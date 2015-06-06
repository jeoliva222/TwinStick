package game.entities.Weapons;

import static engine.Main.game;
import game.entities.Player;

public abstract class AbstractWeapon {
	
	String name;
	
	Player owner;
	
	float shotDelay;
	
	public AbstractWeapon(String name, Player owner, float shotDelay) {
		this.name = name;
		this.owner = owner;
		this.shotDelay = shotDelay;
	}
	
	public void fire() {
	}

}