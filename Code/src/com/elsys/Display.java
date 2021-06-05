package com.elsys;

import javax.swing.*;
import java.awt.*;

public class Display{
    JFrame frame;
    Canvas canvas;

    String title;
    int width;
    int height;

    Map map;

    public Display(String title, int width, int height, Map map) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
        frame.addKeyListener(new MyKeyListener(map));
        this.map = map;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas(){

            @Override
            public void paint(Graphics g){
                for (java.util.Map.Entry<Coordinates, Combination> entry : map.getMap().entrySet()) {
                    entry.getValue().getTerrain().paint((Graphics2D) g, entry.getKey());
                }
                for (java.util.Map.Entry<Coordinates, Combination> entry : map.getMap().entrySet()) {
                    entry.getValue().getObject().paint((Graphics2D) g, entry.getKey());
                }
            }
        };
        canvas.setBounds(0, 0, width, height);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
