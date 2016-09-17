/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike_game.transport;

import java.util.ArrayList;
import roguelike_game.entity.item.Item;

/**
 * @version 09/17/2016
 * @author Andy Walser
 */

public class Inventory {
    protected int items_can_wear = 10;		//helmet, hands, chest armor, belt, ring, pants, left-hand sword, amulet, boots, and right-hand sword
    protected int items_can_hold;           //how many items that can be held in inventory
    protected int inv_width;                // how many items the inventory can hold in a row
    protected int inv_height;               //how many items the inventory can hold in a column
    
    protected ArrayList<Item> equippedItems;//list of equipped items
    protected ArrayList<Item> inventoryItems;//list of items in the inventory
    
    //constructor used to create an inventory with the size created by width * height
    public Inventory(int width, int height) {
    	//variables are inited here
        inv_width = width;
        inv_height = height;
        items_can_hold = inv_width * inv_height;
        equippedItems = new ArrayList<Item>(items_can_wear);
        /*for(int i = 0; i < items_can_wear; i++) { //for loop used to test the limits of the inventory to see if we get errors when it is full
        	equippedItems.add(Item.SWORD);//add item sword everytime the for loop runs
        }*/
        inventoryItems = new ArrayList<Item>(items_can_hold);
        //checking the same thing as items_can_wear
        /*for(int i = 0; i < items_can_hold; i++) {
        	inventoryItems.add(Item.WAND);//adding wand this time
        }*/
    }
    
    //methods used to get variables
    public int getInventoryWidth()  { return inv_width;}
    public int getInventoryHeight() { return inv_height;}
    public int getInventoryMax()    { return items_can_hold;}
    
    //adds item to inventory if inventory is not full already
    public boolean addItem(Item item) {
    	//checks if inventory array size is smalle than max size for holding items
        if(inventoryItems.size() < items_can_hold) {
        	//if it is smaller than max size then add item to inventory
            inventoryItems.add(item);
            //return true that item was added so item can be removed from the map
            return true;
        }
        //if inventory is full than send error that is full
    	System.out.println("Inventory is full");
    	//return false that item did not get added to the inventory
    	return false;
        //TODO: need to figure out a way to tell user inventory is full
    }
    
    //get item from inventory using the inventory id number
    public Item getItem(int id) {
    	//if id number is not bigger than the size of the inventory
        if(inventoryItems.size() > id) {
        	//and the item is not set to null
            if(inventoryItems.get(id) != null) {
            	//return item using item id number
                return inventoryItems.get(id);
            }
        }
        //if id number is too big or item is null than return false
        return null;
    }
    
    public boolean addEquip(Item item) {
        if(equippedItems.size() < items_can_wear) {
            equippedItems.add(item);
            return true;
        }
        System.out.println("Can not equip. too many items equipped.");
        return false;
    }
    
    public Item getEquip(int pos) {
        if(pos < equippedItems.size()) {
            return equippedItems.get(pos);
        } else {
            return null;
        }
    }
}
