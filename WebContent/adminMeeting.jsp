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
     <link rel="stylesheet" href="css/meeting.css">
    
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
       			List<Enquiry> allEnquiry = (List<Enquiry>) request.getAttribute("ALL_ENQUIRY");
       		%>
  	<!-- Start welcome meeting section -->
       		<div class="row">
       			<div class="col-lg-5">
					    <div class="panel-heading">
					      <h2 class="meetingHeader">Welcome to Meeting Desk</h2>
					    </div>
				</div>   
				<div class="col-lg-6 setupMeeting">
					   <button class="btn btn-danger" style="margin-left: 10px;float: right;" data-toggle="modal" data-target="#setup_meeting">Setup New Meeting</button>								    
				</div> 
		   </div>
		   <!-- Start setup meeting Modal -->
					  <div id="setup_meeting" class="modal fade" style="z-index:1000000000;" role="dialog">
					    <div class="modal-dialog">
					        <!-- Modal content-->
					       
					        <div class="modal-content enquiry-form">
					            <div class="modal-body">
					            <h2 class="messageText" style="display:none;">Set a new meeting form.</h2>
					            <h2 id="errorMsg" class="messageText" style="display:none;">Please fill the all mandatory fields.</h2>
					             <form id="meetingForm" action="meeting" method = "POST">
					               		<div class="form-group">
					                        <label for="name" class="formLables"> Meeting Date *:</label>
					                        <input type="date" class="form-control" style="width:80%;" id="meetdate" name="meetdate" >
					                    </div>
					                    <div class="form-group">
					                        <label for="name" class="formLables"> Meeting Time *:</label>
					                        <select id="hours" name="hours" style="width:10%;display:inline;">
					                        	<option value="">Hours</option>
					                        	<option value="1">1</option>
					                        	<option value="2">2</option>
					                        	<option value="3">3</option>
					                        	<option value="4">4</option>
					                        	<option value="5">5</option>
					                        	<option value="6">6</option>
					                        	<option value="7">7</option>
					                        	<option value="8">8</option>
					                        	<option value="9">9</option>
					                        	<option value="10">10</option>
					                        	<option value="11">11</option>
					                        	<option value="12">12</option>
					                        </select>
					                        <select id="minute" name="minute" style="width:5%;display:inline;">
					                            <option value="">Minutes</option>
					                        	<option value="00">00</option><option value="01">01</option><option value="02">02</option><option value="03">03</option>
					                        	<option value="04">04</option><option value="05">05</option><option value="06">06</option><option value="07">07</option>
					                        	<option value="08">08</option><option value="09">09</option><option value="10">10</option><option value="11">11</option>
					                        	<option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option>
					                        	<option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option>
					                        	<option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option>
					                        	<option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">26</option>
					                        	<option value="28">28</option><option value=29"">29</option><option value="30">30</option><option value="31">31</option><option value="32">32</option>
					                        	<option value="33">33</option><option value="34">34</option><option value="35">35</option><option value="36">36</option>
					                        	<option value="37">37</option><option value="38">38</option><option value="39">39</option><option value="40">40</option><option value="41">41</option>
					                        	<option value="42">42</option><option value="43">43</option><option value="44">44</option><option value="45">45</option><option value="46">46</option>
					                        	<option value="47">47</option><option value="48">48</option><option value="49">49</option><option value="50">50</option>
					                        	<option value="51">51</option><option value="52">52</option><option value="53">53</option><option value="54">54</option>
					                        	<option value="55">55</option><option value="56">56</option><option value="57">57</option><option value="58">58</option>
					                        	<option value="59">59</option>
					                        </select>
					                        <select id="periods" name="periods" style="width:5%;display:inline;">
					                        	<option value="AM">AM</option>
					                        	<option value="PM">PM</option>
					                        </select>
					                    </div>
					                    <div class="form-group">
					                        <label for="name" class="formLables"> Meeting Topic *:</label>
					                        <input type="text" class="form-control" style="width:80%;" id="meettopic" name="meettopic" >
					                    </div>
					                    <div class="form-group">
					                        <label for="name" class="formLablest"> Meeting Venue/Address *:</label>
					                        <textarea id="meetvenue" name="meetvenue"  style="width:84%;height:100px;"></textarea>
					                    </div>
					            </form>
					            <button class="btn btn-danger" style="margin-left: 10px;" onclick="setupNewMeeting()" >Set New Meeting</button>								    
					            
					            </div>
					        </div>
					    </div>
					</div>
					
 			<!-- End setup meeting modal-->	
    <!-- End welcome meeting section -->
    
    <!-- Start manage meeting history section -->
       		<div class="row">
       			<div class="col-lg-12">
					    <div class="panel-heading">
					      <h2 class="meetingHeader">Manage Meeting History</h2>
					    </div>
				</div> 
		   </div>
		   <%
		   	String isSave = (String)request.getAttribute("MESSAGE");
			String meetingId = (String)request.getAttribute("MEETING_ID");
			
			
		   if("SAVED".equals(isSave)){
		   %>
		     <div class="row">
		   		<h2 style="color:red;padding-left:20px;"><%=meetingId %> set up successfully.</h2>
		     </div>
		   <%}else 	if("NOTPDF".equals(isSave)){ %>
			     <div class="row">
			   		<h2 style="color:red;padding-left:20px;">Please upload only PDF files.</h2>
			     </div>
		   <%}else if("EXCEED".equals(isSave)){ %>
				 <div class="row">
				   		<h2 style="color:red;padding-left:20px;">File can not be more than 5MB.</h2>
				  </div>
			<%}else if("FILENOTFOUND".equals(isSave)){ %>
				     <div class="row">
				   		<h2 style="color:red;padding-left:20px;">Please upload file.</h2>
				     </div>
		    <%} %>
				<div class="row">
					<div class="col-lg-1" style="background-color: #fbf3f4;padding-top:20px;text-align:center;">
						<h2 class="tableHeading" style="color:#e81131">Meeting Id</h2>
					</div>
					<div class="col-lg-1" style="background-color: #f9e4e7;;padding-top:13px;text-align:center;">
						<h2 class="tableHeading" style="color:#e81131">Date and Time</h2>
					</div>
					<div class="col-lg-1" style="background-color: #f9d1d7;;padding-top:20px;text-align:center;">
						<h2 class="tableHeading" style="color:#e81131">Topic</h2>
					</div>
					<div class="col-lg-1" style="background-color: #fdbfc8;;padding-top:10px;text-align:center;">
						<h2 class="tableHeading" style="color:#e81131">Attendance Sheet</h2>
					</div>
					<div class="col-lg-1" style="background-color: #f7aeb9;padding-top: 10px;text-align:center;">
						<h2 class="tableHeading" style="color:#fbf3f4">Confidential Papers</h2>
					</div>
					<div class="col-lg-1" style="background-color: #f193a1;text-align:center;">
						<h2 class="tableHeading" style="color:#fbf3f4">Non Confidential Papers</h2>
					</div>
					<div class="col-lg-1" style="background-color: #f3687c;padding-top:20px;text-align:center;">
						<h2 class="tableHeading" style="color:#fbf3f4">Venue</h2>
					</div>
					<div class="col-lg-1" style="background-color: #e81131;;padding-top:20px;text-align:center;">
						<h2 class="tableHeading" style="color:#fbf3f4">Operation</h2>
					</div>
					<div class="col-lg-1" style="background-color: #9c031a;;padding-top:20px;text-align:center;">
						<h2 class="tableHeading" style="color:#fbf3f4"></h2>
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
					<div class="col-lg-1" style="padding-top:20px;text-align:center;">
						<%=meeting.getMeetingId() %>
					</div>
					<div class="col-lg-1" style="padding-top:13px;text-align:center;">
						<%=meeting.getMeetingDate() %> &nbsp; <%=meeting.getMeetingTime() %>
					</div>
					<div class="col-lg-1" style="padding-top:20px;text-align:center;">
						<%=meeting.getTopic() %>
					</div>
					<div class="col-lg-1" style="padding-top:10px;text-align:center;">
						<%
							List<String> attendanceS = (List<String>)meeting.getAttendanceSName();
							if(null != attendanceS && attendanceS.size() > 0){
								for(String atName : attendanceS){
						%>
						<a style="word-break: break-all;color: blue;font-weight: bold;" target="_blank" href="downloadFile?fileName=<%=atName %>&meetingId=<%=meeting.getMeetingId() %>&fileType=attendance" ><%=atName %></a>
						<br>
						<%
							}	}
						%>
					</div>
					<div class="col-lg-1" style="">
					<%
							List<String> confDoc = (List<String>)meeting.getConfiPaperName();
							if(null != confDoc && confDoc.size() > 0){
								for(String cName : confDoc){
						%>
						<a style="word-break: break-all;color: blue;font-weight: bold;" target="_blank" href="downloadFile?fileName=<%=cName %>&meetingId=<%=meeting.getMeetingId() %>&fileType=confidential" ><%=cName %></a>
						<br>
						<%
							}	}
						%>
					</div>
					<div class="col-lg-1" style="">
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
					<div class="col-lg-1" style="padding-top:20px;text-align:center;">
						<%=meeting.getVenue() %>
					</div>
					<div class="col-lg-1" style="padding: 10px;text-align:center;">
						<div class="input-group">
							  <div class="input-group-append action-even" >
							    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action</button>
							    <div class="dropdown-menu">
							      <a class="dropdown-item" href="#"  data-toggle="modal" data-target="#upload<%=meeting.getMeetingId() %>">Upload</a>
							      <a class="dropdown-item" href="#" onclick="deleteInformation('')"">Edit</a>
							    </div>
							  </div>
							  
							</div>			
					</div>
					<div class="col-lg-1">
					<% if("N".equals(meeting.getStatus())) {%>
						<img style="width: 91px;height: 70px;padding-left: 10px;" src="img/new.gif">
					<% } %>
					</div>
				</div>
				
				<!-- Start Upload Docs Modal -->
					  <div id="upload<%=meeting.getMeetingId() %>" class="modal fade" style="z-index:1000000000;" role="dialog">
					    <div class="modal-dialog">
					        <!-- Modal content-->
					        <div class="modal-content enquiry-form">
					            <div class="modal-body">
					                <button type="button" class="close" data-dismiss="modal">&times;</button>
					             	<h2 class="formModalHeader">Upload documents related to Meeting id : <%=meeting.getMeetingId() %></h2>
					             	<br>
					                 <form method="post" action="meeting" enctype="multipart/form-data">
					                 	<input type="hidden" name="meetingId" value="<%=meeting.getMeetingId() %>">
					                 	<input type="hidden" name="type" value="upload">
					                 	<div>
					                 		<select name="fileType" style="width:50%;margin-bottom:15px">
					                 			<option value="">Select Upload File Type</option>
					                 			<option value="attendance">Attendance Sheet</option>
					                 			<option value="confidential">Confidential Paper</option>
					                 			<option value="nonConfidential">Non Confidential Paper</option>
					                 		</select>
					                 	</div>
									    <div>
									      <input id="file" type="file" name="uploadFile" style="width:75%"/>
									    </div>
									     <div style="width:15%;margin-top:15px">
									      <input id="uploadButton" type="submit" name="uploadButton" class="btn btn-info" value="Upload"/>
									    </div>
									  </form>
					            </div>
					        </div>
					    </div>
					</div>
 				  <!-- End Upload Docs Modal -->	
				<%
				i++;}}
				%>
				
					
		<!-- End manage meeting history section -->
    
       	</div>
       	</div>
       	</div>	
    <!-- footer_start -->
   <jsp:include page="footer.jsp" />  

    <!-- footer_end -->


    <!-- JS here -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
        <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/meeting.js"></script>
     <script src="js/register.js"></script>
</body>

</html>