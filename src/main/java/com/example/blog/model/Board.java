package com.example.blog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 시퀀스
	
	@Column(nullable = false, length = 100)
	private String title; // 제목
	
	@Lob // 대용량 데이터
	private String content; // 내용
	
	@ColumnDefault("0")
	private int count; // 조회수
	
	@ManyToOne(fetch = FetchType.EAGER) // Many = Board, One = User, EAGER = 바로 Join!
	@JoinColumn(name = "userId")
	private User user; // 작성자
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // One = Board, Many = Reply, (LAZY) = 나중에 Join!
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate; // 생성날짜
}
