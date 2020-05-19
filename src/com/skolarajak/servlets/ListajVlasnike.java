package com.skolarajak.servlets;

import java.io.IOException;
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
 * Servlet implementation class ListajVlasnike
 */
@WebServlet("/ListajVlasnike")
public class ListajVlasnike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListajVlasnike() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer pageNumber = Integer.parseInt(request.getParameter("p"));
		List<Vlasnik> vlasnici = null;
		AdministriranjeVozila administracijaVozila = new AdministriranjeVozila();
		
		try {
			vlasnici = administracijaVozila.dajSveVlasnike(pageNumber);
		} catch (ResultNotFoundException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("listaVlasnike", vlasnici);
		request.setAttribute("pageNumber", pageNumber);
		request.getSession().setAttribute("username", "test user");
	
		request.getRequestDispatcher("/vezba-servleti/listajVlasnikePrikaz.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
