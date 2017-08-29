package com.solwin.test.dao;

import java.util.List;

import com.solwin.test.entity.Article;

public interface IArticleDAO {
    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
    boolean articleExists(Article article);
}
