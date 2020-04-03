var currentUser = sessionStorage.getItem("LOGGED_IN_USER");

$(document).ready(function(){
	
});/**
 * 
 */
function logout(){
	sessionStorage.clear();
	window.location.replace("login.html");
}

function deleteInformation(id,type){

	var dataString = 'aboutUs?redirect=admin&_method=DELETE&id='+id+'&type='+type;
	
	window.location.replace(dataString);
}

