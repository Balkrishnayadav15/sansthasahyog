<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  
    import="java.util.*, com.sanstha.sahyog.model.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Sanstha Sahyog</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
    <!-- CSS here -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/home.css">
     <!-- Responsive CSS -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/custom.css">
        <link rel="stylesheet" href="css/all.css">
    
    
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>
<jsp:include page="/home.jsp" />
<jsp:include page="/bannerImg.jsp" />

<%
	Map<String,String> news = (Map<String,String>)request.getAttribute("LATESTNEWS");
%>
<body style="background-color:#000">
  <div id="pageLoad" class="modal fade">
    <div  class="modal-dialog">
        <div id="gradient" class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title pageLoad-header"><%=news.get("header") %></h4>
            </div>
            <div class="modal-body" style="min-height: 150px;">
                <p class="pageLoad-body"><%=news.get("body") %></p>
               
            </div>
        </div>
    </div>
</div>
 <!-- header-start -->
     <jsp:include page="header.jsp" /> 
    <!-- header-end -->
  <!--  Start banner part -->
	<div class="container banner-container">
			            <div class="row">
							<div class="col-lg-5">
			                    <div class="banner-frame"> <img class="img-fluid" src="img/banner/banner.png" alt="">
			                    </div>
			                </div>
			            <div class="col-lg-7 banner-carousel">
			                    <!-- Start Slider -->
			                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
									    <!-- Indicators -->
									    <ol class="carousel-indicators">
									      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
									      <li data-target="#myCarousel" data-slide-to="1"></li>
									      <li data-target="#myCarousel" data-slide-to="2"></li>
									    </ol>
									    <div class="carousel-inner">
									     <!-- Wrapper for slides -->
									     
										<%
								        	List<Gallery> bnList = (List<Gallery>)request.getAttribute("BANNER_IMG");
								            if(null != bnList){
								            	for(int i = 0;i<bnList.size();i++){
								            		if(i == 0){
								        %>
									      <div class="item active">
									    <%
									    	}else{
								         %>
								          <div class="item">
								         <%
									    	}
								         %>
									        <img src="data:image/jpg;base64,<%=bnList.get(i).getBase64Image() %>" alt="Los Angeles" style="width:100%;max-height:410px;">
									        <div class="carousel-caption">
										        <a href="#" class="boxed-btn4" data-toggle="modal" data-target="#enquiry_form">Enquiry Form</a>
												<a href="login.html" class="boxed-btn4">Login</a>
										     </div>
									      </div>
										<%
								           }}
										%>
									    </div>
									
									    <!-- Left and right controls -->
									    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
									      <span class="glyphicon glyphicon-chevron-left"></span>
									      <span class="sr-only">Previous</span>
									    </a>
									    <a class="right carousel-control" href="#myCarousel" data-slide="next">
									      <span class="glyphicon glyphicon-chevron-right"></span>
									      <span class="sr-only">Next</span>
									    </a>
									  </div>
					    <!-- End Slider -->
                </div>
            </div>
       </div>
       </div>
  <!--  End banner part -->
  <!-- Start Enquiry Modal Modal -->
  <div id="enquiry_form" class="modal fade 	" role="dialog" tabindex="-1">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content enquiry-form">
           
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                
             <div id="success_message" style="width:100%; height:100%; display:none;color:#fff; "> <h3 style="font-weight: bold;color: #ad1616;font-family: monospace;">Sent your enquiry successfully!</h3> </div>
             <div id="error_message" style="width:100%; height:100%; display:none;color:red "> <h3 style="font-weight: bold;color: red;font-family: monospace;">Error! Sorry there was an error sending your enquiry.</h3> </div>
            
                <form>
                <h4><label  class="enqiry-font" style="font-weight: bold;font-size: 31px;color: #3a19bdb8;">Enquiry Form</label></h4>
               		<div class="form-group">
                        <label for="name" class="enqiry-font"> User Name:</label>
                        <input type="text" class="form-control" id="uname" name="uname" required maxlength="50">
                    </div>
               		<div class="form-group">
                        <label for="name" class="enqiry-font"> Institute/Firm Name :</label>
                        <input type="text" class="form-control" id="iname" name="iname" required maxlength="150">
                    </div>
                    <div class="form-group">
                        <label for="address" class="enqiry-font">Address:</label>
                        <input type="text" class="form-control" id="address" name="address" required>
                    </div>
                    <div class="form-group">
                        <label for="email" class="enqiry-font">Email:</label>
                        <input type="email" class="form-control" id="email" name="email" required maxlength="50">
                    </div>
                    <div class="form-group">
                        <label for="name" class="enqiry-font"> Mobile No.:</label>
                        <input type="text" class="form-control" id="mobile" name="mobile" required maxlength="10">
                    </div>
                    <button type="button" class="btn btn-lg btn-danger btn-block" id="btnContactUs" onclick="saveEnquiry()">Send &rarr;</button>
                </form>
                <div id="success_message" style="width:100%; height:100%; display:none; "> <h3>Sent your message successfully!</h3> </div>
                <div id="error_message" style="width:100%; height:100%; display:none; "> <h3>Error</h3> Sorry there was an error sending your form. </div>
            </div>
        </div>
    </div>
