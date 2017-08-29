package com.solwin.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwin.test.dao.IArticleDAO;
import com.solwin.test.entity.Article;

@Service
public class ArticleService implements IArticleService {
	@Autowired
	private IArticleDAO articleDAO;
	
	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return articleDAO.getAllArticles();
	}

	@Override
	public Article getArticleById(int articleId) {
		// TODO Auto-generated method stub
		return articleDAO.getArticleById(articleId);
	}

	@Override
	public boolean addArticle(Article article) {
		// TODO: Check for throw exceptions
		if (articleDAO.articleExists(article)) {
            return false;
        }
		
        articleDAO.addArticle(article);
        return true;
	}

	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}

	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}
}
