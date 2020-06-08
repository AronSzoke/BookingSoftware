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
<title>Registration</title>
<body style="background-image:url(pictures/bg.jpg);background-color: hsla(0, 0%, 100%, 0.134);background-blend-mode: overlay;">
		<div class="container d-flex justify-content-center mt-4">
			<form action="register" method="post" style="border-radius: 10px 10px 10px 10px; border-style: solid; background-color: hsla(0, 0%, 100%, 0.434);">
			<div>
				<h1 class="ml-3">Registration</h1>
			</div>
				<div class="form-group">
					<label class="ml-3" for="username" style="font-family: sans-serif; font-weight:600;">Username:</label>
					<input class="form-control ml-3 mr-3" type="text" placeholder="Username" id="username" name="username" style="width: 500px; border-radius: 30px 25px 30px 25px;">
				</div>
				<div class="form-group">
					<label class="ml-3" for="password" style="font-family: sans-serif; font-weight:600;">Password:</label>
					<input class="form-control ml-3 mr-3" type="password" placeholder="Password" id="password" name="password" style="width: 500px; border-radius: 30px 25px 30px 25px;">
				</div>
				<div class="form-group ml-3 mr-3">
					<select name="userType" id="userType" class="custom-select" style="width: 500px; border-radius: 30px 25px 30px 25px;">
						<option selected>User type:</option>
						<option value="GUEST">GUEST</option>
						<option value="ADMIN">ADMIN</option>
					</select>
				</div>
				<div class="form-group">
					<label class="ml-3" for="firstName" style="font-family: sans-serif; font-weight:600;">First name:</label>
					<input class="form-control ml-3 mr-3" type="text" placeholder="First Name" id="firstName" name="firstName" style="width: 500px; border-radius: 30px 25px 30px 25px;">
				</div>
				<div class="form-group">
					<label class="ml-3" for="email" style="font-family: sans-serif; font-weight:600;">Last name:</label>
					<input class="form-control ml-3 mr-3" type="text" placeholder="Last Name" id="lastName" name="lastName" style="width: 500px; border-radius: 30px 25px 30px 25px;">
				</div>
				<div class="form-group">
					<label class="ml-3" for="email" style="font-family: sans-serif; font-weight:600;">E-mail:</label>
					<input class="form-control ml-3 mr-3" type="email" placeholder="E-mail" id="email" name="email" style="width: 500px; border-radius: 30px 25px 30px 25px;">
				</div>
				<div class="form-group">
					<label class="ml-3" for="dateOfBirth" style="font-family: sans-serif; font-weight:600;">Date of birth:</label>
					<input class="form-control ml-3 mr-3" type="date" placeholder="Date of birth" id="dateOfBirth" name="dateOfBirth" style="width: 500px; border-radius: 30px 25px 30px 25px;">
				</div>
				<button type="submit" class="btn btn-primary mb-3 ml-3">Submit</button>
			</form>
		</div>
</body>
</html>