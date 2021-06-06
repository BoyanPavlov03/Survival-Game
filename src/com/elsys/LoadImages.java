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
    public Image imgBeef;
    public Image imgSteak;

    public Image imgStoneBrick;
    public Image imgStick;

    public Image imgVoid;

    public Image imgFull;
    public Image imgEmpty;
    public Image imgRakia;
    public Image imgApple;
    public Image imgAxe;

    LoadImages() {
        initGrass();
        initWater();
        initStone();
        initPlayer();
        initTree();
        initCow();
        initPig();
        initBeef();
        initSteak();

        initStoneBrick();
        initStick();

        initVoid();

        initFull();
        initEmpty();
        initRakia();
        initApple();
        initAxe();
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
    public void initBeef(){
        try {
            imgBeef = ImageIO.read(new File("./src/img/beef.png"));
            imgBeef = imgBeef.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initSteak(){
        try {
            imgSteak = ImageIO.read(new File("./src/img/steak.png"));
            imgSteak = imgSteak.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initEmpty(){
        try {
            imgEmpty = ImageIO.read(new File("./src/img/empty.png"));
            imgEmpty = imgEmpty.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initFull(){
        try {
            imgFull = ImageIO.read(new File("./src/img/full.png"));
            imgFull = imgFull.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initRakia(){
        try {
            imgRakia = ImageIO.read(new File("./src/img/rakia.png"));
            imgRakia = imgRakia.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initApple(){
        try {
            imgApple = ImageIO.read(new File("./src/img/apple.png"));
            imgApple = imgApple.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initAxe(){
        try {
            imgAxe = ImageIO.read(new File("./src/img/axe.png"));
            imgAxe = imgAxe.getScaledInstance(Main.pixel_size, Main.pixel_size, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
