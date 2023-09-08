<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="icon" href="../data/PNG/Artboard%201.png">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/card.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
</head>
<body>
<div class="d-flex justify-content-center align-items-center min-vh-100 my-2">
  <form class="form-control w-25 own_bg" action="<%=request.getContextPath() %>/UserServlet" method="post">
    <div class="w-100">
      <img src="<%=request.getContextPath() %>/data/SVG/Artboard%201.svg" alt="" class="w-50 h-50">
    </div>
    <c:if test="${not empty loginError}">
         <div class="alert alert-danger ">E-mail is Used !</div>
     </c:if>
     <div class="row">
       <div class="col-md-12 col-12">
         <input type="text" class="form-control" name="name" placeholder="Name">

       </div>
       <div class="col-md-12 col-12 py-2">
        <input type="email" class="form-control" name="email" placeholder="E-mail">

      </div>
      <div class="col-md-12 col-12">
        <input type="password" class="form-control" name="password" placeholder="Password">
      </div>
    </div>
     
    <div class="row pt-2">
    <div class="">
     <a href="<%=request.getContextPath() %>/user/login.jsp" class="text-warning text-decoration-none">SignIn</a>
     </div>
      <div class="d-flex justify-content-end">
        <button class="btn btn-outline-warning hovcol mx-1" type="reset">Cancel</button>
        <button class="btn btn-outline-warning hovcol" type="submit">Sign Up</button>
      </div>
     </div>
   
  </form>

</div>

<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/js/all.min.js"></script>
<script src="<%=request.getContextPath() %>/js/own.js"></script>
<script src="https://static.elfsight.com/platform/platform.js" data-use-service-core defer></script>

</body>
</html>