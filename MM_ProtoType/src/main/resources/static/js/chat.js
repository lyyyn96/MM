//검색 
$(document).ready(function(){ 
	$("#btn-chat").click(function(){
		
		var chat=$("#btn-input").val();

			$.get("chat",{
				chat:chat
				
				});
	});
});

