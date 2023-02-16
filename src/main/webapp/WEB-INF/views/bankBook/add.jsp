<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid">
	<div class="row md-7">
		<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">Product Add Page</h1>
	</div>
	<div class="row justify-content-center">
	<form class="col-md-7" action="./add" method="post">
		<div class="mb-3">
			<label for="bookName" class="form-label">상품명</label>
			<input name="bookName" type="text" class="form-control" id="bookName" placeholder="제품명을 입력해주세요.">
		</div>
		<div class="mb-3">
			<label for="bookRate" class="form-label">이자율</label>
			<input name="bookRate" type="text" class="form-control" id="bookRate" placeholder="이자율을 입력해주세요.">
		</div>
		<div class="mb-3">
  			<label for="bookDetail" class="form-label">상세정보</label>
 			<textarea name="bookDetail" class="form-control" id="bookDetail" rows="7" placeholder="상세정보를 입력해주세요."></textarea>
		</div>
		
		<div class="mb-3">
  			<label for="files" class="form-label">Image</label>
 			<input type="file" class="form-congtrol" id="files" name="pic">

		</div>
		
		<!-- <div class="form-check">
		  <input class="form-check-input" type="radio" name="bookSale" checked value="1" id="bookSale1">
		  <label class="form-check-label" for="bookSale1">
		    판매중
		  </label>
		  </div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="bookSale" value="0" id="bookSale2">
		  <label class="form-check-label" for="bookSale2">
		    판매중단
		  </label>
		  </div> -->
		
		<div class="form-check form-switch">
 			<label class="form-check-label" for="bookSale">판매여부</label>
  			<input name="bookSale" class="form-check-input" type="checkbox" value="1" role="switch" id="bookSale">
		</div>
		<div class="mt-5">
			<button class="btn btn-secondary" type="submit">상품등록</button>
		</div>
	</form>
	</div>
</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>