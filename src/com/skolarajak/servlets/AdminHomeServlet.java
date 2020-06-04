package com.skolarajak.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolarajak.exceptions.dao.ResultNotFoundException;
import com.skolarajak.model.Roles;
import com.skolarajak.model.Vlasnik;
import com.skolarajak.servisi.AdministriranjeVozila;
import com.skolarajak.utils.Konstante;

/**
 * Servlet implementation class AdminHomeServlet
 */
@WebServlet(value = "/vezba-security/adminHomeServlet.html")
public class AdminHomeServlet extends BaseAuthorizationServlet {
	private static final String MODE_PRINT = "print";

	private static final long serialVersionUID = 1L;
	
	private static final String CONTROL_TABLE_COOKIE = "rowsInTable";
       
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
			
			pageNumber = getPageNumber(request);
			
			int rowsInTable = getRowsInTable(request);
			
			List<Vlasnik> vlasnici = null;
			AdministriranjeVozila administracijaVozila = new AdministriranjeVozila();
			
			try {
				vlasnici = administracijaVozila.dajSveVlasnike(pageNumber, rowsInTable);
			} catch (ResultNotFoundException e) {
				
				e.printStackTrace();
			}
			
			request.setAttribute("listaVlasnike", vlasnici);
			request.setAttribute("pageNumber", pageNumber);
			
			setUserIdCookie(response);
			
			if (request.getParameter("mode")!=null && request.getParameter("mode").equals(MODE_PRINT)) {
				request.getRequestDispatcher("/vezba-security/pages/adminHomePagePrint.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/vezba-security/pages/adminHomePage.jsp").forward(request, response);
			}
		}
	}

	protected Integer getPageNumber(HttpServletRequest request) {
		Integer pageNumber;
		try {
			pageNumber = Integer.parseInt(request.getParameter("p"));
		} catch (NumberFormatException e) {
			pageNumber = 1;
		}
		return pageNumber;
	}

	private void setUserIdCookie(HttpServletResponse response) {
		Cookie userIdCookie = new Cookie("userid", "007");
		userIdCookie.setMaxAge(0);
		userIdCookie.setHttpOnly(true);
		userIdCookie.setPath("/");
		
		response.addCookie(userIdCookie);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
