
import static dao.ConnectionProvider.getConnection;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class REGISTRATION extends javax.swing.JFrame {
    
        Color DefaultColor = new Color(24, 28, 47);
        Color ActiveColor = new Color(0, 204, 255);
        Color HoverColor = new Color(0, 204, 255);
        
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(REGISTRATION.class.getName());

    /**
     * Creates new form REGISTRATION
     */
    public REGISTRATION() {
        initComponents();
        
        cinfo.setBackground(DefaultColor);
        pinfo.setBackground(HoverColor);
        DOB.setMaxSelectableDate(new java.util.Date());
        
        fNameLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        lNameLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        DOBLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        emailLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        conLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        addressLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        genderLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        
        complaintLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        allergyLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        exConLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        tempLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        bpLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        btLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        heightLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        weightLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
        
        
        SimpleDateFormat time = new SimpleDateFormat ("hh:mma");
        SimpleDateFormat date = new SimpleDateFormat ("MMMM dd, yyyy");
       
        Timer timer = new Timer(1000, e->{
          oras.setText(time.format(new Date()));
        });
       
        timer.start();
       
        petsa.setText(date.format(new Date()));
        
        
        javax.swing.JFormattedTextField tempText =
((javax.swing.JSpinner.DefaultEditor) tempField.getEditor()).getTextField();

tempText.addFocusListener(new java.awt.event.FocusListener() {

    @Override
    public void focusGained(java.awt.event.FocusEvent e) {
        tempLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
    }

    @Override
    public void focusLost(java.awt.event.FocusEvent e) {
        tempLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
    }
});
       
    }


    
    private int calculateAge(java.util.Date dob) {
    java.time.LocalDate birthDate = dob.toInstant()
            .atZone(java.time.ZoneId.systemDefault())
            .toLocalDate();

    java.time.LocalDate today = java.time.LocalDate.now();

    return java.time.Period.between(birthDate, today).getYears();
}
    private int getLatestPatientID() {
    int patientID = 0;

    try {
        Connection conn = getConnection();

        String sql = "SELECT MAX(Patient_ID) AS Patient_ID FROM patient_info";
        

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            patientID = rs.getInt("Patient_ID");
        }

        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return patientID;
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        pinfo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cinfo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pCon = new javax.swing.JPanel();
        pinfoPanel = new javax.swing.JPanel();
        fNameLabel = new javax.swing.JLabel();
        lNameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        conLabel = new javax.swing.JLabel();
        DOBLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        fNameField = new javax.swing.JTextField();
        contactField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        lNameField = new javax.swing.JTextField();
        DOB = new com.toedter.calendar.JDateChooser();
        gMale = new javax.swing.JRadioButton();
        gFemale = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        prpiNext = new javax.swing.JButton();
        prpiClear = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        prpiReturn = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        addressField = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        cinfoPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        complaintLabel = new javax.swing.JLabel();
        btLabel = new javax.swing.JLabel();
        allergyLabel = new javax.swing.JLabel();
        weightLabel = new javax.swing.JLabel();
        exConLabel = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        tempLabel = new javax.swing.JLabel();
        bpLabel = new javax.swing.JLabel();
        allergyField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        bpField = new javax.swing.JTextField();
        prConReturn = new javax.swing.JButton();
        savePinfoButton = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        prpiClear1 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        btField = new javax.swing.JComboBox<>();
        heightField = new javax.swing.JSpinner();
        weightField = new javax.swing.JSpinner();
        tempField = new javax.swing.JSpinner();
        complaintField = new javax.swing.JTextField();
        exConField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        petsa = new javax.swing.JLabel();
        oras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        jPanel11.setBackground(new java.awt.Color(24, 28, 47));

        pinfo.setBackground(new java.awt.Color(0, 0, 51));
        pinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pinfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pinfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pinfoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pinfoMousePressed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Patient Info");

        javax.swing.GroupLayout pinfoLayout = new javax.swing.GroupLayout(pinfo);
        pinfo.setLayout(pinfoLayout);
        pinfoLayout.setHorizontalGroup(
            pinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pinfoLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pinfoLayout.setVerticalGroup(
            pinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pinfoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        cinfo.setBackground(new java.awt.Color(0, 0, 51));
        cinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cinfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cinfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cinfoMouseExited(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Consultation");

        javax.swing.GroupLayout cinfoLayout = new javax.swing.GroupLayout(cinfo);
        cinfo.setLayout(cinfoLayout);
        cinfoLayout.setHorizontalGroup(
            cinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cinfoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel4)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        cinfoLayout.setVerticalGroup(
            cinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cinfoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pinfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cinfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pCon.setBackground(new java.awt.Color(0, 153, 102));
        pCon.setOpaque(false);
        pCon.setLayout(new java.awt.CardLayout());

        pinfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        pinfoPanel.setOpaque(false);

        fNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fNameLabel.setText("First Name");

        lNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lNameLabel.setText("Last Name");

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailLabel.setText("Email");

        genderLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genderLabel.setText("Sex");

        conLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        conLabel.setText("Contact Number");

        DOBLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DOBLabel.setText("Date of Birth");

        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addressLabel.setText("Address");

        fNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fNameFieldFocusLost(evt);
            }
        });

        contactField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                contactFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                contactFieldFocusLost(evt);
            }
        });

        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });
        emailField.addActionListener(this::emailFieldActionPerformed);

        lNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lNameFieldFocusLost(evt);
            }
        });

        DOB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DOBFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DOBFocusLost(evt);
            }
        });

        gender.add(gMale);
        gMale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gMale.setText("Male");

        gender.add(gFemale);
        gFemale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gFemale.setText("Female");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setText("PERSONAL INFORMATION");

        prpiNext.setBackground(new java.awt.Color(0, 204, 255));
        prpiNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        prpiNext.setForeground(new java.awt.Color(255, 255, 255));
        prpiNext.setIcon(new javax.swing.ImageIcon("C:\\Users\\jairo\\Downloads\\right-arrow (1).png")); // NOI18N
        prpiNext.setText("Next");
        prpiNext.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        prpiNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prpiNextMouseClicked(evt);
            }
        });

        prpiClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        prpiClear.setText("Clear");
        prpiClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prpiClearMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 51));
        jLabel17.setText("CONTACT INFORMATION");

        prpiReturn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        prpiReturn.setText("Return");
        prpiReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prpiReturnMouseClicked(evt);
            }
        });

        addressField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addressFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressFieldFocusLost(evt);
            }
        });
        addressField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressFieldMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pinfoPanelLayout = new javax.swing.GroupLayout(pinfoPanel);
        pinfoPanel.setLayout(pinfoPanelLayout);
        pinfoPanelLayout.setHorizontalGroup(
            pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pinfoPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pinfoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pinfoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pinfoPanelLayout.createSequentialGroup()
                        .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pinfoPanelLayout.createSequentialGroup()
                                .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addressLabel)
                                    .addComponent(conLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prpiReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pinfoPanelLayout.createSequentialGroup()
                                        .addComponent(prpiClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(prpiNext, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pinfoPanelLayout.createSequentialGroup()
                                        .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(contactField, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                                .addComponent(addressField))
                                            .addComponent(fNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                        .addComponent(emailLabel)
                                        .addGap(50, 50, 50)
                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pinfoPanelLayout.createSequentialGroup()
                                .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DOBLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lNameLabel)
                                    .addComponent(genderLabel))
                                .addGap(18, 18, 18)
                                .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pinfoPanelLayout.createSequentialGroup()
                                        .addComponent(gMale, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(gFemale))
                                    .addComponent(lNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator5))
                        .addGap(44, 44, 44))))
        );
        pinfoPanelLayout.setVerticalGroup(
            pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pinfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fNameLabel)
                        .addComponent(fNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lNameLabel)
                        .addComponent(lNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pinfoPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genderLabel)
                            .addComponent(gMale, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pinfoPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DOBLabel))))
                .addGap(52, 52, 52)
                .addComponent(jLabel17)
                .addGap(9, 9, 9)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailLabel))
                    .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(conLabel)
                        .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addressLabel)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(pinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prpiNext, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prpiClear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prpiReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        pCon.add(pinfoPanel, "pinfoPanel");

        cinfoPanel.setOpaque(false);
        cinfoPanel.setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 51));
        jLabel13.setText("MEDICAL INFORMATION");

        complaintLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        complaintLabel.setText("Complaint");

        btLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btLabel.setText("Blood Type");

        allergyLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        allergyLabel.setText("Allergies");

        weightLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        weightLabel.setText("Weight (kg)");

        exConLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        exConLabel.setText("Existing Conditions");

        heightLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        heightLabel.setText("Height (cm)");

        tempLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tempLabel.setText("Temperature (c)");
        tempLabel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tempLabelFocusGained(evt);
            }
        });

        bpLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bpLabel.setText("Blood Pressure");

        allergyField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                allergyFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                allergyFieldFocusLost(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 51));
        jLabel23.setText("VITAL SIGNS");

        bpField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bpFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bpFieldFocusLost(evt);
            }
        });

        prConReturn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        prConReturn.setText("Return");
        prConReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prConReturnMouseClicked(evt);
            }
        });

        savePinfoButton.setBackground(new java.awt.Color(0, 204, 255));
        savePinfoButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        savePinfoButton.setForeground(new java.awt.Color(255, 255, 255));
        savePinfoButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\jairo\\Downloads\\download-icon.png")); // NOI18N
        savePinfoButton.setText("Save");
        savePinfoButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        savePinfoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savePinfoButtonMouseClicked(evt);
            }
        });
        savePinfoButton.addActionListener(this::savePinfoButtonActionPerformed);

        prpiClear1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        prpiClear1.setText("Clear");
        prpiClear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prpiClear1MouseClicked(evt);
            }
        });

        btField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NA", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        btField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btFieldMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btFieldMouseReleased(evt);
            }
        });
        btField.addActionListener(this::btFieldActionPerformed);

        heightField.setVerifyInputWhenFocusTarget(false);
        heightField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                heightFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                heightFieldFocusLost(evt);
            }
        });

        complaintField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                complaintFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                complaintFieldFocusLost(evt);
            }
        });

        exConField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exConFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                exConFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout cinfoPanelLayout = new javax.swing.GroupLayout(cinfoPanel);
        cinfoPanel.setLayout(cinfoPanelLayout);
        cinfoPanelLayout.setHorizontalGroup(
            cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cinfoPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cinfoPanelLayout.createSequentialGroup()
                        .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel13))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cinfoPanelLayout.createSequentialGroup()
                        .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cinfoPanelLayout.createSequentialGroup()
                                .addComponent(prConReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(prpiClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(savePinfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator6)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cinfoPanelLayout.createSequentialGroup()
                                .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(cinfoPanelLayout.createSequentialGroup()
                                        .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(complaintLabel)
                                            .addComponent(tempLabel)
                                            .addComponent(bpLabel)
                                            .addComponent(btLabel))
                                        .addGap(34, 34, 34))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cinfoPanelLayout.createSequentialGroup()
                                        .addComponent(exConLabel)
                                        .addGap(18, 18, 18)))
                                .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(cinfoPanelLayout.createSequentialGroup()
                                        .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(cinfoPanelLayout.createSequentialGroup()
                                                .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(bpField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tempField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(71, 71, 71)
                                                .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(heightLabel)
                                                    .addComponent(weightLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(cinfoPanelLayout.createSequentialGroup()
                                                .addComponent(complaintField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(allergyLabel)
                                                .addGap(26, 26, 26)))
                                        .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(allergyField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(weightField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                .addComponent(heightField, javax.swing.GroupLayout.Alignment.LEADING))))
                                    .addGroup(cinfoPanelLayout.createSequentialGroup()
                                        .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(exConField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(44, 44, 44))))
        );
        cinfoPanelLayout.setVerticalGroup(
            cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cinfoPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complaintLabel)
                    .addComponent(allergyLabel)
                    .addComponent(allergyField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(complaintField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exConLabel)
                    .addComponent(exConField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempLabel)
                    .addComponent(heightLabel)
                    .addComponent(heightField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tempField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bpField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bpLabel)
                        .addComponent(weightLabel)
                        .addComponent(weightField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLabel)
                    .addComponent(btField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(cinfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prConReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prpiClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(savePinfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        pCon.add(cinfoPanel, "cinfoPanel");

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PATIENT REGISTRATION");

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        petsa.setBackground(new java.awt.Color(0, 0, 51));
        petsa.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        petsa.setForeground(new java.awt.Color(255, 255, 255));
        petsa.setText("PETSA");

        oras.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        oras.setForeground(new java.awt.Color(255, 255, 255));
        oras.setText("ORAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(petsa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oras, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(oras)
                        .addComponent(petsa)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(0, 184, 148));
        jLabel1.setForeground(new java.awt.Color(0, 184, 148));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pCon, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pinfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pinfoMouseEntered
        
    }//GEN-LAST:event_pinfoMouseEntered

    private void pinfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pinfoMouseExited
        
    }//GEN-LAST:event_pinfoMouseExited

    private void cinfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cinfoMouseEntered
        
    }//GEN-LAST:event_cinfoMouseEntered

    private void cinfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cinfoMouseExited
        
    }//GEN-LAST:event_cinfoMouseExited

    private void pinfoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pinfoMousePressed
        
        
    }//GEN-LAST:event_pinfoMousePressed

    private void pinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pinfoMouseClicked
        
    }//GEN-LAST:event_pinfoMouseClicked

    private void cinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cinfoMouseClicked
        
    }//GEN-LAST:event_cinfoMouseClicked

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        
    }//GEN-LAST:event_emailFieldActionPerformed

    private void prpiNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prpiNextMouseClicked
        String contact = contactField.getText().trim();
        String email = emailField.getText().trim();

        //validations
        if (!fNameField.getText().matches("[a-zA-Z\\s]+") || fNameField.getText().length() < 3
            || !lNameField.getText().matches("[a-zA-Z\\s]+") || lNameField.getText().length() < 2) {
        JOptionPane.showMessageDialog(this, "Name must not be empty and should contain letters only!");
        return;
        }
        
        if (gender.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please select a gender.");
            return;
        }
        
        if (!contact.matches("^09\\d{9}$")) {
        JOptionPane.showMessageDialog(this,
            "Contact number must start with 09 and be 11 digits!");
        return;
        }
        
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format!");
            return;
        }
        
        
        //if "consultation" is clicked, switch the active panel to consultation info (cinfo)
        CardLayout cl = (CardLayout) pCon.getLayout();
        
        cl.show(pCon, "cinfoPanel");
        cinfo.setBackground(ActiveColor);
        pinfo.setBackground(DefaultColor);
        
    }//GEN-LAST:event_prpiNextMouseClicked

    private void prConReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prConReturnMouseClicked
        
        //if returned, back to personal info (pinfo)
        CardLayout cl = (CardLayout) pCon.getLayout();
        
        cl.show(pCon, "pinfoPanel");
        pinfo.setBackground(ActiveColor);
        cinfo.setBackground(DefaultColor);
    }//GEN-LAST:event_prConReturnMouseClicked

    private void prpiReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prpiReturnMouseClicked
        this.dispose();
        new DASHBOARD().setVisible(true);
    }//GEN-LAST:event_prpiReturnMouseClicked

    private void savePinfoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savePinfoButtonMouseClicked
    
        //validations
    if (!complaintField.getText().matches("[a-zA-Z\\s]+") 
            || !allergyField.getText().matches("[a-zA-Z\\s]+") 
            || !exConField.getText().matches("[a-zA-Z\\s]+")){
        JOptionPane.showMessageDialog(this,
            "Be honest!");
        return;
    }    
    
    double tempVal = ((Number) tempField.getValue()).doubleValue();
    if (tempVal < 30){
        JOptionPane.showMessageDialog(this,
            "Temperature is invalid!");
        return;
    }
    
    int heVal = (int) heightField.getValue();
    if (heVal < 1){
        JOptionPane.showMessageDialog(this,
            "Height is invalid!");
        return;
    }
    
    int weVal = (int) weightField.getValue();
    if (weVal < 1){
        JOptionPane.showMessageDialog(this,
            "Weight is invalid!");
        return;
    }
    
    int choice = JOptionPane.showConfirmDialog(
            this,
            "Confirm Info?",
            "Confirm Patient Registration",
            JOptionPane.YES_NO_OPTION
    );
    
    

    if (choice != JOptionPane.YES_OPTION) {
        return;
    }
    
    

    //saving to db
    try {
        Connection conn = getConnection();

        String sql = "INSERT INTO patient_info "
                + "(First_Name, Last_Name, Age, Sex, Email, Contact_Number, Address, "
                + "Complaint, Existing_Condition, Allergy, Temperature, Blood_Pressure, "
                + "Blood_Type, Height, Weight, Time,Status,Date) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";

        PreparedStatement pst = conn.prepareStatement(sql);

        // ===== PERSONAL INFO =====
        pst.setString(1, fNameField.getText());
        pst.setString(2, lNameField.getText());

        // DOB
        java.util.Date dob = DOB.getDate();
        int age = 0;

        if (dob != null) {
            age = calculateAge(dob);
            
        }
        pst.setInt(3, age);

        // Gender
        String genderValue = "";
        if (gMale.isSelected()) {
            genderValue = "Male";
        } else if (gFemale.isSelected()) {
            genderValue = "Female";
        }
        pst.setString(4, genderValue);

        pst.setString(5, emailField.getText());
        pst.setString(6, contactField.getText());
        pst.setString(7, addressField.getText());

        // ===== MEDICAL INFO =====
        pst.setString(8, complaintField.getText());
        pst.setString(9, exConField.getText());
        pst.setString(10, allergyField.getText());

        pst.setString(11, tempField.getValue().toString());
        pst.setString(12, bpField.getText());
        pst.setString(13, btField.getSelectedItem().toString());
        pst.setString(14, heightField.getValue().toString());
        pst.setString(15, weightField.getValue().toString());
        pst.setString(17, "Pending");
        
        //time stamp
        java.sql.Time currentTime =
        new java.sql.Time(System.currentTimeMillis());
        
        pst.setTime(16, currentTime);
        
        java.sql.Date currentDate =
        new java.sql.Date(System.currentTimeMillis());

        pst.setDate(18, currentDate);
        
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Patient Successfully Saved!");

        int next = JOptionPane.showConfirmDialog(
                this,
                "Proceed to Diagnosis?",
                "Next Step",
                JOptionPane.YES_NO_OPTION
        );

        //if yes, proceed to diagnosis and pass the patient id
        //aron mabal an sa db what index ang gina inseratan
        if (next == JOptionPane.YES_OPTION) {
            this.dispose();
            new DIAGNOSIS(getLatestPatientID()).setVisible(true);
        } else {
            this.dispose();
            new DASHBOARD().setVisible(true);
        }

        
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error saving patient data!");
    }
    
    
        
    }//GEN-LAST:event_savePinfoButtonMouseClicked

    
    private void fNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fNameFieldFocusGained
        fNameLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
    }//GEN-LAST:event_fNameFieldFocusGained

    private void fNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fNameFieldFocusLost
        
        fNameLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_fNameFieldFocusLost

    private void lNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lNameFieldFocusGained
        lNameLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
        
    }//GEN-LAST:event_lNameFieldFocusGained

    private void lNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lNameFieldFocusLost
        
        lNameLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_lNameFieldFocusLost

    private void DOBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DOBFocusGained
        DOBLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
    }//GEN-LAST:event_DOBFocusGained

    private void DOBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DOBFocusLost
        
        DOBLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_DOBFocusLost

    private void contactFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contactFieldFocusGained
        conLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
        
    }//GEN-LAST:event_contactFieldFocusGained

    private void contactFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contactFieldFocusLost
        
        conLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_contactFieldFocusLost

    private void emailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusGained
        emailLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
        
    }//GEN-LAST:event_emailFieldFocusGained

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        
        emailLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_emailFieldFocusLost

    private void allergyFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_allergyFieldFocusGained
        allergyLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
       
    }//GEN-LAST:event_allergyFieldFocusGained

    private void allergyFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_allergyFieldFocusLost
        
        allergyLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_allergyFieldFocusLost

    private void tempLabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tempLabelFocusGained
 
        
    }//GEN-LAST:event_tempLabelFocusGained

    private void bpFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bpFieldFocusGained
        bpLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
        
    }//GEN-LAST:event_bpFieldFocusGained

    private void bpFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bpFieldFocusLost
        
        bpLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_bpFieldFocusLost

    private void prpiClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prpiClearMouseClicked
         String fName = fNameField.getText();
         String lName = lNameField.getText();
         String email = emailField.getText();
         String contact = contactField.getText();
         String address = addressField.getText();
         
         String dob = (DOB.getDate() == null) ? "" : DOB.getDate().toString();

         if (fName.isBlank() && lName.isBlank() && email.isBlank() && contact.isBlank() && address.isBlank() && dob.isBlank()){
             
         } else {
            int c = JOptionPane.showConfirmDialog(this, "Clear Form?", "Warning", 2, JOptionPane.WARNING_MESSAGE);
        
            if (c == 0){
                fNameField.setText("");
                lNameField.setText("");
                DOB.setDate(null);
                contactField.setText("");
                emailField.setText("");
                addressField.setText("");
                gender.clearSelection();
            } 
         }
    }//GEN-LAST:event_prpiClearMouseClicked

    private void prpiClear1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prpiClear1MouseClicked
        String complaint = complaintField.getText();
        String exCon = exConField.getText();
        String allergy = allergyField.getText();
        String temp = tempField.getValue().toString();
        String bp = bpField.getText();
        String bt = btField.getSelectedItem().toString();
        String height =  heightField.getValue().toString();
        String weight = weightField.getValue().toString();
        
        
        
        if (complaint.isBlank() && exCon.isBlank() && allergy.isBlank() &&
                temp.isBlank() && bp.isBlank() && bt.isBlank() && height.isBlank() && weight.isBlank()){
             
         } else {
            int c = JOptionPane.showConfirmDialog(this, "Clear Form?", "Warning", 2, JOptionPane.WARNING_MESSAGE);
        
            if (c == 0){
                complaintField.setText("");
                exConField.setText("");
                allergyField.setText("");
                tempField.setValue(0);
                bpField.setText("");
                btField.setSelectedItem("Select");
                heightField.setValue(0);
                weightField.setValue(0);
            } 
         }
    }//GEN-LAST:event_prpiClear1MouseClicked

    private void btFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFieldMousePressed
        
    }//GEN-LAST:event_btFieldMousePressed

    private void btFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFieldMouseReleased
        
    }//GEN-LAST:event_btFieldMouseReleased

    private void btFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFieldActionPerformed
        btLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
    }//GEN-LAST:event_btFieldActionPerformed

    private void addressFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressFieldMouseClicked
        
    }//GEN-LAST:event_addressFieldMouseClicked

    private void addressFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressFieldFocusGained
        addressLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
    }//GEN-LAST:event_addressFieldFocusGained

    private void addressFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressFieldFocusLost
        addressLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_addressFieldFocusLost

    private void heightFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_heightFieldFocusGained
        heightLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
    }//GEN-LAST:event_heightFieldFocusGained

    private void heightFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_heightFieldFocusLost
        heightLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_heightFieldFocusLost

    private void complaintFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_complaintFieldFocusGained
        complaintLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
    }//GEN-LAST:event_complaintFieldFocusGained

    private void complaintFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_complaintFieldFocusLost
        complaintLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_complaintFieldFocusLost

    private void exConFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exConFieldFocusGained
        exConLabel.setFont(new Font ("Segoe UI", Font.BOLD, 12));
    }//GEN-LAST:event_exConFieldFocusGained

    private void exConFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exConFieldFocusLost
        exConLabel.setFont(new Font ("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_exConFieldFocusLost

    private void savePinfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePinfoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_savePinfoButtonActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new REGISTRATION().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DOB;
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField allergyField;
    private javax.swing.JLabel allergyLabel;
    private javax.swing.JTextField bpField;
    private javax.swing.JLabel bpLabel;
    private javax.swing.JComboBox<String> btField;
    private javax.swing.JLabel btLabel;
    private javax.swing.JPanel cinfo;
    private javax.swing.JPanel cinfoPanel;
    private javax.swing.JTextField complaintField;
    private javax.swing.JLabel complaintLabel;
    private javax.swing.JLabel conLabel;
    private javax.swing.JTextField contactField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField exConField;
    private javax.swing.JLabel exConLabel;
    private javax.swing.JTextField fNameField;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JRadioButton gFemale;
    private javax.swing.JRadioButton gMale;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JSpinner heightField;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField lNameField;
    private javax.swing.JLabel lNameLabel;
    private javax.swing.JLabel oras;
    private javax.swing.JPanel pCon;
    private javax.swing.JLabel petsa;
    private javax.swing.JPanel pinfo;
    private javax.swing.JPanel pinfoPanel;
    private javax.swing.JButton prConReturn;
    private javax.swing.JButton prpiClear;
    private javax.swing.JButton prpiClear1;
    private javax.swing.JButton prpiNext;
    private javax.swing.JButton prpiReturn;
    private javax.swing.JButton savePinfoButton;
    private javax.swing.JSpinner tempField;
    private javax.swing.JLabel tempLabel;
    private javax.swing.JSpinner weightField;
    private javax.swing.JLabel weightLabel;
    // End of variables declaration//GEN-END:variables

    
}
