package jp.ehei;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/Identification")
public class Identification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Identification() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter Afficher = response.getWriter();
		HttpSession S1 = request.getSession();
		String A = (String) S1.getAttribute("Utilisateur");
		enregistrerUtilisateur(S1, request);
		Afficher.println("<!DOCTYPE html>");
		Afficher.println("<html>");
		Afficher.println("<head>");
		Afficher.println("<meta charset=\"utf-8\" />");
		Afficher.println("<title>Test</title>");
		Afficher.println("</head>");
		Afficher.println("<body style=\"background-color: orange\">");
		if (ifUtilisateurExiste(S1, A) == true) {
			Afficher.println("<p style=\"color:yellow\"> Vous ete connecter en tant que : <br>" + A + "Vous ete utilisateur N= </p>" + count);
		} else {
			count++;
			Afficher.println("<p style=é\"color:yellow\"> Vous ete utilisateur N= </p>" + count);

		}
		Afficher.println("</body>");
		Afficher.println("</html>");
	}

	protected void enregistrerUtilisateur(HttpSession Session, HttpServletRequest request) {
		String A = request.getParameter("Util");
		HttpSession S1 = request.getSession();
		S1.setAttribute("Utilisateur", A);
	}

	protected boolean ifUtilisateurExiste(HttpSession session, String nomUtilisateur) {
		if (session.getAttribute("Utilisateur").equals(nomUtilisateur)) {
			return true;
		} else {
			return false;
		}
	}
}
