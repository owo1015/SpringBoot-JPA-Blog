<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<input type="hidden" id="id" value="${board.id}"/>
		<div class="mb-3">
			<input value="${board.title}" type="text" class="form-control" id="title">
		</div>
		<div class="mb-3">
			<textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
		</div>
	</form>
	<button id="btn-update" class="btn btn-primary">수정 완료</button>
</div>

<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 400
	});
</script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>