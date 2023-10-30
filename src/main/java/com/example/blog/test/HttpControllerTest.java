package com.example.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML 파일)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

	private static final String TAG = "HttpControllerTest : ";
	
	// http://localhost:8000/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
		// Member m = new Member(1, "ssar", "1234", "ssar@nate.com");
		Member m = Member.builder().id(1).username("ssar").password("1234").email("ssar@nate.com").build();
		System.out.println(TAG + "getter : " + m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG + "setter : " + m.getUsername());
		return "lombok test 완료";
	}
	
	// 인터넷 브라우저 요청은 get  요청만 가능
	// http://localhost:8000/blog/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8000/blog/http/post (insert)
	@PostMapping("/http/post")
	public String postTest(Member m) {
		return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// text/plain
	// public String postTest(@RequestBody String text) {
	// 	return "post 요청 : " + text;
	// }
	
	// application/json, MessageConverter(스프링부트)가 자동으로 매핑
	// public String postTest(@RequestBody Member m) {
	// 	return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	// }
	
	// http://localhost:8000/blog/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8000/blog/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
