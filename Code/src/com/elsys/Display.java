package com.elsys;

import com.elsys.object.Player;

import javax.swing.*;

public class Display {
    JFrame frame;
    String title;
    int width;
    int height;

    public Display(String title, int width, int height, Player player) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
        frame.addKeyListener(player);
    }

    void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
