package com.MTS.ui;

import com.MTS.dao.CustomerDAO;
import com.MTS.dao.EmployeeDAO;
import com.MTS.dao.MovieDAO;
import com.MTS.dto.CustomerDTO;
import com.MTS.dto.EmployeeDTO;
import com.MTS.dto.MovieDTO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DetailPanel extends javax.swing.JPanel {

    JFrame frame = new JFrame("Movie Ticketing System");
    ListSelectionModel lsm1, lsm2, lsm3;

    public void setVisibilityFalse() {
        frame.setVisible(false);

    }

    public DetailPanel() {
        initComponents();

        empTable.setPreferredScrollableViewportSize(new Dimension(1000, 100));
        loadEmployeeData();

        cusTable.setPreferredScrollableViewportSize(new Dimension(1000, 100));
        loadCustomerData();

        movTable.setPreferredScrollableViewportSize(new Dimension(1000, 100));
        loadMovieData();

        cusDeleteBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (lsm1 != null && !lsm1.isSelectionEmpty()) {
                    cusDeleteBtnActionPerformed(ae);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            }
        });

        empDeleteBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (lsm2 != null && !lsm2.isSelectionEmpty()) {
                    empDeleteBtnActionPerformed(ae);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            }
        });

        movDeleteBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (lsm3 != null && !lsm3.isSelectionEmpty()) {
                    movDeleteBtnActionPerformed(ae);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            }
        });

        cusEditBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (lsm1 != null && !lsm1.isSelectionEmpty()) {
                    cusEditBtnActionPerformed(ae);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid!!!");
                }

            }
        });

        empEditBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (lsm2 != null && !lsm2.isSelectionEmpty()) {
                    empEditBtnActionPerformed(ae);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid!!!");
                }

            }
        });

        movEditBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (lsm3 != null && !lsm3.isSelectionEmpty()) {
                    movEditBtnActionPerformed(ae);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid!!!");
                }

            }
        });

        CusSearchBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cusSearchBttnActionPerformed(e);
            }
        });

        empSearchBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                empSearchBttnActionPerformed(e);
            }
        });

        movSearchBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                movSearchBttnActionPerformed(e);
            }
        });

        CustomerDAO userDAO = new CustomerDAO();
        cusSearchCombo.setModel(new DefaultComboBoxModel(userDAO.getColumnNames(userDAO.returnQueryToGetColumnNames())));

        EmployeeDAO empDAO = new EmployeeDAO();
        empSearchCombo.setModel(new DefaultComboBoxModel(empDAO.getColumnNames(empDAO.returnQueryToGetColumnNames())));

        MovieDAO movDAO = new MovieDAO();
        movSearchCombo.setModel(new DefaultComboBoxModel(movDAO.getColumnNames(movDAO.returnQueryToGetColumnNames())));

        ListSelectionModel listSelectionModel = cusTable.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                lsm1 = (ListSelectionModel) e.getSource();

            }
        });

        ListSelectionModel listSelectionModel1 = empTable.getSelectionModel();
        listSelectionModel1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                lsm2 = (ListSelectionModel) e.getSource();

            }
        });

        ListSelectionModel listSelectionModel2 = movTable.getSelectionModel();
        listSelectionModel2.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                lsm3 = (ListSelectionModel) e.getSource();

            }
        });

        //  frame.add(Movie);
        frame.add(Panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        Toolkit thekit = this.getToolkit();
        Dimension dim = thekit.getScreenSize();
        frame.setBounds(dim.width / 7, dim.height / 5, 1015, 470);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void cusDeleteBtnActionPerformed(ActionEvent ae) {
        new CustomerDAO().delete(String.valueOf(cusTable.getValueAt(cusTable.getSelectedRow(), 0)));
        loadCustomerData();
    }

    private void empDeleteBtnActionPerformed(ActionEvent ae) {
        new EmployeeDAO().delete(String.valueOf(empTable.getValueAt(empTable.getSelectedRow(), 0)));
        loadEmployeeData();
    }

    private void movDeleteBtnActionPerformed(ActionEvent ae) {
        new MovieDAO().delete(String.valueOf(movTable.getValueAt(movTable.getSelectedRow(), 0)));
        loadMovieData();
    }

    private void cusEditBtnActionPerformed(ActionEvent ae) {
        CustomerDTO userEdit = new CustomerDAO().editCustomer(cusTable);

        String[] values = new String[6];

        values[0] = userEdit.getId();
        values[1] = userEdit.getName();
        values[2] = userEdit.getAddress();
        values[3] = userEdit.getContact();
        values[4] = userEdit.getEmail();
        values[5] = userEdit.getGender();
        // JOptionPane.showMessageDialog(null, userEdit.getGender());
        customerEdit ce = new customerEdit();
        ce.sendCusTable(values);
        

         frame.dispose();
    }

    private void empEditBtnActionPerformed(ActionEvent ae) {
        EmployeeDTO userEdit = new EmployeeDAO().editEmployee(empTable);

        String[] values = new String[9];

        values[0] = userEdit.getId();
        values[1] = userEdit.getName();
        values[2] = userEdit.getUserName();
        values[3] = userEdit.getPassword();
        values[4] = userEdit.getGender();
        values[5] = userEdit.getAddress();
        values[6] = userEdit.getContact();
        values[7] = userEdit.getEmail();
        values[8] = userEdit.getCategory();
        // JOptionPane.showMessageDialog(null, userEdit.getGender());
        employeeEdit ce = new employeeEdit();
        ce.sendEmpTable(values);

          frame.dispose();
    }

    private void movEditBtnActionPerformed(ActionEvent ae) {
        MovieDTO userEdit = new MovieDAO().editMovie(movTable);

        String[] values = new String[5];

        values[0] = userEdit.getMovName();
        values[1] = userEdit.getGenre();
        values[2] = userEdit.getDirector();
        values[3] = userEdit.getRelDate();
        values[4] = userEdit.getLength();
        // JOptionPane.showMessageDialog(null, userEdit.getGender());
        movieEdit ce = new movieEdit();
        ce.sendMovTable(values);

          frame.dispose();
    }

    private void cusSearchBttnActionPerformed(ActionEvent e) {
        CustomerDAO userDAO = new CustomerDAO();
        if (cusSearchValidation()) {
            String name = cusSearchCombo.getSelectedItem().toString();
            String value = CusSearchTxt.getText();
            try {
                cusTable.setModel(userDAO.searchCustomer(name, value));
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter in Search Fileld");
        }
        CusSearchTxt.setText("");
        // loadCustomerData();
    }

    private void empSearchBttnActionPerformed(ActionEvent e) {
        EmployeeDAO userDAO = new EmployeeDAO();
        if (empSearchValidation()) {
            String name = empSearchCombo.getSelectedItem().toString();
            String value = empSearchTxt.getText();
            try {
                empTable.setModel(userDAO.searchEmployee(name, value));
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter in Search Fileld");
        }
        empSearchTxt.setText("");
    }

    private void movSearchBttnActionPerformed(ActionEvent e) {
        MovieDAO userDAO = new MovieDAO();
        if (movSearchValidation()) {
            String name = movSearchCombo.getSelectedItem().toString();
            String value = movSearchTxt.getText();
            try {
                movTable.setModel(userDAO.searchMovie(name, value));
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter in Search Fileld");
        }
        movSearchTxt.setText("");
    }

    public void loadEmployeeData() {
        try {
            EmployeeDAO userDAO = new EmployeeDAO();
            empTable.setModel(userDAO.builtTableModel(userDAO.getQueryResult()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCustomerData() {
        try {
            CustomerDAO userDAO = new CustomerDAO();
            cusTable.setModel(userDAO.builtTableModel(userDAO.getQueryResult()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMovieData() {
        try {
            MovieDAO userDAO = new MovieDAO();
            movTable.setModel(userDAO.builtTableModel(userDAO.getQueryResult()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCusColumnName() {
        cusTable.setModel(new DefaultTableModel(null, new CustomerDAO().getColumnNames()));
    }

    public void loadEmpColumnName() {
        empTable.setModel(new DefaultTableModel(null, new CustomerDAO().getColumnNames()));
    }

    public void loadMovColumnName() {
        movTable.setModel(new DefaultTableModel(null, new CustomerDAO().getColumnNames()));
    }


    public boolean cusSearchValidation() {
        if (CusSearchTxt.getText() != null && CusSearchTxt.getText().length() > 0) {
            return true;
        }
        return false;
    }

    public boolean empSearchValidation() {
        if (empSearchTxt.getText() != null && empSearchTxt.getText().length() > 0) {
            return true;
        }
        return false;
    }

    public boolean movSearchValidation() {
        if (movSearchTxt.getText() != null && movSearchTxt.getText().length() > 0) {
            return true;
        }
        return false;
    }

//    public static void main(String[] args) {
//        new DetailPanel();
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        HomeBttn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Movie = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cusTable = new javax.swing.JTable();
        cusEditBttn = new javax.swing.JButton();
        cusDeleteBttn = new javax.swing.JButton();
        searchLab = new javax.swing.JLabel();
        cusSearchCombo = new javax.swing.JComboBox();
        CusSearchTxt = new javax.swing.JTextField();
        CusSearchBttn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        empEditBttn = new javax.swing.JButton();
        empDeleteBttn = new javax.swing.JButton();
        searchLab1 = new javax.swing.JLabel();
        empSearchCombo = new javax.swing.JComboBox();
        empSearchTxt = new javax.swing.JTextField();
        empSearchBttn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        movTable = new javax.swing.JTable();
        movEditBttn = new javax.swing.JButton();
        movDeleteBttn = new javax.swing.JButton();
        searchLab2 = new javax.swing.JLabel();
        movSearchCombo = new javax.swing.JComboBox();
        movSearchTxt = new javax.swing.JTextField();
        movSearchBttn = new javax.swing.JButton();

        Panel.setBackground(java.awt.Color.white);
        Panel.setLayout(null);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/MTSpic.jpg"))); // NOI18N
        Panel.add(jLabel28);
        jLabel28.setBounds(10, 10, 220, 30);

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("ADD CUSTOMER");
        Panel.add(jLabel30);
        jLabel30.setBounds(260, 60, 100, 20);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Here's The Information::");
        Panel.add(jLabel31);
        jLabel31.setBounds(40, 120, 160, 15);
        Panel.add(jSeparator17);
        jSeparator17.setBounds(190, 130, 810, 10);

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel.add(jSeparator18);
        jSeparator18.setBounds(9, 130, 10, 300);
        Panel.add(jSeparator19);
        jSeparator19.setBounds(10, 130, 30, 2);

        jSeparator20.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel.add(jSeparator20);
        jSeparator20.setBounds(1000, 130, 2, 300);
        Panel.add(jSeparator21);
        jSeparator21.setBounds(9, 430, 990, 10);

        HomeBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/homebttn.jpg"))); // NOI18N
        HomeBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBttnActionPerformed(evt);
            }
        });
        Panel.add(HomeBttn);
        HomeBttn.setBounds(10, 40, 80, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Details");
        Panel.add(jLabel1);
        jLabel1.setBounds(500, 90, 50, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line3.jpg"))); // NOI18N
        Panel.add(jLabel2);
        jLabel2.setBounds(10, 90, 990, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/line2.jpg"))); // NOI18N
        Panel.add(jLabel3);
        jLabel3.setBounds(10, 74, 990, 20);

        Movie.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Movie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MovieMouseClicked(evt);
            }
        });

        cusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cusTable);

        cusEditBttn.setText("Edit");
        cusEditBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cusEditBttnActionPerformed(evt);
            }
        });

        cusDeleteBttn.setText("Delete");

        searchLab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchLab.setText("Search By::");

        cusSearchCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CusSearchBttn.setText("Search");
        CusSearchBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusSearchBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(cusEditBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(cusDeleteBttn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchLab, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cusSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CusSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CusSearchBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLab, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cusSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CusSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CusSearchBttn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cusEditBttn)
                    .addComponent(cusDeleteBttn))
                .addContainerGap())
        );

        Movie.addTab("Customer", jPanel1);

        empTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(empTable);

        empEditBttn.setText("Edit");

        empDeleteBttn.setText("Delete");

        searchLab1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchLab1.setText("Search By::");

        empSearchCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        empSearchBttn.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(empEditBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(empDeleteBttn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchLab1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(empSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(empSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(empSearchBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLab1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empSearchBttn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empDeleteBttn)
                    .addComponent(empEditBttn))
                .addContainerGap())
        );

        Movie.addTab("Employee", jPanel2);

        movTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(movTable);

        movEditBttn.setText("Edit");

        movDeleteBttn.setText("Delete");

        searchLab2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchLab2.setText("Search By::");

        movSearchCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        movSearchBttn.setText("Search");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(searchLab2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(movSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(movSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(movSearchBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(349, 349, 349)
                            .addComponent(movEditBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(movDeleteBttn))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLab2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(movSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(movSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(movSearchBttn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movEditBttn)
                    .addComponent(movDeleteBttn))
                .addContainerGap())
        );

        Movie.addTab("Movie", jPanel3);

        Panel.add(Movie);
        Movie.setBounds(20, 140, 970, 280);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cusEditBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cusEditBttnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cusEditBttnActionPerformed

    private void CusSearchBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusSearchBttnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CusSearchBttnActionPerformed

    private void MovieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovieMouseClicked
        // TODO add your handling code here:
        loadCustomerData();
        loadEmployeeData();
        loadMovieData();
    }//GEN-LAST:event_MovieMouseClicked

    private void HomeBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBttnActionPerformed
        // TODO add your handling code here:
        new AdminPanel();
        frame.dispose();
    }//GEN-LAST:event_HomeBttnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CusSearchBttn;
    private javax.swing.JTextField CusSearchTxt;
    private javax.swing.JButton HomeBttn;
    private javax.swing.JTabbedPane Movie;
    private javax.swing.JPanel Panel;
    private javax.swing.JButton cusDeleteBttn;
    private javax.swing.JButton cusEditBttn;
    private javax.swing.JComboBox cusSearchCombo;
    public javax.swing.JTable cusTable;
    private javax.swing.JButton empDeleteBttn;
    private javax.swing.JButton empEditBttn;
    private javax.swing.JButton empSearchBttn;
    private javax.swing.JComboBox empSearchCombo;
    private javax.swing.JTextField empSearchTxt;
    private javax.swing.JTable empTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JButton movDeleteBttn;
    private javax.swing.JButton movEditBttn;
    private javax.swing.JButton movSearchBttn;
    private javax.swing.JComboBox movSearchCombo;
    private javax.swing.JTextField movSearchTxt;
    private javax.swing.JTable movTable;
    private javax.swing.JLabel searchLab;
    private javax.swing.JLabel searchLab1;
    private javax.swing.JLabel searchLab2;
    // End of variables declaration//GEN-END:variables
}
