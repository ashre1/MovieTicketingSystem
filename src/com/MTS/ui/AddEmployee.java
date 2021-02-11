package com.MTS.ui;

import com.MTS.dao.EmployeeDAO;
import com.MTS.database.ConnectionDatabase;
import com.MTS.dto.EmployeeDTO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddEmployee extends 
javax.swing.JPanel {
    JFrame frame = new JFrame();
    String gender = "Male";
    String combo;
    ButtonGroup genderGroup;

    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public AddEmployee() {
        initComponents();

        con = new ConnectionDatabase().getConnection();

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        CancelBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearField();
            }
        });

        AddBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (addValidation()) {
                    addBtnActionPerformed(e);
                }
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
        frame.add(EmployeePanel);
        Toolkit thekit = frame.getToolkit();
        Dimension dim = thekit.getScreenSize();
        frame.setBounds(dim.width / 4, dim.height / 7, 610, 525);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void addBtnActionPerformed(ActionEvent e) {
        EmployeeDTO user = new EmployeeDTO();
        if (femaleRadio.isSelected()) {
            gender = "Female";
        } else {
            gender = "Male";
        }

        combo = CategoryCambo.getSelectedItem().toString();

        user.setId(IdTxt.getText());
        user.setName(NameTxt.getText());
        user.setUserName(UserNameTxt.getText());
        user.setPassword(new String(PasswordTxt.getPassword()));
        user.setGender(gender);
        user.setCategory(combo);
        user.setAddress(AddressTxt.getText());
        user.setContact(ContactTxt.getText());
        user.setEmail(EmailTxt.getText());
        new EmployeeDAO().addEmployee(user);
        clearField();
        // loadData();
    }

    private void clearField() {
        IdTxt.setText("");
        NameTxt.setText("");
        UserNameTxt.setText("");
        PasswordTxt.setText("");
        AddressTxt.setText("");
        ContactTxt.setText("");
        EmailTxt.setText("");
        genderGroup.clearSelection();
        CategoryCambo.setSelectedItem(null);
    }

    public boolean addValidation() {

        String a = IdTxt.getText();
        if (a != null && a.length() == 4) {
            if (a.substring(0, 1).matches("E") && Character.isDigit(a.charAt(1)) && Character.isDigit(a.charAt(2)) && Character.isDigit(a.charAt(3))) {
                String query = "SELECT Emp_ID FROM employee WHERE Emp_ID= '" + IdTxt.getText() + "'";
                try {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        JOptionPane.showMessageDialog(null, "ID already exits");
                        IdTxt.setText("");
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid ID");
                IdTxt.setText("");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid ID");
            IdTxt.setText("");
            return false;
        }

        if (NameTxt.getText().equals(null) || NameTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Name is missing");
            return false;
        }

        if (UserNameTxt.getText().equals(null) || UserNameTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "UserName is missing");
            return false;
        }

        if (PasswordTxt.getPassword().toString().equals(null) || PasswordTxt.getPassword().toString().length() < 6) {
            JOptionPane.showMessageDialog(null, "Password is missing");
            return false;
        }

        if (maleRadio.isSelected() || femaleRadio.isSelected()) {

        } else {
            JOptionPane.showMessageDialog(null, "Gender is missing");
            return false;
        }

        if (AddressTxt.getText().equals(null) || AddressTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Address is missing");
            return false;
        }

        if (ContactTxt.getText().equals(null) || ContactTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Contact missing");
            return false;
        }
        if (EmailTxt.getText().equals(null) || EmailTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Email missing");
            return false;
        }

        return true;
    }

//    public static void main(String[] args) {
//        new AddEmployee();
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EmployeePanel = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        CategoryLab = new javax.swing.JLabel();
        AddressLab = new javax.swing.JLabel();
        AddressTxt = new javax.swing.JTextField();
        IdLab = new javax.swing.JLabel();
        IdTxt = new javax.swing.JTextField();
        EmailLab = new javax.swing.JLabel();
        ContactTxt = new javax.swing.JTextField();
        CancelBttn = new javax.swing.JButton();
        HomeBttn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UserNameLab = new javax.swing.JLabel();
        maleRadio = new javax.swing.JRadioButton();
        femaleRadio = new javax.swing.JRadioButton();
        ContactLab1 = new javax.swing.JLabel();
        EmailTxt = new javax.swing.JTextField();
        PasswordLab = new javax.swing.JLabel();
        NameLab = new javax.swing.JLabel();
        NameTxt = new javax.swing.JTextField();
        UserNameTxt = new javax.swing.JTextField();
        PasswordTxt = new javax.swing.JPasswordField();
        GenderLab = new javax.swing.JLabel();
        CategoryCambo = new javax.swing.JComboBox();
        AddBttn = new javax.swing.JButton();

        EmployeePanel.setBackground(java.awt.Color.white);
        EmployeePanel.setLayout(null);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/MTSpic.jpg"))); // NOI18N
        EmployeePanel.add(jLabel28);
        jLabel28.setBounds(10, 10, 220, 30);

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("ADD CUSTOMER");
        EmployeePanel.add(jLabel30);
        jLabel30.setBounds(260, 60, 100, 20);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Fill Employee Information Below::");
        EmployeePanel.add(jLabel31);
        jLabel31.setBounds(40, 120, 210, 15);
        EmployeePanel.add(jSeparator17);
        jSeparator17.setBounds(250, 130, 340, 10);

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        EmployeePanel.add(jSeparator18);
        jSeparator18.setBounds(9, 130, 10, 355);
        EmployeePanel.add(jSeparator19);
        jSeparator19.setBounds(10, 130, 30, 2);

        jSeparator20.setOrientation(javax.swing.SwingConstants.VERTICAL);
        EmployeePanel.add(jSeparator20);
        jSeparator20.setBounds(589, 130, 2, 354);
        EmployeePanel.add(jSeparator21);
        jSeparator21.setBounds(9, 484, 580, 20);

        CategoryLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CategoryLab.setText("Category::");
        EmployeePanel.add(CategoryLab);
        CategoryLab.setBounds(40, 320, 60, 20);

        AddressLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AddressLab.setText("Address::");
        EmployeePanel.add(AddressLab);
        AddressLab.setBounds(40, 350, 60, 15);

        AddressTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressTxtActionPerformed(evt);
            }
        });
        EmployeePanel.add(AddressTxt);
        AddressTxt.setBounds(130, 350, 140, 20);

        IdLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        IdLab.setText("Employee Id::");
        EmployeePanel.add(IdLab);
        IdLab.setBounds(40, 160, 80, 15);
        EmployeePanel.add(IdTxt);
        IdTxt.setBounds(130, 160, 140, 20);

        EmailLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EmailLab.setText("Email::");
        EmployeePanel.add(EmailLab);
        EmailLab.setBounds(40, 410, 70, 15);
        EmployeePanel.add(ContactTxt);
        ContactTxt.setBounds(130, 380, 140, 20);

        CancelBttn.setText("Cancel");
        EmployeePanel.add(CancelBttn);
        CancelBttn.setBounds(190, 450, 80, 23);

        HomeBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/homebttn.jpg"))); // NOI18N
        EmployeePanel.add(HomeBttn);
        HomeBttn.setBounds(10, 40, 80, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ADD EMPLOYEE");
        EmployeePanel.add(jLabel1);
        jLabel1.setBounds(220, 90, 100, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line3.jpg"))); // NOI18N
        EmployeePanel.add(jLabel2);
        jLabel2.setBounds(10, 90, 580, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line2.jpg"))); // NOI18N
        EmployeePanel.add(jLabel3);
        jLabel3.setBounds(10, 74, 580, 20);

        UserNameLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UserNameLab.setText("UserName::");
        EmployeePanel.add(UserNameLab);
        UserNameLab.setBounds(40, 220, 70, 15);

        maleRadio.setText("Male");
        EmployeePanel.add(maleRadio);
        maleRadio.setBounds(130, 280, 60, 23);

        femaleRadio.setText("Female");
        EmployeePanel.add(femaleRadio);
        femaleRadio.setBounds(200, 280, 70, 23);

        ContactLab1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ContactLab1.setText("Phone no:: ");
        EmployeePanel.add(ContactLab1);
        ContactLab1.setBounds(40, 380, 70, 15);
        EmployeePanel.add(EmailTxt);
        EmailTxt.setBounds(130, 410, 140, 20);

        PasswordLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PasswordLab.setText("Password::");
        EmployeePanel.add(PasswordLab);
        PasswordLab.setBounds(40, 250, 60, 15);

        NameLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NameLab.setText("Name::");
        EmployeePanel.add(NameLab);
        NameLab.setBounds(40, 190, 40, 15);
        EmployeePanel.add(NameTxt);
        NameTxt.setBounds(130, 190, 140, 20);
        EmployeePanel.add(UserNameTxt);
        UserNameTxt.setBounds(130, 220, 140, 20);
        EmployeePanel.add(PasswordTxt);
        PasswordTxt.setBounds(130, 250, 140, 20);

        GenderLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        GenderLab.setText("Gender::");
        EmployeePanel.add(GenderLab);
        GenderLab.setBounds(40, 280, 60, 20);

        CategoryCambo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Frontdesk Officer" }));
        EmployeePanel.add(CategoryCambo);
        CategoryCambo.setBounds(130, 320, 140, 20);

        AddBttn.setText("Add");
        EmployeePanel.add(AddBttn);
        AddBttn.setBounds(80, 450, 80, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EmployeePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(EmployeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddressTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBttn;
    private javax.swing.JLabel AddressLab;
    private javax.swing.JTextField AddressTxt;
    private javax.swing.JButton CancelBttn;
    private javax.swing.JComboBox CategoryCambo;
    private javax.swing.JLabel CategoryLab;
    private javax.swing.JLabel ContactLab1;
    private javax.swing.JTextField ContactTxt;
    private javax.swing.JLabel EmailLab;
    private javax.swing.JTextField EmailTxt;
    private javax.swing.JPanel EmployeePanel;
    private javax.swing.JLabel GenderLab;
    private javax.swing.JButton HomeBttn;
    private javax.swing.JLabel IdLab;
    private javax.swing.JTextField IdTxt;
    private javax.swing.JLabel NameLab;
    private javax.swing.JTextField NameTxt;
    private javax.swing.JLabel PasswordLab;
    private javax.swing.JPasswordField PasswordTxt;
    private javax.swing.JLabel UserNameLab;
    private javax.swing.JTextField UserNameTxt;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JRadioButton maleRadio;
    // End of variables declaration//GEN-END:variables
}
