// 영화 자세히 보기
$(document).ready(function(){ 
	$('button[name=movieDetailBtn]').click(function(){
		
		var index = $(this).attr("class");
		alert(index);
		
		var movieTitle=$('.movieTitle').eq(index).text();
		alert(movieTitle);
		
		$.post("movieDetail",
			{			   
				movieTitle: movieTitle
			});
		alert("영화 자세히 보기");
	});
});