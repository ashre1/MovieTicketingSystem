package com.MTS.ui;

import com.MTS.database.ConnectionDatabase;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class imageLoads extends Canvas {

    Image img;

    public imageLoads(Image img) {

        this.img = img;

    }

    public void paint(Graphics g) {

        if (img != null) {
            g.drawImage(img, 10, 10, Color.yellow, this);

        }

    }

    public void setImage(Image img) {

        this.img = img;

    }

}

public class Images implements ActionListener {

    JFrame fr = new JFrame("Upcoming Movie");

    JPanel subPanel2 = new JPanel(new FlowLayout());

    JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 150, 5));

    JPanel ImgPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

    JPanel bttnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 250, 15));
    
    JPanel donePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));

    Label Label1 = new Label("Choose first image");

    Button Button1 = new Button("Upload");

    Label Label2 = new Label("Choose second image");

    Button Button2 = new Button("Upload");
    
    Button Button4 = new Button("Done");

    Image Image1, Image2;

    imageLoad Canvas1, Canvas2;

    FileDialog fd = new FileDialog(fr, "Open", FileDialog.LOAD);

    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    void initialize() {

        con = new ConnectionDatabase().getConnection();

        fr.setBackground(Color.WHITE);

        fr.setResizable(false);

        Toolkit thekit = fr.getToolkit();

        Dimension dim = thekit.getScreenSize();

        fr.setBounds(dim.width / 4, dim.height / 8, 800, 450);

        fr.setLocationRelativeTo(null);

        labelPanel.add(Label1);

        labelPanel.add(Label2);

        bttnPanel.add(Button1);

        bttnPanel.add(Button2);

        donePanel.add(Button4);
        
        Button4.setSize(100, 70);
        
          Button4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                fr.dispose();
            }
        });

        fr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        Button1.addActionListener(this);

        Button2.addActionListener(this);

        Canvas1 = new imageLoad(null);

        Canvas1.setSize(260, 252);

        ImgPanel.add(Canvas1);

        Canvas2 = new imageLoad(null);

        Canvas2.setSize(260, 252);

        ImgPanel.add(Canvas2);

        subPanel2.add(labelPanel);

        subPanel2.add(ImgPanel);

        subPanel2.add(bttnPanel);
        
        subPanel2.add(donePanel);

        fr.add(subPanel2);

        labelPanel.setBackground(Color.WHITE);
        ImgPanel.setBackground(Color.WHITE);
        bttnPanel.setBackground(Color.WHITE);
        donePanel.setBackground(Color.WHITE);
        subPanel2.setBackground(Color.WHITE);

        fr.show();

    }

    void imageload1() {

        fd.show();

        if (fd.getFile() == null) {

            Label1.setText("You have not select");

        } else {

            String d = (fd.getDirectory() + fd.getFile());

            //  JOptionPane.showMessageDialog(null, d);
            try {
                String query = "UPDATE image SET Image = ? WHERE ID = 001";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, d);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Toolkit toolkit = Toolkit.getDefaultToolkit();

            Image1 = toolkit.getImage(d);

            Canvas1.setImage(Image1);

            Canvas1.repaint();

        }

    }

    void imageload2() {

        fd.show();

        if (fd.getFile() == null) {

            Label2.setText("You have not select");

        } else {

            String d = (fd.getDirectory() + fd.getFile());

            try {
                String query = "UPDATE image SET Image1 = ? WHERE ID = 001";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, d);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Toolkit toolkit = Toolkit.getDefaultToolkit();

            Image2 = toolkit.getImage(d);

            Canvas2.setImage(Image2);

            Canvas2.repaint();

        }

    }


    public void windowClosing(WindowEvent e) {

        System.exit(0);

    }

    public void actionPerformed(ActionEvent event) {

        Button b = (Button) event.getSource();

        if (b == Button1) {

            imageload1();

        }

        if (b == Button2) {

            imageload2();

        }

      

    }

    public static void main(String args[]) {

        Images a = new Images();

        a.initialize();

    }

}


