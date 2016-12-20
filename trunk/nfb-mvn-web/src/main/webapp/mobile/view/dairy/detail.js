$(function() {
	var id=tool.getUrlParams('id');
	var vm = new Vue({
		el : '#app',
		data:{
			info:{}
		},
		methods: {
			toList:function(){
				location.href ='./list.html?'+"_t="+new Date().getTime();;
			},
			toAdd:function(){
				location.href ='./add.html?'+"_t="+new Date().getTime();;
			}
		}
	});
	getDetail();
	function getDetail(){
		$.ajax({
			url : './data/dairyData.json',
			type : 'GET',
			dataType : "json",
			success : function(data) {
				vm.info=data;
			},
			complete : function() {
				
			}
		});
	}
});
