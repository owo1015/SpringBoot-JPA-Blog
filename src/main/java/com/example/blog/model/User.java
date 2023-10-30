package com.example.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @DynamicInsert // null 필드를 제외하고 데이터 insert
@Entity // MySQL에 자동으로 User 테이블 생성
public class User {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터베이스의 넘버링 전략, Oracle = sequence, MySql = auto_increment
	private int id; // 시퀀스
	
	@Column(nullable = false, length = 30, unique = true)
	private String username; // 아이디
	
	@Column(nullable = false, length = 100)
	private String password; // 비밀번호
	
	@Column(nullable = false, length = 50)
	private String email; // 이메일

	// @ColumnDefault("user")
	@Enumerated(EnumType.STRING) // DB에 Enum이 String 타입임을 알림
	private RoleType role;
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate; // 생성날짜
}