var appInfo = {
	listUrl: top.window.urlBase + '/inner/dispatchLog/list.do',//获取配送记录列表接口  DispatchLog
	saveUrl: top.window.urlBase + '/inner/dispatchLog/save.do',//保存新增配送记录接口
	updateUrl: top.window.urlBase + '/inner/dispatchLog/update.do',//编辑配送记录信息接口
	deleteUrl: top.window.urlBase + '/inner/dispatchLog/delete.do',//删除配送记录接口
	selectedId : -1,
	selectedData : {},
	requestParam:{
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus:"new"
 };
 //-----------------权限控制功能 start---------------
	//新增
	function add(){
		$("#editWin").window({
			title : "新增"
		}).window("open");
		$('#ff').form('clear');
		appInfo.formStatus="new";
	}
	
	
	//编辑
	function edit(){
		if (!isSelectedOne(appInfo.selectedId)) {
			return;
		}
		$("#editWin").window({
				title : "编辑"
			}).window("open");
			appInfo.formStatus="edit";
			$('#ff').form('load',appInfo.selectedData);
	}
		//删除
	function del(){
		if (!isSelectedOne(appInfo.selectedId)) {
			return;
		}
		
			$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "logId=" + appInfo.selectedId;
					$.post(appInfo.deleteUrl, parms, function(data) {
						if (data.retcode == '0') {
							app.myreload("#tbList");
							appInfo.selectedData = {};
							appInfo.selectedId=-1;
							showMsg("删除成功");
						} else {
							showMsg(data.retmsg);
						}
					});
				}
			});
		
	}
 //-----------------权限控制功能 end---------------
$(function(){
//加载列表
 	loadList();

//搜索
	$("#doSearch").on("click", function(e) {
		app.myreload("#tbList");
		appInfo.selectedData = {};
		appInfo.selectedId=-1;
	});
	
		//保存菜单
	$("#btnOK").on("click",function(){
		formSubmit();
	});
	$("#btnCancel").on("click",function(){
		$("#editWin").window("close");
	});
});
/**
 * 保存菜单
 */
function formSubmit(){
	if (!$('#ff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var reqUrl=appInfo.formStatus=="new"?appInfo.saveUrl:appInfo.updateUrl;
	var parms = $("#ff").serialize();
	parms += "&formStatus=" + appInfo.formStatus;
	$.post(reqUrl, parms, function(data) {
		if (typeof data === 'string') {
			try {
				data = $.parseJSON(data);
			} catch (e0) {
				showMsg("json格式错误");
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
	});
}

function loadList() {
	$('#tbList').datagrid({
		url : appInfo.listUrl,
//		toolbar : "#tb",
		striped:true,
		nowrap:true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		autoRowHeight:false,
		idField : 'logId',
		height:520,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [                 {title:'记录编号',field:'logId',width:100,align:"center",hidden:true },
                {title:'商品单号',field:'orderGoodId',width:100,align:"center"},
                {title:'订单号',field:'orderId',width:100,align:"center"},
                {title:'条目类别',field:'typeCode',width:100,align:"center"},
                {title:'条目类别',field:'typeCodeName',width:100,align:"center"},
                {title:'操作人',field:'operator',width:100,align:"center"},
                {title:'机构',field:'orgId',width:100,align:"center"},
                {title:'机构',field:'orgName',width:100,align:"center"},
                {title:'商品编号',field:'goodId',width:100,align:"center"},
                {title:'商品编号',field:'goodNo',width:100,align:"center"},
                {title:'商品名称',field:'goodName',width:100,align:"center"},
                {title:'商品码',field:'barNo',width:100,align:"center"},
                {title:'单位',field:'unit',width:100,align:"center"},
                {title:'规格',field:'rank',width:100,align:"center"},
                {title:'型号',field:'model',width:100,align:"center"},
                {title:'类别',field:'typeId',width:100,align:"center"},
                {title:'品类',field:'typeName',width:100,align:"center"},
                {title:'品牌',field:'brandId',width:100,align:"center"},
                {title:'品牌',field:'brandName',width:100,align:"center"},
                {title:'数量',field:'nums',width:100,align:"center"},
                {title:'金额',field:'amt',width:100,align:"center"},
                {title:'创建时间',field:'createtime',width:100,align:"center"} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex,rowData) {
			appInfo.selectedId = rowData.logId;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.logId;
			appInfo.selectedData = rowData;
			edit();
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
		appInfo.requestParam.keyword=$("#keyword").val();
		$.ajax({
			url : opts.url,
			type : "get",
			data : appInfo.requestParam,
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.retcode == '0') {
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
		

