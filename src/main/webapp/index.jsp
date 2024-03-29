<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link rel="stylesheet" href="/resources/css/main.css">

</head>
<body>
	<main>
		
	
			<%-- 로그인 하지 않았을 때 --%>
			<c:choose>
				<c:when test="${empty sessionScope.loginStudent}">
				
				<div class="a">
				<div><h1>희망대학교 수강신청</h1></div>
					<form action="/login" method="post">
						<div>
							<p>아이디</p>
							<input type="text" name="loginId" id="loginId" autocomplete="off">
						</div>
						<div>
							<p>비밀번호</p>
							<input type="password" name="loginPw" id="loginPw">
						</div>
						
						<button class="btn">로그인</button>
						<br>
						<a href="/signup" class="aTag" >회원가입</a>
						<span>|</span>
						<a href="/searchPw" class="aTag">아이디 찾기</a>
						
					
					</form>
					</div>
				</c:when>
			
				<%--로그인 했을 때 --%>
				<c:otherwise>
			
					
				<c:choose>
				
					<c:when test="${empty classList}">
					<div class="a">
					<h1>${sessionScope.loginStudent.studentName}님의 수강신청</h1>
						<h2>아직 개설된 강의가 없습니다!</h2>
						<div>
							<a href="/updateProfile" class="aTag">학과 수정</a>
						</div>
						<br>
						<div>
							<a href="/logout" class="aTag">로그아웃</a>
						</div>
						</div>
					</c:when>
					
					<c:otherwise>
					<div class="a">
					<h1>${sessionScope.loginStudent.studentName}님의 수강신청</h1>
					<p>본인 전공 강의만 조회 가능합니다!</p>
					<div class="table">
						<table >
							<tr>
								<th colspan="2">강의목록</th>
								
							</tr>	
							
							<c:forEach var="cls" items="${classList}">
							<tr>
							<form action ="register" method="post">
								<td>${cls.clsName}</td>
								<input name="clsName" value="${cls.clsName}" type="hidden"> 
								<td><button class="regbtn">신청하기</button></td>
								
							</form>	
							</tr>
							</c:forEach>
						</table>
						</div>
						<section class="section">
								<div class="height">
								<a href="/registerList" class="bTag">신청 내역 조회</a>
								</div>
							<div></div>
								<div class="height">
								<a href="/info" class="bTag">학생 정보 조회</a>
								</div> 
						</section>	
						<section class="section">
								<div class="height">
								<a href="/updateProfile" class="bTag">학과 수정</a>
								</div>
								<div></div>
								<div class="height">
									<a href="/logout" class="bTag">로그아웃</a>
								</div>
						</section>		
								
							</div>	
					</c:otherwise>
				
				</c:choose>
				
			
				
				</c:otherwise>
				
	</c:choose>
		
			
		
	</main>
	
	<c:if test="${not empty sessionScope.message}">
		<script>
			alert('${message}');
		</script>
		<c:remove var="message" scope="session"/>
	</c:if>
	
	
</body>
</html>