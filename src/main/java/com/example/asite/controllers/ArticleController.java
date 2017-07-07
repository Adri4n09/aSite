package com.example.asite.controllers;


import com.example.asite.model.Article;
import com.example.asite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ResponseEntity addArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/getArticles", method = RequestMethod.GET)
    public ResponseEntity<List<Article>> getArticles() {
        return new ResponseEntity<>(articleService.getAllArticles(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addRandomArticle", method = RequestMethod.POST)
    public ResponseEntity addRandomArticle() {
        Article article = new Article();
        article.setId(UUID.randomUUID().toString().substring(0,10));
        article.setUsername(UUID.randomUUID().toString().substring(0,10));
        article.setTitle(UUID.randomUUID().toString().substring(0,10));
        article.setContent(UUID.randomUUID().toString().substring(0,10));
        articleService.updateArticle(article);
        return new ResponseEntity(HttpStatus.OK);

    }
}
