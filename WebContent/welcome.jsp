<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome User</title>
</head>
<body>
<%

	// To prevent back page after logout
	// the below method supports HTTP 1.1
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	// For HTTP 1.0
	response.setHeader("Pragma", "no-cache");
	
	// For Proxy Servers
	response.setDateHeader("Expires", 0);

	//If not logged in and trying to access the link
	if(session.getAttribute("user")==null) {
		response.sendRedirect("index.jsp");
	}
%>

<h1>Welcome,</h1>
<c:out value="${user.userId}"/><br>
<c:out value="${user.userName}"/>!<br>

<form action="Logout" method="POST">
	<input type="submit" value="Logout"/>
</form>

</body>
</html>