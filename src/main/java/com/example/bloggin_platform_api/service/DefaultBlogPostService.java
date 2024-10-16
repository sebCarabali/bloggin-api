package com.example.bloggin_platform_api.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.bloggin_platform_api.dto.BlogPostRequestDTO;
import com.example.bloggin_platform_api.dto.BlogPostResponseDTO;
import com.example.bloggin_platform_api.exception.BlogPostNotFoundException;
import com.example.bloggin_platform_api.filter.BlogPostSpecification;
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

    @Override
    public void delete(Long id) {
        BlogPost blog = blogPostRepository.findById(id).orElseThrow(() -> new BlogPostNotFoundException());
        blogPostRepository.delete(blog);
    }

    @Override
    public BlogPostResponseDTO findById(Long id) {
        return blogPostMapper.mapToCreateResponse(
                blogPostRepository.findById(id).orElseThrow(() -> new BlogPostNotFoundException()));
    }

    @Override
    public List<BlogPostResponseDTO> search(String term) {
        if (term != null && !term.isEmpty()) {
            term = "%" + term + "%";
            Specification<BlogPost> spec = Specification.where(BlogPostSpecification.hasTitle(term))
                    .or(BlogPostSpecification.hasContent(term)).or(BlogPostSpecification.hasCategory(term));
            return blogPostRepository.findAll(spec).stream().map(blogPostMapper::mapToCreateResponse).toList();
        }
        return blogPostRepository.findAll().stream().map(blogPostMapper::mapToCreateResponse).toList();
    }

}
