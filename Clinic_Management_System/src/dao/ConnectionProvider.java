package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionProvider {

    public static Connection getConnection() {

        Connection con = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/clinic","root","");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection failed!");
        }

        return con;
    }
}