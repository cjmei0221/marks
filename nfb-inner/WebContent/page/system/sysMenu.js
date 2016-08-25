var appInfo = {
	listUrl : top.window.urlBase + "/sysMenu/list.do",
	parentMenuUrl : top.window.urlBase + "/sysMenu/parentMenu.do",
	saveUrl : top.window.urlBase + "/sysMenu/save.do",
	selectedId : -1,
	selectedData : {},
	formStatus:"new"
}
$(function() {
	//加载列表
	loadList();
	//新增
	$("#add").on("click",function(){
		$("#editWin").window({
			title : "新增"
		}).window("open");
		initParentMenu();
	});
	//保存菜单
	$("#btnOK").on("click",function(){
		formSubmit();
	});
})

/**
 * 保存菜单
 */
function formSubmit(){
	$('#ff').form('submit',{
	    url:appInfo.saveUrl,
	    onSubmit: function(param){
	    	param.formStatus=appInfo.formStatus;
	    },
	    success:function(data){
			alert(data)
	    }
	});
}
/**
 * 加载列表
 */
function loadList() {
	$('#tbList').treegrid({
		url : appInfo.listUrl,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		pagination : true,
		idField : 'menuid',
		treeField : 'menuitem',
		frozenColumns : [ [ {
			title : '菜单ID',
			field : 'menuid',
			width : 100,
			hidden : true
		}, {
			title : '菜单名称',
			field : 'menuitem',
			width : 400
		} ] ],
		columns : [ [ {
			title : '排序',
			field : 'sort',
			width : 60
		}, {
			title : '创建时间',
			field : 'createtime',
			width : 80
		}, {
			title : '更新时间',
			field : 'updatetime',
			width : 80
		}, {
			title : '更新者',
			field : 'creator',
			width : 80
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowData) {
			appInfo.selectedId = rowData.menuid;
			appInfo.selectedData = rowData;
		},
		onLoadSuccess : function(data) {
			$("#tbList").treegrid('unselectAll');
			appInfo.selectedData = {};
		}
	});
	// 请求加载数据
	function loader(that, params, success, loadError) {
		var opts = that.treegrid("options");
		$.ajax({
			url : opts.url,
			type : "get",
			success : function(data, status, xhr) {
				checkLogin(data);
				if (data.retcode == 0) {
					var list = data.menuList;
					that.data().treegrid["cache"] = data;
					success({
						"total" : list.length,
						"rows" : list
					});
					return true;
				} else {
					$.messager.alert("系统提示", data.retmsg);
				}
			},
			error : function(err) {
				loadError.apply(this, arguments);
			}
		});
	}
}

//加载父级菜单
function initParentMenu(){
	$.ajax({
		url :appInfo.parentMenuUrl,
		type : "get",
		success : function(data, status, xhr) {	
			checkLogin(data);
			if (typeof data === "string") {
				data = $.parseJSON(data);
			}
			if (data.retcode == 0) {
				console.log(data);
				$("#parentidPut").combobox({    
				    data:data.list,    
				    valueField:'menuid',    
				    textField:'menuitem'   
				}); 
			}
		},
		error : function(err) {
			loadError.apply(this, arguments);
		}
	});
}
