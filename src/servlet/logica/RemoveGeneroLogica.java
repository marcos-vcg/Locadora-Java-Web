package servlet.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Genero;
import dao.DataSource;
import dao.GeneroDAO;

public class RemoveGeneroLogica implements Logica {

    public String executa(HttpServletRequest req, HttpServletResponse res)
        throws Exception {

      int id = Integer.parseInt(req.getParameter("id"));

      Genero genero = new Genero();
      genero.setId(id);

      DataSource ds = new DataSource();
      GeneroDAO dao = new GeneroDAO(ds);
      dao.apagar(genero);

      System.out.println("Excluindo contato... ");

      return "lista-contatos.jsp";
    }

  }