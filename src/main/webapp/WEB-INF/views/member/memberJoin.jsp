<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Join</h1>
	<form action="./memberJoin" method="post">
		ID : 
		<input type="text" name="memberId"><br>
		비밀번호 : 
		<input type="text" name="memberPassword"><br>
		이름 : 
		<input type="text" name="memberName"><br>
		주소 :
		<textarea name="memberAddress" rows="" cols=""></textarea><br>
		전화번호 :
		<input type="text" name="memberPhone"><br>
		Email :
		<input type="text" name="memberEmail"><br>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>