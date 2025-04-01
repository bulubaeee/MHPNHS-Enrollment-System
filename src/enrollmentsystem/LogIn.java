package enrollmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.DatabaseMetaData;

public class LogIn extends javax.swing.JFrame {

    int pinindot = 0;
    Connection con;
    int block = 0;
    String y;
    int px, py, px1, py1;

    int x;

    public LogIn() {
        initComponents();
        try {

            int flag = 0;
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql:///dbsoria", "root", "root");
//            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs = st.executeQuery("select * from tblacc");
//
//            DatabaseMetaData metaData = con.getMetaData();
//            System.out.println("Connected to: " + metaData.getURL());
//            System.out.println("Database User: " + metaData.getUserName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblmata1 = new javax.swing.JLabel();
        lblmata = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        btnLog = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("webekjf");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(50, 100, 49));
        jPanel4.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel6.setText("User Log In");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(130, 30, 220, 60);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(510, 190, 390, 2);

        lblmata1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/matamayhiwa copy.png"))); // NOI18N
        lblmata1.setToolTipText("Click Here to Show Password");
        lblmata1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblmata1.setVisible(true);
        lblmata1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmata1MouseClicked(evt);
            }
        });
        jPanel1.add(lblmata1);
        lblmata1.setBounds(860, 250, 40, 40);

        lblmata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/matanakadilat32.png"))); // NOI18N
        lblmata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblmata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmataMouseClicked(evt);
            }
        });
        jPanel1.add(lblmata);
        lblmata.setBounds(860, 250, 40, 40);
        lblmata.setVisible(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel1.setText("Username:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(510, 130, 121, 26);

        txtUser.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtUser.setForeground(new java.awt.Color(102, 102, 102));
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.setBorder(null);
        txtUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });
        jPanel1.add(txtUser);
        txtUser.setBounds(510, 150, 390, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel2.setText("Password:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(510, 220, 108, 32);

        txtPass.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtPass.setForeground(new java.awt.Color(102, 102, 102));
        txtPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPass.setBorder(null);
        txtPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPass.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPassCaretUpdate(evt);
            }
        });
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });
        jPanel1.add(txtPass);
        txtPass.setBounds(510, 250, 390, 40);

        jPanel5.setBackground(new java.awt.Color(50, 100, 49));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(510, 290, 390, 2);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Logo.png"))); // NOI18N
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jLabel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel3KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 0, 440, 450);

        line.setBackground(new java.awt.Color(0, 0, 0));
        line.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        line.setVisible(false);
        line.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line.setText("______");
        jPanel1.add(line);
        line.setBounds(800, 340, 70, 40);

        btnLog.setBackground(new java.awt.Color(255, 255, 255));
        btnLog.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLog.setText("Log In");
        btnLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogMouseExited(evt);
            }
        });
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });
        jPanel1.add(btnLog);
        btnLog.setBounds(770, 330, 130, 60);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel7.setText("Sign In");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(640, 30, 120, 70);

        jLabel8.setText("Forgot password?");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(510, 310, 110, 16);

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel9.setText("_______________");
        jLabel9.setVisible(false);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });
        jPanel1.add(jLabel9);
        jLabel9.setBounds(510, 310, 130, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 20, 920, 470);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 920, 20);

        jPanel3.setBackground(new java.awt.Color(50, 100, 49));
        jPanel3.setLayout(null);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("x");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel3.add(jLabel4);
        jLabel4.setBounds(6, 0, 13, 32);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("-");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 40, 8, 32);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(920, 0, 40, 500);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(50, 0, 430, 40);

        setSize(new java.awt.Dimension(958, 490));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        pinindot++;
        try {

            jLabel3.setBorder(null);
            if (pinindot == 10) {
                jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
                jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            } else if (pinindot == 11) {
                pinindot = 0;
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - px, y - py);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        px = evt.getX();
        py = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setForeground(java.awt.Color.GRAY);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setForeground(java.awt.Color.gray);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged

    }//GEN-LAST:event_jLabel3MouseDragged

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed

        try {
            log();
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_btnLogActionPerformed
    public void log() {

        System.out.print(txtPass.getText());
        if (txtUser.getText().equals("Admin") && txtPass.getText().equals("Admin123")) {
            new Profile(txtUser.getText()).setVisible(true);
            System.out.print(txtUser.getText());
            this.dispose();
            JOptionPane.showMessageDialog(null, "THIS IS JUST A TEST VERSION. PLEASE SEND ME AN EMAIL OR MESSAGE IF YOU WANT TO ACCESS ALL THE FEATURES OF MY SYSTEM, AS GITHUB DOES NOT SUPPORT DATABASE HOSTING. THANK YOU!", "PLEASE READ BEFORE PROCEEDING", JOptionPane.WARNING_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }

//                this.dispose();
//        try {
//
//            int plag = 0;
//            int x = 0;
//            
        // Statement st = con.createStatement();
//            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs = st.executeQuery("select *, "
//                    + " cast(aes_decrypt(password,'key')as char(100))"
//                    + " from tblacc");
//
//            if (txtUser.getText().equals("") || txtPass.getText().equals("")) {
//                JOptionPane.showMessageDialog(null, "Please fill up empty fields!");
//                return;
//            }
//            int not = 0;
//            while (rs.next()) {
//                if (rs.getInt("archive") != 1) {
//                    if (rs.getString("username").equals(txtUser.getText())) {
//                        not = 1;
//                        if (rs.getInt("admin") == 1) {
//                            block = 0;
//                        } else {
//                            plag = 3;
//                        }
//                        if (rs.getInt("blocked") == 1) {
//                            JOptionPane.showMessageDialog(null, "Account already blocked");
//                            return;
//                        } else {
//
//                            if (rs.getString("cast(aes_decrypt(password,'key')as char(100))").equals(txtPass.getText())) {
//
//                                if (rs.getInt("first") == 0) {
//                                    new ChangesPass(0, txtUser.getText()).setVisible(true);
//                                    this.dispose();
//                                    return;
//                                } else if (rs.getInt("first") == 1) {
//                                    plag = 1;
//                                    x = rs.getInt("signed");
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            if (not == 0) {
//                JOptionPane.showMessageDialog(null, "Account does not exist!");
//                return;
//            }
//            if (plag == 3) {
//                JOptionPane.showMessageDialog(null, "Invalid password!");
//                if (block == 0) {
//                    block++;
//                    y = txtUser.getText();
//                } else {
//                    if (y.equals(txtUser.getText())) {
//                        block++;
//                    } else {
//                        y = txtUser.getText();
//                        block = 1;
//                    }
//                }
//            }
//            if (block == 3) {
//                JOptionPane.showMessageDialog(null, "Account has been banned");
//                String query = "update tblacc set blocked = 1 where username = '" + txtUser.getText() + "'";
//                st.executeUpdate(query);
//                block = 0;
//            }
//            if (plag == 1) {
//                System.out.println(x);
//                if (x == 2) {
//                    JOptionPane.showMessageDialog(null, "Account already logged in");
//                    return;
//                }
//                block = 0;
//
//                // Statement st1 = con.createStatement();
//                Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//                LocalDateTime now = LocalDateTime.now();
//                String date = dtf.format(now);
//                System.out.println(date);
//                System.out.println(txtUser.getText());
//                st1.executeUpdate("insert into tblhistory (user, ginawa, date) values ('" + txtUser.getText() + "',' has logged in', '" + date + "')");
//                System.out.println("pasok");
//
//                st.executeUpdate("update tblacc set signed = 2 where username = '" + txtUser.getText() + "'");
//                new Profile(txtUser.getText()).setVisible(true);
//                this.dispose();
//            }
//            if (plag == 0) {
//                JOptionPane.showMessageDialog(null, "Username and password does not match!");
//            }
//
//        } catch (Exception e) {
//            System.err.println(e);
//        }
    }
    private void btnLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogMouseExited
        line.setVisible(false);
    }//GEN-LAST:event_btnLogMouseExited

    private void btnLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogMouseEntered
        line.setVisible(true);
    }//GEN-LAST:event_btnLogMouseEntered

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed

    }//GEN-LAST:event_txtPassActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed

    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        int pin = evt.getKeyCode();
        if (pin == 10) {
            log();
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        int pin = evt.getKeyCode();
        if (pin == 10) {
            log();
        }
    }//GEN-LAST:event_txtUserKeyPressed

    private void txtPassCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPassCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassCaretUpdate

    private void lblmataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmataMouseClicked
        lblmata1.setVisible(true);
        lblmata.setVisible(false);
        txtPass.setEchoChar('*');
    }//GEN-LAST:event_lblmataMouseClicked

    private void lblmata1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmata1MouseClicked
        lblmata1.setVisible(false);
        lblmata.setVisible(true);
        txtPass.setEchoChar((char) 0);
    }//GEN-LAST:event_lblmata1MouseClicked

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel9.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel9.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered

    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked

        new ForgotPassword().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel3KeyPressed

    }//GEN-LAST:event_jLabel3KeyPressed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked

        System.out.println(pinindot);

        try {
            //   Statement st = con.createStatement();
//            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs = st.executeQuery("select * from poweruser");
//            jLabel3.setBorder(null);
//            if (pinindot == 10) {
//                st.executeUpdate("update poweruser set pu = 1");
//                new TableAccounts(txtUser.getText()).setVisible(true);
//                this.dispose();
//                pinindot = 0;
//            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel7MouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLog;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblmata;
    private javax.swing.JLabel lblmata1;
    private javax.swing.JLabel line;
    public static javax.swing.JPasswordField txtPass;
    public static javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
