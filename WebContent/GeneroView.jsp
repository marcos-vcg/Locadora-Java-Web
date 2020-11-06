<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<title>Generos</title>
	</head>
	
	<body>
		<table border="1">
			<thead>
      			<tr><td>Id</td><td>Gênero</td></tr>
   			</thead>
   			
   			<tbody>
				<%@ page import="java.util.*, dao.*, model.*" %>
				
				<%
				DataSource dataSource = new DataSource();
				GeneroDAO generoDao = new GeneroDAO(dataSource);
				ArrayList<Genero> generos = generoDao.readAll();
			
		      	for (Genero genero: generos ) {
				%>
		      	<tr>
			        <td><%=genero.getId() %></td> 
			        <td><%=genero.getNome() %></td>
		      	</tr>
		    	<%
		      	}
		    	%>
	    	</tbody>
	  </table>
	</body>
</html>