package com.MTS.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class AdminPanel extends javax.swing.JPanel {

    JFrame frame = new JFrame();

    public AdminPanel() {
        initComponents();

        LogoutBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainFrame();
            }
        });

        frame.setTitle("Movie Ticketing System");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.add(Panel1);
        Toolkit thekit = frame.getToolkit();
        Dimension dim = thekit.getScreenSize();
        frame.setBounds(dim.width / 4, dim.height / 4, 610, 375);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
//
//    public static void main(String[] args) {
//       new AdminPanel();
//     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        Panel = new javax.swing.JPanel();
        Panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LogoutBttn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        movieBttn = new javax.swing.JButton();
        AddCustomerBttn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        ticketBttn = new javax.swing.JButton();
        addEmployeeBttn = new javax.swing.JButton();
        DetailsBttn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        Panel.setLayout(null);
        add(Panel);
        Panel.setBounds(0, 0, 623, 0);

        Panel1.setBackground(java.awt.Color.white);
        Panel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/MTSpic.jpg"))); // NOI18N
        Panel1.add(jLabel1);
        jLabel1.setBounds(10, 16, 212, 27);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Welcome ! Admin !!");
        Panel1.add(jLabel2);
        jLabel2.setBounds(346, 20, 120, 15);

        LogoutBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/Logoutbttn.jpg"))); // NOI18N
        Panel1.add(LogoutBttn);
        LogoutBttn.setBounds(484, 20, 101, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line.jpg"))); // NOI18N
        Panel1.add(jLabel3);
        jLabel3.setBounds(10, 61, 575, 14);

        movieBttn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        movieBttn.setText("Change Movie ");
        movieBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieBttnActionPerformed(evt);
            }
        });
        Panel1.add(movieBttn);
        movieBttn.setBounds(10, 209, 170, 79);

        AddCustomerBttn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AddCustomerBttn.setText("Add Customers");
        AddCustomerBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCustomerBttnActionPerformed(evt);
            }
        });
        Panel1.add(AddCustomerBttn);
        AddCustomerBttn.setBounds(10, 103, 170, 79);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Update Main Page");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Panel1.add(jButton4);
        jButton4.setBounds(403, 209, 180, 79);

        ticketBttn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ticketBttn.setText("Ticketing Page");
        ticketBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketBttnActionPerformed(evt);
            }
        });
        Panel1.add(ticketBttn);
        ticketBttn.setBounds(198, 209, 190, 79);

        addEmployeeBttn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addEmployeeBttn.setText("Add Employee");
        addEmployeeBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeBttnActionPerformed(evt);
            }
        });
        Panel1.add(addEmployeeBttn);
        addEmployeeBttn.setBounds(198, 103, 191, 79);

        DetailsBttn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DetailsBttn.setText("Details");
        DetailsBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailsBttnActionPerformed(evt);
            }
        });
        Panel1.add(DetailsBttn);
        DetailsBttn.setBounds(407, 103, 180, 79);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line.jpg"))); // NOI18N
        Panel1.add(jLabel4);
        jLabel4.setBounds(10, 315, 580, 14);

        add(Panel1);
        Panel1.setBounds(0, 0, 610, 370);
    }// </editor-fold>//GEN-END:initComponents

    private void addEmployeeBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeBttnActionPerformed
        // TODO add your handling code here:
        new AddEmployee();
        frame.dispose();
    }//GEN-LAST:event_addEmployeeBttnActionPerformed

    private void DetailsBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetailsBttnActionPerformed
        // TODO add your handling code here:
        new DetailPanel();
        frame.dispose();
    }//GEN-LAST:event_DetailsBttnActionPerformed

    private void movieBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieBttnActionPerformed
        // TODO add your handling code here:
        new ticketing();
        frame.dispose();
    }//GEN-LAST:event_movieBttnActionPerformed

    private void ticketBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketBttnActionPerformed
        // TODO add your handling code here:
        new TicketingPanel();
        frame.dispose();
    }//GEN-LAST:event_ticketBttnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new changePanel();
        frame.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void AddCustomerBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCustomerBttnActionPerformed
        // TODO add your handling code here:
        new AddCustomerPanel();
        frame.dispose();
    }//GEN-LAST:event_AddCustomerBttnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCustomerBttn;
    private javax.swing.JButton DetailsBttn;
    private javax.swing.JButton LogoutBttn;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel Panel1;
    private javax.swing.JButton addEmployeeBttn;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton movieBttn;
    private javax.swing.JButton ticketBttn;
    // End of variables declaration//GEN-END:variables
}
