

package com.MTS.ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class changePanel extends javax.swing.JPanel {

    JFrame frame = new JFrame("Movie Ticketing System");
    
    public changePanel() {
        initComponents();
        
         frame.add(Panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        Toolkit thekit = this.getToolkit();
        Dimension dim = thekit.getScreenSize();
        frame.setBounds(dim.width / 7, dim.height / 5, 510, 340);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new changePanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        HomeBttn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        Panel.setBackground(java.awt.Color.white);
        Panel.setLayout(null);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/MTSpic.jpg"))); // NOI18N
        Panel.add(jLabel12);
        jLabel12.setBounds(10, 10, 220, 30);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ADD CUSTOMER");
        Panel.add(jLabel15);
        jLabel15.setBounds(260, 60, 100, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Choose the following option to update");
        Panel.add(jLabel17);
        jLabel17.setBounds(40, 120, 250, 15);
        Panel.add(jSeparator7);
        jSeparator7.setBounds(290, 130, 200, 10);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel.add(jSeparator8);
        jSeparator8.setBounds(10, 130, 10, 170);
        Panel.add(jSeparator9);
        jSeparator9.setBounds(10, 130, 30, 2);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel.add(jSeparator10);
        jSeparator10.setBounds(490, 130, 10, 170);
        Panel.add(jSeparator11);
        jSeparator11.setBounds(10, 300, 480, 10);

        HomeBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/homebttn.jpg"))); // NOI18N
        HomeBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBttnActionPerformed(evt);
            }
        });
        Panel.add(HomeBttn);
        HomeBttn.setBounds(10, 40, 80, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Update Main Page");
        Panel.add(jLabel1);
        jLabel1.setBounds(220, 90, 120, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line3.jpg"))); // NOI18N
        Panel.add(jLabel2);
        jLabel2.setBounds(10, 90, 480, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line2.jpg"))); // NOI18N
        Panel.add(jLabel3);
        jLabel3.setBounds(10, 74, 480, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Movie Detals");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Panel.add(jButton1);
        jButton1.setBounds(340, 160, 130, 120);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("<Html>Now Showing\n&nbsp;&nbsp;&nbsp&nbsp;&nbsp;movie<html>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Panel.add(jButton2);
        jButton2.setBounds(20, 160, 130, 120);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("<HTML>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Up Coming \n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;movie<HTML>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Panel.add(jButton3);
        jButton3.setBounds(180, 160, 130, 120);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Images a = new Images();

        a.initialize();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ImagesLoading b = new ImagesLoading();
        b.initialize();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new main();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void HomeBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBttnActionPerformed
        // TODO add your handling code here:
        new AdminPanel();
        frame.dispose();
    }//GEN-LAST:event_HomeBttnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeBttn;
    private javax.swing.JPanel Panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
