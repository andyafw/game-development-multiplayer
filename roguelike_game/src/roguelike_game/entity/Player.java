/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike_game.entity;

import roguelike_game.graphics.Sprite;
import roguelike_game.transport.Inventory;

/**
 * @version 09/17/2016
 * @author Andy Walser
 */

public class Player extends Mob{
    
    public Player(int x, int y, Sprite sprite) {
        super(x, y, 100);
        setSprite(sprite);
        inventory = new Inventory(7, 7);
    }
}
