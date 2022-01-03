package tp.p1.classes;

public class Ovni {
	private int col;
	private int fil;
	private int life;
	
	public Ovni() {
		col = 9; //lo creo en la 0, 9 porque se mueve instantaneamente tras crearse a la 0, 8
		fil = 0;
		life = 1;
	}
	public int getCol() {
		return col;
	}
	public int getFil() {
		return fil;
	}
	public int getLife() {
		return life;
	}
	public void mover() {
		col--;
	}
	public String toString() {
		return "O[" + life + "]";
	}
}
