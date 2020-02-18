<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList" %>
    
    <%
    ArrayList<String> izenak = new ArrayList<String>();
    izenak.add("Markel");
    izenak.add("Igor");
    izenak.add("Galder");
       
    %>
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>1AW3 - ikasleak</title>
</head>
<body>

<table border="1">
	<tr>
	<th>id</th>
	<th>izena</th>
	</tr>
<%
	for(int i = 0; i< izenak.size(); i++){
		out.println("<tr>");
		out.println("<td>");
		out.println(i+1);
		out.println("</td>");
		out.println("<td>");
		out.println(izenak.get(i));
		out.println("</td>");
		out.println("</tr>");
	}
%>
</table>

</body>
</html>