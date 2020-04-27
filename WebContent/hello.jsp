<%@ page import="java.util.Date, java.util.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	errorPage="myerrorpage.jsp"%>

<html>
<head>
<meta charset="UTF-8">
<title>hello from jsp</title>
</head>
<body>
	<%@ include file="header.html"%>
	<jsp:include page="printdate.jsp" />

	<%
	    Long ms = System.currentTimeMillis();
	    out.write(ms.toString());
	    if (ms % 2 == 0) {
	%>

	<jsp:forward page="prikaz.jsp">
		<jsp:param name="name" value="<%=ms%>" />
	</jsp:forward>

	<%
		}
	%>

	<!-- Declaration -->
	<%! int data = 50;%>

	<!-- Execution  -->
	<%
		// Petlja
	for (int i = 0; i < 10; i++) {
		out.write("<b>" + i + "</b>шђђшђђш broj<br/>");
		//throw new Exception();
	}
	%>
	<!-- Evaluation -->
	<%="Value of the variable is:" + data%>
	<br />
	<%=new Date()%>


</body>
</html>