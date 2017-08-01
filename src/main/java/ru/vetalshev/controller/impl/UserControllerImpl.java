package ru.vetalshev.controller.impl;

import ru.vetalshev.AppContext;
import ru.vetalshev.controller.AbstractController;
import ru.vetalshev.dao.UserDao;
import ru.vetalshev.model.User;
import ru.vetalshev.view.Model;
import ru.vetalshev.view.View;
import ru.vetalshev.view.ViewAndModel;

import java.util.List;

public class UserControllerImpl extends AbstractController {

    public UserControllerImpl() {
        super();
        System.out.println("CONSTRUCTOR UserControllerImpl");
    }

    public ViewAndModel renderUser(int userId) {
        UserDao<User> userDao = AppContext.getUserDao();
        User user = userDao.findById(userId);

        View view = new View("user");
        Model model = new Model();

        model.put("user", user);

        return new ViewAndModel(view, model);
    }

    public ViewAndModel renderUserList() {
        UserDao<User> userDao = AppContext.getUserDao();
        List<User> users = userDao.findAll();

        View view = new View("users");
        Model model = new Model();

        model.put("users", users);

        return new ViewAndModel(view, model);
    }

}
