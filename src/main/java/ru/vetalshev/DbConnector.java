package ru.vetalshev;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnector {

    public static Connection getConnection (String dbConfigPath) throws SQLException {
        Properties config = new Properties();
        //InputStream configFile = null;

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            Class cl= Class.forName("com.mysql.jdbc.Driver");

        // TODO: абсолютный путь
        try (InputStream stream = DbConnector.class.getClassLoader().getResourceAsStream(dbConfigPath)) {
            //configFile = new FileInputStream( stream);

            config.load(stream);
            String url = config.getProperty("url");

            return DriverManager.getConnection(url, config);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}