<%@page import="com.iu.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid my-5">
		<div class="row md-7">
		<h1 class=" col-md-7 mx-auto text-center border-bottom border-dark pb-4">Product List</h1>
	</div>
	<div class="row md-7 col-md-7 mx-auto">
		<table class="table">
			<thead class="table-dark">
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
	</div>
		<a class="btn btn-danger" href="./productAdd">상품등록</a>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>