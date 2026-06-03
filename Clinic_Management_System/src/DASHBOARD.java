
import static dao.ConnectionProvider.getConnection;
import java.awt.CardLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jairo
 */
public class DASHBOARD extends javax.swing.JFrame {
        
        Color DefaultColor = new Color (24,28,47);
        Color ActiveColor = new Color (0, 184, 148);
        Color HoverColor = new Color (36, 41, 61);
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DASHBOARD.class.getName());

 
    public DASHBOARD() {
        initComponents();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        // ID column
        tb1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        // AGE column
        tb1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        // SEX column
        tb1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tb1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        pendingP();
        checkedP();
        queueTable();
        tb1.setShowGrid(true); // show grid lines
        tb1.setGridColor(java.awt.Color.GRAY); // grid color
        tb1.setIntercellSpacing(new java.awt.Dimension(1, 1)); // spacing
        tb1.setRowHeight(30);
        tb1.getColumnModel().getColumn(0).setPreferredWidth(50);
        tb1.getColumnModel().getColumn(1).setPreferredWidth(200);
        tb1.getColumnModel().getColumn(2).setPreferredWidth(50);
        tb1.getColumnModel().getColumn(3).setPreferredWidth(50);
        tb1.getColumnModel().getColumn(4).setPreferredWidth(200);
        tb1.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        
        SimpleDateFormat time = new SimpleDateFormat ("hh:mma");
        SimpleDateFormat date = new SimpleDateFormat ("MMMM dd, yyyy");
       
        //timer
        Timer timer = new Timer(1000, e->{
          oras.setText(time.format(new Date()));
        });
       
        timer.start();
       
        petsa.setText(date.format(new Date()));
      
        //background for panel buttons
        m1.setBackground(DefaultColor);
        m2.setBackground(DefaultColor);
        m3.setBackground(DefaultColor);
        m4.setBackground(DefaultColor);
        SO.setBackground(DefaultColor);
        
    }
    
        public void pendingP(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            
            String pending = "SELECT COUNT(*) AS total FROM Patient_info WHERE Status = 'Pending'";
            
            pst = conn.prepareStatement(pending);
            rs= pst.executeQuery();
            
            if(rs.next()){
                int totalpending = rs.getInt("total");
                pendingpatients.setText(String.valueOf(totalpending));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if (conn !=null) conn.close();
                if (pst !=null) pst.close();
                if (rs !=null) rs.close();
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
            
            String count = "SELECT COUNT(*) AS total FROM Patient_info WHERE Status= 'Checked'";
            pst = conn.prepareStatement(count);
            rs = pst.executeQuery();
            
            if(rs.next()){
                int totalchecked = rs.getInt("total");
                checked.setText(String.valueOf(totalchecked));
            }
     
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if (conn !=null) conn.close();
                if (pst !=null) pst.close();
                if (rs !=null) rs.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }    
    }
    
    public void queueTable(){
        
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    try {
        conn = getConnection();

        String sql = "SELECT * FROM patient_info";

        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tb1.getModel();

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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        m1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        m2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        m3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        m4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        SO = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pendingpatients = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        checked = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        oras = new javax.swing.JLabel();
        petsa = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(1000, 600));

        jPanel11.setBackground(new java.awt.Color(0, 0, 51));
        jPanel11.setOpaque(false);

        m1.setBackground(new java.awt.Color(0, 0, 51));
        m1.setForeground(new java.awt.Color(255, 255, 255));
        m1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                m1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                m1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                m1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\jairo\\Downloads\\plus.png")); // NOI18N
        jLabel1.setText("Add Patient");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout m1Layout = new javax.swing.GroupLayout(m1);
        m1.setLayout(m1Layout);
        m1Layout.setHorizontalGroup(
            m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(m1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        m1Layout.setVerticalGroup(
            m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, m1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );

        m2.setBackground(new java.awt.Color(0, 0, 51));
        m2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                m2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                m2MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Manage Patient");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\jairo\\Downloads\\project-manager.png")); // NOI18N

        javax.swing.GroupLayout m2Layout = new javax.swing.GroupLayout(m2);
        m2.setLayout(m2Layout);
        m2Layout.setHorizontalGroup(
            m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(m2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(12, 12, 12))
        );
        m2Layout.setVerticalGroup(
            m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, m2Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16))
        );

        m3.setBackground(new java.awt.Color(0, 0, 51));
        m3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                m3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                m3MouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Edit Patient Info");

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\jairo\\Downloads\\edit-info.png")); // NOI18N

        javax.swing.GroupLayout m3Layout = new javax.swing.GroupLayout(m3);
        m3.setLayout(m3Layout);
        m3Layout.setHorizontalGroup(
            m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(m3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        m3Layout.setVerticalGroup(
            m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, m3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14))
        );

        m4.setBackground(new java.awt.Color(0, 0, 51));
        m4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                m4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                m4MouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Patient Record");

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\jairo\\Downloads\\folder (1).png")); // NOI18N

        javax.swing.GroupLayout m4Layout = new javax.swing.GroupLayout(m4);
        m4.setLayout(m4Layout);
        m4Layout.setHorizontalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(m4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        m4Layout.setVerticalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(m4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel5))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        SO.setBackground(new java.awt.Color(0, 0, 51));
        SO.setForeground(new java.awt.Color(255, 255, 255));
        SO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SOMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SOMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SOMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SOMousePressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\jairo\\Downloads\\log-out.png")); // NOI18N
        jLabel16.setText("Sign Out");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout SOLayout = new javax.swing.GroupLayout(SO);
        SO.setLayout(SOLayout);
        SOLayout.setHorizontalGroup(
            SOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SOLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SOLayout.setVerticalGroup(
            SOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SOLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(m2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(m1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(m3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(m4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(m2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(m3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(m4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(SO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CLINIC MANAGEMENT SYSTEM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(229, 229, 229))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(102, 102, 102)));

        pendingpatients.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        pendingpatients.setForeground(new java.awt.Color(255, 255, 255));
        pendingpatients.setText("0");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PENDING PATIENTS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(pendingpatients)
                        .addGap(58, 58, 58))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pendingpatients, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(102, 102, 102)));

        checked.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        checked.setForeground(new java.awt.Color(255, 255, 255));
        checked.setText("0");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PATIENT CHECKED");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(checked)
                        .addGap(66, 66, 66))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checked)
                .addGap(18, 18, 18))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(102, 102, 102)));
        jPanel6.setFocusable(false);
        jPanel6.setOpaque(false);

        jScrollPane1.setFocusable(false);

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Patient ID", "Name", "Age", "Sex", "Complaint", "Status"
            }
        ));
        tb1.setFocusable(false);
        jScrollPane1.setViewportView(tb1);

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel10.setText("QUEUE");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("DASHBOARD");

        oras.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        oras.setForeground(new java.awt.Color(255, 255, 255));
        oras.setText("ORAS");

        petsa.setBackground(new java.awt.Color(0, 0, 51));
        petsa.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        petsa.setForeground(new java.awt.Color(255, 255, 255));
        petsa.setText("PETSA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(petsa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oras, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(petsa)
                    .addComponent(oras))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void m1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m1MouseEntered
        m1.setBackground(HoverColor);
    }//GEN-LAST:event_m1MouseEntered

    private void m2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m2MouseEntered
        m2.setBackground(HoverColor);
    }//GEN-LAST:event_m2MouseEntered

    private void m3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m3MouseEntered
        m3.setBackground(HoverColor);
    }//GEN-LAST:event_m3MouseEntered

    private void m4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m4MouseEntered
        m4.setBackground(HoverColor);
    }//GEN-LAST:event_m4MouseEntered

    private void m1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m1MouseExited
        m1.setBackground(DefaultColor);
    }//GEN-LAST:event_m1MouseExited

    private void m2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m2MouseExited
        m2.setBackground(DefaultColor);
    }//GEN-LAST:event_m2MouseExited

    private void m3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m3MouseExited
        m3.setBackground(DefaultColor);
    }//GEN-LAST:event_m3MouseExited

    private void m4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m4MouseExited
        m4.setBackground(DefaultColor);
    }//GEN-LAST:event_m4MouseExited

    private void m1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m1MousePressed
        this.dispose();
        new REGISTRATION().setVisible(true);
        
    }//GEN-LAST:event_m1MousePressed

    private void SOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SOMouseEntered
        // TODO add your handling code here:
        SO.setBackground(HoverColor);
    }//GEN-LAST:event_SOMouseEntered

    private void SOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SOMouseExited
        // TODO add your handling code here:
        SO.setBackground(DefaultColor);
    }//GEN-LAST:event_SOMouseExited

    private void SOMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SOMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SOMousePressed

    private void m2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m2MouseClicked
        this.dispose();
        new PATIENTMANAGEMENT().setVisible(true);
    }//GEN-LAST:event_m2MouseClicked

    private void m3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m3MouseClicked
        this.dispose();
        new INFOMGT().setVisible(true);
    }//GEN-LAST:event_m3MouseClicked

    private void SOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SOMouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you want to log out?","SELECT", JOptionPane.YES_NO_OPTION);
        
        if (a==0){
            System.exit(0);
        }
        else{
            
        }
        
    }//GEN-LAST:event_SOMouseClicked

    private void m4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m4MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new History().setVisible(true);
        
    }//GEN-LAST:event_m4MouseClicked

    
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(() -> new DASHBOARD().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SO;
    private javax.swing.JLabel checked;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m2;
    private javax.swing.JPanel m3;
    private javax.swing.JPanel m4;
    private javax.swing.JLabel oras;
    private javax.swing.JLabel pendingpatients;
    private javax.swing.JLabel petsa;
    private javax.swing.JTable tb1;
    // End of variables declaration//GEN-END:variables
}
