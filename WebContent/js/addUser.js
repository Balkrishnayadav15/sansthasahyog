var currentUser = sessionStorage.getItem("LOGGED_IN_USER");

$(document).ready(function(){
	$("#divLoading").addClass('show');
            $.get('/authenticate?currentUser='+currentUser,
                    function (data) {
                        var responseData = JSON.parse(data);
                        if(responseData.VALID=='no') {
        					window.location.replace("login.html");
        				}
                        $("#divLoading").removeClass('show');
            });
	$("#add_admin").click(function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		var userType = document.getElementById("userType").value;
		var confirm_password = $("#confirm_password").val();
		 var isSubmit = false; 
//		Checking for blank fields.
		if( userId =='' || userId == 0 || userId =='0'){
			$("#userId_error").show();
			isSubmit = true;
			return false;
		}else{
			$("#userId_error").hide();
			isSubmit = false;
		}
		if( password ==''){
			$("#password_error").show();
			isSubmit = true;
			return false;
		}else{
			$("#password_error").hide();
			isSubmit = false;
		}
		if( confirm_password ==''){
			$("#confirm_password_empty_error").show();
			$("#confirm_password_error").hide();
			isSubmit = true;
			return false;
		}else{
			if(password != confirm_password){
				$("#confirm_password_error").show();
				isSubmit = true;
				return false;
			}else{
				$("#confirm_password_empty_error").hide();
				$("#confirm_password_error").hide();
				isSubmit = false;
			}
		}
		 if(userType == null || userType == '0'){
			 $("#userType_error").css("display","block");
			 isSubmit = true;
			 return false;
		 }else{
			 $("#userType_error").hide();
			 isSubmit = false;
		 }	
		
		if(!isSubmit){
			$("#divLoading").addClass('show');
			$.post("/addAdmin",{ userId: userId, password:password,userType:userType},
					function(data) {
						var responseData = JSON.parse(data);
						if(responseData.VALID=='yes') {
							$("#divLoading").removeClass('show');
							$("#login_error").hide();
							window.location.replace("getAllAdmin");
						}else if(responseData.VALID=='no'){
							$("#divLoading").removeClass('show');
							$("#login_error").show();
						} 
			});
		}
	});
});/**
 * 
 */
function logout(){
	sessionStorage.clear();
	window.location.replace("login.html");
}