package it.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet_Helper {

	public static void forward(HttpServletRequest request, HttpServletResponse response, String dominio, List lista) throws ServletException, IOException {
		
		String jspName ="/WEB-INF/templates/" + dominio + "/mostratutti.jsp";
		
		request.setAttribute("lista", lista);
		
		request.getServletContext().getRequestDispatcher(jspName).forward(request, response);
	
	
	
	
	}
	
public static void showList(List<Object[]> list, PrintWriter out ) {
        
        
        for ( Object[] o : list ) {
            
            for (int i = 0; i < o.length; i++) {
                out.append(o[i]+" ");
            }
            out.append("<br>");
            
        }
    
    }
	
}