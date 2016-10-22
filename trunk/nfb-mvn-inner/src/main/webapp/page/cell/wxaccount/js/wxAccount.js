var appInfo = {
	listUrl: top.window.urlBase + '/wxAccount/list.do',//获取公众号管理列表接口  WxAccount
	saveUrl: top.window.urlBase + '/wxAccount/save.do',//保存新增公众号管理接口
	updateUrl: top.window.urlBase + '/wxAccount/update.do',//编辑公众号管理信息接口
	deleteUrl: top.window.urlBase + '/wxAccount/delete.do',//删除公众号管理接口
	selectedId : -1,
	selectedData : {},
	requestParam:{
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus:"new"
 };

$(function(){
//加载列表
 	loadList();

//搜索
	$("#doSearch").on("click", function(e) {
		app.myreload("#tbList");
		appInfo.selectedData = {};
		appInfo.selectedId=-1;
	});
	
	//新增
	$("#add").on("click",function(){
		$("#editWin").window({
			title : "新增"
		}).window("open");
		$('#ff').form('clear');
		appInfo.formStatus="new";
	});
	
	//编辑
	$("#edit").on("click",function(){
		if(isSelectedOne(appInfo.selectedId)){
			$("#editWin").window({
				title : "编辑"
			}).window("open");
			appInfo.formStatus="edit";
			$('#ff').form('load',appInfo.selectedData);
		}
	});
	
	//删除
	$("#delete").on("click",function(){
		if(isSelectedOne(appInfo.selectedId)){
			$.messager.confirm('Confirm', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "accountId=" + appInfo.selectedId;
					$.post(appInfo.deleteUrl, parms, function(data) {
						if (data.retcode == 0) {
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
	var reqUrl=appInfo.formStatus=="new"?appInfo.saveUrl:appInfo.updateUrl;
	$('#ff').form('submit',{
	    url:reqUrl,
	    onSubmit: function(param){
	    	param.formStatus=appInfo.formStatus;
	    },
	    success:function(data){
	   		if(typeof data === 'string'){
				try{
					data = $.parseJSON(data);
				}catch(e0){
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
	    }
	});
}

function loadList() {
	$('#tbList').datagrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		striped:true,
		nowrap:true,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		pagination : true,
		idField : 'accountId',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [                 {title:'公众号ID',field:'accountId',width:100,align:"center",hidden:true },
                {title:'回调路径',field:'url',width:100,align:"center"},
                {title:'令牌',field:'token',width:100,align:"center"},
                {title:'加密秘钥',field:'aeskey',width:100,align:"center"},
                {title:'创建者',field:'creator',width:100,align:"center"},
                {title:'创建时间',field:'createtime',width:100,align:"center"},
                {title:'上下文',field:'server_context',width:100,align:"center"},
                {title:'微信号',field:'wx_acctno',width:100,align:"center"},
                {title:'是否提供服务',field:'is_service',width:100,align:"center"},
                {title:'公众号类型',field:'accttype',width:100,align:"center"},
                {title:'更新时间',field:'updatetime',width:100,align:"center"},
                {title:'公众号名称',field:'accountname',width:100,align:"center"},
                {title:'机构ID',field:'orgid',width:100,align:"center"},
                {title:'APPID',field:'appid',width:100,align:"center"},
                {title:'APPSECRET',field:'appsecret',width:100,align:"center"},
                {title:'授权域名',field:'authdoman',width:100,align:"center"} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex,rowData) {
			appInfo.selectedId = rowData.accountId;
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
		appInfo.requestParam.keyword=$("#keyword").val();
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
		

