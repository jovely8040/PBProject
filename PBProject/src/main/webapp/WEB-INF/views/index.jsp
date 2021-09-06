<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="vo.PhonebookVO"%>
<%@page import="java.util.List"%>

<%
//요청 객체에서 list 속성 받아오기
List<PhonebookVO> list = (List<PhonebookVO>) request.getAttribute("list");
String strsearch = String.valueOf(request.getAttribute("search"));
boolean checkform = true;

%>

<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="메인페이지" name="message" /></jsp:include>

<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<%	if (strsearch == "") {
					%>
				<h2>index</h2>
				<%
				} else {
				%>
				<h2>
					index (search:
					<%=strsearch%>)
				</h2>
				<%
				}
				%>
			</div>
			<div class="col">
				<form action="<%=request.getContextPath()%>/ps" method="post">
					<label style="margin-right: 6px">search </label>
					<input type="text" name="search" id="search" placeholder="검색어를 입력하세요">
					<input type="hidden" name="a" value="search">
					<button class="btn btn-info btn-sm" type="submit" style="margin: 0 0 4px 4px; background-color: orange; border-color: orange;">search</button>
				</form>
			</div>
		</div>
			
		<!-- 리셋 버튼  -->
		<div class="row">
			<div class="col"></div>
			<div class="col showAll">
				<a href="<%=request.getContextPath()%>/ps?a=reset"> ShowAll</a>
			</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">name</th>
					<th scope="col">Phone</th>
					<th scope="col">Tel</th>
					<th scope="col">tool</th>
				</tr>
			</thead>
		<%
		for (PhonebookVO vo : list) {
		%>
			<tbody>
				<tr>
					<td scope="row"><%=vo.getName()%></td>
					<td><%=vo.getHp()%></td>
					<td><%=vo.getTel()%></td>
					<td>
						<form action="<%=request.getContextPath()%>/ps" method="post">
							<input type="hidden" name="a" value="delete">
							<input type="hidden" name="id" value="<%=vo.getId()%>" />
							<button type="submit" class="btn btn-danger btn-sm">delete</button>
						</form>
					</td>
				</tr>
			</tbody>
		<%
		}
		%>
		</table>
	
	<!-- data-target : 이 버튼을 눌렀을 때 행동을 할 요소의 아이디를 선언 -->
	<button id="signbtn" class="btn btn-primary" data-toggle="modal" data-target="#loginDialog">Sign in</button>

	<jsp:include page="/WEB-INF/views/modal.jsp"/>
	
</body>
</html>