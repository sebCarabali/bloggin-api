package com.example.bloggin_platform_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.util.Set;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostResponseDTO implements Serializable{

    private Long id;
    private String title;
    private String content;
    private String category;
    private Set<String> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
