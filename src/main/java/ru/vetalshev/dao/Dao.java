package ru.vetalshev.dao;

import ru.vetalshev.model.Entity;

import java.util.List;

public interface Dao<T extends Entity> {

    public List<T> findAll();

    public T findById(int id);

    public boolean delete(int id);

    public boolean create(T entity);

    public T update(T entity);

}
