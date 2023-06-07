package edu.formation.exercice_s84.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Détecter la méthode d'envoie
		String methode = request.getMethod();
		
		// Récupérer les paramètres et leurs valeurs
		Map<String , String[]> parametres = request.getParameterMap();
		
		// Afficher
		String affichage = "<html><body>"
		+"<h1>Méthode</h1>"
		+"<p>"+ methode+"</p>"
		+"<h1>Paramètres</h1>"
		+"<table border='1'> <tr><th>Paramètre</th><th>Valeurs</th></tr>";
		
		for (String parametre : parametres.keySet()) {
			affichage += "<tr><td>"+parametre+"</td><td>"+
					Arrays.toString(parametres.get(parametre))+"</td></tr>";
        }
		
        affichage += "</table></body></html>";
		response.getWriter().append(affichage);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
