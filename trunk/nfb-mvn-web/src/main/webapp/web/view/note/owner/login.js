$(function() {
	
	var vm = new Vue({
		el : '#app',
		data : {
			c_mobile : "",
			c_password : ""
		},
		methods: {
			summitForm:function(){
				var _this=this;
				if(_this.c_mobile == ''){
					msg.error("手机号码为空");
					return false;
				}
				if(_this.c_password == ''){
					msg.error("密码为空");
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
						location.href ='../dairy/list.html?' +"_t="+new Date().getTime();
					},
					complete : function() {
						
					}
				});
			},
			resetForm:function(){
				var _this=this;
				_this.c_mobile == '';
				_this.c_password == ''
			}
		}
	});

});
