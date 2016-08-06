package roguelike_game.entity;

import roguelike_game.graphics.Sprite;

/**
 *
 * @author andyafw
 */
public abstract class Entity {
    protected int x;
    protected int y;
    
    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getX() {
        return x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getY() {
        return y;
    }
}
