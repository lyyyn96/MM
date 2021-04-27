
//영화 다운로드
$(document).ready(function(){
	$("button[name=downloadBtn]").click(function(){ 
		var index = $(this).attr("id");
		var movieTitle=$('.movieTitle').eq(index).text();
		$.get('download',
				{			   
					movieTitle:movieTitle
				},
				function(data){
					
				});
		
	});
});