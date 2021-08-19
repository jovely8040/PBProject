<%@page import="com.example.pblist.vo.PhonebookVo"%>
<%@page import="com.example.pblist.dao.PhonebookDaoImpl"%>
<%@page import="com.example.pblist.dao.PhonebookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//	파라미터 받아오기
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String tel = request.getParameter("tel");

	//	DAO
	PhonebookDao dao = new PhonebookDaoImpl();
	
	//	Vo 객체 생성
	PhonebookVo vo = new PhonebookVo();
	vo.setName(name);
	vo.setHp(hp);
	vo.setTel(tel);
	
	dao.insert(vo);
	
	//	index.jsp로 리다이렉트(페이지 전환: 302)
	response.sendRedirect(request.getContextPath() + "/pblist/");
%> 