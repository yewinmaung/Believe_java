<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.User"%>
<%@page import="model.Enroll"%>
<%@page import="model.EnrollAccess"%>
<%@page import="model.CourseAccess"%>
<%@page import="model.Category"%>

<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Believe Learning Center</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/data/PNG/Artboard%201.png">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/all.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/card.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/card.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<%
	User user = (User) session.getAttribute("user");
	//boolean stu = (boolean) session.getAttribute("stu");
	//System.out.print("INestu"+stu.getName());
	//CourseAccess ca = new CourseAccess();

	// System.out.print("User Img"+user.getImg());

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
													class="collapse navbar-collapse w-75 justify-content-center align-items-center"
													id="navbarSupportedContent">
													<ul
														class="navbar-nav d-flex justify-content-center align-items-center w-75">


														<li class="nav-item text-center align-items-center w-50">
															<a class="nav-link  hovcol1 w-100 text-col" href="#home">Home</a>
														</li>
														<li class="nav-item w-50 text-center align-items-center">
															<a class="nav-link hovcol1 w-100 text-col" href="#about">About
																Us</a>
														</li>
														<li class="nav-item w-50 text-center align-items-center">
															<a class="nav-link hovcol1 w-100 text-col" href="#course">Courses</a>
														</li>
														<li class="nav-item w-50 text-center align-items-center">
															<a class="nav-link hovcol1 w-100 text-col"
															href="#contact">Contact Us</a>
														</li>


														<c:if test="${user!=null}">
															<li class="nav-item w-50 text-center align-items-center">

																<div class="dropdown">
																	<a class="dropdown-toggle btn btn-outline-warning mb-1"
																		href="#" role="button" id="dropdownMenuLink"
																		data-bs-toggle="dropdown" aria-expanded="false"> <img
																		src="<%=request.getContextPath()%>/upload_images/${user.getImg()}"
																		width="50" height="50" class="rounded-circle" /> <%=user.getName()%>
																	</a>
																	<ul class="dropdown-menu"
																		aria-labelledby="dropdownMenuLink">
																		<li><a class="dropdown-item"
																			href="<%=request.getContextPath()%>/user/profile.jsp">Profile</a></li>
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

	<section class="" id="home">
		<div class="">
			<video autoplay muted loop id="myVideo">
				<source
					src="<%=request.getContextPath()%>/vedio/RU - Ready for Anything-.mkv"
					type="video/mp4">
				Your browser does not support HTML5 video.
			</video>
			<div class="elfsight-app-221ca8b7-ecbc-40f4-9c16-653f6c12afcf"></div>
			<div
				class="d-lg-flex d-md-none justify-content-center align-items-center">
				<div class="content text-col">
					<h1>Believe Learning Center</h1>
					<p>Lorem ipsum dolor sit amet, an his etiam torquatos. Tollit
						soleat phaedrum te duo, eum cu recteque expetendis neglegentur. Cu
						mentitum maiestatis persequeris pro, pri ponderum tractatos ei. Id
						qui nemore latine molestiae, ad mutat oblique delicatissimi pro.</p>
				</div>

			</div>
		</div>
	</section>
	<section class="image-bg min-vh-100" id="about">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="container">
						<div class="row" style="margin-top: 200px;">
							<div class="col-12">

								<div class="">
									<h3
										class="py-3 d-flex justify-content-center align-items-center text-col">
										" Believe Learning Center Is For EveryPerson "</h3>
									<div class="d-flex justify-content-center align-items-center">
										<p class="w-50 text-col">Learn the Computer Sciences Or
											Computer Technology you want to learn for free. Make sure you
											learn the skills taught in this online course and use them
											effectively in your life.</p>
									</div>
									<div class="d-flex justify-content-center align-items-center">
										<p class="text-col">
											"You Can Achieve" <br> When You Believe <br>
											Somehow You Will <br> You Will When You Believe
										</p>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="py-3" id="course">
		<div class="container-fluid">
			<div class="col-12">
				<div class="container">

					<c:if test="${user!=null }">


						<h3 class="new-font-color text-col p-3 my-3" style="width: 125px;">
							Courses</h3>



						<div class="row">
							<c:forEach var="items" items="${categorylist}">
								<div class="col-lg-3 col-md-6">
									<div class="bluebox">
										<div class="first-box boxes">
											<div class="fast">
												<img
													src="<%=request.getContextPath()%>/upload_images/${items.img}"
													alt="bus" />
												<p class="pt-4 text-col">Interested in studying
												<p class="" style="font-weight: bold;">${items.title}</p>
												<p class="">${items.price }
													<span class="px-1"> Kyats</span>
												</p>
												</p>
											</div>
											<div class="background-btn">
												<c:if test="${user!=null}">
													<form method="post"
														action="<%=request.getContextPath()%>/EnrollServlet"
														class="d-flex justify-content-center"
														style="width: 500px;">
														<!-- class id and user id -->
														<input type="hidden" value="${user.id }"
															class="form-control" required name="userid"
															aria-describedby="emailHelp"> <input
															type="hidden" value="${items.id }" class="form-control"
															required name="classid" aria-describedby="emailHelp">
														<button type="submit"
															class="btn btn-outline-warning text-col hovcol w-50">
															View Course</button>

													</form>
													
												</c:if>

												<c:if test="${user==null}">
													<a href="<%=request.getContextPath()%>/user/login.jsp">View Course</a>
												</c:if>




											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>


					</c:if>
					<c:if test="${user==null }">
						<h3 class="new-font-color text-col p-3 my-3" style="width: 228px;">Popular
							Courses</h3>
						<div class="row">
							<div class="col-lg-3 col-md-6">
								<div class="bluebox">
									<div class="first-box boxes">
										<div class="fast">
											<img src="<%=request.getContextPath()%>/data/img/new1.jpg"
												alt="bus" />
											<p class="pt-4 text-col">Interested in studying
												Networking? Browse on
											<h4>Basic Networking course.</h4>
											</p>
										</div>
										<div class="background-btn">

											<c:if test="${user!=null}">
												<a href="<%=request.getContextPath()%>/user/enroll.jsp">Enroll
													Now</a>
											</c:if>
											<c:if test="${user==null}">
												<a href="<%=request.getContextPath()%>/user/login.jsp">Enroll
													Now</a>
											</c:if>

										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-3 col-md-6">
								<div class="bluebox">
									<div class="first-box boxes">
										<div class="fast">
											<img src="<%=request.getContextPath()%>/data/img/python.jpg"
												alt="bus" />
											<p class="pt-4 text-col">Interested in studying
												Programming?Browse on
											<h4>Python course.</h4>
											</p>
										</div>
										<div class="background-btn">
											<c:if test="${user!=null}">
												<a
													href="<%=request.getContextPath()%>/user/pythonEnroll.jsp">Enroll
													Now</a>
											</c:if>
											<c:if test="${user==null}">
												<a href="<%=request.getContextPath()%>/user/login.jsp">Enroll
													Now</a>
											</c:if>

										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-3 col-md-6">
								<div class="bluebox">
									<div class="first-box boxes">
										<div class="fast">
											<img src="<%=request.getContextPath()%>/data/img/about4.jpg"
												alt="bus" />
											<p class="pt-4 mb-0 text-col">Interested in studying
												Business?Browse on
											<h4>Business Administration course.</h4>
											</p>
										</div>
										<div class="background-btn">
											<c:if test="${user!=null}">
												<a href="<%=request.getContextPath()%>/user/baenroll.jsp">Enroll
													Now</a>
											</c:if>
											<c:if test="${user==null}">
												<a href="<%=request.getContextPath()%>/user/login.jsp">Enroll
													Now</a>
											</c:if>

										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-3 col-md-6">
								<div class="bluebox">
									<div class="first-box boxes">
										<div class="fast">
											<img
												src="<%=request.getContextPath()%>/data/img/accounting.jpg"
												alt="bus" />
											<p class="pt-4 text-col">Interested in studying
												Finance?Browse on
											<h4>Accounting course.</h4>
											</p>
										</div>
										<div class="background-btn">
											<c:if test="${user!=null}">
												<a href="<%=request.getContextPath()%>/user/acenroll.jsp">Enroll
													Now</a>
											</c:if>
											<c:if test="${user==null}">
												<a href="<%=request.getContextPath()%>/user/login.jsp">Enroll
													Now</a>
											</c:if>
										</div>
									</div>
								</div>
							</div>

						</div>
					</c:if>

				</div>
			</div>
		</div>
	</section>
	<section class="py-3 my-5" id="news">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="container">
						<div class="row">
							<div class="col-lg-6 col-md-12">
								<div class="">
									<div id="carouselExampleCaptions" class="carousel slide"
										data-bs-ride="carousel">

										<div class="carousel-inner">
											<div class="carousel-item active">
												<img src="<%=request.getContextPath()%>/data/img/new1.jpg"
													class="d-block w-100" alt="...">
											</div>
											<div class="carousel-item">
												<img src="<%=request.getContextPath()%>/data/img/new3.jpg"
													class="d-block w-100" alt="...">
											</div>
											<div class="carousel-item">
												<img src="<%=request.getContextPath()%>/data/img/new2.jpg"
													class="d-block w-100" alt="...">
											</div>
										</div>
										<div
											class="d-flex justify-content-end align-items-center pt-3">
											<button class="carousel-btn" type="button"
												data-bs-target="#carouselExampleCaptions"
												data-bs-slide="prev">
												<span class="carousel-control-prev-icon" aria-hidden="true"></span>

											</button>
											<button class="carousel-btn" type="button"
												data-bs-target="#carouselExampleCaptions"
												data-bs-slide="next">
												<span class="carousel-control-next-icon" aria-hidden="true"></span>

											</button>
										</div>
									</div>

								</div>
							</div>
							<div class="col-lg-6 col-md-12 ">

								<h2 class="text-col new-font-color text-center"
									style="width: 100px;">News</h2>
								<div class="row">
									<div class="col-md-6">
										<a
											href="https://www.miit.edu.mm/news/asean-india-research-training-fellowship"
											class="text-col1 fw-bold"> ASEAN-India Research Training
											Fellowship </a>
										<p class="text-black-50 py-2">The ASEAN-India Research
											Training Fellowship (AIRTF) Scheme is a flagship funding
											program started by the Department of Science & Technology
											(DST), Government of India under the ASEAN-India Science and
											Technology Development Fund (AISTDF),....</p>
										<hr>
									</div>
									<div class="col-md-6">
										<a
											href="https://www.miit.edu.mm/news/learning-in-the-time-of-covid-19"
											class="text-col1 fw-bold"> Learning in the time of
											Covid-19 </a>
										<p class="text-black-50 py-2">For the last six months, the
											entire world has struggled to deal with the impacts of the
											Covid-19 epidemic. Responses have ranged from extremely
											successful to downright dismal. Although the case load in
											Myanmar has never been too high, a globalised economy means
											that no one lives in......</p>
										<hr>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<a href="https://www.bbc.com/news/technology-64512059"
											class="text-col1 fw-bold"> Digital cameras back in
											fashion after online revival </a>
										<p class="text-black-50 py-2">Digital cameras from the
											early 2000s are becoming must-have gadgets for many young
											people because of a burgeoning trend online. Search traffic
											for old kit on online marketplaces like eBay and Etsy is on
											the rise.</p>
										<hr>
									</div>
									<div class="col-md-6">
										<a href="https://www.bbc.com/news/technology-64536590"
											class="text-col1 fw-bold"> Tech lay-offs: Dell to cut
											workforce</a>
										<p class="text-black-50 py-2">Dell is to lay off about
											6,650 workers because of the decline in demand for personal
											computers. The job cuts are expected to affect about 5% of
											its global workforce.</p>
										<hr>
									</div>
								</div>
								<a href="https://www.bbc.com/news/technology"
									class="text-col1 text-center d-flex justify-content-end fs-3">view
									all News</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="" id="partner">
		<div class="container-fluid">
			<div class="col-12 ">
				<div class="container">

					<div class="row">
						<div class="col-12">
							<div
								class="d-flex justify-content-center align-items-center w-100">
								<img
									src="<%=request.getContextPath()%>/data/logo/Google-Logo.png"
									alt="" class="me-2 img-with"> <img
									src="<%=request.getContextPath()%>/data/logo/images%20(1).jpg"
									alt="" class=""> <img
									src="<%=request.getContextPath()%>/data/logo/whatapp.jpg"
									alt="" class="img-with">
							</div>
						</div>

					</div>
					<div class="row ">
						<div class="col-md-12 p-5">
							<div class="d-flex">
								<div
									class="card profile shadow book-card w-50 d-flex justify-content-center align-items-center mb-5"
									style="visibility: visible; animation-name: slideInRight;">
									<div class="row">
										<div class="col-md-4">
											<img
												src="<%=request.getContextPath()%>/data/JPG/Artboard%201-100.jpg"
												class="img-fluid rounded-start p-2" alt="...">
										</div>
										<div class="col-8 p-0">
											<div class="card-body">
												<p
													class="d-flex card-text text-center font-weight-light font-card">
													If you aren't using Hala Talents, you're missing out,
													groundbreaking stuff. I am very pleased</p>
											</div>
										</div>
									</div>

									<div class="d-flex justify-content-center align-items-center">
										<img src="<%=request.getContextPath()%>/data/img/sarkura.png"
											class="card-img-top profile-card" alt="...">
									</div>
								</div>
								<div
									class="mx-1 card profile shadow book-card w-50 d-flex justify-content-center align-items-center mb-5"
									style="visibility: visible; animation-name: slideInRight;">
									<div class="row">
										<div class="col-md-4">
											<img
												src="<%=request.getContextPath()%>/data/JPG/Artboard%201-100.jpg"
												class="img-fluid rounded-start p-2" alt="...">
										</div>
										<div class="col-8 p-0">
											<div class="card-body">
												<p
													class="d-flex card-text text-center font-weight-light font-card">
													If you aren't using Hala Talents, you're missing out,
													groundbreaking stuff. I am very pleased</p>
											</div>
										</div>
									</div>

									<div class="d-flex justify-content-center align-items-center">
										<img src="<%=request.getContextPath()%>/data/img/sarkura.png"
											class="card-img-top profile-card" alt="...">
									</div>
								</div>
								<div
									class="card profile shadow book-card w-50 d-flex justify-content-center align-items-center mb-5"
									style="visibility: visible; animation-name: slideInRight;">
									<div class="row">
										<div class="col-md-4">
											<img
												src="<%=request.getContextPath()%>/data/JPG/Artboard%201-100.jpg"
												class="img-fluid rounded-start p-2" alt="...">
										</div>
										<div class="col-8 p-0">
											<div class="card-body">
												<p
													class="d-flex card-text text-center font-weight-light font-card">
													If you aren't using Hala Talents, you're missing out,
													groundbreaking stuff. I am very pleased</p>
											</div>
										</div>
									</div>

									<div class="d-flex justify-content-center align-items-center">
										<img src="<%=request.getContextPath()%>/data/img/sarkura.png"
											class="card-img-top profile-card" alt="...">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="" id="contact">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="container">
						<div class="d-flex justify-content-start">
							<h3 class="text-col new-font-color p-2" style="width: 144px;">Contact
								Us</h3>

						</div>
						<div class="row mt-5">

							<div class="col-12 col-md-6">
								<form action="<%=request.getContextPath()%>/MessageServlet"
									method="post">
									<div class="form-group">
										<input type="text" name="cname" class="form-control"
											placeholder="Name">
									</div>
									<div class="form-group py-2">
										<input type="email" name="cemail" class="form-control"
											placeholder="Email">
									</div>
									<div class="form-group pb-2">
										<textarea type="text" name="cmessage" class="form-control"
											rows="5" placeholder="Message"></textarea>
									</div>
									<div class="form-group">
										<button class="btn new-font-color text-col" type="submit">
											Send Message</button>
									</div>
								</form>
							</div>
							<div class="col-12 col-md-6">
								<iframe
									src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6491.409325480356!2d97.21881356603336!3d19.694855427407283!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x30cf9bd9dc85195d%3A0x8b34fc6a026b5097!2sUniversity%20of%20Computer%20Studies%2CLoikaw(UCSL)!5e0!3m2!1smy!2smm!4v1672410570956!5m2!1smy!2smm"
									width="450" height="350" style="border: 0;" allowfullscreen=""
									loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="footer" class="">
		<div class="container-fluid base-footer">
			<div class="row">
				<div class="col-12">

					<div class="container">
						<div class="row">
							<div
								class="m-0 p-0 col-md-6 col-lg-3 d-flex align-items-center justify-content-center">
								<img
									src="<%=request.getContextPath()%>/data/PNG/Artboard%201.png"
									alt="" class="w-50">
							</div>
							<div class="col-md-6 col-lg-3">
								<div class="row">
									<div class="col-md-12 ">
										<div class="">
											<h3 class="text-col">Contacts</h3>
										</div>
										<a href="#" class="d-flex text-decoration-none"> <i
											class="fa fa-phone text-col me-2 icon"></i>
											<p class="text-col">+(959) 777 888 99</p>
										</a> <a href="#" class="d-flex text-decoration-none"> <i
											class="fa fa-map-marker text-col me-2 icon"></i>
											<p class="text-col">Burma</p>
										</a> <a href="mailto:yewinmaung@ucsloikaw.edu.mm"
											class="d-flex text-decoration-none"> <i
											class="fa fa-envelope text-col me-2 icon"></i>
											<p class="text-col">info.suitacademy@gmail.com</p>
										</a>
									</div>

								</div>
							</div>
							<div
								class="col-md-6 col-lg-3 d-flex justify-content-center align-items-center">
								<div class="row">
									<div class="col-md-12">
										<div class="">
											<h3 class="text-col">Social Contacts</h3>
										</div>
										<a href="#"
											class="d-flex mb-2 text-decoration-none footer-font"> <i
											class="fa-brands fa-facebook text-col me-2 icon"> </i> <span
											class="text-col">Facebook</span>
										</a> <a href="#"
											class="d-flex mb-2 text-decoration-none footer-font"> <i
											class="fa-brands text-col fa-instagram-square me-2 icon">

										</i> <span class="text-col">Instagram</span>
										</a> <a href="#"
											class="d-flex mb-2 text-decoration-none footer-font"> <i
											class="fa-brands text-col fa-youtube-square me-2 icon"> </i>
											<span class="text-col">Youtube</span>
										</a> <a href="#" class="d-flex text-decoration-none footer-font">
											<i class="fa-brands text-col fa-linkedin-in me-2 icon"> </i>
											<span class="text-col">LinkIn</span>
										</a>
									</div>

								</div>
							</div>
							<div class="col-md-6 col-lg-3">
								<div class="">
									<h3 class=" text-col">Quick Links</h3>
								</div>
								<div class="row">
									<div class="col-md-12">
										<a href="#home" class="d-flex text-decoration-none">
											<p class="text-col">Home</p>
										</a> <a href="#about" class="d-flex text-decoration-none">
											<p class="text-col">About Us</p>
										</a> <a href="#course" class="d-flex text-decoration-none">
											<p class="text-col">Courses</p>
										</a> <a href="#contact" class="d-flex text-decoration-none">
											<p class="text-col">Contact us</p>
										</a>
									</div>

								</div>
							</div>
						</div>
						<div class="row">
							<div class="text-col d-flex justify-content-around">
								<small class="">Copyright &copy;Media_Source</small> <i class="">Created
									by</i> <small> Group 4 </small>
							</div>
						</div>
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