package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog.model.RoleType;
import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록 (IoC)
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void signUP(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	@Transactional
	public void modify(User user) {
		// 영속성 컨텍스트에 User를 영속화한 후 영속화된 User를 수정
		// 수정 함수 종료 = 서비스 종료 = 트랜잭션 종료 = 자동 커밋
		User persistance = userRepository.findById(user.getId())
				.orElseThrow(()->{
					return new IllegalArgumentException("회원 찾기 실패 : 아이디를 찾을 수 없습니다.");
				});
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		persistance.setPassword(encPassword);
		persistance.setEmail(user.getEmail());
	}
	
}

/*
// SELECT를 시작할 때 트랜잭션 시작, 종료할 때 트랜잭션 종료 (정합성) 
@Transactional(readOnly = true)
public User logIn(User user) {
	return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
}
*/