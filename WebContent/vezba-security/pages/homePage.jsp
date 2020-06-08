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
			
	</div>
	<table id="myTable" class="tablesorter">
	  <thead>
	    <tr>
	      <th>Last Name</th>
	      <th>First Name</th>
	      <th>Email</th>
	      <th>Due</th>
	      <th>Web Site</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <td>Smith</td>
	      <td>John</td>
	      <td>jsmith@gmail.com</td>
	      <td>$50.00</td>
	      <td>http://www.jsmith.com</td>
	    </tr>
	    <tr>
	      <td>Bach</td>
	      <td>Frank</td>
	      <td>fbach@yahoo.com</td>
	      <td>$50.00</td>
	      <td>http://www.frank.com</td>
	    </tr>
	    <tr>
	      <td>Doe</td>
	      <td>Jason</td>
	      <td>jdoe@hotmail.com</td>
	      <td>$100.00</td>
	      <td>http://www.jdoe.com</td>
	    </tr>
	    <tr>
	      <td>Conway</td>
	      <td>Tim</td>
	      <td>tconway@earthlink.net</td>
	      <td>$50.00</td>
	      <td>http://www.timconway.com</td>
	    </tr>
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