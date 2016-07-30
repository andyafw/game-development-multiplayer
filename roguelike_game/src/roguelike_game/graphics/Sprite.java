package roguelike_game.graphics;

import java.awt.image.BufferedImage;

public class Sprite {

    public static Sprite PLAYER_UP    = new Sprite(64, 0, 1, SpriteSheet.CHARACTERS);
    public static Sprite PLAYER_LEFT  = new Sprite(64, 0, 2, SpriteSheet.CHARACTERS);
    public static Sprite PLAYER_DOWN  = new Sprite(64, 0, 3, SpriteSheet.CHARACTERS);
    public static Sprite PLAYER_RIGHT = new Sprite(64, 0, 4, SpriteSheet.CHARACTERS);
    
    public static Sprite EMPTY     = new Sprite(64, 0, 0, SpriteSheet.CHARACTERS);
    
    public static Sprite SECOND_FLOOR = new Sprite(64, 4, 0, SpriteSheet.CHARACTERS);
    public static Sprite WALL      = new Sprite(64, 1, 0, SpriteSheet.CHARACTERS);
    public static Sprite ISOWALL   = new Sprite(64, 4, 0, SpriteSheet.CHARACTERS);
    
    public static Sprite FLOOR     = new Sprite(64, 2, 0, SpriteSheet.CHARACTERS);
    public static Sprite NEW_WALL  = new Sprite(64, 3, 0, SpriteSheet.CHARACTERS);
    
    public static Sprite WEAPON    = new Sprite(64, 0, 5, SpriteSheet.CHARACTERS);
    public static Sprite UNICON    = new Sprite(64, 1, 5, SpriteSheet.CHARACTERS);
    public static Sprite SWORD     = new Sprite(64, 2, 5, SpriteSheet.CHARACTERS);
    public static Sprite WAND      = new Sprite(64, 3, 5, SpriteSheet.CHARACTERS);
    
    public static Sprite WALL2     = new Sprite(64, 0, 0, SpriteSheet.WALLS);
    
    
    public final int SIZE;
    public int x, y;
    public int width, height;
    private SpriteSheet sheet;
    private BufferedImage image;

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }

    public Sprite(int x, int y, int width, int height, SpriteSheet sheet) {
        SIZE = 64;
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.width = width;
        this.height = height;
        this.sheet = sheet;
        loadBigImage();
    }

    private void load() {
        image = sheet.getImage().getSubimage(x, y, SIZE, SIZE);
    }

    private void loadBigImage() {
        image = sheet.getImage().getSubimage(x, y, width, height);
    }

    public BufferedImage getImage() {
        if(image != null) {
            return image;
        } else {
            System.out.println("sprite is null");
            return null;
        }
    }
}
