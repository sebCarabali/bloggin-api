package com.example.bloggin_platform_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bloggin_platform_api.dto.BlogPostRequestDTO;
import com.example.bloggin_platform_api.dto.BlogPostResponseDTO;
import com.example.bloggin_platform_api.service.BlogPostService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/post")
@Slf4j
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping
    public ResponseEntity<BlogPostResponseDTO> create(
            @Valid @RequestBody BlogPostRequestDTO createPostRequest) {
        return new ResponseEntity<>(blogPostService.create(createPostRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPostResponseDTO> update(@PathVariable("id") Long id,
            @Valid @RequestBody BlogPostRequestDTO updateRequestDTO) {
        return new ResponseEntity<>(blogPostService.update(id, updateRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        blogPostService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPostResponseDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(blogPostService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BlogPostResponseDTO>> getMethodName(
            @RequestParam(name = "term", required = false) String term) {
        log.info("Search blogs with term: {}", term);
        return ResponseEntity.ok(blogPostService.search(term));
    }

}
