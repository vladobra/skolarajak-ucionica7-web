package com.skolarajak.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skolarajak.model.Roles;
import com.skolarajak.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/vezba-security/userServlet.html")
public class UserServlet extends BaseAuthorizationServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		 super();
	     this.assignedRole = Roles.USER;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (isAuthorized(request, response)) {
			User user = (User) request.getSession().getAttribute("user");
			
			User jsonModel = new User();
			jsonModel.setUsername(user.getUsername());
			jsonModel.setRole(user.getRole());
			
			String json = "[]";
			ObjectMapper mapper = new ObjectMapper();
			try {
				json = mapper.writeValueAsString(jsonModel);

				// System.out.println(json);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			response.setContentType("application/json");
			response.getWriter().append(json);
		}
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

}
