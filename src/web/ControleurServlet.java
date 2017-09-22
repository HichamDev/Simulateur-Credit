package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetir;
@WebServlet(name="cs", urlPatterns={"/controleur" , "*.php"})
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
		
		req.setAttribute("mod", new CreditModel());
		req.getRequestDispatcher("VueCredit.jsp").
		forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double montant=Double.parseDouble(req.getParameter("montant"));
		double taux=Double.parseDouble(req.getParameter("taux"));
		int duree=Integer.parseInt(req.getParameter("duree"));
		
		CreditModel model = new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		
		double res = metier.calculMensualite(montant, duree, taux);
		
		model.setMensualite(res);
		
		req.setAttribute("mod", model);
		req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
	}

}
