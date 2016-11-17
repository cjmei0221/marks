var appInfo = {
	listUrl : top.window.urlBase + '/sysUser/list.do',// 获取用户管理列表接口 SysUser
	saveUrl : top.window.urlBase + '/sysUser/save.do',// 保存新增用户管理接口
	updateUrl : top.window.urlBase + '/sysUser/update.do',// 编辑用户管理信息接口
	deleteUrl : top.window.urlBase + '/sysUser/delete.do',// 删除用户管理接口
	roleidsUrl : top.window.urlBase + '/sysUser/findSysUserById.do',// 删除用户管理接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : "",
		ssorgid:""
	},
	formStatus : "new",
	checkRole : []
};

$(function() {
	// 加载列表
	loadList();
	// 加载角色信息
	loadRoleList();
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
		$("#inputRoleDiv").html('');
	});

	// 编辑
	$("#edit").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$("#editWin").window({
				title : "编辑"
			}).window("open");
			appInfo.formStatus = "edit";
			$('#ff').form('load', appInfo.selectedData);
			appInfo.checkRole = [];
			$("#inputRoleDiv").html('');
			var parms = "userid=" + appInfo.selectedId;
			$.post(appInfo.roleidsUrl, parms, function(data) {
				if (data.retcode == 0) {
					initUser(data.sysUser);
				} else {
					showMsg(data.retmsg);
				}
			});
		}
	});

	// 删除
	$("#delete").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$.messager.confirm('Confirm', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "userid=" + appInfo.selectedId;
					$.post(appInfo.deleteUrl, parms, function(data) {
						if (data.retcode == 0) {
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

	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	$("#btnCancel").on("click", function() {
		$("#editWin").window("close");
	});

	$("#chooseRole").on("click", function() {
		$("#roleWin").window({
			title : "权限角色"
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
		alert(appInfo.checkRole);
		$("#roleWin").window("close");
	});
});
/**
 * 保存菜单
 */
function formSubmit() {
	if (appInfo.checkRole.length == 0) {
		showMsg("权限角色为空");
		return;
	}
	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	$('#ff').form('submit', {
		url : reqUrl,
		onSubmit : function(param) {
			param.formStatus = appInfo.formStatus;
			param.roleIdsPut = appInfo.checkRole.join(",");
			param.companyId=$("#companyId").val();
		},
		success : function(data) {
			if (typeof data === 'string') {
				try {
					data = $.parseJSON(data);
				} catch (e0) {
					showMsg("json 格式 错误");
					return;
				}
			}
			if (data.retcode == 0) {
				$("#editWin").window("close");
				app.myreload("#tbList");
				appInfo.selectedData = {};
				appInfo.selectedId = -1;
				showMsg("保存成功");
			} else {
				showMsg(data.retmsg);
			}
			appInfo.checkRole = [];
			$("#inputRoleDiv").html('');
		}
	});
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
			align : "center",
			hidden : true
		}, {
			title : '用户名称',
			field : 'username',
			width : 100,
			align : "center"
		}, {
			title : '角色名称',
			field : 'rolenamesStr',
			width : 100,
			align : "center"
		}, {
			title : '激活标识',
			field : 'activeFlag',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "激活";
				} else {
					return "启用";
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
		$.ajax({
			url : opts.url,
			type : "get",
			data : appInfo.requestParam,
			dataType : "json",
			success : function(data, status, xhr) {
				checkLogin(data);
				if (data.retcode == 0) {
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

function loadRoleList() {
	$('#roleList')
			.datagrid(
					{
						url : top.window.urlBase + '/sysRole/list.do',
						toolbar : "#roleTb",
						striped : true,
						nowrap : true,
						rownumbers : true,
						animate : true,
						collapsible : true,
						fitColumns : true,
						pagination : true,
						idField : 'roleid',
						pagination : true,
						pageNumber : 1,
						pageSize : 10,
						singleSelect : true,
						columns : [ [ {
							title : '角色ID',
							field : 'roleid',
							width : 100,
							align : "center"
						}, {
							title : '角色名称',
							field : 'rolename',
							width : 100,
							align : "center"
						}, {
							title : '组织名称',
							field : 'orgname',
							width : 100,
							align : "center"
						}, {
							title : '组织全称',
							field : 'orgFullName',
							width : 200,
							align : "left"
						} ] ],
						loader : function(params, success, loadError) {
							var that = $(this);
							roleloader(that, params, success, loadError);
						},
						onClickRow : function(rowIndex, rowData) {
							var flag = true;
							var conp = $("#companyId").val();
							if (conp == null || conp == '') {
								$("#companyId").val(rowData.companyId);
							} else {
								if (conp != rowData.companyId) {
									flag = false;
									showMsg("所属公司不一致");
								}
							}
							if(appInfo.checkRole.length<1){
								if (flag) {
									if(addRole(rowData.roleid)){
										initRolePut(rowData.roleid,rowData.rolename);
									}
									
								}
							}else{
								showMsg("只能添加一个角色");
							}
						},
						onLoadSuccess : function(data) {

						}
					});
	// 请求加载数据
	function roleloader(that, params, success, loadError) {
		var opts = that.datagrid("options");
		var reqParam = {
			page_number : params.page,
			page_size : params.rows,
			sorgid : $("#sorgid").combotree("getValue")
		}
		$.ajax({
			url : opts.url,
			type : "get",
			data : reqParam,
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.retcode == 0) {
					var list = data.list;
					that.data().datagrid["cache"] = data;
					success({
						"total" : list.length,
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
function initUser(user){
	$("#companyId").val(user.companyId);
	appInfo.checkRole=user.roleidsStr.split(",");
	var rolenames=user.rolenamesStr.split(",");
	for(var i=0;i<appInfo.checkRole.length;i++){
		initRolePut(appInfo.checkRole[i],rolenames[i]);
	}
}
function initRolePut(roleid,rolename){
	$("#inputRoleDiv")
	.append(
			"<p id='"
					+ roleid
					+ "'>角色：<span>"
					+ rolename
					+ "</span>&nbsp;&nbsp;<a href='#' onclick=\"javascript:delRoleTr(\'"
					+ roleid
					+ "\')\">删除</a></p>");
}