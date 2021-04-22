// 장바구니 추가
$(document).ready(function(){
	$("#cartInsertBtn").click(function(){ 
	
	var movieTitle=$("#movieTitle").text();

	
	$.post("cartInsert",
		{			   
			movieTitle:movieTitle
		},
		function(data){
			 	alert(data);
			});
		});
});

// 장바구니 삭제
$(document).ready(function(){
	$('button[name=cartDeleteBtn]').click(function(){ 
		
		var index = $(this).attr("class");
		alert(index);
		
		//document.getElementsByName("movieTitle")[index]
		var movieTitle=$('.movieTitle').eq(index).text();
		//var movieTitle=$("#moviTitle").text();
		
		alert(movieTitle)
	if (confirm('정말 삭제하시겠습니까?')){
		$.post("cartDelete",
				{
				   movieTitle:movieTitle
				},
				function(data){		  
					alert(data);	
					location.reload();	
				});
		}
	});
});