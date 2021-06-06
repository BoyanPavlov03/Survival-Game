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

        canvas = new Canvas() {

            @Override
            public void paint(Graphics g){
                if (map.getPlayer().isDead()) {
                    String msg = "YOU DIED";

                    g.clearRect(0, 0, width, height);
                    g.fillRect(0, 0, width, height);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 50));
                    g.setColor(Color.RED);
                    g.drawString(msg, width / 2 - msg.length() * 15, height / 2 - 100);
                } else {
                    int x = map.getPlayer().getCoordinates().get_x() - 5;
                    int y = map.getPlayer().getCoordinates().get_y() - 5;
                    for (int i = 0; i < Main.visible_board_blocks_count; i++) {
                        for (int j = 0; j < Main.visible_board_blocks_count; j++) {
                            Coordinates getCoordinates = new Coordinates(x + i, y + j);
                            Coordinates paintCoordinates = new Coordinates(i, j);
                            map.getMap().get(getCoordinates).getTerrain().paint((Graphics2D) g, paintCoordinates);
                        }
                    }
                    for (int i = 0; i < Main.visible_board_blocks_count; i++) {
                        for (int j = 0; j < Main.visible_board_blocks_count; j++) {
                            Coordinates getCoordinates = new Coordinates(x + i, y + j);
                            Coordinates paintCoordinates = new Coordinates(i, j);
                            map.getMap().get(getCoordinates).getObject().paint((Graphics2D) g, paintCoordinates);
                        }
                    }
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
