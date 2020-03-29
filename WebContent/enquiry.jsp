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
       			List<Enquiry> allEnquiry = (List<Enquiry>) request.getAttribute("ALL_ENQUIRY");
       			
       		%>
       

  	<!-- Start list of enquires -->
       		<div class="panel panel-primary"  style="min-height: 200px;"id="EnquiryUList">
					    <div class="panel-heading">
					      <h2 class="adminHeader">Enquires List</h2>
					    </div>
					    <div class="panel-body">
					      <table class="table table-striped">
					        <thead>
					          <tr>
					            <th>Enquiry Id</th>
					            <th>Name</th>
					            <th class="hideDTEle">Mobile Number</th>
					       	
					          </tr>
					        </thead>
					        <tbody>
					        <% if(null != allEnquiry){
					        	int color = 0;
					        for(Enquiry user:allEnquiry){if(color%2 == 0){
					        %>  
					          <tr>
					        <%}else{ %>
					         <tr style="background-color:#ec887d"> 
					        <% } color++; %>
					            <td><%=user.getEnquiryId() %></td>
					            <td><%=user.getName() %></td>
					            <td class="hideDTEle"><%=user.getMobileNo() %></td>
					            
					            <td>
					                <button onclick="userDetails('<%=user.getEnquiryId()%>','enquiry')" class="btn btn-info hideDTEle" style="margin-left: 10px">Details</button>
					           		<button onclick="userDetails('<%=user.getEnquiryId()%>','enquiry')" class="btn-xs btn-info" style="margin-left: 10px">Details</button>
					            </td>
					          </tr>
					          <tr id="enquiry_<%=user.getEnquiryId() %>" style="display:none">
					          	<td colspan="5">
					          		<div>
								   		<button onclick="rejectEnquiry('<%=user.getEnquiryId()%>')" class="btn btn-danger" style="margin-left: 10px;float: right;">Reject</button>
								    </div>
								    
								    <div id="enquiry_details_<%=user.getEnquiryId() %>">
						          	 	 <div style="margin-top: 42px;">
										    <span><b>Name: </b></span> <span><%=user.getName() %></span>
										  </div>
										  <div>
										    <span><b>School Name: </b></span> <span><%=user.getSchoolName() %></span>
										  </div>
										  <div>
										    <span><b>Email Id: </b></span><span><%=user.getEmailid() %></span>
										  </div>  
										  <div>
										    <span><b>Mobile Number: </b></span> <span><%=user.getMobileNo() %></span>
										  </div> 
										  <div>
										    <span><b>Address: </b></span><span><%=user.getAddress() %></span>
										  </div> 
										  
									  </div> 
									  
					          	<td>
					          </tr>
					        <% }} %>
					        </tbody>
					      </table>
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
    <script src="js/enquiry.js"></script>
     <script src="js/register.js"></script>
</body>

</html>