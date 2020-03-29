<div class="container" id="logoutLink" style="background-color:#000">
	                <div class="row">
	                  <div class="col-xl-12 col-lg-12 d-none d-lg-block" style="text-align: right;">
	                            <div class="social_media_links">
	                            <a style="color: white;cursor: pointer;" onclick="logout()">Logout</a>
	                               
	                            </div>
	                        </div>
	                </div>
	          </div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Links FOR admin -->
	<%
					String userType = (String) session.getAttribute("USER_TYPE");
					if (null != userType && userType.equals("Admin")) {
				%>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="admin">Admin
				Dashboard</a></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> User List </a>
			<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				<li><a class="dropdown-item submenu-link" href="admin?userType=registerUser" >Registered User</a></li>
				<li><a class="dropdown-item submenu-link" href="admin?userType=pendingUser" >Pending User</a></li>
				<li><a class="dropdown-item submenu-link" href="admin?userType=rejectedUser" >Rejected User</a></li>
			</ul>
		</li>
		<li class="nav-item"><a class="nav-link" href="downloadUser.jsp">Download
				List</a></li>
		<li class="nav-item"><a class="nav-link" href="enquiry">Enquiry</a></li>
		<li class="nav-item" id="adminUser"><a class="nav-link"
			href="getAllAdmin">Create Admin</a></li>
		<li class="nav-item" id="adminUser"><a class="nav-link"
			href="registerform.jsp">Register User</a></li>
		<!-- <li class="nav-item" id="adminUser"><a class="nav-link" href="#">Pending
				Uploaded Items</a></li> -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> HomePage </a>
			<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				<li><a class="dropdown-item submenu-link" href="banner" >Banner Image</a></li>
				<li><a class="dropdown-item submenu-link" href="gallery" >Gallery</a></li>
				<li><a class="dropdown-item submenu-link" href="latestNews.jsp" >Latest News</a></li>
			</ul>
		</li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> About Us </a>
			<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				<li><a class="dropdown-item submenu-link" href="aboutUs?type=history&redirect=admin" >History</a></li>
				<li><a class="dropdown-item submenu-link" href="aboutUs?type=electionRules&redirect=admin" >Election Rules</a></li>
				<li><a class="dropdown-item submenu-link" href="aboutUs?type=duties&redirect=admin" >Duties</a></li>
			</ul>
		</li>
	</ul>
	<!-- Links FOR Non Admin -->
	<%
					}else{
				%>
	<ul class="navbar-nav">
		<li class="nav-item" id="adminUser"><a class="nav-link"
			href="registerform.jsp">Register User</a></li>
	</ul>
	<%
					}
				%>
</nav>
