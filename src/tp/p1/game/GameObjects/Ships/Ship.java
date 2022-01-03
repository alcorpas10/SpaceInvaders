package tp.p1.game.GameObjects.Ships;

import tp.p1.game.Game;
import tp.p1.game.GameObjects.GameObject;

public abstract class Ship extends GameObject {
	public Ship(Game game, int x, int y, int life) {
		super(game, x, y, life);
	}

	public abstract void setBombaDestruida();
}
