package enrollmentsystem;

import static enrollmentsystem.LogIn.txtUser;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnrollmentForm extends javax.swing.JFrame {

    int flag = 0, gEn = 0, gPre = 0, tS = 0, firstt = 0, secondd = 0, g = 0;
    String gEnroll = "", tSchool = "", prevG = "", na = "";
    String getFirst = "", getSec = "", bdate, Tos;
    int bmon, bday, byear, px, py;
    String month, gend, edate;
    int date, year, age;
    static int flg = 0;
    String gwa;
    String username;
    Connection con;
    static String s1, s2, s3, s4, s5, s6, s7, s8;
    Calendar cal = Calendar.getInstance();

    DefaultComboBoxModel first = new DefaultComboBoxModel();

    public EnrollmentForm(String user) {
        username = user;
        initComponents();
        txtfrmSI.setText("300751");
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        cbday.setModel(model1);

        DefaultComboBoxModel model2 = new DefaultComboBoxModel();
        cbyear.setModel(model2);
        txtfrmAGE.setText("");

        s1 = null;
        s2 = null;
        s3 = null;
        s4 = null;
        s5 = null;
        s6 = null;
        s7 = null;
        s8 = null;

        for (int ctr = 1; ctr <= 30; ctr++) {
            cbday.addItem(ctr);
        }

        for (int ctr = 2020; ctr >= 1950; ctr--) {
            cbyear.addItem(ctr);
        }

        DefaultComboBoxModel gwa = new DefaultComboBoxModel();
        cbGWA.setModel(gwa);

        DecimalFormat g = new DecimalFormat("0.00");

        cbGWA.addItem("N/A");
        for (float ctr = 100; ctr >= 75; ctr -= 0.01) {
            cbGWA.addItem(g.format(ctr) + "");
        }

        cb1ST.setModel(first);
        cb1ST.addItem("FIRST CHOICE");
        cb1ST.addItem("Technical-Vocational-Livelihood (ICT)-PROGRAMMING");
        cb1ST.addItem("Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)");
        cb1ST.addItem("Technical-Vocational-Livelihood (ICT)-ANIMATION");
        cb1ST.addItem("Technical-Vocational-Livelihood (HE)-BREAD AND PASTRY PRODUCTION");
        cb1ST.addItem("Technical-Vocational-Livelihood (HE)-HOUSEKEEPING");
        cb1ST.addItem("Technical-Vocational-Livelihood (HE)-COOKERY");
        cb1ST.addItem("Technical-Vocational-Livelihood (IA)-AUTOMOTIVE");
        cb1ST.addItem("Technical-Vocational-Livelihood (IA)-REPAIR AND INSTALLATION");
        cb1ST.addItem("Technical-Vocational-Livelihood (IA)-WELDING");
        cb1ST.addItem("Science, Technology, Engineering and Mathematics (STEM) - ENGINEERING");
        cb1ST.addItem("Science, Technology, Engineering and Mathematics (STEM) - MEDICINE");
        cb1ST.addItem("Science, Technology, Engineering and Mathematics (STEM) - ARCHITECHTURE");
        cb1ST.addItem("Accounting and Business Management (ABM) - ACCOUNTANCY");
        cb1ST.addItem("Accounting and Business Management (ABM) - Business Management");
        cb1ST.addItem("Accounting and Business Management (ABM) -ENTREPRENEURSHIP");
        cb1ST.addItem("Applied and specialized subjects ARTS AND DESIGN");
        cb1ST.addItem("Applied and specialized subjects SPORTS");
        cb1ST.addItem("Humanities and Social Sciences (HUMSS)");

        DefaultComboBoxModel sec = new DefaultComboBoxModel();
        cb2ND.setModel(sec);
        cb2ND.addItem("SECOND CHOICE");
        cb2ND.addItem("Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)");
        cb2ND.addItem("Technical-Vocational-Livelihood (ICT)-ANIMATION");
        cb2ND.addItem("Technical-Vocational-Livelihood (HE)-BREAD AND PASTRY PRODUCTION");
        cb2ND.addItem("Technical-Vocational-Livelihood (HE)-HOUSEKEEPING");
        cb2ND.addItem("Technical-Vocational-Livelihood (HE)-COOKERY");
        cb2ND.addItem("Technical-Vocational-Livelihood (IA)-AUTOMOTIVE");
        cb2ND.addItem("Technical-Vocational-Livelihood (IA)-REPAIR AND INSTALLATION");
        cb2ND.addItem("Technical-Vocational-Livelihood (IA)-WELDING");
        cb2ND.addItem("Accounting and Business Management (ABM) -ENTREPRENEURSHIP");
        cb2ND.addItem("Applied and specialized subjects ARTS AND DESIGN");
        cb2ND.addItem("Applied and specialized subjects SPORTS");

    }

    public int compute() {

        int mon = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        int year = cal.get(Calendar.YEAR);

        byear = (int) cbyear.getSelectedItem();
        age = year - byear;

        try {
            if (cbmonth.getSelectedIndex() + 1 > mon) {
                age--;
            } else if (cbmonth.getSelectedIndex() + 1 == mon) {
                if (cbday.getSelectedIndex() + 1 > day) {
                    age--;
                }
            }

        } catch (Exception e) {
        }
        return age;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTAAS = new javax.swing.ButtonGroup();
        bgType = new javax.swing.ButtonGroup();
        bgBABA = new javax.swing.ButtonGroup();
        bgGen = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jMenuItem1 = new javax.swing.JMenuItem();
        lblback = new javax.swing.JLabel();
        enPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtfrmLRN = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtfrmSI = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        cbGWA = new javax.swing.JComboBox<>();
        txtGwa = new javax.swing.JTextField();
        txtApp = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        rbtn11 = new javax.swing.JRadioButton();
        rbtn12 = new javax.swing.JRadioButton();
        cb1ST = new javax.swing.JComboBox<>();
        lbl1ST = new javax.swing.JLabel();
        cb2ND = new javax.swing.JComboBox<>();
        lbl2ND = new javax.swing.JLabel();
        txt1ST = new javax.swing.JTextField();
        txt2ND = new javax.swing.JTextField();
        txtGrade = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtfrmLN = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtfrmFN = new javax.swing.JTextField();
        txtfrmMN = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtfrmNN = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtfrmAGE = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtfrmR = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtfrmCIT = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtfrmBPLACE = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        cbmonth = new javax.swing.JComboBox();
        cbday = new javax.swing.JComboBox();
        cbyear = new javax.swing.JComboBox();
        rbtnMale = new javax.swing.JRadioButton();
        rbtnFem = new javax.swing.JRadioButton();
        txtBday = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txtfrmSLA = new javax.swing.JTextField();
        txtfrmYC = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtfrmREG = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtfrmSA = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        rbtnPUB = new javax.swing.JRadioButton();
        rbtnPRI = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtfrmFATHER = new javax.swing.JTextField();
        txtfrmMOTHER = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtfrmGUARDIAN = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtfrmOCCF = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtfrmOCCM = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtfrmOCCG = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtfrmPN = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        rbtn14 = new javax.swing.JRadioButton();
        rbtn13 = new javax.swing.JRadioButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtfrmET = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        lblMarceloLogo = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        LBLMHPNHS = new javax.swing.JLabel();
        lbldivision = new javax.swing.JLabel();
        lbldivision2 = new javax.swing.JLabel();
        lbldivision1 = new javax.swing.JLabel();
        lblDep = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnfrmCON = new javax.swing.JButton();

        bgTAAS.add(rbtn11);
        bgTAAS.add(rbtn12);

        bgType.add(rbtnPUB);
        bgType.add(rbtnPRI);

        bgBABA.add(rbtn13);
        bgBABA.add(rbtn14);

        bgGen.add(rbtnMale);
        bgGen.add(rbtnFem);

        jTextField1.setText("jTextField1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        lblback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/back.png"))); // NOI18N
        lblback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbackMouseClicked(evt);
            }
        });
        getContentPane().add(lblback);
        lblback.setBounds(10, 10, 40, 30);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setOpaque(false);

        enPanel.setBackground(new java.awt.Color(255, 255, 255));
        enPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enPanel.setOpaque(false);
        enPanel.setPreferredSize(new java.awt.Dimension(813, 1700));
        enPanel.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 102, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ENROLLMENT FORM SENIOR HIGH SCHOOL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel8)
                .addContainerGap(348, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        enPanel.add(jPanel2);
        jPanel2.setBounds(10, 200, 982, 19);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel6.setText("Learners Reference Number (LRN):");
        jLabel6.setToolTipText("LEARNEARS REFERENCE NUMBER");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 20, 258, 16);

        txtfrmLRN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmLRN.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmLRN.setSelectionColor(new java.awt.Color(0, 153, 0));
        txtfrmLRN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                txtfrmLRNMouseDragged(evt);
            }
        });
        txtfrmLRN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtfrmLRNMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtfrmLRNMousePressed(evt);
            }
        });
        jPanel3.add(txtfrmLRN);
        txtfrmLRN.setBounds(20, 50, 620, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel9.setText("School ID:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(680, 20, 65, 16);

        txtfrmSI.setEditable(false);
        txtfrmSI.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmSI.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmSI.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                txtfrmSIMouseDragged(evt);
            }
        });
        txtfrmSI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtfrmSIMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtfrmSIMousePressed(evt);
            }
        });
        txtfrmSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfrmSIActionPerformed(evt);
            }
        });
        jPanel3.add(txtfrmSI);
        txtfrmSI.setBounds(680, 50, 290, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel7.setText("Application Type:");
        jLabel7.setToolTipText("LEARNEARS REFERENCE NUMBER");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(20, 90, 128, 16);

        cbType.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senior High Freshman", "Transferee", "Old Student" }));
        cbType.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeActionPerformed(evt);
            }
        });
        jPanel3.add(cbType);
        cbType.setBounds(20, 120, 620, 30);

        jLabel51.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel51.setText("General Weighted Average (GWA):");
        jLabel51.setToolTipText("LEARNEARS REFERENCE NUMBER");
        jPanel3.add(jLabel51);
        jLabel51.setBounds(680, 90, 237, 16);

        cbGWA.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbGWA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100", "99.9", "99.8", "99.7" }));
        cbGWA.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cbGWA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGWAActionPerformed(evt);
            }
        });
        jPanel3.add(cbGWA);
        cbGWA.setBounds(680, 120, 120, 30);

        txtGwa.setEditable(false);
        txtGwa.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtGwa.setVisible(false);
        jPanel3.add(txtGwa);
        txtGwa.setBounds(680, 120, 120, 30);

        txtApp.setEditable(false);
        txtApp.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtApp.setVisible(false);
        jPanel3.add(txtApp);
        txtApp.setBounds(20, 120, 620, 30);

        enPanel.add(jPanel3);
        jPanel3.setBounds(10, 230, 980, 170);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("2. Submit fully accomplished form and");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("1. Report Card");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("1. Fill out this form");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("bring the requirements");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("2. Birth Certificate(PSA)");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("3. Certificate of Good Moral Character");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("4. NCAE Results");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel19.setText("5. 2pcs. 2x2 ID Picture");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 224, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(181, 181, 181))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        enPanel.add(jPanel5);
        jPanel5.setBounds(10, 440, 982, 130);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel7.setLayout(null);

        rbtn11.setBackground(new java.awt.Color(255, 255, 255));
        rbtn11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbtn11.setText("Grade 11");
        rbtn11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn11ActionPerformed(evt);
            }
        });
        jPanel7.add(rbtn11);
        rbtn11.setBounds(70, 10, 83, 30);

        rbtn12.setBackground(new java.awt.Color(255, 255, 255));
        rbtn12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbtn12.setText("Grade 12");
        rbtn12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn12ActionPerformed(evt);
            }
        });
        jPanel7.add(rbtn12);
        rbtn12.setBounds(70, 50, 83, 30);

        cb1ST.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cb1ST.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cb1ST.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cb1ST.setName(""); // NOI18N
        cb1ST.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb1STMouseClicked(evt);
            }
        });
        cb1ST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1STActionPerformed(evt);
            }
        });
        jPanel7.add(cb1ST);
        cb1ST.setBounds(350, 10, 620, 30);
        cb1ST.getAccessibleContext().setAccessibleName("");

        lbl1ST.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl1ST.setText("First Choice:");
        lbl1ST.setVisible(false);
        jPanel7.add(lbl1ST);
        lbl1ST.setBounds(230, 10, 100, 30);

        cb2ND.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cb2ND.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cb2ND.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb2NDMouseClicked(evt);
            }
        });
        cb2ND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2NDActionPerformed(evt);
            }
        });
        jPanel7.add(cb2ND);
        cb2ND.setBounds(350, 50, 620, 30);

        lbl2ND.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl2ND.setText("Second Choice:");
        lbl2ND.setVisible(false);
        jPanel7.add(lbl2ND);
        lbl2ND.setBounds(230, 50, 98, 30);

        txt1ST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1STActionPerformed(evt);
            }
        });
        txt1ST.setVisible(false);
        jPanel7.add(txt1ST);
        txt1ST.setBounds(350, 10, 620, 30);

        txt2ND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt2NDActionPerformed(evt);
            }
        });
        txt2ND.setVisible(false);
        jPanel7.add(txt2ND);
        txt2ND.setBounds(350, 50, 620, 30);

        txtGrade.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel7.add(txtGrade);
        txtGrade.setBounds(50, 30, 130, 27);
        txtGrade.setVisible(false);

        enPanel.add(jPanel7);
        jPanel7.setBounds(10, 610, 982, 90);

        jPanel6.setBackground(new java.awt.Color(51, 102, 0));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("TRACK, STRANDS and SPECIALIZATION (please select below)");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        enPanel.add(jPanel6);
        jPanel6.setBounds(10, 580, 982, 19);

        jPanel8.setBackground(new java.awt.Color(51, 102, 0));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("PERSONAL INFORMATION");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel21)
                .addContainerGap(737, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        enPanel.add(jPanel8);
        jPanel8.setBounds(10, 710, 982, 19);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel9.setLayout(null);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel22.setText("Last Name:");
        jPanel9.add(jLabel22);
        jLabel22.setBounds(14, 15, 72, 16);

        txtfrmLN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmLN.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmLN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfrmLNFocusGained(evt);
            }
        });
        jPanel9.add(txtfrmLN);
        txtfrmLN.setBounds(14, 38, 217, 30);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel23.setText("First Name:");
        jPanel9.add(jLabel23);
        jLabel23.setBounds(250, 15, 134, 16);

        txtfrmFN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmFN.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmFN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfrmFNFocusGained(evt);
            }
        });
        jPanel9.add(txtfrmFN);
        txtfrmFN.setBounds(247, 38, 500, 30);

        txtfrmMN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmMN.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel9.add(txtfrmMN);
        txtfrmMN.setBounds(759, 38, 209, 30);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel24.setText("Middle Name:");
        jPanel9.add(jLabel24);
        jLabel24.setBounds(759, 15, 134, 16);

        txtfrmNN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmNN.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel9.add(txtfrmNN);
        txtfrmNN.setBounds(14, 99, 217, 30);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel25.setText("Nickname:");
        jPanel9.add(jLabel25);
        jLabel25.setBounds(14, 76, 65, 16);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel26.setText("Birthdate:");
        jPanel9.add(jLabel26);
        jLabel26.setBounds(249, 76, 69, 16);

        txtfrmAGE.setEditable(false);
        txtfrmAGE.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmAGE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfrmAGE.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel9.add(txtfrmAGE);
        txtfrmAGE.setBounds(672, 99, 69, 30);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel27.setText("Age:");
        jPanel9.add(jLabel27);
        jLabel27.setBounds(672, 75, 69, 16);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel28.setText("Religion:");
        jPanel9.add(jLabel28);
        jLabel28.setBounds(759, 76, 134, 16);

        txtfrmR.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmR.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel9.add(txtfrmR);
        txtfrmR.setBounds(759, 99, 209, 30);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel29.setText("Citizenship:");
        jPanel9.add(jLabel29);
        jLabel29.setBounds(14, 136, 74, 16);

        txtfrmCIT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmCIT.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmCIT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfrmCITFocusGained(evt);
            }
        });
        jPanel9.add(txtfrmCIT);
        txtfrmCIT.setBounds(14, 159, 217, 30);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel30.setText("Birthplace:");
        jPanel9.add(jLabel30);
        jLabel30.setBounds(249, 136, 134, 16);

        txtfrmBPLACE.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmBPLACE.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmBPLACE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfrmBPLACEFocusGained(evt);
            }
        });
        jPanel9.add(txtfrmBPLACE);
        txtfrmBPLACE.setBounds(249, 159, 500, 30);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel31.setText("Gender:");
        jPanel9.add(jLabel31);
        jLabel31.setBounds(760, 140, 134, 16);

        cbmonth.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbmonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbmonth.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cbmonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbmonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbmonthMouseClicked(evt);
            }
        });
        cbmonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmonthActionPerformed(evt);
            }
        });
        jPanel9.add(cbmonth);
        cbmonth.setBounds(250, 100, 195, 30);

        cbday.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbday.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cbday.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdayActionPerformed(evt);
            }
        });
        jPanel9.add(cbday);
        cbday.setBounds(456, 99, 74, 30);

        cbyear.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbyear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbyear.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cbyear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbyear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbyearItemStateChanged(evt);
            }
        });
        cbyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbyearActionPerformed(evt);
            }
        });
        jPanel9.add(cbyear);
        cbyear.setBounds(542, 98, 112, 30);

        rbtnMale.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbtnMale.setText("Male");
        rbtnMale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtnMale.setBackground(new java.awt.Color(255, 255, 255));
        rbtnMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMaleActionPerformed(evt);
            }
        });
        jPanel9.add(rbtnMale);
        rbtnMale.setBounds(760, 160, 74, 25);

        rbtnFem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbtnFem.setBackground(new java.awt.Color(255, 255, 255));
        rbtnFem.setText("Female");
        rbtnFem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtnFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFemActionPerformed(evt);
            }
        });
        jPanel9.add(rbtnFem);
        rbtnFem.setBounds(860, 160, 73, 25);

        txtBday.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtBday.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel9.add(txtBday);
        txtBday.setBounds(247, 100, 400, 30);
        txtBday.setVisible(false);

        enPanel.add(jPanel9);
        jPanel9.setBounds(10, 740, 982, 202);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel11.setLayout(null);

        jLabel33.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel33.setText("Name of School Last attended:");
        jPanel11.add(jLabel33);
        jLabel33.setBounds(10, 10, 199, 16);

        txtfrmSLA.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmSLA.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmSLA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfrmSLAFocusGained(evt);
            }
        });
        jPanel11.add(txtfrmSLA);
        txtfrmSLA.setBounds(10, 40, 940, 30);

        txtfrmYC.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmYC.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmYC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfrmYCFocusGained(evt);
            }
        });
        jPanel11.add(txtfrmYC);
        txtfrmYC.setBounds(10, 100, 350, 30);

        jLabel36.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel36.setText("Year Completed:");
        jPanel11.add(jLabel36);
        jLabel36.setBounds(10, 80, 108, 16);

        jLabel40.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel40.setText("Region:");
        jPanel11.add(jLabel40);
        jLabel40.setBounds(10, 140, 49, 16);

        txtfrmREG.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmREG.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmREG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfrmREGFocusGained(evt);
            }
        });
        txtfrmREG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfrmREGActionPerformed(evt);
            }
        });
        jPanel11.add(txtfrmREG);
        txtfrmREG.setBounds(10, 160, 285, 30);

        jLabel37.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel37.setText("School Address: ");
        jPanel11.add(jLabel37);
        jLabel37.setBounds(370, 80, 109, 16);

        txtfrmSA.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmSA.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmSA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfrmSAFocusGained(evt);
            }
        });
        txtfrmSA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfrmSAActionPerformed(evt);
            }
        });
        jPanel11.add(txtfrmSA);
        txtfrmSA.setBounds(370, 100, 580, 30);

        jLabel41.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel41.setText("Type of School:");
        jPanel11.add(jLabel41);
        jLabel41.setBounds(330, 156, 110, 30);

        rbtnPUB.setBackground(new java.awt.Color(255, 255, 255));
        rbtnPUB.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbtnPUB.setText("Public");
        rbtnPUB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtnPUB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPUBActionPerformed(evt);
            }
        });
        jPanel11.add(rbtnPUB);
        rbtnPUB.setBounds(470, 160, 65, 25);

        rbtnPRI.setBackground(new java.awt.Color(255, 255, 255));
        rbtnPRI.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbtnPRI.setText("Private");
        rbtnPRI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtnPRI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPRIActionPerformed(evt);
            }
        });
        jPanel11.add(rbtnPRI);
        rbtnPRI.setBounds(560, 160, 73, 25);

        enPanel.add(jPanel11);
        jPanel11.setBounds(10, 1230, 980, 210);

        jPanel10.setBackground(new java.awt.Color(51, 102, 0));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("FAMILY INFORMATION");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel32)
                .addContainerGap(753, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        enPanel.add(jPanel10);
        jPanel10.setBounds(10, 950, 982, 19);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel13.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel13.setLayout(null);

        jLabel38.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel38.setText("Father:");
        jPanel13.add(jLabel38);
        jLabel38.setBounds(20, 20, 47, 16);

        txtfrmFATHER.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmFATHER.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel13.add(txtfrmFATHER);
        txtfrmFATHER.setBounds(20, 40, 540, 30);

        txtfrmMOTHER.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmMOTHER.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmMOTHER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfrmMOTHERActionPerformed(evt);
            }
        });
        jPanel13.add(txtfrmMOTHER);
        txtfrmMOTHER.setBounds(20, 100, 540, 30);

        jLabel39.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel39.setText("Mother:");
        jPanel13.add(jLabel39);
        jLabel39.setBounds(20, 80, 52, 16);

        jLabel42.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel42.setText("Guardian:");
        jPanel13.add(jLabel42);
        jLabel42.setBounds(20, 140, 62, 16);

        txtfrmGUARDIAN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmGUARDIAN.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmGUARDIAN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfrmGUARDIANFocusGained(evt);
            }
        });
        txtfrmGUARDIAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfrmGUARDIANActionPerformed(evt);
            }
        });
        jPanel13.add(txtfrmGUARDIAN);
        txtfrmGUARDIAN.setBounds(20, 160, 540, 30);

        jLabel43.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel43.setText("Occupation:");
        jPanel13.add(jLabel43);
        jLabel43.setBounds(590, 20, 77, 16);

        txtfrmOCCF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmOCCF.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel13.add(txtfrmOCCF);
        txtfrmOCCF.setBounds(590, 40, 370, 30);

        jLabel44.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel44.setText("Occupation:");
        jPanel13.add(jLabel44);
        jLabel44.setBounds(590, 80, 77, 16);

        txtfrmOCCM.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmOCCM.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmOCCM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfrmOCCMActionPerformed(evt);
            }
        });
        jPanel13.add(txtfrmOCCM);
        txtfrmOCCM.setBounds(590, 100, 370, 30);

        jLabel45.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel45.setText("Occupation:");
        jPanel13.add(jLabel45);
        jLabel45.setBounds(590, 140, 77, 16);

        txtfrmOCCG.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmOCCG.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtfrmOCCG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfrmOCCGActionPerformed(evt);
            }
        });
        jPanel13.add(txtfrmOCCG);
        txtfrmOCCG.setBounds(590, 160, 370, 30);

        enPanel.add(jPanel13);
        jPanel13.setBounds(10, 980, 980, 210);

        jPanel14.setBackground(new java.awt.Color(51, 102, 0));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("ACADEMIC INFORMATION");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel46)
                .addContainerGap(729, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        enPanel.add(jPanel14);
        jPanel14.setBounds(10, 1200, 982, 19);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel34.setText("I hereby certify that the above information given is true and correct");

        txtfrmPN.setEditable(false);
        txtfrmPN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmPN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfrmPN.setBorder(null);
        txtfrmPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfrmPNActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("____________________");

        jLabel50.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel50.setText("Signature Over Printed Name");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel34))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtfrmPN, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfrmPN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel50)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        enPanel.add(jPanel15);
        jPanel15.setBounds(10, 1450, 475, 168);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel47.setText("Eligable for Admission in Grade ");

        rbtn14.setBackground(new java.awt.Color(255, 255, 255));
        rbtn14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbtn14.setText("GRADE 12");
        rbtn14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtn14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn14ActionPerformed(evt);
            }
        });

        rbtn13.setBackground(new java.awt.Color(255, 255, 255));
        rbtn13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbtn13.setText("GRADE 11");
        rbtn13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbtn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn13ActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel48.setText("Enrolling Teacher");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("___________________");

        txtfrmET.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtfrmET.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfrmET.setBorder(null);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addGap(28, 28, 28)
                .addComponent(rbtn13)
                .addGap(18, 18, 18)
                .addComponent(rbtn14)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtfrmET, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(jLabel35)
                    .addContainerGap(61, Short.MAX_VALUE)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(rbtn13)
                    .addComponent(rbtn14))
                .addGap(23, 23, 23)
                .addComponent(txtfrmET, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel48)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE)))
        );

        enPanel.add(jPanel16);
        jPanel16.setBounds(490, 1450, 500, 169);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel12.setLayout(null);

        lblMarceloLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/logo copy copy.png"))); // NOI18N
        jPanel12.add(lblMarceloLogo);
        lblMarceloLogo.setBounds(760, 20, 160, 150);

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("E-mail: marcelohdelpilarnhs@gmail.com/ Tel. No. (044) 795-5343");
        jPanel12.add(jLabel52);
        jLabel52.setBounds(270, 120, 410, 20);

        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Bagong Bayan, City of Malolos, Bulacan / School ID: 300751 / ww.marcelodelpilarnhs.com");
        jPanel12.add(jLabel53);
        jLabel53.setBounds(220, 100, 530, 19);

        LBLMHPNHS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LBLMHPNHS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBLMHPNHS.setText("MARCELO H. DEL PILAR NATIONAL HIGH SCHOOL");
        jPanel12.add(LBLMHPNHS);
        LBLMHPNHS.setBounds(260, 80, 470, 22);

        lbldivision.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision.setText("SCHOOLS DIVISION OFFICE - CITY OF MALOLOS");
        jPanel12.add(lbldivision);
        lbldivision.setBounds(280, 60, 390, 20);

        lbldivision2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision2.setText("DEPARTMENT OF EDUCATION - REGION III");
        jPanel12.add(lbldivision2);
        lbldivision2.setBounds(300, 40, 340, 20);

        lbldivision1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision1.setText("REPUBLIC OF THE PHILIPPINES");
        jPanel12.add(lbldivision1);
        lbldivision1.setBounds(330, 20, 280, 20);

        lblDep.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/deped123.PNG"))); // NOI18N
        jPanel12.add(lblDep);
        lblDep.setBounds(60, 20, 150, 150);

        enPanel.add(jPanel12);
        jPanel12.setBounds(12, 13, 980, 180);

        jPanel4.setBackground(new java.awt.Color(51, 102, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("REQUIREMENTS FOR APPLICATION");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("READ THE INSTRUCTIONS CAREFULLY");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        enPanel.add(jPanel4);
        jPanel4.setBounds(10, 410, 982, 19);

        jScrollPane1.setViewportView(enPanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 20, 1050, 920);

        btnfrmCON.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnfrmCON.setText("Confirm");
        btnfrmCON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfrmCONActionPerformed(evt);
            }
        });
        getContentPane().add(btnfrmCON);
        btnfrmCON.setBounds(30, 960, 140, 27);

        setSize(new java.awt.Dimension(1135, 1001));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbackMouseClicked

        new Profile(Profile.user).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_lblbackMouseClicked


    private void btnfrmCONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrmCONActionPerformed

        txtfrmVal();
        txtfrmlnVAL();
        txtfrmfnVAL();
        txtfrmageVAL();
        txtfrmcitVAL();
        txtfrmtxtfrmbplaceVAL();
        txtfrmguardVAL();
        txtfrmSLAVAL();
        txtfrmycVAL();
        txtfrmSAVAL();
        txtfrmREGVAL();

        bdate = cbmonth.getSelectedItem() + " " + cbday.getSelectedItem() + ", " + cbyear.getSelectedItem();
        Tos = (String) cbType.getSelectedItem();
        gwa = (String) cbGWA.getSelectedItem();

        int mon = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        int year = cal.get(Calendar.YEAR);

        edate = mon + "/" + day + "/" + year;

        if (txtfrmFATHER.getText().trim().equals("")) {
            txtfrmOCCF.setText("");
        }
        if (txtfrmMOTHER.getText().trim().equals("")) {
            txtfrmOCCM.setText("");
        }
        String upName = txtfrmPN.getText().toUpperCase();
        String sem = (String) Profile.CBS.getSelectedItem();
        String sy = (String) Profile.CBSY.getSelectedItem();

        if (age < 14) {
            JOptionPane.showMessageDialog(null, "Your age is not qualified for Senior High School!", "Message", 1);
            return;
        }

        if (g == 0 || flag == 1 || gEn == 0 || gPre == 0 || tS == 0 || getFirst.equals("FIRST CHOICE") || getSec.equals("SECOND CHOICE")) {
            JOptionPane.showMessageDialog(null, "Please Complete The Fields!", "Message", 1);
        } else {
            if (getFirst.equals(getSec)) {
                JOptionPane.showMessageDialog(null, "First Choice and Second Choice Mustn`t the same!", "PLEASE SELECT NEW!", tS);
                return;
            }
            if (txtfrmGUARDIAN.getText().equals("")) {
                txtfrmOCCG.setText("");
            }

            try {

                na = txtfrmLRN.getText();
                if (txtfrmLRN.getText().trim().equals("")) {
                    na = "N/A";
                }
                if (gwa.trim().equals("N/A")) {
                    gwa = "";
                }

                int id = 0;

                con = DriverManager.getConnection("jdbc:mysql:///dbsoria", "root", "root");
               // Statement st3 = con.createStatement();
               Statement st3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs3 = st3.executeQuery("select pr.*,prai.* "
                        + "from tblprof pr,tblprofperinfo prai " + "where pr.id = prai.id");
                while (rs3.next()) {
                    if (txtfrmLRN.getText().equals(rs3.getString("lrn")) && !txtfrmLRN.getText().equals("")) {
                        if (txtfrmFN.getText().trim().equalsIgnoreCase(rs3.getString("fname"))
                                && txtfrmMN.getText().trim().equalsIgnoreCase(rs3.getString("mname"))
                                && txtfrmLN.getText().trim().equalsIgnoreCase(rs3.getString("lname"))
                                && bdate.equals(rs3.getString("bdate"))) {
                            int get = JOptionPane.showConfirmDialog(null, "You already have data in this sytem, press yes to update " + "  ", "Message", 0, 1);
                            if (get != 0) {
                                return;
                            }
                            id = rs3.getInt("id");
                           // Statement st = con.createStatement();
                           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                            st.executeUpdate("update tblprof set school_id = '" + txtfrmSI.getText()
                                    + "', fchoice = '" + getFirst + "', schoice = '" + getSec + "' where id = " + id);
                            st.executeUpdate("update tblprofperinfo set gwa ='" + gwa + "' where id = " + id);
                            st.executeUpdate("update tblprof set date ='" + edate + "',student_type = 'Old Student" + "' where id =" + id);
                            st.executeUpdate("update tblprofperinfo set religion ='" + txtfrmR.getText() + "' where id = " + id);
                            st.executeUpdate("update tblprofperinfo set citizenship ='" + txtfrmCIT.getText() + "' where id = " + id);
                            st.executeUpdate("update tblprofperinfo set bplace ='" + txtfrmBPLACE.getText() + "' where id = " + id);
                            st.executeUpdate("update tblprofacadinfo set eag ='" + gEnroll + "' where id =" + id);
                            st.executeUpdate("update tblprofperinfo set age ='" + age + "', semester = '" + sem + "',sy = '" + sy + "' where id =" + id);
                            JOptionPane.showMessageDialog(null, "Success!");
                            this.dispose();
                            new Profile(Profile.user).setVisible(true);
                            return;

                        } else {
                            JOptionPane.showMessageDialog(null, "LRN Already Exist!", "Message", 2);
                            return;
                        }

                    }
                }

                if (Tos.equals("Transferee")) {
                    flg++;
                }
                if (flg == 1) {
                    new ForTransferee2().setVisible(true);
                    btnfrmCON.setEnabled(false);
                    return;
                }

                con = DriverManager.getConnection("jdbc:mysql:///dbsoria", "root", "root");
              //  Statement st = con.createStatement();
              Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                String in = "insert into tblprof(lrn,school_id,fchoice,schoice,date,student_type) values ('" + na + "','" + txtfrmSI.getText() + "','" + getFirst + "','" + getSec + "','"
                        + edate + "','" + Tos + "')";
                st.executeUpdate(in);

                String in1 = "insert into tblprofperinfo(lname,fname,mname,nname,bdate,age,religion,citizenship,bplace,gender,semester,sy,gwa) values ('"
                        + txtfrmLN.getText() + "','" + txtfrmFN.getText()
                        + "','" + txtfrmMN.getText() + "','" + txtfrmNN.getText() + "','" + bdate + "','" + age + "','" + txtfrmR.getText() + "','" + txtfrmCIT.getText() + "','"
                        + txtfrmBPLACE.getText() + "','" + gend + "','" + sem + "','" + sy + "','" + gwa + "')";
                st.executeUpdate(in1);

                String in2 = "insert into  tblproffaminfo(fathername,fatheroccu,mothername,motheroccu,guardianname,guardianoccu) values ('"
                        + txtfrmFATHER.getText() + "','" + txtfrmOCCF.getText()
                        + "','" + txtfrmMOTHER.getText() + "','" + txtfrmOCCM.getText() + "','" + txtfrmGUARDIAN.getText() + "','" + txtfrmOCCG.getText() + "')";
                st.executeUpdate(in2);

                String in3 = "insert into tblprofacadinfo(nolsa,yearcom,schl_add,reg,tos,Pname,eag,et,archived,section) values ('"
                        + txtfrmSLA.getText() + "','" + txtfrmYC.getText()
                        + "','" + txtfrmSA.getText() + "','" + txtfrmREG.getText() + "','" + tSchool + "','" + upName + "','" + prevG + "','" + txtfrmET.getText() + "',0,'PRE-AD')";
                st.executeUpdate(in3);
                String in4 = "insert into tblsub(s1,s2,s3,s4,s5,s6,s7,s8) values('" + s1 + "','" + s2
                        + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                insertToTblRC();
                st.executeUpdate(in4);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);
                System.out.println(date);

                System.out.println(txtUser.getText());
                st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('" + txtUser.getText() + "',' has enrolled a student', '" + date + "')");
                JOptionPane.showMessageDialog(null, "Successfully Added");

                new Profile(Profile.user).setVisible(true);
                this.dispose();
            } catch (Exception e) {
                System.err.println(e);
            }

        }

    }//GEN-LAST:event_btnfrmCONActionPerformed

    public void insertToTblRC() throws Exception {
       // Statement st = con.createStatement();
       Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        String f_name = txtfrmFN.getText() + " " + txtfrmMN.getText() + " " + txtfrmLN.getText();
        st.executeUpdate("insert into tblrc(lrn,full_name,e_form,g_card,f137,nso,gm,ncae,status,archived) values ('" + na + "','" + f_name + "'," + false + "," + false + "," + false + ","
                + false + "," + false + "," + false + ",'Pending',0" + ")");
    }

    private void rbtn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn13ActionPerformed
        gPre = 1;
        prevG = "GRADE 11";
    }//GEN-LAST:event_rbtn13ActionPerformed

    private void rbtn14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn14ActionPerformed
        gPre = 1;
        prevG = "GRADE 12";
    }//GEN-LAST:event_rbtn14ActionPerformed

    private void txtfrmPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfrmPNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfrmPNActionPerformed

    private void txtfrmOCCGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfrmOCCGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfrmOCCGActionPerformed

    private void txtfrmOCCMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfrmOCCMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfrmOCCMActionPerformed

    private void txtfrmGUARDIANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfrmGUARDIANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfrmGUARDIANActionPerformed

    private void txtfrmMOTHERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfrmMOTHERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfrmMOTHERActionPerformed

    private void rbtnPRIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPRIActionPerformed
        tS = 1;
        tSchool = "Private";
    }//GEN-LAST:event_rbtnPRIActionPerformed

    private void rbtnPUBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPUBActionPerformed
        tS = 1;
        tSchool = "Public";
    }//GEN-LAST:event_rbtnPUBActionPerformed

    private void txtfrmSAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfrmSAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfrmSAActionPerformed

    private void txtfrmREGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfrmREGActionPerformed

    }//GEN-LAST:event_txtfrmREGActionPerformed

    private void rbtnFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFemActionPerformed
        gend = "Female";
        g = 1;
    }//GEN-LAST:event_rbtnFemActionPerformed

    private void rbtnMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMaleActionPerformed
        g = 1;
        gend = "Male";
    }//GEN-LAST:event_rbtnMaleActionPerformed

    private void cbyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbyearActionPerformed
        byear = (int) cbyear.getSelectedItem();
        year = (int) cbyear.getSelectedItem();

        String m = (String) cbmonth.getSelectedItem();

        if ((byear % 400 == 0) || (byear % 4 == 0) && (byear % 100 != 0)) {
            flag = 1;

            if (m.equals("February")) {
                cbday.removeAllItems();
                for (int ctr = 1; ctr <= 29; ctr++) {
                    cbday.addItem(ctr);
                }

            } else {
                //                cbday.removeAllItems();
                //                for (int ctr = 1; ctr <= 31; ctr++) {
                //                    cbday.addItem(ctr);
                //                }
            }
        } else {
            flag = 0;
        }
        compute();
        txtfrmAGE.setText(age + "");
    }//GEN-LAST:event_cbyearActionPerformed

    private void cbyearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbyearItemStateChanged

    }//GEN-LAST:event_cbyearItemStateChanged

    private void cbdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdayActionPerformed
        try {
            date = (int) cbday.getSelectedItem();
            compute();
            txtfrmAGE.setText(age + "");
        } catch (Exception e) {
            // System.err.println(e);
        }
    }//GEN-LAST:event_cbdayActionPerformed

    private void cbmonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmonthActionPerformed
        String m = (String) cbmonth.getSelectedItem();
        month = (String) cbmonth.getSelectedItem();

        if (m.equals("September") || m.equals("April") || m.equals("June") || m.equals("November")) {
            cbday.removeAllItems();
            for (int ctr = 1; ctr <= 30; ctr++) {
                cbday.addItem(ctr);
            }
        } else if (m.equals("February")) {

            if (flag == 1) {

                cbday.removeAllItems();
                for (int ctr = 1; ctr <= 29; ctr++) {
                    cbday.addItem(ctr);
                }
            } else {

                cbday.removeAllItems();
                for (int ctr = 1; ctr <= 28; ctr++) {
                    cbday.addItem(ctr);
                }
            }

        } else {
            cbday.removeAllItems();
            for (int ctr = 1; ctr <= 31; ctr++) {
                cbday.addItem(ctr);
            }
        }
        compute();
        txtfrmAGE.setText(age + "");
    }//GEN-LAST:event_cbmonthActionPerformed

    private void cbmonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbmonthMouseClicked

    }//GEN-LAST:event_cbmonthMouseClicked

    private void txt2NDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt2NDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt2NDActionPerformed

    private void txt1STActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1STActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1STActionPerformed

    private void cb1STActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1STActionPerformed
        getFirst = (String) cb1ST.getSelectedItem();
    }//GEN-LAST:event_cb1STActionPerformed

    private void cb1STMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb1STMouseClicked
        if (firstt == 0) {
            cb1ST.removeItemAt(0);
            firstt++;
        }
    }//GEN-LAST:event_cb1STMouseClicked

    private void cb2NDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2NDActionPerformed
        getSec = (String) cb2ND.getSelectedItem();
    }//GEN-LAST:event_cb2NDActionPerformed

    private void cb2NDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb2NDMouseClicked
        if (secondd == 0) {
            cb2ND.removeItemAt(0);
            secondd++;
        } else {

        }
    }//GEN-LAST:event_cb2NDMouseClicked

    private void rbtn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn12ActionPerformed
        gEn = 1;
        gEnroll = ("GRADE 12");
    }//GEN-LAST:event_rbtn12ActionPerformed

    private void rbtn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn11ActionPerformed
        gEn = 1;
        gEnroll = ("GRADE 11");
    }//GEN-LAST:event_rbtn11ActionPerformed

    private void txtfrmSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfrmSIActionPerformed
        gwa = (String) cbGWA.getSelectedItem();
    }//GEN-LAST:event_txtfrmSIActionPerformed

    private void txtfrmSIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfrmSIMousePressed

        if (txtfrmSI.getText().equals("*Required   ") || txtfrmSI.getText().equals("*Numerical values only!   ")) {
            txtfrmSI.setText("");
        }
    }//GEN-LAST:event_txtfrmSIMousePressed

    private void txtfrmSIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfrmSIMouseClicked

        txtfrmSI.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmSI.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmSI.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmSI.getText().equals("*Required   ") || txtfrmSI.getText().equals("*Numerical values only!   ")) {
            txtfrmSI.setText("");
        }
    }//GEN-LAST:event_txtfrmSIMouseClicked

    private void txtfrmSIMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfrmSIMouseDragged
        txtfrmSI.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmSI.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmSI.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmSI.getText().equals("*Required   ") || txtfrmSI.getText().equals("*Numerical values only!   ")) {
            txtfrmSI.setText("");
        }
    }//GEN-LAST:event_txtfrmSIMouseDragged

    private void txtfrmLRNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfrmLRNMousePressed

        txtfrmLRN.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmLRN.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmLRN.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmLRN.getText().equals("*Required   ") || txtfrmLRN.getText().equals("*Numerical values only!   ")) {
            txtfrmLRN.setText("");
        }
    }//GEN-LAST:event_txtfrmLRNMousePressed

    private void txtfrmLRNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfrmLRNMouseClicked

