package game.entities.Powerups;

import game.entities.AbstractEntity;

public abstract class AbstractPowerup extends AbstractEntity {
	
	String name;

	public AbstractPowerup(float x, float y, float sx, float sy, float r,
			float g, float b) {
		super(x, y, sx, sy, r, g, b);
	}

}
