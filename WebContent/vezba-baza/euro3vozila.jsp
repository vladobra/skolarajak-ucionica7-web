<%@ page language="java" import="java.util.List, com.skolarajak.servisi.AdministriranjeVozila, com.skolarajak.model.Vozilo" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/javaweb/vezba-baza/style.css">
</head>
<body>
	<table border="1">
	<%
	int pageNumber = 1;
	
	try {
		pageNumber = Integer.parseInt(request.getParameter("p"));
	} catch(NumberFormatException e) {
		
	}
	
	AdministriranjeVozila administracijaVozila = new AdministriranjeVozila();
	
	List<Vozilo> euro3Vozila = administracijaVozila.euro3Vozila(pageNumber);
	
	String dataTemplate = "<td>%s</td>";
	if(euro3Vozila.size() > 0) {
		for (Vozilo vozilo : euro3Vozila) {
			out.write("<tr>");
			
			out.write(String.format(dataTemplate,vozilo.getRegistarskiBroj()));
			out.write(String.format(dataTemplate,vozilo.getGodisteProizvodnje().toString()));
			out.write(String.format(dataTemplate,vozilo.getVlasnik().getIme()));
			
			String vlasnikLinkTemplate = "<a href='/javaweb/vezba-baza/prikazvlasnik.jsp?id=%s' target='_blank'>%s</a>";
			String brojVozDozvole = vozilo.getVlasnik().getBrojVozackeDozvole();
			String vlasnikLink = String.format(vlasnikLinkTemplate, brojVozDozvole, brojVozDozvole);
			
			out.write(String.format(dataTemplate, vlasnikLink));
			out.write("</tr>");
		}
	} else {
		out.write("<div class='no-result'>Nema rezultata</div>");
	}
	
	%>
	<a class="pages" href="/javaweb/vezba-baza/db.jsp?p=<%= pageNumber-1 %>"> < </a>
	<div class="pages">strana <%= pageNumber %></div>
	<a class="pages" href="/javaweb/vezba-baza/db.jsp?p=<%= pageNumber+1 %>"> > </a>
	</table>

</body>
</html>