<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <jsp:include page="header.jsp" /> 
    <!-- header-end -->

    <!-- slider_area_start -->
      <div class="logout_class" style="display:none;padding:0 10px 0 0;"><a style="color: white;cursor: pointer;" onclick="logout()">Logout</a></div>
	<div class="main">
    <div class="container">
           <jsp:include page="adminHeader.jsp" /> 
           
       <div id="success_user_div" style="display:none;margin-top:20px;margin-botton:20px;height:500px">
       	<span id = "success_user"></span>
       	 <button type="submit" id="addNewUserButton">Click here to add new User</button>
       	 <span id = "notification_msg"></span>
       	 <button id="sendNotification" onclick="sendMessage()">Send Message</button>
       	 <span id = "sms_send_success" style="display:none;">Registration message send successful</span>
       	 <span id = "sms_send_failure" style="display:none;">Message sending failed. Please contact your administer.</span>
       </div>
       <div class="signup-content" id="signup-content">
                <div class="signup-img">
                    <img src="img/signup-img.jpg" alt="">
                </div>
                <div class="signup-form">
                    <form class="register-form" id="register-form">
                        <h2>Registration form</h2>
                        <label class="firmHeader">Institute/Firm Details</label>
                        <div class="form-row">
                                <div class="form-group-name">
                                    <label for="school_name">Institute/Firm Name :</label>
                                    <input type="text" placeholder="Institute/Firm Name" name="school_name" id="school_name"/>
                                    <div class="alert alert-danger" role="alert" id="school_name_error" style="display:none">
									  Please enter Institute/Firm name.
									</div>
                                </div>
                        </div>
                        <div class="form-group">
                                <label for="school_address">Institute/Firm Address :</label>
                                <input type="text" placeholder="Institue/Firm Address" name="school_address" id="school_address"/>
                                 <div class="alert alert-danger" role="alert" id="school_address_error" style="display:none">
									  Please enter Institute/Firm address.
								 </div>
                        </div>
                         <div class="form-group">
                                <label for="school_address">Dise code :</label>
                                <input type="text" placeholder="Dise code" name="diseCode" id="diseCode"/>
                                 <div class="alert alert-danger" role="alert" id="diseCode_error" style="display:none">
									  Please enter Dise Code.
								 </div>
                        </div>
                         <div class="form-group">
                                <label for="school_address">Affiliation number :</label>
                                <input type="text" placeholder="Affiliation number" name="affNumber" id="affNumber"/>
                                 <div class="alert alert-danger" role="alert" id="affNumber_error" style="display:none">
									  Please enter Affiliation number.
								 </div>
                        </div>
                        <div class="form-group">
                                <label for="year">Institute/Firm Established Year:</label>
                                <div class="form-select">
                                    <select name="eYear" id="eYear">
                                    <option value="0">Select Institute/Firm Established Year</option>
									<option value="2020">2020</option>
									<option value="2019">2019</option>
									<option value="2018">2018</option>
									<option value="2017">2017</option>
									<option value="2016">2016</option>
									<option value="2015">2015</option>
									<option value="2014">2014</option>
									<option value="2013">2013</option>
									<option value="2012">2012</option>
									<option value="2011">2011</option>
									<option value="2010">2010</option>
									<option value="2009">2009</option>
									<option value="2008">2008</option>
									<option value="2007">2007</option>
									<option value="2006">2006</option>
									<option value="2005">2005</option>
									<option value="2004">2004</option>
									<option value="2003">2003</option>
									<option value="2002">2002</option>
									<option value="2001">2001</option>
									<option value="2000">2000</option>
									<option value="1999">1999</option>
									<option value="1998">1998</option>
									<option value="1997">1997</option>
									<option value="1996">1996</option>
									<option value="1995">1995</option>
									<option value="1994">1994</option>
									<option value="1993">1993</option>
									<option value="1992">1992</option>
									<option value="1991">1991</option>
									<option value="1990">1990</option>
									<option value="1989">1989</option>
									<option value="1988">1988</option>
									<option value="1987">1987</option>
									<option value="1986">1986</option>
									<option value="1985">1985</option>
									<option value="1984">1984</option>
									<option value="1983">1983</option>
									<option value="1982">1982</option>
									<option value="1981">1981</option>
									<option value="1980">1980</option>
									<option value="1979">1979</option>
									<option value="1978">1978</option>
									<option value="1977">1977</option>
									<option value="1976">1976</option>
									<option value="1975">1975</option>
									<option value="1974">1974</option>
									<option value="1973">1973</option>
									<option value="1972">1972</option>
									<option value="1971">1971</option>
									<option value="1970">1970</option>
									<option value="1969">1969</option>
									<option value="1968">1968</option>
									<option value="1967">1967</option>
									<option value="1966">1966</option>
									<option value="1965">1965</option>
									<option value="1964">1964</option>
									<option value="1963">1963</option>
									<option value="1962">1962</option>
									<option value="1961">1961</option>
									<option value="1960">1960</option>
									<option value="1959">1959</option>
									<option value="1958">1958</option>
									<option value="1957">1957</option>
									<option value="1956">1956</option>
									<option value="1955">1955</option>
									<option value="1954">1954</option>
									<option value="1953">1953</option>
									<option value="1952">1952</option>
									<option value="1951">1951</option>
									<option value="1950">1950</option>
									<option value="1949">1949</option>
									<option value="1948">1948</option>
									<option value="1947">1947</option>
									<option value="1946">1946</option>
									<option value="1945">1945</option>
									<option value="1944">1944</option>
									<option value="1943">1943</option>
									<option value="1942">1942</option>
									<option value="1941">1941</option>
									<option value="1940">1940</option>
									<option value="1939">1939</option>
									<option value="1938">1938</option>
									<option value="1937">1937</option>
									<option value="1936">1936</option>
									<option value="1935">1935</option>
									<option value="1934">1934</option>
									<option value="1933">1933</option>
									<option value="1932">1932</option>
									<option value="1931">1931</option>
									<option value="1930">1930</option>
									<option value="1929">1929</option>
									<option value="1928">1928</option>
									<option value="1927">1927</option>
									<option value="1926">1926</option>
									<option value="1925">1925</option>
									<option value="1924">1924</option>
									<option value="1923">1923</option>
									<option value="1922">1922</option>
									<option value="1921">1921</option>
									<option value="1920">1920</option>
									<option value="1919">1919</option>
									<option value="1918">1918</option>
									<option value="1917">1917</option>
									<option value="1916">1916</option>
									<option value="1915">1915</option>
									<option value="1914">1914</option>
									<option value="1913">1913</option>
									<option value="1912">1912</option>
									<option value="1911">1911</option>
									<option value="1910">1910</option>
									<option value="1909">1909</option>
									<option value="1908">1908</option>
									<option value="1907">1907</option>
									<option value="1906">1906</option>
									<option value="1905">1905</option>
								</select>
                                    <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                                </div>
                                 <div class="alert alert-danger" role="alert" id="eYear_error" style="display:none">
									  Please select Institute/Firm established year.
								 </div>
                            </div>
                        <label class="firmHeader">User Personal Details</label>
                        <div class="form-group">
                                <label for="userType">User Type :</label>
                                <div class="form-select">
                                    <select name="userType" id="userType">
                                        <option value="SUT">Select User Type</option>
                                        <option value="Director">Director</option>
                                        <option value="Professional">Professional</option>
                                    </select>
                                    <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                                </div>
                                 <div class="alert alert-danger" role="alert" id="userType_error" style="display:none">
									  Please select User Type.
									</div>
                            </div>
                        <div class="form-row">
                                <div class="form-group-name">
                                    <label for="name">Name :</label>
                                    <input type="text" placeholder="Name" name="name" id="name" />
	                                 <div class="alert alert-danger" role="alert" id="name_error" style="display:none">
										  Please enter User Name.
									 </div>
								</div>
                        </div>
                           
                        <div class="form-radio">
                                <label for="gender" class="radio-label">Gender :</label>
                                <div class="form-radio-item">
                                    <input type="radio" name="gender" id="male" value="Male" checked>
                                    <label for="male">Male</label>
                                    <span class="check"></span>
                                </div>
                                <div class="form-radio-item">
                                    <input type="radio" name="gender" id="female" value="Female">
                                    <label for="female">Female</label>
                                    <span class="check"></span>
                                </div>
                        </div>
                        <div class="form-group">
                                <label for="address">Residential Address :</label>
                                <input type="text" placeholder="Residential Address" name="address" id="address" />
                        
		                         <div class="alert alert-danger" role="alert" id="address_error" style="display:none">
											  Please enter user address.
								</div>
						</div>
					<!-- 	<div class="form-group">
                                <label for="userType">City :</label>
                                <div class="form-select">
                                    <select name="userCity" id=""userCity"">
                                        <option value="SUT">Select City</option>
                                        <option value="Director">Director</option>
                                        <option value="Professional">Professional</option>
                                    </select>
                                    <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                                </div>
                                 <div class="alert alert-danger" role="alert" id="userType_error" style="display:none">
									  Please select User Type.
									</div>
                            </div> -->
                        <div class="form-group">
                            <label for="address">Mobile number :</label>
                            <input type="text" placeholder="Mobile number" name="mobile" id="mobile"/>
                        
	                         <div class="alert alert-danger" role="alert" id="mobile_error" style="display:none">
										  Please enter user mobile number.
							</div>
						</div>
                        <div class="form-row">  
                                <div class="form-group"> 
                                         <label for="birth_date">Date of birth :</label>
                                         <input type="date" name="dateofbirth" id="dateofbirth">
                                     
	                                     <div class="alert alert-danger" role="alert" id="dateofbirth_error" style="display:none">
										  Please select user date of birth.
										</div>
								</div>
                                <div class="form-group">
                                         <label for="pincode">Pincode :</label>
                                         <input type="text" placeholder="Pincode" name="pincode" id="pincode">
                                 
	                                      <div class="alert alert-danger" role="alert" id="pincode_error" style="display:none">
										  Please enter Pincode.
										  </div>
								</div>
                        </div>
                       
                        <div class="form-group">
                            <label for="email">Email ID :</label>
                            <input type="email" placeholder="Email ID" name="email" id="email" />
                             <div class="alert alert-danger" role="alert" id="email_error" style="display:none">
										  Please enter email id of user.
							 </div>
                        </div>
						<div class="form-group">
                            <label for="email">Registration Fees :</label>
                            <input type="number" placeholder="Registration Fees" name="registerFees" id="registerFees" />
                             <div class="alert alert-danger" role="alert" id="registerFees_error" style="display:none">
										  Please enter number only for registration fees.
							 </div>
                        </div>
                        <div class="form-submit">
                            <input type="button" value="Submit Form" class="submit" name="submit" id="submit" />
                        </div>
                    </form>
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
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/register.js"></script>
</body>

</html>