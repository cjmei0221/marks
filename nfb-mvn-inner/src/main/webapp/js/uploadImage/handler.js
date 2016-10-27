var initparams;
var settings={
		flash_url : top.window.urlBase+"/js/swfupload.swf",
		file_post_name:"filedata",
		upload_url: "",//必须填写
		post_params: {"uploadType":""},
		use_query_string :true,
		// File Upload Settings
		file_size_limit : "1 MB",  	
		file_types : "*.jpg;*.jpeg;*.gif;*.png",    //格式
		file_types_description : "web iamge file",
		file_upload_limit : 20,//图片数量限制
		file_queue_limit : 0,
		file_queue_error_handler : fileQueueError,
		file_dialog_complete_handler : fileDialogComplete,//选择好文件后提交
		file_queued_handler : fileQueued,
		swfupload_load_failed_handler : swfUploadLoadFailed, //swf 加载失败
		swfupload_loaded_handler : swfUploadLoaded,  //swf 加载完成
		upload_start_handler: uploadStart,
		upload_progress_handler : uploadProgress,
		upload_error_handler : uploadError,
		upload_success_handler : uploadSuccess,
		upload_complete_handler : uploadComplete,
		// 按钮设置
		button_image_url : "",//必传
		button_placeholder_id : "",//必传
		button_width: 100,
		button_height: 23,
		button_text : '<span style="display:block;"></span>',
		custom_settings : {
			photoContainer_Id   : "",  	//图片的容器id 必传
			btnUpload_ID		: "",          //上传按钮 若不为自动提交为必传
			upload_type			: "",
			errorMsg_Id			: "",  			//错误信息id 如需要提示则必传
			errorMsg_fadeOutTime: 2000,  				//错误信息谈出的时间
			clearAll_Id		:"",//全部清空按钮id
			width:55,//图片显示宽度
			height:80, //图片显示高度
			edit:false,
			edit_pic:null,
			is_alert:false
		},
		// Debug Settings
		debug: false,   //是否显示调试窗口
		auto_upload:true, //自动提交
		customObj:null,
};

/**
 * 初始化控件
 * @param options 需要修改的参数
 */
function initSwfupload(options){
	initparams = jQuery.extend({},settings,options);
	var obj = new SWFUpload(initparams);
	
	if(obj.customSettings.edit){
		for(var i=0;i<obj.customSettings.edit_pic.length;i++){
			var path = obj.customSettings.edit_pic[i];
			var type = "";
			var id = obj.customSettings.photoContainer_Id+"delete"+i;
			if(obj.customSettings.upload_type!="" && typeof(obj.customSettings.upload_type)!="undefined"){
				type += initparams.custom_settings.upload_type+",";
			}
			var photoDiv='<div class="ke-inline-block ke-item" id="'+id+'">'
				+'<input type="hidden" name="upload" value="'+type+path+'"/>'
				+'<div class="ke-inline-block ke-photo" style="height:'+obj.customSettings.height+'; width:'+obj.customSettings.width+';">'
				+'	<img src="'+path+'" class="ke-img" data-status="-1" width="'+obj.customSettings.width+'" height="'+obj.customSettings.height+'" />'
				+'		<span class="ke-delete" options="'+id+'" style="background: url('+top.window.urlBase+'/images/error.png) no-repeat;"></span>'
				+'    	</div>'
				+'</div>';
			$("#"+obj.customSettings.photoContainer_Id).append(photoDiv);
			$("#"+obj.customSettings.photoContainer_Id).find(".ke-photo").bind("mouseover",photoMouseOver).bind("mouseout",photoMouseOut);
		}
		$("#"+obj.customSettings.photoContainer_Id).find(".ke-delete").bind("click",function(){deleteFile(obj,$(this).attr("options"))});
	}
	return obj;
}
function restImg(swf,options){ 
	var obj = options;
	$("#"+obj.custom_settings.photoContainer_Id).find(".ke-item").remove();
	for(var i=0;i<obj.custom_settings.edit_pic.length;i++){
		var path = obj.custom_settings.edit_pic[i];
		//var lastindex = path.lastIndexOf("/");
		//var imgname = path.substring(lastindex,path.length);
		var imgname = path;
		var id = obj.custom_settings.photoContainer_Id+"delete"+i;
		var type = "";
		if(obj.custom_settings.upload_type!="" && typeof(obj.custom_settings.upload_type)!="undefined"){
			type += obj.custom_settings.upload_type+",";
		}
		var photoDiv='<div class="ke-inline-block ke-item" id="'+id+'">'
		+'<input type="hidden" name="upload" value="'+type+imgname+'"/>'
		+'<div class="ke-inline-block ke-photo" style="height:'+obj.custom_settings.height+'; width:'+obj.custom_settings.width+';">'
		+'	<img src="'+path+'" class="ke-img" data-status="-1" width="'+obj.custom_settings.width+'" height="'+obj.custom_settings.height+'" />'
		+'		<span class="ke-delete" options="'+id+'" style="background: url('+top.window.urlBase+'/images/error.png) no-repeat;"></span>'
		+'    	</div>'
		+'</div>';
		$("#"+obj.custom_settings.photoContainer_Id).append(photoDiv);
		$("#"+obj.custom_settings.photoContainer_Id).find(".ke-photo").bind("mouseover",photoMouseOver).bind("mouseout",photoMouseOut);
	}
	$("#"+obj.custom_settings.photoContainer_Id).find(".ke-delete").bind("click",function(){deleteFile(swf,$(this).attr("options"))});
}
/**
 * 当文件选择对话框关闭消失时，如果选择的文件成功加入上传队列，
 * 那么针对每个成功加入的文件都会触发一次该事件（N个文件成功加入队列，就触发N次此事件）。
 * @param {} file
 * id : string,			    // SWFUpload控制的文件的id,通过指定该id可启动此文件的上传、退出上传等
 * index : number,			// 文件在选定文件队列（包括出错、退出、排队的文件）中的索引，getFile可使用此索引
 * name : string,			// 文件名，不包括文件的路径。
 * size : number,			// 文件字节数
 * type : string,			// 客户端操作系统设置的文件类型
 * creationdate : Date,		// 文件的创建时间
 * modificationdate : Date,	// 文件的最后修改时间
 * filestatus : number		// 文件的当前状态，对应的状态代码可查看SWFUpload.FILE_STATUS 
 */

