package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/Logout")
public class LogoutController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// To prevent back page after logout
		// the below method supports HTTP 1.1
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		// For HTTP 1.0
		response.setHeader("Pragma", "no-cache");
		
		// For Proxy Servers
		response.setDateHeader("Expires", 0);
		
		request.getSession(false);
		session.removeAttribute("user");
		session.invalidate(); // to remove all the data
		
		response.sendRedirect("index.jsp");
	}

}
