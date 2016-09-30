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
	loginUserLvl : 3
};

// On ready
$(function() {

	// 加载列表
	loadList();
	// 加载商铺列表
	loadShopList();
	// 加载公司列表
	loadCompanyList();
	// 添加角色
	$("#add").click(function(e) {
		$(".wrapperAddPanel").window({
			title : "新增"
		}).window("open");
		;
		appRole.roleFormStatus = "new";
		$('#ff').form('clear');
	});
	// 编辑
	$("#edit").on("click", function(e) {
		if (isSelectedOne(appRole.selectedRoleid)) {
			$("#roleid").val(appRole.selectedRoleid);
			$("#roleNameEdit").val(appRole.selectedRole.rolename);
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
				$("#company").combobox("setValue", appRole.selectedRole.orgid);
			} else {
				$("#lvlTr").hide();
				$("#companyTr").hide();
				$("#shopTr").hide();
				$("#lvlEdit").combobox("setValue", appRole.selectedRole.lvl);
				$("#company").combobox("setValue", appRole.selectedRole.orgid);
			}
			appRole.roleFormStatus = "edit";
			$(".wrapperAddPanel").window({
				title : "编辑"
			}).window("open");
			;
		}
	});
	// 删除
	$("#delete").click(function(e) {
		if (isSelectedOne(appRole.selectedRoleid)) {
			deleteRow(appRole.selectedRoleid, appRole.urlRoleDelete);
		}
	});
});
function loadList() {
	// 初始化表格
	$("#tbList").datagrid({
		url : appRole.urlRoleList,
		striped : true,
		nowrap : true,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		pagination : true,
		toolbar : "#tb",
		idField : 'roleid',
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
	var loader = function(that, params, success, loadError) {
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
	};
}
function showOrHideColomn() {
	if (appRole.loginUserLvl > 1) {
		$('#tbList').datagrid('hideColumn', 'orgname');
	} else {
		$('#tbList').datagrid('showColumn', 'orgname');
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
	var shoploader = function(that, params, success, loadError) {
		appRole.requestParamShop.keyword=$("#shopKeyword").val();
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
	};
}

function loadCompanyList() {
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
							
						}
					});
	var companyloader = function(that, params, success, loadError) {
		appRole.requestParamCompany.keyword=$("#companyKeyword").val();
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
	};
}
