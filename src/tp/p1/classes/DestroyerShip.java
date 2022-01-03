package tp.p1.classes;

public class DestroyerShip {
	private int col;
	private int fil;
	private int vida;
	private boolean tieneProyectil;
	
	//constructor
	public DestroyerShip(int fil, int col) {
		this.col = col;
		this.fil = fil;
		vida = 1;
		tieneProyectil = false;
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
	//setter
	public void setProyectilDestruido() {
		tieneProyectil = false;
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
	//metodos de disparo
	public boolean puedeDisparar() {
		return !tieneProyectil;
	}
	public Proyectil dispara() {
		tieneProyectil = true;
		//crea un proyectil pasandose a si mismo comp parametro en el constructor para que el proyectil sepa quien es su propietario
		return new Proyectil(fil, col, this);
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
	//override del toString para las DestroyerShip
	public String toString() {
		return "D[" + vida + "]";
	}
}
