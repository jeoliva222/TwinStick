package game.entities;

import game.views.Sprite;
import static org.lwjgl.opengl.GL11.*;
import engine.direction.Direction;

public abstract class AbstractEntity {
	
	protected boolean exists;	// true at object creation, false when deleted from game, use end() function to delete
	protected int type;
	
	protected float x;		
	protected float y;
	protected float oldX;	// x position last tick
	protected float oldY;	// y position last tick
	
	protected float dx;
	protected float dy;
	
	protected Direction direction;
	protected float speed = 0;
	protected float maxSpeed;
	
	protected Sprite spr;
	
	/**
	 * @param x -- x position
	 * @param y -- y position
	 * @param sx -- x size
	 * @param sy -- y size
	 * @param r -- red color, 0f-1f range
	 * @param g -- green color, 0f-1f range
	 * @param b -- blue color, 0f-1f range
	 */
	public AbstractEntity(float x, float y, float sx, float sy, float r, float g, float b) {
		this.exists = true;
		this.type = 1;
		
		this.x = x;
		this.y = y;
		
		this.spr = new Sprite(sx, sy, r, g, b);
		this.direction = new Direction(this);
		this.maxSpeed = 1;
	}
	
	
	
	public void update() {
		personalMove();
	}
	
	public void render() {
		glPushMatrix();
		
		glTranslatef(x, y, 0);
		spr.render();
		
		glPopMatrix();
	}
	
	/**
	 * Used in Game class to determine when to delete the entity
	 */
	public boolean getExists() {
		return exists;
	}
	
	/**
	 * Signals the entity to be deleted
	 */
	public void end() {
		exists = false;
	}
	
	public void personalMove() {
		direction.refreshXY();
		
		if (direction.isNull()) {
			speed = 0;
			direction.resetXY();
		} else {
			x += maxSpeed * direction.getX();
			y += maxSpeed * direction.getY();
		}
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getSX() {
		return spr.getSX();
	}
	
	public float getSY() {
		return spr.getSY();
	}

}
