package com.elsys;

import com.elsys.object.EmptyObject;
import com.elsys.object.GameObject;
import com.elsys.object.Tree;
import com.elsys.terrain.Grass;
import com.elsys.terrain.Stone;
import com.elsys.terrain.Terrain;
import com.elsys.terrain.Water;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class Map extends JPanel {
    TreeMap<Coordinates, Combination> map = new TreeMap<>();

    ArrayList<ArrayList<Terrain>> terrains = new ArrayList<>();
    ArrayList<ArrayList<GameObject>> objects = new ArrayList<>();

    int width = 25;
    int height = 25;

    public Map() {
        generate_map();
        generate_random_tree();
        initTerrains();
        initObjects();
    }

    void initTerrains(){
        Coordinates coordinates = new Coordinates(0,0);
        for(int i = 0; i < width; i++){
            ArrayList<Terrain> temp = new ArrayList<>();
            for(int j = 0; j < height; j++){
                coordinates.set_x(i);
                coordinates.set_y(j);
                Terrain terrain = map.get(coordinates).terrain;
                temp.add(terrain);
            }
            terrains.add(temp);
        }
    }

    void initObjects(){
        Coordinates coordinates = new Coordinates(0,0);
        for(int i = 0; i < width; i++){
            ArrayList<GameObject> temp = new ArrayList<>();
            for(int j = 0; j < height; j++){
                coordinates.set_x(i);
                coordinates.set_y(j);
                GameObject object = map.get(coordinates).object;
                temp.add(object);
            }
            objects.add(temp);
        }
    }

    public ArrayList<ArrayList<GameObject>> getObjects() {
        return objects;
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

    private Terrain generate_random_terrain() {
        return switch (new Random().nextInt(3)) {
            case 0 -> new Grass();
            default -> new Stone();
        };
    }

    private void generate_random_tree() {
        for (int i = 3; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (map.get(coordinates).terrain instanceof Grass){
                    if (new Random().nextInt(5) == 1){
                        map.put(coordinates, new Combination(new Tree(),new Grass()));
                    }
                }
            }
        }
    }

    public TreeMap<Coordinates, Combination> getMap() {
        return map;
    }

    public ArrayList<ArrayList<Terrain>> getTerrains() {
        return terrains;
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
