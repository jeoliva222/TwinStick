package game.entities;

import game.entities.Weapons.AbstractWeapon;
import org.lwjgl.input.Keyboard;
//import org.lwjgl.input.Mouse;

public class Player extends AbstractEntity {
	
	int health;
	
	AbstractWeapon currentWep;

	public Player() {
		super(400, 300, 30, 30, 0.1f, 0.3f, 0.1f);
	}

	public void getInput() {
		dx = 0;
		dy = 0;
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W)){
			dy = 1;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			dy = -1;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			dx = -1;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			dx = 1;
		}
	}
	
}
