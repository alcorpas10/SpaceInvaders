package tp.p1.game.GameObjects.Ships;

import tp.p1.game.Game;
import tp.p1.game.GameObjects.Weapons.Bomb;

public class DestroyerAlien extends AlienShip{
	private boolean tieneProyectil;
	
	//constructor
	public DestroyerAlien(Game game, int x, int y, int life) {
		super(game, x, y, life);
		tieneProyectil = false;
	}
	//metodos de movimiento
	/*public void moverIzq() {
		col--;
	}
	public void moverDer() {
		col++;
	}
	public void moverAbajo() {
		fil++;
	}*/
	//metodos de disparo
	public boolean puedeDisparar() {
		return !tieneProyectil;
	}
	public void dispara() {
		tieneProyectil = true;
		//crea un proyectil pasandose a si mismo comp parametro en el constructor para que el proyectil sepa quien es su propietario
		game.addObject(new Bomb(game, x, y, 1, this));
	}
	//otros metodos
	public void reduceLife() {
		//vida--;
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
		return "D[" + this.getLive() + "]";
	}
	
	@Override
	public void setBombaDestruida() {
		tieneProyectil = false;		
	}
}