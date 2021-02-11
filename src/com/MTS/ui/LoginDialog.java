  package com.MTS.ui;

import com.MTS.database.ConnectionDatabase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginDialog extends javax.swing.JDialog {

    JFrame frame = new JFrame();

    public LoginDialog() {

        initComponents();

        LoginBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String Category = UserTypeCambo.getSelectedItem().toString();
                String username = UsernameTxt.getText();
                String password = new String(PasswordTxt.getPassword());

                boolean isLogged = new ConnectionDatabase().checkLogin(username, password, Category);
                if (isLogged) {
                    if (Category.equalsIgnoreCase("Frontdesk officer")) {
                        new TicketingPanel();
                        dispose();
                    } else if (Category.equalsIgnoreCase("Admin")) {
                        new AdminPanel();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "User type not defined");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid User");
                    PasswordTxt.setText("");
                    UserTypeCambo.setSelectedItem(null);
                }

            }
        });

        CancelBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainFrame();
            }
        });

        //  LoginDialog loginDialog = new LoginDialog();
        setTitle("Please Login....");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setBounds(500, 200, 525, 370);
        add(Panel);
        setVisible(true);

    }
//     public static void main(String[] args) {
//       new LoginDialog();
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        UsernameTxt = new javax.swing.JTextField();
        Username = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        UserType = new javax.swing.JLabel();
        UserTypeCambo = new javax.swing.JComboBox();
        LoginBttn = new javax.swing.JButton();
        CancelBttn = new javax.swing.JButton();
        PasswordTxt = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        Panel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(645, 315, 102, 0);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(645, 96, 493, 0);

        UsernameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(UsernameTxt);
        UsernameTxt.setBounds(340, 190, 140, 23);

        Username.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Username.setText("User Name::");
        getContentPane().add(Username);
        Username.setBounds(260, 190, 77, 17);

        Password.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Password.setText("Password::");
        getContentPane().add(Password);
        Password.setBounds(260, 250, 66, 20);

        UserType.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        UserType.setText("User Type::");
        getContentPane().add(UserType);
        UserType.setBounds(260, 220, 71, 17);

        UserTypeCambo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        UserTypeCambo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Frontdesk Officer" }));
        UserTypeCambo.setSelectedItem(null);
        UserTypeCambo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserTypeCamboActionPerformed(evt);
            }
        });
        getContentPane().add(UserTypeCambo);
        UserTypeCambo.setBounds(340, 220, 140, 23);

        LoginBttn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LoginBttn.setText("Login");
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
        LoginBttn.setBounds(260, 290, 70, 25);

        CancelBttn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CancelBttn.setText("Cancel");
        getContentPane().add(CancelBttn);
        CancelBttn.setBounds(350, 290, 80, 25);

        PasswordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordTxtActionPerformed(evt);
            }
        });
        getContentPane().add(PasswordTxt);
        PasswordTxt.setBounds(340, 250, 140, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/login2.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 80, 520, 260);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/login1.jpg"))); // NOI18N

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 261, Short.MAX_VALUE))
        );

        getContentPane().add(Panel);
        Panel.setBounds(0, 0, 520, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserTypeCamboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserTypeCamboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserTypeCamboActionPerformed

    private void LoginBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBttnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginBttnActionPerformed

    private void PasswordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordTxtActionPerformed

    private void LoginBttnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginBttnKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            String Category = UserTypeCambo.getSelectedItem().toString();
            String username = UsernameTxt.getText();
            String password = new String(PasswordTxt.getPassword());

            boolean isLogged = new ConnectionDatabase().checkLogin(username, password, Category);
            if (isLogged) {
                if (Category.equalsIgnoreCase("Frontdesk officer")) {
                    dispose();
                   // new TicketingPanel();
                    
                } else if (Category.equalsIgnoreCase("Admin")) {
                    new AdminPanel();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "User type not defined");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Invalid User");
                PasswordTxt.setText("");
                UserTypeCambo.setSelectedItem(null);
            }
        }
    }//GEN-LAST:event_LoginBttnKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBttn;
    private javax.swing.JButton LoginBttn;
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel Password;
    private javax.swing.JPasswordField PasswordTxt;
    private javax.swing.JLabel UserType;
    private javax.swing.JComboBox UserTypeCambo;
    private javax.swing.JLabel Username;
    private javax.swing.JTextField UsernameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
