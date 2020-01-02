$(document).ready(function(){
	$("#login").click(function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
//		Checking for blank fields.
		if( userId =='' || password ==''){
			$('input[type="text"],input[type="password"]').css("border","2px solid red");
			$('input[type="text"],input[type="password"]').css("box-shadow","0 0 3px red");
			alert("Please fill all fields...!!!!!!");
		}else {
			$.post("/login",{ userId: userId, password:password},
					function(data) {
						var responseData = JSON.parse(data);
						if(responseData.VALID=='yes') {
							/*$('input[type="text"]').css({"border":"2px solid red","box-shadow":"0 0 3px red"});
							$('input[type="password"]').css({"border":"2px solid #00F5FF","box-shadow":"0 0 5px #00F5FF"});
							alert(data); */
							window.location.replace("admin.jsp");
						}else if(responseData=='no'){
							$('input[type="text"],input[type="password"]').css({"border":"2px solid red","box-shadow":"0 0 3px red"});
							alert(data);
						} 
			});
		}
	});
});/**
 * 
 */