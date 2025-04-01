package enrollmentsystem;

import static enrollmentsystem.EnrollmentForm.btnfrmCON;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.table.DefaultTableModel;

public class ForTransferee2 extends javax.swing.JFrame {

    Connection con;
    int px, py, row = 0, f = 0, selected = 0, row1 = 0;
    String username;
    Boolean user;
    String subs[] = new String[17];
    String sub, pangkuha;
    Boolean subSelect;

    public ForTransferee2() {
        initComponents();
        this.requestFocus();
        this.requestFocusInWindow();
        this.requestFocus(true);
        DefaultTableModel mRC = new DefaultTableModel();
        tblSub.setModel(mRC);
        tblSub = new JTable(mRC) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };

        mRC.addColumn("Subjects");
        mRC.addColumn("");

        String arrSub[] = new String[20];
        tblSub.setSelectionMode(SINGLE_SELECTION);

        arrSub[0] = ("Oral Communication in Context");
        arrSub[1] = ("Komunikasyon at Pananaliksik sa Wika at kulturang Filipino");
        arrSub[2] = "Introduction to The Philosophy of the Human Person/Pambungad na Pilosopya ng Tao";
        arrSub[3] = ("General Mathematics");
        arrSub[4] = ("Earth and Life Science");
        arrSub[5] = ("Understanding Culture Society and Politics");
        arrSub[6] = ("English for Academic and Proffessional Purposes");
        arrSub[7] = ("21st Literature from the philippines and the World");
        arrSub[8] = ("Reading and Writing Skiils");
        arrSub[9] = ("Pagbasa at Pagsusuri ng iba`t ibang Teksto Tungo sa Pananaliksik");
        arrSub[10] = ("Statistics and Probability");
        arrSub[11] = ("Contemporary Philippine Arts from the Regions");
        arrSub[12] = ("Empowerment Technologies");
        arrSub[13] = ("Physical Science");
        arrSub[14] = ("Media and Information Literacy");
        arrSub[15] = ("Personal Development");
        arrSub[16] = ("Pagsulat Sa Filipino sa Piling Larang");

        for (int ctr = 0; ctr <= 16; ctr++) {
            Vector vec = new Vector();
            vec.add(arrSub[ctr]);
            mRC.addRow(vec);
        }

        tblSub.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblSub.getColumnModel().getColumn(0).setPreferredWidth(790);
        tblSub.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblSub.setRowHeight(35);

        tblSub.setSelectionBackground(new java.awt.Color(50, 100, 49));
        tblSub.getTableHeader().setResizingAllowed(false);
        tblSub.getTableHeader().setReorderingAllowed(false);
        tblSub.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
        tblSub.setFont(new java.awt.Font("Times New Roman", 0, 18));
        tblSub.setRowHeight(35);

