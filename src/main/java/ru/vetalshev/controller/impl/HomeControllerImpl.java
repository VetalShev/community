package ru.vetalshev.controller.impl;

import ru.vetalshev.controller.AbstractController;
import ru.vetalshev.dao.ArticleDao;
import ru.vetalshev.core.Model;
import ru.vetalshev.core.ViewAndModel;
import ru.vetalshev.core.annotation.RequestMapping;
import ru.vetalshev.model.Article;
import ru.vetalshev.core.impl.ModelImpl;
import ru.vetalshev.core.impl.ViewAndModelImpl;

import java.util.List;

@RequestMapping("/")
public class HomeControllerImpl extends AbstractController {

    private ArticleDao<Article> articleDao;

    public HomeControllerImpl(ArticleDao<Article> articleDao) {
        super();
        this.articleDao = articleDao;
        System.out.println("CONSTRUCTOR HomeControllerImpl");
    }

    @RequestMapping("/")
    public ViewAndModel renderLastArticles() {
        List<Article> articles = articleDao.findLastAdded(3);

        Model model = new ModelImpl();
        model.addAttribute("articles", articles);

        return new ViewAndModelImpl("index", model);
    }

}
