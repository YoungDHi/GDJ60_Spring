<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List</h1>
	<table>
		<thead>
			<tr>
			<th>회원 ID</th>
			<th>회원 이름</th>
			<th>회원 핸드폰</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href="./memberPage?memberId=${dto.memberId}">${dto.memberId}</a></td>
				<td>${pageScope.dto.memberName}</td>
				<td>${dto.memberPhone}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./memberJoin">회원가입</a>
	<a href="./memberLogin">로그인</a>
</body>
</html>