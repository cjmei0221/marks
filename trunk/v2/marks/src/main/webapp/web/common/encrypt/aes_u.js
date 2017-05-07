//使用（YYYMMDDYYYYMMDD）为密钥
function Encrypt(word) {
	var initkey=initKey()+initKey();
	var key = CryptoJS.enc.Utf8.parse(initkey);
	var srcs = CryptoJS.enc.Utf8.parse(word);
	var encrypted = CryptoJS.AES.encrypt(srcs, key, {
		mode : CryptoJS.mode.ECB,
		padding : CryptoJS.pad.Pkcs7
	});
	return encrypted.toString();
}

function initKey() {
	var curr_time = new Date();
	var dateTime = curr_time.getFullYear() ;
	dateTime += curr_time.getMonth() + 1;
	dateTime += curr_time.getDate();
	return dateTime;
}