package com.MTS.ui;

import com.MTS.dao.MovieDAO;
import com.MTS.database.ConnectionDatabase;
import com.MTS.dto.MovieDTO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ticketing extends javax.swing.JPanel {

    JFrame frame = new JFrame();

    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public ticketing() {
        initComponents();

         try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/movie", "root", "");
            stmt = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    

        cancelBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearField();
            }
        });

        changeBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                changeBtnActionPerformed(e);
            }
        });

        HomeBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AdminPanel();
            }
        });

        frame.setTitle("Movie Ticketing System");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.add(Panel);
        Toolkit thekit = frame.getToolkit();
        Dimension dim = thekit.getScreenSize();
        frame.setBounds(dim.width / 4, dim.height / 4, 600, 420);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void changeBtnActionPerformed(ActionEvent e) {
        MovieDTO user = new MovieDTO();

        user.setMovName(movNameTxt.getText());
        user.setGenre(genreTxt.getText());
        user.setDirector(directorTxt.getText());
        user.setRelDate(releaseDateTxt.getText());
        user.setLength(lengthTxt.getText());
        if (Validation()) {
            new MovieDAO().addMovie(user);
        }
        clearField();
        // loadData();
    }

    private void clearField() {

        movNameTxt.setText("");
        genreTxt.setText("");
        directorTxt.setText("");
        releaseDateTxt.setText("");
        lengthTxt.setText("");

    }

