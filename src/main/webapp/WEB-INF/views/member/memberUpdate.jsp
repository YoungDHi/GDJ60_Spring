<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid my-5">
		<div class="col-md-7 mx-auto text-center  border-bottom border-dark pb-4">
			<h1>Member Update</h1>
		</div>
		<div class="row">
			<form action="./memberUpdate" method="post">
				
				
				<!-- 비밀번호 : 
				<input type="text" name="pw"><br> -->
				이름 : 
				<input type="text" name="memberName" value="${dto.memberName}"><br>
				전화번호 :
				<input type="text" name="memberPhone" value="${dto.memberPhone}"><br>
				Email :
				<input type="text" name="email" value="${dto.email}"><br>
				<button type="submit">정보 수정</button>
			</form>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>