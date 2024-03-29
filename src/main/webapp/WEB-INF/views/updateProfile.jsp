<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
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
		<form action="/updateProfile" method="post">
		<h2>전과하신 과를 입력해주세요</h2>
		<br>
		<input type="text" name="newMajor" id="newMajor" required>
		
		<button>정보 수정하기</button>
		</form>
		<br>
		<a href ="/back" class="aTag">뒤로가기</a>
		</div>
	</main>


	<c:if test="${not empty sessionScope.message}">
		<script>
			alert('${message}');
		</script>
		<c:remove var="message" scope="session"/>
		
	</c:if>
</body>
</html>