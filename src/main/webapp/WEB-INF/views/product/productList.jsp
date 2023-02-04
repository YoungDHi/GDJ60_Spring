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
	<h1>Product List</h1>
	<table>
	<thead>
		<tr>
			<th>상품명</th><th>평점</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td><a href="./detail?productNum=${dto.productNum}">${pageScope.dto.productName}</a></td>
			<td>${pageScope.dto.productJumsu}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="./productAdd">상품등록</a>
</body>
</html>