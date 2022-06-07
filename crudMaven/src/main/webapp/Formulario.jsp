<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario</title>
</head>
<body>

	<h1>Datos de la Persona</h1>
	<form action="<%= request.getAttribute("accion") %>" method="post">
		<p> <label>Nombre: </label> <input type="text" value="<%= request.getAttribute("nombre") != null ? request.getAttribute("nombre") : "" %>" name="nombre"> </p>
		<p> <label>Apellido: </label> <input type="text" value="<%= request.getAttribute("apellido") != null ? request.getAttribute("apellido") : "" %>" name="apellido"> </p>
		<% if (request.getAttribute("accion") == "modificar") {%>
			<p> <label>DNI: </label> <input type="text" value="<%= request.getAttribute("dni")%>" name="dni" readOnly> </p>
		<% } else { %>
			<p> <label>DNI: </label> <input type="text" name="dni"> </p>
		<% } %>
		<p> <label>Fecha de Nacimiento: </label> <input type="date" value="<%= request.getAttribute("nacimiento") != null ? request.getAttribute("nacimiento") : "" %>" name="nacimiento"> </p>
		<p> <label>Profesion: </label> <input type="text" value="<%= request.getAttribute("profesion") != null ? request.getAttribute("profesion") : "" %>" name="profesion"> </p>
	
		<button type="submit" name="agregar" value="agregar"><%= request.getAttribute("accion") %></button>
	</form>
	
</body>
</html>