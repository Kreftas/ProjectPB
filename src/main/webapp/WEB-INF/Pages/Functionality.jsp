<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	Server Version: <%= application.getServerInfo() %><br>
	Servlet Version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %>
	JSP Version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %> <br>
</body>
</html>