<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="icon" href="<%=request.getContextPath() %>/data/PNG/Artboard%201.png">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/card.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
</head>
<body>
<div class="d-flex justify-content-center align-items-center min-vh-100">
     
    <form action="<%=request.getContextPath() %>/UserLoginServlet" class="form-control w-25 own_bg" method="post">
       
        <div class="d-flex w-100 justify-content-center align-items-center">
            <img src="<%=request.getContextPath() %>/data/SVG/Artboard%201.svg" alt="" class="w-50 h-50">

        </div>
        
           <c:if test="${not empty adminError}">
         <div class="alert alert-danger ">Your Account is Invilid!</div>
     </c:if>
        <div class="my-3">
            <label for="exampleInputEmail1" class="form-label text-col">Email</label>
            <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label text-col">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1">
        </div>


        <div class="d-flex justify-content-end align-items-center">
             <button type="submit" class="btn btn-outline-warning hovcol w-50">Login</button>
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