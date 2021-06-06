package com.elsys.object;

import com.elsys.Coordinates;
import com.elsys.Main;

import java.awt.*;
import java.util.ArrayList;

public class Inventory {
    public static class InventoryItem {
        public Item item;
        public int count;

        public InventoryItem(Item item, int count) {
            this.item = item;
            this.count = count;
        }
    }
    protected ArrayList<InventoryItem> inventory;
    int max_stack_size;
    int selected = 0;

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public Inventory(int max_stack_size) {
        this.inventory = new ArrayList<>();
        inventory.add(new InventoryItem(new BottleOfWater(), 1));
        this.max_stack_size = max_stack_size;
    }

    public ArrayList<InventoryItem> getInventory() {
        return inventory;
    }

    public void reduceCount(){
        inventory.get(selected).count --;
        if (inventory.get(selected).count == 0) {
            inventory.remove(selected);
        }
    }

    public void add_item(Item new_item) {
        if (new_item instanceof Stackable) {
            for (InventoryItem inventoryItem : inventory) {
                if (inventoryItem.item.type().equals(new_item.type()) && inventoryItem.count < max_stack_size) {
                    inventoryItem.count++;
                    print_inventory();
                    return;
                }
            }
        }
        inventory.add(new InventoryItem(new_item, 1));
        print_inventory();
    }

    public void print_inventory() {
        for (InventoryItem inventoryItem : inventory) {
            System.out.println(inventoryItem.item.type() + ": " + inventoryItem.count);
        }
        System.out.println();
    }

    public void drawInventoryItems(Graphics g) {
        int blocks_count = Main.visible_board_blocks_count;
        for (int i = 0; i < blocks_count; i++) {
            //g.setColor((i == selected) ? Color.red : Color.black);
            g.drawRect(i * Main.pixel_size, blocks_count * Main.pixel_size, Main.pixel_size, Main.pixel_size);
            if (inventory.size() > i) {
                inventory.get(i).item.paint((Graphics2D) g, new Coordinates(i, blocks_count));
                g.drawString(String.valueOf(inventory.get(i).count), i * Main.pixel_size, (blocks_count + 1) * Main.pixel_size);
            }
        }

        g.setColor(Color.red);
        g.drawRect(selected * Main.pixel_size, blocks_count * Main.pixel_size, Main.pixel_size, Main.pixel_size);
        g.setColor(Color.black);

        // Vertical Line
        g.drawLine((blocks_count) * Main.pixel_size, 0, (blocks_count) * Main.pixel_size, (blocks_count + 1) * Main.pixel_size);

        // Horizontal Line
        int s = Main.visible_board_blocks_count * Main.pixel_size;
        g.drawLine(s, 115, Main.display.getWidth(), 115);
    }

    public void drawRecipes(Graphics2D g) {
        g.drawString("Recipes:", 800 , 150);
        g.drawString("T. Axe: 3 Stick + 3 Rock", 800 , 185);
        g.drawString("R. Rakia: 5 Apple + 5 Stick", 800 , 220);
        g.drawString("               + 1 Water", 800 , 255);
    }
}
