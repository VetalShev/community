package ru.vetalshev.controller;

import ru.vetalshev.AppContext;
import ru.vetalshev.dao.UserDao;
import ru.vetalshev.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = "/users/*"
)
public class UserController extends HttpServlet {

    public UserController() {
        System.out.println("CONSTRUCTOR UserController");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("getContextPath: " + request.getContextPath());

        int userId = getUserId(request);

        UserDao<User> userDao = AppContext.getUserDao();
        User user = userDao.findById(userId);

        response.setContentType("text/html");
        request.setAttribute("user", user);
        request.getRequestDispatcher("/user.jsp").forward(request, response);
    }

    private int getUserId(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        String[] parts = url.split("/");

        return Integer.parseInt(parts[parts.length - 1]);
    }
}
