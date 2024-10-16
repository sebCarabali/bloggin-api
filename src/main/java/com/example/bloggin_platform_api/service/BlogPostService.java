package com.example.bloggin_platform_api.service;

import com.example.bloggin_platform_api.dto.BlogPostRequestDTO;
import com.example.bloggin_platform_api.dto.BlogPostResponseDTO;

public interface BlogPostService {

    BlogPostResponseDTO create(BlogPostRequestDTO request);

    BlogPostResponseDTO update(Long id, BlogPostRequestDTO updateRequestDTO);

    void delete(Long id);
}
