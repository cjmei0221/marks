$(function() {
	
	var vm = new Vue({
		el : '#app',
		data : {
			headImage:"../../image/Tulips.jpg"
		},
		methods: {
			toList:function(){
				location.href ='../dairy/list.html?_t='+new Date().getTime();
			}
		}
	});

});
