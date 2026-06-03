
import static dao.ConnectionProvider.getConnection;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jairo
 */
public class INFOMGT extends javax.swing.JFrame {
    
        Color DefaultColor = new Color(24, 28, 47);
        Color ActiveColor = new Color(0, 204, 255);
        Color HoverColor = new Color(0, 204, 255);
    
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(INFOMGT.class.getName());

    /**
     * Creates new form INFOMGT
     */
    public INFOMGT() {
        initComponents();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        editTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        editTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        editTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        editTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        deleteTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        deleteTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        deleteTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        deleteTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        table();
        editTable.setShowGrid(true); // show grid lines
        editTable.setGridColor(java.awt.Color.GRAY); // grid color
        editTable.setIntercellSpacing(new java.awt.Dimension(1, 1)); // spacing
        editTable.setRowHeight(20);
        deleteTable.setShowGrid(true); // show grid lines
        deleteTable.setGridColor(java.awt.Color.GRAY); // grid color
        deleteTable.setIntercellSpacing(new java.awt.Dimension(1, 1)); // spacing
        deleteTable.setRowHeight(20);
        editTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        editTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        editTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        editTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        editTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        deleteTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        deleteTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        deleteTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        deleteTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        deleteTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        jScrollPane3.getViewport().setBackground(Color.WHITE);
        jScrollPane4.getViewport().setBackground(Color.WHITE);

        
        CardLayout cl = (CardLayout) infoMGT.getLayout();
        editTable.setRowHeight(30);
        deleteTable.setRowHeight(30);
        
        cl.show(infoMGT, "editP");
        editInfoPanel.setBackground(ActiveColor);
        delInfoPanel.setBackground(DefaultColor);
        
        SimpleDateFormat time = new SimpleDateFormat ("hh:mma");
        SimpleDateFormat date = new SimpleDateFormat ("MMMM dd, yyyy");
       
        Timer timer = new Timer(1000, e->{
          oras.setText(time.format(new Date()));
        });
       
        timer.start();
       
        petsa.setText(date.format(new Date()));
        
        
    }
    
