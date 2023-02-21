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
	<form class="col-md-7" action="./memberAdd" method="post" id="frm">
		<div class="mb-3">
			<label for="id" class="form-label">ID</label>
			<input type="text" name="id" class="form-control" id="id"><br>
			<div id="idResult"></div>
		</div>
		<div class="mb-3">
			<label for="pw" class="form-label">비밀번호</label>
			<input type="password" name="pw" class="form-control" id="pw"><br>
			<div id="pwResult"></div>
		</div>
		<div class="mb-3">
			<label for="pwCheck" class="form-label">비밀번호</label>
			<input type="password" name="pw" class="form-control" id="pwCheck"><br>
			<div id="pwCheckResult"></div>
		</div>
		<div class="mb-3">
			<label for="userName" class="form-label">이름</label>
			<input type="text" name="memberName" class="form-control" id="userName"><br>
			<div id="userNameResult"></div>
		</div>
		<div class="mb-3">
			<label for="phone" class="form-label">전화번호</label>
			<input type="text" name="memberPhone" class="form-control" id="phone"><br>
			<div id="phoneResult"></div>
		</div>
		<div class="mb-3">
			<label for="email" class="form-label">Email</label>
			<input type="text" name="email" class="form-control" id="email"><br>
			<div id="emailResult"></div>
		</div>
		<div class="mt-5">
		<button class="btn btn-secondary" type="button" id="btn">회원가입</button>
		</div>
	</form>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
	<script src="../resources/js/memberAdd.js"></script>
</body>
</html>