<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="mb-3 mt-3">
			<label for="username" class="form-label">아이디:</label>
			<input type="text" name="username" class="form-control" id="username">
		</div>
		<div class="mb-5">
			<label for="password" class="form-label">비밀번호:</label>
			<input type="password" name="password" class="form-control" id="password">
		</div>
		<button id="btn-login" class="btn btn-primary">로그인</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>