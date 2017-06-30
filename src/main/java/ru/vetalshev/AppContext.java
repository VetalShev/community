package ru.vetalshev;

import ru.vetalshev.dao.*;
import ru.vetalshev.dao.impl.ArticleDaoImpl;
import ru.vetalshev.dao.impl.CommentDaoImpl;
import ru.vetalshev.dao.impl.UserDaoImpl;
import ru.vetalshev.model.Article;
import ru.vetalshev.model.Comment;
import ru.vetalshev.model.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AppContext {

    // constructor as 'private' to prevent creating an instance of AppContext
    private AppContext() {
    }

    private static class DataSourceHolder {
        public static DataSource dataSource;
        static {
            try {
                Context ctx = new InitialContext();
                dataSource = (DataSource) ctx.lookup("java:comp/env/community");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ArticleDaoHolder {
        public static final ArticleDao<Article> articleDao = new ArticleDaoImpl();
    }

    private static class UserDaoHolder {
        public static final UserDao<User> userDao = new UserDaoImpl();
    }

    private static class CommentDaoHolder {
        public static final CommentDao<Comment> commentDao = new CommentDaoImpl();
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

    public static CommentDao<Comment> getCommentDao() {
        return CommentDaoHolder.commentDao;
    }

}
