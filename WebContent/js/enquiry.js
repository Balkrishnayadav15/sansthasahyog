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
		$('#enquiry_'+id).toggle();
		$('#enquiry_details_'+id).show();
}

function logout(){
	sessionStorage.clear();
	window.location.replace("login.html");
}

function update(id){
	$('#details_'+id).hide();
	$('#update_'+id).toggle();
}

function rejectEnquiry(id){

	var dataString = 'currentUser=' + currentUser+'&enquiryId='+id+'&operation=reject';
	
	$("#divLoading").addClass('show');
	jQuery.ajax({
		url: "/updateEnquiry",
		data: dataString,
		type: "POST",
		success: function(data){
			var responseData = JSON.parse(data);
			if(responseData.VALID=='yes') {
				window.location.replace("enquiry");
			} 
			$("#divLoading").removeClass('show');
		},
		error: function (){}
	});

}