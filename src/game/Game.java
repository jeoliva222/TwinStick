package game;

import static org.lwjgl.opengl.GL11.*;
import game.entities.*;
import java.util.ArrayList;

public class Game {
	
	private ArrayList<AbstractEntity> entities;
	private ArrayList<AbstractEntity> removedEntities;
	
	public Game() {
		System.out.println("Welcome to TwinStick");
		
		entities = new ArrayList<AbstractEntity>();
		removedEntities = new ArrayList<AbstractEntity>();
		
		entities.add(new AbstractEntity(100, 100, 30, 30, 0.5f, 0.5f, 1f));
		
	}
	
	public void getInput() {
		
	}
	
	public void update() {
		for (int i = 0; i < entities.size(); i++) {
	        if (entities.get(i).getExists()) {
	            entities.get(i).update();
	        } else {
	            removedEntities.add(entities.get(i));
	            entities.remove(i);
	        }
	    }
		for (int i = 0; i < removedEntities.size(); i++) {
			removedEntities.remove(i);
		}
	}
	
	public void render() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render();
	    }
	}

	/**
	 * @param x -- center of sprite x coordinate
	 * @param y -- center of sprite y coordinate
	 * @param sx -- size of sprite x
	 * @param sy -- size of sprite y
	 * 
	 * @param r -- percentage of red color, 0-1.0 range
	 * @param g -- percentage of green color, 0-1.0 range
	 * @param b -- percentage of blue color, 0-1.0 range
	 */
	public void drawBox(float x, float y, float sx, float sy, float r, float g, float b) {
		glColor3f(r, g, b);
		glBegin(GL_QUADS);
		{
            glTexCoord2f(0, 0); glVertex2f(x - (sx/2), y - (sy/2));
            glTexCoord2f(0, 1); glVertex2f(x - (sx/2), y + (sy/2));
            glTexCoord2f(1, 1); glVertex2f(x + (sx/2), y + (sy/2));
            glTexCoord2f(1, 0); glVertex2f(x + (sx/2), y - (sy/2));
		}
		glEnd();
	}
	
	/**
	 * @param x -- center of sprite x coordinate
	 * @param y -- center of sprite y coordinate
	 * @param sx -- size of sprite x
	 * @param sy -- size of sprite y
	 */
	public void drawBox(float x, float y, float sx, float sy) {
		drawBox(x, y, sx, sy, 1, 1, 1);
	}
	
}
