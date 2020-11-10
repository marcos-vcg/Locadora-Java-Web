<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<h2>Gêneros</h2>
	  	<table>
		  	<tr>
		  		<th>Id</th>
		  		<th>Genêro</th>
		  	</tr>
		    <c:forEach var="genero" items="${generos}">
		    <tr>
				<td>${genero.id}</td>
				<td>${genero.nome}</td>
		    </tr>
		    </c:forEach>
	  	</table>
	</body>
</html>