<%@ page language="java" import="java.util.List, com.skolarajak.servisi.AdministriranjeVozila, com.skolarajak.model.Vlasnik" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Brisanje vlasnika</title>
	<link rel="stylesheet" type="text/css" href="/javaweb/vezba-baza/style.css">
</head>
<body>

	<%
    
		Vlasnik vlasnik = (Vlasnik)request.getAttribute("vlasnik");
	  
		out.write("Vlasnik: "+ vlasnik.getIme() + " "+ vlasnik.getPrezime() +  " ,sa brojem vozačke dozvole: " + vlasnik.getBrojVozackeDozvole());
	    out.write(" je uspešno obrisan!");

	%>
	

</body>
</html>