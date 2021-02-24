<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>LoginPage</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		Enter user name<input type="text" name="userName"><br>
		Enter password<input type="password" name="password"><br>
		<input type="submit" value="Login">
	</form>

</body>
</html>