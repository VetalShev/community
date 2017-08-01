package ru.vetalshev;

import ru.vetalshev.controller.impl.ArticleControllerImpl;
import ru.vetalshev.controller.impl.HomeControllerImpl;
import ru.vetalshev.controller.impl.UserControllerImpl;
import ru.vetalshev.view.ViewAndModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(
        urlPatterns = "/"
)
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

        ViewAndModel viewModel = null;

        if (matcher.find()) {
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);

            if (group1.startsWith("/articles")) {
                ArticleControllerImpl articleController = (ArticleControllerImpl) AppContext.getArticleController();
                if (group2 != null && group2.length() > 0) {
                    viewModel = articleController.renderArticle(Integer.parseInt(group2));
                } else {
                    viewModel = articleController.renderArticleList();
                }
            } else if (group1.startsWith("/users")) {
                UserControllerImpl userController = (UserControllerImpl) AppContext.getUserController();

                if (group2 != null && group2.length() > 0) {
                    viewModel = userController.renderUser(Integer.parseInt(group2));
                } else {
                    viewModel = userController.renderUserList();
                }
            } else {
                HomeControllerImpl homeController = (HomeControllerImpl) AppContext.getHomeController(); // or PageNotFound Controller
                viewModel = homeController.renderLastArticles();
            }
        } else {
            HomeControllerImpl homeController = (HomeControllerImpl) AppContext.getHomeController(); // or PageNotFound Controller
            viewModel = homeController.renderLastArticles();
        }

        resp.setContentType("text/html");

        // populate page model with data from Controller
        for (Map.Entry<String, Object> entry : viewModel.getModel().entrySet()) {
            req.setAttribute(entry.getKey(), entry.getValue());
        }

        RequestDispatcher appDispatcher = req.getRequestDispatcher(viewModel.getView().getName());
        appDispatcher.forward(req, resp);
    }

}
