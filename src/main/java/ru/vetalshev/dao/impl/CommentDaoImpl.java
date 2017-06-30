package ru.vetalshev.dao.impl;

import ru.vetalshev.dao.CommentDao;
import ru.vetalshev.model.Comment;
import ru.vetalshev.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl extends AbstractDao<Comment> implements CommentDao<Comment> {

    private final static String FIND_All_COMMENTS_SQL = "SELECT comment.id AS commentId, comment.text AS commentText, comment.date AS commentDate, user.name AS commentAuthorName, user.id AS commentAuthorId, user.email AS commentAuthorEmail FROM comment INNER JOIN user ON user.id=comment.authorId";
    private final static String FIND_COMMENTS_BY_ARTICLE_SQL = "SELECT comment.id AS commentId, comment.text AS commentText, comment.date AS commentDate, user.name AS commentAuthorName, user.id AS commentAuthorId, user.email AS commentAuthorEmail FROM comment INNER JOIN user ON comment.articleId=? AND user.id=comment.authorId";
    private final static String FIND_COMMENT_BY_ID_SQL = "";

    @Override
    public List<Comment> findAll() {
        Connection connection = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Comment> comments = new ArrayList<>();

        try {
            st = connection.prepareStatement(FIND_All_COMMENTS_SQL);
            rs = st.executeQuery();

            while (rs.next()) {
                Comment comment = new Comment();
                User user = new User();

                comment.setId(rs.getInt("commentId"));
                comment.setText(rs.getString("commentText"));
                comment.setDate(rs.getDate("commentDate"));

                user.setId(rs.getInt("commentAuthorId"));
                user.setName(rs.getString("commentAuthorName"));
                user.setEmail(rs.getString("commentAuthorEmail"));

                comment.setAuthor(user);

                comments.add(comment);
            }

            return comments;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
            closeConnection(connection);
        }

        return comments;
    }

    @Override
    public List<Comment> findAll(int articleId) {
        Connection connection = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Comment> comments = new ArrayList<>();

        try {
            st = connection.prepareStatement(FIND_COMMENTS_BY_ARTICLE_SQL);
            st.setInt(1, articleId);

            rs = st.executeQuery();

            while (rs.next()) {
                Comment comment = new Comment();
                User user = new User();

                comment.setId(rs.getInt("commentId"));
                comment.setText(rs.getString("commentText"));
                comment.setDate(rs.getDate("commentDate"));

                user.setId(rs.getInt("commentAuthorId"));
                user.setName(rs.getString("commentAuthorName"));
                user.setEmail(rs.getString("commentAuthorEmail"));

                comment.setAuthor(user);

                comments.add(comment);
            }

            return comments;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
            closeConnection(connection);
        }

        return comments;
    }

    @Override
    public Comment findById(int id) {
//        Connection connection = getConnection();
//        PreparedStatement st = null;
//        ResultSet rs = null;
//
//        Article article = null;
//
//        try {
//            st = connection.prepareStatement(FIND_COMMENT_BY_ID_SQL);
//            st.setInt(1, id);
//            rs = st.executeQuery();
//
//            if (rs.next()) {
//                article = new Article();
//                User author = new User();
//
//                article.setId(rs.getInt("articleId"));
//                article.setTitle(rs.getString("articleTitle"));
//                article.setText(rs.getString("articleText"));
//                article.setDate(rs.getDate("articleCreationDate"));
//
//                author.setId(rs.getInt("authorId"));
//                author.setName(rs.getString("authorName"));
//                author.setEmail(rs.getString("authorEmail"));
//
//                article.setAuthor(author);
//            }
//
//            return article;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            releaseMemory(st, rs);
//            closeConnection(connection);
//        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean create(Comment entity) {
        return false;
    }

    @Override
    public Comment update(Comment entity) {
        return null;
    }
}
