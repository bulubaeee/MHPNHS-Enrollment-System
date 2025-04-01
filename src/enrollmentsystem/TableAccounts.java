package enrollmentsystem;

import static enrollmentsystem.LogIn.txtUser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.JOptionPane;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.table.DefaultTableModel;

public class TableAccounts extends javax.swing.JFrame {

    String user;
    String username;

    Connection con;
    int px, py, row, count = 0;

    public TableAccounts(String user) {
        username = user;
        initComponents();
        try {
            System.out.println(username);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///dbsoria", "root", "root");
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from poweruser");
            rs.absolute(1);

            if (rs.getInt("pu") == 1) {
                Display1();
                jLabel1.setFont(new java.awt.Font("Dialog", 1, 55));
                jLabel1.setText("Account List(Power User)");
            } else {
                Display();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        tblList.setSelectionMode(SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMn = new javax.swing.JTextField();
        txtLn = new javax.swing.JTextField();
        txtFn = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        eks = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnUp = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnunblock = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnblock = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnRP = new javax.swing.JButton();
        back = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        txtMn.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txtMn.setBorder(null);
        getContentPane().add(txtMn);
        txtMn.setBounds(880, 310, 290, 40);

        txtLn.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txtLn.setBorder(null);
        getContentPane().add(txtLn);
        txtLn.setBounds(880, 390, 290, 40);

        txtFn.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txtFn.setBorder(null);
        getContentPane().add(txtFn);
        txtFn.setBounds(880, 230, 290, 40);

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
        jPanel3.setBounds(1220, 0, 30, 790);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(50, 100, 49));
        jPanel13.setLayout(null);
        jPanel10.add(jPanel13);
        jPanel13.setBounds(880, 160, 290, 2);

        jPanel14.setBackground(new java.awt.Color(50, 100, 49));
        jPanel14.setLayout(null);
        jPanel10.add(jPanel14);
        jPanel14.setBounds(880, 240, 290, 2);

        jPanel15.setBackground(new java.awt.Color(50, 100, 49));
        jPanel15.setLayout(null);
        jPanel10.add(jPanel15);
        jPanel15.setBounds(880, 320, 290, 2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        btnUp.setBackground(new java.awt.Color(255, 255, 255));
        btnUp.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnUp.setText("Update");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });
        jPanel1.add(btnUp);
        btnUp.setBounds(750, 390, 140, 50);

        btnDel.setBackground(new java.awt.Color(255, 255, 255));
        btnDel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        jPanel1.add(btnDel);
        btnDel.setBounds(910, 390, 140, 50);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });
        jPanel1.add(txtSearch);
        txtSearch.setBounds(280, 20, 430, 40);

