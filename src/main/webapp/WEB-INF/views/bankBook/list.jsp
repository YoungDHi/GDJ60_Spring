<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/table.css">
</head>
<body>
	<h1 class="tatle">BankBook List Page</h1>
	<div class="image">
	<img alt="아이유사진1" src="../resources/images/iuPhoto.jpg">
	</div>
	
	<h3>BankBook List</h3>
	<table class="t1" border="1">
		<thead>
			<tr>
				<th>상품명</th>
				<th>이자율</th>
				<th>판매여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
			<tr>
			<td><a href="./detail?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>
			<td>${dto.bookRate}</td>
			<td>
				<c:choose>
					<c:when test="${dto.bookSale eq 1}">판매중</c:when>
					<c:otherwise>판매중단</c:otherwise>
				</c:choose>
				<%-- <c:if test="${dto.bookSale eq 1}">판매중</c:if>
				<c:if test="${dto.bookSale eq 0}">판매중지</c:if> --%>
			</td>
			</tr>
			</c:forEach>			
		</tbody>
	</table>
	
	<a href="./add">상품 등록</a>
</body>
</html>