    public void table(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    try {
        conn = getConnection();

        String sql = "SELECT * FROM patient_info";

        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) editTable.getModel();
        DefaultTableModel model1 = (DefaultTableModel) deleteTable.getModel();

        // clear existing rows
        model.setRowCount(0);
        model1.setRowCount(0);

        while (rs.next()) {

    int id = rs.getInt("Patient_ID");

    String fullName = rs.getString("First_Name") + " " 
                    + rs.getString("Last_Name");

    String sex = rs.getString("Sex");
    String age = rs.getString("Age");
    String status = rs.getString("Status");

    Object[] row = {
        id,
        fullName,
        age,
        sex,
        status
    };
    model.addRow(row);
    model1.addRow(row);
    
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
    
    public void search() {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        conn = getConnection();

        String sql = "SELECT * FROM patient_info WHERE First_Name LIKE ? OR Last_Name LIKE ?";
        pst = conn.prepareStatement(sql);

        String keyword1 = keyword.getText();

        pst.setString(1, "%" + keyword1 + "%");
        pst.setString(2, "%" + keyword1 + "%");
        
        rs = pst.executeQuery();

        DefaultTableModel model1 = (DefaultTableModel) editTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) deleteTable.getModel();

        model1.setRowCount(0);
        model2.setRowCount(0);

        while (rs.next()) {

            int id = rs.getInt("Patient_ID");
            String fullName = rs.getString("First_Name") + " " + rs.getString("Last_Name");
            String age = rs.getString("Age");
            String sex = rs.getString("Sex");
            String status = rs.getString("Status");

            Object[] row = { id, fullName, age, sex, status };

            model1.addRow(row);
            model2.addRow(row);
            
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        editInfoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        delInfoPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        infoMGT = new javax.swing.JPanel();
        editP = new javax.swing.JPanel();
        delP = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        deleteTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        petsa = new javax.swing.JLabel();
        oras = new javax.swing.JLabel();
        keyword = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        editTable = new javax.swing.JTable();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));

        editInfoPanel.setBackground(new java.awt.Color(0, 0, 51));
        editInfoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editInfoPanelMouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Patient Info");

        javax.swing.GroupLayout editInfoPanelLayout = new javax.swing.GroupLayout(editInfoPanel);
        editInfoPanel.setLayout(editInfoPanelLayout);
        editInfoPanelLayout.setHorizontalGroup(
            editInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editInfoPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editInfoPanelLayout.setVerticalGroup(
            editInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editInfoPanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        delInfoPanel.setBackground(new java.awt.Color(0, 0, 51));
        delInfoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delInfoPanelMouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Delete Patient Info");

        javax.swing.GroupLayout delInfoPanelLayout = new javax.swing.GroupLayout(delInfoPanel);
        delInfoPanel.setLayout(delInfoPanelLayout);
        delInfoPanelLayout.setHorizontalGroup(
            delInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(delInfoPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        delInfoPanelLayout.setVerticalGroup(
            delInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(delInfoPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Return");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(delInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(editInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        infoMGT.setBackground(new java.awt.Color(255, 255, 255));
        infoMGT.setOpaque(false);
        infoMGT.setLayout(new java.awt.CardLayout());

        editP.setBackground(new java.awt.Color(255, 255, 255));
        editP.setOpaque(false);

        javax.swing.GroupLayout editPLayout = new javax.swing.GroupLayout(editP);
        editP.setLayout(editPLayout);
        editPLayout.setHorizontalGroup(
            editPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
        );
        editPLayout.setVerticalGroup(
            editPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        infoMGT.add(editP, "editP");

        delP.setBackground(new java.awt.Color(255, 255, 255));
        delP.setOpaque(false);

        deleteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Patient ID", "Name", "Age", "Sex", "Status"
            }
        ));
        deleteTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(deleteTable);

        javax.swing.GroupLayout delPLayout = new javax.swing.GroupLayout(delP);
        delP.setLayout(delPLayout);
        delPLayout.setHorizontalGroup(
            delPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
            .addGroup(delPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(delPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        delPLayout.setVerticalGroup(
            delPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
            .addGroup(delPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(delPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        infoMGT.add(delP, "delP");

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PATIENT INFO MANAGEMENT");

        petsa.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        petsa.setForeground(new java.awt.Color(255, 255, 255));
        petsa.setText("jLabel7");

        oras.setBackground(new java.awt.Color(255, 255, 255));
        oras.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        oras.setForeground(new java.awt.Color(255, 255, 255));
        oras.setText("jLabel7");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(petsa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(oras, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oras)
                    .addComponent(petsa))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        keyword.addActionListener(this::keywordActionPerformed);

        jButton3.setBackground(new java.awt.Color(0, 204, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Search");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel6.setText("Search Patient");

        editTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Patient ID", "Name", "Age", "Sex", "Status"
            }
        ));
        editTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(editTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(infoMGT, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(94, 94, 94)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(697, 697, 697)
                        .addComponent(infoMGT, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteTableMouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you want to Delete this Record?", "SELECT", JOptionPane.YES_NO_OPTION);
        
        if (a == 0) {
        int row = deleteTable.getSelectedRow();

        int id = (int) deleteTable.getValueAt(row, 0);
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = getConnection();
            
            String sql = "DELETE FROM patient_info WHERE Patient_ID = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deleted successfully!");

            table();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(conn!=null) conn.close();
                if(pst!=null) pst.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
       
        }
        
    }//GEN-LAST:event_deleteTableMouseClicked

    private void editTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTableMouseClicked
        
        int a = JOptionPane.showConfirmDialog(null,"Do you want to edit this Patient's record?", "SELECT", JOptionPane.YES_NO_OPTION);
        
        if (a == 0) {
            int row = editTable.getSelectedRow();
            int id = (int) editTable.getValueAt(row, 0);
            
            
            this.dispose();
            new EDITPATIENT(id).setVisible(true);
        }
        
    }//GEN-LAST:event_editTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        search();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void keywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keywordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
        new DASHBOARD().setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void delInfoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delInfoPanelMouseClicked

        CardLayout cl = (CardLayout) infoMGT.getLayout();

        cl.show(infoMGT, "delP");
        editInfoPanel.setBackground(DefaultColor);
        delInfoPanel.setBackground(ActiveColor);
    }//GEN-LAST:event_delInfoPanelMouseClicked

    private void editInfoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoPanelMouseClicked

        CardLayout cl = (CardLayout) infoMGT.getLayout();

        cl.show(infoMGT, "editP");
        editInfoPanel.setBackground(ActiveColor);
        delInfoPanel.setBackground(DefaultColor);
    }//GEN-LAST:event_editInfoPanelMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new INFOMGT().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel delInfoPanel;
    private javax.swing.JPanel delP;
    private javax.swing.JTable deleteTable;
    private javax.swing.JPanel editInfoPanel;
    private javax.swing.JPanel editP;
    private javax.swing.JTable editTable;
    private javax.swing.JPanel infoMGT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField keyword;
    private javax.swing.JLabel oras;
    private javax.swing.JLabel petsa;
    // End of variables declaration//GEN-END:variables
}
