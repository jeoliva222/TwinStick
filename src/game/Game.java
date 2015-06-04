package game;

import static org.lwjgl.opengl.GL11.*;

public class Game {
	
	public Game() {
		System.out.println("Welcome to TwinStick");
	}
	
	public void getInput() {
		
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	/**
	 * @param x -- center of sprite x coordinate
	 * @param y -- center of sprite y coordinate
	 * @param sx -- size of sprite x
	 * @param sy -- size of sprite y
	 */
	public void drawBox(float x, float y, float sx, float sy) {
		glColor3f(1f, 1f, 1f);
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
	
}
