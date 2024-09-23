package config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class JDBC {
    public static Connection getConnection() {
        Connection c = null;
        try {
            // Register MySQL Driver with DriverManager
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connection parameters
            String url = "jdbc:mysql://localhost:3306/sieuthimini";
            String userName = "root";
            String password = "";
            
            // Establish connection
            c = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            System.out.println("kết nối thành công");
            // Handle exception
//          JOptionPane.showMessageDialog(null, "Could not connect to the database!","Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData metadata = c.getMetaData();
                System.out.println(metadata.getDatabaseProductName());
                System.out.println(metadata.getDatabaseProductVersion());
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}
