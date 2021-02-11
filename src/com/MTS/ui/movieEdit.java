package com.MTS.ui;

import com.MTS.dao.MovieDAO;
import com.MTS.dto.MovieDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class movieEdit extends javax.swing.JDialog {

    public void sendMovTable(String[] tableValues) {
        movNameTxt.setText(tableValues[0]);
        movNameTxt.setEditable(false);
        genreTxt.setText(tableValues[1]);
        directorTxt.setText(tableValues[2]);
        releaseDateTxt.setText(tableValues[3]);
        lengthTxt.setText(tableValues[4]);

    }

    public movieEdit() {
        initComponents();

        updateBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                MovieDTO userUpdate = new MovieDTO();
                userUpdate.setMovName(movNameTxt.getText());
                userUpdate.setGenre(genreTxt.getText());
                userUpdate.setDirector(directorTxt.getText());
                userUpdate.setRelDate(releaseDateTxt.getText());
                userUpdate.setLength(lengthTxt.getText());
                if (Validation()) {
                    new MovieDAO().upDateMovie(userUpdate);
                }
                movNameTxt.setEditable(true);
                DetailPanel dp = new DetailPanel();
                dp.loadCustomerData();
                dispose();
            }
        });

        cancelBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setTitle("Employee Edit");
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setResizable(false);
        setBounds(500, 200, 255, 235);
        setLocationRelativeTo(null);
        add(Panel);
        setVisible(true);
    }

    public boolean Validation() {
        if (genreTxt.getText().equals(null) || genreLab.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Genre is missing");
            return false;
        }
        if (directorTxt.getText().equals(null) || directorTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Director is missing");
            return false;
        }
        if (releaseDateTxt.getText().equals(null) || releaseDateTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Release Date is missing");
            return false;
        }
        if (lengthTxt.getText().equals(null) || lengthTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Length is missing");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        movNameLab = new javax.swing.JLabel();
        movNameTxt = new javax.swing.JTextField();
        genreLab = new javax.swing.JLabel();
        genreTxt = new javax.swing.JTextField();
        directorLab = new javax.swing.JLabel();
        directorTxt = new javax.swing.JTextField();
        releaseDateLab = new javax.swing.JLabel();
        releaseDateTxt = new javax.swing.JTextField();
        lengthTxt = new javax.swing.JTextField();
        lengthLab = new javax.swing.JLabel();
        updateBttn = new javax.swing.JButton();
        cancelBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Panel.setBackground(new java.awt.Color(255, 255, 255));

        movNameLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        movNameLab.setText("Movie Name::");

        genreLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        genreLab.setText("Genre::");

        directorLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        directorLab.setText("Director::");

        releaseDateLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        releaseDateLab.setText("Release Date::");

        lengthTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lengthTxtActionPerformed(evt);
            }
        });

        lengthLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lengthLab.setText("Length::");

        updateBttn.setText("Update");

        cancelBttn.setText("Cancel");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(movNameLab)
                        .addGap(16, 16, 16)
                        .addComponent(movNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(genreLab, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(genreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(directorLab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(directorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(releaseDateLab, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(releaseDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(lengthLab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lengthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(updateBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cancelBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(movNameLab)
                    .addComponent(movNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genreLab)
                    .addComponent(genreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(directorLab)
                    .addComponent(directorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(releaseDateLab)
                    .addComponent(releaseDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lengthLab)
                    .addComponent(lengthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateBttn)
                    .addComponent(cancelBttn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lengthTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lengthTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lengthTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton cancelBttn;
    private javax.swing.JLabel directorLab;
    private javax.swing.JTextField directorTxt;
    private javax.swing.JLabel genreLab;
    private javax.swing.JTextField genreTxt;
    private javax.swing.JLabel lengthLab;
    private javax.swing.JTextField lengthTxt;
    private javax.swing.JLabel movNameLab;
    private javax.swing.JTextField movNameTxt;
    private javax.swing.JLabel releaseDateLab;
    private javax.swing.JTextField releaseDateTxt;
    private javax.swing.JButton updateBttn;
    // End of variables declaration//GEN-END:variables
}
