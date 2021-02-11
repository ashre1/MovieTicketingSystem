package com.MTS.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDatabase {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    boolean isUser = false;

    public ConnectionDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/movie", "root", "");
            stmt = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkLogin(String name, String password, String category) {

        String query = "SELECT * FROM login WHERE Name = ? AND Password = ? AND Category = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, category);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                isUser = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUser;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/movie", "root", "");
            stmt = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
