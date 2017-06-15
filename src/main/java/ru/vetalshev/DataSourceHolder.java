package ru.vetalshev;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceHolder {

    private static DataSourceHolder ourInstance = new DataSourceHolder();
    private DataSource dataSource;

    public static DataSourceHolder getInstance() {
        return ourInstance;
    }

    private DataSourceHolder() {
        System.out.println("CONSTRUCTOR DataSourceHolder");
        try {
//            Context envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
//            dataSource = (DataSource) envCtx.lookup("blog");
//
//            OR
//
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/community");
//
//            OR

//            Context ctx = new InitialContext();
//            Context envCtx = (Context) ctx.lookup("java:comp/env");
//            dataSource = (DataSource) envCtx.lookup("blog");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
