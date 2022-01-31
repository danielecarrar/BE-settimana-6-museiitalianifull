package it.musei.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import it.musei.business.GestioneMuseoEjb;
import it.musei.entity.Museo;
import it.musei.exceptions.IdNonSpecificatoException;
import it.musei.exceptions.MuseoNonTrovatoException;

@WebServlet("/trovamuseo")
public class TestTrovaMuseo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestTrovaMuseo() {super();}

	@EJB
	GestioneMuseoEjb poloMusealeServices;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(true)return;//
		poloMusealeServices.direttoreMuseo();
		
		TransferMuseo tm = new TransferMuseo(true, null, "");

		try {
			Museo m = poloMusealeServices.trovaMuseo(request.getParameter("id_museo"));
		tm.setMuseo(m);
		
		} catch (MuseoNonTrovatoException e) {
			tm.setSuccess(false);
			tm.setMessage(e.getMessage());
		} catch (IdNonSpecificatoException e) {
			tm.setSuccess(false);
			tm.setMessage(e.getMessage());
		}

		// System.out.println(m.getNome() + " è il nome del museo!");
request.setAttribute("transfermuseo", tm);
		//DISPATCH manda tutto verso cerca museo passando la request che abbiamo modificato
request.getServletContext().getRequestDispatcher("/cercamuseo.jsp").forward(request, response);
		
		
		
		
	}
}