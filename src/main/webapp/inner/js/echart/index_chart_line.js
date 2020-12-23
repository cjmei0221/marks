var myChart = echarts.init(document.getElementById('main_line'));
var arr = (function (){
	var arr = [];
	$.ajax({
        type : "post",
        async : false, //同步执行
        url : "/inner/detailInfo/lineList.do",
        data : {},
        dataType : "json", //返回数据形式为json
        success : function(result) {
            if (result) {
                for(var i=0;i<result.lineList.length;i++){
                  arr.push(result.lineList[i].total);
                }  
            }
            
        }
   })
   return arr;
})();
var arrDate = (function (){
	var arr = [];
	$.ajax({
        type : "post",
        async : false, //同步执行
        url : "/inner/detailInfo/lineList.do",
        data : {},
        dataType : "json", //返回数据形式为json
        success : function(result) {
        	if(result.lineList.length == 0 ){
        		$('#inner_bottom').append(
        			'<div class="notFound" style="text-align: center;' + 
        			'position: relative;top:-135px;">'+'暂无数据'+'</div>'
        		);
        	}
            if (result) {
                for(var i=0;i<result.lineList.length;i++){
                  arr.push(result.lineList[i].integraDate);
                }  
            }
            
        }
   })
   return arr;
})();
var option = {
	    title: {
	        text: '近30天积分走势图',
	        subtext: '单位：（积分）',
	    },
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross'
	        }
	    },
	    toolbox: {
	        show: true,
	        feature: {
	            saveAsImage: {}
	        }
	    },
	    xAxis:  {
	        type: 'category',
	        boundaryGap: false,
	        data : arrDate
	    },
	    yAxis: {
	        type: 'value',
	        axisLabel: {
	            formatter: '{value}'
	        },
	        axisPointer: {
	            snap: true
	        }
	    },
	    visualMap: {
	        show: false,
	        dimension: 0,
	        pieces: [{
	            lte: 6,
	            color: 'green'
	        }, {
	            gt: 6,
	            lte: 31,
	            color: 'green'
	        }]
	    },
	    series: [
	        {
	            name:'积分',
	            type:'line',
	            smooth: true,
	            data:arr
	        }
	    ]
	};
   // 使用刚指定的配置项和数据显示图表。
   myChart.setOption(option);