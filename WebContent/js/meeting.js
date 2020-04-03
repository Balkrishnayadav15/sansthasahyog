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

function logout(){
	sessionStorage.clear();
	window.location.replace("login.html");
}

function setupNewMeeting(){
	
	var meetdate = $('#meetdate').val();
	var hours = $('#hours').val();
	var minute = $('#minute').val();
	var periods = $('#periods').val();
	var meetvenue = $('#meetvenue').val();
	var meettopics = $('#meettopic').val();
	var isSubmit = false;
	 if(meetdate == '' || hours == '' || minute == '' || meetvenue == '' || meettopics == ''){
		 isSubmit = false;
	 }else{
		 isSubmit = true;
	 }
	
	if(isSubmit){
		document.getElementById("meetingForm").submit();
		$('#errorMsg').hide();
	}else{
		$('#errorMsg').show();
	}
}

