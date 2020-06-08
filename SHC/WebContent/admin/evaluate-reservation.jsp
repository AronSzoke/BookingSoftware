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
<title>Submit Your Review</title>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/shc-new.css">
</head>
<body class="evaluateReservationBody">
	<jsp:include page="navigation.jsp" />
	<div class="container">
		<h1 class="my-4">Reservation To Review</h1>
		<div class="alert alert-danger" id="errorMessage" style="display: none;">Please ensure that a review score is selected!</div>
		<table class="table table-hover table-striped" id="evaluateReviewTable">
			<thead>
				<tr>
					<th>Hotel Name</th>
					<th>Address</th>
					<th>Date From</th>
					<th>Date To</th>
					<th>Room Type</th>
					<th>Total Price</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${param.hotelName}</td>
					<td>${param.address}</td>
					<td>${param.dateFrom}</td>
					<td>${param.dateTo}</td>
					<td>${param.roomType}</td>
					<td>${param.totalPrice}</td>
				</tr>
			</tbody>
		</table>
		<form action="review" method="post" id="reviewForm">
			<div class="reviewTextHeading">
				<h3>
					<label for="reviewText">Enter Your Review:</label>
				</h3>
			</div>
			<div class="reviewTextBox d-flex">
				<textarea id="reviewText" rows="10" cols="137" maxlength="500" name="reviewText" form="reviewForm"></textarea>
			</div>
			<div class="starrating d-flex flex-row-reverse" id="starRating">
				<input type="radio" id="star5" name="reviewScore" value="5" />
				<label for="star5" title="Excelent"></label>
				<input type="radio" id="star4" name="reviewScore" value="4" />
				<label for="star4" title="Good"></label>
				<input type="radio" id="star3" name="reviewScore" value="3" />
				<label for="star3" title="Average"></label>
				<input type="radio" id="star2" name="reviewScore" value="2" />
				<label for="star2" title="Poor"></label>
				<input type="radio" id="star1" name="reviewScore" value="1" />
				<label for="star1" title="Very Bad"></label>
			</div>
			<div id="errorMessage" class="error"></div>
			<input type="hidden" name="reservationId" value="${param.reservationId}">
			<input id="reviewSubmitButton" type="submit" value="Submit">
		</form>
	</div>
	<script type="text/javascript">
		// When your page is ready, wire up these events
		$(function() {
			// When your submit button is clicked
			$("form").submit(function(e) {
				// If it is not checked, prevent the default behavior (your submit)
				if (!$('input[name="reviewScore"]').is(':checked')) {
					document.getElementById('errorMessage').style='display:block;';
					e.preventDefault();
				}
			});
		});
	</script>
</body>
</html>