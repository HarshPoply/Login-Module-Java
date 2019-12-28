<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="theLocale" value="${not empty param.theLocale? param.theLocale : pageContext.request.locale }" scope="session"/>
<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="resources.language" />

<c:set var="msg" value="${errorMessage}" scope="session"/>

<!DOCTYPE html>
<html lang="en">
<head>
	<title><fmt:message key="label.title"/></title>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/BookLibrary.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="images/img-04.png" alt="IMG">
				</div>

				<form class="login100-form validate-form" action="Login" method="POST">
					<span class="login100-form-title">
						<fmt:message key="label.memberLogin"/>
					</span>

					<div class="wrap-input100 validate-input" data-validate = "<fmt:message key="label.requireUsername"/>">
						<input class="input100" type="text" name="uname" placeholder="<fmt:message key="label.username"/>" autocomplete="off">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "<fmt:message key="label.requirePassword"/>">
						<input class="input100" type="password" name="pass" placeholder="<fmt:message key="label.password"/>" autocomplete="off">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							<fmt:message key="label.login"/>
						</button>
						<span id="error">
							<c:choose>
								<c:when test="${msg == 'Invalid Username or Password'}">
									<fmt:message key="label.loginError"/>
								</c:when>
								<c:when test="${msg == 'Login Attempt Exceeds!!'}">
									<fmt:message key="label.loginAttempts"/>
								</c:when>
							</c:choose>
						</span>
					</div>
				</form>
				
			</div>
			
		</div>
	</div>
	
	
<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>