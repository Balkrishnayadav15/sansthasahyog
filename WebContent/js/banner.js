var currentUser = sessionStorage.getItem("LOGGED_IN_USER");
var currentUserType = sessionStorage.getItem("USER_TYPE");

$(document).ready(function(){
	$("#divLoading").addClass('show');
	/*if(currentUserType == 'Admin'){
		$("#adminUser").show();
	}else{
		$("#adminUser").hide();
	}*/
	
	/*$('#submit_image').click(function(){    
	    //on change event  
	    formdata = new FormData();
	    if($('#gallery_file').val().length > 0)
	    {
	        file =$('#gallery_file').val()[0];
	        formdata.append("image", file);
	        jQuery.ajax({
	            url: 'gallery',
	            type: "POST",
	            data: formdata,
	            processData: false,
	            contentType: false,
	            success: function (result) {
	            	var responseData = JSON.parse(result);
					if(responseData.VALID=='yes') {
						window.location.replace("gallery");
					}
	            }
	        });
	    }
	});*/
	
});

function logout(){
	sessionStorage.clear();
	window.location.replace("login.html");
}

function viewImage(){
	 var imgId = document.getElementById("galleryImgId").value;
	window.location.replace("banner?imageId="+imgId+"&reqType=view");
}

function deleteImage(){
	 var imgId = document.getElementById("galleryImgId").value;
	window.location.replace("banner?imageId="+imgId+"&reqType=delete");
}
