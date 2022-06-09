<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.bean.Persona"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado</title>
</head>
<body>

	<h1>Lista de Personas</h1>
	<table>
		<tr>
			<td>NOMBRE</td>
			<td>APELLIDO</td>
			<td>DNI</td>
			<td>FECHA DE NACIMIENTO</td>
			<td>PROFESION</td>
		</tr>

		<%
			for (Persona per : (List<Persona>)request.getAttribute("listaPersonas")) {
		%>
		<tr>
			<td><%=per.getNombre()%></td>
			<td><%=per.getApellido()%></td>
			<td><%=per.getDni()%></td>
			<td><%=per.getNacimiento()%></td>
			<td><%=per.getProfesion()%></td>
			<td>
				<form method="post" action="eliminar?dni=<%= per.getDni() %>">
					<button type="submit">Eliminar</button>
				</form>
			</td>
			<td><form method="post" action="cargar?dni=<%= per.getDni() %>" >
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