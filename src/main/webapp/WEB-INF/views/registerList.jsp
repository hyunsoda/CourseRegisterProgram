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
	
	<c:choose>
	<c:when test="${empty sessionScope.regList}">
	
	<div class="a">
	<h1>${sessionScope.loginStudent.studentName}님의 신청강의 목록</h1>
		<h2>등록된 강의가 없습니다</h2>
		<a href ="/back" class="aTag">뒤로가기</a>
	</div>
	</c:when>
	
	<c:otherwise>
	<div class="a">
	<h1>${sessionScope.loginStudent.studentName}님의 신청강의 목록</h1>
	<table>
		<tr>
			<th colspan="2">강의 목록</th>
			
		</tr>
		
		<c:forEach var="reg" items="${regList}">
			<tr>
				<td>${reg.clsName}</td>		
				<td><a href="/dropClass?regNo=${reg.regNo}"
				onclick="return confirm('정말 삭제하시겠습니까?');" class="cancel">취소하기</a></td>
			</tr>
			
		</c:forEach>
		
	</table>
	<br>
	<a href="/back" class="aTag">뒤로가기</a>
	</div>
	</c:otherwise>
	</c:choose>
	</main>
</body>
</html>