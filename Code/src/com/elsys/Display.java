package com.elsys;

import com.elsys.object.GameObject;
import com.elsys.object.Player;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Display{
    JFrame frame;
    Canvas canvas;

    String title;
    int width;
    int height;
    public ArrayList<GameObject> objects = new ArrayList<>();

    public Display(String title, int width, int height, Player player) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
        frame.addKeyListener(player);
    }

    void addObject(GameObject obj){
        objects.add(obj);
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
                for(GameObject obj : objects){
                    obj.paint((Graphics2D) g);
                }
            }
        };
        canvas.setBounds(0, 0, width, height);

        frame.add(canvas);
        frame.pack();
    }

    public String getTitle() {
        return title;
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
