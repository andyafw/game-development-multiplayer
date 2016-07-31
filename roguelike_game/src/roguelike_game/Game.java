package roguelike_game;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import roguelike_game.developer.DeveloperConsole;
import roguelike_game.entity.Player;
import roguelike_game.events.Movement;
import roguelike_game.graphics.Render;
import roguelike_game.graphics.Sprite;

public class Game extends JFrame implements Runnable, WindowListener {
	private static final long serialVersionUID = -8786702884271086916L;
	public TileMap tilemap;
    public Player player;
    public Movement move;
    public Camera cam;
    public Render render;
    public MenuScreen mainmenu;
    
    public int FPS = 100;
    public int counter = 0;
    public boolean running = false;
    public String version = "Rogue Game - Pre-Alpha build v16.06.21 - 10.51";
    
    private Thread thread;
    
	public Game() {
	    tilemap = new TileMap(100, 100);
	    tilemap.createRandomMap();
	    move = new Movement(this);
	    cam = new Camera();
	    render = new Render(this);
	    player = new Player(13, 9, Sprite.PLAYER_UP);
	    
	    mainmenu = new MenuScreen(this);
	    addKeyListener(move);
	    addMouseListener(move);
	    addMouseMotionListener(move);
	    
	    add(render, BorderLayout.CENTER);
	}
	
	//if no collision then return true
	public boolean collision(int x, int y) {
	    if ((player.getX() + x) < 0 
	        || (player.getX() + x) >= tilemap.width 
	        || (player.getY() + y) < 0 
	        || (player.getY() + y) >= tilemap.height) {
	        return true;
	    }
	    
	    if (tilemap.tiles[player.getY() + y][player.getX() + x] == 0) {
	        return true;
	    } else {
	        return false;
	    }
	}
        
	//update the players movement
	public void updatePlayer(Sprite sprite, int x, int y) {
	    player.setSprite(sprite);
	    player.setX(player.getX() + x);
	    player.setY(player.getY() + y);
	    System.out.println("render " + render.size);
	    cam.x += render.size * x;
	    cam.y += render.size * y;
	    
	    System.out.println("Moving player to " + player.getX() + ", " + player.getY() + ".");
	}
        
    @Override
    public void run() {
        
        boolean[] wait = {false, false, false, false};
        
        System.out.println("Before Loop");
        
        while (running) {
        	FPScounter.StartCounter();
            setTitle(version);
            move.update();

            if(move.OPEN_DEV) {
                DeveloperConsole.getInstance().setVisible(true);
                move.OPEN_DEV = false;
            }
            repaint();
            update(wait);
            FPScounter.StopAndPost();
        }
    }
    
    public void start() {
    	if(!thread.isAlive()) {
    		thread = new Thread(this);
    		thread.start();
    	}
    }
    
    public void stop() {
    	try {
    		thread.join();
    	} catch(InterruptedException ex) {
    		ex.printStackTrace();
    	}
    }
    
    public void update(boolean[] wait) {
    	for (byte i = 0; i < wait.length; i++) {//loop through length of wait array
            boolean isPressed = false;//set ispressed to false
            switch (i) {//similar to an if else but simpler
                case 0://if i = 0
                    isPressed = move.UP;//ispressed = the value of move.up
                    break;
                case 1://if i = 1
                    isPressed = move.DOWN;//ispressed = the value of move.down
                    break;
                case 2://if i = 2;
                    isPressed = move.LEFT;//ispressed = the value of move.left
                    break;
                case 3://if i = 3
                    isPressed = move.RIGHT;//ispressed = the value of move.right
                    break;
            }
        
            if (wait[i]) {//if wait i is true continue
                if (!isPressed) {//if ispressed = false
                    wait[i] = false;//wait i also = false
                }
            } else if (isPressed) {//else if ispressed is true
                int speed = 1;//set speed to 1
                switch (i) {//loop through what the value of i is
	                //if i = 0 then checkcollision and move sprite up
	                case 0: checkCollision(Sprite.PLAYER_UP, 0, -speed);break;
	                //if i = 0 then checkcollision and move sprite down
	                case 1: checkCollision(Sprite.PLAYER_DOWN, 0, speed); break;
	                //if i = 0 then checkcollision and move sprite left
	                case 2: checkCollision(Sprite.PLAYER_LEFT, -speed, 0); break;
	                //if i = 0 then checkcollision and move sprite right
	                case 3: checkCollision(Sprite.PLAYER_RIGHT, speed, 0); break;
                }                        
                wait[i] = true;//set wait i to true before updating again
            }
        }
    }
    
    public void checkCollision(Sprite sprite, int x, int y) {
        if (!collision(x, y)) {//if there is not a collision at x and y then continue
            updatePlayer(sprite, x, y);//move sprite to new position
        }
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        game.setSize(1117, 620);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setLocationRelativeTo(null);
        game.setTitle(game.version); 
        game.setVisible(true);
        game.start();
        game.running = true;
    }
    
    @Override public void windowClosing(WindowEvent arg0) {
    	stop();
    }
	@Override public void windowActivated(WindowEvent arg0) {}
	@Override public void windowClosed(WindowEvent arg0) {}
	@Override public void windowDeactivated(WindowEvent arg0) {}
	@Override public void windowDeiconified(WindowEvent arg0) {}
	@Override public void windowIconified(WindowEvent arg0) {}
	@Override public void windowOpened(WindowEvent arg0) {}
}