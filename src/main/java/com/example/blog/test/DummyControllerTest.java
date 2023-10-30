package com.example.blog.test;

// import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.model.RoleType;
import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;

import jakarta.transaction.Transactional;

@RestController
public class DummyControllerTest {

	@Autowired // 의존성 주입(DI)
	private UserRepository userRepository;
	
	// http://localhost:8000/blog/dummy/join
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("id: " + user.getId());
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("role: " + user.getRole());
		System.out.println("createDate: " + user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
	
	// {id} 주소로 파라미터 전달
	// http://localhost:8000/blog/dummy/user/{id}
	@GetMapping("dummy/user/{id}")
	public User detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
			}
		});
		return user;
	}

	/*
	// http://localhost:8000/blog/dummy/user
	// @GetMapping("/dummy/user")
	public List<User> list() {
		return userRepository.findAll();
	}
	*/

	/*
	 // 한 페이지에 2건의 데이터를 리턴
	 // http://localhost:8000/blog/dummy/user/page
	 @GetMapping("/dummy/user/page")
	 public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
	 	List<User> users = userRepository.findAll(pageable).getContent();
	 	return users;
	 }
	 */
	
	// http://localhost:8000/blog/dummy/user/{id}
	@PutMapping("/dummy/user/{id}")
	@Transactional // save 하지 않아도 데이터 업데이트 가능
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("id: " + id);
		System.out.println("password: " + requestUser.getPassword());
		System.out.println("email: " + requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		return user;
	}
	
	// http://localhost:8000/blog/dummy/user/{id}
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			// 이거 오류가 안 잡히는뎅
			return "해당 유저는 없습니다. id: " + id;
		}
		return "삭제되었습니다. id: " + id;
	}
}
