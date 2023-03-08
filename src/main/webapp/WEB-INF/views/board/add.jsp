<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<c:import url="../template/common_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid">
	<div class="row md-7">
		<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">${boardName} Add Page</h1>
	</div>
	<div class="row justify-content-center">
	<form class="col-md-7" action="./add" method="post" enctype="multipart/form-data">
		<div class="mb-3">
			<label for="writer" class="form-label">작성자</label>
			<input name="writer" type="text" class="form-control" id="writer" value="${member.id}" readonly="readonly">
		</div>
		<div class="mb-3">
			<label for="title" class="form-label">제목</label>
			<input name="title" type="text" class="form-control" id="title" placeholder="제목입력">
		</div>
		<div class="mb-3">
  			<label for="contents" class="form-label">내용</label>
 			<textarea name="contents" class="form-control" id="contents" rows="7" placeholder="내용을 입력해주세요."></textarea>
		</div>
		
		<div id="fileList">
			<!-- <div class="mb-3">
				
				<input type="file" class="form-control" id="files" name="files">
				<button type="button">X</button>
			</div> -->
			<button type="button" id="fileAdd">ADD</button>
		</div>
		
		<div class="mt-5">
			<button class="btn btn-secondary" type="submit">글쓰기</button>
		</div>
	</form>
</div>
</div>
<script src="../resources/js/fileManager.js"></script>
<script>
	
	setMax(5);
	$('#contents').summernote()
	setParam('addFiles');
	
</script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>