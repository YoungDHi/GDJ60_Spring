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
		<div class="row mb-4">
			<h1 class="col-md-5 mx-auto text-center  border-bottom border-dark pb-4">Member Page</h1>
		</div>
		
		<div class="row justify-content-center">
		<div class="col-4">
			<h3>Name : ${dto.memberName}</h3>
			<h3>Phone : ${dto.memberPhone}</h3>
			<h3>Email : ${dto.email}</h3>
			<h3>Role : ${dto.roleDTO.roleName}</h3>
			<a href="./memberUpdate" class="btn btn-dark">정보 수정</a>
		</div>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>