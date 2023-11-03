<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<div class="mb-4">
		<button class="btn btn-secondary btn-sm" onclick="history.back()">돌아가기</button>
	</div>

	<div>
		<h3>${board.title}</h3>
		<div class="d-flex justify-content-between">
			<div>
				<c:set var="createDate" value="${board.createDate}" />
				<fmt:formatDate value="${createDate}" pattern="y.M.d H:mm" type="date"/>
				<br />
				<span>${board.user.username}</span>
			</div>
			<div>
				<c:if test="${board.user.id == principal.user.id}">
					<a href="/board/${board.id}/updateForm" class="btn btn-outline-warning btn-sm">수정</a>
					<button id="btn-delete" class="btn btn-outline-danger btn-sm">삭제</button>
				</c:if>
			</div>
		</div>
		<hr />
	</div>

	<div class="mb-5">
		<div>${board.content }</div>
	</div>

	<div class="card">
		<form>
			<input type="hidden" id="userId" value="${principal.user.id}"/>
			<input type="hidden" id="boardId" value="${board.id}"/>
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">
				<button type="button" id="btn-reply-save" class="btn btn-secondary btn-sm">댓글 등록</button>
			</div>
		</form>
	</div>
	<br />

	<div class="card">
		<div class="card-header">댓글</div>
		<ul id="reply-box" class="list-group">
			<c:forEach var="reply" items="${board.replys}">
				<li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
					<div>${reply.content}</div>
					<div class="d-flex">
						<div>작성자 : ${reply.user.username} &nbsp;</div>
						<button onClick="index.replyDelete(${board.id}, ${reply.id})" class="badge bg-secondary">삭제</button>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>