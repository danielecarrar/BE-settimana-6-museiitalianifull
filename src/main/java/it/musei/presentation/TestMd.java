package it.musei.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import it.musei.business.DaoMuseoEjb;
import it.musei.business.GestioneMuseoEjb;
import it.musei.entity.Dipinto;
import it.musei.entity.Museo;

@WebServlet("/testmd")
public class TestMd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TestMd() {
        super();
    }

    @EJB
    GestioneMuseoEjb poloMusealeServices;
    @EJB
    DaoMuseoEjb serv;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//poloMusealeServices.testMuseoeDipinti();
		System.out.println("Operazione probabilmente completata");
		PrintWriter out = response.getWriter();
		//STAMPA TUTTI I MUSEI DEL DB CON IL GIVEN STYLE
		List<Museo> listaMusei = serv.getAllMusei();
		out.println("<h1>LISTA MUSEI</h1>");
		for(Museo m : listaMusei) {
			
			out.append("<div style='background:aliceblue; padding: 5px; width 80%;border:1px'>")
			.append("Nome Museo: ").append(m.getNome())
			.append(" Città: ").append(m.getCitta())
			.append(" ID numero: ").append(m.getIdMuseo()+"")
			.append("</div>");
		}
		
		List<Dipinto> listaDipinti = serv.getAllDipinti();
		out.println("<h1>LISTA DEI DIPINTI</h1>");
		for(Dipinto d : listaDipinti) {
			
			out.append("<div style='background:aliceblue'>")
			.append("Nome Dipinto: ").append(d.getTitolo())
			.append(" Anno: ").append(d.getAnnoDipinto()+"")
			.append(" ID numero: ").append(d.getIdDipinto()+"")
			.append("</div>");
		}
		
		
	}


}
