package game.entities.Projectiles;

import game.entities.AbstractEntity;

public abstract class AbstractProjectile extends AbstractEntity {

	protected int source;
	
	protected int damage;
	
	public AbstractProjectile(float x, float y, float sx, float sy, float r,
			float g, float b, int source, int damage) {
		super(x, y, sx, sy, r, g, b);
		this.source = source;
		this.damage = damage;
	}

}
