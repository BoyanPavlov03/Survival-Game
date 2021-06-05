package com.elsys;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoadImages {
    public static Image imgGrass;
    public static Image imgWater;
    public static Image imgStone;
    public static Image imgPlayer;
    public static Image imgTree;

    public static Image imgStoneBrick;
    public static Image imgStick;

    LoadImages() {
        LoadImages.initGrass();
        LoadImages.initWater();
        LoadImages.initStone();
        LoadImages.initPlayer();
        LoadImages.initTree();

        LoadImages.initStoneBrick();
        LoadImages.initStick();
    }

    public static void initGrass(){
        try {
            imgGrass = ImageIO.read(new File("./src/img/grass.jpg"));
            imgGrass = imgGrass.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initStone(){
        try {
            imgStone = ImageIO.read(new File("./src/img/stone.png"));
            imgStone = imgStone.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initWater(){
        try {
            imgWater = ImageIO.read(new File("./src/img/water.jpg"));
            imgWater = imgWater.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initPlayer(){
        try {
            imgPlayer = ImageIO.read(new File("./src/img/player.png"));
            imgPlayer = imgPlayer.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initTree(){
        try {
            imgTree = ImageIO.read(new File("./src/img/tree.jpg"));
            imgTree = imgTree.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initStoneBrick(){
        try {
            imgStoneBrick = ImageIO.read(new File("./src/img/stone-brick.png"));
            imgStoneBrick = imgStoneBrick.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initStick(){
        try {
            imgStick = ImageIO.read(new File("./src/img/stick.png"));
            imgStick = imgStick.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
