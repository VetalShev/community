package ru.vetalshev;

import ru.vetalshev.dao.ArticleDao;
import ru.vetalshev.dao.ArticleDaoImpl;
import ru.vetalshev.dao.UserDao;
import ru.vetalshev.dao.UserDaoImpl;
import ru.vetalshev.model.Article;
import ru.vetalshev.model.User;

import javax.sql.DataSource;

public class AppContext {

    // constructor as 'private' to prevent creating an instance of AppContext
    private AppContext() {
    }

    private static class DataSourceHolder {
        public static final DataSource dataSource = ru.vetalshev.DataSourceHolder.getInstance().getDataSource();
    }

    private static class ArticleDaoHolder {
        public static final ArticleDao<Article> articleDao = new ArticleDaoImpl();
    }

    private static class UserDaoHolder {
        public static final UserDao<User> userDao = new UserDaoImpl();
    }





    public static DataSource getDataSource() {
        return DataSourceHolder.dataSource;
    }

    public static ArticleDao<Article> getArticleDao() {
        return ArticleDaoHolder.articleDao;
    }

    public static UserDao<User> getUserDao() {
        return UserDaoHolder.userDao;
    }

}
