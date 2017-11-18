package ru.vetalshev.controller.impl;

import ru.vetalshev.AppContext;
import ru.vetalshev.controller.AbstractController;
import ru.vetalshev.dao.UserDao;
import ru.vetalshev.core.Model;
import ru.vetalshev.core.ViewAndModel;
import ru.vetalshev.core.annotation.RequestMapping;
import ru.vetalshev.model.User;
import ru.vetalshev.core.impl.ModelImpl;
import ru.vetalshev.core.impl.ViewAndModelImpl;

import java.util.List;

@RequestMapping("/users")
public class UserControllerImpl extends AbstractController {

    private UserDao<User> userDao;

    public UserControllerImpl(UserDao<User> userDao) {
        super();
        this.userDao = userDao;
        System.out.println("CONSTRUCTOR UserControllerImpl");
    }

    @RequestMapping("/{userId}")
    public ViewAndModel renderUser(int userId) {
        User user = userDao.findById(userId);

        Model model = new ModelImpl();
        model.addAttribute("user", user);

        return new ViewAndModelImpl("user", model);
    }

    @RequestMapping("/")
    public ViewAndModel renderUserList() {
        UserDao<User> userDao = AppContext.getUserDao();
        List<User> users = userDao.findAll();

        Model model = new ModelImpl();
        model.addAttribute("users", users);

        return new ViewAndModelImpl("users", model);
    }

}
