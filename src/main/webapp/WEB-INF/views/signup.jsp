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
	<div class="b">
	<div>
		<h1 id="title">회원가입</h1>
	</div>
	<form action="/signup" method="post" onsubmit="return validate()" >
		<div>
			<p>아이디</p>
			<input type="text" name="inputId" autocomplete="off"  id="inputId" required>
			<br>
			<span id="idText"></span>
		</div>
		
		<div>
			<p>비밀번호</p>
			<input type="password" name="inputPw" id="inputPw" required>
			<br>
			<span id="PwText"></span>
		</div>
		<div>
			<p>비밀번호 확인</p>
			<input type="password" name="inputPw2" id="inputPw2" required>
			<br>
			<span id="pwText2"></span>
		</div>
		
		<div>
			<p>이름</p>
			<input type="text" name="inputName" id="inputName" required>
			<br>
			<span id="nameText"></span>
		</div>
		
		<div>
			<p>전공</p>
			<input type="text" name="inputMajor" id="inputMajor" required>
			<br>
			<span id="majorText"></span>
		</div>
		
		<div>
			<button class="signupbtn">회원가입하기</button>
		</div>
		
	</form>
	<a href ="/back" class="aTag">뒤로가기</a>
	</div>
</main>	

	<c:if test="${not empty sessionScope.message}">
		<script>
			alert('${message}');
		</script>
		<c:remove var="message" scope="session"/>
	</c:if>
	
<script src="/resources/js/signUp.js"></script> 	
</body>
</html>