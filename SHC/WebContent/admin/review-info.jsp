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
<title>Review</title>
</head>
<body class="rewiewInfoBody">
	<jsp:include page="navigation.jsp" />
	<div class="container">
		<h1 class="my-3">Active Reservations</h1>
		<table class="table table-hover table-striped" id="reviewInfoTable">
			<thead class="reviewInfoTableHead">
				<tr>
					<th style="font-size: large">Hotel Name</th>
					<th style="font-size: large">Address</th>
					<th style="font-size: large">Date From</th>
					<th style="font-size: large">Date To</th>
					<th style="font-size: large">Room Type</th>
					<th style="font-size: large">Total Price</th>
					<th style="font-size: large"></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty reservationsToReview}">
					<tr>
						<td class="text-center" colspan="7">No reservations to review</td>
					</tr>
				</c:if>
				<c:forEach items="${reservationsToReview}" var="reservationToReview">
					<tr>
						<td>${reservationToReview.hotelName}</td>
						<td>${reservationToReview.address}</td>
						<td>${reservationToReview.dateFrom}</td>
						<td>${reservationToReview.dateTo}</td>
						<td>${reservationToReview.roomType}</td>
						<td>${reservationToReview.totalPrice}</td>
						<td>
							<form action="evaluate-reservation.jsp" method="post">
								<input class="btn btn-primary" id="reviewInfoButton" type="submit" value="Review">
								<input type="hidden" name="hotelName" value="${reservationToReview.hotelName}">
								<input type="hidden" name="address" value="${reservationToReview.address}">
								<input type="hidden" name="dateFrom" value="${reservationToReview.dateFrom}">
								<input type="hidden" name="dateTo" value="${reservationToReview.dateTo}">
								<input type="hidden" name="roomType" value="${reservationToReview.roomType}">
								<input type="hidden" name="totalPrice" value="${reservationToReview.totalPrice}">
								<input type="hidden" name="reservationId" value="${reservationToReview.reservationId}">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>