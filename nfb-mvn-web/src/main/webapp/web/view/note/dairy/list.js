$(function() {
	
	var vm = new Vue({
		el : '#app',
		data : {
			dataList : [],
			pageNum : 1,
			pageSize : 10,
			pageTotal : 0,
			isLoading : false
		},
		methods: {
			toDatail:function(id){
				 location.href ='./detail.html?id=' + id+"&_t="+new Date().getTime();
			},
			toAdd:function(){
				location.href ='./add.html?'+"_t="+new Date().getTime();;
			},
			toChangePwd:function(){
				location.href ='../owner/changePwd.html?'+"_t="+new Date().getTime();
			},
			toMyInfo:function(){
				location.href ='../owner/myInfo.html?'+"_t="+new Date().getTime();
			}
		}
	});
	getDairylist();
	
	function getDairylist(){
		$.ajax({
			url : '../data/dairyData.json',
			type : 'GET',
			dataType : "json",
			success : function(data) {
				var dairyList = data.list;
				var totalPage = data.list.length;
				if (scroll) {
					var myArr = vm.dataList;
					if (dairyList.length > 0)
						vm.dataList = myArr.concat(dairyList);
				} else {
					vm.dataList = dairyList;
				}
				vm.pageTotal = totalPage/vm.pageSize+1;
				vm.pageNum++;
				vm.isLoading = false;
			},
			complete : function() {
				// 重置加载flag
				vm.isLoading = false;
			}
		});
	}
});
