package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DB {
    private static String url = "jdbc:mariadb://localhost:3306/db_empleados";
    private static String user = "laura";
    private static String password = "123";
    private static Connection conn = null;

    public static Connection getConexion(){
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to database");
                System.out.println(conn.getCatalog());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return conn;
    }

}