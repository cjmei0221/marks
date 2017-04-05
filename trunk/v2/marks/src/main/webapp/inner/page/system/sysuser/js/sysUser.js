var appInfo = {
	listUrl : top.window.urlBase + '/inner/sysUser/list.do',// 获取用户管理列表接口 SysUser
	saveUrl : top.window.urlBase + '/inner/sysUser/save.do',// 保存新增用户管理接口
	updateUrl : top.window.urlBase + '/inner/sysUser/update.do',// 编辑用户管理信息接口
	deleteUrl : top.window.urlBase + '/inner/sysUser/delete.do',// 删除用户管理接口
	resetPwdUrl : top.window.urlBase + '/inner/sysUser/resetPwd.do',// 删除用户管理接口
	roleUrl : top.window.urlBase + '/inner/sysRole/findSysRoleById.do',// 删除用户管理接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : "",
		ssorgid : "",
		s_role : null
	},
	formStatus : "new",
	checkRole : []
};

$(function() {
	// 加载列表
	loadList();

	// 搜索
	$("#doSearch").on("click", function(e) {
		app.myreload("#tbList");
		appInfo.selectedData = {};
		appInfo.selectedId = -1;
	});

	// 新增
	$("#add").on("click", function() {
		$("#editWin").window({
			title : "新增"
		}).window("open");
		$('#ff').form('clear');
		appInfo.formStatus = "new";
		appInfo.checkRole = [];
		$("#roleid").combobox("reload");
		$("#companyId").val('');
		$("#inputRoleDiv").html('');
		$("#bind_mobile").numberbox({
			disabled : false
		});
	});

	// 编辑
	$("#edit").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$("#editWin").window({
				title : "编辑"
			}).window("open");
			appInfo.formStatus = "edit";
			$("#roleid").combobox("reload");
			$('#ff').form('load', appInfo.selectedData);
			appInfo.checkRole = [];
			$("#inputRoleDiv").html('');
			initUser(appInfo.selectedData);
			notEdit();
		}
	});

	// 删除
	$("#delete").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "userid=" + appInfo.selectedId;
					$.post(appInfo.deleteUrl, parms, function(data) {
						if (data.retcode == "0") {
							app.myreload("#tbList");
							appInfo.selectedData = {};
							appInfo.selectedId = -1;
							showMsg("删除成功");
						} else {
							showMsg(data.retmsg);
						}
					});
				}
			});
		}
	});

	// 重置密码
	$("#resetPwdBtn").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$.messager.confirm('确认', '确认重置密码吗?', function(r) {
				if (r) {
					var parms = "userid=" + appInfo.selectedId;
					$.post(appInfo.resetPwdUrl, parms, function(data) {
						if (data.retcode == "0") {
							showMsg("重置成功");
						} else {
							showMsg(data.retmsg);
						}
					});
				}
			});
		}
	});

	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	$("#btnCancel").on("click", function() {
		$("#editWin").window("close");
	});

	$("#roleid").combobox({
		onChange : function(newValue, oldValue) {
			if (newValue != oldValue) {
				$.ajax({
					url : appInfo.roleUrl,
					type : "get",
					data : {
						"roleid" : newValue
					},
					dataType : "json",
					success : function(data, status, xhr) {
						if (data.retcode == "0") {
							$("#companyId").val(data.sysRole.companyId);
							appInfo.checkRole = [];
							$("#inputRoleDiv").html('');
							// 加载角色信息
							loadRoleList(data.sysRole.companyId);
						}
					}
				});
			}
		}
	});

	$("#chooseRole").on("click", function() {
		var roleId = $("#roleid").combobox("getValue")
		if (roleId == '') {
			showMsg("请先选择用户类型");
			return;
		}
		$("#roleWin").window({
			title : "组织"
		}).window("open");
	});
	$("#searchRoleBtn").on("click", function() {
		app.myreload("#roleList");
	});
	$("#roleBtn").on("click", function() {
		if (appInfo.checkRole.length == 0) {
			showMsg("权限角色为空");
			return;
		}
		$("#roleWin").window("close");
	});
});
function checkPhone(val) {
	if (!(/^1[34578]\d{9}$/.test(val))) {
		return false;
	}
	return true;
}
/**
 * 保存菜单
 */
