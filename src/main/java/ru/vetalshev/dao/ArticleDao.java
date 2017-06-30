package ru.vetalshev.dao;

import ru.vetalshev.model.Entity;
import ru.vetalshev.model.User;

import java.util.Date;
import java.util.List;

public interface ArticleDao<T extends Entity> extends Dao<T> {

    List<T> findByTitle(String title);

    List<T> findByContent(String content);

    List<T> findByAuthor(User author);

    List<T> findByDate(Date date);

    List<T> findLastAdded();

    List<T> findLastAdded(int limit);

//    List<T> findRange(int start, int end);

}
