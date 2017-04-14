
var wxsdk = {};

// 初始化微信jssdk
wxsdk.wx_init = function(apiList, isAsync) {

	var defaultApiList = [ "chooseImage", "uploadImage", "previewImage",
			"showMenuItems", 'hideOptionMenu', 'closeWindow' ];
	var _apiList = defaultApiList.concat(apiList);
	var _asnyc = (isAsync == true) ? false : true;

	$.ajax({
			url:tool.reqUrl.getWxSign,
			type : 'POST',
			data : {
				location : window.location.href.split('#')[0]
			},
			async : _asnyc,
			success : function(data) {
				var appId = data.appId, timestamp = data.timestamp, nonceStr = data.nonceStr, signature = data.signature;
				wx.config({
					debug : false, // 开启调试模式,调用的所有api的返回值会在客户端toast出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
					appId : appId, // 必填，公众号的唯一标识
					timestamp : timestamp, // 必填，生成签名的时间戳
					nonceStr : nonceStr, // 必填，生成签名的随机串
					signature : signature,// 必填，签名，见附录1
					jsApiList : _apiList
				// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
				});
			
			}
		});
};

// 微信二维码
wxsdk.wx_scan = function(cb, type, cancelCb) {

	var _type = (type == 'wx') ? 0 : 1;
	wx.scanQRCode({
		needResult : _type, // 默认为1，扫描直接返回扫描结果，0则结果由微信处理，
		scanType : [ "qrCode", "barCode" ], // 可以指定扫二维码还是一维码，默认二者都有
		success : function(res) {
			var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
			typeof cb === 'function' && cb(result);
		},
		cancel : function() {
			typeof cancelCb === 'function' && cancelCb();
		}
	});

}

// 关闭微信窗口
wxsdk.wx_close = function() {
	wx.closeWindow();
}

// 下载图片
var downloadImage = function(serverId, cb, obj) {

	var imgUrl = '';

	$.ajax({url:tool.reqUrl.downWxImg,
		data : {
			mediaIds : serverId
		},
		async : false,
		success : function(data) {
			if (data.path != '' && data.path.length > 0) {
				imgUrl = data.path[0].picUrl;
				typeof cb === 'function' && cb(imgUrl, obj);
			}
		}
	});

};

// 上传图片
var uploadImage = function(localIds, cb, obj) {

	wx.uploadImage({
		localId : localIds[0], // 需要上传的图片的本地ID，由chooseImage接口获得
		isShowProgressTips : 1, // 默认为1，显示进度提示
		success : function(res) {
			var serverId = res.serverId; // 返回图片的服务器端ID
			downloadImage(serverId, cb, obj);
		}
	});

};

// 选择图片
wxsdk.wx_chooseImg = function(cb, obj) {
	wx.chooseImage({
		count : 1, // 默认9
		sizeType : [ 'original', 'compressed' ], // 可以指定是原图还是压缩图，默认二者都有
		sourceType : [ 'album', 'camera' ], // 可以指定来源是相册还是相机，默认二者都有
		success : function(res) {
			var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
			uploadImage(localIds, cb, obj);
		}
	});
};

// 预览图片
wxsdk.wx_preview = function(current, urls) {

	wx.previewImage({
		current : current,
		urls : urls
	});

};

// 获取地理位置
wxsdk.wx_getLocation = function(cb, data) {

	var lat = 0, lng = 0;

	wx.ready(function() {

		wx.getLocation({
			success : function(res) {
				lat = res.latitude;
				lng = res.longitude;
				typeof cb === 'function' && cb(lat, lng, data);
			},
			fail : function() {
				typeof cb === 'function' && cb(lat, lng, data);
			},
			cancel : function() {
				typeof cb === 'function' && cb(lat, lng, data);
			}
		});

	});

};
