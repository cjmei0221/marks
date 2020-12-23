var img = {
	idDiv : "addMainImg",
	imgNum : 1,
	pageNum : 1,
	pageSize : 12,
	checkImgUrl: "/inner/images/checked.jpg"
};
$(function() {
	$("#upload_form  .l-btn-text").html("请选择");
	$("#upload_form  .l-btn-text").css("width", "80px");
	$("#_easyui_textbox_input1").css("margin-left", "100px");
});
function comfirmPic(){
	$("#imageListWin").window("close");
}
function selectUploadImage(eleName, imgNum) {
	$("#imageListWin").window({
		title : "请选择图片"
	}).window("open");
	img.idDiv = eleName;
	img.imgNum = imgNum;
	loadImageList(1, img.pageSize);
}

function loadImageList(pageNum, pageSize) {
	img.pageSize = pageSize;
	$.ajax({

		type : 'POST',

		url : top.window.urlBase + "/inner/myImage/list.do",
		data : {
			page_number : pageNum,
			page_size : img.pageSize
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
				var imgPicArr = img.getImageVal(img.idDiv);
				var imgArr = imgPicArr.split(",");// 在每个逗号(,)处进行分解。
				if (list.length > 0) {
					for (var i = 0; i < list.length; i++) {
						var imgDiv = showListImage(list[i].picUrl,
								list[i].picId);
						showDiv.append(imgDiv);
						for (var j = 0; j < imgArr.length; j++) {
							if (list[i].picUrl == imgArr[j]) {
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
function uploadPic() {
	if ($("#filebox_file_id_1").val() == "") {
		showMsg("请选择图片");
		return false;
	}
	$('#upload_form').form('submit', {
		url : top.window.urlBase + "/inner/fileUpload/img.do",
		success : function(data) {
			if (typeof data === 'string') {
				try {
					data = $.parseJSON(data);
				} catch (e0) {
					showMsg("json格式错误");
					return;
				}
			}
			if (data.retcode == '0') {
				showMsg("上传成功");
				$("#upload_form").form('clear');
				loadImageList(1, img.pageSize);
			} else {
				showMsg("上传失败");
				$("#upload_form").form('clear');
			}
		}
	});
}
function deleteImage(eInput) {
	var eInputParent = $($(eInput).parent());
	eInputParent.remove();
}

img.deleteImageDiv = function deleteImageDiv(eInput) {
	$("#" + eInput).html("");
}

img.editImage = function editImage(eInput, fileUrl, flag) {
	if(null !=fileUrl && fileUrl.length>4){
		var showDiv = $("#" + eInput);
		var imgDiv = showImage(fileUrl);
//		if (flag == 1) {
//			imgDiv = showImageOnlyRead(fileUrl);
//		}
		showDiv.append(imgDiv);
	}
}

img.getImageVal = function getImageVal(eInput) {
	var showDiv = $("#" + eInput);
	var objArr = $("#" + eInput + " > span > .imageUrlInput");
	var inputArr = [];
	if (objArr.length > 0) {
		for (var i = 0; i < objArr.length; i++) {
			inputArr.push($(objArr[i]).val());
		}

	}
	var str = inputArr.join(",");
	return str
}

function showImageOnlyRead(imgUrl) {
	var str = '<span width="200px" style="float:left; display:inline;">'
			+ '<input class="imageUrlInput" name="ftpImageUrl" value="'
			+ imgUrl
			+ '" class="easyui-validatebox" data-options="required:true" placeholder="图片访问路径" style="width: 155px;display:none;" readonly="readonly"><br/>'
			+ '<img class="imageUrl" src="' + (imgUrl)
			+ '" style="width: 160px; height: 100px;" /> <br/>' + '</span>';
	return str;
}

function showImage(imgUrl) {
	var str = '<span width="200px" style="float:left; display:inline;">'
			+ '<input class="imageUrlInput" name="ftpImageUrl" value="'
			+ imgUrl
			+ '" class="easyui-validatebox" data-options="required:true" placeholder="图片访问路径" style="width: 155px;display:none;" readonly="readonly"><br/>'
			+ '<img class="imageUrl" src="' + (imgUrl)
			+ '" style="width: 160px; height: 100px;" /> <br/>'
//			+ '<input type="button" onclick="deleteImage(this);" value="删除"/>'
			+ '</span>';
	return str;
}
function checkImage(eInput) {
	var showDiv = $($(eInput).parent());
	var flag = showDiv.children('.flagVal').val();
	var picUrl = showDiv.children('.imageUrlInput').val();
	var idDiv = $("#" + img.idDiv);
	if (flag == 1) {
		var num = idDiv.children('span').length;
		if (num >= img.imgNum) {
			alert("只能上传" + img.imgNum + "张图片");
			return;
		}
		$(eInput).attr("src", img.checkImgUrl);
		showDiv.children('.flagVal').val("0");
		img.editImage(img.idDiv, picUrl);
	} else {
		$(eInput).attr("src", picUrl);
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

function initImage(picId, flag) {
	var showDiv = $("#" + picId);
	var flag = showDiv.children('.flagVal').val();
	var picUrl = showDiv.children('.imageUrlInput').val();
	var imgInput = showDiv.children('.imageUrl');
	if (flag == 1) {
		imgInput.attr("src", img.checkImgUrl);
		showDiv.children('.flagVal').val("0");
		// img.editImage(img.idDiv, picUrl);
	}
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
