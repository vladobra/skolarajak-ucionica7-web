<%@ page language="java" import="java.util.List, com.skolarajak.model.Vlasnik" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="/javaweb/vezba-security/assets/css/stilovi.css">
 <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 <script type="text/javascript" src="https://mottie.github.io/tablesorter/dist/js/jquery.tablesorter.min.js"></script>
<script src="/javaweb/vezba-security/assets/js/home.js"></script>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>

	<div class="title standardWidth">Administracija Vozila i Vlasnika</div>
	<div class="menu-header standardWidth">
		<div id="user-info"></div>
		<a href="/javaweb/vezba-security/logout.html">LOGOUT</a>
	</div>
	<div class="standardWidth">
			<div class="table-control">
		<a href="javascript:setNumberOfRows(10);">10</a>
		<a href="javascript:setNumberOfRows(50);">50</a>
		<a href="javascript:setNumberOfRows(100);">100</a>
		<a href="javascript:prevPage()"><</a>
		<a href="javascript:nextPage()">></a>
		<div id="page-number"></div>
	</div>
	</div>
	<table id="myTable" class="tablesorter">
	  <thead>
	    <tr>
	      <th>Ime vlasinika</th>
		  <th>Prezime vlasinika</th>
		  <th>Broj vozacke dozvole</th>
	    </tr>
	  </thead>
	  <tbody>
	   
	  </tbody>
	</table>
	<jsp:include page="footer.jsp" />
<script>
$( document ).ready(function() {
   initPage();
});
</script>
</body>
</html>