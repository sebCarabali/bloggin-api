package com.example.bloggin_platform_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bloggin_platform_api.model.BlogPost;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long>{

}
