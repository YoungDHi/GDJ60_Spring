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
	<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">Member Join</h1>
	<div class="row justify-content-center">
	<form class="col-md-7" action="./memberAdd" method="post">
		<div class="mb-3">
		<label for="id" class="form-label">ID</label>
		<input type="text" name="id" class="form-control" id="id"><br>
		</div>
		<div class="mb-3">
		<label for="id" class="form-label">비밀번호</label>
		<input type="text" name="pw"><br>
		</div>
		<div class="mb-3">
		이름 : 
		<input type="text" name="memberName"><br>
		</div>
		<div class="mb-3">
		전화번호 :
		<input type="text" name="memberPhone"><br>
		</div>
		<div class="mb-3">
		Email :
		<input type="text" name="email"><br>
		</div>
		<div class="mt-5">
		<button class="btn btn-secondary" type="submit">회원가입</button>
		</div>
	</form>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>