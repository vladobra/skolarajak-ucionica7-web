<%@ page language="java" import="com.skolarajak.model.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

User user = (User)request.getSession().getAttribute("user");
out.write("Projavljeni korisnik: " + user.getUsername());
%>
</body>
</html>