        btnunblock.setBackground(new java.awt.Color(255, 255, 255));
        btnunblock.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnunblock.setText("Unblock");
        btnunblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnunblockActionPerformed(evt);
            }
        });
        jPanel1.add(btnunblock);
        btnunblock.setBounds(190, 580, 140, 30);

        btnCreate.setBackground(new java.awt.Color(255, 255, 255));
        btnCreate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCreate.setText("Create account");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate);
        btnCreate.setBounds(520, 580, 190, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setText("Enter username to search:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 20, 260, 40);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setText("Last Name:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(750, 310, 130, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setText("Middle Name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(730, 220, 140, 40);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel6.setText("First Name:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(750, 140, 110, 30);

        jPanel16.setBackground(new java.awt.Color(50, 100, 49));
        jPanel16.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel23.setText("User Log In");
        jPanel16.add(jLabel23);
        jLabel23.setBounds(130, 30, 220, 60);

        jPanel1.add(jPanel16);
        jPanel16.setBounds(880, 95, 290, 2);

        txtUser.setEditable(false);
        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txtUser.setBorder(null);
        jPanel1.add(txtUser);
        txtUser.setBounds(880, 60, 290, 40);

        btnblock.setBackground(new java.awt.Color(255, 255, 255));
        btnblock.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnblock.setText("Block");
        btnblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnblockActionPerformed(evt);
            }
        });
        jPanel1.add(btnblock);
        btnblock.setBounds(20, 580, 150, 30);

        tblList.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblList.getTableHeader().setResizingAllowed(false);
        tblList.getTableHeader().setReorderingAllowed(false);
        tblList.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tblListMouseDragged(evt);
            }
        });
        tblList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblListFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblListFocusLost(evt);
            }
        });
        tblList.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                tblListMouseWheelMoved(evt);
            }
        });
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        tblList.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                tblListComponentHidden(evt);
            }
        });
        tblList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblListKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 690, 500);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel7.setText("Username:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(750, 60, 110, 30);

        btnRP.setBackground(new java.awt.Color(255, 255, 255));
        btnRP.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnRP.setText("Reset Password");
        btnRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRPActionPerformed(evt);
            }
        });
        jPanel1.add(btnRP);
        btnRP.setBounds(1060, 390, 150, 50);

        back.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
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
        back.setBounds(10, 670, 40, 16);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Save as PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(340, 580, 170, 30);

        jPanel10.add(jPanel1);
        jPanel1.setBounds(0, -10, 1220, 750);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 110, 1220, 750);

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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 55)); // NOI18N
        jLabel1.setText("Account List(Admin)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(338, 338, 338))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, -30, 1220, 140);

        setSize(new java.awt.Dimension(1246, 793));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnunblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnunblockActionPerformed
        try {
          //  Statement st2 = con.createStatement();
          Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = st2.executeQuery("select * from poweruser");
            rs2.absolute(1);

            if (rs2.getInt("pu") == 1) {
                jLabel1.setFont(new java.awt.Font("Dialog", 1, 55));
               // Statement st = con.createStatement();
               Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                int row = tblList.getSelectedRow();
                String user = (String) tblList.getValueAt(row, 0);
                st.executeUpdate("update tblacc set blocked = 0 where username = '" + user + "'");
                new TableAccounts("");
                Display1();
            } else {
                jLabel1.setFont(new java.awt.Font("Dialog", 1, 55));
               // Statement st = con.createStatement();
               Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                int row = tblList.getSelectedRow();
                String user = (String) tblList.getValueAt(row, 0);
                st.executeUpdate("update tblacc set blocked = 0 where username = '" + user + "'");
                new TableAccounts("");
                Display();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select item first!");
        }

        txtSearch.setText("");

    }//GEN-LAST:event_btnunblockActionPerformed

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        tblList.getModel();
        row = tblList.getSelectedRow() + 1;
        String user = (String) tblList.getValueAt(row - 1, 0);

        try {
           // Statement st = con.createStatement();
           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from tblacc");
            //  rs.absolute(row);

          //  Statement st1 = con.createStatement();\
          Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs1 = st1.executeQuery("select * from tblacc");

            while (rs1.next()) {
                if (user.equals(rs1.getString("username"))) {
                    txtUser.setText(rs1.getString("username"));
                    txtFn.setText(rs1.getString("FirstName"));
                    txtMn.setText(rs1.getString("MiddleName"));
                    txtLn.setText(rs1.getString("LastName"));
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_tblListMouseClicked

    private void btnblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnblockActionPerformed
        try {
           // Statement st2 = con.createStatement();
           Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = st2.executeQuery("select * from poweruser");
            rs2.absolute(1);
            if (rs2.getInt("pu") == 1) {
                jLabel1.setFont(new java.awt.Font("Dialog", 1, 55));
                //Statement st = con.createStatement();
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                int row = tblList.getSelectedRow();
                String user = (String) tblList.getValueAt(row, 0);
                st.executeUpdate("update tblacc set blocked = 1 where username = '" + user + "'");
                new TableAccounts("");
                Display1();
            } else {
                jLabel1.setFont(new java.awt.Font("Dialog", 1, 55));
               // Statement st = con.createStatement();
               Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                int row = tblList.getSelectedRow();
                String user = (String) tblList.getValueAt(row, 0);
                st.executeUpdate("update tblacc set blocked = 1 where username = '" + user + "'");
                new TableAccounts("");
                Display();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select item first!");
        }

        txtSearch.setText("");


    }//GEN-LAST:event_btnblockActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        try {
            if (txtFn.getText().isEmpty() || txtLn.getText().isEmpty()) {
                //JOptionPane.showMessageDialog(null, "Please complete the fields!");
                return;
            }
         //   Statement st = con.createStatement();
         Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate("update tblacc set username = '" + txtUser.getText() + "', fiRstname = '" + txtFn.getText() + "',"
                    + "middlename = '" + txtMn.getText() + "', lastname = '" + txtLn.getText() + "' where username = "
                    + "'" + txtUser.getText() + "'");
            JOptionPane.showMessageDialog(null, "Successfully updated!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnUpActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked

        try {
           // Statement st1 = con.createStatement();
           Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = st1.executeQuery("select * from poweruser");
            rs2.absolute(1);

            if (rs2.getString("pu").equals("1")) {
                new LogIn().setVisible(true);
                this.dispose();
            } else {
                this.dispose();
                new Profile(username).setVisible(true);

            }

            //  this.dispose();
//            if (rs2.getInt("pu") == 1) {
//                int rs1 = st1.executeUpdate("update poweruser set pu = 0");
//                new RunThis();
//                this.dispose();
//            } else {
//                int rs1 = st1.executeUpdate("update poweruser set pu = 0");
//                this.dispose();
//            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_backMouseClicked

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "No item selected");
            return;
        } else {
            int get = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete? " + txtUser.getText().toUpperCase() + "  ", "WARNING", 0, 0);
            if (get != 0) {
                return;
            }
        }

        try {
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String in = "update tblacc set archive = 1 where username = '" + txtUser.getText() + "';";
            st.executeUpdate(in);

          //  Statement st2 = con.createStatement();
          Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = st2.executeQuery("select * from poweruser");
            rs2.absolute(1);

            if (rs2.getInt("pu") == 1) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);
                st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('" + username + "',' has archived user " + txtUser.getText() + "', '" + date + "')");
                txtUser.setText("");
                txtFn.setText("");
                txtMn.setText("");
                txtLn.setText("");
                JOptionPane.showMessageDialog(null, "Successfully deleted!");
                Display1();
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);
                st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('" + username + "',' has archived user " + txtUser.getText() + "', '" + date + "')");
                txtUser.setText("");
                txtFn.setText("");
                txtMn.setText("");
                txtLn.setText("");
                JOptionPane.showMessageDialog(null, "Successfully deleted!");
                Display();
            }

        } catch (Exception e) {
            System.err.println(e);

        }

    }//GEN-LAST:event_btnDelActionPerformed

    private void tblListComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblListComponentHidden

    }//GEN-LAST:event_tblListComponentHidden

    private void tblListMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_tblListMouseWheelMoved
        display();
    }//GEN-LAST:event_tblListMouseWheelMoved

    private void tblListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblListFocusGained

    }//GEN-LAST:event_tblListFocusGained

    private void tblListFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblListFocusLost

    }//GEN-LAST:event_tblListFocusLost

    private void tblListMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseDragged
        row = tblList.getSelectedRow() + 1;
        display();
    }//GEN-LAST:event_tblListMouseDragged

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        back.setForeground(Color.BLUE);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        back.setForeground(Color.BLACK);
    }//GEN-LAST:event_backMouseExited

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        px = evt.getX();
        py = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - px, y - py);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        String x = txtSearch.getText();
        try {
          //  Statement st4 = con.createStatement();
          Statement st4 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs4 = st4.executeQuery("select * from poweruser");
            rs4.absolute(1);

            if (rs4.getInt("pu") == 1)/*pang poweruser*/ {
                if (txtSearch.getText().equals("")) {
                    txtFn.setText("");
                    txtMn.setText("");
                    txtLn.setText("");
                    txtUser.setText("");
                    Display1();
                } else {
                   // Statement st = con.createStatement();
                   Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    String in = "select acc.* from tblacc acc where (username  like '%" + x + "%');";
                    ResultSet rs = st.executeQuery(in);

                    DefaultTableModel model = new DefaultTableModel();
                    tblList.setModel(model);
                    tblList.setRowHeight(30);
                    tblList.setSelectionBackground(Color.GRAY);
                    model.addColumn("Username");
                    model.addColumn("Status");
                    model.addColumn("Users");
                    tblList.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 24));

                    while (rs.next()) {
                        if (rs.getInt("archive") != 1) {
                            Vector vec = new Vector();
                            vec.add(rs.getString("username"));
                            if (rs.getInt("blocked") == 1) {
                                vec.add("blocked");
                            } else {
                                vec.add("accessible");
                            }
                            if (rs.getInt("admin") == 1) {
                                vec.add("Admin");
                            } else {
                                vec.add("User");
                            }
                            model.addRow(vec);
                        }
                    }
                }
            } else {
                if (txtSearch.getText().equals("")) {
                    txtFn.setText("");
                    txtMn.setText("");
                    txtLn.setText("");
                    txtUser.setText("");
                    Display();
                } else {
                  //  Statement st = con.createStatement();
                  Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    String in = "select acc.* from tblacc acc where (username  like '%" + x + "%');";
                    ResultSet rs = st.executeQuery(in);

                    DefaultTableModel model = new DefaultTableModel();
                    tblList.setModel(model);
                    tblList.setRowHeight(30);
                    tblList.setSelectionBackground(Color.GRAY);
                    model.addColumn("Username");
                    model.addColumn("Status");
                    tblList.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 24));

                    while (rs.next()) {
                        if (rs.getInt("archive") != 1) {
                            Vector vec = new Vector();
                            if (rs.getInt("admin") == 1) {
                            } else {
                                vec.add(rs.getString("username"));
                                if (rs.getInt("blocked") == 1) {
                                    vec.add("blocked");
                                } else {
                                    vec.add("accessible");
                                }
                                model.addRow(vec);
                            }

                        }
                    }
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_txtSearchCaretUpdate

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        new CreateAcc(username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void minMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseExited
        min.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_minMouseExited

    private void minMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseEntered
        min.setForeground(java.awt.Color.gray);
    }//GEN-LAST:event_minMouseEntered

    private void minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseClicked
        this.setState(TableAccounts.ICONIFIED);
    }//GEN-LAST:event_minMouseClicked

    private void eksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eksMouseExited
        eks.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_eksMouseExited

    private void eksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eksMouseEntered
        eks.setForeground(java.awt.Color.GRAY);
    }//GEN-LAST:event_eksMouseEntered

    private void eksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eksMouseClicked

        try {
          //  Statement st1 = con.createStatement();
          Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = st1.executeQuery("select * from poweruser");
            rs2.absolute(1);

           // Statement st = con.createStatement();
           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

            if (rs2.getInt("pu") == 1) {
                int rs1 = st1.executeUpdate("update poweruser set pu = 0");
                new LogIn().setVisible(true);
                int rs = st.executeUpdate("update tblacc set signed = 0 where username ='" + username + "'");
                this.dispose();
            } else {
                int rs1 = st1.executeUpdate("update poweruser set pu = 0");
//                new Profile().setVisible(true);
                int rs = st.executeUpdate("update tblacc set signed = 0 where username ='" + username + "'");
                this.dispose();
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_eksMouseClicked

    private void btnRPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRPActionPerformed
        try {
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "No item selected");
                return;
            } else {
                int get = JOptionPane.showConfirmDialog(null, "Are you sure you want to Reset password? " + txtUser.getText().toUpperCase() + "  ", "WARNING", 0, 0);
                if (get != 0) {
                    return;
                }
            }

           // Statement st = con.createStatement();
           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from tblacc");

            int row = tblList.getSelectedRow();
            String user = (String) tblList.getValueAt(row, 0);

            while (rs.next()) {
                if (user.equals(rs.getString("username"))) {
                    int rs2 = st.executeUpdate("update tblacc set password =aes_encrypt('" + user + "','key')" + "where username ='" + user + "'");
                    JOptionPane.showMessageDialog(null, "Success!");
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnRPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new userPrint().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListKeyPressed
        int x = evt.getKeyCode();
        if (x == 40 && row != count) {
            row++;
        } else if (x == 38 && row != 1) {
            row--;
        }
        display();

    }//GEN-LAST:event_tblListKeyPressed

    public void display() {
        try {
          //  Statement st1 = con.createStatement();
          Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs1 = st1.executeQuery("select * from tblacc");

            String user = (String) tblList.getValueAt(row - 1, 0);

            while (rs1.next()) {
                if (user.equals(rs1.getString("username"))) {
                    txtUser.setText(rs1.getString("username"));
                    txtFn.setText(rs1.getString("FirstName"));
                    txtMn.setText(rs1.getString("MiddleName"));
                    txtLn.setText(rs1.getString("LastName"));
                }
            }
        } catch (Exception e) {
        }
    }

    public void Display() /*pang admin*/ {
        try {
            count = 0;
            DefaultTableModel model = new DefaultTableModel();
            tblList.setModel(model);
            tblList.setRowHeight(30);
            tblList.setSelectionBackground(Color.GRAY);

            model.addColumn("Username");
            model.addColumn("Status");
            tblList.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 24));
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select id.* from tblacc id");

            while (rs.next()) {

                if (rs.getInt("archive") != 1) {
                    Vector vec = new Vector();
                    if (rs.getInt("admin") == 1) {
                    } else {
                        count++;
                        vec.add(rs.getString("username"));
                        if (rs.getInt("blocked") == 1) {
                            vec.add("blocked");
                        } else {
                            vec.add("accessible");
                        }
                        model.addRow(vec);
                    }
                }

            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void Display1() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            tblList.setModel(model);
            tblList.setRowHeight(30);
            tblList.setSelectionBackground(Color.GRAY);

            model.addColumn("Username");
            model.addColumn("Status");
            model.addColumn("Users");
            tblList.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 24));
         //   Statement st = con.createStatement();
         Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select id.* from tblacc id");

            while (rs.next()) {
                Vector vec = new Vector();
                if (rs.getInt("archive") != 1) {
                    vec.add(rs.getString("username"));
                    if (rs.getInt("blocked") == 1) {
                        vec.add("blocked");
                    } else {
                        vec.add("accessible");
                    }
                    if (rs.getInt("admin") == 1) {
                        vec.add("Admin");
                    } else {
                        vec.add("User");
                    }

                    model.addRow(vec);
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

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
            java.util.logging.Logger.getLogger(TableAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableAccounts("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnRP;
    private javax.swing.JButton btnUp;
    private javax.swing.JButton btnblock;
    private javax.swing.JButton btnunblock;
    private javax.swing.JLabel eks;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel min;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField txtFn;
    private javax.swing.JTextField txtLn;
    private javax.swing.JTextField txtMn;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
