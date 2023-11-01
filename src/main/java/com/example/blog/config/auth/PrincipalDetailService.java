package com.example.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	// password는 스프링이 처리
	// username 처리 함수 작성
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : " + username);
				});
		// 시큐리티 세션에 유저 정보 저장
		return new PrincipalDetail(principal);
	}
	
}
