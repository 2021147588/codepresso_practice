$(document).ready(function(){
	$('#login_btn').click(function(){
		console.log("login clicked!!!");
		
		var username = $('#login_username').val();
		var password = $('#login_password').val();
		
		if(!username || !password) {
			alert("필수 항목을 채워주세요.");
			return;
		}
		
		var param = {
				email: username,
				password: password
		}
		
		$.ajax({
	        url: "/members/auth/login",
	        method: "POST",
	        dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(param)
	    }).then(function(data) {	    	
	    	window.location.href = '/';
	    }, function(err) {
	    	alert("계정 정보를 확인해주세요.");
	    	window.location.reload();
	    });
		return false;
	});
});