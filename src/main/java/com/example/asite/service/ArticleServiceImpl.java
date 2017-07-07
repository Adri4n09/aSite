package com.example.asite.service;

import com.example.asite.model.Article;
import com.example.asite.repository.ArticleRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void updateArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return IteratorUtils.toList(articleRepository.findAll().iterator());
    }

    @Override
    public Article getArticle(String articleId) {
        return articleRepository.findOne(articleId);
    }
}
