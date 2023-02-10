<%@page import="com.iu.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	
	<h1 class="tatle">Product List</h1>
	<% 
	List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list");
	for(ProductDTO productDTO:ar){
	%>
		<h3><%= productDTO.getProductName() %></h3>
		<h3><%= productDTO.getProductScore()%></h3>
	<%} %>
	
	<hr>
	<table class="tbl" border="1">
		<thead>
			<tr>
				<th>상품명</th><th>평점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto"> <!-- dto는 page영역에 담김 -->
				<tr>
					<td><a href="./detail?productNum=${dto.productNum}">${pageScope.dto.productName}</a></td>
					<td>${dto.productScore}</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>
	
		<a class="btn btn-danger" href="./productAdd">상품등록</a>
	
	
</body>
</html>