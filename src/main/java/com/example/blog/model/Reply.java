package com.example.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 시퀀스
	
	@Column(nullable = false, length = 200)
	private String content; // 내용
	
	@ManyToOne // Many = Reply, One = Board
	@JoinColumn(name = "boardId")
	private Board board; // 게시글
	
	@ManyToOne // Many = Reply, One = User
	@JoinColumn(name = "userId")
	private User user; // 작성자
	
	@CreationTimestamp
	private Timestamp createDate; // 생성날짜
}
