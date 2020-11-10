package servlet.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Genero;
import dao.DataSource;
import dao.GeneroDAO;

public class ListaGenerosLogica implements Logica {

    public String executa(HttpServletRequest req, HttpServletResponse res)
          throws Exception {

        // Monta a lista de contatos
    	DataSource ds = new DataSource();
        List<Genero> generos = new GeneroDAO(ds).readAll();

        // Guarda a lista no request
        req.setAttribute("generos", generos);

        return "lista-generos.jsp";
    }
  }