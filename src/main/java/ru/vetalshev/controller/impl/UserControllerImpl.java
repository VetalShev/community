package ru.vetalshev.controller.impl;

import ru.vetalshev.AppContext;
import ru.vetalshev.controller.AbstractController;
import ru.vetalshev.dao.UserDao;
import ru.vetalshev.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserControllerImpl extends AbstractController {

    public UserControllerImpl(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        System.out.println("CONSTRUCTOR UserControllerImpl");
    }

    public String renderUser(int userId) {
        HttpServletRequest request = getRequest();
        UserDao<User> userDao = AppContext.getUserDao();
        User user = userDao.findById(userId);

        request.setAttribute("user", user);

        return "/user.jsp";
    }

    public String renderUserList() {
        HttpServletRequest request = getRequest();
        UserDao<User> userDao = AppContext.getUserDao();
        List<User> users = userDao.findAll();

        request.setAttribute("users", users);

        return "/users.jsp";
    }

}
