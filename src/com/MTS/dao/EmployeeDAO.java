package com.MTS.dao;

import com.MTS.database.ConnectionDatabase;
import com.MTS.dto.CustomerDTO;
import com.MTS.dto.EmployeeDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmployeeDAO {

    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public EmployeeDAO() {
        con = new ConnectionDatabase().getConnection();
    }

    public void addEmployee(EmployeeDTO employeeDTO) {
        String query = "INSERT INTO employee VALUE(?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, employeeDTO.getId());
            pstmt.setString(2, employeeDTO.getName());
            pstmt.setString(3, employeeDTO.getUserName());
            pstmt.setString(4, employeeDTO.getPassword());
            pstmt.setString(5, employeeDTO.getGender());
            pstmt.setString(6, employeeDTO.getCategory());
            pstmt.setString(7, employeeDTO.getAddress());
            pstmt.setString(8, employeeDTO.getContact());
            pstmt.setString(9, employeeDTO.getEmail());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "One Record Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query1 = "INSERT INTO login VALUE(?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query1);
            pstmt.setString(1, employeeDTO.getId());
            pstmt.setString(2, employeeDTO.getUserName());
            pstmt.setString(3, employeeDTO.getPassword());
            pstmt.setString(4, employeeDTO.getCategory());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getQueryResult() {
        String sql = "SELECT * FROM employee";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static String[] columnTitle = {"Emp_Id", "Name", "UserName", "Password", "Gender", "Category", "Address", "Contact", "E_mail"};

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

    public EmployeeDTO editEmployee(JTable table) {
        EmployeeDTO employeeEdit = new EmployeeDTO();
        employeeEdit.setId((String) table.getValueAt(table.getSelectedRow(), 0));
        employeeEdit.setName((String) table.getValueAt(table.getSelectedRow(), 1));
        employeeEdit.setUserName((String) table.getValueAt(table.getSelectedRow(), 2));
        employeeEdit.setPassword((String) table.getValueAt(table.getSelectedRow(), 3));
        employeeEdit.setGender((String) table.getValueAt(table.getSelectedRow(), 4));
        employeeEdit.setCategory((String) table.getValueAt(table.getSelectedRow(), 5));
        employeeEdit.setAddress((String) table.getValueAt(table.getSelectedRow(), 6));
        employeeEdit.setContact((String) table.getValueAt(table.getSelectedRow(), 7));
        employeeEdit.setEmail((String) table.getValueAt(table.getSelectedRow(), 8));
        return employeeEdit;

    }

    public void upDateEmployee(EmployeeDTO employeeUpdate) {
        try {
            String query = "UPDATE employee SET Name=?,UserName=?,Gender=?,Category=?,Address=?,Contact=?,Email=? WHERE Emp_ID=?";
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, employeeUpdate.getName());
            pstmt.setString(2, employeeUpdate.getUserName());
            pstmt.setString(3, employeeUpdate.getGender());
            pstmt.setString(4, employeeUpdate.getCategory());
            pstmt.setString(5, employeeUpdate.getAddress());
            pstmt.setString(6, employeeUpdate.getContact());
            pstmt.setString(7, employeeUpdate.getEmail());
            pstmt.setString(8, employeeUpdate.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "One Record Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String query = "UPDATE login SET Name=?,Category=? WHERE ID=?";
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, employeeUpdate.getUserName());
            pstmt.setString(2, employeeUpdate.getCategory());
            pstmt.setString(3, employeeUpdate.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String value) {
        try {
            String query = "DELETE FROM employee WHERE Emp_ID=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, value);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "One Record Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String query = "DELETE FROM login WHERE ID=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, value);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String returnQueryToGetColumnNames() {
        String query = "SELECT Emp_ID,Name,UserName,Gender,Category,Address,Contact,Email FROM employee";
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

    public DefaultTableModel searchEmployee(String name, String value) throws SQLException {
        String sql = "";

        sql = "SELECT Emp_ID,Name,UserName,Gender,Category,Address,Contact,Email FROM employee WHERE " + name + "='" + value + "'";

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
            JOptionPane.showMessageDialog(null, "No Search Found");
        } else {
            rs.beforeFirst();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
        }
        return new DefaultTableModel(data, columnName);

    }

    public Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Emp_Id");
        columnNames.add("Name");
        columnNames.add("UserName");
        columnNames.add("Password");
        columnNames.add("Gender");
        columnNames.add("Category");
        columnNames.add("Address");
        columnNames.add("Contact");
        columnNames.add("E-Mail");
        return columnNames;

    }

}
