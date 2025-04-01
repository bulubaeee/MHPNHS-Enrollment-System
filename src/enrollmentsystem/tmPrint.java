package enrollmentsystem;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;

public class tmPrint extends javax.swing.JFrame {

    public tmPrint() {
        initComponents();
        int no = 1;
        txtFn.append("\n");
        txtDes.append("\n");
        txtAd.append("\n");
        for (int i = 0; i < Profile.a; i++) {
            System.out.println(Profile.a);
            txtFn.append(" " + no + ". " + Profile.arName[i] + "\n");
            txtDes.append("  " + Profile.arDes[i] + "\n");
            txtAd.append("  " + Profile.arAd[i] + "\n");
            no++;
        }
        Profile.a = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAd = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtFn = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        lblMarceloLogo = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        LBLMHPNHS = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbldivision = new javax.swing.JLabel();
        lbldivision2 = new javax.swing.JLabel();
        lbldivision1 = new javax.swing.JLabel();
        lblDep = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1050, 920));
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(920, 1100));
        jPanel1.setLayout(null);

        txtAd.setEditable(false);
        txtAd.setColumns(20);
        txtAd.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtAd.setRows(5);
        txtAd.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(txtAd);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(700, 290, 190, 650);

        txtFn.setEditable(false);
        txtFn.setColumns(20);
        txtFn.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtFn.setRows(5);
        txtFn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(txtFn);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(60, 290, 240, 650);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel1.setText("Advisory Class:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(700, 270, 130, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel2.setText("Full Name:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 266, 80, 20);

        txtDes.setEditable(false);
        txtDes.setColumns(20);
        txtDes.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        txtDes.setRows(5);
        txtDes.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane4.setViewportView(txtDes);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(300, 290, 400, 650);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setText("Designation:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 270, 110, 20);

        lblMarceloLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/logo copy copy.png"))); // NOI18N
        jPanel1.add(lblMarceloLogo);
        lblMarceloLogo.setBounds(740, 60, 160, 150);

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("E-mail: marcelohdelpilarnhs@gmail.com/ Tel. No. (044) 795-5343");
        jPanel1.add(jLabel51);
        jLabel51.setBounds(260, 170, 410, 20);

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Bagong Bayan, City of Malolos, Bulacan / School ID: 300751 / ww.marcelodelpilarnhs.com");
        jPanel1.add(jLabel49);
        jLabel49.setBounds(210, 150, 530, 19);

        LBLMHPNHS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LBLMHPNHS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBLMHPNHS.setText("MARCELO H. DEL PILAR NATIONAL HIGH SCHOOL");
        jPanel1.add(LBLMHPNHS);
        LBLMHPNHS.setBounds(250, 130, 470, 22);

        jPanel3.setBackground(new java.awt.Color(255, 204, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(210, 120, 520, 4);

        lbldivision.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision.setText("SCHOOLS DIVISION OFFICE - CITY OF MALOLOS");
        jPanel1.add(lbldivision);
        lbldivision.setBounds(270, 100, 390, 20);

        lbldivision2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision2.setText("DEPARTMENT OF EDUCATION - REGION III");
        jPanel1.add(lbldivision2);
        lbldivision2.setBounds(290, 80, 340, 20);

        lbldivision1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision1.setText("REPUBLIC OF THE PHILIPPINES");
        jPanel1.add(lbldivision1);
        lbldivision1.setBounds(320, 60, 280, 20);

        lblDep.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/deped123.PNG"))); // NOI18N
        jPanel1.add(lblDep);
        lblDep.setBounds(60, 60, 150, 150);

        jScrollPane1.setViewportView(jPanel1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(80, 10, 1070, 620);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton1.setText("Save as PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(1010, 660, 130, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(880, 660, 120, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel4.setText("Please set paper size to A4");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(680, 660, 190, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1178, 712);

        setSize(new java.awt.Dimension(1178, 712));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
                g2.translate(pf.getImageableX(), pf.getImageableY() + 10);
                g2.scale(0.62, 0.650);
//                g2.scale(0.63, 0.720);

                jPanel1.paint(g2);
                return Printable.PAGE_EXISTS;

            }
        });

        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please set the paper to a4 size!", "MESSAGE", 2);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(tmPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tmPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tmPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tmPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tmPrint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLMHPNHS;
    public javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblDep;
    private javax.swing.JLabel lblMarceloLogo;
    private javax.swing.JLabel lbldivision;
    private javax.swing.JLabel lbldivision1;
    private javax.swing.JLabel lbldivision2;
    public javax.swing.JTextArea txtAd;
    public javax.swing.JTextArea txtDes;
    public javax.swing.JTextArea txtFn;
    // End of variables declaration//GEN-END:variables
}
