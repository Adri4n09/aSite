package com.example.asite.repository;

import com.example.asite.model.Article;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CouchbaseRepository<Article, String> {

}
