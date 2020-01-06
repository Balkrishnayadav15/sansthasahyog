var currentUser = sessionStorage.getItem("LOGGED_IN_USER");

$(document).ready(function(){
	$("#divLoading").addClass('show');
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
					     '&dateofbirth=' + dateofbirth+ '&pincode=' + pincode+ '&email=' + email+ '&registerFees=' + registerFees+ '&currentUser=' + currentUser;
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
			        	 var successText = "<h2 style='color: #62d562'> User "+responseData.USER.name+" with Registration number "+responseData.USER.registerId + " saved successfully.";
			        	 $("#success_user").html(successText);
			        	 $("#divLoading").removeClass('show');
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