package game.entities.Projectiles;

import game.entities.Player;

public class PistolBullet extends AbstractProjectile {
	
	public PistolBullet(Player owner) {
		super(owner.getX(), owner.getY(), 10, 10, 0.1f, 0.1f, 0.1f, 1, 1);
		this.dx = 1;
		this.dy = 1;
	}

}
