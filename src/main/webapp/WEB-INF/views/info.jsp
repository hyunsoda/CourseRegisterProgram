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
			<h1>회원정보조회</h1>
			
			<table class="infoTable">
				<tr>
					<th>학번  : </th>
					<td>${sessionScope.loginStudent.studentNo}</td>
				</tr>
				
				<tr>
					<th>이름  : </th>
					<td>${sessionScope.loginStudent.studentName}</td>
				</tr>
				
				<tr>
					<th>학과  : </th>
					<td>${sessionScope.loginStudent.major}</td>
				</tr>
			</table>
			<br>
			<a href ="/back" class="aTag">뒤로가기</a>
			
		</div>
	
	
	</main>
</body>
</html>