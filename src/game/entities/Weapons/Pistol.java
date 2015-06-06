package game.entities.Weapons;

import static engine.Main.game;
import game.entities.Player;
import game.entities.Projectiles.PistolBullet;

public class Pistol extends AbstractWeapon {

	public Pistol(Player owner) {
		super("Pistol", owner, 0.5f);
	}
	
	public void fire() {
		game.addEntity(new PistolBullet(owner));
	}
	
}
