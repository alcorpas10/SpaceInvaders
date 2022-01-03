package tp.p1.classes;

public class BombList {	
	private Proyectil[] proyectilList;
	private int numProyectiles;
	private Misil misil;
	
	//constructor
	public BombList(int maxBombas) {
		proyectilList = new Proyectil[maxBombas];
		numProyectiles = 0;
		misil = null;
	}
	
	//getters
	public int getFilMisil() {
		return misil.getFil();
	}
	public int getColMisil() {
		return misil.getCol();
	}
	public int getNumProyectiles() {
		return numProyectiles;
	}
	//metodos para insercion y borrado de proyectiles/misiles
	public void anadir(Misil misil) {
		this.misil = misil;
	}
	public void anadir(Proyectil proyectil) {
		proyectilList[numProyectiles] = proyectil;
		numProyectiles++;
	}
	public void borrar() {
		misil = null;
	}
	public void borrar(int pos) {
		proyectilList[pos].estoyEliminado();
		proyectilList[pos] = null;
		for (int i = pos; i < numProyectiles - 1; i++) {
			proyectilList[i] = proyectilList[i + 1];
		}
		numProyectiles--;
		proyectilList[numProyectiles] = null;
	}
	//metodos de movimiento
	public void moverMisiles() {
		for (int i = numProyectiles - 1; i >= 0 ; i--) {
			if (proyectilList[i].getFil() == 7) this.borrar(i);
			else proyectilList[i].mover();
		}
		if (misil != null) {
			if (misil.getFil() == 0) misil = null;
			else misil.mover();
		}
	}
	//metodos de comprobacion de choques
	public int comprobarChoqueUcm(int fil, int col) {
		boolean enc = false;
		int pos = numProyectiles - 1;
		while (pos >= 0 && !enc) {
			enc = (proyectilList[pos].getFil() == fil && proyectilList[pos].getCol() == col);
			pos--;
		}
		if (enc) return ++pos;
		else return -1;
	}
	public int comprobarChoqueBombas(){
		boolean enc = false;
		int pos = numProyectiles - 1;
		while (pos >= 0 && !enc) {
			enc = ((misil.getFil() - proyectilList[pos].getFil() < 2) && (misil.getFil() - proyectilList[pos].getFil() > -1) && proyectilList[pos].getCol() == misil.getCol());
			pos--;
		}
		if (enc) return ++pos;
		else return -1;	
	}
	public boolean comprobarChoqueNave(int fil, int col) {
		return misil.getFil() == fil && misil.getCol() == col;
	}
	public boolean ovniAlcanzado(int fil, int col) {
		if (col == misil.getCol() && misil.getFil() == fil) {
			misil = null;
			return true;
		}
		else return false;
	}
	//otros metodos
	public boolean existeMisil() {
		return misil != null;
	}
	public boolean existeProyectil(Proyectil proyectil) {
		boolean enc = false;
		for (int i = 0; i < numProyectiles; i++) {
			if (proyectil == proyectilList[i]) {
				enc = true;
			}
		}
		return enc;
	}
	//devuelve el string correspondiente a un proyectil/misil si lo hay en la posicion indicada
	public String toString(int fil, int col) {
		boolean encontrado = false;
		int pos = 0;
		if (misil != null && misil.getCol() == col && misil.getFil() == fil) return misil.toString();
		else {
			while (pos < numProyectiles && !encontrado) {
				if (proyectilList[pos].getCol() == col && proyectilList[pos].getFil() == fil) {
					encontrado = true;
				}
				pos++;
			}
			if (encontrado) return proyectilList[--pos].toString();
			else return "";
		}
	}
}
