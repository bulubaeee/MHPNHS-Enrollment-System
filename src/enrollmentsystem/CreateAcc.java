package enrollmentsystem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class CreateAcc extends javax.swing.JFrame {

    Connection con;
    int px, py, acc = 0, flag = 0;
    String bdate, month, bday1, pos, sq, sa, gend, username;
    int bmon, bday, byear;
    int date, year, age;
    Calendar cal = Calendar.getInstance();

    public CreateAcc(String user) {
        username = user;
        initComponents();
        this.setVisible(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///dbsoria", "root", "root");

            sq();
            DefaultComboBoxModel model1 = new DefaultComboBoxModel();
            cbday.setModel(model1);

            DefaultComboBoxModel model2 = new DefaultComboBoxModel();
            cbyear.setModel(model2);

            for (int ctr = 1; ctr <= 30; ctr++) {
                model1.addElement(ctr);
            }
            for (int ctr = 2020; ctr >= 1950; ctr--) {
                model2.addElement(ctr);
            }

            month = (String) cbmonth.getSelectedItem();
            pos = (String) cbPos.getSelectedItem();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void Position() throws Exception {

    }

    public void sq() throws Exception {
        DefaultComboBoxModel tmSQ = new DefaultComboBoxModel();
        cbSQ.setModel(tmSQ);
        cbSQ.addItem("What was your first pet`s name?");
        cbSQ.addItem("What`s the name of the city where you were born?");
        cbSQ.addItem("What`s the name of the city where your parents met?");
        cbSQ.addItem("What`s the name of your first Teacher");
        cbSQ.addItem("What`s your favorite Food");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgUser = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        eks = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtmname = new javax.swing.JTextField();
        txtfname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtlname1 = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnUs = new javax.swing.JRadioButton();
        btnAd = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbyear = new javax.swing.JComboBox<>();
        cbSQ = new javax.swing.JComboBox<>();
        cbday = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbmonth = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbPos = new javax.swing.JComboBox<>();
        txtNum = new javax.swing.JTextField();
        txtSa = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        pnlborderrighgt3 = new javax.swing.JPanel();
        pnlborderrighgt4 = new javax.swing.JPanel();
        pnlborderrighgt5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        rbtnF = new javax.swing.JRadioButton();
        rbtnM = new javax.swing.JRadioButton();

        bgUser.add(btnAd);
        bgUser.add(btnUs);

        jScrollPane1.setViewportView(jTextPane1);

        buttonGroup1.add(rbtnF);
        buttonGroup1.add(rbtnM);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(50, 100, 49));
        jPanel3.setLayout(null);

        eks.setBackground(new java.awt.Color(255, 255, 255));
        eks.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        eks.setForeground(new java.awt.Color(255, 255, 255));
        eks.setText("x");
        eks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eksMouseExited(evt);
            }
        });
        jPanel3.add(eks);
        eks.setBounds(6, 0, 13, 32);

        min.setBackground(new java.awt.Color(255, 255, 255));
        min.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        min.setForeground(new java.awt.Color(255, 255, 255));
        min.setText("-");
        min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minMouseExited(evt);
            }
        });
        jPanel3.add(min);
        min.setBounds(10, 40, 8, 32);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(1230, 0, 30, 730);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(50, 104, 50));
        jPanel1.setLayout(null);

        txtUser.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.setBorder(null);
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel1.add(txtUser);
        txtUser.setBounds(210, 390, 390, 40);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(210, 280, 219, 18);

        txtmname.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtmname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmname.setBorder(null);
        jPanel1.add(txtmname);
        txtmname.setBounds(210, 310, 390, 40);

        txtfname.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtfname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfname.setBorder(null);
        jPanel1.add(txtfname);
        txtfname.setBounds(210, 230, 390, 40);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel11.setText("Create Account");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(520, 20, 280, 60);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setText("First name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 240, 107, 26);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setText("Middle name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 320, 126, 26);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel2.setText("Last name:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 160, 105, 26);

        txtlname1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtlname1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtlname1.setBorder(null);
        txtlname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlname1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtlname1);
        txtlname1.setBounds(210, 150, 390, 40);

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAdd.setText("Continue");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);
        btnAdd.setBounds(550, 630, 200, 50);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(210, 200, 219, 18);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(210, 440, 219, 18);

        jPanel4.setBackground(new java.awt.Color(50, 100, 49));
        jPanel4.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel12.setText("User Log In");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(130, 30, 220, 60);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(210, 430, 390, 2);

        jPanel5.setBackground(new java.awt.Color(50, 100, 49));
        jPanel5.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel13.setText("User Log In");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(130, 30, 220, 60);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(210, 190, 390, 2);

        jPanel7.setBackground(new java.awt.Color(50, 100, 49));
        jPanel7.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel15.setText("User Log In");
        jPanel7.add(jLabel15);
        jLabel15.setBounds(130, 30, 220, 60);

        jPanel1.add(jPanel7);
        jPanel7.setBounds(210, 270, 390, 2);

        jPanel8.setBackground(new java.awt.Color(50, 100, 49));
        jPanel8.setLayout(null);

        jLabel16.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel16.setText("User Log In");
        jPanel8.add(jLabel16);
        jLabel16.setBounds(130, 30, 220, 60);

        jPanel1.add(jPanel8);
        jPanel8.setBounds(210, 350, 390, 2);

        btnUs.setBackground(new java.awt.Color(255, 255, 255));
        btnUs.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnUs.setText("User");
        btnUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsActionPerformed(evt);
            }
        });
        jPanel1.add(btnUs);
        btnUs.setBounds(670, 70, 100, 35);

        btnAd.setBackground(new java.awt.Color(255, 255, 255));
        btnAd.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnAd.setText("Admin");
        btnAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdActionPerformed(evt);
            }
        });
        jPanel1.add(btnAd);
        btnAd.setBounds(540, 70, 100, 35);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel7.setText("Secret Question:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(640, 400, 190, 30);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel14.setText("Username:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(80, 400, 110, 30);

        cbyear.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbyearActionPerformed(evt);
            }
        });
        jPanel1.add(cbyear);
        cbyear.setBounds(490, 470, 110, 30);

        cbSQ.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbSQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSQActionPerformed(evt);
            }
        });
        jPanel1.add(cbSQ);
        cbSQ.setBounds(820, 400, 380, 30);

        cbday.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdayActionPerformed(evt);
            }
        });
        jPanel1.add(cbday);
        cbday.setBounds(390, 470, 90, 30);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel17.setText("Age:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(140, 540, 70, 30);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel18.setText("Gender:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(710, 250, 90, 30);

        cbmonth.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbmonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbmonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmonthActionPerformed(evt);
            }
        });
        jPanel1.add(cbmonth);
        cbmonth.setBounds(210, 470, 170, 30);

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel19.setText("Designagtion:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(670, 330, 140, 30);

        cbPos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbPos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teacher I", "Teacher II", "Teacher III", "Master Teacher I", "Master Teacher II", "Master Teacher III", "Special Science Teacher I", "Registrar I", "Registrar II", "Registrar II", "Registrar IV", "Administrator", "Administrative officer II", "Administrative Staff ", "Office Staff", "Principal", "Assistant Principal", "Other" }));
        cbPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPosActionPerformed(evt);
            }
        });
        jPanel1.add(cbPos);
        cbPos.setBounds(830, 330, 250, 30);

        txtNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNum.setBorder(null);
        jPanel1.add(txtNum);
        txtNum.setBounds(840, 170, 250, 30);

        txtSa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSa.setBorder(null);
        jPanel1.add(txtSa);
        txtSa.setBounds(820, 450, 370, 30);

        txtAge.setEditable(false);
        txtAge.setBackground(new java.awt.Color(255, 255, 255));
        txtAge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAge.setBorder(null);
        jPanel1.add(txtAge);
        txtAge.setBounds(210, 540, 80, 30);

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel20.setText("Birth Date:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(80, 470, 110, 30);

        jPanel6.setBackground(new java.awt.Color(50, 100, 49));
        jPanel6.setLayout(null);

        jLabel21.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel21.setText("User Log In");
        jPanel6.add(jLabel21);
        jLabel21.setBounds(130, 30, 220, 60);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(210, 570, 80, 2);

        jPanel10.setBackground(new java.awt.Color(50, 100, 49));
        jPanel10.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel23.setText("User Log In");
        jPanel10.add(jLabel23);
        jLabel23.setBounds(130, 30, 220, 60);

        jPanel1.add(jPanel10);
        jPanel10.setBounds(840, 200, 250, 2);

        jPanel11.setBackground(new java.awt.Color(50, 100, 49));
        jPanel11.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel24.setText("User Log In");
        jPanel11.add(jLabel24);
        jLabel24.setBounds(130, 30, 220, 60);

        jPanel1.add(jPanel11);
        jPanel11.setBounds(820, 480, 370, 2);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel12);
        jPanel12.setBounds(510, 30, 280, 40);

        pnlborderrighgt3.setBackground(new java.awt.Color(50, 100, 49));

        javax.swing.GroupLayout pnlborderrighgt3Layout = new javax.swing.GroupLayout(pnlborderrighgt3);
        pnlborderrighgt3.setLayout(pnlborderrighgt3Layout);
        pnlborderrighgt3Layout.setHorizontalGroup(
            pnlborderrighgt3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1230, Short.MAX_VALUE)
        );
        pnlborderrighgt3Layout.setVerticalGroup(
            pnlborderrighgt3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel1.add(pnlborderrighgt3);
        pnlborderrighgt3.setBounds(0, 720, 1230, 3);

        pnlborderrighgt4.setBackground(new java.awt.Color(50, 100, 49));
        pnlborderrighgt4.setForeground(new java.awt.Color(50, 104, 50));

        javax.swing.GroupLayout pnlborderrighgt4Layout = new javax.swing.GroupLayout(pnlborderrighgt4);
        pnlborderrighgt4.setLayout(pnlborderrighgt4Layout);
        pnlborderrighgt4Layout.setHorizontalGroup(
            pnlborderrighgt4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        pnlborderrighgt4Layout.setVerticalGroup(
            pnlborderrighgt4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );

        jPanel1.add(pnlborderrighgt4);
        pnlborderrighgt4.setBounds(0, 0, 3, 920);

        pnlborderrighgt5.setBackground(new java.awt.Color(50, 100, 49));
        pnlborderrighgt5.setForeground(new java.awt.Color(50, 104, 50));

        javax.swing.GroupLayout pnlborderrighgt5Layout = new javax.swing.GroupLayout(pnlborderrighgt5);
        pnlborderrighgt5.setLayout(pnlborderrighgt5Layout);
        pnlborderrighgt5Layout.setHorizontalGroup(
            pnlborderrighgt5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1270, Short.MAX_VALUE)
        );
        pnlborderrighgt5Layout.setVerticalGroup(
            pnlborderrighgt5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel1.add(pnlborderrighgt5);
        pnlborderrighgt5.setBounds(-40, 0, 1270, 3);

        jLabel1.setText("Already have an account? ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(540, 690, 150, 20);
        jLabel1.setVisible(false);

        jLabel5.setForeground(new java.awt.Color(51, 204, 255));
        jLabel5.setText("Sign in");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(690, 690, 50, 20);
        jLabel5.setVisible(false);

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel25.setText("Contact #:");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(690, 170, 98, 30);

        rbtnF.setBackground(new java.awt.Color(255, 255, 255));
        rbtnF.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        rbtnF.setText("Female");
        rbtnF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnF);
        rbtnF.setBounds(930, 250, 107, 33);

        rbtnM.setBackground(new java.awt.Color(255, 255, 255));
        rbtnM.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        rbtnM.setText("Male");
        rbtnM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnM);
        rbtnM.setBounds(830, 250, 100, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1230, 730);

        setSize(new java.awt.Dimension(1259, 723));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        sa = txtSa.getText().trim();
        String cont = txtNum.getText();

        try {
            int flag = 0;
            if (txtfname.getText().equals("")) {
                jLabel9.setText("Field must not be blank");
                jLabel9.setForeground(Color.RED);
                jLabel9.setVisible(true);
            } else {
                jLabel9.setVisible(false);
            }
            if (txtlname1.getText().equals("")) {
                jLabel10.setText("Field must not be blank");
                jLabel10.setForeground(Color.RED);
                jLabel10.setVisible(true);
            } else {
                jLabel10.setVisible(false);
            }

            if (txtUser.getText().equals("")) {
                jLabel8.setText("Field must not be blank");
                jLabel8.setForeground(Color.RED);
                jLabel8.setVisible(true);
            } else {
                jLabel8.setVisible(false);
            }

            if (txtUser.getText().equals("") || txtfname.getText().equals("") || txtlname1.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please fill up empty fields!");
                return;
            }

            if (acc == 3) {
                JOptionPane.showMessageDialog(null, "please select Account!");
                return;
            }

            if (btnUs.isSelected() == false && btnAd.isSelected() == false) {
                JOptionPane.showMessageDialog(null, "Please select Admin/user");
                return;
            }

            for (int ctr = 0; ctr < txtlname1.getText().length(); ctr++) {
                switch (txtlname1.getText().toLowerCase().charAt(ctr)) {
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                    case 'g':
                    case 'h':
                    case 'i':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'm':
                    case 'n':
                    case 'o':
                    case 'p':
                    case 'q':
                    case 'r':
                    case 's':
                    case 't':
                    case 'u':
                    case 'v':
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
                    case ' ':
                    case '.':
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Last name mus`nt Contain Special Characters!");
                        return;
                }
            }

            for (int ctr = 0; ctr < txtfname.getText().length(); ctr++) {
                switch (txtfname.getText().toLowerCase().charAt(ctr)) {
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                    case 'g':
                    case 'h':
                    case 'i':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'm':
                    case 'n':
                    case 'o':
                    case 'p':
                    case 'q':
                    case 'r':
                    case 's':
                    case 't':
                    case 'u':
                    case 'v':
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
                    case ' ':
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "First name mus`nt Contain Special Characters!");
                        return;
                }
            }

            for (int ctr = 0; ctr < txtmname.getText().length(); ctr++) {
                switch (txtmname.getText().toLowerCase().charAt(ctr)) {
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                    case 'g':
                    case 'h':
                    case 'i':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'm':
                    case 'n':
                    case 'o':
                    case 'p':
                    case 'q':
                    case 'r':
                    case 's':
                    case 't':
                    case 'u':
                    case 'v':
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
                    case ' ':
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, " Middle name must not Contain Special Characters!");
                        return;
                }
            }

            for (int ctr = 0; ctr < txtUser.getText().length(); ctr++) {
                switch (txtUser.getText().toLowerCase().charAt(ctr)) {
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                    case 'g':
                    case 'h':
                    case 'i':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'm':
                    case 'n':
                    case 'o':
                    case 'p':
                    case 'q':
                    case 'r':
                    case 's':
                    case 't':
                    case 'u':
                    case 'v':
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
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
                    case '_':
                    case ' ':
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Username must contain Alphanumerical Characters only!");
                        return;
                }
            }

            if (age <= 0) {
                JOptionPane.showMessageDialog(null, "Please Fillup Empty Fields!");
                return;
            } else {
                bday1 = month + " " + date + ", " + year;
            }

            if (sa.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Fillup Empty Fields!");
                return;
            }

            if (flag == 0) {
                //Statement st = con.createStatement();
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                st.executeUpdate("insert into tblacc(username,password,signed,first,blocked,attempts,firstname,middlename,lastname,admin,bday,age,secret_question,answer,contact,gender,position)"
                        + " values ('" + txtUser.getText().trim() + "',aes_encrypt('" + txtUser.getText().trim() + "','key'),0,0,0,0,'" + txtfname.getText().trim() + "','"
                        + txtmname.getText().trim() + "','" + txtlname1.getText().trim() + "'," + acc + ",'" + bday1
                        + "'," + age + ",'" + sq + "','" + sa + "','" + cont + "','" + gend + "','" + pos + "')");

                //Statement st2 = con.createStatement();
                Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                st2.executeUpdate("insert into tbltm(fname,mname,lname,desig) values('" + txtfname.getText() + "','" + txtmname.getText() + "','" + txtlname1.getText() + "','" + pos + "')");
                new TableAccounts(username).setVisible(true);
                System.out.println(gend);
                this.dispose();
            }
            System.out.println(bday1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Username already registered!");
            System.err.println(e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void eksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eksMouseClicked
        try {
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from poweruser");
            rs.absolute(1);
            if (rs.getString("pu").equals("1")) {
                new TableAccounts(username).setVisible(true);
            } else {
                this.dispose();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_eksMouseClicked

    private void eksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eksMouseEntered
        eks.setForeground(java.awt.Color.GRAY);
    }//GEN-LAST:event_eksMouseEntered

    private void eksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eksMouseExited
        eks.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_eksMouseExited

    private void minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseClicked
        this.setState(TableAccounts.ICONIFIED);
    }//GEN-LAST:event_minMouseClicked

    private void minMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseEntered
        min.setForeground(java.awt.Color.gray);
    }//GEN-LAST:event_minMouseEntered

    private void minMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseExited
        min.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_minMouseExited

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdActionPerformed
        acc = 1;
    }//GEN-LAST:event_btnAdActionPerformed

    private void btnUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsActionPerformed
        acc = 0;
    }//GEN-LAST:event_btnUsActionPerformed

    private void cbmonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmonthActionPerformed
        String m = (String) cbmonth.getSelectedItem();
        month = (String) cbmonth.getSelectedItem();

        if (m.equals("September") || m.equals("April") || m.equals("June") || m.equals("November")) {
            cbday.removeAllItems();
            for (int ctr = 1; ctr <= 30; ctr++) {
                cbday.addItem(ctr + "");
            }
        } else if (m.equals("February")) {

            if ((byear % 400 == 0) || (byear % 4 == 0) && (byear % 100 != 0)) {
                cbday.removeAllItems();
                for (int ctr = 1; ctr <= 29; ctr++) {
                    cbday.addItem(ctr + "");
                }
            } else {

                cbday.removeAllItems();
                for (int ctr = 1; ctr <= 28; ctr++) {
                    cbday.addItem(ctr + "");
                }
            }

        } else {
            cbday.removeAllItems();
            for (int ctr = 1; ctr <= 31; ctr++) {
                cbday.addItem(ctr + "");
            }
        }
        compute();
        txtAge.setText(age + "");
    }//GEN-LAST:event_cbmonthActionPerformed

    private void cbdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdayActionPerformed
        try {
            date = (int) cbday.getSelectedItem();
            compute();
            txtAge.setText(age + "");
        } catch (Exception e) {
            // System.err.println(e);
        }
    }//GEN-LAST:event_cbdayActionPerformed

    private void cbyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbyearActionPerformed
        byear = (int) cbyear.getSelectedItem();
        year = (int) cbyear.getSelectedItem();

        String m = (String) cbmonth.getSelectedItem();
        if (m.equals("February")) {
            if ((byear % 400 == 0) || (byear % 4 == 0) && (byear % 100 != 0)) {
                flag = 1;
                cbday.removeAllItems();
                for (int ctr = 1; ctr <= 29; ctr++) {
                    cbday.addItem(ctr + "");
                }
            } else {
                cbday.removeAllItems();
                for (int ctr = 1; ctr <= 28; ctr++) {
                    cbday.addItem(ctr + "");
                }
//                flag = 0;
            }

        } else if (m.equals("September") || m.equals("April") || m.equals("June") || m.equals("November")) {
            cbday.removeAllItems();
            for (int ctr = 1; ctr <= 30; ctr++) {
                cbday.addItem(ctr + "");
            }
        } else {
            for (int ctr = 1; ctr <= 31; ctr++) {
                cbday.addItem(ctr + "");
            }
        }

        compute();
        txtAge.setText(age + "");
    }//GEN-LAST:event_cbyearActionPerformed

    private void cbPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPosActionPerformed
        pos = (String) cbPos.getSelectedItem();
    }//GEN-LAST:event_cbPosActionPerformed

    private void cbSQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSQActionPerformed
        sq = (String) cbSQ.getSelectedItem();
    }//GEN-LAST:event_cbSQActionPerformed

    private void txtlname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlname1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();
        new LogIn().setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void rbtnMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMActionPerformed
        gend = "Male";
    }//GEN-LAST:event_rbtnMActionPerformed

    private void rbtnFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFActionPerformed
        gend = "Female";
    }//GEN-LAST:event_rbtnFActionPerformed

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
            System.err.println(e);
        }
        return age;
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
            java.util.logging.Logger.getLogger(CreateAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAcc("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgUser;
    private javax.swing.JRadioButton btnAd;
    private javax.swing.JButton btnAdd;
    private javax.swing.JRadioButton btnUs;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbPos;
    private javax.swing.JComboBox<String> cbSQ;
    private javax.swing.JComboBox<String> cbday;
    private javax.swing.JComboBox<String> cbmonth;
    private javax.swing.JComboBox<String> cbyear;
    private javax.swing.JLabel eks;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel min;
    private javax.swing.JPanel pnlborderrighgt3;
    private javax.swing.JPanel pnlborderrighgt4;
    private javax.swing.JPanel pnlborderrighgt5;
    private javax.swing.JRadioButton rbtnF;
    private javax.swing.JRadioButton rbtnM;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtSa;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname1;
    private javax.swing.JTextField txtmname;
    // End of variables declaration//GEN-END:variables
}