//全部清空
function clearUpload(obj){
	$("div[id='"+obj.customSettings.photoContainer_Id+"']").find(".ke-item").each(function(i,objs){
		deleteFile(obj,$(objs).attr('id'));
	});
}

// 添加错误信息
function addErrorMsg(obj,message,isFadeOut){
	if(obj.customSettings.is_alert){
		if( !(message==""||message==null||typeof(message)=="undefined" ))
			alert(message);
	}else{
		$("#"+obj.customSettings.errorMsg_Id).html(message);
		if(isFadeOut){
			setTimeout(function () {
				$("#"+obj.customSettings.errorMsg_Id).children().fadeOut(1000);
			},parseInt(obj.customSettings.errorMsg_fadeOutTime));
		}
	}
}

//鼠标 移入 移出的 背景效果
function photoMouseOver(){
	$(this).addClass("ke-on");
}
function photoMouseOut(obj){
	$(this).removeClass("ke-on");
}

//swf 准备加载  为使用
function swfUploadPreLoad() {
	var self = this;
	var loading = function () {
		var longLoad = function () {
			document.getElementById("divLoadingContent").style.display = "none";
			document.getElementById("divLongLoading").style.display = "";
		};
		this.customSettings.loadingTimeout = setTimeout(function () {
				longLoad.call(self)
			},
			15 * 1000
		);
	};
	
	this.customSettings.loadingTimeout = setTimeout(function () {
			loading.call(self);
		},
		1*1000
	);
}

//swf 加载失败
function swfUploadLoadFailed() {
	
	//clearTimeout(this.customSettings.loadingTimeout);
	var message='<div id="divAlternateContent" style="background-color: #FFFF66; text-align:center;">'
			+'<a href="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" target="_blank"><font color="red">请安装或者升级您的Flash插件!</font></a></div>';
	addErrorMsg(this,message,false);
}

//swf 加载 完成
function swfUploadLoaded() {
	//编辑图片
	var stats = this.getStats();
	if(this.customSettings.edit_pic!=null){
		stats.successful_uploads += this.customSettings.edit_pic.length;
	}
	this.setStats(stats);
	if (this.customSettings.clearAll_Id!="") {
		var obj = this;
		$("#"+this.customSettings.clearAll_Id).bind("click",function(){clearUpload(obj)});
	}
	//var self = this;
	//clearTimeout(this.customSettings.loadingTimeout);
	addErrorMsg(this,"",false);
	if(this.customSettings.btnUpload_ID!=""){
		$("#"+this.customSettings.btnUpload_ID).click(function (){this.startUpload()});
	}
}


 //每次被加入 到列队中
function fileQueued(file){
	addReadyFileInfo(this,file.id,file.name,file.filestatus,"等待上传");
}

