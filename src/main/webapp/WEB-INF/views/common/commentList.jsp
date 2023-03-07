<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-srtiped">
	<c:forEach items="${list}" var="dto">
		<tr>
			<td id="contents${dto.num}">
				${dto.contents}
			</td>
			<td>${dto.writer}</td>
			<td>${dto.regDate}</td>
			<td>
				<c:if test="${member.id eq dto.writer}">
					<button class="btn btn-primary update" data-comment-num="${dto.num}" data-bs-toggle="modal" data-bs-target="#contentsModal">UPDATE</button>
				</c:if>
			</td>
			<td>
				<c:if test="${member.id eq dto.writer}">
					<!-- <textarea class="form-control" id="replyUpdate" rows="3"></textarea>
					<button class="btn btn-primary upd" data-update-num="${dto.num}">UPDATE</button> -->
					<button class="btn btn-danger del" data-comment-num="${dto.num}">DELETE</button>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- paging -->
<div class="row">
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	  	<li class="page-item">
	      <a class="page-link" href="#" aria-label="Previous" data-comment-page="1">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>					    
	    <li class="page-item ${pager.before? 'disabled':''}">
	      <a class="page-link" href="#" aria-label="Previous" data-comment-page="${pager.startNum-1}">
	        <span aria-hidden="true">&lsaquo;</span>
	      </a>
	    </li>
	    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	    	<li class="page-item"><a class="page-link" href="#" data-comment-page="${i}">${i}</a></li>
	    </c:forEach>
	    <li class="page-item ${pager.after eq false ? 'disabled' : ''}">
	      <a class="page-link" href="#"  aria-label="Next" data-comment-page="${pager.lastNum+1}">
	        <span aria-hidden="true">&rsaquo;</span>
	      </a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#"  aria-label="Next" data-comment-page="${pager.totalPage}">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>	
</div>

