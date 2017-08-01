package ru.vetalshev.controller.impl;

import ru.vetalshev.AppContext;
import ru.vetalshev.controller.AbstractController;
import ru.vetalshev.dao.ArticleDao;
import ru.vetalshev.dao.CommentDao;
import ru.vetalshev.model.Article;
import ru.vetalshev.model.Comment;
import ru.vetalshev.view.Model;
import ru.vetalshev.view.View;
import ru.vetalshev.view.ViewAndModel;

import java.util.List;

public class ArticleControllerImpl extends AbstractController {

    public ArticleControllerImpl() {
        super();
        System.out.println("CONSTRUCTOR ArticleControllerImpl");
    }

    public ViewAndModel renderArticle(int articleId) {
        ArticleDao<Article> articleDao = AppContext.getArticleDao();
        Article article = articleDao.findById(articleId);

        CommentDao<Comment> commentDao = AppContext.getCommentDao();
        List<Comment> comments = commentDao.findAll(articleId);

        article.setComments(comments);

        View view = new View("article");
        Model model = new Model();

        model.put("article", article);

        return new ViewAndModel(view, model);
    }

    public ViewAndModel renderArticleList() {
        ArticleDao<Article> articleDao = AppContext.getArticleDao();
        List<Article> articles = articleDao.findAll();

        View view = new View("articles");
        Model model = new Model();

        model.put("articles", articles);

        return new ViewAndModel(view, model);
    }

}