        tblSub.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(tblSub);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        eks1 = new javax.swing.JLabel();
        min1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSub = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        rbtnNo = new javax.swing.JRadioButton();
        rbtnYes = new javax.swing.JRadioButton();
        btnCon = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnRes = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        buttonGroup1.add(rbtnYes);
        buttonGroup1.add(rbtnNo);

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
        jPanel4.setBounds(890, 0, 30, 710);

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
            .addGap(0, 890, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 890, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Please Select the Subjects you've already taken");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 50, 410, 30);

        tblSub.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblSub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSubMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblSub);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 870, 520);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("For Transferee only!");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(410, 80, 150, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Note:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(380, 80, 41, 20);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 40, 80, 60);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 670, 100, 32);

        rbtnNo.setText("No");
        rbtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNoActionPerformed(evt);
            }
        });
        getContentPane().add(rbtnNo);
        rbtnNo.setBounds(510, 640, 70, 28);

        rbtnYes.setText("Yes");
        rbtnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnYesActionPerformed(evt);
            }
        });
        getContentPane().add(rbtnYes);
        rbtnYes.setBounds(430, 640, 70, 28);

        btnCon.setText("Confirm");
        btnCon.setEnabled(false);
        btnCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConActionPerformed(evt);
            }
        });
        getContentPane().add(btnCon);
        btnCon.setBounds(330, 670, 90, 32);

        jLabel5.setText("I am a Transferee Student");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 640, 170, 20);

        btnRes.setText("reset");
        btnRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResActionPerformed(evt);
            }
        });
        getContentPane().add(btnRes);
        btnRes.setBounds(550, 670, 100, 32);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 30, 890, 680);

        setSize(new java.awt.Dimension(920, 705));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eks1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eks1MouseClicked
        btnfrmCON.setEnabled(true);
        this.dispose();
        EnrollmentForm.flg = 0;
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        btnfrmCON.setEnabled(true);
        this.dispose();
        EnrollmentForm.flg = 2;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbtnYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnYesActionPerformed
        if (rbtnYes.isSelected()) {
            btnCon.setEnabled(true);
        } else {
            btnCon.setEnabled(false);
        }
    }//GEN-LAST:event_rbtnYesActionPerformed

    private void rbtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNoActionPerformed
        if (rbtnYes.isSelected()) {
            btnCon.setEnabled(true);
        } else {
            btnCon.setEnabled(false);
        }
    }//GEN-LAST:event_rbtnNoActionPerformed

    private void tblSubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubMouseClicked
        try {

            selected = 0;
            row = tblSub.getSelectedRow() + 1;
            subSelect = (Boolean) tblSub.getValueAt(row - 1, 1);

            if (tblSub.getSelectedColumn() != 1) {
                subSelect = (Boolean) tblSub.getValueAt(row - 1, 1);
                if (subSelect == null || subSelect == false) {
                    tblSub.setValueAt(true, row - 1, 1);
//                    selected++;
                } else {
//                    selected--;
                    tblSub.setValueAt(false, row - 1, 1);
                }
            }
            for (int i = 0; i <= 16; i++) {
                Boolean gb = (Boolean) tblSub.getValueAt(i, 1);
                if (gb != null && gb != false) {
                    selected += 1;
                }
            }

            if (selected == 8) {
                JOptionPane.showMessageDialog(null, "Maximum Number of Selection Reached!", "OOPS!!", 2);
                tblSub.setEnabled(false);
            } else {
                tblSub.setEnabled(true);
            }

//            for (int i = 0; i < count; i++) {
//                Boolean gb = (Boolean) tblEM.getValueAt(i, 0);
//                if (gb == true) {
//                    tNum++;
//                }
//            }
//            row = tblSub.getSelectedRow();
//            int col = tblSub.getSelectedColumn();
//            if (col == 1) {
//                Boolean user = (Boolean) tblSub.getValueAt(row, 1);
//                System.out.println(user);
//                if (user == true) {
//                    f++;
//                } else if (user == false) {
//                    f--;
//                }
//                if (f == 8) {
//                    JOptionPane.showMessageDialog(null, "Maximum Number of Selection Reached!");
//                    tblSub.setEnabled(false);
//                }
//                System.out.println(f);
//            }
        } catch (Exception e) {
            System.err.println(e);
        }


    }//GEN-LAST:event_tblSubMouseClicked

    private void btnConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConActionPerformed

        try {
            String arrSubs[] = new String[8];
            int a = 0;
            for (int i = 0; i <= 16; i++) {
                Boolean gb = (Boolean) tblSub.getValueAt(i, 1);
                if (gb != null && gb != false) {
                    pangkuha = (String) tblSub.getValueAt(i, 0);
                    if (!pangkuha.equals("null")) {
                        subs[i] = pangkuha;
                        arrSubs[a] = subs[i];
                    }
                    a++;
                }
            }

            EnrollmentForm.s1 = arrSubs[0];
            EnrollmentForm.s2 = arrSubs[1];
            EnrollmentForm.s3 = arrSubs[2];
            EnrollmentForm.s4 = arrSubs[3];
            EnrollmentForm.s5 = arrSubs[4];
            EnrollmentForm.s6 = arrSubs[5];
            EnrollmentForm.s7 = arrSubs[6];
            EnrollmentForm.s8 = arrSubs[7];
            System.out.println(EnrollmentForm.s1);
            System.out.println(EnrollmentForm.s2);
            System.out.println(EnrollmentForm.s3);
            System.out.println(EnrollmentForm.s4);
            System.out.println(EnrollmentForm.s5);
            System.out.println(EnrollmentForm.s6);
            System.out.println(EnrollmentForm.s7);
            System.out.println(EnrollmentForm.s8);

            EnrollmentForm.flg = 2;
            btnfrmCON.setEnabled(true);
            this.dispose();
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_btnConActionPerformed

    private void btnResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResActionPerformed
        for (int ctr = 0; ctr < 15; ctr++) {
            tblSub.setValueAt(false, ctr, 1);
            tblSub.setEnabled(true);
            f = 0;
        }
    }//GEN-LAST:event_btnResActionPerformed

    private void tblSubMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubMousePressed

    }//GEN-LAST:event_tblSubMousePressed

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
            java.util.logging.Logger.getLogger(ForTransferee2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForTransferee2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForTransferee2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForTransferee2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForTransferee2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCon;
    private javax.swing.JButton btnRes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel eks1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel min1;
    private javax.swing.JRadioButton rbtnNo;
    private javax.swing.JRadioButton rbtnYes;
    private javax.swing.JTable tblSub;
    // End of variables declaration//GEN-END:variables
}
