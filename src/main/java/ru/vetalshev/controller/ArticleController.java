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

@WebServlet(
        urlPatterns = "/articles/*"
)
public class ArticleController extends HttpServlet {

    public ArticleController() {
        System.out.println("CONSTRUCTOR ArticleController");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int articleId = getArticleId(request);

        ArticleDao<Article> articleDao = AppContext.getArticleDao();
        Article article = articleDao.findById(articleId);

        response.setContentType("text/html");

        request.setAttribute("article", article);
        request.getRequestDispatcher("/article.jsp").forward(request, response);

    }

    private int getArticleId(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        String[] parts = url.split("/");

        return Integer.parseInt(parts[parts.length - 1]);
    }
}
