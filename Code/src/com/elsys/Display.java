package com.elsys;

import com.elsys.object.Player;

import javax.swing.*;

public class Display {
    JFrame frame;
    String title;
    double width;
    double height;

    public Display(String title, double width, double height, Player player) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
        frame.addKeyListener(player);
    }

    void createDisplay(){
        frame = new JFrame(title);
        frame.setSize((int)width, (int)height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
