<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="container-fluid">
		<div class="row col-md-1 offset-md-3">
			<table class="table table-hover">
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>
							<div class="col-7 text-truncate">
							<a href="./detail?num=${dto.num}">${dto.title}</a></td>
							</div>
							<c:if test="${i.first}">
								${dto.contents}
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
