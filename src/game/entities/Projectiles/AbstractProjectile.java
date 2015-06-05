package game.entities.Projectiles;

import game.entities.AbstractEntity;

public class AbstractProjectile extends AbstractEntity {

	public AbstractProjectile(float x, float y, float sx, float sy, float r,
			float g, float b) {
		super(x, y, sx, sy, r, g, b);
		// TODO Auto-generated constructor stub
	}

	protected int source;
	
	protected int damage;
}
