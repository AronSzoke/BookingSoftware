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
<meta http-equiv='refresh' content='10; URL=${pageContext.servletContext.contextPath}/admin/home.jsp'>
<title>Reservation Details</title>
</head>
<body>
	<div class="container">
		<script type="text/javascript">
			$(window).load(function() {
				$('#myModal').modal('show');
			});
		</script>
		<div class="myModal" id="myModal" role="dialog">
			<div class="modal-dialog">
				<h1>Booking confirmation</h1>
				<div>${reservation.id}</div>
				<hr>
				<div>
					Date of booking: <span>${reservationTime}</span>
				</div>
				<hr>
				<div>Dear ${sessionScope.loggedInUser.firstName},</div>
				<div>We have received your reservation for your hotel.</div>
				<div>Thank you for your choosing us!</div>
				<hr>
				<div>
					Arrival: <span>${dateFrom}</span>
				</div>
				<hr>
				<div>If you have any question, please feel free to contact us on info@shc.com</div>
				<div>You will be redirected to home page in ten seconds...</div>
			</div>
		</div>

	</div>
</body>
</html>