//    public static void main(String[] args) {
//        new ticketing();
//    }

    public boolean Validation() {

        if (movNameTxt.getText().equals(null) || movNameTxt.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Movie name is missing");
            return false;
        } else {
            String query = "SELECT Mov_Name FROM movie WHERE Mov_Name= '" + movNameTxt.getText() + "'";
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Movie Name already exits");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        movNameTxt = new javax.swing.JTextField();
        directorLab = new javax.swing.JLabel();
        directorTxt = new javax.swing.JTextField();
        releaseDateLab = new javax.swing.JLabel();
        releaseDateTxt = new javax.swing.JTextField();
        lengthLab = new javax.swing.JLabel();
        lengthTxt = new javax.swing.JTextField();
        changeBttn = new javax.swing.JButton();
        cancelBttn = new javax.swing.JButton();
        HomeBttn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        genreTxt = new javax.swing.JTextField();
        genreLab = new javax.swing.JLabel();
        movNameLab = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        ResetBttn3 = new javax.swing.JButton();
        ResetBttn = new javax.swing.JButton();
        ResetBttn1 = new javax.swing.JButton();
        ResetBttn2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        Panel.setBackground(java.awt.Color.white);
        Panel.setLayout(null);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/MTSpic.jpg"))); // NOI18N
        Panel.add(jLabel12);
        jLabel12.setBounds(10, 10, 220, 30);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Change Movie Info");
        Panel.add(jLabel15);
        jLabel15.setBounds(240, 90, 120, 20);
        Panel.add(jSeparator7);
        jSeparator7.setBounds(230, 130, 350, 10);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Fill Movie Information Below::");
        Panel.add(jLabel17);
        jLabel17.setBounds(40, 120, 210, 15);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel.add(jSeparator8);
        jSeparator8.setBounds(10, 130, 2, 240);
        Panel.add(jSeparator9);
        jSeparator9.setBounds(10, 130, 30, 2);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel.add(jSeparator10);
        jSeparator10.setBounds(580, 130, 2, 240);
        Panel.add(jSeparator11);
        jSeparator11.setBounds(10, 370, 570, 20);
        Panel.add(movNameTxt);
        movNameTxt.setBounds(120, 160, 140, 20);

        directorLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        directorLab.setText("Director::");
        Panel.add(directorLab);
        directorLab.setBounds(30, 220, 60, 15);
        Panel.add(directorTxt);
        directorTxt.setBounds(120, 220, 140, 20);

        releaseDateLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        releaseDateLab.setText("Release Date::");
        Panel.add(releaseDateLab);
        releaseDateLab.setBounds(30, 250, 80, 15);
        Panel.add(releaseDateTxt);
        releaseDateTxt.setBounds(120, 250, 140, 20);

        lengthLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lengthLab.setText("Length::");
        Panel.add(lengthLab);
        lengthLab.setBounds(30, 280, 60, 15);

        lengthTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lengthTxtActionPerformed(evt);
            }
        });
        Panel.add(lengthTxt);
        lengthTxt.setBounds(120, 280, 140, 20);

        changeBttn.setText("Change");
        Panel.add(changeBttn);
        changeBttn.setBounds(140, 330, 80, 23);

        cancelBttn.setText("Cancel");
        Panel.add(cancelBttn);
        cancelBttn.setBounds(250, 330, 80, 23);

        HomeBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/homebttn.jpg"))); // NOI18N
        Panel.add(HomeBttn);
        HomeBttn.setBounds(0, 40, 80, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line3.jpg"))); // NOI18N
        Panel.add(jLabel2);
        jLabel2.setBounds(10, 90, 570, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line2.jpg"))); // NOI18N
        Panel.add(jLabel3);
        jLabel3.setBounds(10, 74, 570, 20);

        label1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label1.setText("Reset 12 PM data::");
        Panel.add(label1);
        label1.setBounds(310, 190, 110, 15);
        Panel.add(genreTxt);
        genreTxt.setBounds(120, 190, 140, 20);

        genreLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        genreLab.setText("Genre::");
        Panel.add(genreLab);
        genreLab.setBounds(30, 190, 50, 15);

        movNameLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        movNameLab.setText("Movie Name::");
        Panel.add(movNameLab);
        movNameLab.setBounds(30, 160, 74, 15);

        label2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label2.setText("Reset 3 PM data::");
        Panel.add(label2);
        label2.setBounds(310, 220, 110, 15);

        label3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label3.setText("Reset 6 PM data::");
        Panel.add(label3);
        label3.setBounds(310, 250, 110, 15);

        label4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label4.setText("Reset 9 AM data::");
        Panel.add(label4);
        label4.setBounds(310, 160, 110, 15);

        ResetBttn3.setText("Reset");
        ResetBttn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBttn3ActionPerformed(evt);
            }
        });
        Panel.add(ResetBttn3);
        ResetBttn3.setBounds(440, 250, 73, 23);

        ResetBttn.setText("Reset");
        ResetBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBttnActionPerformed(evt);
            }
        });
        Panel.add(ResetBttn);
        ResetBttn.setBounds(440, 160, 73, 23);

        ResetBttn1.setText("Reset");
        ResetBttn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBttn1ActionPerformed(evt);
            }
        });
        Panel.add(ResetBttn1);
        ResetBttn1.setBounds(440, 190, 73, 23);

        ResetBttn2.setText("Reset");
        ResetBttn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBttn2ActionPerformed(evt);
            }
        });
        Panel.add(ResetBttn2);
        ResetBttn2.setBounds(440, 220, 73, 23);

        jLabel1.setText("jLabel1");
        Panel.add(jLabel1);
        jLabel1.setBounds(270, 90, 34, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lengthTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lengthTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lengthTxtActionPerformed

    private void ResetBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBttnActionPerformed
        // TODO add your handling code here:
        
        String value = "green";
        String query = "UPDATE ticket SET Ticket = ?";
        try {
             pstmt = con.prepareStatement(query);
                pstmt.setString(1, value);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String query1 = "DELETE FROM booking";
        try {
            stmt.executeUpdate(query1);
        } catch (SQLException ae) {
            ae.printStackTrace();
        }
        
        JOptionPane.showMessageDialog(null, "Reset Done");
    }//GEN-LAST:event_ResetBttnActionPerformed

    private void ResetBttn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBttn1ActionPerformed
 String value = "green";
        String query = "UPDATE ticket1 SET Ticket = ?";
        try {
             pstmt = con.prepareStatement(query);
                pstmt.setString(1, value);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String query1 = "DELETE FROM booking1";
        try {
            stmt.executeUpdate(query1);
        } catch (SQLException ae) {
            ae.printStackTrace();
        }        // TODO add your handling code here:
         JOptionPane.showMessageDialog(null, "Reset Done");
    }//GEN-LAST:event_ResetBttn1ActionPerformed

    private void ResetBttn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBttn2ActionPerformed
        // TODO add your handling code here:
         String value = "green";
        String query = "UPDATE ticket2 SET Ticket = ?";
        try {
             pstmt = con.prepareStatement(query);
                pstmt.setString(1, value);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String query1 = "DELETE FROM booking2";
        try {
            stmt.executeUpdate(query1);
        } catch (SQLException ae) {
            ae.printStackTrace();
        }
         JOptionPane.showMessageDialog(null, "Reset Done");
    }//GEN-LAST:event_ResetBttn2ActionPerformed

    private void ResetBttn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBttn3ActionPerformed
        // TODO add your handling code here:
         String value = "green";
        String query = "UPDATE ticket3 SET Ticket = ?";
        try {
             pstmt = con.prepareStatement(query);
                pstmt.setString(1, value);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String query1 = "DELETE FROM booking3";
        try {
            stmt.executeUpdate(query1);
        } catch (SQLException ae) {
            ae.printStackTrace();
        }
         JOptionPane.showMessageDialog(null, "Reset Done");
    }//GEN-LAST:event_ResetBttn3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeBttn;
    private javax.swing.JPanel Panel;
    private javax.swing.JButton ResetBttn;
    private javax.swing.JButton ResetBttn1;
    private javax.swing.JButton ResetBttn2;
    private javax.swing.JButton ResetBttn3;
    private javax.swing.JButton cancelBttn;
    private javax.swing.JButton changeBttn;
    private javax.swing.JLabel directorLab;
    private javax.swing.JTextField directorTxt;
    private javax.swing.JLabel genreLab;
    private javax.swing.JTextField genreTxt;
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
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel lengthLab;
    private javax.swing.JTextField lengthTxt;
    private javax.swing.JLabel movNameLab;
    private javax.swing.JTextField movNameTxt;
    private javax.swing.JLabel releaseDateLab;
    private javax.swing.JTextField releaseDateTxt;
    // End of variables declaration//GEN-END:variables
}
