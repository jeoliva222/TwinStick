package game.entities;

import game.entities.Weapons.AbstractWeapon;

public class Player extends AbstractEntity {
	
	int health;
	
	AbstractWeapon currentWep;

	public Player() {
		super(400, 300, 30, 30, 0.1f, 0.3f, 0.1f);
	}

}
