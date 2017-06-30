package ru.vetalshev.dao.impl;

import ru.vetalshev.dao.ArticleDao;
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

    private static final String FIND_ALL_ARTICLES_SQL = "SELECT article.id AS articleId, article.title AS articleTitle, article.creationDate AS articleCreationDate, article.text AS articleText, user.id AS authorId, user.name AS authorName, user.email AS authorEmail FROM article LEFT JOIN user ON article.authorId = user.id ORDER BY creationDate";
    private static final String FIND_LAST_ARTICLES_SQL = "SELECT article.id AS articleId, article.title AS articleTitle, article.creationDate AS articleCreationDate, article.text AS articleText, user.id AS authorId, user.name AS authorName, user.email AS authorEmail FROM article LEFT JOIN user ON article.authorId = user.id ORDER BY creationDate DESC";
    private static final String FIND_ARTICLE_BY_ID_SQL = "SELECT article.id AS articleId, article.title AS articleTitle, article.creationDate AS articleCreationDate, article.text AS articleText, user.id AS authorId, user.name AS authorName, user.email AS authorEmail FROM article INNER JOIN user ON article.id=? AND user.id=article.authorId";

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
        return findLastAdded(5);
    }

    @Override
    public List<Article> findLastAdded(int limit) {
        Connection connection = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Article> articles = new ArrayList<>();

        try {
            st = connection.prepareStatement(FIND_LAST_ARTICLES_SQL);
            st.setMaxRows(limit);

            rs = st.executeQuery();

            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("articleId"));
                article.setTitle(rs.getString("articleTitle"));
                article.setText(rs.getString("articleText"));
                article.setDate(rs.getDate("articleCreationDate"));

                User author = new User();
                author.setId(rs.getInt("authorId"));
                author.setName(rs.getString("authorName"));
                author.setEmail(rs.getString("authorEmail"));

                article.setAuthor(author);

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

        List<Article> articles = new ArrayList<>();

        try {
            st = connection.prepareStatement(FIND_ALL_ARTICLES_SQL);
            rs = st.executeQuery();

            while (rs.next()) {
                Article article = new Article();
                User author = new User();

                article.setId(rs.getInt("articleId"));
                article.setTitle(rs.getString("articleTitle"));
                article.setText(rs.getString("articleText"));
                article.setDate(rs.getDate("articleCreationDate"));

                author.setId(rs.getInt("authorId"));
                author.setName(rs.getString("authorName"));
                author.setEmail(rs.getString("authorEmail"));

                article.setAuthor(author);

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

        Article article = null;

        try {
            st = connection.prepareStatement(FIND_ARTICLE_BY_ID_SQL);
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                article = new Article();
                User author = new User();

                article.setId(rs.getInt("articleId"));
                article.setTitle(rs.getString("articleTitle"));
                article.setText(rs.getString("articleText"));
                article.setDate(rs.getDate("articleCreationDate"));

                author.setId(rs.getInt("authorId"));
                author.setName(rs.getString("authorName"));
                author.setEmail(rs.getString("authorEmail"));

                article.setAuthor(author);
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
