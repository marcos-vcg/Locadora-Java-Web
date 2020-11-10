<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*, dao.*,bean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<title>Generos</title>
	</head>
	
	<body>
		<table border="1">
			<thead>
      			<tr><th>Id</th><th>Gênero</th></tr>
   			</thead>
   			
   			<tbody>
				<jsp: useBean id="generos" scope="request" class="bean.Genero"/>
				<c:forEach var="contato" items="${generos}"/>
				<tr>
					<td>${genero.getId()}</td>
					<td>${genero.getNome()}</td> 
		      	</tr>
	    	</tbody>
	  </table>
	</body>
</html>