<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  
    import="java.util.List, com.sanstha.sahyog.model.*"
    %>
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
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
     <style>
     *, ::after, ::before {
    box-sizing: unset !important;
}
tr:nth-child(even) {background-color: #f2f2f2;}
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
    <div class="container" style="padding-bottom:50px;min-height:350px">
			<jsp:include page="adminHeader.jsp" />
			
			<div>
       		<%
   			    //List of All Enquires
       			String isSaved = (String) request.getAttribute("HEADER_IMG");
       			
       		%>

  	<!-- Start list of enquires -->
       		<div class="panel panel-primary"  style="min-height: 200px;" id="EnquiryUList">
					    <div class="panel-heading">
					      <h2 class="adminHeader">Latest News on Home Page Load</h2>
						</div>
						
								<div class="panel-body" style="width:40%">
									<% if("SAVED".equals(isSaved)){ %>
										<h2 style="color:red;">Saved latest news successfully.</h2>
									<%} %>
										<div class="latest-news">
			
											<form method="POST" action="latestNews" class="latest-news" id="register-form">
												
											<!-- 	<input type="checkbox" class="user-select" name="user" id="showNews">
											    <label class="user-select">User Id</label>
												<br> -->
												<div class="form-row">
													<div class="form-group-name">
														<label for="name">News Header :</label> 
														<input type="text" name="newsHeader" id="newsHeader" />
														<div class="alert alert-danger" role="alert"
															id="userId_error" style="display: none">Please enter
															News Header.</div>
													</div>
			
												</div>
												<div class="form-row">
													<div class="form-group-name">
														<label for="name">News Body :</label>
														 <textarea id="newsBody" name="newsBody" style="width:500px;height:200px;"></textarea>
														<div class="alert alert-danger" role="alert"
															id="newsBody_error" style="display: none">Please enter
															News Body.</div>
													</div>
												</div>
			
												<div class="form-submit">
													<input type="submit" value="Send" class="submit" />
												</div>
											</form>
										</div>
									
								</div>
				</div>
       		<!-- End list of enquires -->
       	</div>
       	</div>
       	</div>	
    <!-- footer_start -->
   <jsp:include page="footer.jsp" />  

    <!-- footer_end -->


    <!-- JS here -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
     <script src="js/register.js"></script>
</body>

</html>