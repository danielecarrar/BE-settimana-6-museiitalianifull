package it.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import it.musei.business.DaoMuseoEjb;
import it.musei.entity.Dipinto;
import it.musei.entity.Museo;

public class InserisciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public InserisciServlet() {
        super();
    }
    @EJB
    DaoMuseoEjb services;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dominio = request.getParameter("dominio");
		
		String jspName ="/WEB-INF/templates/" + dominio + "/mostratutti.jsp";
		
		if(dominio.equals("musei")) {
			services.insertMuseo(request.getParameter("nome_museo"), request.getParameter("citta_museo"));
			List<Museo> listaMusei = services.getAllMusei();
			request.setAttribute("lista", listaMusei);
		
		}
		else if(dominio.equals("dipinti")) {
			services.insertDipinto(request.getParameter("titolo"), Integer.parseInt(request.getParameter("anno")));
			List<Dipinto> listaDipinti = services.getAllDipinti();
			request.setAttribute("lista", listaDipinti);
		}
		request.getServletContext().getRequestDispatcher(jspName).forward(request, response);
		
	}

	
	
	
}