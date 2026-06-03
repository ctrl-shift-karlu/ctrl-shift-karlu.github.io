import dao.ConnectionProvider;
import static dao.ConnectionProvider.getConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jairo
 */
public class FULL_INFO extends javax.swing.JFrame {
    
    private int patientID;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FULL_INFO.class.getName());

    /**
     * Creates new form FULL_INFO
     */
    public FULL_INFO(int patientID) {
        initComponents();
        this.patientID = patientID;
        
        diag();
        pres();
        add();
        
        //gikuha niya ang patientid and giset niya as active
        
        
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
    public void loadPatientInfo(){
        
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
                    "Date Created: " + rs.getDate("Date")+ "\n" +
                    "Patient ID:    " + rs.getInt("Patient_ID") + "\n" +
                    "Name:           " + rs.getString("First_Name") + 
                            " " + rs.getString("Last_Name") + "\n" +
                    "Age:            " + rs.getInt("Age") + "\n" +
                    "Gender:        " + rs.getString("Sex") + "\n\n" +
                    
                    "------------------------------------" + "\n" +
                    "CONTACT INFO" + "\n" +
                    "------------------------------------" + "\n" +
                    "Address:       " + rs.getString("Address") + "\n" +
                    "Contact:       " + rs.getString("Contact_Number") + "\n" +
                    "Email:         " + rs.getString("Email") + "\n\n" +
                    
                    "------------------------------------" + "\n" +
                    "CONSULTATION INFO" + "\n " +
                    "------------------------------------" + "\n" +
                    "Complaint:     " + rs.getString("Complaint") + "\n" +
                    "Allergy:       " + rs.getString("Allergy") + "\n" +
                    "Existing Condition: " + rs.getString("Existing_Condition") + "\n\n" +
                    
                    "------------------------------------" + "\n" +
                    "MEDICAL INFO" + "\n" +
                    "------------------------------------" + "\n" +
                    "Temperature:   " + rs.getString("Temperature") + "\n" +
                    "Blood Pressure: " + rs.getString("Blood_Pressure") + "\n" +
                    "Blood Type:    " + rs.getString("Blood_Type") + "\n" +
                    "Height:    " + rs.getString("Height") + "\n" +
                    "Weight:    " + rs.getString("Weight");

            pAbout.setText(info); // or another textarea if this is just for diagnosis
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
    public void diag(){
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            
            String sql = "SELECT * FROM patient_info WHERE Patient_ID=?";
            
            pst = conn.prepareStatement(sql);
            pst.setInt(1, patientID);

            rs = pst.executeQuery();
            
            if(rs.next()){
                String info = rs.getString("Diagnosis");
                diagField.setText(info);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
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
    public void pres(){
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            
            String sql = "SELECT * FROM patient_info WHERE Patient_ID=?";
            
            pst = conn.prepareStatement(sql);
            pst.setInt(1, patientID);

            rs = pst.executeQuery();
            
            if(rs.next()){
                String info = rs.getString("Prescription");
                prescField.setText(info);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
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
    
    public void add(){
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            
            String sql = "SELECT * FROM patient_info WHERE Patient_ID=?";
            
            pst = conn.prepareStatement(sql);
            pst.setInt(1, patientID);

            rs = pst.executeQuery();
            
            if(rs.next()){
                String info = rs.getString("Comments");
                addAdField.setText(info);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        finishDiagBut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        diagField = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        kk = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pAbout = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prescField = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        addAdField = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        petsa = new javax.swing.JLabel();
        oras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        finishDiagBut.setText("Return");
        finishDiagBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finishDiagButMouseClicked(evt);
            }
        });
        finishDiagBut.addActionListener(this::finishDiagButActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("PATIENT INFO");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Diagnosis");

        diagField.setColumns(20);
        diagField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        diagField.setRows(5);
        diagField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, java.awt.SystemColor.controlHighlight));
        diagField.setFocusable(false);
        jScrollPane4.setViewportView(diagField);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Additional Advice");

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

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Prescription/s");

        prescField.setColumns(20);
        prescField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        prescField.setRows(5);
        prescField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, java.awt.SystemColor.controlHighlight));
        prescField.setFocusable(false);
        jScrollPane2.setViewportView(prescField);

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

        addAdField.setColumns(20);
        addAdField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addAdField.setRows(5);
        addAdField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, java.awt.SystemColor.controlHighlight));
        addAdField.setFocusable(false);
        jScrollPane3.setViewportView(addAdField);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 51));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PATIENT'S INFORMATION");

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
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(petsa)
                    .addComponent(oras))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finishDiagBut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(finishDiagBut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void finishDiagButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishDiagButMouseClicked

    }//GEN-LAST:event_finishDiagButMouseClicked

    private void finishDiagButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishDiagButActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new History().setVisible(true);
    }//GEN-LAST:event_finishDiagButActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FULL_INFO(1).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addAdField;
    private javax.swing.JTextArea diagField;
    private javax.swing.JButton finishDiagBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
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
}
