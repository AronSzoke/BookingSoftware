<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/shc-new.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Modification of Room Price</title>
</head>
<body class="roomModificationBody">
	<nav class="navbar navbar-expand-sm" id="roomModificationNavBar">
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
	<a id="back-to-top" href="#" class="btn btn-info btn-lg back-to-top" role="button">
		<i class="fas fa-chevron-up"></i>
	</a>
	<div class="row" id="roomModificationRow">
		<div class="column">
			<h1 class="roomModificationHeading">Modification of Room Price</h1>
		</div>
		<div class="column">
			<button class="roomModificationButton" type="submit" form="saveForm">Save All</button>
		</div>
	</div>
	
	<div class="container" id="roomModificationContainer">
		<c:if test="${success eq 'true'}">
			<div class="alert alert-success">All modifications have been saved successfully!</div>
		</c:if>
		<c:if test="${saveFailed eq 'true'}">
			<div class="alert alert-danger">Modifications have not been saved!</div>
		</c:if>
		<form id="saveForm" action="saveRoomChanges" method="post">
			<table class="table table-hover table-striped">
				<thead class="text-center">
					<tr>
						<th>Hotel Id</th>
						<th>Room Id</th>
						<th>Room Number</th>
						<th>Room Type</th>
						<th>Room Size</th>
						<th>Floor</th>
						<th>Room Price</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<c:forEach items="${rooms}" var="room">
						<tr>
							<td>${room.hotelId}</td>
							<td>${room.roomId}</td>
							<td>${room.roomNumber}</td>
							<td>${room.roomType}</td>
							<td>${room.roomSize}</td>
							<td>${room.floor}</td>
							<%-- 							<td><input class="text-center" type="number" min="0" max="1000000" name="roomPrice_${room.roomId}" value="${room.roomPrice}"></td> --%>
							<td><input class="text-right" type="text" name="roomPrice_${room.roomId}" min="0" max="1000000" value="<fmt:setLocale value="en_US" /><fmt:formatNumber type="number" maxFractionDigits="0" value="${room.roomPrice}" />"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$(window).scroll(function() {
				if ($(this).scrollTop() > 50) {
					$('#back-to-top').fadeIn();
				} else {
					$('#back-to-top').fadeOut();
				}
			});
			// scroll body to 0px on click
			$('#back-to-top').click(function() {
				$('body,html').animate({
					scrollTop : 0
				}, 400);
				return false;
			});
		});
	</script>
</body>
</html>