package com.elsys.object;

import com.elsys.Coordinates;
import com.elsys.Main;

import java.awt.*;

public class Player implements GameObject{
    int curr_hp;
    int max_hp;
    int curr_hunger;
    int max_hunger;
    int curr_thirst;
    int max_thirst;
    int damage;
    boolean dead = false;
    Coordinates coordinates;

    public Inventory inventory;

    int move_tracker = 0;

    public Player(int max_hp, int max_hunger, int max_thirst, int x, int y, int damage) {
        this.curr_hp = max_hp;
        this.max_hp = max_hp;
        this.curr_hunger = max_hunger;
        this.max_hunger = max_hunger;
        this.curr_thirst = max_thirst;
        this.max_thirst = max_thirst;
        this.damage = damage;
        this.coordinates = new Coordinates(x, y);
        this.inventory = new Inventory(20);
    }

    public int getDamage() {
        Item item = inventory.inventory.get(inventory.selected).item;
        if (item instanceof Axe) {
            return ((Axe) item).damage + damage;
        }
        return damage;
    }

    public void takeDamage(int damage) {
        this.curr_hp -= damage;
        if (curr_hp < 0) {
            dead = true;
        }
    }

    public void getHungry(int hunger) {
        this.curr_hunger -= hunger;
        if (curr_hunger <= 0) {
            curr_hunger = 0;
            takeDamage(1);
        }
    }

    public void getThirsty(int thirst) {
        this.curr_thirst -= thirst;
        if (curr_thirst <= 0) {
            curr_thirst = 0;
            takeDamage(1);
        }
    }

    public boolean isDead() {
        return dead;
    }

    public void gainHealth(int health){
        curr_hp = Math.min(curr_hp + health, max_hp);
    }

    public void gainHunger(int hunger){
        curr_hunger = Math.min(curr_hunger + hunger, max_hunger);
    }

    public void gainThirst() {
        if (inventory.getInventory().size() > inventory.getSelected()) {
            Item item = inventory.getInventory().get(inventory.getSelected()).item;
            if (item instanceof BottleOfWater) {
                curr_thirst = Math.min(curr_thirst + ((BottleOfWater) item).drink(), max_thirst);
            } else if (item instanceof Rakia) {
                Main.rakias_drank++;
                curr_thirst = Math.min(curr_thirst + ((Rakia) item).drink(), max_thirst);
                inventory.inventory.get(inventory.getSelected()).item = new BottleOfWater(false);
            }
        }
    }

    public void eat() {
        if (inventory.getInventory().size() > inventory.getSelected()) {
            Item item = inventory.getInventory().get(inventory.getSelected()).item;
            inventory.reduceCount();
            if (item instanceof Food) {
                gainHealth(((Food) item).health_restore);
                gainHunger(((Food) item).hunger_restore);
            }
            else {
                gainHealth(-2);
                gainHunger(2);
            }
            setMove_tracker(1);
        }
    }

    @Override
    public void paint(Graphics2D g, Coordinates coordinates) {
        g.clearRect(800, 0, 350, 500);
        g.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g.drawString("Health: " + curr_hp + "/" + max_hp, 800, 35);
        g.drawString("Hunger: " + curr_hunger + "/" + max_hunger, 800, 70);
        g.drawString("Thirst: " + curr_thirst + "/" + max_thirst, 800, 105);

        inventory.drawInventoryItems(g);
        inventory.drawRecipes(g);
        g.drawImage(Main.loadImages.imgPlayer, coordinates.get_x() * Main.pixel_size, coordinates.get_y() * Main.pixel_size, null, null);
    }

    protected int get_sticks_count() {
        return inventory.inventory.stream()
                .filter(item -> item.item instanceof Stick)
                .mapToInt(item -> item.count)
                .reduce(0, Integer::sum);
    }

    protected int get_rocks_count() {
        return inventory.inventory.stream()
                .filter(item -> item.item instanceof StoneBrick)
                .mapToInt(item -> item.count)
                .reduce(0, Integer::sum);
    }

    protected int get_apples_count() {
        return inventory.inventory.stream()
                .filter(item -> item.item instanceof Apple)
                .mapToInt(item -> item.count)
                .reduce(0, Integer::sum);
    }

    protected int get_waters_count() {
        return inventory.inventory.stream()
                .filter(item -> item.item instanceof BottleOfWater && ((BottleOfWater) item.item).full)
                .mapToInt(item -> item.count)
                .reduce(0, Integer::sum);
    }

    public void craftAxe() {
        int sticks_count = get_sticks_count();
        int rock_count = get_rocks_count();

        if (sticks_count >= 3 && rock_count >= 3 && inventory.inventory.size() < 11) {
            inventory.add_item(new Axe());
            for (Inventory.InventoryItem inventoryItem : inventory.inventory) {
                if (inventoryItem.item instanceof Stick) {
                    inventoryItem.count -= 3;
                    if (inventoryItem.count <= 0) {
                        inventory.inventory.remove(inventoryItem);
                    }
                    break;
                }
            }
            for (Inventory.InventoryItem inventoryItem : inventory.inventory) {
                if (inventoryItem.item instanceof StoneBrick) {
                    inventoryItem.count -= 3;
                    if (inventoryItem.count <= 0) {
                        inventory.inventory.remove(inventoryItem);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public String type() {
        return "player";
    }

    public int getMove_tracker() {
        return move_tracker;
    }

    public void setMove_tracker(int i) {
        move_tracker = i;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void craftRakia() {
        int sticks_count = get_sticks_count();
        int apples_count = get_apples_count();
        int water_count = get_waters_count();

        if (sticks_count >= 5 && apples_count >= 5 && water_count >= 1 && inventory.inventory.size() < 11) {
            inventory.add_item(new Rakia());
            for (Inventory.InventoryItem inventoryItem : inventory.inventory) {
                if (inventoryItem.item instanceof Stick) {
                    inventoryItem.count -= 5;
                    if (inventoryItem.count <= 0) {
                        inventory.inventory.remove(inventoryItem);
                    }
                    break;
                }
            }
            for (Inventory.InventoryItem inventoryItem : inventory.inventory) {
                if (inventoryItem.item instanceof Apple) {
                    inventoryItem.count -= 5;
                    if (inventoryItem.count <= 0) {
                        inventory.inventory.remove(inventoryItem);
                    }
                    break;
                }
            }
            for (Inventory.InventoryItem inventoryItem : inventory.inventory) {
                if (inventoryItem.item instanceof BottleOfWater && ((BottleOfWater) inventoryItem.item).full) {
                    inventory.inventory.remove(inventoryItem);
                    break;
                }
            }
        }
    }
}