//文件对话框选择完成
function fileDialogComplete(numFilesSelected, numFilesQueued) {
	try {
		if(this.settings.auto_upload){
			//是否要上传
			this.startUpload();
		}
	} catch (ex) {
		this.debug(ex);
	}
	
}
//都加入列队中 的错误信息
function fileQueueError(file, errorCode, message) {
	try {
		switch (errorCode) {
		case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:
			message = "数量超过"+this.getSetting('file_upload_limit')+"张啦!";
			break;
		case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
			message =  "文件超过"+this.getSetting('file_size_limit')+"啦!";
			break;
		case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
			message = "文件不能为空哦!";
		case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
			message = "文件格式只能为"+this.getSetting('fileTypes')+"!";
			break;
		default:
			message="选择文件发生错误!"+"";
			break;
		}
		if(this.customSettings.is_alert==false){
			message = "<font color='red'>"+message+"</font>";
		}
		addErrorMsg(this,message,true);
		//addReadyFileInfo(this,file.id,file.name,file.filestatus,"上传错误")+"</font>";
	} catch (ex) {
		this.debug(ex);
	}
}


// 开始上传 
function uploadStart(file){
	$("#"+file.id).find(".ke-progressbar").css("display","block");
	$("#"+file.id).find(".ke-message").css("display","none");		
}
// 上传的进度
function uploadProgress(file, bytesLoaded) {
	try {
		var percent = Math.ceil((bytesLoaded / file.size) * 100);
		
		if(percent>100){
			percent=100;
		}
		var progress = new FileProgress(file);
		progress.setProgress(percent);
		if (percent === 100) {
			//progress.setStatus("建缩略图...");//正在创建缩略图...
			//progress.toggleCancel(false, this);
		}else {
			progress.setStatus("正在上传...");
			progress.toggleCancel(true, this);
		}
	}catch (ex) {
		this.debug(ex);
	}
}

// 上传到服务器后 的放回信息
function uploadSuccess(file, serverData) {
//	try {
		var progress = new FileProgress(file);
		var data = eval("(" + serverData + ")");
		$("#"+file.id).find(".ke-img").attr("data-status",data.status);
		if (data.status == 0 || data.status == "0") {
			$("#"+this.customSettings.errorMsg_Id).html("");
			var type = "";
			if(this.customSettings.upload_type!="" && typeof(this.customSettings.upload_type)!="undefined"){
				type = this.customSettings.upload_type+",";
			}
			$("#"+file.id).find(".ke-img").attr("src",data.message);
			$("#"+file.id).find("input").val(type+data.message);
			progress.setStatus("上传成功");
			progress.toggleCancel();
			return;
		}else if(data.status == 1 || data.status == "1"){
			progress.setStatus("上传失败");
		}else if(data.status == 2 || data.status == "2"){
			progress.setStatus("格式不对");
		}else if(data.status == 3 || data.status == "3"){
			progress.setStatus("文件超大");
		}else if(data.status == 4 || data.status == "4"){
			progress.setStatus("文件为空");
		}else if(data.status == 5 || data.status == "6"){
			progress.setStatus("路径不对");
		}else{
			progress.setStatus("上传失败");
		}
		progress.toggleCancel(false);
	
//	} catch (ex) {
//		this.debug(ex);
//	}
}

// 选择文件后 添加到 操作层中
function addReadyFileInfo(obj,fileid,fileName,filestatus,message){
	var photoDiv='<div class="ke-inline-block ke-item" id="'+fileid+'">'
			+'<input type="hidden" name="upload"/>'
            +'<div class="ke-inline-block ke-photo" style="height:'+obj.customSettings.height+'; width:'+obj.customSettings.width+';">'
			+'	<img src="'+top.window.urlBase+'/images/image.png" class="ke-img" data-status="-1" width="'+obj.customSettings.width+'" height="'+obj.customSettings.height+'" />'
			+'		<span class="ke-delete" style="background: url('+top.window.urlBase+'/images/error.png) no-repeat;"></span>'
           	+'			<div class="ke-status">'
            +'				<div class="ke-progressbar" style="display: none;">'
			+'          		 <div class="ke-progressbar-bar">'
            +'               	 	<div class="ke-progressbar-bar-inner"></div>'
            +'           		 </div>'
            +'            		<div class="ke-progressbar-percent">0%</div>'
            +'        		 </div>'
            +'				<div class="ke-message">'+message+'</div>'
            +'   	 	</div>'
            +'    	</div>'
            +'  <div class="ke-name" alt="'+fileName+'">'+fileName+'</div>'
        	+'</div>';
	$("#"+obj.customSettings.photoContainer_Id).append(photoDiv);
	$("#"+fileid).find(".ke-photo").bind("mouseover",photoMouseOver).bind("mouseout",photoMouseOut);
	$("#"+fileid).find(".ke-delete").bind("click",function(){deleteFile(obj,fileid)});
}


