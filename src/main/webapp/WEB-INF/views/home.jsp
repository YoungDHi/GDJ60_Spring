<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<a class="a1" href="/member/memberJoin">MemberJoin</a>
<a class="a1" href="/product/list">ProductList</a>
<a class="a1" href="/bankBook/list">BankBookList</a>
<a class="a1" href="./bankBook/list">BankBookList</a>

<img alt="아이유사진1" src="/resources/images/iuPhoto.jpg">
<img alt="아이유사진2" src="./resources/images/iuPhoto2.jpg">


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
