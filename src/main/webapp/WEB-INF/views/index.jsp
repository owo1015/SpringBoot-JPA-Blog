<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<style>
.page-link {
  color: #000; 
  background-color: #fff;
  border: 1px solid #ccc; 
}
.page-item.active .page-link {
 z-index: 1;
 color: #555;
 font-weight:bold;
 background-color: #f1f1f1;
 border-color: #ccc;
}
.page-link:focus, .page-link:hover {
  color: #000;
  background-color: #fafafa; 
  border-color: #ccc;
}
</style>

<div class="container">

	<c:forEach var="board" items="${boards.content}">
		<div class="card m-2">
			<div class="card-body m-1">
				<h4 class="card-title">${board.title}</h4>
				<a href="/board/${board.id}" class="btn btn-secondary btn-sm">상세보기</a>
			</div>
		</div>
	</c:forEach>

	<ul class="pagination justify-content-center mt-4">
		<c:choose>
			<c:when test="${boards.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1 }">이전</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number-1 }">이전</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1 }">다음</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number+1 }">다음</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
	
</div>

<%@ include file="layout/footer.jsp"%>