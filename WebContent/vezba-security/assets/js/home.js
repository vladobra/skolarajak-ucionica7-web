function initPage() {
	 initUser();
	 initTable();
}

function initUser() {
	$.get( "/javaweb/vezba-security/userServlet.html", function( data ) {
		 console.log(data);
		 $("#user-info").text("Welcome " + data.username);
		 
		});
}

function initTable() {
	$("#myTable").tablesorter();
}