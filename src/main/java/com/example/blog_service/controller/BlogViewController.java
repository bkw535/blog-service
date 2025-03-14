package com.example.blog_service.controller;

import com.example.blog_service.dto.ArticleListViewResponse;
import com.example.blog_service.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);
        System.out.println("📌 가져온 데이터: " + articles);
        return "articleList";
    }

    @GetMapping("/test-template")
    public String testTemplate() {
        return "articleList"; // 템플릿 파일 로드 테스트
    }
}
