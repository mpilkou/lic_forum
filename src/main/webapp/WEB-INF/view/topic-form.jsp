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
		
	<title>Topic Form</title>
</head>
<body>
<div id = "body">

	<div id="main">
		
		<form:form action = "addTopic" modelAttribute = "topic" metod = "POST">
			<div class="form-group row">
				<label for="inputTopic1" class="col-sm-2 col-form-label">Topic</label>
				<div class="col-sm-10">
				  	<input type="text" class="form-control" id="inputTopic1" placeholder="Topic" name="topic_name" >
				</div>
			 </div>
			 <div class="form-group row">
				<label for="inputText1" class="col-sm-2 col-form-label">Text</label>
				<div class="col-sm-10">
				  	<input type="text" class="form-control" id="inputText1" placeholder="Text" name="topic_text">
				</div>
			 </div>
			 <div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary" value="Save">Save</button>
				</div>
	 		</div>
	 		
	 		<div>
				<a href="${pageContext.request.contextPath}/forum/themes" class="btn btn-outline-info" role="button" aria-pressed="true"><-Back</a>
			</div>
	 		
	 	</form:form>
	</div>
</div>
	
</body>
</html>


