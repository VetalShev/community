package ru.vetalshev.controller;

import ru.vetalshev.AppContext;
import ru.vetalshev.dao.ArticleDao;
import ru.vetalshev.model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/articles")
public class ArticlesController extends HttpServlet {

    public ArticlesController() {
        System.out.println("CONSTRUCTOR ArticlesController");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArticleDao<Article> articleDao = AppContext.getArticleDao();
        List<Article> articles = articleDao.findAll();

        response.setContentType("text/html");
        request.setAttribute("articles", articles);
        request.getRequestDispatcher("/articles.jsp").forward(request, response);

    }
}
