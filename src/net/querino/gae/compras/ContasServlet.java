package net.querino.gae.compras;
import java.io.IOException;
import java.util.Date;
import java.text.*;
 
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ContasServlet extends HttpServlet {
	 private Dao dao;
	    private DateFormat formatadorData;
	   
	    public void init() throws ServletException {
	      dao = new Dao();
	      formatadorData = new SimpleDateFormat("dd/MM/yyyy");
	    }
	    
	    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException {
	      String descricao = req.getParameter("descricao");
	      if (descricao == null || descricao.trim().equals("")) {
	        descricao = "CONTA SEM DESCRIÇÃO";
	      }
	      double valor;
	      try {
	        valor = Double.parseDouble(req.getParameter("valor").replace(',', '.'));
	      } catch (NumberFormatException ex) {
	        valor = 0;
	      }
	      Date vencimento;
	      try {
	        vencimento = formatadorData.parse(req.getParameter("vencimento"));
	      } catch (ParseException ex) {
	        vencimento = new Date();
	      }
	      String linhaDigitavel = req.getParameter("linhaDigitavel");
	      if (linhaDigitavel == null || linhaDigitavel.trim().equals("")) {
	        linhaDigitavel = "NÃO INFORMADA";
	      }
	      dao.incluirConta(descricao, valor, vencimento, linhaDigitavel);
	      resp.sendRedirect("/Contas.jsp");
	    }
	   
	    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	      String id = req.getParameter("id");
	      dao.excluirConta(Long.valueOf(id));
	     resp.sendRedirect("/Contas.jsp");
	    }
	  }
