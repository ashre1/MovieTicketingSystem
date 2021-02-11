package com.MTS.main;

import com.MTS.ui.MainFrame;
import javax.swing.UIManager;

public class MovieTicketSystem {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        new MainFrame();

    }
}
