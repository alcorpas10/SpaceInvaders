package tp.p1.game.GameObjects;

import tp.p1.game.GameObjects.Ships.Ship;
import tp.p1.game.GameObjects.Weapons.UCMMissile;
import tp.p1.game.Game;

public class UCMShip extends Ship {
	private boolean tieneMisil;
	
	//constructor
	public UCMShip(Game game, int x, int y, int life) {
		super(game, x, y, life);
		tieneMisil = false;
	}
	
	//metodos de movimiento
	public void mover(int i) {
		if (col + i < 9 && col + i > -1) col += i;
	}
	//metodos de disparo
	public boolean puedeDisparar() {
		return !tieneMisil;
	}
	public void dispara() {
		tieneMisil = true;
		game.addObject(new UCMMissile(fil, col, this));
	}
	//otros metodos
	public void reduceLife() {
		life--;
	}
	//override del toString para las UCMShip
	

	public String stateToString() {
		return null;
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
		
		// TODO Auto-generated method stub
	}
	
	@Override
	public String toString() {
		if (this.isAlive()) return "^__^";
		else return "!xx!";
	}
	@Override
	public void setBombaDestruida() {
		tieneMisil = false;
	}
}
