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
<title>Room Details:</title>
</head>
<body class="roomDetailsBody">
	<nav class="navbar navbar-expand-sm py-3" id="roomDetailsNavBar">
	<ul class="navbar-nav">
		<li class="navHomeLi"><a class="navButton" id="homeButton" href="home.jsp">Home</a></li>
		<li class="navLi"><a class="navButton" href="search.jsp">Search</a></li>
		<li class="navLi"><a class="navButton" href="getCancellableReservations">Cancel</a></li>
		<li class="navLi"><a class="navButton" href="collectReviewInfo">Review</a></li>
		<c:if test="${sessionScope.alma == 'ADMIN'}">
			<li class="navLi"><a class="navButton" href="collectModificationInfo">Modify</a></li>
		</c:if>
	</ul>
	<ul class="navbar-nav ml-auto">
		<li class="navLi"><a class="navButton" href="${pageContext.request.contextPath}/logout" role="button">Logout</a></li>
	</ul>
</nav>
	<div class="row" style="width: 1450px;">
	<div class="roomDetailsContainerDateAndRoomSize">
	<div class="column m-3">
		<div>
			<h2>Reservation: ${dateFrom} - ${dateTo}</h2>
		</div>
		<div>
			<h2>
				Room size: ${room.roomSize} m<sup>2</sup>
			</h2>
		</div>
		</div>
	</div>
		<div class="column mt-4 ml-4">
				<form action="${pageContext.request.contextPath}/admin/reserve" method="post">
					<input name="roomId" type="hidden" value="${room.roomId}">
					<input name="dateFrom" type="hidden" value="${dateFrom}">
					<input name="dateTo" type="hidden" value="${dateTo}">
					<input class="reserveRoomButton" type="submit" value="Reserve">
				</form>
			</div>
			</div>
	<div class="roomDetailsContainerPictureAndDetails">
		<div class="row">
			<div class="column mr-3">
				<img src="../pictures/hotel-room.jpg" alt="hotel-room" style="width: 100%">
			</div>
			<div class="column ml-5 m-3">
				<h3>Services:</h3>
				<ul>
					<c:forEach items="${services}" var="service">
						<li>${service.serviceName}</li>
					</c:forEach>
				</ul>
			</div>
			<div class="column mt-3">
				<h3>Equipments:</h3>
				<ul>
					<c:forEach items="${equipments}" var="equipment">
						<li>${equipment.name}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>