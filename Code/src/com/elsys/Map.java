package com.elsys;

import com.elsys.object.EmptyObject;
import com.elsys.object.GameObject;
import com.elsys.object.Player;
import com.elsys.object.Tree;
import com.elsys.terrain.Grass;
import com.elsys.terrain.Stone;
import com.elsys.terrain.Terrain;
import com.elsys.terrain.Water;

import javax.swing.*;
import java.util.Random;
import java.util.TreeMap;

public class Map extends JPanel {
    TreeMap<Coordinates, Combination> map = new TreeMap<>();

    int width = Main.pixel_size;
    int height = Main.pixel_size;
    Player player;

    public Map(Player player) {
        generate_map();
        generate_random_tree();
        addPlayer(player);
        this.player = player;
    }

    void addPlayer(Player player){
        map.replace(player.getCoordinates(), new Combination(player, new Grass()));
    }

    void generate_map() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < height; j++) {
                map.put(new Coordinates(i, j), new Combination(new EmptyObject(), new Water()));
            }
        }
        for (int i = 3; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                map.put(coordinates, new Combination(new EmptyObject(), generate_random_terrain()));
            }
        }
    }

    protected void moveDown() {
        if((1 + player.getCoordinates().get_y()) * Main.pixel_size < Main.display.getHeight()){
            Coordinates oldCoordinates = new Coordinates(player.getCoordinates().get_x(), player.getCoordinates().get_y());
            Coordinates newCoordinates = new Coordinates(player.getCoordinates().get_x(), player.getCoordinates().get_y() + 1);
            if (intersectionHandler(newCoordinates)) {
                player.getCoordinates().set_y(player.getCoordinates().get_y() + 1);
                swap(oldCoordinates, newCoordinates);
            }
        }
    }
    protected void moveUp(){
        if(player.getCoordinates().get_y() - 1 >= 0){
            Coordinates oldCoordinates = new Coordinates(player.getCoordinates().get_x(), player.getCoordinates().get_y());
            Coordinates newCoordinates = new Coordinates(player.getCoordinates().get_x(), player.getCoordinates().get_y() - 1);
            if (intersectionHandler(newCoordinates)) {
                player.getCoordinates().set_y(player.getCoordinates().get_y() - 1);
                swap(oldCoordinates, newCoordinates);
            }
        }
    }
    protected void moveLeft(){
        if(player.getCoordinates().get_x() - 1 >= 0){
            Coordinates oldCoordinates = new Coordinates(player.getCoordinates().get_x(), player.getCoordinates().get_y());
            Coordinates newCoordinates = new Coordinates(player.getCoordinates().get_x() - 1, player.getCoordinates().get_y());
            if (intersectionHandler(newCoordinates)) {
                player.getCoordinates().set_x(player.getCoordinates().get_x() - 1);
                swap(oldCoordinates, newCoordinates);
            }
        }
    }
    protected void moveRight(){
        if((1 + player.getCoordinates().get_x()) * Main.pixel_size < Main.display.getWidth()){
            Coordinates oldCoordinates = new Coordinates(player.getCoordinates().get_x(), player.getCoordinates().get_y());
            Coordinates newCoordinates = new Coordinates(player.getCoordinates().get_x() + 1, player.getCoordinates().get_y());
            if (intersectionHandler(newCoordinates)) {
                player.getCoordinates().set_x(player.getCoordinates().get_x() + 1);
                swap(oldCoordinates, newCoordinates);
            }
        }
    }

    void swap(Coordinates oldCoordinates, Coordinates newCoordinates){
        Terrain newTerrain = map.get(newCoordinates).getTerrain();
        map.replace(newCoordinates, new Combination(player, newTerrain));
        Terrain oldTerrain = map.get(oldCoordinates).getTerrain();
        map.replace(oldCoordinates, new Combination(new EmptyObject(), oldTerrain));
    }

    boolean intersectionHandler(Coordinates coordinates) {
        GameObject object = map.get(coordinates).getObject();
        if(object instanceof EmptyObject){
            return true;
        }
        return false;
    }

    private Terrain generate_random_terrain() {
        return new Random().nextInt(2) == 1 ? new Grass() : new Stone();
    }

    public Player getPlayer(){
        return player;
    }

    private void generate_random_tree() {
        for (int i = 3; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (map.get(coordinates).terrain instanceof Grass){
                    if (new Random().nextInt(10) == 1){
                        map.put(coordinates, new Combination(new Tree(),new Grass()));
                    }
                }
            }
        }
    }

    public TreeMap<Coordinates, Combination> getMap() {
        return map;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
