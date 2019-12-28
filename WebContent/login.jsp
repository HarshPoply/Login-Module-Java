<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form name="loginForm" action="Login" onsubmit="return validateForm()" method="POST">
		<table>
	
			<tr>
				<td>Enter Username:</td>
				<td><input type="text" name="uname" autocomplete="off" placeholder="Username" required/></td>
			</tr>
			
			<tr>
				<td>Enter Password:</td>
				<td><input type="password" name="pass" autocomplete="off" placeholder="Password" required/></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="login" value="Login"/>
				</td>
			</tr>
		
		</table>
	</form>
	${errorMessage}
	
	<!-- Custom JS -->
    <script src="js/script.js"></script>
</body>
</html>