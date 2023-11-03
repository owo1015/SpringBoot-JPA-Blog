package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{

}
