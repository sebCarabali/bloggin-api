package com.example.bloggin_platform_api.filter;

import org.springframework.data.jpa.domain.Specification;

import com.example.bloggin_platform_api.model.BlogPost;

public class BlogPostSpecification {

    public static Specification<BlogPost> hasTitle(String term) {
        return (root, cq, cb) -> cb.like(root.get("title"), term);
    }

    public static Specification<BlogPost> hasContent(String term) {
        return (root, cq, cb) -> cb.like(root.get("content"), term);
    }

    public static Specification<BlogPost> hasCategory(String term) {
        return (root, cq, cb) -> cb.like(root.get("category"), term);
    }
}
