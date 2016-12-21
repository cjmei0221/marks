$(function() {
	var vm = new Vue({
		el : '#app',
		data:{
			info:{}
		},
		methods: {
			toList:function(){
				location.href ='./list.html?_t='+new Date().getTime();
			},
			summitForm:function(){
				
			}
		}
	});
});
