package com.MTS.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends javax.swing.JFrame {

    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public MainFrame() {
        initComponents();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/movie", "root", "");
            stmt = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }

        loadImage();
        
        AA ThreadAA = new AA();
        A ThreadA = new A();
        B ThreadB = new B();
        C ThreadC = new C();
        
        ThreadAA.start();
        ThreadA.start();
        ThreadB.start();
        ThreadC.start();
        
        LoginBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginDialog();
                
            }
        });

        this.setTitle("Movie Ticketing System");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        // this.setResizable(false);
        Toolkit thekit = this.getToolkit();
        Dimension dim = thekit.getScreenSize();
        this.setSize(dim);
        //  this.setBounds(dim.width / 4, dim.height / 8, 750, 550);
        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LoginBttn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nowLabel = new javax.swing.JLabel();
        movieLab = new javax.swing.JLabel();
        titleLab = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        reviewLab = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        upLabel1 = new javax.swing.JLabel();
        upLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        upLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel2.setForeground(java.awt.Color.orange);
        jLabel2.setText("Grand");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(290, 10, 90, 32);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.orange);
        jLabel1.setText("cinemas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 40, 120, 32);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.orange);
        jLabel3.setText("Welcome To The Revolution...");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(280, 80, 190, 10);

        LoginBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/loginbttn.png"))); // NOI18N
        LoginBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBttnActionPerformed(evt);
            }
        });
        LoginBttn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginBttnKeyPressed(evt);
            }
        });
        getContentPane().add(LoginBttn);
        LoginBttn.setBounds(1000, 130, 100, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/main3.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 0, 870, 110);

        jLabel4.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel4.setForeground(java.awt.Color.orange);
        jLabel4.setText("UP COMING MOVIE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(660, 530, 170, 22);

        nowLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/main1.jpg"))); // NOI18N
        getContentPane().add(nowLabel);
        nowLabel.setBounds(360, 170, 360, 350);

        movieLab.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        movieLab.setForeground(java.awt.Color.orange);
        movieLab.setText("HOLIDAY");
        getContentPane().add(movieLab);
        movieLab.setBounds(840, 180, 90, 20);

        titleLab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titleLab.setForeground(java.awt.Color.orange);
        titleLab.setText("(A SOLDIER IS NEVER OFF DUTY)");
        getContentPane().add(titleLab);
        titleLab.setBounds(770, 210, 250, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(java.awt.Color.orange);
        jLabel8.setText("<html><u>Review<\\html>");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(770, 240, 60, 20);

        reviewLab.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        reviewLab.setForeground(java.awt.Color.orange);
        reviewLab.setText("<html><p align=\"justify\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A Soldier Is Never Off Duty is a 2014 Bollywood action thriller film written and directed by A.R. Murugadoss, and produced by Vipul Shah. It features Akshay Kumar and Sonakshi Sinha in the lead roles, along with Govinda in a supporting role. It is a remake of the 2012 Tamil film Thuppakki which was also directed by A. R. Murugadoss. The film released on 6 June 2014.</p></html>");
        getContentPane().add(reviewLab);
        reviewLab.setBounds(770, 240, 290, 240);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/bg1.jpg"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(1120, 0, 250, 750);

        jLabel7.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel7.setForeground(java.awt.Color.orange);
        jLabel7.setText("Now Showing");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(680, 130, 140, 30);

        upLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/N1.jpg"))); // NOI18N
        getContentPane().add(upLabel1);
        upLabel1.setBounds(290, 560, 240, 170);

        upLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/N2.jpg"))); // NOI18N
        getContentPane().add(upLabel2);
        upLabel2.setBounds(580, 560, 240, 170);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/bg1.jpg"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(0, 0, 250, 750);

        upLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/N1.jpg"))); // NOI18N
        getContentPane().add(upLabel3);
        upLabel3.setBounds(850, 560, 230, 170);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/main4.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 110, 870, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBttnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginBttnActionPerformed

    private void LoginBttnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginBttnKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            new LoginDialog();
            dispose();
        }
    }//GEN-LAST:event_LoginBttnKeyPressed

    String image, image1, img1, img2, img3;

    public void loadImage() {
        String query = "SELECT Image,Image1,Img1,Img2,Img3 FROM image WHERE ID =001";
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                image = rs.getString(1);
                image1 = rs.getString(2);
                img1 = rs.getString(3);
                img2 = rs.getString(4);
                img3 = rs.getString(5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        nowLabel.setIcon(new ImageIcon(image));
        upLabel1.setIcon(new ImageIcon(img1));
        upLabel2.setIcon(new ImageIcon(img2));
        upLabel3.setIcon(new ImageIcon(img3));

        String name = null;
        String title = null;
        String review = null;

        String query1 = "SELECT Mov_Name,Title,Review FROM details WHERE ID=001";
        try {
            rs = stmt.executeQuery(query1);
            while (rs.next()) {
                name = rs.getString(1);
                name.toUpperCase();
                title = "(" + rs.getString(2) + ")";
                title.toUpperCase();
                review = "<html><p align=\"justify\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString(3) + "</p></html>";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        movieLab.setText(name);
        titleLab.setText(title);
        reviewLab.setText(review);

    }
    
     class AA extends Thread {

        AA() {
            super("Thread AA");
        }

        public void run() {
            try {
                for (int i = 0; i <= 5; i++) {
                    nowLabel.setIcon(new ImageIcon(image));
                    Thread.sleep(3000);
                    nowLabel.setIcon(new ImageIcon(image1));
                    Thread.sleep(3000);
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    class A extends Thread {

        A() {
            super("Thread A");
        }

        public void run() {
            try {
                for (int i = 0; i <= 5; i++) {
                    upLabel1.setIcon(new ImageIcon(img1));
                    Thread.sleep(2000);
                    upLabel1.setIcon(new ImageIcon(img2));
                    Thread.sleep(2000);
                    upLabel1.setIcon(new ImageIcon(img3));
                    Thread.sleep(2000);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    
    class B extends Thread {

        B() {
            super("Thread B");
        }

        public void run() {
            try {
                for (int i = 0; i <= 5; i++) {
                    
                    upLabel2.setIcon(new ImageIcon(img2));
                    Thread.sleep(2000);
                    upLabel2.setIcon(new ImageIcon(img3));
                    Thread.sleep(2000);
                    upLabel2.setIcon(new ImageIcon(img1));
                    Thread.sleep(2000);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    
    class C extends Thread {

        C() {
            super("Thread C");
        }

        public void run() {
            try {
                for (int i = 0; i <= 5; i++) {
                    
                    upLabel3.setIcon(new ImageIcon(img3));
                    Thread.sleep(2000);
                    upLabel3.setIcon(new ImageIcon(img1));
                    Thread.sleep(2000);
                    upLabel3.setIcon(new ImageIcon(img2));
                    Thread.sleep(2000);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBttn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel movieLab;
    private javax.swing.JLabel nowLabel;
    private javax.swing.JLabel reviewLab;
    private javax.swing.JLabel titleLab;
    private javax.swing.JLabel upLabel1;
    private javax.swing.JLabel upLabel2;
    private javax.swing.JLabel upLabel3;
    // End of variables declaration//GEN-END:variables
}
