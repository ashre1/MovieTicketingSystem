package com.MTS.ui;

import com.MTS.database.ConnectionDatabase;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class main extends javax.swing.JDialog {

    JFrame frame = new JFrame();
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public main() {
        initComponents();
        con = new ConnectionDatabase().getConnection();

        doneBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTxt.getText();
                String title = titleTxt.getText();
                String review = reviewTxt.getText();

                if (Validation()) {

                    try {
                        String query = "UPDATE details SET Mov_Name = ?,Title = ?,Review = ? WHERE ID = 001";
                        pstmt = con.prepareStatement(query);
                        pstmt.setString(1, name);
                        pstmt.setString(2, title);
                        pstmt.setString(3, review);
                        pstmt.executeUpdate();
                    } catch (SQLException ae) {
                        ae.printStackTrace();
                    }
                }
                frame.dispose();

            }
        });

        frame.setTitle("Movie Details");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panle);
        Toolkit thekit = frame.getToolkit();
        Dimension dim = thekit.getScreenSize();
        frame.setBounds(dim.width / 4, dim.height / 4, 305, 310);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public boolean Validation() {
        
        if (nameTxt.getText().equals(null) || nameTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Movie Name is missing");
            return false;
        }

        if (reviewTxt.getText().equals(null) || reviewTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Review is missing");
            return false;
        }

        return true;
    }
    
//  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panle = new javax.swing.JPanel();
        nameLab = new javax.swing.JLabel();
        reviewLab = new javax.swing.JLabel();
        titleLab = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        titleTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewTxt = new javax.swing.JTextArea();
        doneBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panle.setBackground(new java.awt.Color(255, 255, 255));

        nameLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameLab.setText("Movie Name::");

        reviewLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        reviewLab.setText("Review::");

        titleLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titleLab.setText("Sub-Title::");

        reviewTxt.setColumns(20);
        reviewTxt.setRows(5);
        jScrollPane1.setViewportView(reviewTxt);

        doneBttn.setText("Done");

        javax.swing.GroupLayout panleLayout = new javax.swing.GroupLayout(panle);
        panle.setLayout(panleLayout);
        panleLayout.setHorizontalGroup(
            panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLab)
                    .addComponent(titleLab)
                    .addComponent(reviewLab))
                .addGap(18, 18, 18)
                .addGroup(panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleTxt)
                    .addComponent(nameTxt)
                    .addComponent(doneBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panleLayout.setVerticalGroup(
            panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panleLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLab)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLab)
                    .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reviewLab)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(doneBttn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doneBttn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLab;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JPanel panle;
    private javax.swing.JLabel reviewLab;
    private javax.swing.JTextArea reviewTxt;
    private javax.swing.JLabel titleLab;
    private javax.swing.JTextField titleTxt;
    // End of variables declaration//GEN-END:variables
}
