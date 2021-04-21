// 장바구니 추가
$(document).ready(function(){
	$("#cartInsert").click(function(){ 
	
	var movieTitle=$("#movieTitle").val();

	
	$.post("cartInsert",
		{			   
			movieTitle:movieTitle
		},
		function(data){
			 	alert(data);
			});
		});
});
