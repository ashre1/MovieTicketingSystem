package com.MTS.ui;

import com.MTS.dao.CustomerDAO;
import com.MTS.database.ConnectionDatabase;
import com.MTS.dto.CustomerDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class customerEdit extends javax.swing.JDialog {

    ButtonGroup genderGroup;
    String gender;


    public void sendCusTable(String[] tableValues) {
        IdTxt.setText(tableValues[0]);
        // JOptionPane.showMessageDialog(null, userEdit.getId());
        IdTxt.setEditable(false);
        NameTxt.setText(tableValues[1]);
        AddressTxt.setText(tableValues[2]);
        ContactTxt.setText(tableValues[3]);
        EmailTxt.setText(tableValues[4]);
        gender = tableValues[5];
        if (tableValues[5].equalsIgnoreCase("Male")) {
            maleRadio.setSelected(true);
        } else {
            femaleRadio.setSelected(true);
        }
    }

    public customerEdit() {
        initComponents();
        //   dp.setVisibilityFalse();
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
                CustomerDTO userUpdate = new CustomerDTO();
                userUpdate.setId(IdTxt.getText());
                userUpdate.setName(NameTxt.getText());
                userUpdate.setAddress(AddressTxt.getText());
                userUpdate.setContact(ContactTxt.getText());
                userUpdate.setEmail(EmailTxt.getText());
                userUpdate.setGender(gender);

                if (validation()) {
                    new CustomerDAO().upDateCustomer(userUpdate);
                }
                IdTxt.setEditable(true);

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

        setTitle("Customer Edit");
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setResizable(false);
        setBounds(500, 200, 270, 265);
        setLocationRelativeTo(null);
        add(panel);
        setVisible(true);

    }

    public boolean validation() {

        if (NameTxt.getText().equals(null) || NameTxt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Name is missing");
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
            JOptionPane.showMessageDialog(null, "Contact is missing");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        IdLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        IdLab.setText("Customer Id::");

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

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(NameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(NameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(GenderLab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(maleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(femaleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(AddressLab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(AddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(ContactLab1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(ContactTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(EmailLab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(EmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(IdLab, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(IdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(updateBttn)
                        .addGap(43, 43, 43)
                        .addComponent(cancelBttn)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdLab)
                    .addComponent(IdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLab)
                    .addComponent(NameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GenderLab, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maleRadio)
                    .addComponent(femaleRadio))
                .addGap(7, 7, 7)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddressLab)
                    .addComponent(AddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContactLab1)
                    .addComponent(ContactTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmailLab)
                    .addComponent(EmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBttn)
                    .addComponent(cancelBttn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressLab;
    private javax.swing.JTextField AddressTxt;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JPanel panel;
    private javax.swing.JButton updateBttn;
    // End of variables declaration//GEN-END:variables
}
