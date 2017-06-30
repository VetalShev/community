package ru.vetalshev.controller.impl;

import ru.vetalshev.AppContext;
import ru.vetalshev.controller.AbstractController;
import ru.vetalshev.dao.ArticleDao;
import ru.vetalshev.model.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HomeControllerImpl extends AbstractController {

    public HomeControllerImpl(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        System.out.println("CONSTRUCTOR HomeControllerImpl");
    }

    public String renderLastArticles() {
        HttpServletRequest request = getRequest();

        ArticleDao articleDao = AppContext.getArticleDao();
        List<Article> articles = articleDao.findLastAdded(3);

        request.setAttribute("articles", articles);


        return "/index.jsp";
    }

}
