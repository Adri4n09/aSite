package com.example.asite.service;

import com.example.asite.model.Article;

import java.util.List;

public interface ArticleService {

    void updateArticle(Article article);

    void deleteArticle(Article article);

    List<Article> getAllArticles();

    Article getArticle(String articleId);
}
