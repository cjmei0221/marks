$(function() {
	
	var vm = new Vue({
		el : '#app',
		data : {
			c_mobile : "",
			c_password : "",
			isLoading : true
		},
		methods: {
			summitForm:function(){
				vm.isLoading = false;
				var _this=this;
				if(_this.c_mobile == ''){
					$.toast("手机号码为空");
					return false;
				}
				if(_this.c_password == ''){
					$.toast("密码为空");
					return false;
				}
				$.ajax({
					url : '../data/dairyData.json',
					type : 'POST',
					dataType : "json",
					data:{
						mobile:_this.c_mobile,
						password:_this.c_password
					},
					success : function(data) {
						vm.isLoading = true;
						location.href ='../dairy/list.html?' +"_t="+new Date().getTime();
					},
					complete : function() {
						// 重置加载flag
						vm.isLoading = true;
					}
				});
			}
		}
	});

});
