package enrollmentsystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class enFormView extends EnrollmentForm {

    String fullname;
    Connection con;
    String type;
    String grade, gender;

    public enFormView(String user) {
        super(user);
    }

    public enFormView() {

        super("");
        initComponents();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///dbsoria", "root", "root");
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from tblrc;");

            View();
        } catch (Exception e) {
            System.err.println(e);
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEd = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblEFormNote = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEd.setBackground(new java.awt.Color(255, 255, 255));
        btnEd.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnEd.setText("Edit");
        btnEd.setAlignmentY(0.0F);
        btnEd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(255, 255, 255));
        btnPrint.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnPrint.setText("Save as PDF");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnUp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUp.setText("Update");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblEFormNote.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        lblEFormNote.setText("Please save this file in Legal size Paper");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(lblEFormNote, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEd, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrint)
                            .addComponent(btnEd)
                            .addComponent(lblEFormNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(940, 940, 940)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                pf.setOrientation(PageFormat.PORTRAIT);
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) pg;
                g2.translate(pf.getImageableX() + 20, pf.getImageableY() + 20);
                g2.scale(0.570, 0.590);

                enPanel.paint(g2);
                return Printable.PAGE_EXISTS;

            }
        });

        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (Exception e) {
                System.err.println(e);
            }
        }


    }//GEN-LAST:event_btnPrintActionPerformed
    public void View() {

        try {

            if (Profile.acc == 1) {
                btnEd.setVisible(true);
            } else {
                btnEd.setVisible(false);
                lblEFormNote.setVisible(false);
            }

            lblback.setVisible(true);
            btnfrmCON.setVisible(false);
            btnUp.setVisible(false);
            btnBack.setVisible(false);
            btnPrint.setVisible(true);

            cbGWA.setVisible(false);
            txtGwa.setVisible(true);
            cbType.setVisible(false);
            txtApp.setVisible(true);

            cb1ST.setVisible(false);
            lbl1ST.setVisible(true);
            txt1ST.setVisible(true);
            cb2ND.setVisible(false);
            lbl2ND.setVisible(true);
            txt2ND.setVisible(true);
            cbmonth.setVisible(false);
            cbday.setVisible(false);
            cbyear.setVisible(false);
            txtBday.setVisible(true);

            txtfrmLRN.setEditable(false);
            txtfrmSI.setEditable(false);
            txt1ST.setEditable(false);
            txt2ND.setEditable(false);
            txtBday.setEditable(false);

            txtfrmLN.setEditable(false);
            txtfrmFN.setEditable(false);
            txtfrmMN.setEditable(false);
            txtfrmNN.setEditable(false);
            txtfrmR.setEditable(false);
            txtfrmCIT.setEditable(false);
            txtfrmBPLACE.setEditable(false);
            txtfrmFATHER.setEditable(false);
            txtfrmOCCF.setEditable(false);
            txtfrmMOTHER.setEditable(false);
            txtfrmOCCM.setEditable(false);
            txtfrmGUARDIAN.setEditable(false);
            txtfrmOCCG.setEditable(false);
            txtfrmSLA.setEditable(false);
            txtfrmYC.setEditable(false);
            txtfrmSA.setEditable(false);
            txtfrmREG.setEditable(false);
            txtfrmPN.setEditable(false);
            txtfrmET.setEditable(false);

            rbtn11.setEnabled(false);
            rbtn11.setForeground(Color.black);
            rbtn12.setEnabled(false);
            rbtn12.setForeground(Color.black);
            rbtn13.setEnabled(false);
            rbtn13.setForeground(Color.black);
            rbtn14.setEnabled(false);
            rbtn14.setForeground(Color.black);
            rbtnMale.setEnabled(false);
            rbtnMale.setForeground(Color.black);
            rbtnFem.setEnabled(false);
            rbtnFem.setForeground(Color.black);

            rbtnPUB.setEnabled(false);
            rbtnPUB.setForeground(Color.black);
            rbtnPRI.setEnabled(false);
            rbtnPRI.setForeground(Color.black);

            String x = Profile.idSaTable + "";
           // Statement st = con.createStatement();
           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id;");

            int g = 0;
            String mi = "".toUpperCase();
            while (rs.next()) {
                if (rs.getString("id").equals(x)) {
                    int ctr = 0;
                    if (rs.getString("mname").length() != 0) {
                        mi = rs.getString("mname").toUpperCase().charAt(0) + ".";
                    }
                    while (ctr < rs.getString("mname").length()) {
                        switch (rs.getString("mname").charAt(ctr)) {
                            case ' ':
                                mi = mi + rs.getString("mname").charAt(ctr + 1) + ".";
                                break;
                        }
                        ctr++;
                    }
                }

                if (rs.getString("id").equals(x)) {
                    txt1ST.setText(rs.getString("fchoice"));
                    txt2ND.setText(rs.getString("schoice"));
                    txtBday.setText(rs.getString("bdate"));

                    String bday = rs.getString("bdate");

                    cbGWA.setSelectedItem(rs.getString("gwa"));

                    Scanner scan = new Scanner(bday);
                    while (scan.hasNext()) {
                        cbmonth.setSelectedItem(scan.next());
                        String toy = scan.next();
                        toy = toy.substring(0, toy.length() - 1);
                        cbday.setSelectedItem(Integer.parseInt(toy));
                        cbyear.setSelectedItem(Integer.parseInt(scan.next()));

                    }

                    txtfrmLRN.setText(rs.getString("lrn"));
                    txtfrmSI.setText(rs.getString("school_id"));
                    txtApp.setText(rs.getString("student_type"));

                    if (rs.getString("gwa").equals("")) {
                        System.out.println("hehe");
                        txtGwa.setText("N/A");
                    } else {
                        txtGwa.setText(rs.getString("gwa"));
                    }

                    cb1ST.setSelectedItem(rs.getString("fchoice"));
                    cb2ND.setSelectedItem(rs.getString("schoice"));
                    txtfrmLN.setText(rs.getString("lname"));
                    txtfrmFN.setText(rs.getString("fname"));
                    txtfrmMN.setText(rs.getString("mname"));
                    txtfrmNN.setText(rs.getString("nname"));
                    txtfrmR.setText(rs.getString("religion"));
                    txtfrmCIT.setText(rs.getString("citizenship"));
                    txtfrmBPLACE.setText(rs.getString("bplace"));
                    txtfrmFATHER.setText(rs.getString("fathername"));
                    txtfrmOCCF.setText(rs.getString("fatheroccu"));
                    txtfrmMOTHER.setText(rs.getString("mothername"));
                    txtfrmOCCM.setText(rs.getString("motheroccu"));
                    txtfrmGUARDIAN.setText(rs.getString("guardianname"));
                    txtfrmOCCG.setText(rs.getString("guardianoccu"));
                    txtfrmSLA.setText(rs.getString("nolsa"));
                    txtfrmYC.setText(rs.getString("yearcom"));
                    txtfrmSA.setText(rs.getString("schl_add"));
                    txtfrmREG.setText(rs.getString("reg"));
                    txtfrmPN.setText(rs.getString("fname").toUpperCase() + " " + mi + " " + rs.getString("lname").toUpperCase());
                    txtfrmET.setText(rs.getString("et"));

                    String gen = rs.getString("gender");
                    if (gen.equals("Male")) {
                        rbtnMale.setSelected(true);
                    } else {
                        rbtnFem.setSelected(true);
                    }

                    String type = rs.getString("tos");
                    if (type.equals("Public")) {
                        rbtnPUB.setSelected(true);
                    } else {
                        rbtnPRI.setSelected(true);
                    }

                    grade = rs.getString("eag");

                    if (grade.equals("GRADE 11")) {
                        prevG = "GRADE 11";
                        rbtn11.setSelected(true);
                        rbtn13.setSelected(true);
                    } else {
                        prevG = "GRADE 12";
                        rbtn14.setSelected(true);
                        rbtn12.setSelected(true);
                    }
                }
            }

            fullname = txtfrmFN.getText() + " " + txtfrmMN.getText() + " " + txtfrmLN.getText();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    private void btnEdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdActionPerformed
        try {
            lblback.setVisible(false);
            btnPrint.setVisible(false);
            btnEd.setVisible(false);
            btnUp.setVisible(true);
            btnBack.setVisible(true);

           // Profile p = new Profile("");
           // Statement st = con.createStatement();
           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id;");
            //rs.absolute(Profile.id);

            cbGWA.setVisible(true);

            txtGwa.setVisible(false);
//            cbType.setVisible(true);
//            txtApp.setVisible(false);

            cb1ST.setVisible(true);
            lbl1ST.setVisible(true);
            txt1ST.setVisible(false);
            cb2ND.setVisible(true);
            lbl2ND.setVisible(true);
            txt2ND.setVisible(false);
            cbmonth.setVisible(true);
            cbday.setVisible(true);
            cbyear.setVisible(true);
            txtBday.setVisible(false);

            txtfrmLRN.setEditable(true);
            txtfrmSI.setEditable(true);
            txt1ST.setEditable(true);
            txt2ND.setEditable(true);
            txtBday.setEditable(true);

            txtfrmLN.setEditable(true);
            txtfrmFN.setEditable(true);
            txtfrmMN.setEditable(true);
            txtfrmNN.setEditable(true);
            txtfrmR.setEditable(true);
            txtfrmCIT.setEditable(true);
            txtfrmBPLACE.setEditable(true);
            txtfrmFATHER.setEditable(true);
            txtfrmOCCF.setEditable(true);
            txtfrmMOTHER.setEditable(true);
            txtfrmOCCM.setEditable(true);
            txtfrmGUARDIAN.setEditable(true);
            txtfrmOCCG.setEditable(true);
            txtfrmSLA.setEditable(true);
            txtfrmYC.setEditable(true);
            txtfrmSA.setEditable(true);
            txtfrmREG.setEditable(true);
            txtfrmET.setEditable(true);

            rbtn11.setEnabled(true);
            rbtn11.setForeground(Color.black);
            rbtn12.setEnabled(true);
            rbtn12.setForeground(Color.black);
            rbtn13.setEnabled(true);
            rbtn13.setForeground(Color.black);
            rbtn14.setEnabled(true);
            rbtn14.setForeground(Color.black);
            rbtnMale.setEnabled(true);
            rbtnMale.setForeground(Color.black);
            rbtnFem.setEnabled(true);
            rbtnFem.setForeground(Color.black);

            rbtnPUB.setEnabled(true);
            rbtnPUB.setForeground(Color.black);
            rbtnPRI.setEnabled(true);
            rbtnPRI.setForeground(Color.black);

            if (rbtnMale.isSelected()) {
                gend = "Male";
            } else {
                gend = "Female";
            }

//            rbtn11.setVisible(false);
//            rbtn12.setVisible(false);
//            txtGrade.setText(rs.getString("eag"));
            int g = 0;

            while (rs.next()) {
                if (rs.getString("id").equals(Profile.idSaTable)) {
                    String bday = rs.getString("bdate");
                    Scanner scan = new Scanner(bday);

                    while (scan.hasNext()) {
                        cbmonth.setSelectedItem(scan.next());
                        String toy = scan.next();
                        toy = toy.substring(0, toy.length() - 1);
                        cbday.setSelectedItem(Integer.parseInt(toy));
                        cbyear.setSelectedItem(Integer.parseInt(scan.next()));
                    }

                    txtfrmLRN.setText(rs.getString("lrn"));
                    txtfrmSI.setText(rs.getString("school_id"));
                    cb1ST.setSelectedItem(rs.getString("fchoice"));
                    cb2ND.setSelectedItem(rs.getString("schoice"));
                    txtfrmLN.setText(rs.getString("lname"));
                    txtfrmFN.setText(rs.getString("fname"));
                    txtfrmMN.setText(rs.getString("mname"));
                    txtfrmNN.setText(rs.getString("nname"));
                    txtfrmR.setText(rs.getString("religion"));
                    txtfrmCIT.setText(rs.getString("citizenship"));
                    txtfrmBPLACE.setText(rs.getString("bplace"));
                    txtfrmFATHER.setText(rs.getString("fathername"));
                    txtfrmOCCF.setText(rs.getString("fatheroccu"));
                    txtfrmMOTHER.setText(rs.getString("mothername"));
                    txtfrmOCCM.setText(rs.getString("motheroccu"));
                    txtfrmGUARDIAN.setText(rs.getString("guardianname"));
                    txtfrmOCCG.setText(rs.getString("guardianoccu"));
                    txtfrmSLA.setText(rs.getString("nolsa"));
                    txtfrmYC.setText(rs.getString("yearcom"));
                    txtfrmSA.setText(rs.getString("schl_add"));
                    txtfrmREG.setText(rs.getString("reg"));
                    txtfrmPN.setText(rs.getString("pname"));
                    txtfrmET.setText(rs.getString("et"));

                    String gen = rs.getString("gender");
                    if (gen.equals("Male")) {
                        rbtnMale.setSelected(true);
                    } else {
                        rbtnFem.setSelected(true);
                    }

                    type = rs.getString("tos");
                    if (type.equals("Public")) {
                        rbtnPUB.setSelected(true);
                    } else {
                        rbtnPRI.setSelected(true);
                    }

                    String grade = rs.getString("eag");

                    if (grade.equals("GRADE 11")) {
                        rbtn11.setSelected(true);
                        rbtn13.setSelected(true);
                    } else {
                        rbtn14.setSelected(true);
                        rbtn12.setSelected(true);
                    }

                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnEdActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        View();
        txtfrmLRN.setFont(new java.awt.Font("Times New Roman", 0, 14));
        txtfrmLRN.setForeground(new java.awt.Color(0, 0, 0));
        txtfrmLRN.setHorizontalAlignment(javax.swing.JTextField.LEADING);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed

        try {
            String gwa = (String) cbGWA.getSelectedItem();

            if (gwa.equals("N/A")) {
                gwa = "";
                System.out.println("hehe");
            }

            String id = Profile.idSaTable + "";

            String bday = "" + cbmonth.getSelectedItem() + " " + cbday.getSelectedItem() + ", " + cbyear.getSelectedItem();
            System.out.print(bday + "eto");
           // Statement st = con.createStatement();
           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

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

            if (txtfrmFATHER.getText().equals("")) {
                txtfrmOCCF.setText("");
            }
            if (txtfrmMOTHER.getText().equals("")) {
                txtfrmOCCM.setText("");
            }

            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "please fill the fields with the correct values");
                return;
            } else {
                if (getFirst.equals(getSec)) {
                    JOptionPane.showMessageDialog(null, "First Choice and Second Choice Mustn`t the same!", "PLEASE SELECT NEW!", tS);
                    return;
                }

                if (age < 14) {
                    JOptionPane.showMessageDialog(null, "Your age is not qualified for Senior High School!", "Message", 1);
                    return;
                }

                //HANGGANG DITO ANG VALIDATION
                st.executeUpdate("update tblprof set lrn = '" + txtfrmLRN.getText() + "', school_id = '" + txtfrmSI.getText()
                        + "', fchoice = '" + getFirst + "', schoice = '" + getSec + "' where id = " + id);

                st.executeUpdate("update tblprofperinfo set lname ='" + txtfrmLN.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofperinfo set fname ='" + txtfrmFN.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofperinfo set mname ='" + txtfrmMN.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofperinfo set nname ='" + txtfrmNN.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofperinfo set bdate ='" + bday + "' where id = " + id);
                st.executeUpdate("update tblprofperinfo set age ='" + txtfrmAGE.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofperinfo set religion ='" + txtfrmR.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofperinfo set citizenship ='" + txtfrmCIT.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofperinfo set bplace ='" + txtfrmBPLACE.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofperinfo set gender = '" + gend + "' where id = " + id);
                st.executeUpdate("update tblprofperinfo set gwa ='" + gwa + "' where id = " + id);
                st.executeUpdate("update tblproffaminfo set fathername ='" + txtfrmFATHER.getText() + "' where id = " + id);
                st.executeUpdate("update tblproffaminfo set mothername ='" + txtfrmMOTHER.getText() + "' where id = " + id);
                st.executeUpdate("update tblproffaminfo set fatheroccu ='" + txtfrmOCCF.getText() + "' where id = " + id);
                st.executeUpdate("update tblproffaminfo set motheroccu ='" + txtfrmOCCM.getText() + "' where id = " + id);
                st.executeUpdate("update tblproffaminfo set guardianname ='" + txtfrmGUARDIAN.getText() + "' where id = " + id);
                st.executeUpdate("update tblproffaminfo set guardianoccu ='" + txtfrmOCCG.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofacadinfo set nolsa ='" + txtfrmSLA.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofacadinfo set yearcom ='" + txtfrmYC.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofacadinfo set schl_add ='" + txtfrmSA.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofacadinfo set reg ='" + txtfrmREG.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofacadinfo set eag ='" + prevG + "' where id = " + id);
                st.executeUpdate("update tblprofacadinfo set et ='" + txtfrmET.getText() + "' where id = " + id);
                st.executeUpdate("update tblprofacadinfo set tos ='" + tSchool + "' where id = " + id); //Tinamad kaming gawin yung maiksi

//                new Profile(Profile.user).setVisible(true);
                System.out.println(Profile.user);
                JOptionPane.showMessageDialog(null, "Success!");
                View();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnUpActionPerformed

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
            java.util.logging.Logger.getLogger(enFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(enFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(enFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(enFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new enFormView("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    public static javax.swing.JButton btnEd;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnUp;
    private javax.swing.JLabel lblEFormNote;
    // End of variables declaration//GEN-END:variables
}
