<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/shc-new.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Cancellation</title>
</head>
<body class="reservationCancellationBody">
		<nav class="navbar navbar-expand-sm py-3" id="reservationCancellationNavBar">
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
	<div class="container">
		<h1 class="reservationCancellationHeading">Reservations:</h1>
		<table class="table table-hover table-striped" id="reservationCancellationTable">
			<thead class="reservationCancellationTableHead">
				<tr>
					<th>Hotel</th>
					<th>Address</th>
					<th>Date From</th>
					<th>Date To</th>
					<th>Total Price</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty validReservations}">
					<tr>
						<td class="text-center" colspan="7">No active reservations to display</td>
					</tr>
				</c:if>
				<c:forEach items="${validReservations}" var="validReservation">
					<tr>
						<td>${validReservation.hotelName}</td>
						<td>${validReservation.address}</td>
						<td>${validReservation.dateFrom}</td>
						<td>${validReservation.dateTo}</td>
						<td>${validReservation.totalPrice}</td>
						<td>
							<form action="cancelReservation" method="post">
								<input type="hidden" name="reservationId" value="${validReservation.reservationId}">
								<input class="reservationCancellationButton" type="submit" value="Cancel">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>