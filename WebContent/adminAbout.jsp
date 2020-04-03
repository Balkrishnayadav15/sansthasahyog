<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  
    import="java.util.*, com.sanstha.sahyog.model.*"
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
       <link rel="stylesheet" href="css/aboutUs.css">
     <link rel="stylesheet" href="css/loader.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
     <style>
     *, ::after, ::before {
    box-sizing: unset !important;
}
tr:nth-child(even) {background-color: #f2f2f2;}
     </style>
     <script>
		if ( window.history.replaceState ) {
		  window.history.replaceState( null, null, window.location.href );
		}
	        </script>
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
       			String isSaved = (String) request.getAttribute("ABOUT_US_SAVE");
       			String type = (String) request.getAttribute("TYPE");
       			String edited=(String)request.getAttribute("EDITED");
       			String delted=(String)request.getAttribute("DELETED");
       		%>
  	<!-- Start list of enquires -->
       		<div class="panel panel-primary"  style="min-height: 200px;" id="EnquiryUList">
					    <div class="panel-heading">
					    <% if("history".equals(type)) { %>
					      <h2 class="adminHeader">Add About Us History</h2>
					    <%}else if("electionRules".equals(type)) {%>
					      <h2 class="adminHeader">Add About Us Election Rules</h2>
					    <%}else if("duties".equals(type)) {%>
					      <h2 class="adminHeader">Add About Us Duties
					      </h2>
					    <%} %>
						</div>
									<% if("SAVED".equals(isSaved)){ %>
										<h2 style="color:red;">Saved About Us information successfully.</h2>
									<%} %>
										<div class="latest-news">
											<form method="POST" action="aboutUs" class="latest-news" id="register-form">
												<div class="form-row">
													<div class="form-group-name">
														<label for="name"> Header :</label> 
														<input type="text" name="header" id="header"  style="width:40%;"/>
														<div class="alert alert-danger" role="alert"
															id="userId_error" style="display: none">Please enter
															 Header.</div>
													</div>
			
												</div>
												<div class="form-row">
													<div class="form-group-name">
														<label for="name"> Body :</label>
														 <textarea id="body" name="body"  style="width:500px;height:200px;"></textarea>
														<div class="alert alert-danger" role="alert"
															id="newsBody_error" style="display: none">Please enter
															 Body.</div>
													</div>
												</div>
												 <% if("history".equals(type)) { %>
													<input type="hidden" name="type" value="history">
												    <%}else if("electionRules".equals(type)) {%>
													<input type="hidden" name="type" value="electionRules">
												    <%}else if("duties".equals(type)) {%>
													<input type="hidden" name="type" value="duties">
												    <%} %>
												<div class="form-submit">
													<input type="submit" value="Add" class="addHistory" />
												</div>
											</form>
										</div>
									
								</div>
				</div>
       		<!-- End list of enquires -->
       	
       
       	<div>
       		 <% if("history".equals(type)) { %>
				 <h2 class="adminHeader manageHeading">Manage About Us History</h2>
				 <%if("EDITED".equals(edited)){ %>
				 	<h2 style="color:red;">History Edited successfully.</h2>
				  <%}else if(("DELETED").equals(delted)){ %>
				 	<h2 style="color:red;">History Deleted successfully.</h2>
				 <%} %>
			 <%}else if("electionRules".equals(type)) {%>
				 <h2 class="adminHeader manageHeading">Manage About Us Election Rules</h2>
				 <%if("EDITED".equals(edited)){ %>
				 	<h2 style="color:red;">Election Rules Edited successfully.</h2>
				  <%}else if(("DELETED").equals(delted)){ %>
				 	<h2 style="color:red;">Election Rules Deleted successfully.</h2>
				 <%} %>
				 
			<%}else if("duties".equals(type)) {%>
				 <h2 class="adminHeader manageHeading">Manage About Us Duties</h2>
				 <%if("EDITED".equals(edited)){ %>
				 	<h2 style="color:red;">Duties Edited successfully.</h2>
				 <%}else if(("DELETED").equals(delted)){ %>
				 	<h2 style="color:red;">Duties Deleted successfully.</h2>
				 <%} %>
			 <%} %>
			 <div class="row">
				   <div class="col-lg-2">
				   	 <h2 style="color:#2a1ee6;margin-bottom:0px;">Header</h2>
				   </div>
				   <div class="col-lg-7">
				   	 <h2 style="color:#2a1ee6;margin-bottom:0px;">Body</h2>
				   </div>
				   <div class="col-lg-2">
				   </div>
			</div>
		<%
			List<Map<String,String>> aboutUs = (List<Map<String,String>>)request.getAttribute("ABOUT-US");
       		//int row = 0;   
       	    for (int i=0;i<aboutUs.size();i++) {
       	    	String id = (String)aboutUs.get(i).get("id"); 
				if(i%2 == 0){
				%> 
				   <div class="row action-button-even">
				   <div class="col-lg-2">
		                     <h2 class="noo-sh-title-top headerTagAdmin-even"><%=aboutUs.get(i).get("header") %></span></h2>
		                </div>
		                <div  class="col-lg-7">
		               		 <p class="bodyTag-even"><%=aboutUs.get(i).get("body") %></p>
		                </div>
		                 <div class="col-lg-2">
		                  <div class="input-group">
							  <div class="input-group-append action-even" >
							    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action</button>
							    <div class="dropdown-menu">
							      <a class="dropdown-item" href="#"  data-toggle="modal" data-target="#edit_form_<%=i%>">Edit</a>
							      <a class="dropdown-item" href="#" onclick="deleteInformation('<%=id%>','<%=type%>')"">Delete</a>
							    </div>
							  </div>
							</div>
		                </div>
           			 </div>
				<%
					}else{
				%>
					<div class="row action-button-odd">
					 <div class="col-lg-2">
		                     <h2 class="noo-sh-title-top headerTagAdmin-odd"><%=aboutUs.get(i).get("header") %></span></h2>
		                </div>
		                <div  class="col-lg-7">
		               		 <p class="bodyTag-odd"><%=aboutUs.get(i).get("body") %></p>
		                </div>
		                 <div class="col-lg-2">
		                  <div class="input-group">
							  <div class="input-group-append" >
							    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action</button>
							    <div class="dropdown-menu">
							      <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_form_<%=i%>">Edit</a>
							      <a class="dropdown-item" href="#" onclick="deleteInformation('<%=id%>','<%=type%>')">Delete</a>
							    </div>
							  </div>
							</div>
		                </div>
		             </div>
				<%
					}
				%>
				<!-- Start Enquiry Modal Modal -->
					  <div id="edit_form_<%=i%>" class="modal fade" style="z-index:1000000000;" role="dialog">
					    <div class="modal-dialog">
					        <!-- Modal content-->
					        <div class="modal-content enquiry-form">
					            <div class="modal-body">
					                <button type="button" class="close" data-dismiss="modal">&times;</button>
					             <div id="success_message" style="width:80%; height:100%; display:none;color:#fff; "> <h3 style="font-weight: bold;color: #ad1616;font-family: monospace;">Sent your enquiry successfully!</h3> </div>
					             <div id="error_message" style="width:80%; height:100%; display:none;color:red "> <h3 style="font-weight: bold;color: red;font-family: monospace;">Error! Sorry there was an error sending your enquiry.</h3> </div>
					            
					                <form action="aboutUs" method="post">
								       		 <% if("history".equals(type)) { %>
													<h4><label  class="enqiry-font" style="font-weight: bold;font-size: 31px;color: #3a19bdb8;">Edit history</label></h4>
											 <%}else if("electionRules".equals(type)) {%>
													<h4><label  class="enqiry-font" style="font-weight: bold;font-size: 31px;color: #3a19bdb8;">Edit election rules</label></h4>
											<%}else if("duties".equals(type)) {%>
													<h4><label  class="enqiry-font" style="font-weight: bold;font-size: 31px;color: #3a19bdb8;">Edit duties</label></h4>
											 <%} %>
											
					               		<div class="form-group">
					                        <label for="name" class="enqiry-font"> Header:</label>
					                        <input type="text" class="form-control" style="width:80%;" id="header_<%=i%>" name="header" value="<%=aboutUs.get(i).get("header") %>">
					                    </div>
					               		<div class="form-group">
					                        <label for="name" class="enqiry-font"> Body :</label>
											<textarea id="body_<%=i%>" name="body"  style="width:84%;height:200px;"><%=aboutUs.get(i).get("body") %></textarea>
					                    </div>
					                     <% if("history".equals(type)) { %>
													<input type="hidden" name="type" value="history">
												    <%}else if("electionRules".equals(type)) {%>
													<input type="hidden" name="type" value="electionRules">
												    <%}else if("duties".equals(type)) {%>
													<input type="hidden" name="type" value="duties">
												    <%} %>
										 <input type="hidden" name="id" value="<%=id%>">
										 <input type="hidden" name="_method" value="PUT">
					                    <input type="submit" class="btn btn-lg btn-danger btn-block" style="width: 15%;" id="btnContactUs" value="Update">
					                </form>
					            </div>
					        </div>
					    </div>
					</div>
 			<!-- End Enquiry Modal Modal -->					                     
          <%
       		} 
          %>
       	</div>
       	</div>
       	</div>	
       	
    <!-- footer_start -->
   <jsp:include page="footer.jsp" />  

    <!-- footer_end -->

    <!-- JS here -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/register.js"></script>
    <script src="js/aboutUs.js"></script>
     
</body>

</html>