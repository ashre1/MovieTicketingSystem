package com.MTS.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TicketingPanel3 extends javax.swing.JPanel {

    boolean isBooking = false;
//    boolean isSelection = false;
    String TicketNo = null;
    int numS = 0;
    String seats;
    JFrame frame = new JFrame();
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    JTextField[] text;
    private static final String[] PlatinumArray = new String[]{"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10"};
    private static final String[] GoldArray = new String[]{"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10"};
    private static final String[] SilverArray = new String[]{"G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10", "J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10"};

    public TicketingPanel3() {
        initComponents();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/movie", "root", "");
            stmt = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // con = new ConnectionDatabase().getConnection();
        this.text = new JTextField[]{A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, E1, E2, E3, E4, E5, E6, E7, E8, E9, E10, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, G1, G2, G3, G4, G5, G6, G7, G8, G9, G10, H1, H2, H3, H4, H5, H6, H7, H8, H9, H10, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, J1, J2, J3, J4, J5, J6, J7, J8, J9, J10};

        loadTicket();
        
        loadDetails();

        LogoutBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainFrame();
            }
        });

        ShowTimeCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String show = ShowTimeCombo.getSelectedItem().toString();
                if (show.equalsIgnoreCase("12 PM")) {
                    new TicketingPanel1();
                    frame.dispose();
                }else if(show.equalsIgnoreCase("3 PM")){
                    new TicketingPanel2();
                    frame.dispose();
                }else if(show.equalsIgnoreCase("6 PM")){
                     new TicketingPanel3();
                    frame.dispose();
                }else{
                     new TicketingPanel();
                    frame.dispose();
                }
            }
        });

        A1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(A1, "A1");
            }
        });

        A2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(A2, "A2");
            }
        });

        A3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(A3, "A3");
            }
        });

        A4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(A4, "A4");
            }
        });

        A5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(A5, "A5");
            }
        });

        A6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(A6, "A6");
            }
        });

        A7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(A7, "A7");
            }
        });

        A8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(A8, "A8");
            }
        });

        A9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(A9, "A9");
            }
        });

        A10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(A10, "A10");
            }
        });

        B1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(B1, "B1");
            }
        });

        B2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(B2, "B2");
            }
        });

        B3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(B3, "B3");
            }
        });

        B4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(B4, "B4");
            }
        });

        B5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(B5, "B5");
            }
        });

        B6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(B6, "B6");
            }
        });

        B7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(B7, "B7");
            }
        });

        B8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(B8, "B8");
            }
        });

        B9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(B9, "B9");
            }
        });

        B10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(B10, "B10");
            }
        });

        C1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(C1, "C1");
            }
        });

        C2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(C2, "C2");
            }
        });

        C3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(C3, "C3");
            }
        });

        C4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(C4, "C4");
            }
        });

        C5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(C5, "C5");
            }
        });

        C6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(C6, "C6");
            }
        });

        C7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(C7, "C7");
            }
        });

        C8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(C8, "C8");
            }
        });

        C9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(C9, "C9");
            }
        });

        C10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(C10, "C10");
            }
        });

        D1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(D1, "D1");
            }
        });

        D2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(D2, "D2");
            }
        });

        D3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(D3, "D3");
            }
        });

        D4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(D4, "D4");
            }
        });

        D5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(D5, "D5");
            }
        });

        D6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(D6, "D6");
            }
        });

        D7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(D7, "D7");
            }
        });

        D8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(D8, "D8");
            }
        });

        D9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(D9, "D9");
            }
        });

        D10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(D10, "D10");
            }
        });

        E1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(E1, "E1");
            }
        });

        E2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(E2, "E2");
            }
        });

        E3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(E3, "E3");
            }
        });

        E4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(E4, "E4");
            }
        });

        E5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(E5, "E5");
            }
        });

        E6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(E6, "E6");
            }
        });

        E7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(E7, "E7");
            }
        });

        E8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(E8, "E8");
            }
        });

        E9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(E9, "E9");
            }
        });

        E10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(E10, "E10");
            }
        });

        F1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(F1, "F1");
            }
        });

        F2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(F2, "F2");
            }
        });

        F3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(F3, "F3");
            }
        });

        F4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(F4, "F4");
            }
        });

        F5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(F5, "F5");
            }
        });

        F6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(F6, "F6");
            }
        });

        F7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(F7, "F7");
            }
        });

        F8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(F8, "F8");
            }
        });

        F9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(F9, "F9");
            }
        });

        F10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(F10, "F10");
            }
        });

        G1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(G1, "G1");
            }
        });

        G2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(G2, "G2");
            }
        });

        G3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(G3, "G3");
            }
        });

        G4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(G4, "G4");
            }
        });

        G5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(G5, "G5");
            }
        });

        G6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(G6, "G6");
            }
        });

        G7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(G7, "G7");
            }
        });

        G8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(G8, "G8");
            }
        });

        G9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(G9, "G9");
            }
        });

        G10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(G10, "G10");
            }
        });

        H1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(H1, "H1");
            }
        });

        H2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(H2, "H2");
            }
        });

        H3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(H3, "H3");
            }
        });

        H4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(H4, "H4");
            }
        });

        H5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(H5, "H5");
            }
        });

        H6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(H6, "H6");
            }
        });

        H7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(H7, "H7");
            }
        });

        H8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(H8, "H8");
            }
        });

        H9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(H9, "H9");
            }
        });

        H10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(H10, "H10");
            }
        });

        I1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(I1, "I1");
            }
        });

        I2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(I2, "I2");
            }
        });

        I3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(I3, "I3");
            }
        });

        I4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(I4, "I4");
            }
        });

        I5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(I5, "I5");
            }
        });

        I6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(I6, "I6");
            }
        });

        I7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(I7, "I7");
            }
        });

        I8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(I8, "I8");
            }
        });

        I9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(I9, "I9");
            }
        });

        I10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(I10, "I10");
            }
        });

        J1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(J1, "J1");
            }
        });

        J2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(J2, "J2");
            }
        });

        J3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(J3, "J3");
            }
        });

        J4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(J4, "J4");
            }
        });

        J5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(J5, "J5");
            }
        });

        J6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(J6, "J6");
            }
        });

        J7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(J7, "J7");
            }
        });

        J8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(J8, "J8");
            }
        });

        J9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(J9, "J9");
            }
        });

        J10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mc) {
                ticket(J10, "J10");
            }
        });

        BookBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int count = 0;
                String n = null;
                boolean isSeatSelected = false;
                //  List<JTextField> textField = Arrays.asList(text);
                boolean check = checkId();
                if (check) {
                    boolean selection = checkSelection();

                    if (selection) {
                        for (int i = 0; i < text.length; i++) {
                            count = i + 1;
                            if (text[i].getBackground() == Color.YELLOW) {
                                text[i].setBackground(Color.blue);
                                if (i < 10) {
                                    n = "A" + count;
                                } else if (i < 20) {
                                    n = "B" + (count - 10);
                                } else if (i < 30) {
                                    n = "C" + (count - 20);
                                } else if (i < 40) {
                                    n = "D" + (count - 30);
                                } else if (i < 50) {
                                    n = "E" + (count - 40);
                                } else if (i < 60) {
                                    n = "F" + (count - 50);
                                } else if (i < 70) {
                                    n = "G" + (count - 60);
                                } else if (i < 80) {
                                    n = "H" + (count - 70);
                                } else if (i < 90) {
                                    n = "I" + (count - 80);
                                } else {
                                    n = "J" + (count - 90);
                                }
                                blue(n);

                            }

                        }

                    }
                     if (!selection) {
                        if (booking()) {
                            isSeatSelected = true;
                            showBooking();
                        }
                    }

                    if (!selection && !isSeatSelected) {
                        JOptionPane.showMessageDialog(null, "No Seat Selected");
                    } else {
                        if (selection && !isSeatSelected) {
                            JOptionPane.showMessageDialog(null, "Booking Successfull");
                            NoOfTicketsTxt.setText("");
                            PriceTxt.setText("");
                            idTxt.setText("");
                            available();
                            numS = 0;
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Booking Not Allowed");
                    for (int i = 0; i < text.length; i++) {
                        if (text[i].getBackground() == Color.YELLOW) {
                            text[i].setBackground(Color.GREEN);
                        }
                    }
                    NoOfTicketsTxt.setText("");
                    PriceTxt.setText("");
                    idTxt.setText("");
                }
                // frame.revalidate();
            }
        });

        BuyBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int count = 0;
                String n = null;
                boolean selection = checkSelection();

                if (selection) {
                    for (int i = 0; i < text.length; i++) {
                        count = i + 1;

                        if (text[i].getBackground() == Color.YELLOW) {
                            text[i].setBackground(Color.RED);
                            if (i < 10) {
                                n = "A" + count;
                            } else if (i < 20) {
                                n = "B" + (count - 10);
                            } else if (i < 30) {
                                n = "C" + (count - 20);
                            } else if (i < 40) {
                                n = "D" + (count - 30);
                            } else if (i < 50) {
                                n = "E" + (count - 40);
                            } else if (i < 60) {
                                n = "F" + (count - 50);
                            } else if (i < 70) {
                                n = "G" + (count - 60);
                            } else if (i < 80) {
                                n = "H" + (count - 70);
                            } else if (i < 90) {
                                n = "I" + (count - 80);
                            } else {
                                n = "J" + (count - 90);
                            }
                            red(n);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No Seat Selected");
                }
                idTxt.setText("");
                loadTicket();
                frame.revalidate();
            }
        });

        SPanel.add(SeatPanel, BorderLayout.NORTH);
        SPanel.add(SeatInfoPanel, BorderLayout.SOUTH);
        frame.add(InfoPanel, BorderLayout.WEST);
        frame.add(SPanel, BorderLayout.EAST);
        frame.setTitle("Movie Ticketing System");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        Toolkit thekit = frame.getToolkit();
        Dimension dim = thekit.getScreenSize();
        frame.setBounds(dim.width / 4, dim.height / 8, 720, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    boolean checkId() {
        String id = idTxt.getText();
        //  JOptionPane.showMessageDialog(null, id);
        if (id != null && id.trim().length() > 0) {
            String query = "SELECT * FROM customer WHERE Cus_ID = ?";
            try {
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, id);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    return true;
                }
            } catch (Exception ae) {
                ae.printStackTrace();;

            }
        }
        return false;
    }

    boolean checkSelection() {
        for (int i = 0; i < text.length; i++) {
            if (text[i].getBackground() == Color.YELLOW) {
                return true;
            }
        }
        return false;

    }

    public void available() {
        int num = 0;
        for (int i = 0; i < text.length; i++) {
            if (text[i].getBackground() == Color.GREEN) {
                num++;
            }
        }
        AvailableSeatsTxt.setText(String.valueOf(num));

    }

    public void loadTicket() {
        String query = "SELECT *FROM ticket3";
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String No = rs.getString(1);
                String Tic = rs.getString(2);

                int count = 0;
                String n = null;

                if (Tic.equalsIgnoreCase("red")) {

                    for (int i = 0; i < text.length; i++) {
                        count = i + 1;
                        if (i < 10) {
                            n = "A" + count;
                        } else if (i < 20) {
                            n = "B" + (count - 10);
                        } else if (i < 30) {
                            n = "C" + (count - 20);
                        } else if (i < 40) {
                            n = "D" + (count - 30);
                        } else if (i < 50) {
                            n = "E" + (count - 40);
                        } else if (i < 60) {
                            n = "F" + (count - 50);
                        } else if (i < 70) {
                            n = "G" + (count - 60);
                        } else if (i < 80) {
                            n = "H" + (count - 70);
                        } else if (i < 90) {
                            n = "I" + (count - 80);
                        } else {
                            n = "J" + (count - 90);
                        }
                        if (No.equalsIgnoreCase(n)) {
                            text[count - 1].setBackground(Color.RED);

                        }
                    }
                }
                if (Tic.equalsIgnoreCase("blue")) {

                    for (int i = 0; i < text.length; i++) {
                        count = i + 1;
                        if (i < 10) {
                            n = "A" + count;
                        } else if (i < 20) {
                            n = "B" + (count - 10);
                        } else if (i < 30) {
                            n = "C" + (count - 20);
                        } else if (i < 40) {
                            n = "D" + (count - 30);
                        } else if (i < 50) {
                            n = "E" + (count - 40);
                        } else if (i < 60) {
                            n = "F" + (count - 50);
                        } else if (i < 70) {
                            n = "G" + (count - 60);
                        } else if (i < 80) {
                            n = "H" + (count - 70);
                        } else if (i < 90) {
                            n = "I" + (count - 80);
                        } else {
                            n = "J" + (count - 90);
                        }
                        if (No.equalsIgnoreCase(n)) {
                            text[count - 1].setBackground(Color.BLUE);

                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Caught=" + e.getMessage());
        }
         ShowTimeCombo.setSelectedItem("6 PM");
        NoOfTicketsTxt.setText("");
        PriceTxt.setText("");

        available();
        numS = 0;

    }
    // int flag;

    public void ticket(JTextField t, String r) {

        String seats = TicketTypesCombo.getSelectedItem().toString();
        //  boolean check1 = booking();

        List<String> pSeatList = Arrays.asList(PlatinumArray);
        List<String> gSeatList = Arrays.asList(GoldArray);
        List<String> sSeatList = Arrays.asList(SilverArray);

        if ((seats.equalsIgnoreCase("platinum") && pSeatList.contains(r)) || (seats.equalsIgnoreCase("gold") && gSeatList.contains(r)) || (seats.equalsIgnoreCase("silver") && sSeatList.contains(r))) {

            if ((t.getBackground() == Color.GREEN)) {
                t.setBackground(Color.yellow);
                numS++;
                //flag = 2;
            } else if (t.getBackground() == Color.red) {

            } else if ((t.getBackground() == Color.BLUE)) {
                if (checkId()) {
                    if (booking()) {
                        t.setBackground(Color.yellow);
                        numS++;
                    }
                }

                //flag = 1;
            } else {
                t.setBackground(Color.green);
                green(r);
                available();
                numS--;
                if (numS == 0) {
                    NoOfTicketsTxt.setText("");
                    PriceTxt.setText("");
                }

            }

            if (seats.equalsIgnoreCase("platinum")) {
                NoOfTicketsTxt.setText(String.valueOf(numS));
                PriceTxt.setText(String.valueOf(numS * 350));
            } else if (seats.equalsIgnoreCase("gold")) {
                NoOfTicketsTxt.setText(String.valueOf(numS));
                PriceTxt.setText(String.valueOf(numS * 300));
            } else {
                NoOfTicketsTxt.setText(String.valueOf(numS));
                PriceTxt.setText(String.valueOf(numS * 250));
            }
        }
    }

    public void red(String num) {

        String query = "UPDATE ticket3 SET Ticket = 'red' WHERE Number = ? ";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, num);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Caught=" + e.getMessage());
        }

        String query1 = "DELETE FROM booking3 WHERE Ticket_No =?";
        try {
            pstmt = con.prepareStatement(query1);
            pstmt.setString(1, num);
            pstmt.executeUpdate();
            //  JOptionPane.showMessageDialog(null, num + " Booking Cancelled");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void blue(String num) {
        String query = "UPDATE ticket3 SET Ticket = 'blue' WHERE Number = ?";
        boolean isTicketAvailable = false;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, num);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Caught=" + e.getMessage());
        }

        String id = idTxt.getText();
        String query2 = "SELECT Ticket_No FROM booking3 WHERE CUS_ID = ? AND Ticket_No = ?";
        try {
            pstmt = con.prepareStatement(query2);
            pstmt.setString(1, id);
            pstmt.setString(2, num);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                isTicketAvailable = true;
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!isTicketAvailable) {
            String query1 = "INSERT INTO booking3 VALUES(?,?)";
            try {
                pstmt = con.prepareStatement(query1);
                pstmt.setString(1, id);
                pstmt.setString(2, num);
                pstmt.executeUpdate();
            } catch (SQLException ae) {
                ae.printStackTrace();
            }
        }
    }

    public void green(String num) {
        String query = "UPDATE ticket3 SET Ticket = 'green' WHERE Number = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, num);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Caught=" + e.getMessage());
        }

        String query1 = "DELETE FROM booking3 WHERE Ticket_No =?";
        try {
            pstmt = con.prepareStatement(query1);
            pstmt.setString(1, num);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, num + "Cancelled Ticket");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean booking() {
        String id = idTxt.getText();
        String all = null;
        String query = "SELECT Ticket_No FROM booking3 WHERE Cus_id = ?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void showBooking() {

        List<String> pSeatList = Arrays.asList(PlatinumArray);
        List<String> gSeatList = Arrays.asList(GoldArray);
        List<String> sSeatList = Arrays.asList(SilverArray);

        numS = 0;
        String ticketType = null;
        String id = idTxt.getText();
        String all = "";
        String query = "SELECT Ticket_No FROM booking3 WHERE Cus_id = ?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TicketNo = rs.getString(1);
                if (ticketType == null) {
                    if (pSeatList.contains(TicketNo)) {
                        ticketType = "Platinum";
                    } else if (gSeatList.contains(TicketNo)) {
                        ticketType = "Gold";
                    } else {
                        ticketType = "Silver";
                    }
                }
                next(TicketNo, ticketType);
                all = TicketNo + ", " + all;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (ticketType != null) {
            TicketTypesCombo.setSelectedItem(ticketType);
        }
        JOptionPane.showMessageDialog(null, "Booked Ticket Number are :: " + all);
    }

    public void next(String Num, String type) {

        int count = 0;
        String n = null;
        for (int i = 0; i < text.length; i++) {
            count = i + 1;
            if (i < 10) {
                n = "A" + count;
            } else if (i < 20) {
                n = "B" + (count - 10);
            } else if (i < 30) {
                n = "C" + (count - 20);
            } else if (i < 40) {
                n = "D" + (count - 30);
            } else if (i < 50) {
                n = "E" + (count - 40);
            } else if (i < 60) {
                n = "F" + (count - 50);
            } else if (i < 70) {
                n = "G" + (count - 60);
            } else if (i < 80) {
                n = "H" + (count - 70);
            } else if (i < 90) {
                n = "I" + (count - 80);
            } else {
                n = "J" + (count - 90);
            }
            if (Num.equalsIgnoreCase(n)) {
                text[count - 1].setBackground(Color.YELLOW);
                numS++;
            }
        }

        if (type.equalsIgnoreCase("platinum")) {
            NoOfTicketsTxt.setText(String.valueOf(numS));
            PriceTxt.setText(String.valueOf(numS * 350));
        } else if (type.equalsIgnoreCase("gold")) {
            NoOfTicketsTxt.setText(String.valueOf(numS));
            PriceTxt.setText(String.valueOf(numS * 300));
        } else {
            NoOfTicketsTxt.setText(String.valueOf(numS));
            PriceTxt.setText(String.valueOf(numS * 250));
        }

    }
    
     public void loadDetails() {

        String name = null;
        String query1 = "SELECT Mov_Name FROM details WHERE ID=001";

        try {
            rs = stmt.executeQuery(query1);
            while (rs.next()) {
                name = rs.getString(1);
               // name.toUpperCase();
                check(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    }
    
    public void check(String name){
        
        String movie = null;
        String genre = null;
        String director = null;
        String date = null;
        String length = null;
        String query = "SELECT Mov_Name,Genre,Director,Release_Date,Length FROM movie WHERE Mov_Name = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                movie = rs.getString(1);
                movie.toUpperCase();
                genre = rs.getString(2);
                director = rs.getString(3);
                date = rs.getString(4);
                length = rs.getString(5);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MovieNameLab.setText(movie.toUpperCase());
        GenreTxt.setText(genre);
        DirectorTxt.setText(director);
        ReleaseDateTxt.setText(date);
        LengthTxt.setText(length);

    }

//    public static void main(String[] args) {
//        new TicketingPanel();
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jTextField128 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        InfoPanel = new javax.swing.JPanel();
        DirectorLab = new javax.swing.JLabel();
        ReleaseDateLab = new javax.swing.JLabel();
        MovieNameLab = new javax.swing.JLabel();
        GenreLab = new javax.swing.JLabel();
        AvailableSeatsLab = new javax.swing.JLabel();
        ShowTimeLab = new javax.swing.JLabel();
        LengthLab = new javax.swing.JLabel();
        TotalSeatsLab = new javax.swing.JLabel();
        BuyBttn = new javax.swing.JButton();
        TicketTypesCombo = new javax.swing.JComboBox();
        PriceTxt = new javax.swing.JTextField();
        ShowTimeCombo = new javax.swing.JComboBox();
        GenreTxt = new javax.swing.JTextField();
        DirectorTxt = new javax.swing.JTextField();
        TotalSeatsTxt = new javax.swing.JTextField();
        ReleaseDateTxt = new javax.swing.JTextField();
        LengthTxt = new javax.swing.JTextField();
        AvailableSeatsTxt = new javax.swing.JTextField();
        NoOfTicketsTxt = new javax.swing.JTextField();
        BookBttn = new javax.swing.JButton();
        TicketTypesLab = new javax.swing.JLabel();
        PriceLab = new javax.swing.JLabel();
        NoOfTicketLab = new javax.swing.JLabel();
        LogoutBttn = new javax.swing.JButton();
        idTxt = new javax.swing.JTextField();
        idLab = new javax.swing.JLabel();
        SPanel = new javax.swing.JPanel();
        SeatPanel = new javax.swing.JPanel();
        A = new javax.swing.JTextField();
        A1 = new javax.swing.JTextField();
        A2 = new javax.swing.JTextField();
        A3 = new javax.swing.JTextField();
        A6 = new javax.swing.JTextField();
        A4 = new javax.swing.JTextField();
        A5 = new javax.swing.JTextField();
        A7 = new javax.swing.JTextField();
        A8 = new javax.swing.JTextField();
        A9 = new javax.swing.JTextField();
        A10 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        SeatInfoPanel = new javax.swing.JPanel();
        jTextField125 = new javax.swing.JTextField();
        jTextField126 = new javax.swing.JTextField();
        jTextField127 = new javax.swing.JTextField();
        jTextField129 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        A11 = new javax.swing.JTextField();
        B1 = new javax.swing.JTextField();
        B2 = new javax.swing.JTextField();
        B3 = new javax.swing.JTextField();
        B4 = new javax.swing.JTextField();
        B5 = new javax.swing.JTextField();
        B6 = new javax.swing.JTextField();
        B7 = new javax.swing.JTextField();
        B8 = new javax.swing.JTextField();
        B9 = new javax.swing.JTextField();
        B10 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        C4 = new javax.swing.JTextField();
        C9 = new javax.swing.JTextField();
        C7 = new javax.swing.JTextField();
        C3 = new javax.swing.JTextField();
        C5 = new javax.swing.JTextField();
        C10 = new javax.swing.JTextField();
        C8 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        C2 = new javax.swing.JTextField();
        C = new javax.swing.JTextField();
        C6 = new javax.swing.JTextField();
        C1 = new javax.swing.JTextField();
        D3 = new javax.swing.JTextField();
        D6 = new javax.swing.JTextField();
        D2 = new javax.swing.JTextField();
        D1 = new javax.swing.JTextField();
        D8 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        D4 = new javax.swing.JTextField();
        D10 = new javax.swing.JTextField();
        D9 = new javax.swing.JTextField();
        D5 = new javax.swing.JTextField();
        A53 = new javax.swing.JTextField();
        D7 = new javax.swing.JTextField();
        E9 = new javax.swing.JTextField();
        E10 = new javax.swing.JTextField();
        E5 = new javax.swing.JTextField();
        E4 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        E7 = new javax.swing.JTextField();
        A60 = new javax.swing.JTextField();
        E2 = new javax.swing.JTextField();
        E6 = new javax.swing.JTextField();
        E1 = new javax.swing.JTextField();
        E8 = new javax.swing.JTextField();
        E3 = new javax.swing.JTextField();
        F7 = new javax.swing.JTextField();
        F1 = new javax.swing.JTextField();
        A68 = new javax.swing.JTextField();
        F3 = new javax.swing.JTextField();
        F6 = new javax.swing.JTextField();
        F5 = new javax.swing.JTextField();
        F10 = new javax.swing.JTextField();
        F8 = new javax.swing.JTextField();
        F2 = new javax.swing.JTextField();
        F9 = new javax.swing.JTextField();
        jTextField55 = new javax.swing.JTextField();
        F4 = new javax.swing.JTextField();
        G8 = new javax.swing.JTextField();
        G3 = new javax.swing.JTextField();
        G2 = new javax.swing.JTextField();
        G5 = new javax.swing.JTextField();
        G6 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        G4 = new javax.swing.JTextField();
        G1 = new javax.swing.JTextField();
        G9 = new javax.swing.JTextField();
        G10 = new javax.swing.JTextField();
        G7 = new javax.swing.JTextField();
        A98 = new javax.swing.JTextField();
        H8 = new javax.swing.JTextField();
        H7 = new javax.swing.JTextField();
        H9 = new javax.swing.JTextField();
        H1 = new javax.swing.JTextField();
        A103 = new javax.swing.JTextField();
        H6 = new javax.swing.JTextField();
        H4 = new javax.swing.JTextField();
        H10 = new javax.swing.JTextField();
        jTextField58 = new javax.swing.JTextField();
        H3 = new javax.swing.JTextField();
        H5 = new javax.swing.JTextField();
        H2 = new javax.swing.JTextField();
        A110 = new javax.swing.JTextField();
        I1 = new javax.swing.JTextField();
        I2 = new javax.swing.JTextField();
        I3 = new javax.swing.JTextField();
        I4 = new javax.swing.JTextField();
        I5 = new javax.swing.JTextField();
        I6 = new javax.swing.JTextField();
        I7 = new javax.swing.JTextField();
        I8 = new javax.swing.JTextField();
        I9 = new javax.swing.JTextField();
        I10 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        J8 = new javax.swing.JTextField();
        J4 = new javax.swing.JTextField();
        A123 = new javax.swing.JTextField();
        J5 = new javax.swing.JTextField();
        J1 = new javax.swing.JTextField();
        J3 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        J10 = new javax.swing.JTextField();
        J6 = new javax.swing.JTextField();
        J7 = new javax.swing.JTextField();
        J9 = new javax.swing.JTextField();
        J2 = new javax.swing.JTextField();

        jTextPane4.setEditable(false);
        jTextPane4.setBorder(null);
        jTextPane4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jTextPane4.setText("Booking Seats");
        jTextPane4.setAutoscrolls(false);
        jScrollPane4.setViewportView(jTextPane4);

        jLabel1.setText("jLabel1");

        jTextField128.setBackground(new java.awt.Color(0, 0, 153));
        jTextField128.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField128.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(0, 0, 153));

        InfoPanel.setBackground(new java.awt.Color(0, 0, 153));

        DirectorLab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DirectorLab.setForeground(java.awt.Color.orange);
        DirectorLab.setText("Director::");

        ReleaseDateLab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ReleaseDateLab.setForeground(java.awt.Color.orange);
        ReleaseDateLab.setText("Release Date::");

        MovieNameLab.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        MovieNameLab.setForeground(java.awt.Color.orange);
        MovieNameLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MovieNameLab.setText("Holiday");

        GenreLab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        GenreLab.setForeground(java.awt.Color.orange);
        GenreLab.setText("Genre::");

        AvailableSeatsLab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AvailableSeatsLab.setForeground(java.awt.Color.orange);
        AvailableSeatsLab.setText("Available Seats::");

        ShowTimeLab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ShowTimeLab.setForeground(java.awt.Color.orange);
        ShowTimeLab.setText("Show Time::");

        LengthLab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LengthLab.setForeground(java.awt.Color.orange);
        LengthLab.setText("Length::");

        TotalSeatsLab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TotalSeatsLab.setForeground(java.awt.Color.orange);
        TotalSeatsLab.setText("Total Seats::");

        BuyBttn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BuyBttn.setText("Buy");

        TicketTypesCombo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TicketTypesCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Platinum", "Gold", "Silver"}));

        PriceTxt.setEditable(false);
        PriceTxt.setBackground(new java.awt.Color(0, 0, 153));
        PriceTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PriceTxt.setForeground(new java.awt.Color(255, 255, 255));
        PriceTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceTxtActionPerformed(evt);
            }
        });

        ShowTimeCombo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ShowTimeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"9 AM", "12 PM", "3 PM", "6 PM"}));

        GenreTxt.setEditable(false);
        GenreTxt.setBackground(new java.awt.Color(0, 0, 153));
        GenreTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        GenreTxt.setForeground(new java.awt.Color(255, 255, 255));
        GenreTxt.setText("Action");
        GenreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenreTxtActionPerformed(evt);
            }
        });

        DirectorTxt.setEditable(false);
        DirectorTxt.setBackground(new java.awt.Color(0, 0, 153));
        DirectorTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DirectorTxt.setForeground(new java.awt.Color(255, 255, 255));
        DirectorTxt.setText("Marc Webb");
        DirectorTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirectorTxtActionPerformed(evt);
            }
        });

        TotalSeatsTxt.setEditable(false);
        TotalSeatsTxt.setBackground(new java.awt.Color(0, 0, 153));
        TotalSeatsTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TotalSeatsTxt.setForeground(new java.awt.Color(255, 255, 255));
        TotalSeatsTxt.setText("100");

        ReleaseDateTxt.setEditable(false);
        ReleaseDateTxt.setBackground(new java.awt.Color(0, 0, 153));
        ReleaseDateTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ReleaseDateTxt.setForeground(new java.awt.Color(255, 255, 255));
        ReleaseDateTxt.setText("01 May 2014");

        LengthTxt.setEditable(false);
        LengthTxt.setBackground(new java.awt.Color(0, 0, 153));
        LengthTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LengthTxt.setForeground(new java.awt.Color(255, 255, 255));
        LengthTxt.setText("2 Hrs 22 Min");

        AvailableSeatsTxt.setEditable(false);
        AvailableSeatsTxt.setBackground(new java.awt.Color(0, 0, 153));
        AvailableSeatsTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AvailableSeatsTxt.setForeground(new java.awt.Color(255, 255, 255));
        AvailableSeatsTxt.setText("100");
        AvailableSeatsTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvailableSeatsTxtActionPerformed(evt);
            }
        });

        NoOfTicketsTxt.setBackground(new java.awt.Color(0, 0, 153));
        NoOfTicketsTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        NoOfTicketsTxt.setForeground(new java.awt.Color(255, 255, 255));
        NoOfTicketsTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoOfTicketsTxtActionPerformed(evt);
            }
        });

        BookBttn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BookBttn.setText("Book");
        BookBttn.setBorderPainted(false);

        TicketTypesLab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TicketTypesLab.setForeground(java.awt.Color.orange);
        TicketTypesLab.setText("Ticket Types::");

        PriceLab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PriceLab.setForeground(java.awt.Color.orange);
        PriceLab.setText("Price::");

        NoOfTicketLab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        NoOfTicketLab.setForeground(java.awt.Color.orange);
        NoOfTicketLab.setText("No. of Ticket::");

        LogoutBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/MTS/ui/pic/Logoutbttn.jpg"))); // NOI18N

        idTxt.setBackground(new java.awt.Color(0, 0, 153));
        idTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        idTxt.setForeground(new java.awt.Color(255, 255, 255));
        idTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTxtActionPerformed(evt);
            }
        });

        idLab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        idLab.setForeground(java.awt.Color.orange);
        idLab.setText("Customer Id::");

        javax.swing.GroupLayout InfoPanelLayout = new javax.swing.GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
                InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(GenreLab)
                                .addComponent(DirectorLab)
                                .addComponent(ReleaseDateLab)
                                .addComponent(LengthLab)
                                .addComponent(TotalSeatsLab)
                                .addComponent(AvailableSeatsLab)
                                .addComponent(ShowTimeLab)
                                .addComponent(TicketTypesLab)
                                .addComponent(NoOfTicketLab)
                                .addComponent(PriceLab)
                                .addComponent(BookBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idLab))
                        .addGap(8, 8, 8)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(InfoPanelLayout.createSequentialGroup()
                                        .addComponent(BuyBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(InfoPanelLayout.createSequentialGroup()
                                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(idTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(PriceTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                                .addComponent(NoOfTicketsTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                                .addComponent(TicketTypesCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 114, Short.MAX_VALUE)
                                                .addComponent(TotalSeatsTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(DirectorTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(GenreTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ReleaseDateTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(LengthTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(AvailableSeatsTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ShowTimeCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 114, Short.MAX_VALUE))
                                        .addGap(0, 14, Short.MAX_VALUE))))
                .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(InfoPanelLayout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(LogoutBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(InfoPanelLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(MovieNameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InfoPanelLayout.setVerticalGroup(
                InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(MovieNameLab)
                        .addGap(35, 35, 35)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(GenreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(GenreLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DirectorLab)
                                .addComponent(DirectorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ReleaseDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ReleaseDateLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LengthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LengthLab))
                        .addGap(40, 40, 40)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TotalSeatsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TotalSeatsLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(AvailableSeatsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AvailableSeatsLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ShowTimeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ShowTimeLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TicketTypesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TicketTypesLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NoOfTicketsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NoOfTicketLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PriceLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BookBttn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BuyBttn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(LogoutBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );

        A.setEditable(false);
        A.setBackground(new java.awt.Color(255, 153, 0));
        A.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A.setText("A");

        A1.setEditable(false);
        A1.setBackground(java.awt.Color.green);
        A1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A1.setText("1");
        A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A1ActionPerformed(evt);
            }
        });

        A2.setEditable(false);
        A2.setBackground(java.awt.Color.green);
        A2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A2.setText("2");

        A3.setEditable(false);
        A3.setBackground(java.awt.Color.green);
        A3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A3.setText("3");
        A3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A3ActionPerformed(evt);
            }
        });

        A6.setEditable(false);
        A6.setBackground(java.awt.Color.green);
        A6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A6.setText("6");

        A4.setEditable(false);
        A4.setBackground(java.awt.Color.green);
        A4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A4.setText("4");

        A5.setEditable(false);
        A5.setBackground(java.awt.Color.green);
        A5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A5.setText("5");

        A7.setEditable(false);
        A7.setBackground(java.awt.Color.green);
        A7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A7.setText("7");

        A8.setEditable(false);
        A8.setBackground(java.awt.Color.green);
        A8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A8.setText("8");

        A9.setEditable(false);
        A9.setBackground(java.awt.Color.green);
        A9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A9.setText("9");

        A10.setEditable(false);
        A10.setBackground(java.awt.Color.green);
        A10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A10.setText("10");

        jTextField40.setEditable(false);
        jTextField40.setBackground(new java.awt.Color(255, 153, 0));
        jTextField40.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField40.setText("A");

        SeatInfoPanel.setBackground(new java.awt.Color(204, 204, 204));

        jTextField125.setEditable(false);
        jTextField125.setBackground(new java.awt.Color(0, 204, 0));
        jTextField125.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField125.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField126.setEditable(false);
        jTextField126.setBackground(java.awt.Color.red);
        jTextField126.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField126.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField126.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField126ActionPerformed(evt);
            }
        });

        jTextField127.setEditable(false);
        jTextField127.setBackground(java.awt.Color.blue);
        jTextField127.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField127.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField129.setEditable(false);
        jTextField129.setBackground(java.awt.Color.yellow);
        jTextField129.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField129.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField129.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField129ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Available Seats");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Sold Seats");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Selected Seats");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Booking Seats");

        javax.swing.GroupLayout SeatInfoPanelLayout = new javax.swing.GroupLayout(SeatInfoPanel);
        SeatInfoPanel.setLayout(SeatInfoPanelLayout);
        SeatInfoPanelLayout.setHorizontalGroup(
                SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SeatInfoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField125, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField127, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField129, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField126, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SeatInfoPanelLayout.setVerticalGroup(
                SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SeatInfoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField126, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField125, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jTextField127, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SeatInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField129, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel3.setForeground(java.awt.Color.orange);
        jLabel3.setText("PLATIUM");

        jLabel4.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel4.setForeground(java.awt.Color.orange);
        jLabel4.setText("GOLD");

        jLabel5.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel5.setForeground(java.awt.Color.orange);
        jLabel5.setText("SILVER");

        A11.setEditable(false);
        A11.setBackground(new java.awt.Color(255, 153, 0));
        A11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A11.setText("B");

        B1.setEditable(false);
        B1.setBackground(java.awt.Color.green);
        B1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        B1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B1.setText("1");
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });

        B2.setEditable(false);
        B2.setBackground(java.awt.Color.green);
        B2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        B2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B2.setText("2");

        B3.setEditable(false);
        B3.setBackground(java.awt.Color.green);
        B3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        B3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B3.setText("3");

        B4.setEditable(false);
        B4.setBackground(java.awt.Color.green);
        B4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        B4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B4.setText("4");

        B5.setEditable(false);
        B5.setBackground(java.awt.Color.green);
        B5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        B5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B5.setText("5");

        B6.setEditable(false);
        B6.setBackground(java.awt.Color.green);
        B6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        B6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B6.setText("6");

        B7.setEditable(false);
        B7.setBackground(java.awt.Color.green);
        B7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        B7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B7.setText("7");

        B8.setEditable(false);
        B8.setBackground(java.awt.Color.green);
        B8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        B8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B8.setText("8");

        B9.setEditable(false);
        B9.setBackground(java.awt.Color.green);
        B9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        B9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B9.setText("9");

        B10.setEditable(false);
        B10.setBackground(java.awt.Color.green);
        B10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        B10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B10.setText("10");

        jTextField50.setEditable(false);
        jTextField50.setBackground(new java.awt.Color(255, 153, 0));
        jTextField50.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField50.setText("B");

        C4.setEditable(false);
        C4.setBackground(java.awt.Color.green);
        C4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C4.setText("4");

        C9.setEditable(false);
        C9.setBackground(java.awt.Color.green);
        C9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C9.setText("9");

        C7.setEditable(false);
        C7.setBackground(java.awt.Color.green);
        C7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C7.setText("7");

        C3.setEditable(false);
        C3.setBackground(java.awt.Color.green);
        C3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C3.setText("3");

        C5.setEditable(false);
        C5.setBackground(java.awt.Color.green);
        C5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C5.setText("5");

        C10.setEditable(false);
        C10.setBackground(java.awt.Color.green);
        C10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C10.setText("10");

        C8.setEditable(false);
        C8.setBackground(java.awt.Color.green);
        C8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C8.setText("8");

        jTextField51.setEditable(false);
        jTextField51.setBackground(new java.awt.Color(255, 153, 0));
        jTextField51.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField51.setText("C");

        C2.setEditable(false);
        C2.setBackground(java.awt.Color.green);
        C2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C2.setText("2");

        C.setEditable(false);
        C.setBackground(new java.awt.Color(255, 153, 0));
        C.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C.setText("C");

        C6.setEditable(false);
        C6.setBackground(java.awt.Color.green);
        C6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C6.setText("6");

        C1.setEditable(false);
        C1.setBackground(java.awt.Color.green);
        C1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C1.setText("1");
        C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C1ActionPerformed(evt);
            }
        });

        D3.setEditable(false);
        D3.setBackground(java.awt.Color.green);
        D3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        D3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D3.setText("3");

        D6.setEditable(false);
        D6.setBackground(java.awt.Color.green);
        D6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        D6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D6.setText("6");

        D2.setEditable(false);
        D2.setBackground(java.awt.Color.green);
        D2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        D2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D2.setText("2");

        D1.setEditable(false);
        D1.setBackground(java.awt.Color.green);
        D1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        D1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D1.setText("1");
        D1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D1ActionPerformed(evt);
            }
        });

        D8.setEditable(false);
        D8.setBackground(java.awt.Color.green);
        D8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        D8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D8.setText("8");

        jTextField53.setEditable(false);
        jTextField53.setBackground(new java.awt.Color(255, 153, 0));
        jTextField53.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField53.setText("D");

        D4.setEditable(false);
        D4.setBackground(java.awt.Color.green);
        D4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        D4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D4.setText("4");

        D10.setEditable(false);
        D10.setBackground(java.awt.Color.green);
        D10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        D10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D10.setText("10");

        D9.setEditable(false);
        D9.setBackground(java.awt.Color.green);
        D9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        D9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D9.setText("9");

        D5.setEditable(false);
        D5.setBackground(java.awt.Color.green);
        D5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        D5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D5.setText("5");

        A53.setEditable(false);
        A53.setBackground(new java.awt.Color(255, 153, 0));
        A53.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A53.setText("D");

        D7.setEditable(false);
        D7.setBackground(java.awt.Color.green);
        D7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        D7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D7.setText("7");

        E9.setEditable(false);
        E9.setBackground(java.awt.Color.green);
        E9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        E9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E9.setText("9");

        E10.setEditable(false);
        E10.setBackground(java.awt.Color.green);
        E10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        E10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E10.setText("10");

        E5.setEditable(false);
        E5.setBackground(java.awt.Color.green);
        E5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        E5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E5.setText("5");

        E4.setEditable(false);
        E4.setBackground(java.awt.Color.green);
        E4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        E4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E4.setText("4");

        jTextField54.setEditable(false);
        jTextField54.setBackground(new java.awt.Color(255, 153, 0));
        jTextField54.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField54.setText("E");
        jTextField54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField54ActionPerformed(evt);
            }
        });

        E7.setEditable(false);
        E7.setBackground(java.awt.Color.green);
        E7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        E7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E7.setText("7");

        A60.setEditable(false);
        A60.setBackground(new java.awt.Color(255, 153, 0));
        A60.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A60.setText("E");

        E2.setEditable(false);
        E2.setBackground(java.awt.Color.green);
        E2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        E2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E2.setText("2");

        E6.setEditable(false);
        E6.setBackground(java.awt.Color.green);
        E6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        E6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E6.setText("6");

        E1.setEditable(false);
        E1.setBackground(java.awt.Color.green);
        E1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        E1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E1.setText("1");
        E1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E1ActionPerformed(evt);
            }
        });

        E8.setEditable(false);
        E8.setBackground(java.awt.Color.green);
        E8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        E8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E8.setText("8");

        E3.setEditable(false);
        E3.setBackground(java.awt.Color.green);
        E3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        E3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E3.setText("3");

        F7.setEditable(false);
        F7.setBackground(java.awt.Color.green);
        F7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F7.setText("7");

        F1.setEditable(false);
        F1.setBackground(java.awt.Color.green);
        F1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F1.setText("1");
        F1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F1ActionPerformed(evt);
            }
        });

        A68.setEditable(false);
        A68.setBackground(new java.awt.Color(255, 153, 0));
        A68.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A68.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A68.setText("F");

        F3.setEditable(false);
        F3.setBackground(java.awt.Color.green);
        F3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F3.setText("3");

        F6.setEditable(false);
        F6.setBackground(java.awt.Color.green);
        F6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F6.setText("6");

        F5.setEditable(false);
        F5.setBackground(java.awt.Color.green);
        F5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F5.setText("5");

        F10.setEditable(false);
        F10.setBackground(java.awt.Color.green);
        F10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F10.setText("10");

        F8.setEditable(false);
        F8.setBackground(java.awt.Color.green);
        F8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F8.setText("8");

        F2.setEditable(false);
        F2.setBackground(java.awt.Color.green);
        F2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F2.setText("2");

        F9.setEditable(false);
        F9.setBackground(java.awt.Color.green);
        F9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F9.setText("9");

        jTextField55.setEditable(false);
        jTextField55.setBackground(new java.awt.Color(255, 153, 0));
        jTextField55.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField55.setText("F");
        jTextField55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField55ActionPerformed(evt);
            }
        });

        F4.setEditable(false);
        F4.setBackground(java.awt.Color.green);
        F4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F4.setText("4");

        G8.setEditable(false);
        G8.setBackground(java.awt.Color.green);
        G8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        G8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G8.setText("8");

        G3.setEditable(false);
        G3.setBackground(java.awt.Color.green);
        G3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        G3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G3.setText("3");

        G2.setEditable(false);
        G2.setBackground(java.awt.Color.green);
        G2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        G2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G2.setText("2");

        G5.setEditable(false);
        G5.setBackground(java.awt.Color.green);
        G5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        G5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G5.setText("5");

        G6.setEditable(false);
        G6.setBackground(java.awt.Color.green);
        G6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        G6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G6.setText("6");

        jTextField57.setEditable(false);
        jTextField57.setBackground(new java.awt.Color(255, 153, 0));
        jTextField57.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField57.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField57.setText("G");

        G4.setEditable(false);
        G4.setBackground(java.awt.Color.green);
        G4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        G4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G4.setText("4");

        G1.setEditable(false);
        G1.setBackground(java.awt.Color.green);
        G1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        G1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G1.setText("1");
        G1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G1ActionPerformed(evt);
            }
        });

        G9.setEditable(false);
        G9.setBackground(java.awt.Color.green);
        G9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        G9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G9.setText("9");

        G10.setEditable(false);
        G10.setBackground(java.awt.Color.green);
        G10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        G10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G10.setText("10");

        G7.setEditable(false);
        G7.setBackground(java.awt.Color.green);
        G7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        G7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G7.setText("7");

        A98.setEditable(false);
        A98.setBackground(new java.awt.Color(255, 153, 0));
        A98.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A98.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A98.setText("G");
        A98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A98ActionPerformed(evt);
            }
        });

        H8.setEditable(false);
        H8.setBackground(java.awt.Color.green);
        H8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        H8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H8.setText("8");

        H7.setEditable(false);
        H7.setBackground(java.awt.Color.green);
        H7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        H7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H7.setText("7");

        H9.setEditable(false);
        H9.setBackground(java.awt.Color.green);
        H9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        H9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H9.setText("9");

        H1.setEditable(false);
        H1.setBackground(java.awt.Color.green);
        H1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        H1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H1.setText("1");
        H1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H1ActionPerformed(evt);
            }
        });

        A103.setEditable(false);
        A103.setBackground(new java.awt.Color(255, 153, 0));
        A103.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A103.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A103.setText("H");

        H6.setEditable(false);
        H6.setBackground(java.awt.Color.green);
        H6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        H6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H6.setText("6");

        H4.setEditable(false);
        H4.setBackground(java.awt.Color.green);
        H4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        H4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H4.setText("4");

        H10.setEditable(false);
        H10.setBackground(java.awt.Color.green);
        H10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        H10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H10.setText("10");

        jTextField58.setEditable(false);
        jTextField58.setBackground(new java.awt.Color(255, 153, 0));
        jTextField58.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField58.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField58.setText("H");

        H3.setEditable(false);
        H3.setBackground(java.awt.Color.green);
        H3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        H3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H3.setText("3");

        H5.setEditable(false);
        H5.setBackground(java.awt.Color.green);
        H5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        H5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H5.setText("5");

        H2.setEditable(false);
        H2.setBackground(java.awt.Color.green);
        H2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        H2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H2.setText("2");

        A110.setEditable(false);
        A110.setBackground(new java.awt.Color(255, 153, 0));
        A110.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A110.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A110.setText("I");

        I1.setEditable(false);
        I1.setBackground(java.awt.Color.green);
        I1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        I1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I1.setText("1");
        I1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I1ActionPerformed(evt);
            }
        });

        I2.setEditable(false);
        I2.setBackground(java.awt.Color.green);
        I2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        I2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I2.setText("2");

        I3.setEditable(false);
        I3.setBackground(java.awt.Color.green);
        I3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        I3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I3.setText("3");

        I4.setEditable(false);
        I4.setBackground(java.awt.Color.green);
        I4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        I4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I4.setText("4");

        I5.setEditable(false);
        I5.setBackground(java.awt.Color.green);
        I5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        I5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I5.setText("5");

        I6.setEditable(false);
        I6.setBackground(java.awt.Color.green);
        I6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        I6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I6.setText("6");

        I7.setEditable(false);
        I7.setBackground(java.awt.Color.green);
        I7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        I7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I7.setText("7");

        I8.setEditable(false);
        I8.setBackground(java.awt.Color.green);
        I8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        I8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I8.setText("8");

        I9.setEditable(false);
        I9.setBackground(java.awt.Color.green);
        I9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        I9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I9.setText("9");

        I10.setEditable(false);
        I10.setBackground(java.awt.Color.green);
        I10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        I10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I10.setText("10");

        jTextField59.setEditable(false);
        jTextField59.setBackground(new java.awt.Color(255, 153, 0));
        jTextField59.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField59.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField59.setText("I");

        J8.setEditable(false);
        J8.setBackground(java.awt.Color.green);
        J8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        J8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J8.setText("8");

        J4.setEditable(false);
        J4.setBackground(java.awt.Color.green);
        J4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        J4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J4.setText("4");

        A123.setEditable(false);
        A123.setBackground(new java.awt.Color(255, 153, 0));
        A123.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        A123.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A123.setText("J");

        J5.setEditable(false);
        J5.setBackground(java.awt.Color.green);
        J5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        J5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J5.setText("5");

        J1.setEditable(false);
        J1.setBackground(java.awt.Color.green);
        J1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        J1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J1.setText("1");
        J1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J1ActionPerformed(evt);
            }
        });

        J3.setEditable(false);
        J3.setBackground(java.awt.Color.green);
        J3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        J3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J3.setText("3");

        jTextField60.setEditable(false);
        jTextField60.setBackground(new java.awt.Color(255, 153, 0));
        jTextField60.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField60.setText("J");

        J10.setEditable(false);
        J10.setBackground(java.awt.Color.green);
        J10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        J10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J10.setText("10");

        J6.setEditable(false);
        J6.setBackground(java.awt.Color.green);
        J6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        J6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J6.setText("6");

        J7.setEditable(false);
        J7.setBackground(java.awt.Color.green);
        J7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        J7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J7.setText("7");

        J9.setEditable(false);
        J9.setBackground(java.awt.Color.green);
        J9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        J9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J9.setText("9");

        J2.setEditable(false);
        J2.setBackground(java.awt.Color.green);
        J2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        J2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J2.setText("2");

        javax.swing.GroupLayout SeatPanelLayout = new javax.swing.GroupLayout(SeatPanel);
        SeatPanel.setLayout(SeatPanelLayout);
        SeatPanelLayout.setHorizontalGroup(
                SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SeatInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SeatPanelLayout.createSequentialGroup()
                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(jLabel3))
                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(A11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(A53, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(A60, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(A98, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(G6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(G7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(G8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(G9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(G10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField57, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(A103, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(H3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(H8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(H9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(H10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField58, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(A68, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(A110, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(I1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(I2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(I3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(I4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(I5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(I6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(I7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(I8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(I9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(I10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(A123, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(J1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(J2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(J3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(J4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel5))
                                                .addGroup(SeatPanelLayout.createSequentialGroup()
                                                        .addComponent(J5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(J6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(J7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(J8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(J9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(J10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeatPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(204, 204, 204))
        );
        SeatPanelLayout.setVerticalGroup(
                SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SeatPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(A7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(A8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(A9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(A10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(A11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(A53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(A60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(E4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(E6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(E7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(E8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(E9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(E10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(A68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(F9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(F10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(A98, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(G6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(G7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(G8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(G9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(G10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(A103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(H3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(H8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(H9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(H10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(A110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(I1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(I2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(I3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(I4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(I5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(I6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(I7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(I8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(I9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(I10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(A123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(J1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(J2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(J3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(J4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(J5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(J6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(J7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(J8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(J9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(J10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SeatInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout SPanelLayout = new javax.swing.GroupLayout(SPanel);
        SPanel.setLayout(SPanelLayout);
        SPanelLayout.setHorizontalGroup(
                SPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SPanelLayout.createSequentialGroup()
                        .addComponent(SeatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
        );
        SPanelLayout.setVerticalGroup(
                SPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SeatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(InfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(InfoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    private void DirectorTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AvailableSeatsTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NoOfTicketsTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void PriceTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void GenreTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void H1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void G1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void F1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void E1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void D1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void C1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField129ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField126ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void A1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void I1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void J1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void A98ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField54ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField55ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void A3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void idTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField A;
    private javax.swing.JTextField A1;
    private javax.swing.JTextField A10;
    private javax.swing.JTextField A103;
    private javax.swing.JTextField A11;
    private javax.swing.JTextField A110;
    private javax.swing.JTextField A123;
    private javax.swing.JTextField A2;
    private javax.swing.JTextField A3;
    private javax.swing.JTextField A4;
    private javax.swing.JTextField A5;
    private javax.swing.JTextField A53;
    private javax.swing.JTextField A6;
    private javax.swing.JTextField A60;
    private javax.swing.JTextField A68;
    private javax.swing.JTextField A7;
    private javax.swing.JTextField A8;
    private javax.swing.JTextField A9;
    private javax.swing.JTextField A98;
    private javax.swing.JLabel AvailableSeatsLab;
    private javax.swing.JTextField AvailableSeatsTxt;
    private javax.swing.JTextField B1;
    private javax.swing.JTextField B10;
    private javax.swing.JTextField B2;
    private javax.swing.JTextField B3;
    private javax.swing.JTextField B4;
    private javax.swing.JTextField B5;
    private javax.swing.JTextField B6;
    private javax.swing.JTextField B7;
    private javax.swing.JTextField B8;
    private javax.swing.JTextField B9;
    private javax.swing.JButton BookBttn;
    private javax.swing.JButton BuyBttn;
    private javax.swing.JTextField C;
    private javax.swing.JTextField C1;
    private javax.swing.JTextField C10;
    private javax.swing.JTextField C2;
    private javax.swing.JTextField C3;
    private javax.swing.JTextField C4;
    private javax.swing.JTextField C5;
    private javax.swing.JTextField C6;
    private javax.swing.JTextField C7;
    private javax.swing.JTextField C8;
    private javax.swing.JTextField C9;
    private javax.swing.JTextField D1;
    private javax.swing.JTextField D10;
    private javax.swing.JTextField D2;
    private javax.swing.JTextField D3;
    private javax.swing.JTextField D4;
    private javax.swing.JTextField D5;
    private javax.swing.JTextField D6;
    private javax.swing.JTextField D7;
    private javax.swing.JTextField D8;
    private javax.swing.JTextField D9;
    private javax.swing.JLabel DirectorLab;
    private javax.swing.JTextField DirectorTxt;
    private javax.swing.JTextField E1;
    private javax.swing.JTextField E10;
    private javax.swing.JTextField E2;
    private javax.swing.JTextField E3;
    private javax.swing.JTextField E4;
    private javax.swing.JTextField E5;
    private javax.swing.JTextField E6;
    private javax.swing.JTextField E7;
    private javax.swing.JTextField E8;
    private javax.swing.JTextField E9;
    private javax.swing.JTextField F1;
    private javax.swing.JTextField F10;
    private javax.swing.JTextField F2;
    private javax.swing.JTextField F3;
    private javax.swing.JTextField F4;
    private javax.swing.JTextField F5;
    private javax.swing.JTextField F6;
    private javax.swing.JTextField F7;
    private javax.swing.JTextField F8;
    private javax.swing.JTextField F9;
    private javax.swing.JTextField G1;
    private javax.swing.JTextField G10;
    private javax.swing.JTextField G2;
    private javax.swing.JTextField G3;
    private javax.swing.JTextField G4;
    private javax.swing.JTextField G5;
    private javax.swing.JTextField G6;
    private javax.swing.JTextField G7;
    private javax.swing.JTextField G8;
    private javax.swing.JTextField G9;
    private javax.swing.JLabel GenreLab;
    private javax.swing.JTextField GenreTxt;
    private javax.swing.JTextField H1;
    private javax.swing.JTextField H10;
    private javax.swing.JTextField H2;
    private javax.swing.JTextField H3;
    private javax.swing.JTextField H4;
    private javax.swing.JTextField H5;
    private javax.swing.JTextField H6;
    private javax.swing.JTextField H7;
    private javax.swing.JTextField H8;
    private javax.swing.JTextField H9;
    private javax.swing.JTextField I1;
    private javax.swing.JTextField I10;
    private javax.swing.JTextField I2;
    private javax.swing.JTextField I3;
    private javax.swing.JTextField I4;
    private javax.swing.JTextField I5;
    private javax.swing.JTextField I6;
    private javax.swing.JTextField I7;
    private javax.swing.JTextField I8;
    private javax.swing.JTextField I9;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JTextField J1;
    private javax.swing.JTextField J10;
    private javax.swing.JTextField J2;
    private javax.swing.JTextField J3;
    private javax.swing.JTextField J4;
    private javax.swing.JTextField J5;
    private javax.swing.JTextField J6;
    private javax.swing.JTextField J7;
    private javax.swing.JTextField J8;
    private javax.swing.JTextField J9;
    private javax.swing.JLabel LengthLab;
    private javax.swing.JTextField LengthTxt;
    private javax.swing.JButton LogoutBttn;
    private javax.swing.JLabel MovieNameLab;
    private javax.swing.JLabel NoOfTicketLab;
    private javax.swing.JTextField NoOfTicketsTxt;
    private javax.swing.JLabel PriceLab;
    private javax.swing.JTextField PriceTxt;
    private javax.swing.JLabel ReleaseDateLab;
    private javax.swing.JTextField ReleaseDateTxt;
    private javax.swing.JPanel SPanel;
    private javax.swing.JPanel SeatInfoPanel;
    private javax.swing.JPanel SeatPanel;
    private javax.swing.JComboBox ShowTimeCombo;
    private javax.swing.JLabel ShowTimeLab;
    private javax.swing.JComboBox TicketTypesCombo;
    private javax.swing.JLabel TicketTypesLab;
    private javax.swing.JLabel TotalSeatsLab;
    private javax.swing.JTextField TotalSeatsTxt;
    private javax.swing.JLabel idLab;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField125;
    private javax.swing.JTextField jTextField126;
    private javax.swing.JTextField jTextField127;
    private javax.swing.JTextField jTextField128;
    private javax.swing.JTextField jTextField129;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextPane jTextPane4;
    // End of variables declaration                   
}
