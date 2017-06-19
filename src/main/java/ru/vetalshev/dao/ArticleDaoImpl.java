package ru.vetalshev.dao;

import ru.vetalshev.model.Article;
import ru.vetalshev.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleDaoImpl extends AbstractDao<Article> implements ArticleDao<Article> {

    public ArticleDaoImpl() {
        System.out.println("CONSTRUCTOR ArticleDao");
    }

    @Override
    public List<Article> findByTitle(String title) {
        Connection connection = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        String FIND_BY_ID_SQL = "SELECT id, authorId, title, text, creationDate FROM article WHERE title LIKE ?";
        List<Article> articles = new ArrayList<>();

        try {
            st = connection.prepareStatement(FIND_BY_ID_SQL);
            st.setString(1, ('%' + title + '%'));
            rs = st.executeQuery();

            while (rs.next()) {
                Article article = new Article();

                article.setId(rs.getInt("id"));
                article.setId(rs.getInt("authorId"));
                article.setTitle(rs.getString("title"));
                article.setText(rs.getString("text"));
                article.setDate(rs.getDate("creationDate"));
            }

            return articles;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
            closeConnection(connection);
        }

        return articles;
    }

    @Override
    public List<Article> findByContent(String name) {
        return null;
    }

    @Override
    public List<Article> findByAuthor(User author) {
        return null;
    }

    @Override
    public List<Article> findByDate(Date date) {
        return null;
    }

    @Override
    public List<Article> findLastAdded() {
        Connection connection = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        String FIND_ALL_SQL = "SELECT id, authorId, title, text, creationDate FROM article ORDER BY creationDate DESC LIMIT 5";
        List<Article> articles = new ArrayList<>();

        try {
            st = connection.prepareStatement(FIND_ALL_SQL);
            rs = st.executeQuery();

            while (rs.next()) {
                Article article = new Article();

                article.setId(rs.getInt("id"));
                article.setId(rs.getInt("authorId"));
                article.setTitle(rs.getString("title"));
                article.setText(rs.getString("text"));
                article.setDate(rs.getDate("creationDate"));

                articles.add(article);
            }

            return articles;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
            closeConnection(connection);
        }

        return articles;
    }

    @Override
    public List<Article> findLastAdded(int limit) {
        Connection connection = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        String FIND_ALL_SQL = "SELECT id, authorId, title, text, creationDate FROM article ORDER BY creationDate DESC LIMIT " + limit;
        List<Article> articles = new ArrayList<>();

        try {
            st = connection.prepareStatement(FIND_ALL_SQL);
//            st.setMaxRows(); // TODO limit
            rs = st.executeQuery();

            while (rs.next()) {
                Article article = new Article();

                article.setId(rs.getInt("id"));
                article.setId(rs.getInt("authorId"));
                article.setTitle(rs.getString("title"));
                article.setText(rs.getString("text"));
                article.setDate(rs.getDate("creationDate"));

                articles.add(article);
            }

            return articles;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
            closeConnection(connection);
        }

        return articles;
    }

    @Override
    public List<Article> findAll() {
        Connection connection = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        String FIND_ALL_SQL = "SELECT id, authorId, title, text, creationDate FROM article";
        List<Article> articles = new ArrayList<>();

        try {
            st = connection.prepareStatement(FIND_ALL_SQL);
            rs = st.executeQuery();

            while (rs.next()) {
                Article article = new Article();

                article.setId(rs.getInt("id"));
                article.setId(rs.getInt("authorId"));
                article.setTitle(rs.getString("title"));
                article.setText(rs.getString("text"));
                article.setDate(rs.getDate("creationDate"));

                articles.add(article);
            }

            return articles;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
            closeConnection(connection);
        }

        return articles;
    }

    @Override
    public Article findById(int id) {
        Connection connection = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        String FIND_BY_ID_SQL = "SELECT id, authorId, title, text, creationDate FROM article WHERE id=?";
        Article article = null;

        try {
            st = connection.prepareStatement(FIND_BY_ID_SQL);
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                article = new Article();

                article.setId(rs.getInt("id"));
                article.setId(rs.getInt("authorId"));
                article.setTitle(rs.getString("title"));
                article.setText(rs.getString("text"));
                article.setDate(rs.getDate("creationDate"));
            }

            return article;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
            closeConnection(connection);
        }

        return article;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean create(Article entity) {
        return false;
    }

    @Override
    public Article update(Article entity) {
        return null;
    }
}
