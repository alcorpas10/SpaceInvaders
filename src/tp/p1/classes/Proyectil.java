package tp.p1.classes;

public class Proyectil {
	private int col;
	private int fil;
	private DestroyerShip propietario;
	
	//constructor
	public Proyectil(int fil, int col, DestroyerShip dShip) {
		this.col = col;
		this.fil = fil;
		propietario = dShip;
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
		fil++;
	}
	//otros metodos
	public void estoyEliminado() {
		propietario.setProyectilDestruido();
	}
	//override del toString para los Proyectiles
	public String toString() {
		return "·";
	}
}
