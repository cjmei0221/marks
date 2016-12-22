var id=tool.getUrlParams('id');
$(function() {
	getDetail();
});

function getDetail(){
	$.ajax({
		url : './data/dairyData.json',
		type : 'GET',
		dataType : "json",
		success : function(data) {
			
		},
		complete : function() {
			
		}
	});
}