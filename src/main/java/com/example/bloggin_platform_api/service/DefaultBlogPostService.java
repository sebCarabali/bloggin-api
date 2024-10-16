package com.example.bloggin_platform_api.service;

import org.springframework.stereotype.Service;

import com.example.bloggin_platform_api.dto.BlogPostRequestDTO;
import com.example.bloggin_platform_api.dto.BlogPostResponseDTO;
import com.example.bloggin_platform_api.mapper.BlogPostMapper;
import com.example.bloggin_platform_api.model.BlogPost;
import com.example.bloggin_platform_api.repository.BlogPostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultBlogPostService implements BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final BlogPostMapper blogPostMapper;

    @Override
    public BlogPostResponseDTO create(BlogPostRequestDTO request) {
        BlogPost post = blogPostMapper.mapFromCreateRequest(request);
        post = blogPostRepository.save(post);
        return blogPostMapper.mapToCreateResponse(post);
    }

}