</div>
 

    <!-- Start About Sanstha Sahyog services -->
 
    <div class="container">
    		<div class="row about-title">
                <div class="col-lg-12">
                    <div class="title-all text-center">
                        <h1 class="service-title">Why to come with Sanstha Sahyog.
                        </h1> 
                    </div>
                </div>
            </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/supplies.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">Reason to Join Sahyog</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/support.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">Attendance Sheet</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/parents.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">Current Targets & Applications</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/supplies.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">Media News - School & Education</a>
                </div>
            </div>
        </div>
        
        <div class="row service-2">
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/support.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">Affiliation Rules</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/parents.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">RTE Rules Desk</a>
                </div>
            </div>
             <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/supplies.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">Admin & Helpers</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/support.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">Education Rules Candidates</a>
                </div>
            </div>
        </div>
        
        <div class="row service-2">
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/parents.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">Government Rules & Regulations</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/supplies.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">Achievement</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/support.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">Awards & Criteria</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="img/parents.jpg" alt="" />
                    <a class="btn hvr-hover service-title" href="#">Nomination for Awards</a>
                </div>
            </div>
        </div>
        
        
    </div>
    <!-- End About Sanstha Sahyog services -->

	<!-- Start Award Recognition -->
	
	<div class="container award">
            <div class="row">
                <div class="col-lg-12">
                    <div class="title-all text-center">
                        <h1 class="service-title">Awards & Recognitions</h1>
                        <p class="service-title">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet lacus enim.</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-4 col-xl-4">
                    <div class="blog-box">
                        <div class="blog-img">
                            <img class="img-fluid" src="img/award-1.jpg" alt="" />
                        </div>
                      
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-4">
                    <div class="blog-box">
                        <div class="blog-img">
                            <img class="img-fluid" src="img/award-1.jpg" alt="" />
                        </div>
                       
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-4">
                    <div class="blog-box">
                        <div class="blog-img">
                            <img class="img-fluid" src="img/award-1.jpg" alt="" />
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
        
       <!--  End Award Recognition -->
       
     <!--   Start Gallery -->
       <div class="instagram-box">
        <div class="main-instagram owl-carousel owl-theme">
        <%
        	List<Gallery> lsList = (List<Gallery>)request.getAttribute("GALLERY_IMG");
            if(null != lsList){
            	for(Gallery gl:lsList){
        %>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="data:image/jpg;base64,<%=gl.getBase64Image() %>" alt="" style="height:270px;" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
         <%
            }}
         %>
          <!--   <div class="item">
                <div class="ins-inner-box">
                    <img src="img/gallery-2.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="img/gallery-3.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="img/gallery-4.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="img/gallery-1.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="img/gallery-2.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="img/gallery-3.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="img/gallery-4.jpg" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div> -->
           
        </div>
    </div>
    
     <!--   End Gallery -->
    <!-- footer_start -->
     <jsp:include page="footer.jsp" />  

    <!-- footer_end -->
    
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!-- JS here -->
    <script src="js/baguetteBox.min.js"></script>
     <script src="js/jquery.superslides.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="js/inewsticker.js"></script>
    <script src="js/bootsnav.js."></script>
    <script src="js/images-loded.min.js"></script>
    <script src="js/isotope.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    
    <script src="js/form-validator.min.js"></script>
    <script src="js/contact-form-script.js"></script>
    <script src="js/custom.js"></script>
    <script src="js/main.js"></script>
    
</body>

</html>