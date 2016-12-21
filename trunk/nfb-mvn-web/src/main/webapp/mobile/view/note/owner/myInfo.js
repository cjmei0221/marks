$(function() {
	
	var vm = new Vue({
		el : '#app',
		data : {
			headImage:"../../image/Tulips.jpg"
		},
		methods: {
			toList:function(){
				location.href ='../list.html?_t='+new Date().getTime();
			}
		}
	});

});
