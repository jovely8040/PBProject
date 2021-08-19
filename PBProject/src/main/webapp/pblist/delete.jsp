<%@page import="com.example.pblist.dao.PhonebookDaoImpl"%>
<%@page import="com.example.pblist.dao.PhonebookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//	파라미터 받기
	Long pk = Long.valueOf(request.getParameter("id"));
	//	Dao 불러오기
	PhonebookDao dao = new PhonebookDaoImpl();
	//	삭제
	dao.delete(pk);
	
	//	index.jsp로 리다이렉트
	response.sendRedirect(request.getContextPath() + "/pblist/");
%>