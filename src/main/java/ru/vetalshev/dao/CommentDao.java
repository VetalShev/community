package ru.vetalshev.dao;

import ru.vetalshev.model.Entity;

import java.util.List;

public interface CommentDao<T extends Entity> extends Dao<T> {

    List<T> findAll(int articleId);

}
