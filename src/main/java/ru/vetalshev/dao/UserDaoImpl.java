package ru.vetalshev.dao;

import ru.vetalshev.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao<User> implements UserDao<User> {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        String FIND_ALL_SQL = "SELECT id, name, email FROM user";
        List<User> users = new ArrayList<>();

        try {
            st = connection.prepareStatement(FIND_ALL_SQL);
            rs = st.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));

                users.add(user);
            }

            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
        }

        return users;
    }

    @Override
    public User findById(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        String FIND_BY_ID_SQL = "SELECT id, name, email FROM user WHERE id=?";
        User user = null;

        try {
            st = connection.prepareStatement(FIND_BY_ID_SQL);
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
        }

        return user;
    }

    @Override
    public User findByEmail(String email) {
        PreparedStatement st = null;
        ResultSet rs = null;

        String FIND_BY_EMAIL_SQL = "SELECT id, name, email FROM user WHERE email=?";
        User user = null;

        try {
            st = connection.prepareStatement(FIND_BY_EMAIL_SQL);
            st.setString(1, email);
            rs = st.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
        }

        return user;
    }

    @Override
    public List<User> findByName(String name) {
        PreparedStatement st = null;
        ResultSet rs = null;

        String FIND_BY_NAME_SQL = "SELECT id, name, email FROM user WHERE name=?";
        List<User> users = new ArrayList<>();

        try {
            st = connection.prepareStatement(FIND_BY_NAME_SQL);
            st.setString(1, name);
            rs = st.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));

                users.add(user);
            }

            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
        }

        return users;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        boolean flag = false;
        String SQL_DELETE = "DELETE FROM user WHERE id=?";

        try {
            st = connection.prepareStatement(SQL_DELETE);
            st.setInt(1, id);
            st.executeUpdate();

            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
        }

        return flag;
    }

    @Override
    public boolean create(User user) {
        PreparedStatement st = null;
        ResultSet rs = null;

        boolean flag = false;
        String SQL_INSERT = "INSERT INTO user(name, email) VALUES(?,?)";

        try {
            st = connection.prepareStatement(SQL_INSERT);
            st.setString(1, user.getName());
            st.setString(2, user.getEmail());
            st.executeUpdate();

            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
        }

        return flag;
    }

    @Override
    public User update(User user) {
        PreparedStatement st = null;
        ResultSet rs = null;

        String SQL_INSERT = "UPDATE user SET name = ?, email = ?";

        try {
            st = connection.prepareStatement(SQL_INSERT);
            st.setString(1, user.getName());
            st.setString(2, user.getEmail());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseMemory(st, rs);
        }

        return user;
    }

}