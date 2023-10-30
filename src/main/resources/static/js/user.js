let index = {
	init: function() {
		$("#btn-save").on("click", ()=>{
			this.save();
		});
		$("#btn-login").on("click", ()=>{
			this.login();
		});
	},
	
	save: function() {
		// alert('user의 save 함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		// console.log(data);
		
		// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		// ajax 호출시 비동기 호출이 default
		$.ajax({
			// 회원가입 수행 요청
			type: "POST",
			url: "/api/user",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp){
			// 성공
			alert("회원가입이 완료되었습니다.");
			location.href="/";
		}).fail(function(){
			// 실패
			alert(JSON.stringify(error));
		});
	},
	
	login: function() {
		// alert('user의 save 함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
		};
		
		$.ajax({
			// 로그인 수행 요청
			type: "POST",
			url: "/api/user/login",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp){
			// 성공
			alert("로그인이 완료되었습니다.");
			location.href="/";
		}).fail(function(){
			// 실패
			alert(JSON.stringify(error));
		});
	}
}

index.init();