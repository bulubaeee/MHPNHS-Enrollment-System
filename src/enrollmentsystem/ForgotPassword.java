package enrollmentsystem;

//import com.mysql.cj.protocol.Resultset;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ForgotPassword extends javax.swing.JFrame {

    Connection con;
    int px, py;
    String username;
    int flag = 0, flag2 = 0;

    public ForgotPassword() {

        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///dbsoria", "root", "root");

        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jButton1 = new javax.swing.JButton();
        back = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtFPUser = new javax.swing.JTextField();
        btnCon = new javax.swing.JButton();
        txtFPCont = new javax.swing.JTextField();
        txtFPA = new javax.swing.JTextField();
        txtFPSQ = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

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
        jPanel4.setBounds(850, 0, 30, 570);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
            .addGap(0, 846, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 850, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setText("Answer:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 360, 100, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setText("Contact #:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 200, 130, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel2.setText("Enter Username:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 120, 180, 30);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 27)); // NOI18N
        jLabel1.setText("Forgot Password");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(320, 30, 280, 50);

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
        jPanel5.setBounds(310, 390, 260, 2);

        jPanel6.setBackground(new java.awt.Color(50, 100, 49));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(260, 150, 370, 2);

        jPanel7.setBackground(new java.awt.Color(50, 100, 49));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(260, 240, 490, 2);

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
        jButton1.setBounds(680, 450, 130, 60);

        back.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back.setText("back");
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
        back.setBounds(10, 510, 50, 17);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel7.setText("Secret Question:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(80, 280, 170, 40);

        jPanel8.setBackground(new java.awt.Color(50, 100, 49));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8);
        jPanel8.setBounds(260, 318, 490, 2);

        txtFPUser.setEditable(true);
        txtFPUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFPUser.setBorder(null);
        txtFPUser.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFPUserCaretUpdate(evt);
            }
        });
        jPanel1.add(txtFPUser);
        txtFPUser.setBounds(260, 110, 370, 40);

        btnCon.setEnabled(false);
        btnCon.setBackground(new java.awt.Color(255, 255, 255));
        btnCon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCon.setText("Continue");
        btnCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConActionPerformed(evt);
            }
        });
        jPanel1.add(btnCon);
        btnCon.setBounds(640, 110, 100, 40);

        txtFPCont.setEditable(false);
        txtFPCont.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFPCont.setBorder(null);
        jPanel1.add(txtFPCont);
        txtFPCont.setBounds(260, 200, 490, 40);

        txtFPA.setEditable(false);
        txtFPA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFPA.setBorder(null);
        jPanel1.add(txtFPA);
        txtFPA.setBounds(310, 350, 260, 40);

        txtFPSQ.setEditable(false);
        txtFPSQ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFPSQ.setBorder(null);
        jPanel1.add(txtFPSQ);
        txtFPSQ.setBounds(260, 280, 490, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 30, 850, 540);

        setSize(new java.awt.Dimension(878, 571));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String user = txtFPUser.getText();
           // Statement st = con.createStatement();
           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("Select * from tblacc");
            while (rs.next()) {
                if (txtFPCont.getText().trim().equalsIgnoreCase(rs.getString("contact"))) {
                    if (txtFPA.getText().trim().equalsIgnoreCase(rs.getString("answer"))) {
                        flag2 = 1;
                        int rs2 = st.executeUpdate("update tblacc set password =aes_encrypt('" + user + "','key')" + "where username ='" + user + "'");
                        JOptionPane.showMessageDialog(null, "Success! your default password is '"+txtFPUser.getText()+"'");
                        new LogIn().setVisible(true);
                        this.dispose();
                    }
                }
            }
            if (flag2 == 0) {
                JOptionPane.showMessageDialog(null, "Invalid !");
                new LogIn().setVisible(true);
                this.dispose();
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void eks1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eks1MouseClicked
        this.dispose();
    }//GEN-LAST:event_eks1MouseClicked

    private void eks1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eks1MouseEntered

    }//GEN-LAST:event_eks1MouseEntered

    private void eks1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eks1MouseExited

    }//GEN-LAST:event_eks1MouseExited

    private void min1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseClicked

    }//GEN-LAST:event_min1MouseClicked

    private void min1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseEntered

    }//GEN-LAST:event_min1MouseEntered

    private void min1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseExited

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
        new LogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        back.setForeground(Color.BLUE);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        back.setForeground(Color.BLACK);
    }//GEN-LAST:event_backMouseExited

    private void txtFPUserCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFPUserCaretUpdate
        if (txtFPUser.getText().length() == 0) {
            btnCon.setEnabled(false);
        } else {
            btnCon.setEnabled(true);
        }
    }//GEN-LAST:event_txtFPUserCaretUpdate

    private void btnConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConActionPerformed
        try {
         //   Statement st = con.createStatement();
         Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("Select * from tblacc");
            while (rs.next()) {
                if (rootPaneCheckingEnabled) {
                    if (txtFPUser.getText().equals(rs.getString("username"))) {
                        flag = 1;
                        txtFPCont.setEditable(true);
                        txtFPUser.setEnabled(false);
                        btnCon.setEnabled(false);
                        txtFPA.setEditable(true);
                        txtFPSQ.setText(rs.getString("secret_question"));
                        System.out.println(rs.getString("answer"));
                    }
                }
            }
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "Username does not exist!");
                new LogIn().setVisible(true);
                this.dispose();
            }

        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_btnConActionPerformed

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton btnCon;
    private javax.swing.JLabel eks1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel min1;
    private javax.swing.JTextField txtFPA;
    private javax.swing.JTextField txtFPCont;
    private javax.swing.JTextField txtFPSQ;
    private javax.swing.JTextField txtFPUser;
    // End of variables declaration//GEN-END:variables
}
