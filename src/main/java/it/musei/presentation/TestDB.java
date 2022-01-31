package it.musei.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.musei.business.GestioneMuseoEjb;

@WebServlet("/testdb")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	GestioneMuseoEjb poloMusealeServices;
	
   
    public TestDB() {super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		poloMusealeServices.testDb();
		System.out.println("TUTTOOKFORSE");
	}

}
