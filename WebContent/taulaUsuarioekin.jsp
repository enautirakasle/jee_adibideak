<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList" %>
<%@page import="modelo.bean.Usuario" %>
 
 <%
 ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
 Usuario usuario1 = new Usuario("jagoba", "11223344e", false);
 usuarios.add(usuario1);
 usuario1 = new Usuario("unai", "88776655f", false);
 usuarios.add(usuario1);
 usuario1 = new Usuario("eñaut", "55446655p", true);
 usuarios.add(usuario1);
 
 usuarios.add(new Usuario("iker", "88887777u", false));
 
 
 %>

 
 <!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Erabiltzaile zerrenda</title>
  </head>
  <body>
  
  	<div class="container">
    	<h1>Erabiltzaile zerrenda1</h1>
    	<table class="table">
    	<tr>
    		<th>izena</th>
    		<th>dni</th>
    		<th>admin</th>
    	</tr>
    	
    	<%
    	for(int i = 0; i<usuarios.size();i++){
    		Usuario usuario = usuarios.get(i);
    		out.println("<tr>");
    		out.println("<td>"+ usuario.getNombre() +"</td>");
    		out.println("<td>"+ usuario.getDni() +"</td>");
    		out.println("<td>"+ usuario.isAdmin() +"</td>");
    		out.println("</tr>");
    	}
    	%>
    	</table>
    	    	<h1>Erabiltzaile zerrenda2</h1>
    	<table class="table">
    	<tr>
    		<th>izena</th>
    		<th>dni</th>
    		<th>admin</th>
    	</tr>
    	
    	<%
    	for(int i = 0; i<usuarios.size();i++){
    		Usuario usuario = usuarios.get(i);
    	%>
    		<tr>
    			<td><%=usuario.getNombre()%> </td>
    			<td><%=usuario.getDni()%> </td>
    			<td><%=usuario.isAdmin()%> </td>
    		</tr>
    	<%
    	}
    	%>
    	
    	</table>
    	
    	
    	
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>