<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Add</h1>
	<form action="./productAdd" method="post">
		상품명 : 
		<input type="text" name="productName">
		상품정보 : 
		<textarea name="productDetail" rows="" cols=""></textarea><br>
		<button type="submit">등록</button>
	</form>
</body>
</html>