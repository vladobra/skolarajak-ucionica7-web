package com.skolarajak.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolarajak.model.Roles;
import com.skolarajak.model.User;
import com.skolarajak.servisi.AdministracijaKorisnika;
import com.skolarajak.servisi.AdministriranjeVozila;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(value = "/vezba-security/loginServlet.html")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdministracijaKorisnika administracijaKorisnika = new AdministracijaKorisnika();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (administracijaKorisnika.isRegistered(username)) {
			if (administracijaKorisnika.isAuthenticated(username, password)) {
				User user = administracijaKorisnika.getUser(username);
				if (user != null) {
					request.getSession().setAttribute("user", user);
				}
				if (user.getRole().equals(Roles.ADMIN)) {
					request.getRequestDispatcher("/vezba-security/adminHomeServlet.html").forward(request, response);
				} else {
					request.getRequestDispatcher("/vezba-security/homeServlet.html").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("/vezba-security/wrongPassword.html").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/vezba-security/notRegisteredUser.html").forward(request, response);
		}
	}

}
