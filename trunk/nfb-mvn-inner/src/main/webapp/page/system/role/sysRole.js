var appRole = {
	urlRoleList : top.window.urlBase + "/sys/role/list.do",
	urlRoleSave : top.window.urlBase + "/sys/role/save.do",
	urlRoleDelete : top.window.urlBase + "/sys/role/delete.do",
	urlRoleOperList : top.window.urlBase + "/sys/role/oper/list.do",
	urlRoleOperSave : top.window.urlBase + "/sys/role/oper/save.do",
	urlShopList : top.window.urlBase + "/shop/getShopList.do",
	urlCompanyList : top.window.urlBase + "/shop/getCompanyList.do",
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	requestParamShop : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	requestParamCompany : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	selectedRole : null,
	selectedRoleid : -1,
	roleFormStatus : "new",
	loginUserLvl : 3,
	lvldata : [],
	lvlStatus:true
};

// On ready
$(function() {

	// 加载列表
	loadList();
	// 添加角色
	$("#add").click(function(e) {
		$("#companyMsg").html("");
		$("#shopMsg").html("");
		// 加载商铺列表
		loadShopList(false);
		
		// 加载公司列表
		loadCompanyList(false);
		$(".wrapperAddPanel").window({
			title : "新增"
		}).window("open");
		;
		appRole.roleFormStatus = "new";
		$('#ff').form('clear');
	});
	// 编辑
	$("#edit").on("click", function(e) {
		$("#companyMsg").html("");
		$("#shopMsg").html("");
		if (isSelectedOne(appRole.selectedRoleid)) {
			$("#roleid").val(appRole.selectedRoleid);
			$("#rolename").val(appRole.selectedRole.rolename);
			if (appRole.selectedRole.lvl == 0) {
				$("#lvlTr").show();
				$("#companyTr").hide();
				$("#shopTr").hide();
				$("#lvlEdit").combobox("setValue", appRole.selectedRole.lvl);
			} else if (appRole.selectedRole.lvl == 1) {
				$("#lvlTr").show();
				$("#companyTr").show();
				$("#shopTr").hide();
				$("#lvlEdit").combobox("setValue", appRole.selectedRole.lvl);
				$("#companyPut").val(appRole.selectedRole.orgid);
			} else if (appRole.selectedRole.lvl == 2) {
				$("#lvlTr").show();
				$("#companyTr").hide();
				$("#shopTr").show();
				$("#lvlEdit").combobox("setValue", appRole.selectedRole.lvl);
				$("#companyPut").val(appRole.selectedRole.orgid);
			} else {
				$("#lvlTr").hide();
				$("#companyTr").hide();
				$("#shopTr").hide();
				$("#lvlEdit").combobox("setValue", appRole.selectedRole.lvl);
			}
			// 加载商铺列表
			loadShopList(true, appRole.selectedRole.orgid);
			// 加载公司列表
			loadCompanyList(true, appRole.selectedRole.orgid);

			appRole.roleFormStatus = "edit";
			$(".wrapperAddPanel").window({
				title : "编辑"
			}).window("open");
		}
	});
	// 删除
	$("#delete").click(function(e) {
		if (isSelectedOne(appRole.selectedRoleid)) {
			$.messager.confirm('Confirm', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "id=" + appRole.selectedRoleid;
					$.post(appRole.urlRoleDelete, parms, function(data) {
						if (data.retcode == 0) {
							showMsg("删除成功");
							app.myreload("#tbList");
							appRole.selectedRole={};
							appRole.selectedRoleid=-1;
						} else {
							showMsg(data.retmsg);
						}
					});
				}
			});
		}
	});
	// 打开公司选择窗口
	$("#companyWin").on("click", function() {
		$("#companyListWin").window("open");
	});
	// 关闭公司选择窗口
	$("#companyOk").on("click", function() {
		var datarow = $("#companyTbList").datagrid("getChecked");
		$("#companyPut").val(datarow[0].shopid);
		$("#companyListWin").window("close");
	});
	// 保存角色
	$("#btnSave").on("click", function() {
		submitForm();
	});
});
function loadLvl() {
	$("#lvlEdit").combobox({
		valueField : 'value',
		textField : 'label',
		data :appRole.lvldata,
		onChange : function(newValue, oldValue) {
			if (newValue != oldValue) {
				if (newValue == "0") {
					$("#companyTr").hide();
					$("#shopTr").hide();
				} else if (newValue == "1") {
					$("#companyTr").show();
					$("#shopTr").hide();
				} else if (newValue == "2") {
					$("#companyTr").hide();
					$("#shopTr").show();
				}
			}
		}
	});
}
// 保存角色
function submitForm() {
	if ($("#ff").form("validate")) {
		var lvl = $("#lvlEdit").val();
		if (lvl == 1) {
			if ($("#companyPut").val() == null || $("#companyPut").val() == '') {
				$("#companyMsg").html("所选的公司为空！");
				return;
			}
		} else if (lvl == 2) {
			if ($("#shopPut").val() == null || $("#shopPut").val() == '') {
				$("#shopMsg").html("所选的店铺为空！");
				return;
			}
		}
		$("#companyMsg").html("");
		$("#shopMsg").html("");
		$('#ff').form('submit', {
			url : appRole.urlRoleSave,
			onSubmit : function(param) {
				param.formStatus = appRole.roleFormStatus;
			},
			success : function(data) {
				if (typeof data === "string") {
					data = $.parseJSON(data);
				}
				if (data.retcode == 0) {
					$(".wrapperAddPanel").window("close");
					$('#tbList').datagrid('reload');
					$("#tbList").datagrid('unselectAll');
				} else {
					showMsg(data.retmsg);
					

				}
			}
		});
	}
}
function loadList() {
	// 初始化表格
	$("#tbList").datagrid({
		url : appRole.urlRoleList,
		toolbar : "#tb",
		striped : true,
		nowrap : true,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		pagination : true,
		idField : 'operid',
		pagination : true,
		pageNumber : appRole.requestParam.page_number,
		pageSize : appRole.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			field : 'roleid',
			title : "角色ID",
			width : 100
		}, {
			field : 'rolename',
			title : "角色名称",
			width : 100
		}, {
			field : 'orgname',
			title : "店铺或商家名称",
			width : 100
		}, {
			field : 'createtime',
			title : "创建时间",
			width : 100
		}, {
			field : 'updatetime',
			title : "更新时间",
			width : 100
		}, {
			field : 'creator',
			title : "创建者",
			width : 100
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appRole.selectedRole = rowData;
			appRole.selectedRoleid = rowData.roleid;

		}
	});
	function loader(that, params, success, loadError) {
		appRole.requestParam.keyword = $("#keyword").val();
		$.ajax({
			url : appRole.urlRoleList,
			type : "post",
			data : appRole.requestParam,
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.retcode == 0) {
					var list = data.list;
					appRole.loginUserLvl = data.loginUserLvl;
					that.data().datagrid["cache"] = data;
					success({
						"total" : list.length,
						"rows" : list
					});
					showOrHideColomn();
					return true;
				}
				if (data.retcode == -2000) {
					showMsg(data.retmsg);
					return true;
				}
			},
			error : function(err) {
				loadError.apply(this, arguments);
			}
		});
	}
	;
}
function showOrHideColomn() {
	if (appRole.loginUserLvl > 1) {
		$('#tbList').datagrid('hideColumn', 'orgname');
	} else {
		$('#tbList').datagrid('showColumn', 'orgname');
	}
	$("#lvlEdit").show();
	if(appRole.lvlStatus){
		if (appRole.loginUserLvl == 0) {
			appRole.lvldata = [ {
				label : '系统级别',
				value : '0'
			}, {
				label : '公司级别',
				value : '1'
			}, {
				label : '店铺级别',
				value : '2'
			} ]
		} else if (appRole.loginUserLvl == 1) {
			appRole.lvldata = [ {
				label : '公司级别',
				value : '1'
			}, {
				label : '店铺级别',
				value : '2'
			} ]
		} else if (appRole.loginUserLvl == 2) {
			$("#lvlEdit").hide();
		}
		appRole.lvlStatus=false;
		// 加载数据
		loadLvl();
	}
	
}

