package com.elsys;

import com.elsys.object.EmptyObject;
import com.elsys.terrain.Grass;
import com.elsys.terrain.Stone;
import com.elsys.terrain.Terrain;
import com.elsys.terrain.Water;

import java.util.Random;
import java.util.TreeMap;

public class Map {
    TreeMap<Coordinates, Combination> map = new TreeMap<>();

    int width = 25;
    int height = 25;

    public Map() {
        generate_map();
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
            case 1 -> new Stone();
            default -> new Water();
        };
    }
}
