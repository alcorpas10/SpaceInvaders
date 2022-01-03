package tp.p1.game.GameObjects.Weapons;

import tp.p1.game.Game;
import tp.p1.game.GameObjects.GameObject;
import tp.p1.game.GameObjects.Ships.Ship;

public abstract class Weapon extends GameObject {
	private Ship propietario;
	public Weapon(Game game, int x, int y, int live, Ship propietario) {
		super(game, x, y, live);
		this.propietario = propietario;
	}

	public void estoyEliminado() {
		propietario.setBombaDestruida();
	}
}
