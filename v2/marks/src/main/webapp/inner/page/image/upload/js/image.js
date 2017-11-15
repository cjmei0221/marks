var appInfo = {
	pageNum : 1,
	pageSize : 12,
	eleName:"",
	imgNum:0
}
function uploadPic() {
	if ($("#filebox_file_id_1").val() == "") {
		showMsg("请选择图片");
		return false;
	}
	$('#upload_form').form('submit', {
		url : "/inner/fileUpload/img.do",
		success : function(data) {
			showMsg("上传成功");
			$("#filebox_file_id_1").val("")
			loadImageList(1, appInfo.pageSize);
		}
	});
}
$(function() {
	appInfo.eleName=app.getUrlParams('eleName');
	appInfo.imgNum=app.getUrlParams('imgNum');
	
	$("#upload_form  .l-btn-text").html("请选择");
	$("#upload_form  .l-btn-text").css("width", "80px");
	$("#_easyui_textbox_input1").css("margin-left", "100px");
	loadImageList(1, appInfo.pageSize);
});

function loadImageList(pageNum, pageSize) {
	appInfo.pageSize = pageSize;
	$.ajax({
		type : 'POST',
		url : top.window.urlBase + "/inner/myImage/list.do",
		data : {
			page_number : pageNum,
			page_size : appInfo.pageSize
		},
		dataType : 'json',

		success : function(data) {
			if (data.retcode == "0") {
				$("#pgNation").pagination({
					total : data.total_count,
					pageList : [ 12, 24 ]
				});
				var list = data.list;
				var showDiv = $("#ImgList");
				showDiv.html("");
				var imgArr = getImageVal();// 在每个逗号(,)处进行分解。
				if (list.length > 0) {
					for (var i = 0; i < list.length; i++) {
						var imgDiv = showListImage(list[i].picUrl,
								list[i].picId);
						showDiv.append(imgDiv);
						for (var j = 0; j < imgArr.length; j++) {
							if (list[i].picName == imgArr[j]) {
								initImage(list[i].picId, 1);
							}
						}
					}
				}
			} else {
				showMsg('加载失败');

			}

		},

		error : function(err) {
			alert('网络故障');

		}

	});
}
function getImageVal() {
	console.log(appInfo.eleName);
	var objArr = $("#" + appInfo.eleName+ " > span > .imageUrlInput",window.opener.document);
	console.log(appInfo.objArr);
	var inputArr = [];
	if (null !=objArr && objArr.length > 0) {
		for (var i = 0; i < objArr.length; i++) {
			inputArr.push($(objArr[i]).val());
		}
	}
	var str = inputArr.join(",");
	return str
}
function showListImage(imgUrl, picId) {
	var str = '<span id="'
			+ picId
			+ '" width="200px" style="float:left; display:inline;">'
			+ '<input class="imageUrlInput" name="ftpImageUrl" value="'
			+ imgUrl
			+ '" class="easyui-validatebox" data-options="required:true" placeholder="图片访问路径" style="width: 155px;display:none;" readonly="readonly"><br/>'
			+ '<img class="imageUrl" src="'
			+ (imgUrl)
			+ '" style="width: 100px; height: 80px;" onclick="checkImage(this);"/> <br/>'
			+ '<input class="flagVal" value="1" style="width: 155px;display:none;" readonly="readonly"><br/>'
			+ '</span>';
	return str;
}
function initImage(picId, flag) {
	var showDiv = $("#" + picId);
	var flag = showDiv.children('.flagVal').val();
	var picUrl = showDiv.children('.imageUrlInput').val();
	var imgInput = showDiv.children('.imageUrl');
	if (flag == 1) {
		imgInput.attr("src", top.window.urlBase + "/images/checked.jpg");
		showDiv.children('.flagVal').val("0");
		showDiv.children('.flagVal').addClass("flagClass");
	}
}
function checkImage(eInput) {
	var showDiv = $($(eInput).parent());
	var flag = showDiv.children('.flagVal').val();
	var picUrl = showDiv.children('.imageUrlInput').val();
	if (flag == 1) {
		var num = $('.flagClass').length;
		if (num >= appInfo.imgNum) {
			alert("只能上传" + appInfo.imgNum + "张图片");
			return;
		}
		$(eInput).attr("src", top.window.urlBase + "/inner/images/checked.jpg");
		showDiv.children('.flagVal').val("0");
		showDiv.children('.flagVal').addClass("flagClass");
	} else {
		$(eInput).attr("src", picUrl);
		showDiv.children('.flagVal').removeClass("flagClass");
		showDiv.children('.flagVal').val("1");
		var spanArr = idDiv.children('span');
		for (var j = 0; j < spanArr.length; j++) {
			var objSpan = $(spanArr[j]);
			var orgUrl = objSpan.children('.imageUrlInput').val();
			if (picUrl == orgUrl) {
				objSpan.remove();
			}
		}
	}
}