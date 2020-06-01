<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div class="paginator standardWidth">
	    <a class="pages" href="/javaweb/vezba-security/${param.servlet}.html?p=${param.pageNumber -1}"> < </a>
		<div class="pages">strana ${param.pageNumber} </div>
		<a class="pages" href="/javaweb/vezba-security/${param.servlet}.html?p=${param.pageNumber + 1}"> > </a>
	</div>