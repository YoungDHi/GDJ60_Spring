<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 등록 Page</h1>
	<form action="./add" method="post">
		상품명 : <input type="text" name="bookName" placeholder="제품명을 입력하세요."><br>
		이자율 : <input type="text" name="bookRate"><br>
		상세정보 : <textarea name="bookDetail" rows="" cols=""></textarea><br>
		판매여부 : <input type="text" name="bookSale"><br>
		<button type="submit">상품등록</button>
	</form>
</body>
</html>