<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.User"%>
<%@page import="model.CourseAccess"%>
<%@page import="model.Category"%>

<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Lists</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/data/PNG/Artboard%201.png">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/all.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/data/feather-icons-web/feather.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/card.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/enroll_course/app.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/enroll_course/style.css">
</head>
<body>
	<%
	User admin = (User) session.getAttribute("admin");
	CourseAccess ca = new CourseAccess();
	List<Category> catlist = ca.showClass();
	
	
    
	//String name = (String) session.getAttribute("name");
	%>

	<section class="main container-fluid min-vh-100">
		<div class="row">
			<!--        sidebar start-->
			<div class="col-12 col-lg-3 col-xl-2 min-vh-100 sidebar">
				<div
					class="d-flex justify-content-between align-items-center py-2 mt-3">
					<div class="d-flex align-items-center">
						<img src="<%=request.getContextPath()%>/data/SVG/Artboard%201.svg"
							alt="" style="width: 180px;">
					</div>
					<button class="hide-sidebar-btn btn btn-light d-block d-lg-none">
						<i class="feather-x text-col1" style="font-size: 2em;"></i>
					</button>
				</div>

				<div class="nav-menu">
					<ul>
						<li class="menu-spacer"></li>

						<li class="menu-item"><a
							href="<%=request.getContextPath()%>/admin/dashboard.jsp"
							class="menu-item-link"> <span> <i
									class="feather-pie-chart"></i> Dashboard
							</span>
						</a></li>

						<li class="menu-item"><a
							href="<%=request.getContextPath()%>/CourseListServlet"
							class="menu-item-link active"> <span> <i
									class="feather-user"></i> Course Lists
							</span>
						</a></li>
						<li class="menu-item"><a
							href="<%=request.getContextPath()%>/admin/createclass.jsp"
							class="menu-item-link"> <span> <i
									class="feather-user-plus"></i> Create Course
							</span>
						</a></li>
						<li class="menu-item"><a
							href="<%=request.getContextPath()%>/ShowClassServlet"
							class="menu-item-link"> <span> <i
									class="feather-user-plus"></i> Add Course
							</span>
						</a></li>
						<li class="menu-item"><a
							href="<%=request.getContextPath()%>/admin/bankAccount.jsp"
							class="menu-item-link"> <span> <i
									class="feather-user-plus"></i> Create BankAccount
							</span>
						</a></li>

						<div class=""></div>

						<li class="menu-item"><a
							href="<%=request.getContextPath()%>/admin/profile.jsp"
							class="menu-item-link"> <span> <i class="feather-edit"></i>
									Edit Profile
							</span>
						</a></li>
					</ul>
				</div>
			</div>
			<!--        sidebar end-->
			<div class="col-12 col-lg-9 col-xl-10 vh-100 content-course">

				<div class="row w-100">
					<div class="col-12">
						<div class="navbar navbar-course">
							<div
								class="d-flex w-100 justify-content-between align-items-center">
								<button
									class="show-sidebar-btn btn btn-primary d-block d-lg-none">
									<i class="feather-align-left text-col" style="font-size: 2em;"></i>
								</button>

								<nav aria-label="breadcrumb">
									<ol class="breadcrumb"
										style="width: 310px; background: rgba(5, 5, 154, 0.86) !important;">
										<li class="breadcrumb-item "><a
											href="<%=request.getContextPath()%>/admin/dashboard.jsp"
											class="text-col text-decoration-none">Home</a></li>
										<li class="breadcrumb-item active text-col"
											aria-current="page">Courses list</li>
									</ol>
								</nav>

								<!-- Admin Profile -->
								<c:if test="${admin!=null}">
									<div class="dropdown">
										<a class="dropdown-toggle btn btn-outline-warning mb-1"
											href="#" role="button" id="dropdownMenuLink"
											data-bs-toggle="dropdown" aria-expanded="false"> <%=admin.getName()%>
										</a>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
											<li><a class="dropdown-item"
												href="<%=request.getContextPath()%>/user/profile.jsp">Profile</a></li>
											<li><a class="dropdown-item"
												href="<%=request.getContextPath()%>/UserLogoutServlet">Logout</a></li>
										</ul>
									</div>
								</c:if>

								<c:if test="${admin==null}">
									<div class="dropdown">
										<a class=" dropdown-toggle btn btn-outline-warning mb-2"
											href="#" role="button" id="dropdownMenuLink"
											data-bs-toggle="dropdown" aria-expanded="false">
											SignUp/Login </a>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
											<li><a class="dropdown-item"
												href="<%=request.getContextPath()%>/user/register.jsp">Register</a></li>
											<li><a class="dropdown-item"
												href="<%=request.getContextPath()%>/user/login.jsp">Login</a></li>
										</ul>
									</div>
								</c:if>

								<!-- End Admin Profile-->
							</div>
						</div>
					</div>
				</div>
				<!--content Area Start-->
				<div>
					<table class="table bg-white">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Image</th>
							<th>Class</th>
							<th>Link</th>
							<th>Created_Date</th>
							<th>Controls</th>
						</tr>

						<c:forEach var="items" items="${courselist}">

							<tr>
								<td>${items.id}</td>
								<td>${items.name}</td>
								<td><img src="./upload_images/${items.img}" width="60"
									height="60" /></td>
									
								<c:foreach var="catlists" items="${catlist }">
								<c:if test="${items.type== catlists.id}">
									<td>${catlist.title}</td>
									</c:if>
								</c:foreach>
								<td>${items.link}</td>
								<td>${items.date}</td>
								<td class="d-flex"><a
									href="<%=request.getContextPath()%>/CourseEditServlet?courseid=${items.id}"
									class="btn btn-outline-warning text-primary hovcol ">Edit</a></td>
							</tr>
						</c:forEach>

					</table>
				</div>
				<!--content Area Start-->
			</div>
		</div>
		</div>
		</div>
	</section>
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/all.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/own.js"></script>
	<script src="https://static.elfsight.com/platform/platform.js"
		data-use-service-core defer></script>

</body>
</html>