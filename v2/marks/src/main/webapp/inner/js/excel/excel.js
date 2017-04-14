var excel={};
excel.init=function(uploadReqUrl){
	$('#file_upload').uploadify({
		'uploader'       : top.window.urlBase + '/inner/fileUpload/excel.do',//servlet的路径或者.jsp 这是访问servlet 'scripts/uploadif' 
		'formData'     : {
			'timestamp' : new Date().getTime(),
			'token'     : ''
		},
		'swf'      : top.window.urlBase +'/inner/js/uploadify/uploadify.swf',
		'cancelImg'      : top.window.urlBase+ '/inner/js/uploadify/uploadify-cancel.png',
		'auto'           : true, //选定文件后是否自动上传，默认false
		'multi': false,
		'preventCaching' : true,  //清楚缓存
		'buttonText'     :"上传文件",
		'buttonCursor'   : "hand",
		'method'         : 'post',  //如果要传参数，就必须改为GET
		'onFallback' : function() {
               alert('未检测到兼容版本的Flash,请更换浏览器或安装最新版本的Flash播放器');
         },
         'fileSizeLimit'  : '20MB', //设置单个文件大小限制，单位为byte  
		 'removeTimeout' :1,
		 'onSelect' : function(file) {
        	 $("#file_upload").clearQueue();
        	 $("#excelfileName").val("");
        	 $("#uploadInfo").html("");
          },
          'onUploadSuccess' : function(file, data, response) {
        	  var dataJson = JSON.parse(data);
	        	 if(dataJson.retcode == '0'){
	        		 $("#uploadInfo").html("上传成功");
	        		 $("#excelfileName").val(dataJson.fileName);
	        		 $.ajax({
	        				url : uploadReqUrl,
	        				type : "get",
	        				data : {
	        					"excelfileName":dataJson.fileName
	        				},
	        				dataType : "json",
	        				success : function(data, status, xhr) {
	        					if (data.retcode == '0') {
	        						$("#uploadInfo").html("上传成功");
	        						app.myreload("#tbList");
	        						appInfo.selectedData = {};
	        						appInfo.selectedId = -1;
	        						return true;
	        					} else if(data.retcode == '2001'){
	        						$("#uploadInfo").html(data.retmsg);
	        					} else {
	        						$("#uploadInfo").html(data.retmsg);
	        					}
	        				},
	        				error : function(err) {
	        					loadError.apply(this, arguments);
	        				}
	        			});
	        	 }else{
	        		 $("#uploadInfo").html("上传失败");
	        		 $("#excelfileName").val("");
	        	 }
          }
	});
}
			
excel.upload=function(){
	$('#file_upload').uploadify('upload');
}
excel.cancel=function(){
	$('#file_upload').uploadify('cancel');
}
excel.downTemplat=function(fileName){
	$.ajax({
		url : top.window.urlBase + '/inner/fileUpload/excelTemplate.do',
		type : "post",
		data : {
			"fileName":fileName
		},
		success : function(data, status, xhr) {	
		},
		error : function(err) {

		}
	});
}