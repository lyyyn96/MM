//검색 
$(document).ready(function(){ 
	$("#searchBtn").click(function(){
		
		var movieTitle=$("#movieTitle").val();
		if (movieTitle == null){
			$.post("movieList",
			{			   
				
			}	
		);
		}
		else {
			$.post("movieSearch",
			{			   
				movieTitle:movieTitle
			}	
		);
		}
		
	alert(movieTitle);
	});
});