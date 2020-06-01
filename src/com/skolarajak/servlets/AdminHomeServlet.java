package com.skolarajak.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolarajak.exceptions.dao.ResultNotFoundException;
import com.skolarajak.model.Roles;
import com.skolarajak.model.Vlasnik;
import com.skolarajak.servisi.AdministriranjeVozila;

/**
 * Servlet implementation class AdminHomeServlet
 */
@WebServlet(value = "/vezba-security/adminHomeServlet.html")
public class AdminHomeServlet extends BaseAuthorizationServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomeServlet() {
        super();
        this.assignedRole = Roles.ADMIN;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (isAuthorized(request, response)) {
			// TODO Auto-generated method stub
			Integer pageNumber = 1;
			try {
				pageNumber = Integer.parseInt(request.getParameter("p"));
			} catch (NumberFormatException e) {
				pageNumber = 1;
			}
			List<Vlasnik> vlasnici = null;
			AdministriranjeVozila administracijaVozila = new AdministriranjeVozila();
			
			try {
				vlasnici = administracijaVozila.dajSveVlasnike(pageNumber);
			} catch (ResultNotFoundException e) {
				
				e.printStackTrace();
			}
			
			request.setAttribute("listaVlasnike", vlasnici);
			request.setAttribute("pageNumber", pageNumber);
			
			request.getRequestDispatcher("/vezba-security/pages/adminHomePage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
