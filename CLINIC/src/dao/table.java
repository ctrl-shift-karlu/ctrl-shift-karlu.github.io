package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class table {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = ConnectionProvider.getConnection();
            st = conn.createStatement();

            st.executeUpdate ( 
                    "CREATE TABLE IF NOT EXIST patient_infos ("
        + "Patient_ID INT AUTO_INCREMENT PRIMARY KEY, "
        + "First_Name VARCHAR(50), "
        + "Last_Name VARCHAR(50), "
        + "Age INT, "
        + "Sex VARCHAR(10), "
        + "Email VARCHAR(100), "
        + "Contact_Number VARCHAR(20), "
        + "Address VARCHAR(255), "
        + "Complaint TEXT, "
        + "Existing_Condition TEXT, "
        + "Allergy TEXT, "
        + "Temperature VARCHAR(10), "
        + "Blood_Pressure VARCHAR(20), "
        + "Blood_Type VARCHAR(10), "
        + "Height VARCHAR(10), "
        + "Weight VARCHAR(10), "
        + "Created_At TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
        + ")");



            System.out.println("Table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}