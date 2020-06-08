<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/shc.css">
<title>Reservation Error</title>
</head>
<body>
	<h1>Booking Error</h1>
	<div>
		Error Message: <span>There is no availability for this room for the given dates</span>
	</div>
	<a href="search.jsp" class="linkAsAButton">Retry Search</a>
</body>
</html>