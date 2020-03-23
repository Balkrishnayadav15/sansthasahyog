var currentUser = sessionStorage.getItem("LOGGED_IN_USER");
var currentUserType = sessionStorage.getItem("USER_TYPE");

$(document).ready(function(){
	$("#divLoading").addClass('show');
	/*if(currentUserType == 'Admin'){
		$("#adminUser").show();
	}else{
		$("#adminUser").hide();
	}*/
	$.get('/authenticate?currentUser='+currentUser,
			function (data) {
				var responseData = JSON.parse(data);
				console.log("admin:"+responseData);
				$("#divLoading").removeClass('show');
				if(responseData.VALID=='no') {
					window.location.replace("login.html");
				}
	});
});

function userDetails(id, status){
	if(status === 'pending'){
		$('#pending_'+id).toggle();
		$('#pending_details_'+id).show();
		//$('#update_'+id).hide();
	}else{
		$('#'+id).toggle();
		$('#details_'+id).show();
		$('#update_'+id).hide();
	}
}

function logout(){
	sessionStorage.clear();
	window.location.replace("login.html");
}

function update(id){
	$('#details_'+id).hide();
	$('#update_'+id).toggle();
}

function approve(id){

	var dataString = 'currentUser=' + currentUser+'&userId='+id;
	
	$("#divLoading").addClass('show');
	jQuery.ajax({
		url: "/approve",
		data: dataString,
		type: "POST",
		success: function(data){
			var responseData = JSON.parse(data);
			if(responseData.VALID=='yes') {
				window.location.replace("admin");
			} 
			$("#divLoading").removeClass('show');
		},
		error: function (){}
	});

}

function saveUpdatedDetails(id){
	var isSubmit = false; 
	var schoolName = document.getElementById("school_name_"+id).value;
	var schoolAddress = document.getElementById("school_address_"+id).value;
	var eYear = document.getElementById("eYear_"+id).value;
	var userType = document.getElementById("userType_"+id).value;
	var name = document.getElementById("name_"+id).value;
	var address = document.getElementById("address_"+id).value;
	var mobile = document.getElementById("mobile_"+id).value;
	var dateofbirth = document.getElementById("dateofbirth_"+id).value;
	var pincode = document.getElementById("pincode_"+id).value;
	var email = document.getElementById("email_"+id).value;
	//var gender = $("input[name='gender_'"+id+"]:checked"). val();
	 if(document.getElementById('male_'+id).checked) {
		 var gender = "Male";
	 }else if(document.getElementById('female_'+id).checked){
		 var gender = "Female";
	 }
	 
	 
	if(schoolName == null || schoolName == ''){
		$("#school_name_error_"+id).show();
		isSubmit = true;
	}else{
		$("#school_name_error_"+id).hide();
		isSubmit = false;
	}
	if(schoolAddress == null || schoolAddress == ''){
		$("#school_address_error_"+id).css("display","block");
		isSubmit = true;
	}else{
		$("#school_address_error_"+id).hide();
		isSubmit = false;
	}		
	if(eYear == null || eYear == ''){
		$("#eYear_error_"+id).css("display","block");
		isSubmit = true;
	}else{
		$("#eYear_error_"+id).hide();
		isSubmit = false;
	}	
	if(userType == null || userType == ''){
		$("#userType_error_"+id).css("display","block");
		isSubmit = true;
	}else{
		$("#userType_error_"+id).hide();
		isSubmit = false;
	}	
	
	if(name == null || name == ''){
		$("#name_error_"+id).css("display","block");
		isSubmit = true;
	}else{
		$("#name_error_"+id).hide();
		isSubmit = false;
	}	
	if(address == null || address == ''){
		$("#address_error_"+id).css("display","block");
		isSubmit = true;
	}else{
		$("#address_error_"+id).hide();
		isSubmit = false;
	}
	if(mobile == null || mobile == ''){
		$("#mobile_error_"+id).css("display","block");
		isSubmit = true;
	}else{
		$("#mobile_error_"+id).hide();
		isSubmit = false;
	}
	/*if(dateofbirth == null || dateofbirth == ''){
		$("#dateofbirth_error_"+id).css("display","block");
		isSubmit = true;
	}else{
		$("#dateofbirth_error_"+id).hide();
		isSubmit = false;
	}*/
	if(pincode == null || pincode == ''){
		$("#pincode_error_"+id).css("display","block");
		isSubmit = true;
	}else{
		$("#pincode_error_"+id).hide();
		isSubmit = false;
	}
	if(email == null || email == ''){
		$("#email_error_"+id).css("display","block");
		isSubmit = true;
	}else{
		$("#email_error_"+id).hide();
		isSubmit = false;
	}
	
	
	if(!isSubmit){
		var dataString = 'schoolName='+ schoolName + '&schoolAddress=' + schoolAddress+ '&eYear=' + eYear+ '&userType=' + userType +
						'&name=' + name+ '&gender=' + gender+ '&address=' + address+ '&mobile=' + mobile +
						'&dateofbirth=' + dateofbirth+ '&pincode=' + pincode+ '&email=' + email+  '&currentUser=' + currentUser+'&userId='+id;
		$("#divLoading").addClass('show');
		jQuery.ajax({
			url: "/update",
			data: dataString,
			type: "POST",
			success: function(data){
				var responseData = JSON.parse(data);
				if(responseData.VALID=='yes') {
					window.location.replace("admin");
				} 
				$("#divLoading").removeClass('show');
			},
			error: function (){}
		});
	}
}
function download(){
	var url ="http://www.sansthasahyog.com/downloadUsers";
	//var url = "http://localhost:8080/downloadUsers";
	 var getselectVal = [];
     $.each($("input[name='user']:checked"), function(){
    	 getselectVal.push($(this).val());
     });
    // alert("My favourite sports are: " + getselectVal.join(", "));
	
     if(getselectVal.length > 0){
    	 url = url + "?selectedUser="+getselectVal.join(",");
    	 $("#error").hide();
	 	 window.open(url);
	 }else{
		 $("#error").show();
	 }
}

function deleteUser(id){
	$("#divLoading").addClass('show');
		jQuery.ajax({
			url: "/delete",
			data: "userId="+id+'&currentUser=' + currentUser,
			type: "POST",
			success: function(data){
				var responseData = JSON.parse(data);
				if(responseData.VALID=='yes') {
					window.location.replace("admin");
				} 
				$("#divLoading").removeClass('show');
			},
			error: function (){}
		});
}