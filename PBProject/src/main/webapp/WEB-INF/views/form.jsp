<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>

<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="메인페이지" name="message"/>
</jsp:include>

<body>
	<h2>새 주소 등록</h2>
	<!-- action: 요청을 처리할 페이지(서블릿/JSP), method: 요청방식 -->
	<form action="<%=request.getContextPath()%>/ps" method="post">
		<input type="hidden" value="add" name="a"/>

			<table border="1">
				<tr >
					<th width="120">이름</th>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<th>휴대전화</th>
					<td><input type="text" name="hp" id="hp"></td>
				</tr>
				<tr>			
					<th>집전화</th>
					<td><input type="text" name="tel" id="tel"></td>
				</tr>
			</table>
			
			<!-- 전송 버튼 -->
			<input type="submit" value="등록">
	</form>
	<!-- 리스트로 돌아가기 -->
	<p>
		<a href="<%=request.getContextPath()%>/ps?a=reset">목록 보기</a>
	<p>

</body>
</html>