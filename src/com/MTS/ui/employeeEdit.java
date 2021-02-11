package com.MTS.ui;

import com.MTS.dao.EmployeeDAO;
import com.MTS.database.ConnectionDatabase;
import com.MTS.dto.EmployeeDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class employeeEdit extends javax.swing.JDialog {

    ButtonGroup genderGroup;
    String gender;
    String combo;


    public void sendEmpTable(String[] tableValues) {
        IdTxt.setText(tableValues[0]);
        // JOptionPane.showMessageDialog(null, userEdit.getId());
        IdTxt.setEditable(false);
        NameTxt.setText(tableValues[1]);
        userNameTxt.setText(tableValues[2]);
        passwordTxt.setText(tableValues[3]);
        passwordTxt.setEditable(false);
        AddressTxt.setText(tableValues[5]);
        ContactTxt.setText(tableValues[6]);
        EmailTxt.setText(tableValues[7]);
        gender = tableValues[4];
        if (tableValues[4].equalsIgnoreCase("Male")) {
            maleRadio.setSelected(true);
        } else {
            femaleRadio.setSelected(true);
        }
        combo = tableValues[8];
        CategoryCambo.setSelectedItem(combo);
    }

    public employeeEdit() {

        initComponents();


        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        updateBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (femaleRadio.isSelected()) {
                    gender = "Female";
                } else {
                    gender = "Male";
                }

                //  combo = CategoryCambo.getSelectedItem().toString();
                EmployeeDTO userUpdate = new EmployeeDTO();
                userUpdate.setId(IdTxt.getText());
                userUpdate.setName(NameTxt.getText());
                userUpdate.setUserName(userNameTxt.getText());
                userUpdate.setPassword(new String(passwordTxt.getPassword()));
                userUpdate.setAddress(AddressTxt.getText());
                userUpdate.setContact(ContactTxt.getText());
                userUpdate.setEmail(EmailTxt.getText());
                userUpdate.setGender(gender);
                userUpdate.setCategory(combo);
                if (Validation()) {
                    new EmployeeDAO().upDateEmployee(userUpdate);
                }
                IdTxt.setEditable(true);
                passwordTxt.setEditable(true);
                DetailPanel dp = new DetailPanel();
                dp.loadEmployeeData();
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
        setBounds(500, 200, 290, 370);
        setLocationRelativeTo(null);
        add(panel);
        setVisible(true);
    }

    public boolean Validation() {

        if (NameTxt.getText().equals(null) || NameTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Name is missing");
            return false;
        }

        if (userNameTxt.getText().equals(null) || userNameTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "UserName is missing");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        IdLab = new javax.swing.JLabel();
        IdTxt = new javax.swing.JTextField();
        NameLab = new javax.swing.JLabel();
        NameTxt = new javax.swing.JTextField();
        GenderLab = new javax.swing.JLabel();
        maleRadio = new javax.swing.JRadioButton();
        femaleRadio = new javax.swing.JRadioButton();
        AddressTxt = new javax.swing.JTextField();
        AddressLab = new javax.swing.JLabel();
        ContactLab1 = new javax.swing.JLabel();
        EmailLab = new javax.swing.JLabel();
        updateBttn = new javax.swing.JButton();
        cancelBttn = new javax.swing.JButton();
        EmailTxt = new javax.swing.JTextField();
        ContactTxt = new javax.swing.JTextField();
        userNameLab = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        CategoryLab = new javax.swing.JLabel();
        CategoryCambo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        IdLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        IdLab.setText("Employee Id::");

        NameLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NameLab.setText("Name::");

        GenderLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        GenderLab.setText("Gender::");

        maleRadio.setText("Male");

        femaleRadio.setText("Female");

        AddressLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AddressLab.setText("Address::");

        ContactLab1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ContactLab1.setText("Phone no:: ");

        EmailLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EmailLab.setText("Email::");

        updateBttn.setText("Update");

        cancelBttn.setText("Cancel");

        userNameLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        userNameLab.setText("UserName::");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Password::");

        userNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTxtActionPerformed(evt);
            }
        });

        CategoryLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CategoryLab.setText("Category");

        CategoryCambo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Frontdesk Officer" }));
        CategoryCambo.setSelectedItem(null);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ContactLab1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailLab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(updateBttn)
                        .addGap(33, 33, 33)
                        .addComponent(cancelBttn))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelLayout.createSequentialGroup()
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameLab)
                                        .addComponent(jLabel2))
                                    .addGap(50, 50, 50))
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(IdLab, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)))
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(IdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NameTxt)
                                    .addComponent(userNameTxt)
                                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelLayout.createSequentialGroup()
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(GenderLab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AddressLab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(53, 53, 53))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                    .addComponent(CategoryLab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(AddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(maleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(femaleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(ContactTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(EmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CategoryCambo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdLab)
                    .addComponent(IdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLab)
                    .addComponent(NameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameLab)
                    .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenderLab, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maleRadio)
                    .addComponent(femaleRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategoryLab)
                    .addComponent(CategoryCambo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddressLab)
                    .addComponent(AddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContactLab1)
                    .addComponent(ContactTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailLab)
                    .addComponent(EmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBttn)
                    .addComponent(cancelBttn))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressLab;
    private javax.swing.JTextField AddressTxt;
    private javax.swing.JComboBox CategoryCambo;
    private javax.swing.JLabel CategoryLab;
    private javax.swing.JLabel ContactLab1;
    private javax.swing.JTextField ContactTxt;
    private javax.swing.JLabel EmailLab;
    private javax.swing.JTextField EmailTxt;
    private javax.swing.JLabel GenderLab;
    private javax.swing.JLabel IdLab;
    private javax.swing.JTextField IdTxt;
    private javax.swing.JLabel NameLab;
    private javax.swing.JTextField NameTxt;
    private javax.swing.JButton cancelBttn;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JButton updateBttn;
    private javax.swing.JLabel userNameLab;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
}
