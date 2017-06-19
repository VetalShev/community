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

@WebServlet("/")
public class HomeController extends HttpServlet {

    public HomeController() {
        System.out.println("CONSTRUCTOR HomeController");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArticleDao articleDao = AppContext.getArticleDao();
        List<Article> articles = articleDao.findLastAdded(5);

        response.setContentType("text/html");
        request.setAttribute("articles", articles);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
