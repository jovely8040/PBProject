<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
<!-- Google Web Font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,400;0,700;1,400&display=swap" rel="stylesheet">

<!-- 부트스트랩 css 사용 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

<!--  부트스트랩 js 사용 -->
<!--  부트스트랩 js 사용 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<script>
	function checkForm() {
		const form = document.getElementById("joinform")
		console.log(form);
		
		// 이름 검증
		let userid = form.name.value.trim();
		if (userid.length < 2 ||  userid.length > 10) {
          //  검증 실패
          alert("이름을 입력하세요.");
          form.name.focus(); //  포커스 부여
        return false;
        }
		
		let userhp = form.hp.value.trim();
		if (userhp.length < 4 ||  userhp.length > 13) {
          //  검증 실패
          alert("휴대전화 번호를 정확히 입력하세요.");
          form.hp.focus(); //  포커스 부여
        return false;
        }
		
		let usertel = form.tel.value.trim();
		if (usertel.length < 4 ||  usertel.length > 13) {
          //  검증 실패
          alert("집전화 번호를 정확히 입력하세요.");
          form.tel.focus(); //  포커스 부여
        return false;
        }
		return true;
	}
</script>

<style>
* {
	font-family: 'Ubuntu', sans-serif;
}
h1, th, td {
	text-align: center;
}

h1 {
	padding: 30px 0px;
	font-weight: 700;
	color: #4b4b4b;
}

div.col, div.row {
	text-align: right;
}

h2 {
	text-align: left;
}

div.showAll {
	margin-bottom: 1em;
}

.modal-header h5 {
	text-align: center;
}

.form-row {
	margin-bottom: 10px;
}

.modal-body {
	padding: 1rem 2rem 0 2rem;
}

.modal-footer {
	margin-top: 20px;
}

.callImg {
	max-width: 36px;
	height: auto;
	margin: 0 20px 6px 0;
}

.signinImg {
	max-width: 36px;
	height: auto;
	margin-right: 10px;
}
</style>
</head>
<body>
<h1><img src="<%= request.getContextPath() %>/images/call.png" class="callImg" />주소록 Servlet</h1>

</body>
</html>