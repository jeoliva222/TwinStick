package game.entities.Weapons;

import static engine.Main.game;
import engine.time.Delay;
import game.entities.Player;

public abstract class AbstractWeapon {
	
	String name;
	
	Player owner;
	
	Delay shotDelay;
	
	public AbstractWeapon(String name, Player owner, Delay shotDelay) {
		this.name = name;
		this.owner = owner;
		this.shotDelay = shotDelay;
	}
	

	public void fire() {
	}
	
	public Delay getShotDelay() {
		return this.shotDelay;
	}

}