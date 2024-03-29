<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 목록 조회</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	<h1>수강신청하기</h1>
	
	<table>
		<tr>
			<th>강의명</th>
			<th>등록하기</th>
		</tr>	
		
		<c:forEach var="cls" items="${classList}">
		<tr>
			<td>${cls.clsName}</td>
			<td><a href="/register?clsNo=${cls.clsNo}">등록하기</a></td>
		</tr>	
		</c:forEach>
		
	</table>

	<c:if test="${not empty sessionScope.message}">
		<script>
		alert("${message}");
		</script>	
		<c:remove var="message" scope="session"/>
	</c:if>
</body>
</html>