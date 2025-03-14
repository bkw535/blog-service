package com.example.blog_service.dto;

import com.example.blog_service.domain.Article;
import lombok.Data;

@Data
public class ArticleListViewResponse {

    private Long id;
    private String title;
    private String content;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