// 删除 单个文件 
function deleteFile(obj,fileId){
	var imageSrc = $("#"+fileId).find("img").attr("src");
	$("#"+fileId).remove();
	try{
		obj.cancelUpload(fileId,false);
		//队列中数量减少 要不然会影响数量
		var stats = obj.getStats();
		stats.successful_uploads--;
		obj.setStats(stats);
        afterDeleteFile(imageSrc);
	}catch(ex){
		
	}
}

// 单个 文件上传完  
function uploadComplete(file) { 
	try {
		/*  如果队列中的下一个文件，会继续上传 */
		if (this.getStats().files_queued > 0) {
			this.startUpload();
		}
	} catch (ex) {
		this.debug(ex);
	}
}
//上传的错误
function uploadError(file, errorCode, message) {
	var message =  "<font color='red'>文件上传出错!</font>";
	var progress = new FileProgress(file);
	try {
		switch (errorCode) {
		case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
				progress.setStatus("取消上传");
				progress.toggleCancel(false);
				break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
				progress.setStatus("停止上传");
				progress.toggleCancel(true);
		case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
				progress.setStatus("文件超大");
				progress.toggleCancel(false);
				break;
		default:
			addErrorMsg(this,message,true);
			break;
		}
		//addFileInfo(file.id,imageName);
	} catch (ex3) {
		this.debug(ex3);
	}

}

function fadeIn(element, opacity) {
	var reduceOpacityBy = 5;
	var rate = 30;	// 15 fps


	if (opacity < 100) {
		opacity += reduceOpacityBy;
		if (opacity > 100) {
			opacity = 100;
		}

		if (element.filters) {
			try {
				element.filters.item("DXImageTransform.Microsoft.Alpha").opacity = opacity;
			} catch (e) {
				// If it is not set initially, the browser will throw an error.  This will set it if it is not set yet.
				element.style.filter = 'progid:DXImageTransform.Microsoft.Alpha(opacity=' + opacity + ')';
			}
		} else {
			element.style.opacity = opacity / 100;
		}
	}

	if (opacity < 100) {
		setTimeout(function () {
			fadeIn(element, opacity);
		}, rate);
	}
}

/* ******************************************
 *	This event comes from the Queue Plugin
 * ****************************************** */
function queueComplete(numFilesUploaded) {
	 console.info(this.getStats().successful_uploads);
}

/* ******************************************
 *	FileProgress Object
 *	Control object for displaying file info
 * ****************************************** */

function FileProgress(file) {
	if(file){
		this.fileProgressWrapper = $("#"+file.id).find(".ke-status"); 
		if (!this.fileProgressWrapper) {
			fadeIn(this.fileProgressWrapper, 0);
		}
	}
}

FileProgress.prototype.setProgress = function (percentage) {
	$(this.fileProgressWrapper).find(".ke-progressbar-bar-inner").css("width",percentage + "%");
	$(this.fileProgressWrapper).find(".ke-progressbar-percent").text(percentage + "%");
};

FileProgress.prototype.setComplete = function () {
	$(this.fileProgressWrapper).find(".ke-progressbar-bar-inner").css("width","");
};

FileProgress.prototype.setCancelled = function () {
	$(this.fileProgressWrapper).find(".ke-progressbar-bar-inner").css("width","");
};

FileProgress.prototype.setStatus = function (status) {
	$(this.fileProgressWrapper).find(".ke-message").text(status);
};

FileProgress.prototype.toggleCancel = function (show) {
	if(typeof show =='undefined'){
		$(this.fileProgressWrapper).find(".ke-progressbar").css("display", "none");
		$(this.fileProgressWrapper).find(".ke-message").css("display","none");
	}else{
		$(this.fileProgressWrapper).find(".ke-progressbar").css("display", show ? "block" : "none");
		$(this.fileProgressWrapper).find(".ke-message").css("display", show ? "none" : "block");
	}
};

/*
 * 淡出效果
 * elem==>需要淡入的元素
 * speed==>淡入速度,正整数(可选)
 * opacity==>淡入到指定的透明度,0~100(可选)
 */
function fadeOut(elem, speed, opacity){
    
    speed = speed || 20;
    opacity = opacity || 0;
    //初始化透明度变化值为0
    var val = 100;
    //循环将透明值以5递减,即淡出效果
    (function(){
        SetOpacity(elem, val);
        val -= 5;
        if (val >= opacity) {
            setTimeout(arguments.callee, speed);
        }else if (val < 0) {
            //元素透明度为0后隐藏元素
            elem.style.display = 'none';
        }
    })();
}
