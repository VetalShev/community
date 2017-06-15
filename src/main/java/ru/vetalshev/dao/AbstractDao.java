package ru.vetalshev.dao;

import ru.vetalshev.model.Entity;

import java.sql.*;

public abstract class AbstractDao<T extends Entity> implements Dao<T> {
    protected Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

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
}
