<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1 Can't press back in browser and gain access after logout
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); // Proxies
	
	if (session.getAttribute("userName") == null) // Can't enter ProjectLeaderPage.jsp in URL and gain access
		request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
	%>
	Project leader page
	<br>
	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>