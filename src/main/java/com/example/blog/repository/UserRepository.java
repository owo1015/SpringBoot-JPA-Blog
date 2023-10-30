package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.model.User;

// DAO (Data Access Object)
// @Repository (생략 가능)
public interface UserRepository extends JpaRepository<User, Integer>{
	
	// JPA Naming 쿼리
	// SELECT * FROM user WHERE username = ? AND password = ?;
	User findByUsernameAndPassword(String username, String password);
	
	/*
	@Query(value="SELECT * FROM user WHERE username = ? AND password = ?", nativeQuery = true)
	User login(String username, String password);
	*/
}
