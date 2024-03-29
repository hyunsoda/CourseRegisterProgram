<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	<main>
		<div class="a">
			<h1>${sessionScope.searchId.studentName}님의 아이디</h1>
			<p>${searchId.studentId}</p>
			
			<br>
			<a href="/" class="aTag">로그인하기</a>
		</div>
	</main>
</body>
</html>