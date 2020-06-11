package com.skolarajak.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skolarajak.exceptions.dao.ResultNotFoundException;
import com.skolarajak.model.Roles;
import com.skolarajak.model.Vlasnik;
import com.skolarajak.servisi.AdministriranjeVozila;
import com.skolarajak.utils.Konstante;

/**
 * Servlet implementation class ListajVlasnikeJSONServlet
 */
@WebServlet("/vezba-security/getVlasnici.html")
public class ListajVlasnikeJSONServlet extends BaseAuthorizationServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTROL_TABLE_COOKIE = "rowsInTable";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListajVlasnikeJSONServlet() {
		super();
		this.assignedRole = Roles.USER;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String json = "[]";
		
		if (isAuthorized(request, response)) {
			Integer pageNumber = 1;

			pageNumber = getPageNumber(request);

			int rowsInTable = getRowsInTable(request);

			List<Vlasnik> vlasnici = null;
			AdministriranjeVozila administracijaVozila = new AdministriranjeVozila();

			try {
				vlasnici = administracijaVozila.dajSveVlasnike(pageNumber, rowsInTable);
			} catch (ResultNotFoundException e) {

				e.printStackTrace();
			}
			
			
			ObjectMapper mapper = new ObjectMapper();
			try {
				json = mapper.writeValueAsString(vlasnici);

				// System.out.println(json);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		
		
		response.setContentType("application/json");
		response.getWriter().append(json);
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
	
	private Integer getPageNumber(HttpServletRequest request) {
		Integer pageNumber;
		try {
			pageNumber = Integer.parseInt(request.getParameter("p"));
		} catch (NumberFormatException e) {
			pageNumber = 1;
		}
		return pageNumber;
	}
	
	private int getRowsInTable(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		  if(cookies != null) {
		      for (int i = 0; i < cookies.length; i++) {
		          Cookie cookie=cookies[i];
		          String cookieName = cookie.getName();
		          if (CONTROL_TABLE_COOKIE.equals(cookieName)) {
		        	  return Integer.parseInt(cookie.getValue());
		          }
		          
		       }
		   }
		  
		return Konstante.VELICINA_TABELE_PRIKAZA;
	}

}
