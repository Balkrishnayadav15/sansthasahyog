var currentUser = sessionStorage.getItem("LOGGED_IN_USER");
var currentUserType = sessionStorage.getItem("USER_TYPE");

$(document).ready(function(){
	$("#divLoading").addClass('show');
	if(currentUserType == 'Admin'){
		/*$("#adminUser").show();
		$("#PendingUList").show();*/
		
	}else{
	/*	$("#adminUser").hide();
		$("#PendingUList").hide();*/
                     	}
	$.get('/authenticate?currentUser='+currentUser,
			function (data) {
				var responseData = JSON.parse(data);
				$("#divLoading").removeClass('show');
				if(responseData.VALID=='no') {
					window.location.replace("login.html");
				}
				refreshRegFields();
	});
});

$("#addNewUserButton").click(function(){
	refreshRegFields();
});

function refreshRegFields(){
	 $("#signup-content").show();
	 $("#success_user_div").hide();
	 
	 $("#success_user").html("");
	 
	 $("#school_name").val("");
	 $("#school_address").val("");
	 $("#name").val("");
	 $("#address").val("");
	 $("#mobile").val("");
	 $("#dateofbirth").val("");
	 $("#pincode").val("");
	 $("#email").val("");
	 $("#registerFees").val("");
}

$("#submit").click(function(){
	
	
	 var isSubmit = false; 
	 var schoolName = document.getElementById("school_name").value;
	 var schoolAddress = document.getElementById("school_address").value;
	 var eYear = document.getElementById("eYear").value;
	 var userType = document.getElementById("userType").value;
	 var name = document.getElementById("name").value;
	 var male = document.getElementById("male").value;
	 var female = document.getElementById("female").value;
	 var address = document.getElementById("address").value;
	 var mobile = document.getElementById("mobile").value;
	 var dateofbirth = document.getElementById("dateofbirth").value;
	 var pincode = document.getElementById("pincode").value;
	 var email = document.getElementById("email").value;
	 var registerFees = document.getElementById("registerFees").value;
	 var gender = $("input[name='gender']:checked"). val();
	 var diseCode = document.getElementById("diseCode").value;
	 var affNumber = document.getElementById("affNumber").value;
	 
	 if(affNumber == null || affNumber == ''){
		 $("#affNumber_error").show();
		 isSubmit = true;
	 }else{
		 $("#affNumber_error").hide();
		 isSubmit = false;
	 }
	 if(diseCode == null || diseCode == ''){
		 $("#diseCode_error").show();
		 isSubmit = true;
	 }else{
		 $("#diseCode_error").hide();
		 isSubmit = false;
	 }
	 if(schoolName == null || schoolName == ''){
		 $("#school_name_error").show();
		 isSubmit = true;
	 }else{
		 $("#school_name_error").hide();
		 isSubmit = false;
	 }
	 if(schoolAddress == null || schoolAddress == ''){
		 $("#school_address_error").css("display","block");
		 isSubmit = true;
	 }else{
		 $("#school_address_error").hide();
		 isSubmit = false;
	 }		
	 if(eYear == null || eYear == ''){
		 $("#eYear_error").css("display","block");
		 isSubmit = true;
	 }else{
		 $("#eYear_error").hide();
		 isSubmit = false;
	 }	
	 if(userType == null || userType == ''){
		 $("#userType_error").css("display","block");
		 isSubmit = true;
	 }else{
		 $("#userType_error").hide();
		 isSubmit = false;
	 }	
	 
	 if(name == null || name == ''){
		 $("#name_error").css("display","block");
		 isSubmit = true;
	 }else{
		 $("#name_error").hide();
		 isSubmit = false;
	 }	
	 if(address == null || address == ''){
		 $("#address_error").css("display","block");
		 isSubmit = true;
	 }else{
		 $("#address_error").hide();
		 isSubmit = false;
	 }
	 if(mobile == null || mobile == ''){
		 $("#mobile_error").css("display","block");
		 isSubmit = true;
	 }else{
		 $("#mobile_error").hide();
		 isSubmit = false;
	 }
	 if(dateofbirth == null || dateofbirth == ''){
		 $("#dateofbirth_error").css("display","block");
		 isSubmit = true;
	 }else{
		 $("#dateofbirth_error").hide();
		 isSubmit = false;
	 }
	 if(pincode == null || pincode == ''){
		 $("#pincode_error").css("display","block");
		 isSubmit = true;
	 }else{
		 $("#pincode_error").hide();
		 isSubmit = false;
	 }
	 if(email == null || email == ''){
		 $("#email_error").css("display","block");
		 isSubmit = true;
	 }else{
		 $("#email_error").hide();
		 isSubmit = false;
	 }
	 if(registerFees == null || registerFees == ''){
		 $("#registerFees_error").css("display","block");
		 isSubmit = true;
	 }else{
		 $("#registerFees_error").hide();
		 isSubmit = false;
	 }
     
	 if(!isSubmit){
	     var dataString = 'schoolName='+ schoolName + '&schoolAddress=' + schoolAddress+ '&eYear=' + eYear+ '&userType=' + userType +
					     '&name=' + name+ '&gender=' + gender+ '&address=' + address+ '&mobile=' + mobile +
					     '&dateofbirth=' + dateofbirth+ '&pincode=' + pincode+ '&email=' + email+ '&registerFees=' + registerFees+ '&currentUser=' + currentUser+ '&affNumber=' + affNumber+ '&diseCode=' + diseCode;
	     $("#divLoading").addClass('show');
	     
	     jQuery.ajax({
	         url: "/register",
	         data: dataString,
	         type: "POST",
	         success: function(data){
	        	 var responseData = JSON.parse(data);
				 if(responseData.VALID=='yes') {
						 $("#signup-content").hide();
			        	 $("#success_user_div").show();
			        	 var successText = "<h2 style='color: #62d562'> User "+responseData.USER.name+" with Registration number "+responseData.USER.registerId + " saved successfully.</h2>";
			        	 var notification_msg =  "<br><br><br><p class='sendMsg' style='background-color: antiquewhite;width: 100%;'>Thank you for Registing yourself with Shayog Ashasakiya Vidhalay Sangh.Your Registion number is "+responseData.USER.registerId+". Please visit our site www.sasnthasahyog.com</p>";
			        	 $("#notification_msg").html(notification_msg);
			        	 $("#success_user").html(successText);
			        	 $("#divLoading").removeClass('show');
			        	 sessionStorage.setItem("REG_USER_NAME",responseData.USER.name);
			        	 sessionStorage.setItem("REG_USER_ID",responseData.USER.registerId);
				 } 
	         },
	         error: function (){}
	     });
	 }
	
});
function logout(){
	sessionStorage.clear();
	window.location.replace("login.html");
}

function sendMessage(){
	var userId = sessionStorage.getItem("REG_USER_NAME");
	var userName = sessionStorage.getItem("REG_USER_ID");
	 jQuery.ajax({
         url: "/sendsms",
         data: "userId="+userId+"&userName"+userName,
         type: "POST",
         success: function(data){
        	 var responseData = JSON.parse(data);
			 if(responseData.VALID=='yes') {
		        	 $("#divLoading").removeClass('show');
		        	 $("#sms_send_failure").hide();
		        	 $("#sms_send_success").show();
		        	 sessionStorage.removeItem("REG_USER_NAME");
		        	 sessionStorage.removeItem("REG_USER_ID");
			 }else{
				 $("#sms_send_failure").show();
				 $("#sms_send_success").hide();
			 }
         },
         error: function (){}
     });
}