package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3307/student_mng";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối CSDL thành công!");
        } catch (SQLException e) {
            System.out.println("kết nối thất bại!");
        }
    }

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        Db.conn = conn;
    }
}