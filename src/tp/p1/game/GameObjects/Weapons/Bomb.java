package tp.p1.game.GameObjects.Weapons;

import tp.p1.game.Game;
import tp.p1.game.GameObjects.Ships.DestroyerAlien;

public class Bomb extends Weapon{
	public Bomb(Game game, int x, int y, int live, DestroyerAlien propietario) {
		super(game, x, y, live, propietario);
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
		y++;
	}
	@Override
	public String toString() {
		return "·";
	}	
}
