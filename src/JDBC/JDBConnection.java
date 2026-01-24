package JDBC;

import java.sql.*;

public class JDBConnection {
    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_pharma", "root", "king4070");
    }
}

