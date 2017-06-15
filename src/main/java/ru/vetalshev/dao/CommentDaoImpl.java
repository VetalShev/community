package ru.vetalshev.dao;

import ru.vetalshev.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CommentDaoImpl extends AbstractDao<User> implements CommentDao<User> {

    public CommentDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}
