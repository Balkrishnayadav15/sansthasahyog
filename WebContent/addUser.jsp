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
       <style>
     *, ::after, ::before {
    box-sizing: unset !important;
}
@media screen and (max-width: 992px) {
.form-row{
	padding: 0 25px 0 0;
}
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
    <div class="container">
     <jsp:include page="adminHeader.jsp" />
       <div class="signup-content">
                <div class="signup-img">
                    <img src="img/signup-img.jpg" alt="">
                </div>
               
                <div class="signup-form">
                 
                    <form method="POST" class="register-form" id="register-form">
                        <h2>Add Admin User</h2>
                        <div class="alert alert-danger" role="alert" id="login_error" style="display:none">
										  User is already exists in the system. Please add different user.
						</div>
                        <div class="form-row">
                            <div class="form-group-name">
                                <label for="name">User Id :</label>
                                <select name="userId" id="userId">
                                    <option value="0">Select User Id</option>
                                    <% 
                                    
                                    List<String> userIds = (List<String>)request.getAttribute("REG_IDS");
                                    	if(null != userIds){
                                    		for(String userId : userIds){
                                    %>
									<option value="<%=userId %>"><%=userId %></option>
									<% 
                                    	}}
									%>
								</select>
                                 <div class="alert alert-danger" role="alert" id="userId_error" style="display:none">
										  Please enter User id.
						</div>
                            </div>
                            
                        </div>
						<div class="form-row">
							<div class="form-group-name">
                                <label for="password">Password :</label>
                                <input type="password" name="password" id="password"/>
                                 <div class="alert alert-danger" role="alert" id="password_error" style="display:none">
										  Please enter password.
								</div>
                            </div>
						</div>
						<div class="form-row">
							<div class="form-group-name">
                                <label for="password">Confirm Password :</label>
                                <input type="password" name="confirm_password" id="confirm_password"/>
                                 <div class="alert alert-danger" role="alert" id="confirm_password_error" style="display:none">
										  Password is not matching.
								</div>
								 <div class="alert alert-danger" role="alert" id="confirm_password_empty_error" style="display:none">
										  Password enter confirm password.
								</div>
                            </div>
						</div>
						 <div class="form-group">
                                <label for="userType">Select User Type :</label>
                                <div class="form-select">
                                    <select name="userType" id="userType">
                                        <option value="0">Select User Type</option>
                                        <option value="Admin">Admin</option>
                                        <option value="Non Admin">Non Admin</option>
                                    </select>
                                    <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                                </div>
                                 <div class="alert alert-danger" role="alert" id="userType_error" style="display:none">
									  Please select User Type.
									</div>
                            </div>
                        <div class="form-submit">
                            <input type="button" value="Add" class="submit" name="add_admin" id="add_admin" />
                        </div>
                    </form>
                </div>
            </div>
            
            <% 
       			List<User> userList = (List<User>) request.getAttribute("ALL_ADMIN");
       		%>
       		 <div class="panel panel-primary" style="padding-bottom: 50px;">
					    <div class="panel-heading">
					      <h2>User List</h2>
					    </div>
					    <div class="panel-body">
					      <table class="table table-striped">
					        <thead>
					          <tr>
					            <th>User Id</th>
					            <th>User Type</th>
					            <th>Password</th>
					          </tr>
					        </thead>
					        <tbody>
					        <% if(userList != null ){for(User user:userList){%>
					          <tr>
					            <td><%if(null != user.getName()) { %><%=user.getName() %><%} %></td>
					            <td><%if(null != user.getUserType()) {%><%=user.getUserType() %>  <%} %></td>
					            <td><%if(null != user.getPassword()) { %><%=user.getPassword() %><%} %></td>
					           
					          </tr>
					         <% }} %>
					        </tbody>
					      </table>
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
 <!--    <script src="js/login.js"></script> -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
     <script src="js/addUser.js"></script>
    
 <!-- <link rel="stylesheet" href="css/responsive.css"> -->

</body>

</html>