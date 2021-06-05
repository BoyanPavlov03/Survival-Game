package com.elsys;

import com.elsys.object.GameObject;
import com.elsys.object.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display{
    JFrame frame;
    Canvas canvas;

    String title;
    int width;
    int height;

    Map map = new Map();
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
                for(int i = 0; i < map.getWidth(); i++){
                    for(int j = 0; j < map.getHeight(); j++){
                        map.getTerrains().get(i).get(j).paint((Graphics2D) g, new Coordinates(i , j));
                    }
                }
                for(int i = 0; i < map.getWidth(); i++){
                    for(int j = 0; j < map.getHeight(); j++){
                        map.getObjects().get(i).get(j).paint((Graphics2D) g, new Coordinates(i , j));
                    }
                }
                for(GameObject obj : objects){
                    obj.paint((Graphics2D) g, new Coordinates(0,0));
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
