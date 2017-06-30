package ru.vetalshev.dao;

import ru.vetalshev.model.Entity;

import java.util.List;

public interface Dao<T extends Entity> {

    List<T> findAll();

    T findById(int id);

    boolean delete(int id);

    boolean create(T entity);

    T update(T entity);

}