function loadShopList() {
	// 初始化表格
	$("#shopTbList")
			.datagrid(
					{
						url : appRole.urlShopList,
						striped : true,
						nowrap : true,
						rownumbers : true,
						animate : true,
						collapsible : true,
						fitColumns : true,
						pagination : true,
						toolbar : "#shopTb",
						idField : 'shopid',
						pagination : true,
						pageNumber : appRole.requestParamShop.page_number,
						pageSize : appRole.requestParamShop.page_size,
						singleSelect : true,
						columns : [ [
								{
									field : 'shopid',
									title : "选择",
									width : 100,
									formatter : function(value, rowData,
											rowIndex) {
										return '<input type="radio" name="shopid" id="shopid"'
												+ rowIndex
												+ '    value="'
												+ rowData.shopid + '" />';
									}
								}, {
									field : 'shopname',
									title : "商铺名称",
									width : 100
								}, {
									field : 'companyname',
									title : "公司名称",
									width : 100
								}, {
									field : 'createtime',
									title : "创建时间",
									width : 100
								} ] ],
						loader : function(params, success, loadError) {
							var that = $(this);
							shoploader(that, params, success, loadError);
						},
						onClickRow : function(rowIndex, rowData) {

						}
					});
	function shoploader(that, params, success, loadError) {
		appRole.requestParamShop.keyword = $("#shopKeyword").val();
		$.ajax({
			url : appRole.urlShopList,
			type : "post",
			data : appRole.requestParamShop,
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
				}
				if (data.retcode == -2000) {
					showMsg(data.retmsg);
					return true;
				}
			},
			error : function(err) {
				loadError.apply(this, arguments);
			}
		});
	}
	;
}

