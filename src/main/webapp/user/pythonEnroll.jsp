<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<link rel="icon" href="<%=request.getContextPath() %>/data/PNG/Artboard%201.png">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/card.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
</head>
<body>
<%
	User user = (User) session.getAttribute("user");

	String name = (String) session.getAttribute("name");
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
																	<a class="dropdown-toggle btn btn-outline-warning mb-1" href="#" role="button"
																		id="dropdownMenuLink" data-bs-toggle="dropdown"
																		aria-expanded="false"> <%=user.getName()%>
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
																	<a class=" dropdown-toggle btn btn-outline-warning mb-2" href="#" role="button"
																		id="dropdownMenuLink" data-bs-toggle="dropdown"
																		aria-expanded="false"> SignUp/Login </a>
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
										   
                                            <nav aria-label="breadcrumb" style="background-color:rgba(5, 5, 154, 0.86)!important;">
                                                <ol class="breadcrumb new-font-color p-2" style="width: 123px;">
                                                    <li class="breadcrumb-item "><a href="index.jsp" class="text-col text-decoration-none">Home</a></li>
                                                   <li class="breadcrumb-item active text-col" aria-current="page">Python</li>
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

<div class="h-100 w-50" style="padding-top: 8%;"></div>
<section class="">
    <div class="container-fluid enroll-min-bg min-vh-100">
        <div class="col-12">
            <div class="container">
              <div class="row pt-5">
                  <div class="col-12">
                      <div class="d-flex justify-content-center align-items-center">
                          <form method="post" action="<%=request.getContextPath() %>/PaymentServlet" class="form-control own_bg px-3" style="width: 500px;">
                              <div class="d-flex w-100 justify-content-center align-items-center">
                                  <img src="<%=request.getContextPath() %>/data/SVG/Artboard%201.svg" alt="" class="w-50 h-50">

                              </div>
                               <c:if test="${not empty paymentError}">
						         <div class="alert alert-danger ">Your BankAccount is Invilid!</div>
						     </c:if>
						     <c:if test="${not empty amountError}">
						         <div class="alert alert-danger ">Your have not enough money!</div>
						     </c:if>
                              <div class="my-3 w-100 d-flex justify-content-center align-items-center">
                              <div class="w-100">
                                  <label for="exampleInputEmail1" class="form-label text-col">Name</label>
                                  <input type="text" class="form-control" required name="name" aria-describedby="emailHelp">
                              </div>
                              </div>
                              <div class="mb-3 w-100 d-flex justify-content-center align-items-center">
                              <div class="w-100">
                                  <label for="exampleInputPassword1" class="form-label text-col">E-mail</label>
                                  <input type="email" required class="form-control" name="email">
                              </div>
                              </div>
                               <div class="row">
                                   <div class="col-12 col-md-6">
                                       <img src="<%=request.getContextPath() %>/data/img/bank_logo.png" alt="" class="bg-light w-100">
                                   </div>
                                   <div class="col-12 col-md-6">
                                     
                                          
                                          <div class="w-100">
                                  <label for="exampleInputPassword1" class="form-label text-col">Account No</label>
                                  <input type="text" required class="form-control" name="accno">
                                 </div>
                                            
                                           
                                           </div>
                                   <div class="w-100 d-flex justify-content-end align-items-center py-3">
                                        
                                      <button type="reset" class="btn btn-outline-warning text-col hovcol w-25 mx-1">Cancel</button>
							           <button type="submit" class="btn btn-outline-warning text-col hovcol w-25">Enroll</button>
							
                                        </div>
                               </div>


                          </form>
                      </div>
                  </div>
              </div>
    </div>
        </div>
    </div>
</section>
<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/js/all.min.js"></script>
<script src="<%=request.getContextPath() %>/js/own.js"></script>
<script src="https://static.elfsight.com/platform/platform.js" data-use-service-core defer></script>

</body>
</html>