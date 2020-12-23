var myChart = echarts.init(document.getElementById('main_pie'));
var skuNameArr = [];
var arr = [];
var arr = (function(){
	$.ajax({
		type : "POST",
		url : "/inner/detailInfo/pieList.do",
		async : false,
		data : {},
		dataType : "json",
		success : function(result){
			if(result.pieList.length == 0 ){
        		$('#inner_top').append(
        			'<div class="notFound" style="text-align: center;' + 
        			'position: relative;top:-135px;">'+'暂无数据'+'</div>'
        		);
			} else {
				for(var i=0;i<result.pieList.length;i++){
					var object = {};
					var skuName = result.pieList[i].skuName;
					skuNameArr.push(skuName);
					object.value = result.pieList[i].count;
					object.name = skuName;
					arr.push(object);
				}
			}
		}
		
	})
	return arr;
})();

var option = {
	    title : {
	        text: '近30天积分商品占比',
	        subtext: '单位：（件）',
	        x:'left'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: { //说明、图例
	        orient: 'vertical', // 使适应：垂直
	        left: 'right',
	        data:skuNameArr
	    },
	    series : [
	        {
	            name: '数据来源',
	            type: 'pie',
	            radius : '65%',
	            center: ['45%', '50%'],
	            data:arr,
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
   // 使用刚指定的配置项和数据显示图表。
   myChart.setOption(option);