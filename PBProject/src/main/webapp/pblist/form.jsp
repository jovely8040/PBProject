<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 주소 추가</title>
</head>
<body>

	<h1>주소록 Servlet</h1>
	<h3>새 주소 등록</h3>
	<div class="box" style="border: 2px solid lightblue; padding : 10px; width: 250px; height: 180px; border-radius : 5%;">
		<!-- action: 요청을 처리할 페이지(서블릿/JSP), method: 요청방식 -->
		<form action="<%= request.getContextPath() %>/pl"
				method="post">
			<label for="name">이름</label>
			<div><input type="text" name="name" id="name" /></div>
			<label for="hp">휴대전화</label>
			<div><input type="text" name="hp" id="hp" /></div>
			<label for="tel">집전화</label>
			<div><input type="text" name="tel" id="tel" /></div>
		
			<!-- 전송 버튼 -->
			<div style="text-align: right; padding : 10px 96px 0px;"><input type="submit" value="주소등록" /></div>
		</form>
	</div>
	<!-- 리스트로 돌아가기 -->
	<p>
		<a href="<%= request.getContextPath() %>/pl">목록 보기</a>
	</p>

</body>
</html>