$(document).ready(function(){
	var id = '#dialog';
	
	//Get the screen height and width
	var maskHeight = $(document).height();
	var maskWidth = $(window).width();

	//Set heigth and width to mask to fill up the whole screen
	$('#mask').css({'width':maskWidth,'height':maskHeight});
	
	//transition effect		
	$('#mask').fadeIn(500);	
	$('#mask').fadeTo("slow",0.9);	

	//Get the window height and width
	var winH = $(window).height();
	var winW = $(window).width();
          
	//Set the popup window to center
	$(id).css('top',  winH/2-$(id).height()/2);
	$(id).css('left', winW/2-$(id).width()/2);

	//transition effect
	$(id).fadeIn(2000); 	

//if close button is clicked
$('.window .close').click(function (e) {
	//Cancel the link behavior
	e.preventDefault();
	
	$('#mask').hide();
	$('.window').hide();
});		

//if mask is clicked
$('#mask').click(function () {
	$(this).hide();
	$('.window').hide();
});	
});

function saveEnquiry(){
	
	 var name = document.getElementById("uname").value;
	 var schoolName = document.getElementById("iname").value;
	 var address = document.getElementById("address").value;
	 var email = document.getElementById("email").value;
	 var mobile = document.getElementById("mobile").value;
	 
	 if(name == null || name == '' || schoolName == null || schoolName == '' ||
			 address == null || address == '' ||
			 email == null || email == '' ||
			 mobile == null || mobile == ''){
		 return false;
	 }else{
		     var dataString = 'name='+ name + '&schoolName=' + schoolName+ '&address=' + address+ '&email=' + email + '&mobile=' + mobile ;
		     $("#divLoading").addClass('show');
		     
		     jQuery.ajax({
		         url: "/enquiry",
		         data: dataString,
		         type: "POST",
		         success: function(data){
		        	 var responseData = JSON.parse(data);
					 if(responseData.VALID=='yes') {
							 $("#error_message").hide();
				        	 $("#success_message").show();
					 }else{
						 $("#error_message").show();
			        	 $("#success_message").hide();
					 }
		         },
		         error: function (){}
		     });
	 }
}