<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario</title>
<style>

	form {
		text-align: center;
	}

	body {
		background-color: #00507f;
		text-align: center;
		color: #00d2aa;
		font-family: 'Montserrat', sans-serif;
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
		text-transform: uppercase; 
	}
	
	input {
		padding:10px;
		border-radius:10px;
		border:	none;
	}
	
</style>
</head>
<body>
	<c:choose>
		<c:when test="${action eq 'CREAR'}">
			<c:url var="post_url" value="/crearSave" />
			<c:set var="title" value="Agregar"/>
		</c:when>
		<c:otherwise>
			<c:url var="post_url" value="/modificarSave" />
			<c:set var="title" value="Editar"/>
		</c:otherwise>
	</c:choose>

	<h1>${title} Persona</h1>
	
	<form:form action="${post_url}" method="POST" modelAttribute="person">
		<p> 
		<form:label path="nombre">Nombre</form:label>
		<form:input type="text"  path="nombre"/>
		</p>
		
		<p> 
		<form:label path="apellido">Apellido</form:label>
		<form:input type="text" path="apellido"/>
		</p>
		
		<c:choose>
			<c:when test="${action eq 'MODIFICAR'}">
			<p> 
			<form:label path="dni">DNI</form:label>
			<form:input type="text" path="dni" readonly="true"/> 
			</p>
		</c:when>
		<c:otherwise>
			<p> 
			<form:label path="dni">DNI</form:label>
			<form:input type="text" path="dni"/> 
			</p>
			</c:otherwise>
		</c:choose>
		
		<p> 
		<form:label path="nacimiento">Fecha de Nacimiento</form:label>
		<form:input type="date" path="nacimiento"/>
		</p>
		
		<p> 
		<form:label path="profesion">Profesion</form:label>
		<form:input type="text" path="profesion" />
		</p>
		
		<br> <input type="submit" value="${title}">
		
	</form:form>
	
</body>
</html>