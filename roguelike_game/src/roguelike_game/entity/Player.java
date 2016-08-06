/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike_game.entity;

import roguelike_game.entity.item.Item;
import roguelike_game.graphics.Sprite;
import roguelike_game.transport.Inventory;

/**
 * @version 08-06-16
 * @author andyafw
 */
public class Player extends Mob{
    private Inventory inventory;
    
    public Player(int x, int y, Sprite sprite) {
        super(x, y, 100);
        setSprite(sprite);
        inventory = new Inventory(7, 7);
    }
}
