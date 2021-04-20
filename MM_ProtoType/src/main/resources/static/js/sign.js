// 로그인
$(document).ready(function(){ 
	$("#signInBtn").click(function(){
		
		var id=$("#floatingInput").val();
		var pw=$("#floatingPassword").val();
		
<<<<<<< HEAD
		if(id == 'admin' && pw =='0000'){
			$.post("signIn",
				  {			   
				    id:id,
				    pw:pw
				  },
				  function(data, status){
				    var obj=JSON.parse(data);			  
			  	if(obj.name){
				 	alert(obj.name + "님 환영합니다.");
				 	location.href = "home";
					$.cookie("logined4admin",obj.name + "님 환영합니다.");	
					
					
					
				}else{
					alert(obj.msg);
					
				}	
			});
		}else{ 
			$.post("signIn",
				  {			   
				    id:id,
				    pw:pw
				  },
				  function(data, status){
					  var obj=JSON.parse(data);		
					  if(obj.name){
						  alert(obj.name+ "님 환영합니다.");
						  location.href = "home";
						  $.cookie("logined",obj.name + "님 환영합니다.");	
					}else{
						 alert(obj.msg);
				}	
			});
		}alert();
=======
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
					$.cookie("logined",obj.name + "님 환영합니다.", {path:'/'});	
				}else{
					alert(obj.msg);
				}	
			});
		alert("무비 멘토 접속 중");
>>>>>>> e88e3c75d782e6113ec16ce3f1e6e9f753fd3343
	});
});


//로그인 쿠키 처리
$(document).ready(function(){ 
	$(function(){
		var login=$.cookie('logined');
		
	$("#msgDiv").html(login);
	});

});


// 로그아웃
$(document).ready(function(){ 
	$("#signOutBtn").click(function(){
	$.post("signOut",
		{
		   
		},
		function(data){		  
			alert(data);	
			$.removeCookie("logined", {path:'/'});
			location.href = "/";	
			}		   
		);
	});
});

