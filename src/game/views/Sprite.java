package game.views;

import static org.lwjgl.opengl.GL11.*;

public class Sprite {
	
	protected float r;
	protected float g;
	protected float b;
	
	protected float sx;
	protected float sy;
	
	/**
	 * @param sx -- x size
	 * @param sy -- y size
	 * @param r -- red color, 0f-1f range
	 * @param g -- green color, 0f-1f range
	 * @param b -- blue color, 0f-1f range
	 */
	public Sprite(float sx, float sy, float r, float g, float b) {
		this.sx = sx;
		this.sy = sy;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void render() {
		glColor3f(r, g, b);
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0); glVertex2f(-sx/2, -sy/2);
			glTexCoord2f(0, 1); glVertex2f(-sx/2,  sy/2);
			glTexCoord2f(1, 1); glVertex2f( sx/2,  sy/2);
			glTexCoord2f(1, 0); glVertex2f( sx/2, -sy/2);
		}
		glEnd();
	}
	
	public float getSX() {
		return sx;
	}
	
	public float getSY() {
		return sy;
	}
	
}
