<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html style="height: calc(100% - 38px);">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/shc-new.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<body class="homeBody">
	<jsp:include page="navigation.jsp" />
	<p class="welcome-text">
		Welcome
		<c:out value='${sessionScope.loggedInUser.firstName}' />
		!
	</p>
	<div class="container d-flex justify-content-center">
		<div id="demo" class="carousel slide" data-ride="carousel">

			<!-- Indicators -->
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
				<li data-target="#demo" data-slide-to="3"></li>
				<li data-target="#demo" data-slide-to="4"></li>
				<li data-target="#demo" data-slide-to="5"></li>
			</ul>

			<!-- The slideshow -->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="../pictures/seaside9.jpg" alt="Los Angeles">
				</div>
				<div class="carousel-item">
					<img src="../pictures/seaside3.jpg" alt="Los Angeles">
				</div>
				<div class="carousel-item">
					<img src="../pictures/seaside5.jpg" alt="Chicago">
				</div>
				<div class="carousel-item">
					<img src="../pictures/seaside6.jpg" alt="New York">
				</div>
				<div class="carousel-item">
					<img src="../pictures/test-carousel.jpg" alt="New York">
				</div>
				<div class="carousel-item">
					<img src="../pictures/seaside7.jpg" alt="New York">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a>
			<a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		</div>
	</div>
</body>
</html>