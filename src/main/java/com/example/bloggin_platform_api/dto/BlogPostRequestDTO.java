package com.example.bloggin_platform_api.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Data
@ToString
public class BlogPostRequestDTO implements Serializable {

    @NotEmpty(message = "Title cannot be empty")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    @NotEmpty(message = "Content cannot be empty")
    @Size(min = 10, message = "Content must have at least 10 characters")
    private String content;

    @NotEmpty(message = "Category cannot be empty")
    @Size(max = 50, message = "Category must not exceed 50 characters")
    private String category;

    private Set<@Size(max = 30, message = "Each tag must not exceed 30 characters") String> tags;
}
