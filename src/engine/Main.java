package engine;

import engine.Time;
import game.Game;

// Display and Input imports from lwjgl
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Main {
	
	public static Game game;
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		initDisplay();
		initGL();
		initGame();
		
		gameLoop();
		
		cleanUp();
	}
	
	
	private static void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
			Keyboard.create();
			Mouse.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	private static void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
		
		glDisable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		
		glClearColor(0, 0, 0, 0);
	}
	
	private static void initGame() {
		game = new Game();
	}
	
	private static void gameLoop() {
		// All of this Time code is for recording fps
		Time.init();
        
        int frames = 0;
        long lastTime = System.nanoTime();
        long totalTime = 0;
        
        while (!Display.isCloseRequested()) {
            long now = System.nanoTime();
            long passed = now - lastTime;
            lastTime = now;
            totalTime += passed;
            if (totalTime >= 1000000000) {
                System.out.println(frames);
                totalTime = 0;
                frames = 0;
            }
            
            Time.update();
            // Game engine works in 3 parts: 1) get player input 2) update all entities 3) render all entities
            {
            	getInput();
            	update();
            	render();
            }
            
            frames++;
        }
	}
	
	private static void getInput() {
		game.getInput();
	}
	
	private static void update() {
		game.update();
	}
	
	private static void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
		
		game.render();
		
		Display.update();
		Display.sync(60);;
	}
	
	private static void cleanUp() {
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}
	
}
