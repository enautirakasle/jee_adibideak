<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<%
		for(int i = 1; i<=100; i++){
			
			out.println("<tr><td style='background-color:grey'>" + i + "</td></tr>");
			
		}
		%>
	</table>
	
</body>
</html>