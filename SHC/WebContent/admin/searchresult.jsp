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
<title>Search</title>
</head>
<body>
<body class="searchResultBody">
	<nav class="navbar navbar-expand-sm py-3" id="searchResultNavBar">
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
		<h1 class="searchResultTableHeading">Search Results:</h1>
		<table class="table table-hover table-striped" id="searchResultTable">
			<thead class="searchResultTableHead">
				<tr>
					<th>Address</th>
					<th>Hotel Name</th>
					<th>Stars</th>
					<th>Review</th>
					<th>Room types</th>
					<th>Bed types</th>
					<th>Adults</th>
					<th>Nights</th>
					<th>Price</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${searchResults}" var="searchResult">
					<tr>
						<td>${searchResult.address}</td>
						<td>${searchResult.hotelName}</td>
						<td>${searchResult.stars}</td>
						<td>${searchResult.review}</td>
						<td>${searchResult.roomType}</td>
						<td>${searchResult.bedTypes}</td>
						<td>${searchResult.adults}</td>
						<td>${nights}</td>
						<td>${searchResult.roomPrice * nights}</td>
						<td>
							<form action="roomdetails" method="post">
								<input type="hidden" name="roomId" value="${searchResult.roomId}">
								<input type="hidden" name="dateFrom" value="${dateFrom}">
								<input type="hidden" name="dateTo" value="${dateTo}">
								<button class="searchResultReserveButton" type="submit">Check</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>