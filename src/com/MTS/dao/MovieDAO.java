package com.MTS.dao;

import com.MTS.database.ConnectionDatabase;
import com.MTS.dto.CustomerDTO;
import com.MTS.dto.MovieDTO;
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

public class MovieDAO {

    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public MovieDAO() {
        con = new ConnectionDatabase().getConnection();
    }

    public void addMovie(MovieDTO movieDTO) {
        String query = "INSERT INTO movie VALUE(?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, movieDTO.getMovName());
            pstmt.setString(2, movieDTO.getGenre());
            pstmt.setString(3, movieDTO.getDirector());
            pstmt.setString(4, movieDTO.getRelDate());
            pstmt.setString(5, movieDTO.getLength());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Change successfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getQueryResult() {
        String sql = "SELECT * FROM movie";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static String[] columnTitle = {"Mov_Name", "Genre", "Director", "Release_Date", "Length"};

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

    public MovieDTO editMovie(JTable table) {
        MovieDTO movieEdit = new MovieDTO();
        movieEdit.setMovName((String) table.getValueAt(table.getSelectedRow(), 0));
        movieEdit.setGenre((String) table.getValueAt(table.getSelectedRow(), 1));
        movieEdit.setDirector((String) table.getValueAt(table.getSelectedRow(), 2));
        movieEdit.setRelDate((String) table.getValueAt(table.getSelectedRow(), 3));
        movieEdit.setLength((String) table.getValueAt(table.getSelectedRow(), 4));
        return movieEdit;

    }

    public void upDateMovie(MovieDTO movieUpdate) {
        try {
            String query = "UPDATE movie SET Genre=?,Director=?,Release_Date=?,Length=? WHERE Mov_Name=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, movieUpdate.getGenre());
            pstmt.setString(2, movieUpdate.getDirector());
            pstmt.setString(3, movieUpdate.getRelDate());
            pstmt.setString(4, movieUpdate.getLength());
            pstmt.setString(5, movieUpdate.getMovName());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "One Record Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String value) {
        try {
            String query = "DELETE FROM movie WHERE Mov_Name=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, value);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "One Record Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String returnQueryToGetColumnNames() {
        String query = "SELECT Mov_Name,Genre,Director,Release_Date,Length FROM movie";
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

    public DefaultTableModel searchMovie(String name, String value) throws SQLException {
        String sql = "";

        sql = "SELECT  Mov_Name,Genre,Director,Release_Date,Length FROM movie WHERE " + name + "='" + value + "'";

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
        }
        return new DefaultTableModel(data, columnName);

    }

    public Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mov_Name");
        columnNames.add("Genre");
        columnNames.add("Director");
        columnNames.add("Release_Date");
        columnNames.add("Length");
        return columnNames;

    }

}
