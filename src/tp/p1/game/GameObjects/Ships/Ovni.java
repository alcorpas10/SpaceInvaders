package tp.p1.game.GameObjects.Ships;

import tp.p1.game.Game;

public class Ovni extends EnemyShip {
	
	public Ovni(Game game, int x, int y, int life) {
		super(game, x, y, life);
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
		x--;
	}
	
	@Override
	public String toString() {
		return "O[" + getLive() + "]";
	}

	@Override
	public void setBombaDestruida() {}
}
