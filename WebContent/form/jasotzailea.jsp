<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
   	String izena = request.getParameter("fname");
    String abizena = request.getParameter("lname");
    
    String[] cars = request.getParameterValues("cars");
    
    String message = request.getParameter("message");
    
    String gender = request.getParameter("gender");
    
    String vehicle1 = request.getParameter("vehicle1");
    String vehicle2 = request.getParameter("vehicle2");
    String vehicle3 = request.getParameter("vehicle3");
    
    
    %>
 <!doctype html>
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jasotzailea</title>
</head>
<body>
 Izena: <% out.println(izena); %><br>
 Abizena: <%=abizena %><br><br>
 
 Cars:
 <%
 for(int i = 0; i<cars.length;i++){
	 out.println(cars[i]);
 }

 out.println(message);
 
 out.println(gender);
 
 out.println(vehicle1);
 out.println(vehicle2);
 out.println(vehicle3);
 %>
</body>
</html>