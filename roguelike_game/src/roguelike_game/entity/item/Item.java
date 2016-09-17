/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike_game.entity.item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import roguelike_game.graphics.Sprite;

/**
 * @version 09/17/2016
 * @author Andy Walser
 */

public class Item{
    public static Item SWORD = new Item("Iron Sword", Item.Type.SWORD, Sprite.SWORD);
    public static Item WAND = new Item("Long Wand", Item.Type.ITEM, Sprite.WAND);
    
    protected int x, y;
    protected Sprite sprite;
    protected String itemName;
    public static enum Type {ITEM, HELMET, SWORD, GLOVES, CHEST, BELT, PANTS, BOOTS, AMULET, RING};
    
    protected Type type;
    
    public Item(String name, Type type, Sprite sprite) {
        this.sprite = sprite;
        this.itemName = name;
        this.type = type;
    }
    
    public String getItemName() {
    	return itemName;
    }
    
    public void setItemName(String name) {
    	this.itemName = name;
    }
    
    public Type getType() {
        return type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public BufferedImage getSpriteImage() {
        return sprite.getImage();
    }
    
    public void render(Graphics g, int xscroll, int yscroll) {
        if(sprite.getImage() != null) {
            g.drawImage(sprite.getImage(), x * sprite.width - xscroll, y * sprite.height - xscroll, sprite.width, sprite.height, null);
        }
    }
    
    public void render(Graphics g, int xx, int yy, int type) {
        if(sprite.getImage() != null) {
            g.drawImage(sprite.getImage(), xx, yy, 32, 32, null);
        }
    }
    
}