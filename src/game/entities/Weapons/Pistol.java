package game.entities.Weapons;

import static engine.Main.game;
import engine.time.Delay;
import game.entities.Player;
import game.entities.Projectiles.PistolBullet;

public class Pistol extends AbstractWeapon {

	public Pistol(Player owner) {
		super("Pistol", owner, new Delay(0.5f));
	}
	
	public void fire() {
		shotDelay.reset();
		shotDelay.start();
		game.addEntity(new PistolBullet(owner));
	}
	
}
