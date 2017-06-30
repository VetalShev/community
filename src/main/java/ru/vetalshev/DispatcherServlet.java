package ru.vetalshev;

import ru.vetalshev.controller.impl.ArticleControllerImpl;
import ru.vetalshev.controller.impl.HomeControllerImpl;
import ru.vetalshev.controller.impl.UserControllerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@WebServlet(
//        urlPatterns = "/"
//)
public class DispatcherServlet extends HttpServlet {

    public DispatcherServlet() {
        System.out.println("CONSTRUCTOR DispatcherServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DO_GET");

        String URL_PATTERN = "^(/articles|/users)(?:/([\\d]*))?$";
        String contextPath = req.getContextPath();
        String uri = req.getRequestURI();
        String uriFreeContextPath = uri.substring(contextPath.length());

        Pattern pattern = Pattern.compile(URL_PATTERN);
        Matcher matcher = pattern.matcher(uriFreeContextPath);

        String view = null;

        if (matcher.find()) {
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);

            if (group1.startsWith("/articles")) {
                ArticleControllerImpl articleController = new ArticleControllerImpl(req, resp);
                if (group2 != null && group2.length() > 0) {
                    view = articleController.renderArticle(Integer.parseInt(group2));
                } else {
                    view = articleController.renderArticleList();
                }
            } else if (group1.startsWith("/users")) {
                UserControllerImpl userController = new UserControllerImpl(req, resp);

                if (group2 != null && group2.length() > 0) {
                    view = userController.renderUser(Integer.parseInt(group2));
                } else {
                    view = userController.renderUserList();
                }
            } else {
                HomeControllerImpl homeController = new HomeControllerImpl(req, resp); // or PageNotFound Controller
                view = homeController.renderLastArticles();
            }
        } else {
            HomeControllerImpl homeController = new HomeControllerImpl(req, resp); // or PageNotFound Controller
            view = homeController.renderLastArticles();
        }

        resp.setContentType("text/html");

        RequestDispatcher appDispatcher = req.getRequestDispatcher(view);
        appDispatcher.forward(req, resp);
    }

}
