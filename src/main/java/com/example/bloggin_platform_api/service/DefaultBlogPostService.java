package com.example.bloggin_platform_api.service;

import org.springframework.stereotype.Service;

import com.example.bloggin_platform_api.dto.BlogPostRequestDTO;
import com.example.bloggin_platform_api.dto.BlogPostResponseDTO;
import com.example.bloggin_platform_api.exception.BlogPostNotFoundException;
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

    @Override
    public BlogPostResponseDTO update(Long id, BlogPostRequestDTO updateRequestDTO) {
        BlogPost blog = blogPostRepository.findById(id).orElseThrow(() -> new BlogPostNotFoundException());
        blog.setTitle(updateRequestDTO.getTitle());
        blog.setContent(updateRequestDTO.getContent());
        blog.setCategory(updateRequestDTO.getCategory());
        blog.setTags(updateRequestDTO.getTags());
        blogPostRepository.save(blog);
        return blogPostMapper.mapToCreateResponse(blog);
    }

}
