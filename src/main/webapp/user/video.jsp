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
<title>Lecture</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/data/PNG/Artboard%201.png">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/all.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/card.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<%
	User user = (User) session.getAttribute("user");
	CourseAccess ca = new CourseAccess();

	//String name = (String) session.getAttribute("name");
	%>


	<header class="container-fluid position-fixed own_bg"
		style="z-index: 1;">
		<div class="col-12">
			<div class="container">
				<div class="row">
					<div class="">
						<nav class="navbar navbar-expand-lg navbar-dark m-0 p-0">
							<div class="container-fluid">
								<div class="col-12">
									<div class="container">
										<div class="col-12">
											<div class="row w-100 d-flex">
												<a class="w-25" href="#"> <img
													src="<%=request.getContextPath()%>/data/SVG/Artboard%201.svg"
													alt="" style="width: 127px;">
												</a>
												<div
													class="w-75 d-flex justify-content-end align-items-center">
													<button class="navbar-toggler" type="button"
														data-bs-toggle="collapse"
														data-bs-target="#navbarSupportedContent"
														aria-controls="navbarSupportedContent"
														aria-expanded="false" aria-label="Toggle navigation">
														<span class="navbar-toggler-icon"></span>
													</button>
												</div>

											</div>
											<div class="row d-flex m-0 p-0">
												<div
													class="collapse navbar-collapse w-75 justify-content-end align-items-center"
													id="navbarSupportedContent">
													<ul
														class="navbar-nav d-flex justify-content-end align-items-center w-75">
														<c:if test="${user!=null}">
															<li class="nav-item w-50 text-center align-items-center">
																<div class="dropdown">
																	<a class="dropdown-toggle btn btn-outline-warning mb-1"
																		href="#" role="button" id="dropdownMenuLink"
																		data-bs-toggle="dropdown" aria-expanded="false"> <img
																		src="<%=request.getContextPath()%>/upload_images/${user.img}"
																		width="50" height="50" class="rounded-circle" /> <%=user.getName()%>
																	</a>
																	<ul class="dropdown-menu"
																		aria-labelledby="dropdownMenuLink">
																		<li><a class="dropdown-item"
																			href="<%=request.getContextPath()%>/user/index.jsp">Home</a></li>
																		<li><a class="dropdown-item"
																			href="<%=request.getContextPath()%>/UserLogoutServlet">Logout</a></li>
																	</ul>
																</div>
														</c:if>

														<c:if test="${user==null}">
															<li class="nav-item w-50 text-center align-items-center">

																<div class="dropdown">
																	<a
																		class=" dropdown-toggle btn btn-outline-warning mb-2"
																		href="#" role="button" id="dropdownMenuLink"
																		data-bs-toggle="dropdown" aria-expanded="false">
																		SignUp/Login </a>
																	<ul class="dropdown-menu"
																		aria-labelledby="dropdownMenuLink">
																		<li><a class="dropdown-item"
																			href="<%=request.getContextPath()%>/user/register.jsp">Register</a></li>
																		<li><a class="dropdown-item"
																			href="<%=request.getContextPath()%>/user/login.jsp">Login</a></li>
																	</ul>
																</div>
														</c:if>

													</ul>
												</div>

											</div>

											<nav aria-label="breadcrumb"
												style="">
												<ol class="breadcrumb  p-2"
													style="width: 230px;">
													<li class="breadcrumb-item "><a
														href="<%=request.getContextPath()%>/UserClassShowServlet"
														class="text-col text-decoration-none">Home</a></li>
													
													
													<li class="breadcrumb-item active text-col"
														aria-current="page">${categorylist.title }</li>
														
												</ol>
											</nav>
										</div>
									</div>

								</div>

							</div>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</header>


	<!-- Jsp Content Path -->

	<div class="" style="height: 30px;"></div>
	<section class="main container-fluid min-vh-100">
		<div class="" style="height: 150px;"></div>
		<div class="row">
			<!--        sidebar start-->

			<div class="col-12 col-lg-3 col-xl-2 sidebar">
				

					<div class="nav-menu">
						
					</div>
				
			</div>
			<!--        sidebar end-->
			<div class="col-12 col-lg-9 col-xl-10 min-vh-100 content-course">

				<div class="row w-100"></div>
				<!--content Area Start-->
				<div class="container-fluid">
					<div class="col-12">
						<div class="container">
							<div class="row">
								<div class="col-9 col-md-9">

									<div class="pt-4">
										<!--                           carousle-->

									</div>
									<div class="row">
										<div class="col-12"></div>

										<c:forEach var="items" items="${courselist}">

											<div class="card text-center my-2">
												<div class="card-header d-flex justify-content-start">
													<h4>${items.name}</h4>
												</div>
												<div class="card-body">
													<h5 class="card-title"></h5>
													<iframe width="560" height="315" src="${items.link }"
														title="YouTube video player" frameborder="0"
														allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
														allowfullscreen></iframe>
												</div>
												<div class="card-footer text-muted"><span>Updated at : </span> ${items.date }</div>
											</div>
										</c:forEach>
										<!--carousel-->
									</div>


								</div>

							</div>
							<div class="col-3 col-md-3 p-0">
								<div class="pt-4"></div>
							</div>
						</div>
					</div>
				</div>
				<!--content Area Start-->
			</div>
		</div>
		</div>
		</div>
	</section>

	<!-- Jsp End Content Path -->

	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/all.min.js"></script>


	<script src="<%=request.getContextPath()%>/js/own.js"></script>
	<script src="https://static.elfsight.com/platform/platform.js"
		data-use-service-core defer></script>

</body>
</html>