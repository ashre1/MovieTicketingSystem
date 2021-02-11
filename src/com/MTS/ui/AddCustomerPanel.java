package com.MTS.ui;

import com.MTS.dao.CustomerDAO;
import com.MTS.database.ConnectionDatabase;
import com.MTS.dto.CustomerDTO;
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

public class AddCustomerPanel extends javax.swing.JPanel {

    JFrame frame = new JFrame();
    String gender = "Male";
    ButtonGroup genderGroup;

    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public AddCustomerPanel() {
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
        frame.add(Panel);
        Toolkit thekit = frame.getToolkit();
        Dimension dim = thekit.getScreenSize();
        frame.setBounds(dim.width / 4, dim.height / 4, 610, 455);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void addBtnActionPerformed(ActionEvent e) {
        CustomerDTO user = new CustomerDTO();
        if (femaleRadio.isSelected()) {
            gender = "Female";
        } else {
            gender = "Male";
        }
        user.setId(IdTxt.getText());
        user.setName(NameTxt.getText());
        user.setGender(gender);
        user.setAddress(AddressTxt.getText());
        user.setContact(ContactTxt.getText());
        user.setEmail(EmailTxt.getText());
        new CustomerDAO().addCustomer(user);
        clearField();
        // loadData();
    }

    private void clearField() {
        IdTxt.setText("");
        NameTxt.setText("");
        AddressTxt.setText("");
        ContactTxt.setText("");
        EmailTxt.setText("");
        genderGroup.clearSelection();

    }

    public boolean addValidation() {

        String a = IdTxt.getText();
        if (a != null && a.length() == 4) {
            if (a.substring(0, 1).matches("C") && Character.isDigit(a.charAt(1)) && Character.isDigit(a.charAt(2)) && Character.isDigit(a.charAt(3))) {
                String query = "SELECT Cus_ID FROM customer WHERE Cus_ID= '" + IdTxt.getText() + "'";
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

//    public static void main(String[] args) {
//        new AddCustomerPanel();
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        Panel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        EmailTxt = new javax.swing.JTextField();
        AddressLab = new javax.swing.JLabel();
        IdLab = new javax.swing.JLabel();
        IdTxt = new javax.swing.JTextField();
        EmailLab = new javax.swing.JLabel();
        ContactTxt = new javax.swing.JTextField();
        AddBttn = new javax.swing.JButton();
        CancelBttn = new javax.swing.JButton();
        HomeBttn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NameTxt = new javax.swing.JTextField();
        NameLab = new javax.swing.JLabel();
        ContactLab1 = new javax.swing.JLabel();
        AddressTxt = new javax.swing.JTextField();
        GenderLab = new javax.swing.JLabel();
        femaleRadio = new javax.swing.JRadioButton();
        maleRadio = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);
        add(jSeparator4);
        jSeparator4.setBounds(20, 150, 0, 2);

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
        jLabel17.setText("Fill Customer Information Below::");
        Panel.add(jLabel17);
        jLabel17.setBounds(40, 120, 210, 15);
        Panel.add(jSeparator7);
        jSeparator7.setBounds(250, 130, 330, 10);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel.add(jSeparator8);
        jSeparator8.setBounds(10, 130, 2, 270);
        Panel.add(jSeparator9);
        jSeparator9.setBounds(10, 130, 30, 2);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel.add(jSeparator10);
        jSeparator10.setBounds(580, 130, 2, 270);
        Panel.add(jSeparator11);
        jSeparator11.setBounds(10, 400, 570, 10);
        Panel.add(EmailTxt);
        EmailTxt.setBounds(130, 310, 140, 20);

        AddressLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AddressLab.setText("Address::");
        Panel.add(AddressLab);
        AddressLab.setBounds(40, 250, 60, 15);

        IdLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        IdLab.setText("Customer Id::");
        Panel.add(IdLab);
        IdLab.setBounds(40, 160, 80, 15);
        Panel.add(IdTxt);
        IdTxt.setBounds(130, 160, 140, 20);

        EmailLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EmailLab.setText("Email::");
        Panel.add(EmailLab);
        EmailLab.setBounds(40, 310, 60, 15);
        Panel.add(ContactTxt);
        ContactTxt.setBounds(130, 280, 140, 20);

        AddBttn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Desktop\\1406803908_Add-Male-User.png")); // NOI18N
        AddBttn.setText("Add");
        Panel.add(AddBttn);
        AddBttn.setBounds(20, 340, 120, 50);

        CancelBttn.setIcon(new javax.swing.ImageIcon("D:\\NCCS BIM\\6th Semester\\CSC\\pics_icons\\cancel.png")); // NOI18N
        CancelBttn.setText("Cancel");
        Panel.add(CancelBttn);
        CancelBttn.setBounds(160, 340, 110, 40);

        HomeBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/homebttn.jpg"))); // NOI18N
        Panel.add(HomeBttn);
        HomeBttn.setBounds(0, 40, 80, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ADD CUSTOMERS");
        Panel.add(jLabel1);
        jLabel1.setBounds(220, 90, 100, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line3.jpg"))); // NOI18N
        Panel.add(jLabel2);
        jLabel2.setBounds(10, 90, 570, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line2.jpg"))); // NOI18N
        Panel.add(jLabel3);
        jLabel3.setBounds(10, 74, 570, 20);
        Panel.add(NameTxt);
        NameTxt.setBounds(130, 190, 140, 20);

        NameLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NameLab.setText("Name::");
        Panel.add(NameLab);
        NameLab.setBounds(40, 190, 40, 15);

        ContactLab1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ContactLab1.setText("Phone no:: ");
        Panel.add(ContactLab1);
        ContactLab1.setBounds(40, 280, 70, 15);
        Panel.add(AddressTxt);
        AddressTxt.setBounds(130, 250, 140, 20);

        GenderLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        GenderLab.setText("Gender::");
        Panel.add(GenderLab);
        GenderLab.setBounds(40, 220, 60, 20);

        femaleRadio.setText("Female");
        Panel.add(femaleRadio);
        femaleRadio.setBounds(200, 220, 70, 23);

        maleRadio.setText("Male");
        Panel.add(maleRadio);
        maleRadio.setBounds(130, 220, 60, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/ticketImg.jpg"))); // NOI18N
        Panel.add(jLabel5);
        jLabel5.setBounds(280, 150, 300, 200);

        add(Panel);
        Panel.setBounds(0, 0, 590, 420);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBttn;
    private javax.swing.JLabel AddressLab;
    private javax.swing.JTextField AddressTxt;
    private javax.swing.JButton CancelBttn;
    private javax.swing.JLabel ContactLab1;
    private javax.swing.JTextField ContactTxt;
    private javax.swing.JLabel EmailLab;
    private javax.swing.JTextField EmailTxt;
    private javax.swing.JLabel GenderLab;
    private javax.swing.JButton HomeBttn;
    private javax.swing.JLabel IdLab;
    private javax.swing.JTextField IdTxt;
    private javax.swing.JLabel NameLab;
    private javax.swing.JTextField NameTxt;
    private javax.swing.JPanel Panel;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JRadioButton maleRadio;
    // End of variables declaration//GEN-END:variables
}
