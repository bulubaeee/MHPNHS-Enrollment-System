package enrollmentsystem;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class corPrint extends javax.swing.JFrame {

    static String sec;

    public corPrint() {
        initComponents();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        if (Profile.txtSmSn.getText().length() > 29) {
            lblCorFn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        } else if (Profile.txtSmSn.getText().length() > 26) {
            lblCorFn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        }

        System.out.println(sec.length() + " ertegt");
        if (sec.length() > 14) {
            lblT6.setBounds(230, 360, 40, 30);
            lblT8.setBounds(280, 360, 90, 30);
        } else if (sec.length() > 4) {
            lblCorS.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        }

        lblCorFn.setText(Profile.txtSmSn.getText().toUpperCase());
        lblCorYl.setText(Profile.txtSmGl.getText());
        lblCorTeacher.setText(Profile.lblname.getText());
        lblCorDes.setText(Profile.lblDes.getText());
        lblCorS.setText(sec);
        lblCorDate.setText(date);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblDep = new javax.swing.JLabel();
        lbldivision = new javax.swing.JLabel();
        LBLMHPNHS = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        lblMarceloLogo = new javax.swing.JLabel();
        lbldivision1 = new javax.swing.JLabel();
        lbldivision2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblCorDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCorFn = new javax.swing.JLabel();
        lblT1 = new javax.swing.JLabel();
        lblT2 = new javax.swing.JLabel();
        lblT3 = new javax.swing.JLabel();
        lblCorYl = new javax.swing.JLabel();
        lblCorS = new javax.swing.JLabel();
        lblT6 = new javax.swing.JLabel();
        lblT7 = new javax.swing.JLabel();
        lblT8 = new javax.swing.JLabel();
        lblT9 = new javax.swing.JLabel();
        lblT10 = new javax.swing.JLabel();
        lblCorDes = new javax.swing.JLabel();
        lblCorTeacher = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        lblDep.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/deped123.PNG"))); // NOI18N
        jPanel2.add(lblDep);
        lblDep.setBounds(60, 30, 150, 150);

        lbldivision.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision.setText("SCHOOLS DIVISION OFFICE - CITY OF MALOLOS");
        jPanel2.add(lbldivision);
        lbldivision.setBounds(270, 70, 390, 20);

        LBLMHPNHS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LBLMHPNHS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBLMHPNHS.setText("MARCELO H. DEL PILAR NATIONAL HIGH SCHOOL");
        jPanel2.add(LBLMHPNHS);
        LBLMHPNHS.setBounds(250, 100, 470, 22);

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Bagong Bayan, City of Malolos, Bulacan / School ID: 300751 / ww.marcelodelpilarnhs.com");
        jPanel2.add(jLabel49);
        jLabel49.setBounds(210, 120, 530, 19);

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("E-mail: marcelohdelpilarnhs@gmail.com/ Tel. No. (044) 795-5343");
        jPanel2.add(jLabel51);
        jLabel51.setBounds(260, 140, 410, 20);

        lblMarceloLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/logo copy copy.png"))); // NOI18N
        jPanel2.add(lblMarceloLogo);
        lblMarceloLogo.setBounds(740, 30, 160, 150);

        lbldivision1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision1.setText("REPUBLIC OF THE PHILIPPINES");
        jPanel2.add(lbldivision1);
        lbldivision1.setBounds(320, 29, 280, 20);

        lbldivision2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision2.setText("DEPARTMENT OF EDUCATION - REGION III");
        jPanel2.add(lbldivision2);
        lbldivision2.setBounds(290, 50, 340, 20);

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

        jPanel2.add(jPanel3);
        jPanel3.setBounds(210, 90, 520, 4);

        lblCorDate.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblCorDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorDate.setText("Date");
        jPanel2.add(lblCorDate);
        lblCorDate.setBounds(690, 220, 200, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel2.setText("TO WHOM IT MAY CONCERN :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(70, 280, 230, 40);

        lblCorFn.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblCorFn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorFn.setText("FRANCIS C. COMBOY");
        jPanel2.add(lblCorFn);
        lblCorFn.setBounds(260, 330, 230, 30);

        lblT1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblT1.setText("only.");
        jPanel2.add(lblT1);
        lblT1.setBounds(60, 480, 60, 30);

        lblT2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblT2.setText("This certification is issued upon the request of the aforementioned student for verification purposes");
        jPanel2.add(lblT2);
        lblT2.setBounds(120, 450, 750, 30);

        lblT3.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblT3.setText("is presently enrolled in this school as ");
        jPanel2.add(lblT3);
        lblT3.setBounds(500, 330, 290, 30);

        lblCorYl.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblCorYl.setText("Grade 12");
        jPanel2.add(lblCorYl);
        lblCorYl.setBounds(780, 330, 110, 30);

        lblCorS.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblCorS.setText("TVL");
        jPanel2.add(lblCorS);
        lblCorS.setBounds(60, 360, 140, 30);

        lblT6.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblT6.setText("S.Y.");
        jPanel2.add(lblT6);
        lblT6.setBounds(160, 360, 40, 30);

        lblT7.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblT7.setText("This is certify that ");
        jPanel2.add(lblT7);
        lblT7.setBounds(120, 330, 150, 30);

        lblT8.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblT8.setText("2019-2020");
        jPanel2.add(lblT8);
        lblT8.setBounds(210, 360, 90, 30);

        lblT9.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblT9.setText("This is certify that he/she is of good moral character and has not been subjected to any disciplinary");
        jPanel2.add(lblT9);
        lblT9.setBounds(120, 390, 750, 30);

        lblT10.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblT10.setText("action.");
        jPanel2.add(lblT10);
        lblT10.setBounds(60, 420, 60, 30);

        lblCorDes.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        lblCorDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorDes.setText("Designation");
        jPanel2.add(lblCorDes);
        lblCorDes.setBounds(620, 560, 260, 20);

        lblCorTeacher.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        lblCorTeacher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorTeacher.setText("FULL NAME");
        jPanel2.add(lblCorTeacher);
        lblCorTeacher.setBounds(580, 540, 330, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(40, 40, 950, 610);

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(790, 670, 100, 25);

        jButton2.setText("print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(900, 670, 80, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1032, 719));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        lblCorFn.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
                g2.translate(pf.getImageableX() + 10, pf.getImageableY() + 20);
                g2.scale(0.62, 0.650);
//                g2.scale(0.570, 0.550);

                jPanel2.paint(g2);
                return Printable.PAGE_EXISTS;

            }
        });

        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please set the paper to a4 size!", "MESSAGE", 2);
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(corPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(corPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(corPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(corPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new corPrint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLMHPNHS;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lblCorDate;
    private javax.swing.JLabel lblCorDes;
    private javax.swing.JLabel lblCorFn;
    private javax.swing.JLabel lblCorS;
    private javax.swing.JLabel lblCorTeacher;
    private javax.swing.JLabel lblCorYl;
    private javax.swing.JLabel lblDep;
    private javax.swing.JLabel lblMarceloLogo;
    private javax.swing.JLabel lblT1;
    private javax.swing.JLabel lblT10;
    private javax.swing.JLabel lblT2;
    private javax.swing.JLabel lblT3;
    private javax.swing.JLabel lblT6;
    private javax.swing.JLabel lblT7;
    private javax.swing.JLabel lblT8;
    private javax.swing.JLabel lblT9;
    private javax.swing.JLabel lbldivision;
    private javax.swing.JLabel lbldivision1;
    private javax.swing.JLabel lbldivision2;
    // End of variables declaration//GEN-END:variables
}
