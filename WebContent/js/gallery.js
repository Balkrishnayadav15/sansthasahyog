var currentUser = sessionStorage.getItem("LOGGED_IN_USER");
var currentUserType = sessionStorage.getItem("USER_TYPE");

$(document).ready(function(){
	$("#divLoading").addClass('show');
});

function logout(){
	sessionStorage.clear();
	window.location.replace("login.html");
}

function viewImage(){
	 var imgId = document.getElementById("galleryImgId").value;
	window.location.replace("gallery?imageId="+imgId+"&reqType=view");
}

function deleteImage(){
	 var imgId = document.getElementById("galleryImgId").value;
	window.location.replace("gallery?imageId="+imgId+"&reqType=delete");
}
