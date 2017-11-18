package ru.vetalshev.controller.impl;

import ru.vetalshev.AppContext;
import ru.vetalshev.controller.AbstractController;
import ru.vetalshev.dao.ArticleDao;
import ru.vetalshev.dao.CommentDao;
import ru.vetalshev.core.Model;
import ru.vetalshev.core.ViewAndModel;
import ru.vetalshev.core.annotation.RequestMapping;
import ru.vetalshev.model.Article;
import ru.vetalshev.model.Comment;
import ru.vetalshev.core.impl.ModelImpl;
import ru.vetalshev.core.impl.ViewAndModelImpl;

import java.util.List;

@RequestMapping("/articles")
public class ArticleControllerImpl extends AbstractController {

    ArticleDao<Article> articleDao;
    CommentDao<Comment> commentDao;

    public ArticleControllerImpl(ArticleDao<Article> articleDao, CommentDao<Comment> commentDao) {
        super();
        this.articleDao = articleDao;
        this.commentDao = commentDao;
        System.out.println("CONSTRUCTOR ArticleControllerImpl");
    }

    @RequestMapping("/{articleId}")
    public ViewAndModel renderArticle(int articleId) {
        Article article = articleDao.findById(articleId);
        List<Comment> comments = commentDao.findAll(articleId);

        article.setComments(comments);

        Model model = new ModelImpl();
        model.addAttribute("article", article);

        return new ViewAndModelImpl("article", model);
    }

    @RequestMapping("/")
    public ViewAndModel renderArticleList() {
        List<Article> articles = articleDao.findAll();

        Model model = new ModelImpl();
        model.addAttribute("articles", articles);

        return new ViewAndModelImpl("articles", model);
    }

}