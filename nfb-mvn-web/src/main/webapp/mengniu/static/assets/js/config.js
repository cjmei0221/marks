document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideOptionMenu');
});

require.config({
	baseUrl: '../../',
	paths: {
		//共用
		zepto: '../assets/js/lib/zepto-1.2.0',
		Vue: '../assets/js/lib/vue.min',
		sm: '../sui/js/sm.min',
		smExtend: '../sui/js/sm-extend.min',
		_: '../assets/js/lib/lodash.min',
		wx: 'http://res.wx.qq.com/open/js/jweixin-1.0.0',
		//api
		api: '../module/api/api',
		//tool
		copyRight: '../module/tool/copyRight',
		template: '../module/tool/template',
		requestion: '../module/tool/requestion',
		filter: '../module/tool/filter',
		tool: '../module/tool/tool',
		wxsdk: '../module/tool/wxsdk',
		regex: '../module/tool/regex',
		date: '../module/tool/date',
		storage: '../module/tool/storage',
		wxPay: '../module/tool/wxPay',
		md5: '../module/tool/md5',
		userInfo: '../module/tool/userInfo',
		link: '../module/tool/link',
		//template对应的模块
		dialog: '../template/dialog/dialog',
		//handle
		orderStatus: '../module/handle/orderStatus',
		//components
		address: '../module/components/address',
		zoneSelect: '../module/components/zoneSelect',
		protocol: '../module/components/protocol',
	},
	shim : {
		sm : {
			deps:['zepto']
		},
		smExtend : {
			deps:['zepto', 'sm']
		}
	}
});