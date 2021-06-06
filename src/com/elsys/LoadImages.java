package com.elsys;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoadImages {
    public Image imgGrass;
    public Image imgWater;
    public Image imgStone;
    public Image imgPlayer;
    public Image imgTree;
    public Image imgPig;
    public Image imgCow;

    public Image imgStoneBrick;
    public Image imgStick;

    public Image imgVoid;

    LoadImages() {
        initGrass();
        initWater();
        initStone();
        initPlayer();
        initTree();
        initCow();
        initPig();

        initStoneBrick();
        initStick();

        initVoid();
    }

    public void initGrass(){
        try {
            imgGrass = ImageIO.read(new File("./src/img/grass.jpg"));
            imgGrass = imgGrass.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initStone(){
        try {
            imgStone = ImageIO.read(new File("./src/img/stone.png"));
            imgStone = imgStone.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initWater(){
        try {
            imgWater = ImageIO.read(new File("./src/img/water.jpg"));
            imgWater = imgWater.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initPlayer(){
        try {
            imgPlayer = ImageIO.read(new File("./src/img/player.png"));
            imgPlayer = imgPlayer.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initTree(){
        try {
            imgTree = ImageIO.read(new File("./src/img/tree.jpg"));
            imgTree = imgTree.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initStoneBrick(){
        try {
            imgStoneBrick = ImageIO.read(new File("./src/img/stone-brick.png"));
            imgStoneBrick = imgStoneBrick.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initStick(){
        try {
            imgStick = ImageIO.read(new File("./src/img/stick.png"));
            imgStick = imgStick.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initVoid(){
        try {
            imgVoid = ImageIO.read(new File("./src/img/void.png"));
            imgVoid = imgVoid.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initPig(){
        try {
            imgPig = ImageIO.read(new File("./src/img/pig.png"));
            imgPig = imgPig.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initCow(){
        try {
            imgCow = ImageIO.read(new File("./src/img/cow.png"));
            imgCow = imgCow.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
