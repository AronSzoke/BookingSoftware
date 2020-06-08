<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html style="height: calc(100% - 38px);">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/shc-new.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Seaside Hotel Chain</title>
</head>
<body style="height: calc(100% - 38px);" id="loginBody">
	<div class="container h-100 d-flex justify-content-center" id="loginContainer">
		<div class="flex-column my-auto">
			<h1 class="text-center mb-3">Sign In</h1>
			<div class="p-4" id="loginBox">
				<form action="login" method="post">
					<div class="form-group m-3">
						<i class="fas fa-user m-2"></i>
						<input type="text" placeholder="Username" id="username" name="username">
					</div>
					<div class="form-group m-3">
						<i class="fas fa-unlock-alt m-2"></i>
						<input type="password" placeholder="Password" id="password" name="password">
					</div>
					<c:if test="${errorMessage != null}">
						<div class="alert alert-danger">
							<c:out value="${errorMessage}"></c:out>
						</div>
					</c:if>
					<button type="submit" class="btn btn-primary" id="loginButton">Login</button>
				</form>
				<div class="form-group m-2 text-center">
					<a href="registration.jsp">
						<u>Create account</u>
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>