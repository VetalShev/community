package ru.vetalshev.dao;

import ru.vetalshev.AppContext;
import ru.vetalshev.model.Entity;

import javax.sql.DataSource;
import java.sql.*;

public abstract class AbstractDao<T extends Entity> implements Dao<T> {

    protected void closeStatement(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            // лог о невозможности закрытия Statement
        }
    }

    protected void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) { // был ли создан ResultSet
                rs.close();
            } else {
                System.out.println("Reading DB error");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
            // лог о невозможности закрытия Connection
        }
    }

    protected void releaseMemory(Statement st, ResultSet rs) {
        // закрыть ResultSet, если он был открыт или ошибка произошла во время чтения из него данных
        closeResultSet(rs);
        // закрыть Statement, если он был открыт или ошибка произошла во время создания Statement
        closeStatement(st);
    }

    protected Connection getConnection() {
        DataSource dataSource = AppContext.getDataSource();
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    protected void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
