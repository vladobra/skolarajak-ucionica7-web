<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean scope="session" id="vlasnik" class="com.skolarajak.model.Vlasnik"></jsp:useBean>  

  

<jsp:getProperty property="ime" name="vlasnik"/><br>  
<jsp:getProperty property="prezime" name="vlasnik"/><br>  
<jsp:getProperty property="brojVozackeDozvole" name="vlasnik" /><br>  
</body>
</html>