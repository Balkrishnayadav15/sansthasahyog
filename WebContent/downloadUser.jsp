<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Sanstha Sahyog</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
    <!-- CSS here -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="css/register.css">
     <link rel="stylesheet" href="css/loader.css">
     <link rel="stylesheet" href="css/download.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
     <style>
     *, ::after, ::before {
    box-sizing: unset !important;
}
     </style>
</head>

<body>
        <div id="divLoading"> 
        </div>
  <jsp:include page="header.jsp" /> 
    <!-- header-end -->

    <!-- slider_area_start -->
     <div class="logout_class" style="display:none;padding:0 10px 0 0;"><a style="color: white;cursor: pointer;" onclick="logout()">Logout</a></div>
	<div class="main">
    <div class="container" style="padding-bottom:50px">
        <jsp:include page="adminHeader.jsp" />
        <div class="panel panel-primary" id="PendingUList" >
					    <div class="panel-heading">
					      <h2 class="adminHeader" style="text-transform: inherit;">Please check the fields that you wants to download</h2>
					 	  <h4 id = "error" style="text-transform: inherit;color:red;display:none;">Please select atleast one field for download</h4>
					    
					    </div>
					    <div class="panel-body">
							    <input type="checkbox" class="user-select" name="user" id="userId" value="User Id">
							    <label class="user-select">User Id</label>
								<br>
							    <input type="checkbox" class="user-select" name="user" id="institueName" value="Institute Name">
							    <label class="user-select" >Institute/Firm Name</label>
							    <br>
							    <input type="checkbox" class="user-select" name="user" id="institueAddress" value="Institute Address">
							    <label class="user-select" >Institute/Firm Address</label>
							    <br>
							     <input type="checkbox" class="user-select" name="user" id="establishedYear" value="Institute Established Year">
							    <label class="user-select" >Institute/Firm Established Year</label>
						   		 <br>
							     <input type="checkbox" class="user-select" name="user" id="userType" value="User Type">
							     <label class="user-select" >User Type</label>
							      <br>
							     <input type="checkbox" class="user-select" name="user" id="username" value="User Name">
							    <label class="user-select" >User Name</label>
							     <br>
							     <input type="checkbox" class="user-select" name="user" id="gender" value="Gender">
							    <label class="user-select" >Gender</label>
							     <br>
							     <input type="checkbox" class="user-select" name="user" id="residentialAddress" value="Residential Address">
							    <label class="user-select" >Residential Address</label>
							     <br>
							     <input type="checkbox" class="user-select" name="user" id="userMobile" value="Mobile">
							    <label class="user-select" >Mobile</label>
							     <br>
							     <input type="checkbox" class="user-select" name="user" id="dob" value="Date Of Birth">
							    <label class="user-select" for="userId">Date of Birth</label>
							     <br>
							     <input type="checkbox" class="user-select" name="user" id="userpincode" value="Pincode">
							    <label class="user-select" >Pincode</label>
							     <br>
							     <input type="checkbox" class="user-select" name="user" id="emaildId" value="Emaild Id">
							    <label class="user-select" >Email Id</label>
							     <br>
							     <input type="checkbox" class="user-select" name="user" id="diseCode" value="Dise Code">
							    <label class="user-select" >Dise Code</label>
							     <br>
							     <input type="checkbox" class="user-select" name="user" id="affCode" value="Affiliation Code">
							    <label class="user-select" >Affiliation Code</label>
							     <br>
							     <input type="checkbox" class="user-select" name="user" id="registrationFees" value="Registration Fees">
							    <label class="user-select" >Registration Fees</label>
							     <br>
							     <input type="checkbox" class="user-select" name="user" id="status" value="Status">
							    <label class="user-select" >Status</label>
							    <br>
							    <br>
					           	<button onclick="download()" class="btn btn-dark" style="margin-left: 10px">Download</button>
						   
						   	</div>
					    </div>
	</div>
 
    </div>
	
    <!-- slider_area_end -->
	
    <!-- footer_start -->
    <jsp:include page="footer.jsp" />  

    <!-- footer_end -->


    <!-- JS here -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/admin.js"></script>
     <script src="js/register.js"></script>
</body>

</html>