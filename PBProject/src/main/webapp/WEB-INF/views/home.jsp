<%@page import="com.example.pblist.vo.PhonebookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//요청 객체에서 list 속성 받아오기
List<PhonebookVo> list = (List<PhonebookVo>)request.getAttribute("list");
String holder = request.getParameter("search");
if(holder == null) {
	holder = "";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작 화면</title>

<style type="text/css">
.trstyle th,td{padding: 0px 60px 0px;}
</style>

</head>
<body>
	<h1>주소록 Servlet</h1>
	<h3>목록</h3>

 	<form action="ps" method="POST" id="search">
   		<!-- hidden은 사용자 입력은 아니지만 전송해야 할 데이터 -->
   		<label for="search">검색어</label>
		<input type="hidden" value="search" name="a" />
    	<input type="text" name="search" id="search" placeholder="<%= holder %>" />
   		<!-- 전송 버튼 -->	
 	  	<input type="submit" value="검색" />
   </form>
   
 	<!-- 폰북 리스트: 목록 -->
	<table border="1" style="margin-top: 20px;">
		<!-- 행 -->
		<thead style="background-color:lightblue; border: none; ">
			<tr class="trstyle">
				<th>이름</th>
				<th>휴대전화</th>
				<th>전화번호</th>
				<th>도구</th>
			</tr>
		</thead>
		<tbody>
			<!-- 루프 시작 -->
			<% for (PhonebookVo vo: list) { %>
				<tr>
					<td><%= vo.getName() %></td>
					<td><%= vo.getHp() %></td>
					<td><%= vo.getTel() %></td>
					<td>
					<!-- 삭제 폼 -->
						<form action="<%= request.getContextPath() %>/ps" method="POST">
							<input type="hidden" name="a" value="delete" />
							<input type="hidden" name="id" value="<%= vo.getId() %>" />
							<input type="submit" value="삭제" />
						</form>
					</td>
				</tr>
			<% } %>
			<!-- 루프의 끝 -->
		</tbody>
	</table>
 
	 <!-- 작성 폼으로 이동 -->
	<p>
		<a href="<%= request.getContextPath() %>/ps?a=form">새 주소 추가</a>
	</p>
 
</body>
</html>