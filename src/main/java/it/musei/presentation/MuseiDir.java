package it.musei.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.musei.business.GestioneMuseoEjb;

@WebServlet("/museidir")
public class MuseiDir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MuseiDir() {
        super();
    }

    @EJB
    GestioneMuseoEjb poloMusealeServices;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		poloMusealeServices.direttoreMuseo();
		System.out.println();
	}
}