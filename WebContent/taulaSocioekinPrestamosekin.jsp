<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dao.ModeloSocio"%>
<%@page import="modelo.bean.Socio"%>
<%@page import="modelo.bean.Prestamo"%>

<%
	ModeloSocio modeloSocio = new ModeloSocio();
	ArrayList<Socio> socios = modeloSocio.selectConPrestamos();
%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title>Sozio zerrenda</title>
</head>
<body>

	<div class="container">
		<%
			for (int i = 0; i < socios.size(); i++) {
				Socio socio = socios.get(i);
		%>
		<div class="jumbotron">
			<%=socio.getNombre()%>
			<%=socio.getApellido()%><br>

			<table class="table">
			<tr>
				<th>Fecha</th>
				<th>Devuelto</th>
				<th>Titulo</th>
				<th>Autor</th>
			</tr>
				<%
					ArrayList<Prestamo> prestamos = socio.getPrestamos();
						if (prestamos.size() == 0) {
				%>

				<div class="alert alert-light" role="alert">
					No tiene ningun prestamo.
				</div>
				<%
					}
						for (int j = 0; j < prestamos.size(); j++) {
							Prestamo prestamo = prestamos.get(j);
				%>
				<tr>
					<td><%=prestamo.getFecha()%></td>
					<td><%=prestamo.isDevuelto()%></td>
					<td><%=prestamo.getLibro().getTitulo()%></td>
					<td><%=prestamo.getLibro().getAutor()%></td>
				</tr>

				<%
					}
				%>
			</table>
		</div>
		<%
			} //for socios
		%>

	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>