<%@ page language="java" import="com.skolarajak.model.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="title standardWidth">Administracija Vozila i Vlasnika</div>
<div class="menu-header standardWidth">

<%

User user = (User)request.getSession().getAttribute("user");
out.write("Projavljeni korisnik: " + user.getUsername());
%>
<a href="/javaweb/vezba-security/logout.html">LOGOUT</a>
</div>