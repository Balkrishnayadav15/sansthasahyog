var currentUser = sessionStorage.getItem("LOGGED_IN_USER");

$(document).ready(function(){
	$("#divLoading").addClass('show');
            $.get('/authenticate?currentUser='+currentUser,
                    function (data) {
                        var responseData = JSON.parse(data);
                        if(responseData.VALID=='yes') {
                            window.location.replace("admin");
                        }
                        $("#divLoading").removeClass('show');
            });
	$("#login").click(function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		 var isSubmit = false; 
//		Checking for blank fields.
		if( userId ==''){
			$("#userId_error").show();
			isSubmit = true;
		}else{
			$("#userId_error").hide();
			isSubmit = false;
		}
		if( password ==''){
			$("#password_error").show();
			isSubmit = true;
		}else{
			$("#password_error").hide();
			isSubmit = false;
		}

		
		if(!isSubmit){
			$("#divLoading").addClass('show');
			$.post("/login",{ userId: userId, password:password},
					function(data) {
						var responseData = JSON.parse(data);
						if(responseData.VALID=='yes') {
							sessionStorage.setItem("LOGGED_IN_USER", userId);
							$("#divLoading").removeClass('show');
							$("#login_error").hide();
							window.location.replace("admin");
						}else if(responseData.VALID=='no'){
							$("#divLoading").removeClass('show');
							$("#login_error").show();
							sessionStorage.clear();
						} 
			});
		}
	});
});/**
 * 
 */