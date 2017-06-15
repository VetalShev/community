package ru.vetalshev.controller;

import ru.vetalshev.DataSourceHolder;
import ru.vetalshev.dao.UserDaoImpl;
import ru.vetalshev.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/users")
public class UsersController extends HttpServlet {

    public UsersController() {
        System.out.println("CONSTRUCTOR UsersController");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        DataSource ds = DataSourceHolder.getInstance().getDataSource();

        try {
            connection = ds.getConnection();

            connection.setAutoCommit(false); //TODO объединение нескольких запросов в одну транзакцию

            UserDaoImpl userDao = new UserDaoImpl(connection);
            List<User> users = userDao.findAll();

            connection.commit(); // TODO

            response.setContentType("text/html");
            request.setAttribute("users", users);
            request.getRequestDispatcher("/users.jsp").forward(request, response);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
