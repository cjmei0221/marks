$(function() {
	
	var vm = new Vue({
		el : '#app',
		data : {
			c_oldPwd : "",
			c_newPwd : "",
			c_newPwd2 : "",
			isLoading : true
		},
		methods: {
			toList:function(){
				location.href ='../list.html?_t='+new Date().getTime();
			},
			summitForm:function(){
				vm.isLoading = false;
				var _this=this;
				if(_this.c_oldPwd == ''){
					$.toast("旧密码为空");
					return false;
				}
				if(_this.c_newPwd == ''){
					$.toast("新密码为空");
					return false;
				}
				if(_this.c_newPwd2 == ''){
					$.toast("确认密码为空");
					return false;
				}
				if(_this.c_newPwd !=_this.c_newPwd2){
					$.toast("新密码与确认密码不一致");
					return false;
				}
				$.ajax({
					url : '../data/dairyData.json',
					type : 'POST',
					dataType : "json",
					data:{
						oldPwd:_this.c_oldPwd,
						newPwd:_this.c_newPwd,
						newPwd2:_this.c_newPwd2
					},
					success : function(data) {
						vm.isLoading = true;
						location.href ='./login.html?' +"_t="+new Date().getTime();
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
