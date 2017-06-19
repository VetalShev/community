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
import java.util.List;

@WebServlet("/users")
public class UsersController extends HttpServlet {

    public UsersController() {
        System.out.println("CONSTRUCTOR UsersController");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDao<User> userDao = AppContext.getUserDao();
        List<User> users = userDao.findAll();

        response.setContentType("text/html");
        request.setAttribute("users", users);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}
