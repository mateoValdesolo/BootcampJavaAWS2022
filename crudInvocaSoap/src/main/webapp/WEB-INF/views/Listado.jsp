<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.model.PersonaLocal"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<c:forEach var="per" items="${listaPersonas}" varStatus="status">
			<tr>
				<td>${per.nombre}</td>
				<td>${per.apellido}</td>
				<td>${per.dni}</td>
				<td>${per.nacimiento}</td>
				<td>${per.profesion}</td>
				<td><a type="button"
					href='<c:url value="/editarInit" />?dni=${per.dni}'><button>Editar</button></a>
				<a type="button"
					href='<c:url value="/eliminar" />?dni=${per.dni}'><button>Eliminar</button></a></td>

			</tr>
		</c:forEach>
		<tr align="left">
			<td colspan="8"><a type="button"
				href='<c:url value="/crearInit" />'><button>Agregar otra Persona</button></a></td>
		</tr>
	</table>

</body>
</html>