package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Genero;
import dao.DataSource;
import dao.GeneroDAO;

/**
 * Servlet implementation class GeneroServlet
 */
@WebServlet("/Genero")
public class GeneroServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");	
		String operacao = request.getParameter("operacao");
		
		DataSource dataSource = new DataSource();
		GeneroDAO generoDao = new GeneroDAO(dataSource);
				
		// Cria um novo Genero
		Genero genero = new Genero();
		genero.setId(id);
		genero.setNome(nome);
		
		
		switch(operacao) {
		case("i"):
			// Adiciona o Genero ao BD
			generoDao.inserir(genero);
			request.setAttribute("genero", genero);
			request.getRequestDispatcher("generoView.jsp").forward(request, response);
			break;
			
		case("r"):
			// Le todos os Generos
			ArrayList<Genero> generos = generoDao.readAll();			
			request.setAttribute("generos", generos);
			request.getRequestDispatcher("generoView.jsp").forward(request, response);
			break;
			
		case("a"):
			// Exclui o Genero
			generoDao.apagar(genero);
		
		case("e"):
			// Edita o Genero
			generoDao.editar(genero);
			break;
			
		default: 
			// Recarrega todos os Generos
			break;
		}
	
		
	}
	
	

}
