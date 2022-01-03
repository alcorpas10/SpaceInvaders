
package tp.p1.classes;

public class Misil {
	private int col;
	private int fil;
	
	//constructor
	public Misil(int fil, int col) {
		this.col = col;
		this.fil = fil;
	}
	
	//getters
	public int getCol() {
		return col;
	}
	public int getFil() {
		return fil;
	}
	//metodos de movimiento
	public void mover() {
		fil--;
	}
	//override del toString para los Misiles
	public String toString() {
		return "oo";
	}
}
