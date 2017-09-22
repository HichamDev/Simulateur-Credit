package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetir;

public class ControleurServlet extends HttpServlet{
	
	private CreditMetir metier;
	
	@Override
	public void init() throws ServletException {
		metier=new CreditMetir();
	}
	
	@Override
	protected void doGet(HttpServletRequest req,
		HttpServletResponse resp) 
		throws ServletException, IOException {
		
		req.getRequestDispatcher("VueCredit.jsp").
		forward(req, resp);
		
	}

}
