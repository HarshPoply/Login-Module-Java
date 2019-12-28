package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import database.DbManager;
import helper.LoginUserDbUtil;
import pojo.LoginUser;
import utilities.Encryption;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	
	private LoginUserDbUtil loginUserDbUtil;
	private DbManager dbManager = new DbManager();
	private HttpSession session;
	private String url;
	private int loginAttempts;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			loginUserDbUtil = new LoginUserDbUtil(dbManager);
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get our current session
		session = request.getSession();
		
		// get the number of logins (Prevents brute force attacks)
		if(session.getAttribute("loginAttempts")==null) {
			loginAttempts = 0;
		}
				
		// exceeded logins
		if(loginAttempts > 2) {
					
			String errorMessage = "Login Attempt Exceeds!!";
			session.setAttribute("errorMessage", errorMessage);
					
			url = "index.jsp";
		}
		else {	// proceed
			// pull the fields from the form
			String username = request.getParameter("uname");
			String password = request.getParameter("pass");
			
			if(username!=null && username.length()!=0 && password!=null && password.length()!=0) {
				
					// encrypt the password to check against what stored in the DB
					String encryptedPass = Encryption.SHA1(password);
					
					// create a user helper class to make database calls, and call authenticate user method
					LoginUser user = loginUserDbUtil.authenticateUser(username,encryptedPass);		
					
					// we have found a user that matches the credentials
					if(user!=null) {	
						// invalidate the current session, then get new session for our user (combats: session hijacking)
						session.invalidate();
						session = request.getSession(true);
						session.setAttribute("user", user);
						
						url = "welcome.jsp";
					}
					else {	// user don't exist, redirect to previous page and show error
						userNotExist(request,response);
					}
				}
				else {
					userNotExist(request,response);
				}
			}
		
		// forward our request along
		response.sendRedirect(url); 
	}

	private void userNotExist(HttpServletRequest request, HttpServletResponse response) {

		String errorMessage = "Invalid Username or Password";
		session.setAttribute("errorMessage", errorMessage);

		//track login attempts (combats: brute force attacks)
		session.setAttribute("loginAttempts", loginAttempts++);
		url = "index.jsp";
	}
}
