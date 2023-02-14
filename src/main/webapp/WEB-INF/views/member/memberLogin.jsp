<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
			<h1>Member Login</h1>
		<section class="w-100 p-4 d-flex justify-content-center pb-4">
			<div class="row">
    		<form style="width: 22rem;" action="./memberLogin" method="post">
	        	<!-- id input -->
	        	<div class="form-outline mb-4">
	        		<input name="id" type="text" id="form2Example1" class="form-control">
					<label class="form-label" for="form2Example1" style="margin-left: 0px;">id</label>
					<div class="form-notch"><div class="form-notch-leading" style="width: 9px;"></div>
						<div class="form-notch-middle" style="width: 88px;"></div>
						<div class="form-notch-trailing"></div>
					</div>
				</div>
	
				<!-- Password input -->
				<div class="form-outline mb-4">
	         		<input name="pw" type="password" id="form2Example2" class="form-control">
					<label class="form-label" for="form2Example2" style="margin-left: 0px;">Password</label>
					<div class="form-notch">
						<div class="form-notch-leading" style="width: 9px;"></div><div class="form-notch-middle" style="width: 61.6px;"></div><div class="form-notch-trailing"></div>
					</div>
				</div>
	
				<!-- 2 column grid layout for inline styling -->
				<div class="row mb-4">
					<div class="col d-flex justify-content-center">
	            	<!-- Checkbox -->
	            		<div class="form-check">
	              			<input class="form-check-input" type="checkbox" value="" id="form2Example31" checked="">
	              			<label class="form-check-label" for="form2Example31"> Remember me </label>
	            		</div>
	          		</div>
	
	         		<div class="col">
	            	<!-- Simple link -->
	            		<a href="#!">Forgot password?</a>
	          		</div>
	        	</div>
	
	        	<!-- Submit button -->
	        	<button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>
         	</form>
      	</div>
    </section>
    <c:import url="../template/common_js.jsp"></c:import>
</body>
</html>