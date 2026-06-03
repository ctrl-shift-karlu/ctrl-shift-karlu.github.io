import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class PATIENTMANAGEMENT extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PATIENTMANAGEMENT.class.getName());

    /**
     * Creates new form PATIENTMANAGEMENT
     */
    public PATIENTMANAGEMENT() {
        initComponents();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        // ID column
        pmQ.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        // AGE column
        pmQ.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        // SEX column
        pmQ.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        pmQ.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        
        loadTable();
        waitingPatient();
        checkedP();
        pmQ.setRowHeight(20);
        todaypatient();
        completedp();
        pmQ.setShowGrid(true); // show grid lines
        pmQ.setGridColor(java.awt.Color.GRAY); // grid color
        pmQ.setIntercellSpacing(new java.awt.Dimension(1, 1)); // spacing
        
        SimpleDateFormat time = new SimpleDateFormat ("hh:mma");
        SimpleDateFormat date = new SimpleDateFormat ("MMMM dd, yyyy");
       
        Timer timer = new Timer(1000, e->{
          oras.setText(time.format(new Date()));
        });
       
        timer.start();
       
        petsa.setText(date.format(new Date()));
        
        pmQ.setRowHeight(30);
        pmQ.getColumnModel().getColumn(0).setPreferredWidth(50);
        pmQ.getColumnModel().getColumn(1).setPreferredWidth(200);
        pmQ.getColumnModel().getColumn(2).setPreferredWidth(50);
        pmQ.getColumnModel().getColumn(3).setPreferredWidth(50);
        pmQ.getColumnModel().getColumn(4).setPreferredWidth(200);
        pmQ.getColumnModel().getColumn(5).setPreferredWidth(200);

    }
    
    public void loadTable() {
        
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    try {
        conn = getConnection();

        String sql = "SELECT * FROM patient_info WHERE Status= 'Pending'";

        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) pmQ.getModel();

        // clear existing rows
        model.setRowCount(0);

        while (rs.next()) {

    int id = rs.getInt("Patient_ID");

    String fullName = rs.getString("First_Name") + " " 
                    + rs.getString("Last_Name");

    String sex = rs.getString("Sex");
    String age = rs.getString("Age");
    String comp = rs.getString("Complaint");
    String status = rs.getString("Status");

    model.addRow(new Object[]{
        id,
        fullName,
        age,
        sex,
        comp,
        status
    });
}
    } catch (Exception e) {
        e.printStackTrace();
    }
    finally{
        try{
            if (conn!=null) conn.close();
            if (pst!=null) pst.close();
            if (rs!=null) rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
    public void waitingPatient(){
        
        Connection conn= null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            
            String count = "SELECT COUNT(*) AS total FROM patient_info WHERE Status = 'Pending'";
            
            pst = conn.prepareStatement(count);
            rs= pst.executeQuery();
            
            if(rs.next()){
                int totalP = rs.getInt("total");
                waiting.setText(String.valueOf(totalP));
                
            }           
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
            if (conn!=null) conn.close();
            if (pst!=null) pst.close();
            if (rs!=null) rs.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    public void checkedP(){
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            
            String count = "SELECT COUNT(*) AS total FROM patient_info";
            
            pst = conn.prepareStatement(count);
            rs= pst.executeQuery();
            
            if(rs.next()){
                int totalP = rs.getInt("total");
                checkedP.setText(String.valueOf(totalP));
                
            }           
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
            if (conn!=null) conn.close();
            if (pst!=null) pst.close();
            if (rs!=null) rs.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
    }
    
    public void searchPatient() {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {

        conn = getConnection();

        String sql = "SELECT * FROM patient_info WHERE First_Name LIKE ? OR Last_Name LIKE ?";

        pst = conn.prepareStatement(sql);

        String keyword = jTextField2.getText();

        pst.setString(1, "%" + keyword + "%");
        pst.setString(2, "%" + keyword + "%");

        rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) pmQ.getModel();

        model.setRowCount(0); 

        while (rs.next()) {

            int id = rs.getInt("Patient_ID");

            String fullName = rs.getString("First_Name") + " " + rs.getString("Last_Name");

            String age = rs.getString("Age");
            String sex = rs.getString("Sex");
            String comp = rs.getString("Complaint");
            String status = rs.getString("Status");

            model.addRow(new Object[]{
                id,
                fullName,
                age,
                sex,
                comp,
                status
            });
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    public void todaypatient(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

    try {

        conn = getConnection();

        String sql = "SELECT * FROM patient_info WHERE `Date` = CURDATE()";

        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();

        summary.setText(""); 

        while (rs.next()) {

            int id = rs.getInt("Patient_ID");

            String fullName = rs.getString("First_Name") + " " + rs.getString("Last_Name");

            String age = rs.getString("Age");
            String sex = rs.getString("Sex");
            String comp = rs.getString("Complaint");
            String status = rs.getString("Status");

            summary.append(
            "ID: " + id +
            " | Name: " + fullName +
            " | Age: " + age +
            " | Sex: " + sex +
            " | Complaint: " + comp +
            " | Status: " + status +"\n"+"\n");
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    }
    
    public void completedp(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            
            String count = "SELECT COUNT(*) AS total FROM patient_info WHERE Status = 'Checked'";
            
            pst = conn.prepareStatement(count);
            rs= pst.executeQuery();
            
            if(rs.next()){
                int totalP = rs.getInt("total");
                compcons.setText(String.valueOf(totalP));
                
            }           
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
            if (conn!=null) conn.close();
            if (pst!=null) pst.close();
            if (rs!=null) rs.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pmQ = new javax.swing.JTable();
        waitingP = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        waiting = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        checkedP = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        oras = new javax.swing.JLabel();
        petsa = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        compcons = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        summary = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 583));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        pmQ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Age", "Sex", "Complaint", "Status"
            }
        ));
        pmQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pmQMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pmQ);

        waitingP.setBackground(new java.awt.Color(0, 204, 255));
        waitingP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(102, 102, 102)));
        waitingP.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        waitingP.setPreferredSize(new java.awt.Dimension(100, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        waiting.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        waiting.setText("0");

        javax.swing.GroupLayout waitingPLayout = new javax.swing.GroupLayout(waitingP);
        waitingP.setLayout(waitingPLayout);
        waitingPLayout.setHorizontalGroup(
            waitingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(waitingPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(52, 52, 52))
            .addGroup(waitingPLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(waiting)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        waitingPLayout.setVerticalGroup(
            waitingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, waitingPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(waiting, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Pending Patients");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Today's Patients");

        jPanel8.setBackground(new java.awt.Color(0, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(102, 102, 102)));
        jPanel8.setPreferredSize(new java.awt.Dimension(100, 60));

        checkedP.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        checkedP.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(checkedP)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkedP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel5.setText("Total Patients");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("QUEUE");

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel7.setText("Search");

        jButton2.setBackground(new java.awt.Color(0, 204, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PATIENT MANAGEMENT");

        oras.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        oras.setForeground(new java.awt.Color(255, 255, 255));
        oras.setText("jLabel4");

        petsa.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        petsa.setForeground(new java.awt.Color(255, 255, 255));
        petsa.setText("jLabel4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(petsa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 524, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(52, 52, 52))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(petsa)
                    .addComponent(oras))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel4.setText("Select from table to diagnose patient");

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(102, 102, 102)));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 60));

        compcons.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        compcons.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(compcons)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(compcons, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("Completed Consultations");

        summary.setColumns(20);
        summary.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        summary.setRows(5);
        summary.setBorder(null);
        summary.setFocusable(false);
        summary.setSelectionColor(new java.awt.Color(0, 184, 148));
        jScrollPane2.setViewportView(summary);

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Return");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(291, 291, 291)
                                .addComponent(jLabel4))
                            .addComponent(jButton3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(waitingP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel5))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(waitingP, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addGap(18, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton3)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        searchPatient();
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void pmQMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pmQMouseClicked
        // TODO add your handling code here:
        
        
        int a = JOptionPane.showConfirmDialog(null, "Do you want to Diagnos this patient?", "SELECT", JOptionPane.YES_NO_OPTION);
        
        if (a == 0) {
        int row = pmQ.getSelectedRow();

        int patientID = Integer.parseInt(
        pmQ.getValueAt(row, 0).toString()
        );

        new DIAGNOSIS(patientID).setVisible(true);

        this.dispose();
        
        }
    }//GEN-LAST:event_pmQMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new DASHBOARD().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new PATIENTMANAGEMENT().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel checkedP;
    private javax.swing.JLabel compcons;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel oras;
    private javax.swing.JLabel petsa;
    private javax.swing.JTable pmQ;
    private javax.swing.JTextArea summary;
    private javax.swing.JLabel waiting;
    private javax.swing.JPanel waitingP;
    // End of variables declaration//GEN-END:variables

    private Connection getConnection() {
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
