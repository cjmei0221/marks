function selectImage(file) {
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
				var eInputParent=$(eInput).parent(); 
				var eInput0=$(eInputParent.children('input').eq(0));
				eInput0.val(data.fileUrl);
				var imageUrl=$(eInputParent.children('img')); 
				imageUrl.attr("src", data.fileUrl)
				imageUrl.show();
				var eInput2=$(eInputParent.children('input').eq(2));
				eInput2.show();
				$(eInputParent.children('input').eq(1)).hide();
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

function deleteImage(eInput){
	var eInputParent=$(eInput).parent(); 
	$(eInputParent.children('input').eq(1)).show();
	$(eInputParent.children('input').eq(1)).val('');
	$(eInputParent.children('input').eq(0)).val('');
	var imageUrl=$(eInputParent.children('img')); 
	imageUrl.attr('src','');
	imageUrl.hide();
	$(eInput).hide();
}

function deleteImageByName(eInput){
	var eInputParent=$("#"+eInput).parent(); 
	$(eInputParent.children('input').eq(1)).show();
	$(eInputParent.children('input').eq(1)).val('');
	$(eInputParent.children('input').eq(0)).val('');
	var imageUrl=$(eInputParent.children('img')); 
	imageUrl.attr('src','');
	imageUrl.hide();
}

function editImage(eInput){
	var eInputParent=$("#"+eInput).parent(); 
	var path=$(eInputParent.children('input').eq(0)).val(); 
	$(eInputParent.children('input').eq(1)).hide();
	var imageUrl=$(eInputParent.children('img')); 
	imageUrl.attr('src',path);
	imageUrl.show();
	var eInput2=$(eInputParent.children('input').eq(2));
	eInput2.show();
}
