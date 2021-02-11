package com.MTS.dao;

import com.MTS.database.ConnectionDatabase;
import com.MTS.dto.CustomerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustomerDAO {

    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public CustomerDAO() {
        con = new ConnectionDatabase().getConnection();
    }

    public void addCustomer(CustomerDTO customerDTO) {
        String query = "INSERT INTO customer VALUE(?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, customerDTO.getId());
            pstmt.setString(2, customerDTO.getName());
            pstmt.setString(3, customerDTO.getGender());
            pstmt.setString(4, customerDTO.getAddress());
            pstmt.setString(5, customerDTO.getContact());
            pstmt.setString(6, customerDTO.getEmail());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "One Record Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getQueryResult() {
        String sql = "SELECT * FROM customer";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static String[] columnTitle = {"Cus_Id", "Name", "Gender", "Address", "Contact", "E_mail"};

    public DefaultTableModel builtTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnName = new Vector<String>();
        // int columnCount = metaData.getColumnCount();
        int columnCount = columnTitle.length;

        for (int column = 1; column <= columnCount; column++) {
            columnName.add(columnTitle[column - 1]);
            // columnName.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnName);

    }

    public CustomerDTO editCustomer(JTable table) {
        CustomerDTO customerEdit = new CustomerDTO();
        customerEdit.setId((String) table.getValueAt(table.getSelectedRow(), 0));
        customerEdit.setName((String) table.getValueAt(table.getSelectedRow(), 1));
        customerEdit.setGender((String) table.getValueAt(table.getSelectedRow(), 2));
        customerEdit.setAddress((String) table.getValueAt(table.getSelectedRow(), 3));
        customerEdit.setContact((String) table.getValueAt(table.getSelectedRow(), 4));
        customerEdit.setEmail((String) table.getValueAt(table.getSelectedRow(), 5));
        return customerEdit;

    }

    public void upDateCustomer(CustomerDTO customerUpdate) {
        try {
            String query = "UPDATE customer SET Name=?,Gender=?,Address=?,Contact=?,Email=? WHERE Cus_ID=?";
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, customerUpdate.getName());
            pstmt.setString(2, customerUpdate.getGender());
            pstmt.setString(3, customerUpdate.getAddress());
            pstmt.setString(4, customerUpdate.getContact());
            pstmt.setString(5, customerUpdate.getEmail());
            pstmt.setString(6, customerUpdate.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "One Record Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String value) {
        try {
            String query = "DELETE FROM customer WHERE Cus_ID=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, value);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "One Record Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String returnQueryToGetColumnNames() {
        String query = "SELECT Cus_ID,Name,Gender,Address,Contact,Email FROM customer";
        return query;
    }

    //this method is to set the column names in combobox for searching
    public Vector<String> getColumnNames(String query) {
        Vector<String> columnNames = new Vector<String>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnNames;
    }

    public DefaultTableModel searchCustomer(String name, String value) throws SQLException {
        String sql = "";
     
            sql = "SELECT  Cus_ID,Name,Gender,Address,Contact,Email FROM customer WHERE " + name + "='" + value + "'";
       
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnName = new Vector<String>();
        int columnCount = metaData.getColumnCount();

        for (int column = 1; column <= columnCount; column++) {
            columnName.add(columnTitle[column - 1]);
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "No search Found");
        } else {
            rs.beforeFirst();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
            //return new DefaultTableModel(data, columnName);
        }
       return new DefaultTableModel(data, columnName);

    }

    public Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Cus_Id");
        columnNames.add("Name");
        columnNames.add("Gender");
        columnNames.add("Address");
        columnNames.add("Contact");
        columnNames.add("E-Mail");
        return columnNames;

    }

}
