$(document).ready(function(){
	$('#signup_btn').click(function(){
		console.log("signup clicked!!!");
		
		var username = $('#signup_username').val();
		var password = $('#signup_password').val();
		
		if(!username || !password) {
			alert("필수 항목을 채워주세요.");
			return;
		}
		
		var param = {
				email: username,
				userName: "test-user",
				password: password,
		}
		
		$.ajax({
	        url: "/members/auth/signUp",
	        method: "POST",
	        dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(param)
	    }).then(function(data) {
	    	console.log("s");
	    	alert("회원 가입이 되었습니다.");
	    	window.location.href = '/';
	    }, function(err) {
	    	console.log("f");
	    	alert(err);
	    	window.location.reload();
	    });
		return false;
	});
});