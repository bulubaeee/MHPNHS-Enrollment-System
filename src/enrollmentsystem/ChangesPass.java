package enrollmentsystem;

import static enrollmentsystem.LogIn.txtUser;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ChangesPass extends javax.swing.JFrame {

    Connection con;
    int px, py;
    static String username;
    int pasa;

    public ChangesPass(int from, String user) {
        username = user;
        pasa = from;
        initComponents();
        
        try {
            System.out.println(username);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///dbsoria", "root", "root");

        } catch (Exception e) {
        }
        if (from == 1) {
            txtOld.setEditable(true);
        } else {
            txtOld.setText(LogIn.txtPass.getText());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        eks = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        eks1 = new javax.swing.JLabel();
        min1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtOld = new javax.swing.JPasswordField();
        txtNew = new javax.swing.JPasswordField();
        lblmata = new javax.swing.JLabel();
        lblmata1 = new javax.swing.JLabel();
        txtReNew = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        back = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(50, 100, 49));
        jPanel3.setLayout(null);

        eks.setBackground(new java.awt.Color(255, 255, 255));
        eks.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        eks.setForeground(new java.awt.Color(255, 255, 255));
        eks.setText("x");
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
        jPanel3.setBounds(1190, 0, 30, 790);

        jPanel4.setBackground(new java.awt.Color(50, 100, 49));
        jPanel4.setLayout(null);

        eks1.setBackground(new java.awt.Color(255, 255, 255));
        eks1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        eks1.setForeground(new java.awt.Color(255, 255, 255));
        eks1.setText("x");
        eks1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eks1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eks1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eks1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eks1MouseExited(evt);
            }
        });
        jPanel4.add(eks1);
        eks1.setBounds(6, 0, 13, 32);

        min1.setBackground(new java.awt.Color(255, 255, 255));
        min1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        min1.setForeground(new java.awt.Color(255, 255, 255));
        min1.setText("-");
        min1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        min1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                min1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                min1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                min1MouseExited(evt);
            }
        });
        jPanel4.add(min1);
        min1.setBounds(10, 40, 8, 32);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(520, 0, 30, 490);

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
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 520, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Retype:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 280, 110, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("New:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 200, 60, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Old:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 130, 60, 20);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 27)); // NOI18N
        jLabel1.setText("Change Password");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 30, 280, 50);

        jPanel5.setBackground(new java.awt.Color(50, 100, 49));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(150, 310, 260, 2);

        jPanel6.setBackground(new java.awt.Color(50, 100, 49));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(150, 160, 260, 2);

        jPanel7.setBackground(new java.awt.Color(50, 100, 49));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(150, 240, 260, 2);

        txtOld.setEditable(false);
        txtOld.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtOld.setBorder(null);
        jPanel1.add(txtOld);
        txtOld.setBounds(150, 120, 260, 40);

        txtNew.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtNew.setBorder(null);
        txtNew.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNewCaretUpdate(evt);
            }
        });
        jPanel1.add(txtNew);
        txtNew.setBounds(150, 200, 260, 40);

        lblmata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/matamayhiwa copy.png"))); // NOI18N
        lblmata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblmata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmataMouseClicked(evt);
            }
        });
        jPanel1.add(lblmata);
        lblmata.setBounds(370, 270, 40, 40);
        lblmata.setVisible(false);

        lblmata1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/matanakadilat32.png"))); // NOI18N
        lblmata1.setToolTipText("Click Here to Show Password");
        lblmata1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblmata1.setVisible(true);
        lblmata1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmata1MouseClicked(evt);
            }
        });
        jPanel1.add(lblmata1);
        lblmata1.setBounds(370, 270, 40, 40);

        txtReNew.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtReNew.setBorder(null);
        txtReNew.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtReNewCaretUpdate(evt);
            }
        });
        jPanel1.add(txtReNew);
        txtReNew.setBounds(150, 270, 260, 40);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(350, 360, 130, 60);

        back.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        jPanel1.add(back);
        back.setBounds(10, 430, 50, 17);

        jLabel5.setBackground(new java.awt.Color(255, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setText("O");
        jLabel5.setVisible(false);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(420, 280, 50, 20);

        jLabel6.setBackground(new java.awt.Color(255, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("X");
        jLabel6.setVisible(false);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(420, 280, 50, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 30, 520, 450);

        setSize(new java.awt.Dimension(545, 479));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try {
    if (txtNew.getText().equals("") || txtReNew.getText().equals("") || txtOld.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Fill lahat!");
    } else {
        int plag = 0;
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select *, cast(aes_decrypt(password,'key')as char(100)) from tblacc;");
        
        boolean oldPasswordFound = false;
        
        while (rs.next()) {
            String decryptedPassword = rs.getString("cast(aes_decrypt(password,'key')as char(100))");
            if (decryptedPassword != null && decryptedPassword.equals(txtOld.getText())) {
                oldPasswordFound = true;
                break;
            } else {
                plag++;
            }
        }

        rs.absolute(plag + 1); 

        if (oldPasswordFound) {
            if (rs.getInt("first") == 0) {
                if (txtNew.getText().equals(txtReNew.getText())) {
                    Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    st2.executeUpdate("update tblacc set password = aes_encrypt('" + txtNew.getText() + "','key'),"
                            + "signed = " + 2 + " where username = '" + LogIn.txtUser.getText() + "'");
                    st2.executeUpdate("update tblacc set first = 1 where username = '" + LogIn.txtUser.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Password changed successfully!");
                    this.dispose();
                    new Profile(username).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords didn't match!");
                }
            } else {
                if (txtNew.getText().equals(txtReNew.getText())) {
                    Statement st2 = con.createStatement();
                    st2.executeUpdate("update tblacc set password = aes_encrypt('" + txtNew.getText() + "','key'),"
                            + "signed = " + 2 + " where username = '" + rs.getString("username") + "'");
                    st2.executeUpdate("update tblacc set first = 1 where username = '" + rs.getString("username") + "'");
                    JOptionPane.showMessageDialog(null, "Password changed successfully!");
                    this.dispose();
                    new Profile(username).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords didn't match!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect old password!");
        }
    }
} catch (Exception e) {
    e.printStackTrace();  // Prints stack trace for better debugging
    JOptionPane.showMessageDialog(null, "An error occurred while changing the password.");
}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void eksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eksMouseClicked
        System.exit(0);
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

    private void eks1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eks1MouseClicked
        try {
            Statement st = con.createStatement();
            int rs = st.executeUpdate("update tblacc set signed = 0 where username ='" + username + "'");
            this.dispose();
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_eks1MouseClicked

    private void eks1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eks1MouseEntered
        eks.setForeground(java.awt.Color.GRAY);
    }//GEN-LAST:event_eks1MouseEntered

    private void eks1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eks1MouseExited
        eks.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_eks1MouseExited

    private void min1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseClicked
        this.setState(TableAccounts.ICONIFIED);
    }//GEN-LAST:event_min1MouseClicked

    private void min1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseEntered
        min.setForeground(java.awt.Color.gray);
    }//GEN-LAST:event_min1MouseEntered

    private void min1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseExited
        min.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_min1MouseExited

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - px, y - py);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        px = evt.getX();
        py = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed

    }//GEN-LAST:event_jPanel2KeyPressed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        if (pasa == 1) {
            new Profile(txtUser.getText()).setVisible(true);
            this.dispose();
        } else {
            try {
                Statement st = con.createStatement();
                int rs = st.executeUpdate("update tblacc set signed = 0 where username ='" + username + "';");
                this.dispose();
                new LogIn().setVisible(true);

            } catch (Exception e) {
                System.err.println(e);
            }

        }
    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        back.setForeground(Color.BLUE);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        back.setForeground(Color.BLACK);
    }//GEN-LAST:event_backMouseExited

    private void txtReNewCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtReNewCaretUpdate

        if (!txtNew.getText().equals("") && !txtReNew.getText().equals("")) {
            if (txtNew.getText().equals(txtReNew.getText())) {
                jLabel5.setVisible(true);
                jLabel6.setVisible(false);
            } else {
                jLabel6.setVisible(true);
                jLabel5.setVisible(false);
            }
        }

    }//GEN-LAST:event_txtReNewCaretUpdate

    private void txtNewCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNewCaretUpdate
        if (!txtNew.getText().equals("") && !txtReNew.getText().equals("")) {
            if (txtNew.getText().equals(txtReNew.getText())) {
                jLabel5.setVisible(true);
                jLabel6.setVisible(false);
            } else {
                jLabel6.setVisible(true);
                jLabel5.setVisible(false);
            }
        }
    }//GEN-LAST:event_txtNewCaretUpdate

    private void lblmata1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmata1MouseClicked
        lblmata1.setVisible(false);
        lblmata.setVisible(true);
        txtReNew.setEchoChar((char) 0);
        txtNew.setEchoChar((char) 0);
    }//GEN-LAST:event_lblmata1MouseClicked

    private void lblmataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmataMouseClicked
        lblmata1.setVisible(true);
        lblmata.setVisible(false);
        txtReNew.setEchoChar('*');
        txtNew.setEchoChar('*');
    }//GEN-LAST:event_lblmataMouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ChangesPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangesPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangesPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangesPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangesPass(0, "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel eks;
    private javax.swing.JLabel eks1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblmata;
    private javax.swing.JLabel lblmata1;
    private javax.swing.JLabel min;
    private javax.swing.JLabel min1;
    private javax.swing.JPasswordField txtNew;
    private javax.swing.JPasswordField txtOld;
    private javax.swing.JPasswordField txtReNew;
    // End of variables declaration//GEN-END:variables
}
