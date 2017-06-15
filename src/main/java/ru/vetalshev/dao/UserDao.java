package ru.vetalshev.dao;

import ru.vetalshev.model.Entity;
import ru.vetalshev.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao<T extends Entity> extends Dao<T> {

    public T findByEmail(String email);

    public List<T> findByName(String name);

}
