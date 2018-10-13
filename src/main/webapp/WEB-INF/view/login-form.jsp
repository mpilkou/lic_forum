<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/login.css"/>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light" rel="stylesheet"> 
	
	<title>Login Form</title>


</head>
<body>
	<div id = "main">
		<form:form action = "${pageContext.request.contextPath}/loginUser" metod = "POST">
			<c:if test="${param.error != null}">					
				<div class="alert alert-danger col-xs-offset-1 col-xs-10">
					invalid username or password
				</div>
			</c:if>
			 <div class="form-group row">
				<label for="inputUserName1" class="col-sm-2 col-form-label">Nick</label>
				<div class="col-sm-10">
				  	<input type="text" class="form-control" id="inputUserName1" placeholder="Username" name="username" >
				</div>
			 </div>
			 <div class="form-group row">
				<label for="inputPassword1" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
				  	<input type="password" class="form-control" id="inputPassword1" placeholder="Password" name="password">
				</div>
			 </div>
			 <div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary" value="Login">Log in</button>
				</div>
		 	</div>
		</form:form>
		
		<div>
			<a href="${pageContext.request.contextPath}/registration/signupForm" class="btn btn-primary" role="button" aria-pressed="true">New User</a>
		</div>
	</div>

	
	
	<div id="end">
		<i>Developed by: Matsvei Pilkou</i>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
</body>
</html>