//        txtfrmLRN.setFont(new java.awt.Font("Times New Roman", 0, 14));
//        txtfrmLRN.setForeground(new java.awt.Color(0, 0, 0));
//        txtfrmLRN.setHorizontalAlignment(javax.swing.JTextField.LEADING);
//        if (txtfrmLRN.getText().equals("*Required   ") || txtfrmLRN.getText().equals("*Numerical values only!   ")) {
//            txtfrmLRN.setText("");
//        }
    }//GEN-LAST:event_txtfrmLRNMouseClicked

    private void txtfrmLRNMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfrmLRNMouseDragged

//        txtfrmLRN.setFont(new java.awt.Font("Times New Roman", 0, 14));
//        txtfrmLRN.setForeground(new java.awt.Color(0, 0, 0));
//        txtfrmLRN.setHorizontalAlignment(javax.swing.JTextField.LEADING);
//        if (txtfrmLRN.getText().equals("*Required   ") || txtfrmLRN.getText().equals("*Numerical values only!   ")) {
//            txtfrmLRN.setText("");
//        }
    }//GEN-LAST:event_txtfrmLRNMouseDragged

    private void cbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeActionPerformed
        Tos = (String) cbType.getSelectedItem();
    }//GEN-LAST:event_cbTypeActionPerformed

    private void cbGWAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGWAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGWAActionPerformed

    private void txtfrmLNFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfrmLNFocusGained
        txtfrmLN.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmLN.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmLN.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmLN.getText().equals("*Required   ")) {
            txtfrmLN.setText("");
        }
    }//GEN-LAST:event_txtfrmLNFocusGained

    private void txtfrmFNFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfrmFNFocusGained

        txtfrmFN.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmFN.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmFN.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmFN.getText().equals("*Required   ")) {
            txtfrmFN.setText("");
        }
    }//GEN-LAST:event_txtfrmFNFocusGained

    private void txtfrmCITFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfrmCITFocusGained

        txtfrmCIT.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmCIT.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmCIT.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmCIT.getText().equals("*Required   ")) {
            txtfrmCIT.setText("");
        }
    }//GEN-LAST:event_txtfrmCITFocusGained

    private void txtfrmBPLACEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfrmBPLACEFocusGained

        txtfrmBPLACE.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmBPLACE.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmBPLACE.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmBPLACE.getText().equals("*Required   ")) {
            txtfrmBPLACE.setText("");
        }
    }//GEN-LAST:event_txtfrmBPLACEFocusGained

    private void txtfrmGUARDIANFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfrmGUARDIANFocusGained
        txtfrmGUARDIAN.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmGUARDIAN.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmGUARDIAN.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmGUARDIAN.getText().equals("*Required   ")) {
            txtfrmGUARDIAN.setText("");
        }
    }//GEN-LAST:event_txtfrmGUARDIANFocusGained

    private void txtfrmSLAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfrmSLAFocusGained

        txtfrmSLA.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmSLA.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmSLA.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmSLA.getText().equals("*Required   ")) {
            txtfrmSLA.setText("");
        }
    }//GEN-LAST:event_txtfrmSLAFocusGained

    private void txtfrmYCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfrmYCFocusGained

        txtfrmYC.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmYC.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmYC.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmYC.getText().equals("*   ")) {
            txtfrmYC.setText("");
        }
    }//GEN-LAST:event_txtfrmYCFocusGained

    private void txtfrmSAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfrmSAFocusGained

        txtfrmSA.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmSA.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmSA.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmSA.getText().equals("*Required   ")) {
            txtfrmSA.setText("");
        }
    }//GEN-LAST:event_txtfrmSAFocusGained

    private void txtfrmREGFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfrmREGFocusGained
        txtfrmREG.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmREG.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmREG.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        if (txtfrmREG.getText().equals("*Required   ")) {
            txtfrmREG.setText("");
        }
    }//GEN-LAST:event_txtfrmREGFocusGained

    public void txtfrmVal() {
        for (int ctr = 0; ctr < txtfrmLRN.getText().length(); ctr++) {
            switch (txtfrmLRN.getText().charAt(ctr)) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                case ' ':
                    flag = 0;
                    break;
                default:
                    txtfrmLRN.setFont(new java.awt.Font("Times New Roman", 3, 13));
                    txtfrmLRN.setForeground(new java.awt.Color(255, 0, 51));
                    txtfrmLRN.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                    txtfrmLRN.setText("*Numerical values only!   ");
                    flag = 1;
                    return;
            }
        }

    }

    public void txtfrmlnVAL() {
        switch (txtfrmLN.getText()) {
            case "":
                txtfrmLN.setFont(new java.awt.Font("Times New Roman", 3, 13));
                txtfrmLN.setForeground(new java.awt.Color(255, 0, 51));
                txtfrmLN.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                txtfrmLN.setText("*Required   ");
                flag = 1;
                break;

        }
    }

    public void txtfrmfnVAL() {
        switch (txtfrmFN.getText()) {
            case "":
                txtfrmFN.setFont(new java.awt.Font("Times New Roman", 3, 13));
                txtfrmFN.setForeground(new java.awt.Color(255, 0, 51));
                txtfrmFN.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                txtfrmFN.setText("*Required   ");

                flag = 1;
                break;
            case "*Required   ":
                flag = 1;
                break;
        }
    }

    public void txtfrmageVAL() {
        switch (txtfrmAGE.getText()) {
            case "":
                txtfrmAGE.setFont(new java.awt.Font("Times New Roman", 3, 13));
                txtfrmAGE.setForeground(new java.awt.Color(255, 0, 51));
                txtfrmAGE.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                txtfrmAGE.setText("*   ");

                flag = 1;
                break;
            case "*   ":
                flag = 1;
                break;
        }
    }

    public void txtfrmcitVAL() {
        switch (txtfrmCIT.getText()) {
            case "":
                txtfrmCIT.setFont(new java.awt.Font("Times New Roman", 3, 13));
                txtfrmCIT.setForeground(new java.awt.Color(255, 0, 51));
                txtfrmCIT.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                txtfrmCIT.setText("*Required   ");

                flag = 1;
                break;
            case "*Required   ":
                flag = 1;
                break;
        }
    }

    public void txtfrmtxtfrmbplaceVAL() {
        switch (txtfrmBPLACE.getText()) {
            case "":
                txtfrmBPLACE.setFont(new java.awt.Font("Times New Roman", 3, 13));
                txtfrmBPLACE.setForeground(new java.awt.Color(255, 0, 51));
                txtfrmBPLACE.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                txtfrmBPLACE.setText("*Required   ");

                flag = 1;
                break;
            case "*Required   ":
                flag = 1;
                break;
        }
    }

    public void txtfrmguardVAL() {
        switch (txtfrmGUARDIAN.getText()) {
            case "":
                txtfrmGUARDIAN.setFont(new java.awt.Font("Times New Roman", 3, 13));
                txtfrmGUARDIAN.setForeground(new java.awt.Color(255, 0, 51));
                txtfrmGUARDIAN.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                txtfrmGUARDIAN.setText("*Required   ");

                flag = 1;
                break;
            case "*Required   ":
                flag = 1;
                break;
        }
    }

    public void txtfrmSLAVAL() {
        switch (txtfrmSLA.getText()) {
            case "":
                txtfrmSLA.setFont(new java.awt.Font("Times New Roman", 3, 13));
                txtfrmSLA.setForeground(new java.awt.Color(255, 0, 51));
                txtfrmSLA.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                txtfrmSLA.setText("*Required   ");

                flag = 1;
                break;
            case "*Required   ":
                flag = 1;
                break;
        }
    }

    public void txtfrmycVAL() {
        switch (txtfrmYC.getText()) {
            case "":
                txtfrmYC.setFont(new java.awt.Font("Times New Roman", 3, 13));
                txtfrmYC.setForeground(new java.awt.Color(255, 0, 51));
                txtfrmYC.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                txtfrmYC.setText("*   ");

                flag = 1;
                break;
            case "*   ":
                flag = 1;
                break;
        }
    }

    public void txtfrmSAVAL() {
        switch (txtfrmSA.getText()) {
            case "":
                txtfrmSA.setFont(new java.awt.Font("Times New Roman", 3, 13));
                txtfrmSA.setForeground(new java.awt.Color(255, 0, 51));
                txtfrmSA.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                txtfrmSA.setText("*Required   ");
                flag = 1;
                break;
        }
    }

    public void txtfrmREGVAL() {
        switch (txtfrmREG.getText()) {
            case "":
                txtfrmREG.setFont(new java.awt.Font("Times New Roman", 3, 13));
                txtfrmREG.setForeground(new java.awt.Color(255, 0, 51));
                txtfrmREG.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                txtfrmREG.setText("*Required   ");
                flag = 1;
                break;
            case "*Required   ":
                flag = 1;
                break;
        }
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnrollmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnrollmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnrollmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnrollmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnrollmentForm("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLMHPNHS;
    public static javax.swing.ButtonGroup bgBABA;
    public static javax.swing.ButtonGroup bgGen;
    public static javax.swing.ButtonGroup bgTAAS;
    public static javax.swing.ButtonGroup bgType;
    public static javax.swing.JButton btnfrmCON;
    public static javax.swing.JComboBox<String> cb1ST;
    public static javax.swing.JComboBox<String> cb2ND;
    public javax.swing.JComboBox<String> cbGWA;
    public javax.swing.JComboBox<String> cbType;
    public static javax.swing.JComboBox cbday;
    public static javax.swing.JComboBox cbmonth;
    public static javax.swing.JComboBox cbyear;
    public static javax.swing.JPanel enPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public static javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public final javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    private javax.swing.JTextField jTextField1;
    public javax.swing.JLabel lbl1ST;
    public javax.swing.JLabel lbl2ND;
    private javax.swing.JLabel lblDep;
    private javax.swing.JLabel lblMarceloLogo;
    public static javax.swing.JLabel lblback;
    private javax.swing.JLabel lbldivision;
    private javax.swing.JLabel lbldivision1;
    private javax.swing.JLabel lbldivision2;
    public static javax.swing.JRadioButton rbtn11;
    public static javax.swing.JRadioButton rbtn12;
    public static javax.swing.JRadioButton rbtn13;
    public static javax.swing.JRadioButton rbtn14;
    public static javax.swing.JRadioButton rbtnFem;
    public static javax.swing.JRadioButton rbtnMale;
    public static javax.swing.JRadioButton rbtnPRI;
    public static javax.swing.JRadioButton rbtnPUB;
    public javax.swing.JTextField txt1ST;
    public javax.swing.JTextField txt2ND;
    public javax.swing.JTextField txtApp;
    public javax.swing.JTextField txtBday;
    public javax.swing.JTextField txtGrade;
    public javax.swing.JTextField txtGwa;
    public static javax.swing.JTextField txtfrmAGE;
    public static javax.swing.JTextField txtfrmBPLACE;
    public static javax.swing.JTextField txtfrmCIT;
    public static javax.swing.JTextField txtfrmET;
    public static javax.swing.JTextField txtfrmFATHER;
    public static javax.swing.JTextField txtfrmFN;
    public static javax.swing.JTextField txtfrmGUARDIAN;
    public static javax.swing.JTextField txtfrmLN;
    public static javax.swing.JTextField txtfrmLRN;
    public static javax.swing.JTextField txtfrmMN;
    public static javax.swing.JTextField txtfrmMOTHER;
    public static javax.swing.JTextField txtfrmNN;
    public static javax.swing.JTextField txtfrmOCCF;
    public static javax.swing.JTextField txtfrmOCCG;
    public static javax.swing.JTextField txtfrmOCCM;
    public static javax.swing.JTextField txtfrmPN;
    public static javax.swing.JTextField txtfrmR;
    public static javax.swing.JTextField txtfrmREG;
    public static javax.swing.JTextField txtfrmSA;
    public javax.swing.JTextField txtfrmSI;
    public static javax.swing.JTextField txtfrmSLA;
    public static javax.swing.JTextField txtfrmYC;
    // End of variables declaration//GEN-END:variables
}
