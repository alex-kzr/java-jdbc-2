package com.alexkozyura.tutorial.jdbc2.database;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLiteConnection {

    private static Connection connection;
    private static InitialContext initialContext;
    private static DataSource dataSource;
    public static final String URL = "jdbc:sqlite:E:\\Docs\\workspace\\Java\\java-jdbc2\\avia.db";

    private SQLiteConnection() {}

    private static SQLiteConnection sqLiteConnectionInstance;

    public static SQLiteConnection getInstance() {
        if (sqLiteConnectionInstance == null) {
            sqLiteConnectionInstance = new SQLiteConnection();
        }

        return sqLiteConnectionInstance;
    }

    public Connection getConnection() {

        try {
            if  (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL);
            }
        } catch (SQLException exception) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, exception);
        }

        return connection;
    }
}
