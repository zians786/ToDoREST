<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Register</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

<title>Insert title here</title>
</head>
<body>


<!-- 

<form action="Registration" Method="post">  
    Username:<input type="text" name="userName" /><br/>  
    Email:<input type="text" name="email"  /><br/>  
    Password:<input type="password" name="password"  /><br/>
     Number: <input type="text" name="number"  /><br/>
    <input type="submit" value="register"/>  
    </form>  
 -->
  <div class="container">
  
  <c:set var="details" value="${message}" />
<c:if test="${details!=null}">
<c:out value="${details}"></c:out>
</c:if>
  

          <div class="row">
            <div class="col-sm-6 col-sm-offset-3">

              <div class="form-box">
                <div class="form-top">
                  <div class="form-top-left">
                    <h3>Sign up now</h3>
                      <p>Fill in the form below to get access:</p>
                  </div>
                  <div class="form-top-right">
                    <i class="fa fa-pencil"></i>
                  </div>
                  </div>
                  <div class="form-bottom">
                <form role="form" action="registration" name="register" method="post" class="registration-form">
                  <div class="form-group">
                      <input id="name" type="text" name="userName" placeholder="Username..."class=" form-control" required>
                       <span class="name" style="color:#19b9e7"></span>
                    </div>
                    <div class="form-group">
                      <input id="email" type="text" name="email" placeholder="Email..." class=" form-control" >
                    <span class="email" style="color:#19b9e7"></span>
                    <span class="emailAjax" style="color:#19b9e7"></span>
                    </div>
                    <div class="form-group">
                      <input id="password" type="password" name="password" placeholder="Password..."class="form-control" required >
                      <span class="password" style="color:#19b9e7"></span>
                      
                    </div>
                   
                   <div class="form-group">
                      <input id="confirm" type="password" name="password" placeholder="Confirm Password..."class="form-control" required>
                      <span class="confirm" style="color:#19b9e7"></span>
                    </div>
                   
                    <div class="form-group">
                      <input id="number" type="text" name="number" placeholder="Mobile Number" class=" form-control"  required>
                      <span class="number" style="color:#19b9e7"></span>
                              </div>
                    <button type="submit" class="btn">Sign me up!</button>
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
        

</body>
</html>