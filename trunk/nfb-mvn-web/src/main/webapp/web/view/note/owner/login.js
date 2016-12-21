$(function() {
	
	var vm = new Vue({
		el : '#app',
		data : {
			c_mobile : "",
			c_password : "",
			errorMsg:"ewrt",
			msgFlag:false
		},
		methods: {
			summitForm:function(){
				var _this=this;
				if(_this.c_mobile == ''){
					this.errorMsg="手机号码为空";
					this.msgFlag=true;
					return;
				}
				if(_this.c_password == ''){
					this.errorMsg="密码为空";
					this.msgFlag=true;
					return;
				}
				console.log(this.msgFlag);
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
