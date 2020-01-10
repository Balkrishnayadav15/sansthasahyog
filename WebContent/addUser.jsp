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
    <header>
        <div class="header-area ">
            <div id="sticky-header" class="main-header-area">
                <div class="container-fluid p-0">
                    <div class="row align-items-center justify-content-between no-gutters">
                        <div class="col-xl-2 col-lg-2">
                            <div class="logo-img">
                                <a href="index.jsp">
                                    <img src="img/Logo.png" alt="" style="height: 47px;width:316px">
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-7 col-lg-8">
                            <div class="main-menu  d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                        <li><a class="active" href="index.jsp">home</a></li>
                                        <li><a href="index.jsp">About</a></li>
                                        <li><a href="index.jsp">Advertisment Area</a></li>
                                        
                                        <li><a href="#">Gallery <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="index.jsp">Photos</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="index.jsp">Contact</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-2 d-none d-lg-block">
                            <div class="social_media_links">
                              <a style="color: white;cursor: pointer;" onclick="logout()">Logout</a>
                                <ul>
                                    <li><a href="#"> <i class="fa fa-facebook"></i> </a></li>
                                    <li><a href="#"> <i class="fa fa-twitter"></i> </a></li>
                                    <li><a href="#"> <i class="fa fa-instagram"></i> </a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- header-end -->

    <!-- slider_area_start -->
   <!--  <div class="logout_class" style="display:none;padding:0 10px 0 0;"><a style="color: white;cursor: pointer;" onclick="logout()">Logout</a><div> -->
	<div class="main">
    <div class="container">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                    <!-- Links -->
                    <ul class="navbar-nav">
                      <li class="nav-item">
                          <a  class="nav-link" href="admin">User List</a>
                      </li>
                      <li class="nav-item">
                    <a class="nav-link" href="registerform.jsp" >Register User</a>
                </li>
                    </ul>
                </nav>
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
                                <input type="text" name="userId" id="userId" />
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
    <footer class="footer">
        <div class="footer_top">
            <div class="container">
                <div class="row"  style="background:#202020 !important">
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
 <!--    <script src="js/login.js"></script> -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
     <script src="js/addUser.js"></script>
    
 <!-- <link rel="stylesheet" href="css/responsive.css"> -->

</body>

</html>