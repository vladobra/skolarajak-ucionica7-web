<%@ page language="java" import="java.util.List, com.skolarajak.model.Vlasnik" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="/javaweb/vezba-security/assets/css/stilovi.css">
<meta charset="UTF-8">
<title>Admin Home Page</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div class="standardWidth">
		<table class="tabela-vlasnici" border="1">
		<th>Ime vlasinika</th>
		<th>Prezime vlasinika</th>
		<th>Broj vozacke dozvole</th>
			<%
			int pageNumber = 1;
			
			try {
				pageNumber = (Integer)request.getAttribute("pageNumber");
			} catch(NumberFormatException e) {
				
			}
			
			List<Vlasnik> vlasnici = (List<Vlasnik>)request.getAttribute("listaVlasnike");
			
			String dataTemplate = "<td>%s</td>";
			if(vlasnici.size() > 0) {
				for (Vlasnik vlasnik : vlasnici) {
					out.write("<tr>");
					
					out.write(String.format(dataTemplate,vlasnik.getIme()));
					out.write(String.format(dataTemplate,vlasnik.getPrezime()));
					out.write(String.format(dataTemplate,vlasnik.getBrojVozackeDozvole()));
					//domaci cas53
					String brojVozDozvole = vlasnik.getBrojVozackeDozvole();
					
					out.write("</tr>");
				}
			} else {
				out.write("<div class='no-result'>Nema rezultata</div>");
			}
			
			%>
	
		</table>
	</div>
	<jsp:include page="paginator.jsp" >
	  <jsp:param name="servlet" value="adminHomeServlet" />
	  <jsp:param name="pageNumber" value="<%= pageNumber  %>" />
	</jsp:include>
<jsp:include page="footer.jsp" />
</body>
</html>