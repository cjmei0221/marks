function selectImage(file,snum) {
	var showDiv = $($(file).parent().next());
	var num=showDiv.children('span').length;
	if(num>=snum){
		alert("只能上传"+snum+"张图片");
		return;
	}
	if (!file.files || !file.files[0]) {
		return;
	}
	var image = '';
	var reader = new FileReader();
	reader.onload = function(evt) {
		// $('.'+eInput).attr("src",evt.target.result);
		image = evt.target.result;
		uploadImage(image, file);
	}
	reader.readAsDataURL(file.files[0]);
}
function uploadImage(image, eInput) {
	$.ajax({

				type : 'POST',

				url : top.window.urlBase + "/fileUpload/image.do",

				data : {
					image : image
				},

				async : false,

				dataType : 'json',

				success : function(data) {
					if (data.retcode == 0) {
						var showDiv = $($(eInput).parent().next());
						var imgDiv=showImage(data.fileUrl);
						showDiv.append(imgDiv);
						showMsg('上传成功');
					} else {
						showMsg('上传失败');

					}

				},

				error : function(err) {
					alert('网络故障');

				}

			});

}

function deleteImage(eInput) {
	var eInputParent = $($(eInput).parent());
	eInputParent.remove();
}

function deleteImageDiv(eInput) {
	$("#" + eInput).html("");
}

function editImage(eInput,fileUrl) {
	var showDiv = $("#"+eInput);
	var imgDiv=showImage(fileUrl);
	showDiv.append(imgDiv);
}

function getImageVal(eInput){
	var showDiv = $("#"+eInput);
	var objArr=$("#"+eInput+" > span > img");
	var inputArr=[];
	if(objArr.length >0){
		for(var i=0;i<objArr.length;i++){
			inputArr.push($(objArr[i]).attr("src"));
		}
	
	}
	var str=inputArr.join(",");
	alert(str);
	return str
}

function showImage(imgUrl){
	var str = '<span width="200px" style="float:left; display:inline;">'
		+ '<input name="ftpImageUrl" value="'+imgUrl+'" class="easyui-validatebox" data-options="required:true" placeholder="图片访问路径" style="width: 155px;" readonly="readonly"><br/>'
		+ '<img class="imageUrl" src="'+imgUrl+'" style="width: 160px; height: 100px;" /> <br/>'
		+ '<input type="button" onclick="deleteImage(this);" value="删除"/>'
		+ '</span>';
	return str;
}
