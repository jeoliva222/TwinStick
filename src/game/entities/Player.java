package game.entities;

import game.entities.Weapons.AbstractWeapon;
import game.entities.Weapons.Pistol;

import org.lwjgl.input.Keyboard;
//import org.lwjgl.input.Mouse;

public class Player extends AbstractEntity {
	
	int health;
	
	AbstractWeapon currentWep;

	public Player() {
		super(400, 300, 30, 30, 0.1f, 0.3f, 0.1f);
		type = 0;
		this.health = 3;
		this.currentWep = new Pistol(this);
		
		direction.setToCardinal();
	}
	
	public void getInput() {
		direction.resetXY();
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			direction.addUpCardinal();
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			direction.addDownCardinal();
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			direction.addLeftCardinal();
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			direction.addRightCardinal();
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_L) && currentWep.getShotDelay().isOver()) {
			currentWep.fire();
		}
	}
	
}
