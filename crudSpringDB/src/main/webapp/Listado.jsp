<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.bean.Persona"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado</title>

<style>
#personas {
	font-family: 'Montserrat', sans-serif;
	border-collapse: collapse;
	width: 100%;
	text-align: center;
}

#personas td, #personas th {
	border: 1px solid #ddd;
	padding: 8px;
}

#personas tr:nth-child(even) {
	background-color: #f2f2f2;
}

#personas tr:nth-child(odd) {
	background-color: #d1d1d1;
}

#personas tr:hover {
	background-color: #ddd;
}

#personas th {
	font-family: 'Montserrat', sans-serif;
	padding-top: 12px;
	padding-bottom: 12px;
	background-color: #00d2aa;
	color: #003d6f;
	text-align: center;
}

button {
	background-color: #00d2aa;
	border: none;
	color: black;
	padding: 15px 32px;
	font-family: 'Montserrat', sans-serif;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 12px;
}

body {
	background-color: #00507f;
}

h1 {
	text-align: center;
	color: #00d2aa;
	font-family: 'Montserrat', sans-serif;
}

</style>
</head>
<body>

	<h1>Lista de Personas</h1>
	<table id="personas">
		<tr>
			<th>NOMBRE</th>
			<th>APELLIDO</th>
			<th>DNI</th>
			<th>FECHA DE NACIMIENTO</th>
			<th>PROFESION</th>
			<th>OPCIONES</th>
		</tr>

		<%
			for (Persona per : (List<Persona>) request.getAttribute("listaPersonas")) {
		%>
		<tr>
			<td><%=per.getNombre()%></td>
			<td><%=per.getApellido()%></td>
			<td><%=per.getDni()%></td>
			<td><%=per.getNacimiento()%></td>
			<td><%=per.getProfesion()%></td>
			<td>
				<form method="post" action="eliminar?dni=<%=per.getDni()%>">
					<button type="submit">Eliminar</button>
				</form>
				<form method="post" action="cargar?dni=<%=per.getDni()%>">
					<button type="submit">Modificar</button>
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>

	<form action="agregar" method="post">
		<button type="submit">Agregar otra Persona</button>
	</form>

</body>
</html>