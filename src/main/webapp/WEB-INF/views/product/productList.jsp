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
	<h3>Product List</h3>
	<table>
	<thead>
		<tr>
			<th>상품명</th><th>평점</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="list" var="dto">
		<tr>
			<td>${pageScope.dto.productName}</td>
			<td>${pageScope.dto.productJumsu}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</body>
</html>