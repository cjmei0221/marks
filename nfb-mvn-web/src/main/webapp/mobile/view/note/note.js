var eleNode=tool.getUrlParams("ele");

function toList(){
	if(eleNode == null || eleNode =='undefined' ){
		eleNode="diary";
	}
	location.href="../"+eleNode+"/list.html";
}