package tp.p1.classes;

public class UCMShip {

	private int col;
	private int fil;
	private int life;
	private boolean tieneMisil;
	
	//constructor
	public UCMShip() {
		col = 4;
		fil = 7;
		life = 3;
		tieneMisil = false;
	}
	
	//getters
	public int getCol() {
		return col;
	}
	public int getFil() {
		return fil;
	}
	public int getLife() {
		return life;
	}
	//setters
	public void setLife(int x) {
		life = x;
	}
	public void setEstadoMisil(boolean sigueEnJuego) {
		tieneMisil = sigueEnJuego;
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
	}
	//otros metodos
	public void reduceLife() {
		life--;
	}
	public boolean estaVivo() {
		return life != 0;
	}
	//override del toString para las UCMShip
	public String toString() {
		if (life > 0) return "^__^";
		else return "!xx!";
	}
}
