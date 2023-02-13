<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>Member Join</h1>
	<form action="./memberJoin" method="post">
		ID : 
		<input type="text" name="id"><br>
		비밀번호 : 
		<input type="text" name="pw"><br>
		이름 : 
		<input type="text" name="memberName"><br>
		전화번호 :
		<input type="text" name="memberPhone"><br>
		Email :
		<input type="text" name="email"><br>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>