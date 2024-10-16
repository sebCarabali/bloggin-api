package com.example.bloggin_platform_api.mapper;

import org.springframework.stereotype.Component;

import com.example.bloggin_platform_api.dto.BlogPostRequestDTO;
import com.example.bloggin_platform_api.dto.BlogPostResponseDTO;
import com.example.bloggin_platform_api.model.BlogPost;

@Component
public class BlogPostMapper {

    public BlogPost mapFromCreateRequest(BlogPostRequestDTO request) {
        return BlogPost.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .category(request.getCategory())
                .tags(request.getTags())
                .build();
    }

    public BlogPostResponseDTO mapToCreateResponse(BlogPost post) {
        return BlogPostResponseDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .category(post.getCategory())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .tags(post.getTags())
                .build();
    }

}
