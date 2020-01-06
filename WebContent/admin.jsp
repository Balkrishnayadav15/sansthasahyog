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
	<div class="main">
    <div class="container" style="padding-bottom:50px">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <!-- Links -->
            <ul class="navbar-nav">
              <li class="nav-item">
                  <a  class="nav-link" href="admin">User List</a>
              </li>
              <li class="nav-item">
                  <a class="nav-link" href="">Add User</a>
              </li>
              <li class="nav-item">
                    <a class="nav-link" href="registerform.jsp" >Register User</a>
                </li>
            </ul>
        </nav>
       <div>
       		<% 
       			List<User> userList = (List<User>) request.getAttribute("ALL_USER");
       		%>
				  <div class="panel panel-primary" >
					    <div class="panel-heading">
					      <h2>User List</h2>
					    </div>
					    <div class="panel-body">
					      <table class="table table-striped">
					        <thead>
					          <tr>
					            <th>Registration Addess</th>
					            <th>Name</th>
					            <th>Email</th>
					            <th>Mobile number</th>
					          </tr>
					        </thead>
					        <tbody>
					        <% for(User user:userList){%>
					          <tr>
					            <td><%=user.getRegisterId() %></td>
					            <td><%=user.getName() %></td>
					            <td><%=user.getEmail() %></td>
					            <td><%=user.getMobile() %></td>
					            <td><!-- <button (click)="deleteUser(user.id,user)" class="btn btn-danger">Delete</button>
					                <button (click)="updateUser(user.id)" class="btn btn-info" style="margin-left: 10px">Update</button> -->
					                <button onclick="userDetails('<%=user.getRegisterId()%>')" class="btn btn-info" style="margin-left: 10px">Details</button>
					            </td>
					          </tr>
					          <tr id="<%=user.getRegisterId() %>" style="display:none">
					          	<td colspan="5">
					          	 	 <div>
									    <span><b>Name: </b></span> <span><%=user.getName() %></span>
									  </div>
									  <div>
									    <span><b>Address: </b></span> <span><%=user.getAddress() %></span>
									  </div>
									  <div>
									    <span><b>Email Id: </b></label> <span><%=user.getEmail() %></span>
									  </div>  
									  <div>
									    <span><b>Mobile Number: </b></span> <span><%=user.getMobile() %></span>
									  </div> 
									  <div>
									    <span><b>Gender: </b></span><span><%=user.getGender() %></span>
									  </div> 
									  <div>
									    <span><b>User Type: </b></span><span><%=user.getUserType() %></span>
									  </div> 
									   <div>
									    <span><b>Date of birth: </b></span><span><%=user.getDateOfBirth() %></span>
									  </div> 
									   <div>
									    <span><b>Pincode: </b></span><span><%=user.getPincode() %></span>
									  </div>
									  <div>
									    <span><b>Institute/Firm Name: </b></span><span><%=user.getSchoolName() %></span>
									  </div> 
									   <div>
									    <span><b>Institute/Firm Addess: </b></span><span><%=user.getSchoolAddress() %></span>
									  </div> 
									   <div>
									    <span><b>Institute/Firm Established Year: </b></span><span><%=user.geteYear() %></span>
									  </div> 
									   <div>
									    <span><b>Registration Fees: </b></span><span><%=user.getRegisterFees() %></span>
									  </div> 
					          	<td>
					          </tr>
					        <% } %>
					        </tbody>
					      </table>
					    </div>
					</div>
			<% 
			
			%>
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
                            <p class="footer_text">501 Palhar Nagar, Indore, M.P<br>
                                +91 9999999999<br>
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
    <script src="js/admin.js"></script>
</body>

</html>