function formSubmit() {
	if (!$('#ff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	if (appInfo.checkRole.length == 0) {
		showMsg("所属组织为空");
		return;
	}
	console.log($("#bind_mobile").val());
	var phoneVar = checkPhone($("#bind_mobile").val());
	console.log(phoneVar);
	if (!phoneVar) {
		showMsg("手机号码格式有误，请重填");
		return;
	}

	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	$("#bind_mobile").numberbox({
		disabled : false
	});
	$('#ff').form('submit', {
		url : reqUrl,
		onSubmit : function(param) {
			param.formStatus = appInfo.formStatus;
			param.orgIdsPut = appInfo.checkRole.join(",");
			param.companyId = $("#companyId").val();
		},
		success : function(data) {
			notEdit();
			if (typeof data == 'string') {
				try {
					data = $.parseJSON(data);
				} catch (e0) {
					return;
				}
			}
			if (data.retcode == "0") {
				$("#editWin").window("close");
				app.myreload("#tbList");
				appInfo.selectedData = {};
				appInfo.selectedId = -1;
				showMsg("保存成功");
			} else {
				showMsg(data.retmsg);
			}
		}
	});
}
function notEdit() {
	if (appInfo.formStatus != "new") {
		$("#bind_mobile").numberbox({
			disabled : true
		});
	}
}
function loadList() {
	$('#tbList').datagrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		striped : true,
		nowrap : true,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		pagination : true,
		idField : 'userid',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '用户ID',
			field : 'userid',
			width : 100,
			align : "center"
		}, {
			title : '绑定手机',
			field : 'bind_mobile',
			width : 100,
			align : "center"
		}, {
			title : '用户名称',
			field : 'username',
			width : 100,
			align : "center"
		}, {
			title : '绑定标识',
			field : 'bindFlag',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "绑定";
				} else {
					return "未绑定";
				}
			}
		}, {
			title : '用户类型',
			field : 'rolename',
			width : 100,
			align : "center"
		}, {
			title : '所属组织',
			field : 'orgidNamesStr',
			width : 100,
			align : "center"
		}, {
			title : '激活标识',
			field : 'activeFlag',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "启用";
				} else {
					return "禁用";
				}
			}

		}, {
			title : '创建时间',
			field : 'createtime',
			width : 100,
			align : "center"
		}, {
			title : '更新时间',
			field : 'updatetime',
			width : 100,
			align : "center"

		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.userid;
			appInfo.selectedData = rowData;
		},
		onLoadSuccess : function(data) {
			$("#tbList").datagrid('unselectAll');
			appInfo.selectedData = {};
		}
	});
	// 请求加载数据
	function loader(that, params, success, loadError) {
		var opts = that.datagrid("options");
		appInfo.requestParam.page_number = params.page;
		appInfo.requestParam.page_size = params.rows;
		appInfo.requestParam.keyword = $("#keyword").val();
		appInfo.requestParam.ssorgid = $("#ssorgid").combotree("getValue");
		appInfo.requestParam.s_role = $("#s_role").combotree("getValue");
		$.ajax({
			url : opts.url,
			type : "get",
			data : appInfo.requestParam,
			dataType : "json",
			success : function(data, status, xhr) {
				checkLogin(data);
				if (data.retcode == "0") {
					var list = data.list;
					that.data().datagrid["cache"] = data;
					success({
						"total" : data.total_count,
						"rows" : list
					});
					return true;
				} else {
					showMsg(data.retmsg);
					success({
						"total" : 0,
						"rows" : []
					});
				}
			},
			error : function(err) {
				loadError.apply(this, arguments);
			}
		});
	}
}

function loadRoleList(id) {
	var roleUrl = top.window.urlBase + '/inner/orgInfo/list.do?companyId=' + id;
	$('#roleList').treegrid(
			{
				url : roleUrl,
				striped : true,
				nowrap : true,
				rownumbers : true,
				animate : true,
				collapsible : true,
				fitColumns : true,
				idField : 'orgid',
				treeField : 'orgname',
				singleSelect : true,
				queryParams : {
					userflag : 1
				},
				columns : [ [ {
					title : '组织名称',
					field : 'orgname',
					width : 150,
					align : "left"
				}, {
					title : '组织ID',
					field : 'orgid',
					width : 100,
					align : "center"
				}, {
					title : '创建时间',
					field : 'createtime',
					width : 100,
					align : "center"
				}, {
					title : '更新时间',
					field : 'updatetime',
					width : 100,
					align : "center"
				}, {
					title : '创建者',
					field : 'creator',
					width : 100,
					align : "center"
				} ] ],
				onBeforeExpand : function(row) {
					$("#roleList").treegrid("options").url = roleUrl
							+ "&parentId=" + row.orgid + "&_timer="
							+ new Date().getTime();
				},
				onClickRow : function(rowData) {
					var flag = true;
				/*	var conp = $("#companyId").val();
					if (conp == null || conp == '') {
						$("#companyId").val(rowData.companyId);
					} else {
						if (conp != rowData.companyId) {
							flag = false;
							showMsg("所属公司不一致");
						}
					}
*/
					if (flag) {
						if(appInfo.checkRole.length>0){
							showMsg("只能选择一个组织");
							return;
						}
						if (addRole(rowData.orgid)) {
							initRolePut(rowData.orgid, rowData.orgname);
						}
						return;

					}
				},
				onLoadSuccess : function(row, data) {

				}
			});
}

// 删除功能
function delRoleTr(id) {
	delRole(id);
	$("#" + id).remove();

}
Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	}
};
Array.prototype.indexOf = function(obj) {
	for (var i = 0; i < this.length; i++) {
		if (this[i] == obj) {
			return i;
		}
	}
	return -1;
}

function addRole(id) {

	var idx = appInfo.checkRole.indexOf(id);//
	if (idx < 0) {
		appInfo.checkRole.push(id);
		return true;
	}
	return false;
}
function delRole(id) {

	var idx = appInfo.checkRole.indexOf(id);//
	if (idx > -1) {
		appInfo.checkRole.remove(id);
	}
}
function initUser(user) {
	$("#companyId").val(user.companyId);
	appInfo.checkRole = user.orgidsStr.split(",");
	var rolenames = user.orgidNamesStr.split(",");
	for (var i = 0; i < appInfo.checkRole.length; i++) {
		if (appInfo.checkRole[i] != null && appInfo.checkRole[i] != '') {
			initRolePut(appInfo.checkRole[i], rolenames[i]);
		}
	}
}
function initRolePut(roleid, rolename) {
	$("#inputRoleDiv")
			.append(
					"<p id='"
							+ roleid
							+ "'>组织：<span>"
							+ rolename
							+ "</span>&nbsp;&nbsp;<a href='#' onclick=\"javascript:delRoleTr(\'"
							+ roleid + "\')\">删除</a></p>");
}