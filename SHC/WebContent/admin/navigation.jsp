<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-sm py-3" id="navbar">
	<!-- 	<ul class="navbar-nav"> -->
	<!-- 		<li class="homeButton"><a class="btn btn-light btn-sm ml-2 mr-2 text-dark font-weight-bold" href="home.jsp"> Home </a></li> -->
	<!-- 		<li><a class="btn btn-primary btn-sm mx-2 text-light font-weight-bold" href="search.jsp">Search</a></li> -->
	<!-- 		<li><a class="btn btn-primary btn-sm mx-2 text-light font-weight-bold" href="getCancellableReservations">Cancel</a></li> -->
	<!-- 		<li><a class="btn btn-primary btn-sm mx-2 text-light font-weight-bold" href="collectReviewInfo">Review</a></li> -->
	<%-- 		<c:if test="${sessionScope.alma == 'ADMIN'}"> --%>
	<!-- 			<li class="nav-item"><a class="btn btn-primary btn-sm mx-2 text-light font-weight-bold" href="collectModificationInfo">Modify</a></li> -->
	<%-- 		</c:if> --%>
	<!-- 	</ul> -->
	<!-- 	<ul class="navbar-nav ml-auto"> -->
	<%-- 		<li class="nav-item"><a class="btn btn-secondary btn-sm mx-2" href="${pageContext.request.contextPath}/logout" role="button">Logout</a></li> --%>
	<!-- 	</ul> -->
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