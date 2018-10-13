<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/main.css"/>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light" rel="stylesheet"> 
	
	<title>Forum</title>
</head>
<body>
	
	<div id = "body">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<!--   ${pageContext.request.contextPath}/scores-->
				<a class="navbar-brand" href="http://localhost:80/project/index.html">
					<i class="fas fa-gamepad"></i>
					Game 
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent1">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/chat/themes">
								<i class="far fa-comments"></i>
								Chat
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/scores/scores">
								<i class="fas fa-align-justify"></i>
								Scores
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/forum/themes">
								<i class="far fa-comment"></i>
								Forum
							</a>
						</li>
						
					</ul>
					
				</div>	
			</div>
		</nav>
	
		<div id = "main">
		
			
			
			<input type="button" id = "myinput" class="btn btn-outline-light" 
				value="Add Topic" onclick="window.location.href='addTopicForm'"/>
		
			<table class = "score text">
			
				<tr>
					<th>
						Topic theme
					</th>
					<th>
						Topic text
					</th>
				</tr>
				<c:forEach var = "topic" items = "${topics}">
					<tr>
						<td> ${topic.topic_name} </td>
						<td> ${topic.topic_text} </td>
					</tr>
				</c:forEach>
			</table>
			
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