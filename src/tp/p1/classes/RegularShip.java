package tp.p1.classes;

public class RegularShip {
	private int fil;
	private int col;
	private int vida;

	//constructor
	public RegularShip(int fil, int col) {
		this.fil = fil;
		this.col = col;
		vida = 2;
	}
	
	//getters
	public int getCol() {
		return col;
	}
	public int getFil() {
		return fil;
	}
	public int getLife() {
		return vida;
	}
	//metodos de movimiento
	public void moverIzq() {
		col--;
	}
	public void moverDer() {
		col++;
	}
	public void moverAbajo() {
		fil++;
	}
	//otros metodos
	public void reduceLife() {
		vida--;
	}
	public boolean isInPos(int fil, int col) {
		return this.fil == fil && this.col == col;
	}
	public boolean estaViva() {
		return vida != 0;
	}
	//override del toString para las RegularShip
	public String toString() {
		return "R[" + vida + "]";
	}
}
