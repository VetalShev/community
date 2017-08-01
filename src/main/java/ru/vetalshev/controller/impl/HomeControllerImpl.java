package ru.vetalshev.controller.impl;

import ru.vetalshev.AppContext;
import ru.vetalshev.controller.AbstractController;
import ru.vetalshev.dao.ArticleDao;
import ru.vetalshev.model.Article;
import ru.vetalshev.view.Model;
import ru.vetalshev.view.View;
import ru.vetalshev.view.ViewAndModel;

import java.util.List;

public class HomeControllerImpl extends AbstractController {

    public HomeControllerImpl() {
        super();
        System.out.println("CONSTRUCTOR HomeControllerImpl");
    }

    public ViewAndModel renderLastArticles() {
        ArticleDao articleDao = AppContext.getArticleDao();
        List<Article> articles = articleDao.findLastAdded(3);

        View view = new View("index");
        Model model = new Model();

        model.put("articles", articles);

        return new ViewAndModel(view, model);
    }

}
