package ru.vetalshev.controller.impl;

import ru.vetalshev.AppContext;
import ru.vetalshev.controller.AbstractController;
import ru.vetalshev.dao.ArticleDao;
import ru.vetalshev.dao.CommentDao;
import ru.vetalshev.model.Article;
import ru.vetalshev.model.Comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ArticleControllerImpl extends AbstractController {

    public ArticleControllerImpl(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        System.out.println("CONSTRUCTOR ArticleControllerImpl");
    }

    public String renderArticle(int articleId) {
        HttpServletRequest request = getRequest();

        ArticleDao<Article> articleDao = AppContext.getArticleDao();
        Article article = articleDao.findById(articleId);

        CommentDao<Comment> commentDao = AppContext.getCommentDao();
        List<Comment> comments = commentDao.findAll(articleId);

        article.setComments(comments);

        request.setAttribute("article", article);

        return "/article.jsp";
    }

    public String renderArticleList() {
        HttpServletRequest request = getRequest();
        ArticleDao<Article> articleDao = AppContext.getArticleDao();
        List<Article> articles = articleDao.findAll();

        request.setAttribute("articles", articles);

        return "/articles.jsp";
    }

}