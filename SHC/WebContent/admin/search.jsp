<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html style="height: calc(100% - 38px);">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/shc-new.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/shc.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Search</title>
</head>
<body class="searchBody">
<nav class="navbar navbar-expand-sm" id="searchNavBar">
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
<!-- 	<h1 class="text-center m-1">Search</h1> -->
	<div class="container d-flex justify-content-center" id="searchContainer">
		<form class="searchForm" action="search" method="get">
			<div class="form-group m-3">
				<label for="priceFrom">Price From: </label>
				<input class="form-control" type="number" placeholder="20000" id="priceFrom" name="priceFrom" value="${param.priceFrom}" <c:if test="${priceFromResult != null && !priceFromResult.successful}">class="hasValidationError"</c:if>>
				<c:forEach items="${priceFromResult.errorMessages}" var="validationErrorMessage">
					<span class="error">* ${validationErrorMessage}</span>
				</c:forEach>
			</div>
			<div class="from-group m-3">
				<label for="priceTo">Price To: </label>
				<input class="form-control" type="number" placeholder="200000" id="priceTo" name="priceTo" value="${param.priceTo}" <c:if test="${priceToResult != null && !priceToResult.successful}">class="hasValidationError"</c:if>>
				<c:forEach items="${priceToResult.errorMessages}" var="validationErrorMessage">
					<span class="error">* ${validationErrorMessage}</span>
				</c:forEach>
			</div>
			<div class="form-group m-3">
				<label for="address">Address (*): </label>
				<input class="form-control" type="text" placeholder="Budapest" id="address" name="address" value="${param.address}" <c:if test="${addressResult != null && !addressResult.successful}">class="hasValidationError"</c:if>>
				<c:forEach items="${addressResult.errorMessages}" var="validationErrorMessage">
					<span class="error">* ${validationErrorMessage}</span>
				</c:forEach>
			</div>
			<div class="form-group m-3">
				<label for="dateFrom">Date From (*): </label>
				<input class="form-control" type="date" placeholder="2019-12-12" id="dateFrom" name="dateFrom" value="${param.dateFrom}" <c:if test="${dateFromResult != null && !dateFromResult.successful}">class="hasValidationError"</c:if>>
				<c:forEach items="${dateFromResult.errorMessages}" var="validationErrorMessage">
					<span class="error">* ${validationErrorMessage}</span>
				</c:forEach>
			</div>
			<div class="form-group m-3">
				<label for="dateTo">Date To (*): </label>
				<input class="form-control" type="date" placeholder="2019-12-31" id="dateTo" name="dateTo" value="${param.dateTo}" <c:if test="${dateToResult != null && !dateToResult.successful}">class="hasValidationError"</c:if>>
				<c:forEach items="${dateToResult.errorMessages}" var="validationErrorMessage">
					<span class="error">* ${validationErrorMessage}</span>
				</c:forEach>
			</div>
			<c:if test="${doubleDateResult != null && !doubleDateResult.successful}">
				<div>
					<c:forEach items="${doubleDateResult.errorMessages}" var="errorMessage">
						<span class="error">${errorMessage}</span>
					</c:forEach>
				</div>
			</c:if>
			<div class="m-3">
				<label for="numberOfGuests">Guests (*): </label>
				<select id="numberOfGuests" name="numberOfGuests" <c:if test="${numberOfGuestsResult != null && !numberOfGuestsResult.successful}">class="hasValidationError"</c:if>>
					<option value="1" ${param.numberOfGuests == 1 ? 'selected="selected"' : ''}>1 adult</option>
					<option value="2" ${param.numberOfGuests == 2 ? 'selected="selected"' : ''}>2 adults</option>
					<option value="3" ${param.numberOfGuests == 3 ? 'selected="selected"' : ''}>3 adults</option>
					<option value="4" ${param.numberOfGuests == 4 ? 'selected="selected"' : ''}>4 adults</option>
				</select>
				<c:forEach items="${numberOfGuestsResult.errorMessages}" var="validationErrorMessage">
					<span class="error">* ${validationErrorMessage}</span>
				</c:forEach>
			</div>
			<p class="ml-3 mr-3">* required</p>
			<div class="ml-3 mr-3">
				<input class="searchButton" type="submit" value="Search">
			</div>
		</form>
	</div>
</body>
</html>