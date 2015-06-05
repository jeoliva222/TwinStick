package game.entities.Weapons;

public abstract class AbstractWeapon {
	
	String name;
	
	float shotDelay;
	
	public AbstractWeapon(String name, float shotDelay) {
		this.name = name;
		this.shotDelay = shotDelay;
	}
	

}