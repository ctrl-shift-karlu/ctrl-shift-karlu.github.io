import dao.ConnectionProvider;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class DIAGNOSIS extends javax.swing.JFrame {
    
    private int patientID;
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DIAGNOSIS.class.getName());
     public DIAGNOSIS(int patientID) {
        initComponents();
        
        //gikuha niya ang patientid and giset niya as active
        this.patientID = patientID;
        
        //method nga mashow ang patient info
        loadPatientInfo();
        
        
        //mao ni tong rel time, i butang ni sa tanan jframes aron naay real time tanan
        SimpleDateFormat time = new SimpleDateFormat ("hh:mma");
        SimpleDateFormat date = new SimpleDateFormat ("MMMM dd, yyyy");
       
        Timer timer = new Timer(1000, e->{
          oras.setText(time.format(new Date()));
        });
       
        timer.start();
       
        petsa.setText(date.format(new Date()));
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kk = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pAbout = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        petsa = new javax.swing.JLabel();
        oras = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prescField = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        addAdField = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        finishDiagBut = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        diagField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        kk.setBackground(new java.awt.Color(255, 255, 255));
        kk.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, java.awt.SystemColor.controlHighlight));

        pAbout.setColumns(20);
        pAbout.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pAbout.setRows(5);
        pAbout.setBorder(null);
        pAbout.setFocusable(false);
        jScrollPane1.setViewportView(pAbout);

        javax.swing.GroupLayout kkLayout = new javax.swing.GroupLayout(kk);
        kk.setLayout(kkLayout);
        kkLayout.setHorizontalGroup(
            kkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        kkLayout.setVerticalGroup(
            kkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(24, 28, 47));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 51));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DIAGNOSIS");

        petsa.setBackground(new java.awt.Color(255, 255, 255));
        petsa.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        petsa.setForeground(new java.awt.Color(255, 255, 255));
        petsa.setText("jLabel5");

        oras.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        oras.setForeground(new java.awt.Color(255, 255, 255));
        oras.setText("jLabel5");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(petsa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oras, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(petsa)
                    .addComponent(oras))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Diagnosis");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Additional Advice");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Prescription/s");

        prescField.setColumns(20);
        prescField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        prescField.setRows(5);
        prescField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, java.awt.SystemColor.controlHighlight));
        jScrollPane2.setViewportView(prescField);

        addAdField.setColumns(20);
        addAdField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addAdField.setRows(5);
        addAdField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, java.awt.SystemColor.controlHighlight));
        jScrollPane3.setViewportView(addAdField);

        jButton5.setText("Return");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        finishDiagBut.setBackground(new java.awt.Color(0, 204, 255));
        finishDiagBut.setForeground(new java.awt.Color(255, 255, 255));
        finishDiagBut.setText("Finish");
        finishDiagBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finishDiagButMouseClicked(evt);
            }
        });

        jButton7.setText("Clear");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("PATIENT INFO");

        diagField.setColumns(20);
        diagField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        diagField.setRows(5);
        diagField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, java.awt.SystemColor.controlHighlight));
        jScrollPane4.setViewportView(diagField);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(finishDiagBut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(finishDiagBut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)))))
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        this.dispose();
        new DASHBOARD().setVisible(true);
    }//GEN-LAST:event_jButton5MouseClicked
    private void loadPatientInfo() {//mao ni method nga magshow sa patient info
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
    try {
        conn = getConnection();

        String sql = "SELECT * FROM patient_info WHERE Patient_ID=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, patientID);

        rs = pst.executeQuery();

        if (rs.next()) {
            String info =
                    "------------------------------------" + "\n" +
                    "PERSONAL INFO" + "\n" +
                    "------------------------------------" + "\n" +
                    "Patient ID: " + rs.getInt("Patient_ID") + "\n" +
                    "Name: " + rs.getString("First_Name") + 
                            " " + rs.getString("Last_Name") + "\n" +
                    "Age: " + rs.getInt("Age") + "\n" +
                    "Gender: " + rs.getString("Sex") + "\n\n" +
                    
                    "------------------------------------" + "\n" +
                    "CONTACT INFO" + "\n" +
                    "------------------------------------" + "\n" +
                    "Address: " + rs.getString("Address") + "\n" +
                    "Contact: " + rs.getString("Contact_Number") + "\n" +
                    "Email: " + rs.getString("Email") + "\n\n" +
                    
                    "------------------------------------" + "\n" +
                    "CONSULTATION INFO" + "\n " +
                    "------------------------------------" + "\n" +
                    "Complaint: " + rs.getString("Complaint") + "\n" +
                    "Allergy: " + rs.getString("Allergy") + "\n" +
                    "Existing Condition: " + rs.getString("Existing_Condition") + "\n\n" +
                    
                    "------------------------------------" + "\n" +
                    "MEDICAL INFO" + "\n" +
                     "------------------------------------" + "\n" +
                    "Temperature: " + rs.getString("Temperature") + "\n" +
                    "Blood Pressure: " + rs.getString("Blood_Pressure") + "\n" +
                    "Blood Type: " + rs.getString("Blood_Type") + "\n" +
                    "Height: " + rs.getString("Height") + "\n" +
                    "Weight: " + rs.getString("Weight");

            pAbout.setText(info);
        } else {
            pAbout.setText("No patient found.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading patient info");
    }
    finally {
        try{
            if(conn!=null) conn.close();
            if(pst!=null) pst.close();
            if(rs!=null) rs.close();       
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
    
    private void finishDiagButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishDiagButMouseClicked
        
        
        String d = diagField.getText();
        String p = prescField.getText();
        String a = addAdField.getText();
        
        if (d.isBlank() || p.isBlank() || a.isBlank()){
            JOptionPane.showMessageDialog(this, "Please input information properly!");
            return;
        }
        
        int choice = JOptionPane.showConfirmDialog(
        this,
        "Complete Diagnosis?",
        "Confirm Patient Diagnosis",
        JOptionPane.YES_NO_OPTION);

    if(choice != JOptionPane.YES_OPTION){
        return;
    }

    Connection conn = null;
    PreparedStatement pst = null;

    try{

        conn = ConnectionProvider.getConnection();

        String sql =
            "UPDATE patient_info SET Diagnosis=?, Prescription=?, Comments=?, Status=? WHERE Patient_ID=?";

        pst = conn.prepareStatement(sql);

        pst.setString(1, diagField.getText());
        pst.setString(2, prescField.getText());
        pst.setString(3, addAdField.getText());
        pst.setString(4, "Checked");
        pst.setInt(5, patientID);

        int rowsUpdated = pst.executeUpdate();

        if(rowsUpdated > 0){

            JOptionPane.showMessageDialog(this,
                "Diagnosis Saved Successfully!");

            this.dispose();

            new DASHBOARD().setVisible(true);

        }
        else{

            JOptionPane.showMessageDialog(this,
                "Patient not found!");
        }

    }
    catch(Exception e){

        e.printStackTrace();

        JOptionPane.showMessageDialog(this,
            "Error saving diagnosis!");
    }
    finally{

        try{

            if(pst != null) pst.close();
            if(conn != null) conn.close();

        }
        catch(Exception e){

            e.printStackTrace();
        }
    }
    
    }//GEN-LAST:event_finishDiagButMouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        String diagnosis = diagField.getText();
        String prescriptions = prescField.getText();
        String addAdvice = addAdField.getText();
        
        int c = JOptionPane.showConfirmDialog(this, "Clear Form?", "Warning", JOptionPane.WARNING_MESSAGE);
        
        if (c == 0){
            diagField.setText("");
            prescField.setText("");
            addAdField.setText("");
        }
    }//GEN-LAST:event_jButton7MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(() -> new DIAGNOSIS(1).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addAdField;
    private javax.swing.JTextArea diagField;
    private javax.swing.JButton finishDiagBut;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel kk;
    private javax.swing.JLabel oras;
    private javax.swing.JTextArea pAbout;
    private javax.swing.JLabel petsa;
    private javax.swing.JTextArea prescField;
    // End of variables declaration//GEN-END:variables

    private java.sql.Connection getConnection() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return java.sql.DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/clinic",
            "root",
            ""
        );

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!");
            return null;
        }
    }
}
