/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

import java.awt.Component;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;


public class Reason extends javax.swing.JFrame {

    public Reason() {



    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        rbtn = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        txtIn = new javax.swing.JTextField();
        lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jRadioButton1.setText("No Longer School");
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(8, 90, 140, 25);

        rbtn.setText("Completer");
        getContentPane().add(rbtn);
        rbtn.setBounds(8, 47, 87, 25);

        jRadioButton3.setText("Drop Out");
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(8, 120, 79, 25);

        jRadioButton4.setText("jRadioButton1");
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(8, 206, 107, 25);

        jRadioButton5.setText("Transffered Out");
        getContentPane().add(jRadioButton5);
        jRadioButton5.setBounds(8, 163, 140, 25);

        jRadioButton6.setText("jRadioButton1");
        getContentPane().add(jRadioButton6);
        jRadioButton6.setBounds(8, 249, 107, 25);
        getContentPane().add(txtIn);
        txtIn.setBounds(209, 104, 161, 22);

        lbl.setText("Are you sure?");
        getContentPane().add(lbl);
        lbl.setBounds(256, 215, 79, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Reason.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reason.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reason.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reason.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reason().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JLabel lbl;
    private javax.swing.JRadioButton rbtn;
    private javax.swing.JTextField txtIn;
    // End of variables declaration//GEN-END:variables
}
