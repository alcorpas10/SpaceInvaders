
package tp.p1.game.GameObjects.Weapons;

import tp.p1.game.Game;
import tp.p1.game.GameObjects.UCMShip;

public class UCMMissile extends Weapon{
	
	//constructor
	public UCMMissile(Game game, int x, int y, int live, UCMShip propietario) {
		super(game, x, y, 1, propietario);
	}
	
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		y--;
	}
	
	@Override
	public String toString() {
		return "oo";
	}
}
