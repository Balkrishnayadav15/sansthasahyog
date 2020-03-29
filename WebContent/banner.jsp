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
			
  	<!-- Start list of Gallery admin -->
       		
       			<div class="container">
       				<div class="row">
       					<div class="col-lg-12 col-md-12 col-xs-12">
						    <div>
						      <h2 class="adminHeader">Upload Banner Image</h2>
						    </div>
						    <%
								      String isSave = (String)request.getAttribute("IS_IMG_SAVED");
								      	if(null != isSave && "YES".equals(isSave)){
								      %>
								      <div id="success_message" style="color:red "> <h3 style="font-weight: bold;color: red;font-family: monospace;">Banner image Saved successfully
								      </h3> </div>
							<% } %>
						  <form method="post" action="banner" enctype="multipart/form-data">
						    <div>
						      <input id="gallery_file" type="file" name="image" style="width:25%"/>
						    </div>
						     <div style="width:15%;margin-top:15px">
						      <input id="submit_image" type="submit" name="image" class="btn btn-info" value="Upload"/>
						    </div>
						  </form>
						</div>
						<hr>
						<div class="col-lg-12 col-md-12 col-xs-12" style="border-top-style:solid">
								 	<div>
								      <h2 class="adminHeader">View Banner Image</h2>
								      <%
								      String isDelete = (String)request.getAttribute("IS_IMG_DELETE");
								      	if(null != isDelete && "YES".equals(isDelete)){
								      %>
								      <div id="success_message" style="width:100%; height:100%;color:red "> <h3 style="font-weight: bold;color: red;font-family: monospace;">Banner image deleted successfully
								      </h3> </div>
								      <% } %>
								    </div>
								    <div class="form-row">
			                            <div class="form-group-name">
			                                <select name="galleryImgId" id="galleryImgId" style="width:20%">
			                                    <option value="0">Select Image Id</option>
			                                    <% 
			                                    	List<String> imageIds = (List<String>)request.getAttribute("GALLERY_IMG_IDS");
			                                    	if(null != imageIds){
			                                    		for(String imageId : imageIds){
			                                    %>
												<option value="<%=imageId %>"><%=imageId %></option>
												<% 
			                                    	}}
												%>
											</select>
			                            </div>
			                        </div>
			                        <%
									Gallery gl = (Gallery)request.getAttribute("GALLERY_IMG");
									if(null != gl){
								%>
						    	<div style="padding:20px">
						     		 <img src="data:image/jpg;base64,<%=gl.getBase64Image() %>" width="240" height="300"/>
						   		</div>
						   		<div style="width:15%;margin-top:15px">
						   			<button onclick="deleteImage()" class="btn btn-danger" style="margin-left: 10px;float: right;">Delete</button>								    
									<button onclick="viewImage()" class="btn btn-info" style="margin-left: 10px;float: right;">View</button>								    
			                     </div> 
								<%
									}
								%>
			                    
		                     </div>   
						</div>
					</div>
				</div>
			</div>
       		<!-- End list of Gallery admin -->
       		
    <!-- footer_start -->
    <jsp:include page="footer.jsp" />  

    <!-- footer_end -->


    <!-- JS here -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/banner.js"></script>
     <script src="js/register.js"></script>
</body>

</html>