function loadCompanyList(flag, companyid) {
	console.log("companyid----");
	console.log(companyid);
	// 初始化表格
	$("#companyTbList")
			.datagrid(
					{
						url : appRole.urlCompanyList,
						striped : true,
						nowrap : true,
						rownumbers : true,
						animate : true,
						collapsible : true,
						fitColumns : true,
						pagination : true,
						toolbar : "#companyTb",
						idField : 'shopid',
						pagination : true,
						pageNumber : appRole.requestParamCompany.page_number,
						pageSize : appRole.requestParamCompany.page_size,
						singleSelect : true,
						columns : [ [
								{
									field : 'shopid',
									title : "选择",
									width : 100,
									editor : {
										type : 'radio'
									},
									formatter : function(value, rowData,
											rowIndex) {
										return '<input type="radio" name="companyid" id="companyid"'
												+ rowIndex
												+ '    value="'
												+ rowData.shopid + '" />';
									}
								}, {
									field : 'shopname',
									title : "公司名称",
									width : 100
								}, {
									field : 'createtime',
									title : "创建时间",
									width : 100
								} ] ],
						loader : function(params, success, loadError) {
							var that = $(this);
							companyloader(that, params, success, loadError);
						},
						onClickRow : function(rowIndex, rowData) {

						},
						onLoadSuccess : function(data) {
							if (flag) {
								if (data) {
									$.each(data.rows,
											function(index, item) {

												if (item.shopid == companyid) {
													console.log("werwer");
													// input元素的value是easyui
													// datagrid的column列field:'id'定义
													var input = "input[value="
															+ companyid + "]"; // item.id商品编号
													$("#companyListWin").find(
															input).attr(
															"checked",
															"checked");
													$("#companyPut").val(companyid);
												}
											});
								}
							} else {
								$("#companyTbList").datagrid('unselectAll');
							}

						}
					});
	function companyloader(that, params, success, loadError) {
		appRole.requestParamCompany.keyword = $("#companyKeyword").val();
		$.ajax({
			url : appRole.urlCompanyList,
			type : "post",
			data : appRole.requestParamCompany,
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
				}
				if (data.retcode == -2000) {
					showMsg(data.retmsg);
					return true;
				}
			},
			error : function(err) {
				loadError.apply(this, arguments);
			}
		});
	}
	;
}
