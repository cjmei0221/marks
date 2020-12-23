var appInfo = {
	listUrl : top.window.urlBase + '/inner/traceLog/list.do',// 获取追踪日志列表接口
																// TraceLog
	saveUrl : top.window.urlBase + '/inner/traceLog/save.do',// 保存新增追踪日志接口
	updateUrl : top.window.urlBase + '/inner/traceLog/update.do',// 编辑追踪日志信息接口
	deleteUrl : top.window.urlBase + '/inner/traceLog/delete.do',// 删除追踪日志接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus : "new"
};
// -----------------权限控制功能 start---------------
appInfo.requestParam.batchId=tool.getUrlParams("id");
// -----------------权限控制功能 end---------------
$(function() {
	// 加载列表
	loadList();

});


function loadList() {
	$('#tbList').datagrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		idField : 'id',
		height : 400,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : 'ID',
			field : 'id',
			width : 100,
			align : "center",
			hidden : true
		}, {
			title : '批次号',
			field : 'batchId',
			width : 250,
			align : "center"
		}, {
			title : '商品编号',
			field : 'goodNo',
			width : 100,
			align : "center"
		}, {
			title : '国际条码',
			field : 'barNo',
			width : 100,
			align : "center"
		}, {
			title : '商品名称',
			field : 'goodName',
			width : 100,
			align : "center"
		}, {
			title : '机构编号',
			field : 'orgid',
			width : 100,
			align : "center"
		}, {
			title : '机构名称',
			field : 'orgname',
			width : 100,
			align : "center"
		}, {
			title : '业务类型',
			field : 'ywName',
			width : 100,
			align : "center"
		}, {
			title : '数量',
			field : 'nums',
			width : 100,
			align : "center"
		}, {
			title : '金额',
			field : 'amount',
			width : 100,
			align : "center"
		}, {
			title : '出库金额',
			field : 'outAmt',
			width : 100,
			align : "center"
		}, {
			title : '剩余数量',
			field : 'balNums',
			width : 100,
			align : "center"
		}, {
			title : '剩余金额',
			field : 'balAmt',
			width : 100,
			align : "center"
		}, {
			title : '创建时间',
			field : 'createtime',
			width : 150,
			align : "center"
		}, {
			title : '品类',
			field : 'typeName',
			width : 100,
			align : "center"
		}, {
			title : '品牌',
			field : 'brandName',
			width : 100,
			align : "center"
		
		}, {
			title : '操作者',
			field : 'operator',
			width : 100,
			align : "center"
		
		}, {
			title : '备注',
			field : 'remarks',
			width : 100,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.id;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.id;
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
		appInfo.requestParam.keyword = appInfo.requestParam.batchId;
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
