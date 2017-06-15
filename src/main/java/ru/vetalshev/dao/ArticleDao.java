package ru.vetalshev.dao;

import ru.vetalshev.model.Entity;
import ru.vetalshev.model.User;

import java.util.Date;
import java.util.List;

public interface ArticleDao<T extends Entity> extends Dao<T> {

    public List<T> findByTitle(String title);

    public List<T> findByContent(String content);

    public List<T> findByAuthor(User author);

    public List<T> findByDate(Date date);

    public List<T> findLastAdded();

    public List<T> findLastAdded(int limit);

    //    public List<T> findRange(int start, int end);

}
