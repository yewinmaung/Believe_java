<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.User"%>
<%@page import="model.Message"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
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

	//System.out.print("AdminImg :"+admin.getImg());

	//String name = (String) session.getAttribute("Admin");
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
							href="<%=request.getContextPath()%>/CounterServlet"
							class="menu-item-link active"> <span> <i
									class="feather-pie-chart"></i> Dashboard
							</span>
						</a></li>
						<li class="menu-item"><a
							href="<%=request.getContextPath()%>/CategoryListServlet"
							class="menu-item-link"> <span> <i
									class="feather-folder"></i> Class List
							</span>
						</a></li>
						<li class="menu-item"><a
							href="<%=request.getContextPath()%>/CourseListServlet"
							class="menu-item-link "> <span> <i
									class="feather-file-text"></i> Course Lists
							</span>
						</a></li>
						<li class="menu-item"><a
							href="<%=request.getContextPath()%>/admin/createclass.jsp"
							class="menu-item-link"> <span> <i
									class="feather-folder-plus"></i> Create Class
							</span>
						</a></li>

						<li class="menu-item"><a
							href="<%=request.getContextPath()%>/ShowClassServlet"
							class="menu-item-link"> <span> <i
									class="feather-file-plus"></i> Add Course
							</span>
						</a></li>
						<li class="menu-item"><a
							href="<%=request.getContextPath()%>/ShowBankAccountServlet"
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

								<nav aria-label="breadcrumb"></nav>
								<!-- Admin Profile -->
								<c:if test="${admin!=null}">

									<div class="dropdown">
										<a class="dropdown-toggle btn btn-outline-warning mb-1"
											href="#" role="button" id="dropdownMenuLink"
											data-bs-toggle="dropdown" aria-expanded="false"> <img
											src="<%=request.getContextPath()%>/upload_images/${admin.img}"
											width="50" height="50" class="rounded-circle" /> <%=admin.getName()%>
										</a>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
											<li><a class="dropdown-item"
												href="<%=request.getContextPath()%>/admin/profile.jsp">Profile</a></li>
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
												href="<%=request.getContextPath()%>/admin/alogin.jsp">Login</a></li>
										</ul>
									</div>
								</c:if>

								<!-- End Admin Profile-->
							</div>
						</div>
					</div>
				</div>
				<!--content Area Start-->
				<div class=" container-fluid">
					<div class="col-12">
						<div class="container">
							<div class="row">
								<div class="col-12 col-md-6 col-lg-6 col-xl-3">
									<div class="card mb-4 status-card">
										<div class="card-body">
											<div class="row align-items-center">
												<div class="col-3">
													<i class="feather-users h1 text-col1"></i>
												</div>
												<div class="col-9">
													<p class="mb-1 h4 font-weight-bolder">
														<span class="counter-up text-col1">${getUser.getCount()}</span>
													</p>
													<p class="mb-0 text-col1-50">Users</p>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="col-12 col-md-6 col-lg-6 col-xl-3">
									<div class="card mb-4 status-card">
										<div class="card-body">
											<div class="row align-items-center">
												<div class="col-3">
													<i class="feather-user-check h1 text-col1"></i>
												</div>
												<div class="col-9">
													<p class="mb-1 h4 font-weight-bolder">
														<span class="counter-up text-col1">${enrollCourse.getCount()}</span>
													</p>
													<p class="mb-0 text-col1-50">Enrolls</p>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="col-12 col-md-6 col-lg-6 col-xl-3">
									<div class="card mb-4 status-card">
										<div class="card-body">
											<div class="row align-items-center">
												<div class="col-3">
													<i class="feather-shield h1 text-col1"></i>
												</div>
												<div class="col-9">
													<p class="mb-1 h4 font-weight-bolder">
														<span class="counter-up text-col1">${classcount.getCount()}</span>
													</p>
													<p class="mb-0 text-col1-50">Classes</p>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="col-12 col-md-6 col-lg-6 col-xl-3">
									<div class="card mb-4 status-card">
										<div class="card-body">
											<div class="row align-items-center">
												<div class="col-3">
													<i class="feather-pocket h1 text-col1"></i>
												</div>
												<div class="col-9">
													<p class="mb-1 h4 font-weight-bolder">
														<span class="counter-up text-col1">${report.getCount()}</span>
													</p>
													<p class="mb-0 text-col1-50">Report</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-md-12">
									<div>
										<table class="table bg-light">
											<thead>
												<tr>
													<th>#</th>
													<th>Name</th>
													<th>E-mail</th>
													<th>Message</th>
													<th>Date</th>
													<th>Action</th>
												</tr>

											</thead>
											<tbody>
												<c:forEach var="items" items="${message}">
													<tr>
														<td>${items.id }</td>
														<td>${items.name }</td>
														<td>${items.email }</td>
														<td>${items.message }</td>

														<td>${items.date}</td>
														<td>
																<a href="mailto:${items.email }" class="btn btn-outline-primary">
																	<i class="feather-mail "></i>
																</a>

															</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
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
	<script src="<%=request.getContextPath()%>/js/Chart.min.js"></script>
	<script src="https://static.elfsight.com/platform/platform.js"
		data-use-service-core defer></script>

</body>
</html>