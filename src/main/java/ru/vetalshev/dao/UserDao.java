package ru.vetalshev.dao;

import ru.vetalshev.model.Entity;

import java.util.List;

public interface UserDao<T extends Entity> extends Dao<T> {

    T findByEmail(String email);

    List<T> findByName(String name);

}
