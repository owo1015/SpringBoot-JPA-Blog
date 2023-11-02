<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="mb-3">
			<input type="text" class="form-control" id="title">
		</div>
		<div class="mb-3">
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">글쓰기 완료</button>
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