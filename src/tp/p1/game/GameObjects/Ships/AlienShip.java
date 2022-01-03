package tp.p1.game.GameObjects.Ships;

import tp.p1.game.Game;

public abstract class AlienShip extends EnemyShip {

	public AlienShip(Game game, int x, int y, int life) {
		super(game, x, y, life);
	}

	public static boolean allDead() {
		
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean haveLanded() {
		// TODO Auto-generated method stub
		return false;
	}

	public static String getRemainingAliens() {
		// TODO Auto-generated method stub
		return null;
	}

}
