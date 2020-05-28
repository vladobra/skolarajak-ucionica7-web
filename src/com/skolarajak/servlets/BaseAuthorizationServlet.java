package com.skolarajak.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolarajak.model.Roles;
import com.skolarajak.model.User;

/**
 * Servlet implementation class BaseAuthorizationServlet
 */
public class BaseAuthorizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Roles assignedRole; 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseAuthorizationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected boolean isAuthorized(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		boolean isAuthorized = false;
		User user = (User)request.getSession().getAttribute("user");
		if ( user == null || !user.getRole().equals(this.assignedRole) ) {
			response.sendRedirect("/javaweb/vezba-security/notAuthorized.html");
		} else {
			isAuthorized = true;
		}
		return isAuthorized;
	}
}
