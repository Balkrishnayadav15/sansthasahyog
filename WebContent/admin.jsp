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
                        <div class="col-xl-3 col-lg-3" style="padding:30px;">
                            <div class="logo-img">
                                <a href="index.jsp">
                                    <img src="img/Logo.png" alt="" style="height: 47px;width:316px">
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-7 col-lg-9">
                            <div class="main-menu  d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                        <li><a class="active" href="index.jsp">Home</a></li>
                                         <li><a href="about.html">Our Services</a></li>
                                          <li><a href="about.html">Media</a></li>
                                           <li><a href="about.html">Online Serives</a></li>
                                        <li><a href="about.html">About Us</a></li>                                        
                                        <!-- <li><a href="#">Gallery <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="index.jsp">Photos</a></li>
                                            </ul>
                                        </li> -->
                                        <li><a href="contact.html">Contact Us</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                       
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>
                </div>
                <div class="container" style="background-color:#000">
	                <div class="row">
	                  <div class="col-xl-12 col-lg-12 d-none d-lg-block">
	                            <div class="social_media_links">
	                            <a style="color: white;cursor: pointer;" onclick="logout()">Logout</a>
	                               
	                            </div>
	                        </div>
	                </div>
	          </div>
            </div>
        </div>
    </header>
    <!-- header-end -->

    <!-- slider_area_start -->
     <div class="logout_class" style="display:none;padding:0 10px 0 0;"><a style="color: white;cursor: pointer;" onclick="logout()">Logout</a></div>
	<div class="main">
    <div class="container" style="padding-bottom:50px">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <!-- Links -->
            <ul class="navbar-nav">
              <li class="nav-item">
                  <a  class="nav-link" href="admin">User List</a>
              </li>
              <li class="nav-item" id="adminUser">
                  <a class="nav-link" href="getAllAdmin">Admin User</a>
              </li>
              <li class="nav-item">
                    <a class="nav-link" href="registerform.jsp" >Register User</a>
               </li>
               <li class="nav-item">
                    <a class="nav-link" href="downloadUser.html" >Download</a>
               </li>
            </ul>
        </nav>
       <div>
       		<% 
       			List<User> userList = (List<User>) request.getAttribute("ALL_USER");
       		
   				List<User> pendingUsers = (List<User>) request.getAttribute("PENDING_USER");

       		%>
       	<!-- Start list of user with pending status -->
       		<div class="panel panel-primary" id="PendingUList" >
					    <div class="panel-heading">
					      <h2 class="adminHeader">Pending User List</h2>
					    </div>
					    <div class="panel-body">
					      <table class="table table-striped">
					        <thead>
					          <tr>
					            <th>Registration Id</th>
					            <th>Name</th>
					            <th class="hideDTEle">Email</th>
					            <th class="hideDTEle">Mobile number</th>
					          </tr>
					        </thead>
					        <tbody>
					        <% for(User user:pendingUsers){%>
					          <tr>
					            <td><%=user.getRegisterId() %></td>
					            <td><%=user.getName() %></td>
					            <td class="hideDTEle"><%=user.getEmail() %></td>
					            <td class="hideDTEle"><%=user.getMobile() %></td>
					            <td><!-- <button (click)="deleteUser(user.id,user)" class="btn btn-danger">Delete</button>
					                <button (click)="updateUser(user.id)" class="btn btn-info" style="margin-left: 10px">Update</button> -->
					                <button onclick="userDetails('<%=user.getRegisterId()%>','pending')" class="btn btn-info hideDTEle" style="margin-left: 10px">Details</button>
					           		<button onclick="userDetails('<%=user.getRegisterId()%>','pending')" class="btn-xs btn-info" style="margin-left: 10px">Details</button>
					            </td>
					          </tr>
					          <tr id="pending_<%=user.getRegisterId() %>" style="display:none">
					          	<td colspan="5">
					          		<div>
								        <button onclick="approve('<%=user.getRegisterId()%>')" class="btn btn-dark" style="margin-left: 10px;float: right;">Approve</button>
								    </div>
								    
								    <!--Start Approve Modal HTML -->
										<div id="approve_modal" class="modal fade"  tabindex="-1">
											<div class="modal-dialog modal-confirm">
												<div class="modal-content">
													<div class="modal-header">
														<div class="icon-box">
															<i class="material-icons">&#xE5CD;</i>
														</div>				
														<h4 class="modal-title">Are you sure?</h4>	
										                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
													</div>
													<div class="modal-body">
														<p>Do you really want to delete these records? This process cannot be undone.</p>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-info" data-dismiss="modal">Cancel</button>
														<button type="button" class="btn btn-danger" onclick="approve('<%=user.getRegisterId()%>')" data-dismiss="modal" >Delete</button>
													</div>
												</div>
											</div>
										</div>  
								 <!--End Approve Modal HTML -->
								    
								    <div id="pending_details_<%=user.getRegisterId() %>">
						          	 	 <div style="margin-top: 42px;">
										    <span><b>Name: </b></span> <span><%=user.getName() %></span>
										  </div>
										  <div>
										    <span><b>Address: </b></span> <span><%=user.getAddress() %></span>
										  </div>
										  <div>
										    <span><b>Email Id: </b></span><span><%=user.getEmail() %></span>
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
										  <div>
										  	<span><b>SMS Status: </b></span><span><%=user.getSmsSend() %></span><br>
										  </div>
									  </div> 
									  
					          	<td>
					          </tr>
					        <% } %>
					        </tbody>
					      </table>
					    </div>
					</div>
       		<!-- End list of user with pending status -->
       		
       		<!-- Start Completed user registration list -->
				  <div class="panel panel-primary" >
					    <div class="panel-heading">
					      <h2 class="adminHeader">User List</h2>
					    </div>
					    <div class="panel-body">
					      <table class="table table-striped">
					        <thead>
					          <tr>
					            <th>Registration Id</th>
					            <th>Name</th>
					            <th class="hideDTEle">Email</th>
					            <th class="hideDTEle">Mobile number</th>
					          </tr>
					        </thead>
					        <tbody>
					        <% for(User user:userList){%>
					          <tr>
					            <td><%=user.getRegisterId() %></td>
					            <td><%=user.getName() %></td>
					            <td class="hideDTEle"><%=user.getEmail() %></td>
					            <td class="hideDTEle"><%=user.getMobile() %></td>
					            <td><!-- <button (click)="deleteUser(user.id,user)" class="btn btn-danger">Delete</button>
					                <button (click)="updateUser(user.id)" class="btn btn-info" style="margin-left: 10px">Update</button> -->
					                <button onclick="userDetails('<%=user.getRegisterId()%>')" class="btn btn-info hideDTEle" style="margin-left: 10px">Details</button>
					           		<button onclick="userDetails('<%=user.getRegisterId()%>')" class="btn-xs btn-info" style="margin-left: 10px">Details</button>
					            </td>
					          </tr>
					          <tr id="<%=user.getRegisterId() %>" style="display:none">
					          	<td colspan="5">
					          		<div>
								        <button onclick="update('<%=user.getRegisterId()%>')" class="btn btn-dark" style="margin-left: 10px;float: right;">Update</button>
										<button onclick="deleteUser('<%=user.getRegisterId()%>')" class="btn btn-danger" style="margin-left: 10px;float: right;">Delete</button>
								    </div>
								    <div id="details_<%=user.getRegisterId() %>">
						          	 	 <div style="margin-top: 42px;">
										    <span><b>Name: </b></span> <span><%=user.getName() %></span>
										  </div>
										  <div>
										    <span><b>Address: </b></span> <span><%=user.getAddress() %></span>
										  </div>
										  <div>
										    <span><b>Email Id: </b></span><span><%=user.getEmail() %></span>
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
										  <div>
										  	<span><b>SMS Status: </b></span><span><%=user.getSmsSend() %></span><br>
										  </div>
									  </div> 
									  <div id="update_<%=user.getRegisterId() %>" style="display:none;margin-top: 42px;">
											  	<span><b>Name: </b></span><input type="text" class="updateinput" value="<%=user.getName() %>" name="name_<%=user.getRegisterId() %>" id="name_<%=user.getRegisterId() %>"><br>
											  	 <span id="name_error_<%=user.getRegisterId() %>" style="color:red;display:none;">Name can not be empty.</span>
											  	 <span><b>Address: </b></span><input type="text" class="updateinput" value="<%=user.getAddress() %>" name="address_<%=user.getRegisterId() %>"  id="address_<%=user.getRegisterId() %>"><br>
											  	 <span id="address_error_<%=user.getRegisterId() %>" style="color:red;display:none;">Name can not be empty.</span>
											  	 <span><b>Email Id: </b> </span><input type="text" class="updateinput" value="<%=user.getEmail() %>" name="email_<%=user.getRegisterId() %>" id="email_<%=user.getRegisterId() %>"><br>
											  	<span id="email_error_<%=user.getRegisterId() %>" style="color:red;display:none;">Name can not be empty.</span>
											  	<span><b>Mobile Number: </b></span><input type="text" class="updateinput" value="<%=user.getMobile() %>" name="mobile_<%=user.getRegisterId() %>" id="mobile_<%=user.getRegisterId() %>"><br>
												 <span id="mobile_error_<%=user.getRegisterId() %>" style="color:red;display:none;">Name can not be empty.</span>
												 <span><b>Gender: </b></span><br>
												<input type="radio" style="visibility: visible;width: 10%;display: inline;margin: 6px;" class="radio-gender" name="gender_<%=user.getRegisterId() %>" id="male_<%=user.getRegisterId() %>" value="Male" <%if((user.getGender().equals("Male"))){%> checked <%}%>>
 												Male<br>
  												 <input type="radio" style="visibility: visible;width: 10%;display: inline;margin: 6px;"  class="radio-gender" name="gender_<%=user.getRegisterId() %>" id="female_<%=user.getRegisterId() %>" value="Female" <%if((user.getGender().equals("Female"))){%> checked <%}%>>
  												Female
  												<br>
											  	<span><b>User Type: </b></span><select name="userType_<%=user.getRegisterId() %>" id="userType_<%=user.getRegisterId() %>" class="updateinput">
											                                        <option value="SUT" >Select User Type</option>
											                                        <option value="Director" <%if((user.getUserType().equals("Director"))){%> selected <%}%>>Director</option>
											                                        <option value="Professional" <%if((user.getUserType().equals("Professional"))){%> selected <%}%>>Professional</option>
											                                    </select><br>
											    <span><b>Date of birth: </b></span><input type="date" class="updateinput" value="<%=user.getDateOfBirth() %>" name="dateofbirth_<%=user.getRegisterId() %>" id="dateofbirth_<%=user.getRegisterId() %>"><br>
											    <span><b>Pincode: </b></span><input type="text" class="updateinput" value="<%=user.getPincode() %>" name="pincode_<%=user.getRegisterId() %>" id="pincode_<%=user.getRegisterId() %>"><br>
											    <span id="pincode_error_<%=user.getRegisterId() %>" style="color:red;display:none;">Name can not be empty.</span>
											    <span><b>Institute/Firm Name: </b></span><input type="text" class="updateinput" value="<%=user.getSchoolName() %>" name="school_name_<%=user.getRegisterId() %>" id="school_name_<%=user.getRegisterId() %>"><br>
											    <span id="school_name_error_<%=user.getRegisterId() %>" style="color:red;display:none;">Name can not be empty.</span>
											    <span><b>Institute/Firm Addess: </b></span><input type="text" class="updateinput" value="<%=user.getSchoolAddress() %>" name="school_address_<%=user.getRegisterId() %>" id="school_address_<%=user.getRegisterId() %>"><br>
											    <span id="school_address_error_<%=user.getRegisterId() %>" style="color:red;display:none;">Name can not be empty.</span>
											    <span><b>Institute/Firm Established Year: </b></span> <select name="eYear_<%=user.getRegisterId() %>" id="eYear_<%=user.getRegisterId() %>" class="updateinput">
																	                                    <option value="0">Select Institute/Firm Established Year</option>
																										<option value="2020" <%if((user.geteYear().equals("2020"))){%> selected <%}%> >2020</option>
																										<option value="2019" <%if((user.geteYear().equals("2019"))){%> selected <%}%> >2019</option>
																										<option value="2018" <%if((user.geteYear().equals("2018"))){%> selected <%}%> >2018</option>
																										<option value="2017" <%if((user.geteYear().equals("2017"))){%> selected <%}%> >2017</option>
																										<option value="2016" <%if((user.geteYear().equals("2016"))){%> selected <%}%> >2016</option>
																										<option value="2015" <%if((user.geteYear().equals("2015"))){%> selected <%}%> >2015</option>
																										<option value="2014" <%if((user.geteYear().equals("2014"))){%> selected <%}%> >2014</option>
																										<option value="2013" <%if((user.geteYear().equals("2013"))){%> selected <%}%> >2013</option>
																										<option value="2012" <%if((user.geteYear().equals("2012"))){%> selected <%}%> >2012</option>
																										<option value="2011" <%if((user.geteYear().equals("2011"))){%> selected <%}%> >2011</option>
																										<option value="2010" <%if((user.geteYear().equals("2010"))){%> selected <%}%> >2010</option>
																										<option value="2009" <%if((user.geteYear().equals("2009"))){%> selected <%}%> >2009</option>
																										<option value="2008" <%if((user.geteYear().equals("2008"))){%> selected <%}%> >2008</option>
																										<option value="2007" <%if((user.geteYear().equals("2007"))){%> selected <%}%> >2007</option>
																										<option value="2006" <%if((user.geteYear().equals("2006"))){%> selected <%}%> >2006</option>
																										<option value="2005" <%if((user.geteYear().equals("2005"))){%> selected <%}%> >2005</option>
																										<option value="2004" <%if((user.geteYear().equals("2004"))){%> selected <%}%> >2004</option>
																										<option value="2003" <%if((user.geteYear().equals("2003"))){%> selected <%}%> >2003</option>
																										<option value="2002" <%if((user.geteYear().equals("2002"))){%> selected <%}%> >2002</option>
																										<option value="2001" <%if((user.geteYear().equals("2001"))){%> selected <%}%> >2001</option>
																										<option value="2000" <%if((user.geteYear().equals("2000"))){%> selected <%}%> >2000</option>
																										<option value="1999" <%if((user.geteYear().equals("1999"))){%> selected <%}%> >1999</option>
																										<option value="1998" <%if((user.geteYear().equals("1998"))){%> selected <%}%> >1998</option>
																										<option value="1997" <%if((user.geteYear().equals("1997"))){%> selected <%}%> >1997</option>
																										<option value="1996" <%if((user.geteYear().equals("1996"))){%> selected <%}%> >1996</option>
																										<option value="1995" <%if((user.geteYear().equals("1995"))){%> selected <%}%> >1995</option>
																										<option value="1994" <%if((user.geteYear().equals("1994"))){%> selected <%}%> >1994</option>
																										<option value="1993" <%if((user.geteYear().equals("1993"))){%> selected <%}%> >1993</option>
																										<option value="1992" <%if((user.geteYear().equals("1992"))){%> selected <%}%> >1992</option>
																										<option value="1991" <%if((user.geteYear().equals("1991"))){%> selected <%}%> >1991</option>
																										<option value="1990" <%if((user.geteYear().equals("1990"))){%> selected <%}%> >1990</option>
																										<option value="1989" <%if((user.geteYear().equals("1989"))){%> selected <%}%> >1989</option>
																										<option value="1988" <%if((user.geteYear().equals("1988"))){%> selected <%}%> >1988</option>
																										<option value="1987" <%if((user.geteYear().equals("1987"))){%> selected <%}%> >1987</option>
																										<option value="1986" <%if((user.geteYear().equals("1986"))){%> selected <%}%> >1986</option>
																										<option value="1985" <%if((user.geteYear().equals("1985"))){%> selected <%}%> >1985</option>
																										<option value="1984" <%if((user.geteYear().equals("1984"))){%> selected <%}%> >1984</option>
																										<option value="1983" <%if((user.geteYear().equals("1983"))){%> selected <%}%> >1983</option>
																										<option value="1982" <%if((user.geteYear().equals("1982"))){%> selected <%}%> >1982</option>
																										<option value="1981" <%if((user.geteYear().equals("1981"))){%> selected <%}%> >1981</option>
																										<option value="1980" <%if((user.geteYear().equals("1980"))){%> selected <%}%> >1980</option>
																										<option value="1979" <%if((user.geteYear().equals("1979"))){%> selected <%}%> >1979</option>
																										<option value="1978" <%if((user.geteYear().equals("1978"))){%> selected <%}%> >1978</option>
																										<option value="1977" <%if((user.geteYear().equals("1977"))){%> selected <%}%> >1977</option>
																										<option value="1976" <%if((user.geteYear().equals("1976"))){%> selected <%}%> >1976</option>
																										<option value="1975" <%if((user.geteYear().equals("1975"))){%> selected <%}%> >1975</option>
																										<option value="1974" <%if((user.geteYear().equals("1974"))){%> selected <%}%> >1974</option>
																										<option value="1973" <%if((user.geteYear().equals("1973"))){%> selected <%}%> >1973</option>
																										<option value="1972" <%if((user.geteYear().equals("1972"))){%> selected <%}%> >1972</option>
																										<option value="1971" <%if((user.geteYear().equals("1971"))){%> selected <%}%> >1971</option>
																										<option value="1970" <%if((user.geteYear().equals("1970"))){%> selected <%}%> >1970</option>
																										<option value="1969" <%if((user.geteYear().equals("1969"))){%> selected <%}%> >1969</option>
																										<option value="1968" <%if((user.geteYear().equals("1968"))){%> selected <%}%> >1968</option>
																										<option value="1967" <%if((user.geteYear().equals("1967"))){%> selected <%}%> >1967</option>
																										<option value="1966" <%if((user.geteYear().equals("1966"))){%> selected <%}%> >1966</option>
																										<option value="1965" <%if((user.geteYear().equals("1965"))){%> selected <%}%> >1965</option>
																										<option value="1964" <%if((user.geteYear().equals("1964"))){%> selected <%}%> >1964</option>
																										<option value="1963" <%if((user.geteYear().equals("1963"))){%> selected <%}%> >1963</option>
																										<option value="1962" <%if((user.geteYear().equals("1962"))){%> selected <%}%> >1962</option>
																										<option value="1961" <%if((user.geteYear().equals("1961"))){%> selected <%}%> >1961</option>
																										<option value="1960" <%if((user.geteYear().equals("1960"))){%> selected <%}%> >1960</option>
																										<option value="1959" <%if((user.geteYear().equals("1959"))){%> selected <%}%> >1959</option>
																										<option value="1958" <%if((user.geteYear().equals("1958"))){%> selected <%}%> >1958</option>
																										<option value="1957" <%if((user.geteYear().equals("1957"))){%> selected <%}%> >1957</option>
																										<option value="1956" <%if((user.geteYear().equals("1956"))){%> selected <%}%> >1956</option>
																										<option value="1955" <%if((user.geteYear().equals("1955"))){%> selected <%}%> >1955</option>
																										<option value="1954" <%if((user.geteYear().equals("1954"))){%> selected <%}%> >1954</option>
																										<option value="1953" <%if((user.geteYear().equals("1953"))){%> selected <%}%> >1953</option>
																										<option value="1952" <%if((user.geteYear().equals("1952"))){%> selected <%}%> >1952</option>
																										<option value="1951" <%if((user.geteYear().equals("1951"))){%> selected <%}%> >1951</option>
																										<option value="1950" <%if((user.geteYear().equals("1950"))){%> selected <%}%> >1950</option>
																										<option value="1949" <%if((user.geteYear().equals("1949"))){%> selected <%}%> >1949</option>
																										<option value="1948" <%if((user.geteYear().equals("1948"))){%> selected <%}%> >1948</option>
																										<option value="1947" <%if((user.geteYear().equals("1947"))){%> selected <%}%> >1947</option>
																										<option value="1946" <%if((user.geteYear().equals("1946"))){%> selected <%}%> >1946</option>
																										<option value="1945" <%if((user.geteYear().equals("1945"))){%> selected <%}%> >1945</option>
																										<option value="1944" <%if((user.geteYear().equals("1944"))){%> selected <%}%> >1944</option>
																										<option value="1943" <%if((user.geteYear().equals("1943"))){%> selected <%}%> >1943</option>
																										<option value="1942" <%if((user.geteYear().equals("1942"))){%> selected <%}%> >1942</option>
																										<option value="1941" <%if((user.geteYear().equals("1941"))){%> selected <%}%> >1941</option>
																										<option value="1940" <%if((user.geteYear().equals("1940"))){%> selected <%}%> >1940</option>
																										<option value="1939" <%if((user.geteYear().equals("1939"))){%> selected <%}%> >1939</option>
																										<option value="1938" <%if((user.geteYear().equals("1938"))){%> selected <%}%> >1938</option>
																										<option value="1937" <%if((user.geteYear().equals("1937"))){%> selected <%}%> >1937</option>
																										<option value="1936" <%if((user.geteYear().equals("1936"))){%> selected <%}%> >1936</option>
																										<option value="1935" <%if((user.geteYear().equals("1935"))){%> selected <%}%> >1935</option>
																										<option value="1934" <%if((user.geteYear().equals("1934"))){%> selected <%}%> >1934</option>
																										<option value="1933" <%if((user.geteYear().equals("1933"))){%> selected <%}%> >1933</option>
																										<option value="1932" <%if((user.geteYear().equals("1932"))){%> selected <%}%> >1932</option>
																										<option value="1931" <%if((user.geteYear().equals("1931"))){%> selected <%}%> >1931</option>
																										<option value="1930" <%if((user.geteYear().equals("1930"))){%> selected <%}%> >1930</option>
																										<option value="1929" <%if((user.geteYear().equals("1929"))){%> selected <%}%> >1929</option>
																										<option value="1928" <%if((user.geteYear().equals("1928"))){%> selected <%}%> >1928</option>
																										<option value="1927" <%if((user.geteYear().equals("1927"))){%> selected <%}%> >1927</option>
																										<option value="1926" <%if((user.geteYear().equals("1926"))){%> selected <%}%> >1926</option>
																										<option value="1925" <%if((user.geteYear().equals("1925"))){%> selected <%}%> >1925</option>
																										<option value="1924" <%if((user.geteYear().equals("1924"))){%> selected <%}%> >1924</option>
																										<option value="1923" <%if((user.geteYear().equals("1923"))){%> selected <%}%> >1923</option>
																										<option value="1922" <%if((user.geteYear().equals("1922"))){%> selected <%}%> >1922</option>
																										<option value="1921" <%if((user.geteYear().equals("1921"))){%> selected <%}%> >1921</option>
																										<option value="1920" <%if((user.geteYear().equals("1920"))){%> selected <%}%> >1920</option>
																										<option value="1919" <%if((user.geteYear().equals("1919"))){%> selected <%}%> >1919</option>
																										<option value="1918" <%if((user.geteYear().equals("1918"))){%> selected <%}%> >1918</option>
																										<option value="1917" <%if((user.geteYear().equals("1917"))){%> selected <%}%> >1917</option>
																										<option value="1916" <%if((user.geteYear().equals("1916"))){%> selected <%}%> >1916</option>
																										<option value="1915" <%if((user.geteYear().equals("1915"))){%> selected <%}%> >1915</option>
																										<option value="1914" <%if((user.geteYear().equals("1914"))){%> selected <%}%> >1914</option>
																										<option value="1913" <%if((user.geteYear().equals("1913"))){%> selected <%}%> >1913</option>
																										<option value="1912" <%if((user.geteYear().equals("1912"))){%> selected <%}%> >1912</option>
																										<option value="1911" <%if((user.geteYear().equals("1911"))){%> selected <%}%> >1911</option>
																										<option value="1910" <%if((user.geteYear().equals("1910"))){%> selected <%}%> >1910</option>
																										<option value="1909" <%if((user.geteYear().equals("1909"))){%> selected <%}%> >1909</option>
																										<option value="1908" <%if((user.geteYear().equals("1908"))){%> selected <%}%> >1908</option>
																										<option value="1907" <%if((user.geteYear().equals("1907"))){%> selected <%}%> >1907</option>
																										<option value="1906" <%if((user.geteYear().equals("1906"))){%> selected <%}%> >1906</option>
																										<option value="1905" <%if((user.geteYear().equals("1905"))){%> selected <%}%> >1905</option>
																									</select><br>
												
												<button onclick="saveUpdatedDetails('<%=user.getRegisterId()%>')" class="btn btn-dark" style="margin-left: 10px;float: right;">Save details</button>

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
    <script src="js/admin.js"></script>
     <script src="js/register.js"></script>
</body>

</html>