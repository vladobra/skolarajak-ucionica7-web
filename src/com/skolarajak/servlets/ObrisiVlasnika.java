package com.skolarajak.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolarajak.exceptions.dao.ResultNotFoundException;
import com.skolarajak.model.Vlasnik;
import com.skolarajak.servisi.AdministriranjeVozila;

/**
 * Servlet implementation class ObrisiVlasnika
 */
@WebServlet(value = "/vezba-servleti/obrisiVlasnika.html")
public class ObrisiVlasnika extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ObrisiVlasnika() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String brojVozackeDozvole = request.getParameter("id");

		AdministriranjeVozila administracijaVozila = new AdministriranjeVozila();
		Vlasnik vlasnik = null;

		try {

			vlasnik = administracijaVozila.dajVlasnikaBezVozila(brojVozackeDozvole);
			request.setAttribute("vlasnik", vlasnik);
			administracijaVozila.obrisiVlasnika(brojVozackeDozvole);
			request.getRequestDispatcher("/vezba-servleti/obrisiVlasnikaPrikaz.jsp").forward(request, response);
		} catch (ResultNotFoundException | SQLException e) {

			e.printStackTrace();
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
