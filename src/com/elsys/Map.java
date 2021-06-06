package com.elsys;

import com.elsys.object.*;
import com.elsys.terrain.*;

import javax.swing.*;
import java.util.Random;
import java.util.TreeMap;

public class Map extends JPanel {
    TreeMap<Coordinates, Combination> map = new TreeMap<>();

    int width = 61;
    int height = 61;
    Player player;

    public Map(Player player) {
        generate_map();
        generate_random_tree();
        generate_random_stone_bricks();
        generate_random_sticks();
        generate_random_pig();
        generate_random_cow();

        addPlayer(player);
        this.player = player;
    }

    void addPlayer(Player player){
        map.replace(player.getCoordinates(), new Combination(player, new GrassTerrain()));
    }

    void generate_map() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < height; j++) {
                map.put(new Coordinates(i, j), new Combination(new EmptyObject(), new VoidTerrain()));
                map.put(new Coordinates(i + 56, j), new Combination(new EmptyObject(), new VoidTerrain()));
            }
        }

        for (int i = 5; i < 56; i++) {
            for(int j = 0; j < 5; j++) {
                map.put(new Coordinates(i, j), new Combination(new EmptyObject(), new VoidTerrain()));
                map.put(new Coordinates(i, j + 56), new Combination(new EmptyObject(), new VoidTerrain()));
            }
        }

        for (int i = 5; i < 8; i++) {
            for (int j = 5; j < height - 5; j++) {
                map.put(new Coordinates(i, j), new Combination(new EmptyObject(), new WaterTerrain()));
            }
        }
        for (int i = 8; i < width - 5; i++) {
            for (int j = 5; j < height - 5; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                map.put(coordinates, new Combination(new EmptyObject(), generate_random_terrain()));
            }
        }
    }

    protected void moveDown() {
        if((1 + player.getCoordinates().get_y()) < 56){
            Coordinates oldCoordinates = new Coordinates(player.getCoordinates().get_x(), player.getCoordinates().get_y());
            Coordinates newCoordinates = new Coordinates(player.getCoordinates().get_x(), player.getCoordinates().get_y() + 1);
            if (intersectionHandler(newCoordinates)) {
                player.getCoordinates().set_y(player.getCoordinates().get_y() + 1);
                swap(oldCoordinates, newCoordinates);
            }
        }
    }
    protected void moveUp(){
        if(player.getCoordinates().get_y() - 1 > 4){
            Coordinates oldCoordinates = new Coordinates(player.getCoordinates().get_x(), player.getCoordinates().get_y());
            Coordinates newCoordinates = new Coordinates(player.getCoordinates().get_x(), player.getCoordinates().get_y() - 1);
            if (intersectionHandler(newCoordinates)) {
                player.getCoordinates().set_y(player.getCoordinates().get_y() - 1);
                swap(oldCoordinates, newCoordinates);
            }
        }
    }
    protected void moveLeft(){
        if(player.getCoordinates().get_x() - 1 > 4){
            Coordinates oldCoordinates = new Coordinates(player.getCoordinates().get_x(), player.getCoordinates().get_y());
            Coordinates newCoordinates = new Coordinates(player.getCoordinates().get_x() - 1, player.getCoordinates().get_y());
            if (intersectionHandler(newCoordinates)) {
                player.getCoordinates().set_x(player.getCoordinates().get_x() - 1);
                swap(oldCoordinates, newCoordinates);
            }
        }
    }
    protected void moveRight(){
        if((1 + player.getCoordinates().get_x()) < 56){
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
        if (object instanceof Item) {
            player.inventory.add_item((Item) object);
            return true;
        }
        return object instanceof EmptyObject;
    }

    public void hit(Coordinates target){
        GameObject object = map.get(target).getObject();
        if(object instanceof Animal){
            if(((Animal) object).take_dmg(player.getDamage())){
                if(object instanceof Pig){
                    player.inventory.add_item(new Steak());
                }
                else player.inventory.add_item(new Beef());
                map.replace(target, new Combination(new EmptyObject(), new GrassTerrain()));
                player.setMove_tracker(1);
            }
        }
    }

    private Terrain generate_random_terrain() {
        return new Random().nextInt(3) == 1 ? new StoneTerrain() : new GrassTerrain();
    }

    public Player getPlayer(){
        return player;
    }

    private void generate_random_tree() {
        for (int i = 3; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (map.get(coordinates).getTerrain() instanceof GrassTerrain){
                    if (new Random().nextInt(10) == 1){
                        map.put(coordinates, new Combination(new Tree(),new GrassTerrain()));
                    }
                }
            }
        }
    }

    private void generate_random_stone_bricks() {
        for (int i = 3; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (map.get(coordinates).getTerrain() instanceof StoneTerrain){
                    if (new Random().nextInt(15) == 1){
                        map.put(coordinates, new Combination(new StoneBrick(),new StoneTerrain()));
                    }
                }
            }
        }
    }

    private void generate_random_sticks() {
        for (int i = 3; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (map.get(coordinates).getTerrain() instanceof GrassTerrain){
                    if (new Random().nextInt(15) == 1 && !(map.get(coordinates).getObject() instanceof Tree)){
                        map.put(coordinates, new Combination(new Stick(),new GrassTerrain()));
                    }
                }
            }
        }
    }

    private void generate_random_pig() {
        for (int i = 3; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (map.get(coordinates).getTerrain() instanceof GrassTerrain){
                    if (new Random().nextInt(30) == 1 && !(map.get(coordinates).getObject() instanceof Tree) && !(map.get(coordinates).getObject() instanceof Stick)){
                        map.put(coordinates, new Combination(new Pig(),new GrassTerrain()));
                    }
                }
            }
        }
    }

    private void generate_random_cow() {
        for (int i = 3; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (map.get(coordinates).getTerrain() instanceof GrassTerrain){
                    if (new Random().nextInt(30) == 1 && !(map.get(coordinates).getObject() instanceof Tree) && !(map.get(coordinates).getObject() instanceof Stick) && !(map.get(coordinates).getObject() instanceof Pig)){
                        map.put(coordinates, new Combination(new Cow(),new GrassTerrain()));
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
