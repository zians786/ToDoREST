<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

<title>Insert title here</title>
</head>
<body>



<div class="Container">
<c:set var="details" value="${message}" />
<c:if test="${details!=null}">
<c:out value="${details}"></c:out>
</c:if>
	
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4">

				<div class="form-box">
					<div class="form-top">
						<div class="form-top-left">
							<h3>Login to our site</h3>
							<p>Enter username and password :</p>
						</div>
						<div class="form-top-right">
							<i class="fa fa-key"></i>
						</div>
					</div>
					<div class="form-bottom">
						<form role="form" action="login" name="loginForm" method="post"
							class="login-form">
							<div class="form-group">

								<input id="name" type="text" name="userName"
									placeholder="Username..." class=" form-control" required>
								 <span class="name" style="color:#19b9e7"></span>
							</div>
							<div class="form-group">

								<input id="password" type="password" name="password" placeholder="Password..."
									class="form-control" required>
									<span class="password" style="color:#19b9e7"></span>
							</div>
							<div class="form-group">

								<button type="submit" class="btn">Sign in!</button>
							</div>
							<div class="form-group">
								<a href="registration.jsp" >New
									Registration ?</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>


	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/scripts.js"></script>

	<!--  
    <form action="login.jsp" method="post">  
    UserName:
    <input type="text" name="userName"/><br/> 
    Password: 
    <input type="password" name="password"/><br/>  
    <input type="submit" value="login"/>
    
    </form>  
    <br><a href="registration.jsp" class="btn btn-danger" role="button" >Register</a>
-->
</body>
</html>