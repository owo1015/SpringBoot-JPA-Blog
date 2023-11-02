<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<div class="mb-3">
		<button class="btn btn-secondary btn-sm" onclick="history.back()">돌아가기</button>
	</div>

	<div class="mb-3">
		<h3>${board.title}</h3>
		글 번호 : <span id="id">${board.id}</span>
		작성자 : <span>${board.user.username}</span>
	</div>
	
	<div>
		<c:if test="${board.user.id == principal.user.id}">
			<a href="/board/${board.id}/updateForm" class="btn btn-outline-warning btn-sm">수정</a>
			<button id="btn-delete" class="btn btn-outline-danger btn-sm">삭제</button>
		</c:if>
	</div>
	<hr />
	
	<div class="mb-5">
		<div>${board.content }</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>