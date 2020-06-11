var currentPage = 1;
function initPage() {
	 initUser();
	 initTable();
	 $("#myTable").tablesorter();
}

function nextPage() {
	currentPage ++;
	initTable();
}

function prevPage() {
	if (currentPage > 1) {
		currentPage --;
		initTable();
	}
}

function initUser() {
	$.get( "/javaweb/vezba-security/userServlet.html", function( data ) {
		 console.log(data);
		 $("#user-info").text("Welcome " + data.username);
		 
		});
}

function initTable() {
	$.get( "/javaweb/vezba-security/getVlasnici.html?p="+currentPage, function( data ) {
		 console.log(data);
		 populateTable(data);
		
		 $("#myTable").trigger('update');
		});
	
}

function populateTable(data) {
	var myTable = $("#myTable").find('tbody');
	$.tablesorter.clearTableBody( $("#myTable") );
	data.forEach(function (item, index) {
		 myTable.append($('<tr>')
			        .append($('<td>').text(item.ime)   
			        )
			        .append($('<td>').text(item.prezime) 
			        )
			        .append($('<td>').text(item.brojVozackeDozvole) 
			        )
			    );
	});
	$("#page-number").text(currentPage);
}

function setNumberOfRows(rows) {
	console.log("Rows:" + rows);
	 var now = new Date();
	 var time = now.getTime();
	 var expireTime = time + 96*1000*3600;
	 now.setTime(expireTime);
	 document.cookie = "rowsInTable=" + rows +";expires="+now.toGMTString();
	 location.reload();
}