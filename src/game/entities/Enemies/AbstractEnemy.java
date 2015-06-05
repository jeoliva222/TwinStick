package game.entities.Enemies;

import game.entities.AbstractEntity;

public abstract class AbstractEnemy extends AbstractEntity {
	
	String name;
	
	int health;

	public AbstractEnemy(float x, float y, float sx, float sy, float r,
			float g, float b) {
		super(x, y, sx, sy, r, g, b);
	}
	
	

}
