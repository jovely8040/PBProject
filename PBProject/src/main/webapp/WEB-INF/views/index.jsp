<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="vo.PhonebookVO"%>
<%@page import="java.util.List"%>

<%
//요청 객체에서 list 속성 받아오기
List<PhonebookVO> list = (List<PhonebookVO>) request.getAttribute("list");
String strsearch = String.valueOf(request.getAttribute("search"));
%>

<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="메인페이지" name="message" /></jsp:include>

<body>
	<%if (strsearch.isEmpty()){ %>
	<h2>목록</h2>
		<%} else { %>
	<h2>목록 (검색어: <%=strsearch %>)</h2>
		<%} %>
		
	<form action="<%=request.getContextPath()%>/ps" method="post"  >
		<!--<input type="hidden" name="a" value="search">-->
		<!--<input type="submit" VALUE="검색"style="margin:0px ">-->
		<label>검색어 </label>
		<input type="text" name="search" id="search" style="margin:0px">	
		<input type="hidden" name="a" value="search"> 
		<input type="submit" value="검색"style="margin:0px ">
		<!-- 리셋 버튼  -->
		<a href="<%=request.getContextPath()%>/ps?a=reset"> 모든 연락처 보기</a>
	</form>

	<br>
	<table border="1">
			<thead>
				<tr bgcolor="lightGrey">
					<th width="100" align="center">이름</th>
					<th width="150" align="center">휴대전화</th>
					<th width="150" align="center">집전화</th>
					<th width="100" align="center">도구</th>
				</tr>
			</thead>
			<%
			for (PhonebookVO vo : list) {
			%>
			<tbody>
				<tr>
					<td align="center"><%=vo.getName()%></td>
					<td align="center"><%=vo.getHp() %></td>
					<td align="center"><%=vo.getTel()%></td>
					<td width="50" align="center">
					<form action="<%=request.getContextPath()%>/con" method="post">
						<input type="hidden" name="a" value="delete"> 
						<input type="hidden" name="id" value="<%=vo.getId()%>"/>
						<input type="submit" VALUE="삭제">
					</form>
					</td>
				</tr>
			</tbody>
			<%
			}
			%>		
	</table>
 
	<!-- 등록 폼으로 이동 -->
	<p>
		<a href="<%= request.getContextPath() %>/ps?a=form">새 주소 추가</a>
	</p>
	
	
 
</body>
</html>