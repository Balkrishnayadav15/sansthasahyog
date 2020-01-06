var currentUser = sessionStorage.getItem("LOGGED_IN_USER");

$(document).ready(function(){
	$("#divLoading").addClass('show');
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

function userDetails(id){
	$('#'+id).toggle();
}

function logout(){
	sessionStorage.clear();
	window.location.replace("login.html");
}