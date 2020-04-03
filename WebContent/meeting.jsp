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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/aboutUs.css">
</head>

<body>
  
   <jsp:include page="header.jsp" />  
    <!-- header-end -->
     <div class="about-box-main">
        <div class="container" style="padding-bottom: 80px;">
  <!-- Start manage meeting history section -->
       		<div class="row">
       			<div class="col-lg-12">
					    <div class="panel-heading">
					      <h2 class="meetingHeader" style="padding-bottom: 30px;color:#1714d2">Welcome to Meeting Desk</h2>
					    </div>
				</div> 
		   </div>
		  
				<div class="row">
					<div class="col-lg-2" style="background-color: #fbf3f4;padding-top:20px;text-align:center;">
						<h2 class="tableHeader" style="color:#e81131;font-size: 22px;font-weight: bold;">Meeting Id</h2>
					</div>
					<div class="col-lg-2" style="background-color: #f9e4e7;;padding-top:13px;text-align:center;">
						<h2 class="tableHeader" style="color:#e81131;font-size: 22px;font-weight: bold;">Date and Time</h2>
					</div>
					<div class="col-lg-2" style="background-color: #f9d1d7;;padding-top:20px;text-align:center;">
						<h2 class="tableHeader" style="color:#e81131;font-size: 22px;font-weight: bold;">Topic</h2>
					</div>
					<div class="col-lg-2" style="background-color: #f193a1;padding-top: 20px;text-align:center;">
						<h2 class="tableHeader" style="color:#fbf3f4;font-size: 22px;font-weight: bold;">Documents</h2>
					</div>
					<div class="col-lg-2" style="background-color: #f3687c;padding-top:20px;text-align:center;">
						<h2 class="tableHeader" style="color:#fbf3f4;font-size: 22px;font-weight: bold;">Venue</h2>
					</div>
					<div class="col-lg-2" style="background-color: #b10b23;padding-top:20px;text-align:center;">
						
					</div>
					
				</div>
				<%
				 	List<Meeting> meetingList = (List<Meeting>)request.getAttribute("MEETING_LIST");
					if(null!=meetingList){
						int i = 0;
						for(Meeting meeting:meetingList){
				 if(i%2 == 0){
				%>
				<div class="row">
				<%}else{ %>
				<div class="row" style="background-color: #ecd7d7;">
				<% } %>
					<div class="col-lg-2" style="padding-top:20px;text-align:center;">
						<%=meeting.getMeetingId() %>
					</div>
					<div class="col-lg-2" style="padding-top:13px;text-align:center;">
						<%=meeting.getMeetingDate() %> &nbsp; <%=meeting.getMeetingTime() %>
					</div>
					<div class="col-lg-2" style="padding-top:20px;text-align:center;">
						<%=meeting.getTopic() %>
					</div>
					
					
					<div class="col-lg-2" style="padding: 5px">
					<%
							List<String> ncDoc = (List<String>)meeting.getNonConfiPaperName();
							if(null != ncDoc && ncDoc.size() > 0){
								for(String ncName : ncDoc){
						%>
						<a style="word-break: break-all;color: blue;font-weight: bold;" target="_blank" href="downloadFile?fileName=<%=ncName %>&meetingId=<%=meeting.getMeetingId() %>&fileType=nonConfidential" ><%=ncName %></a>
						<br>
						<%
							}	}
						%>
					</div>
					<div class="col-lg-2" style="padding-top:20px;text-align:center;">
						<%=meeting.getVenue() %>
					</div>
					
					<div class="col-lg-2">
						<% if("N".equals(meeting.getStatus())) {%>
						<img style="width: 91px;height: 70px;padding-left: 10px;" src="img/new.gif">
					<% } %>
					</div>
				</div>
				
					
				<%
				i++;}}
				%>
		</div>
		</div>		
			</div>		
		<!-- End manage meeting history section -->
    <!-- footer_start -->
    <footer class="footer">
        <div class="footer_top">
            <div class="container">
                <div class="row">
                    <div class="col-xl-4 col-md-6 col-lg-3">
                        <div class="footer_widget">
                            <div class="footer_logo">
                                <a href="index.jsp">
                                   <!-- <img src="img/Logo.png" alt="">-->
                                </a>
                            </div>
                            <p class="footer_text">416 Bhagirath Pura, Indore, M.P<br>
                                8109033456, 9827016480, 9977866588<br>
                                <a class="domain" href="#">vijay.dubey@sansthasahyog.com</a></p>
                            <div class="socail_links">
                                <ul>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-facebook"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-twitter"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-instagram"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-6 col-lg-2">
                        <div class="footer_widget">
                            <h3 class="footer_title">
                                    Userfull Area
                            </h3>
                            <ul>
                                <li><a href="#">Advertisment Area
                                    </a></li>
                                <li><a href="#">Academic Area</a></li>
                                <li><a href="#">Non Academic Area</a></li>
                                <li><a href="#">School Area</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-6 col-lg-2">
                        <div class="footer_widget">
                            <h3 class="footer_title">
                                    Useful Links
                            </h3>
                            <ul>
                                <li><a href="#">About</a></li>
                                <li><a href="#">Blog</a></li>
                                <li><a href="#"> Contact</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-xl-4 col-md-6 col-lg-4">
                        <div class="footer_widget">
                            <h3 class="footer_title">
                                    Subscribe
                            </h3>
                            <form action="#" class="newsletter_form">
                                <input type="text" placeholder="Enter your mail">
                                <button type="submit">Sign Up</button>
                            </form>
                            <p class="newsletter_text">Subscribe newsletter to get updates</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       
    </footer>
    <!-- footer_end -->


    <!-- JS here -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>

</body>

</html>