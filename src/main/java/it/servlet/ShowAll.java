package it.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import it.musei.business.DaoMuseoEjb;
import it.musei.entity.Dipinto;
import it.musei.entity.Museo;

@WebServlet("/show")
public class ShowAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowAll() {
		super();
	}

	@EJB
	DaoMuseoEjb serv;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Object[]> listaDm = serv.getDipintiMusei();

		for (Object[] obj : listaDm) {
			System.out.println("ID DIPINTO: " + obj[0] + " Titolo: " + obj[1] + " Anno: " + obj[2] + " Nome Museo: "
					+ obj[3] + " Città Museo: " + obj[4] + " ");
		}

		String dominio = request.getParameter("dominio");
		
		List lista = null;
		
		if (dominio.equals("musei")) {
			lista = serv.getAllMusei();
		} else if (dominio.equals("dipinti")) {
			lista = serv.getAllDipinti();
		}

		// Servlet_Helper.forward(request, response, dominio, lista);

		else if (dominio.equals("artistidipinti")) {
			Servlet_Helper.showList(serv.getDipintiArtisti(), out);

			List<Object[]> listaAD = serv.getArtistiDipinti();

			listaAD = serv.getArtistiDipinti();

			for (Object[] obj : listaAD) {
				for (int i = 0; i < obj.length; i++) {
					out.append(obj[i] + " ").append("<br>");
				}
				// out.append(obj[0]+"").append(obj[1]+"").append(obj[2]+"").append(obj[3]+"").append(obj[4]+"");
			}
		}
		if (true)
			return;

		String jspName = "/WEB-INF/templates/" + dominio + "/mostratutti.jsp";

		if (dominio.equalsIgnoreCase("musei")) {
			List<Museo> listaMusei = serv.getAllMusei();
			request.setAttribute("lista", listaMusei);

		} else if (dominio.equalsIgnoreCase("dipinti")) {
			List<Dipinto> listaDipinti = serv.getAllDipinti();
			request.setAttribute("lista", listaDipinti);
		}
		request.getServletContext().getRequestDispatcher(jspName).forward(request, response);
	}
}