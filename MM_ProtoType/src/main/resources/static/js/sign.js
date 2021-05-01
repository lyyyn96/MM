// 로그인
$(document).ready(function(){ 
	$("#signInBtn").click(function(){
		
		var id=$("#floatingID").val();
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
					$.cookie("logined",obj.name + "님 환영합니다.", {path:'/'});	
				}else{
					alert(obj.msg);
				}	
			});
		alert("무비 멘토 접속 중");
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
	if (confirm('로그아웃 하시겠습니까?')){
	$.post("signOut",
		{
		   
		},
		function(data){		  
			alert(data);	
			$.removeCookie("logined", {path:'/'});
			location.href = "/";	
			}		   
		);
		}
	});
});

// 회원가입
$(document).ready(function(){
	$("#signUpBtn").click(function(){ 
		$.post("signUp",
		{

		}
		);
	});
});

//회원 정보 수정
$(document).ready(function(){
	$("#memberUpdateBtn").click(function(){

		var name=$("#floatingName").val();
		var pw=$("#floatingPassword").val();


		var prefer_arr = [];
		$("input[name='preference']:checked").each(function() {
				var prefer = $(this).val();
			prefer_arr.push(prefer);
		});

		if(pw == ""){
			alert("비밀번호 값은 필수 입력입니다.");
		}else if (name == "" && prefer_arr.length == 0){
			alert("수정된 정보가 없습니다.");
		}else{
			$.ajax({
				method : "POST",
				url : "memberUpdate",
				traditional : true,
				data : {
				name:name,
				pw:pw,
				prefer:prefer_arr
				},
				success : function(data){
				if(data != "비밀번호가 일치하지 않습니다." && data != "수정된 정보가 없습니다."){
				alert(data);
				opener.parent.location.reload();
				window.close();
				}else{
					alert(data);
					
				}
				}
			});
		}
	});
});

$(document).ready(function(){
	$("#memberDeleteBtn").click(function(){ 
		if (confirm('정말 탈퇴하시겠습니까?')){
			$.post("memberDelete",
					{
					   
					},
					function(data){		  
						alert(data);	
						$.removeCookie("logined", {path:'/'});
						location.href = "/";	
						}		   
					);
		}
	});
});


// 멤버 추가
$(document).ready(function(){
	$("#memberInsertBtn").click(function(){ 
	
		var name=$("#floatingName").val();
		var id=$("#floatingID").val();
		var pw=$("#floatingPassword").val();


		var prefer_arr = [];
		$("input[name='preference']:checked").each(function() {
				var prefer = $(this).val();
			prefer_arr.push(prefer);
			});

		if(name == ""){
			alert("이름 값은 필수 입력입니다.");

		}
		else if(id == ""){
			alert("아이디 값은 필수 입력입니다.");

		}
		else if(pw == ""){
			alert("비밀번호 값은 필수 입력입니다.");

		}else{
			if($("input:checkbox[name='preference']").is(":checked")==false){
				alert("하나 이상의 취향 선택은 필수입니다.");
				
			}else{
				$.ajax({
					method : "POST",
					url : "memberInsert",
					traditional : true,
					data : {
						name:name,
						id:id,
						pw:pw,
						prefer:prefer_arr
					},
					success : function(data){
						if(data != "아이디가 중복입니다."){
						alert(data);
						opener.parent.location.reload();
						window.close();
						}else{
							alert("아이디가 중복입니다.");
							
						}
					}
				});
			}
		}


	});

});

//핸드폰 메세지 전송
$(document).ready(function() {
	$('#sendPhoneNumber').click(function() {
		let phoneNumber = $('#inputPhoneNumber').val();
		Swal.fire('인증번호 발송 완료!')

		$.ajax({
			type : "GET",
			url : "sendSMS",
			data : {
				"phoneNumber" : phoneNumber
			},
			success : function(res) {
				$('#checkBtn').click(function() {
					if ($.trim(res) == $('#inputCertifiedNumber').val()) {
						Swal.fire('인증성공!', '휴대폰 인증이 정상적으로 완료되었습니다.', 'success')

						$.ajax({
							type : "GET",
							url : "/update/phone",
							data : {
								"phoneNumber" : $('#inputPhoneNumber').val()
							}
						})
						document.location.href = "/home";
					} else {
						Swal.fire({
							icon : 'error',
							title : '인증오류',
							text : '인증번호가 올바르지 않습니다!',
							footer : '<a href="/home">다음에 인증하기</a>'
						})
					}
				})

			}
		})
	});
});