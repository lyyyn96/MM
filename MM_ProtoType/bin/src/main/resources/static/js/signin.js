
// 로그인

$(document).ready(function(){
	$("#loginBtn").click(function(){ // 로그인
		
		var id=$("#floatingInput").val();
		var pw=$("#floatingPassword").val();
		
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
		}
	});
});