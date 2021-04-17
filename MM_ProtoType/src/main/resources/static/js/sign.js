$(document).ready(function(){// 로그인
	$("#signInBtn").click(function(){
		
		var id=$("#floatingInput").val();
		var pw=$("#floatingPassword").val();
		
		$.post("signIn",
				  {			   
				    id:id,
				    pw:pw
				  },
				  function(data){
				  var obj=JSON.parse(data);			  
			  	if(obj.name){
				 	alert(obj.name+ "님 환영합니다.");
				 	location.href = "home";
					$.cookie("logined",obj.name + "님 환영합니다.");	
				}else{
					alert(obj.msg);
				}	
			});
			alert("b");
	});
});