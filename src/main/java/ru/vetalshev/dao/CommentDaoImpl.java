package ru.vetalshev.dao;

import ru.vetalshev.model.User;

import java.util.List;

public class CommentDaoImpl extends AbstractDao<User> implements CommentDao<User> {

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
