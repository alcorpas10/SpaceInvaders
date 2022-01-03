package tp.p1.game.GameObjects.Lists;

public class DestroyerShipList {
	private DestroyerAlien[] dShipList;
	private int numNaves;
	
	//constructor
	public DestroyerShipList(int numNaves) {
		this.numNaves = 0;
		dShipList = new DestroyerAlien[numNaves];
	}
	
	//getters
	public int getColNave(int pos) {
		return dShipList[pos].getCol();
	}
	public int getFilNave(int pos) {
		return dShipList[pos].getFil();
	}
	public int getLength() {
		return numNaves;
	}
	//metodos para insercion y borrado de naves de la lista
	public void anadir(DestroyerAlien dShip) {
		dShipList[numNaves] = dShip;
		numNaves++;
	}
	public void borrarNave(int pos) {
		dShipList[pos] = null;
		for (int i = pos; i < numNaves - 1; i++) {
			dShipList[i] = dShipList[i + 1];
		}
		numNaves--;
		dShipList[numNaves] = null;
	}
	//metodos de movimiento
	public void mover(boolean irDerecha) {
		if (irDerecha) derecha();
		else izquierda();
	}
	public void abajo() {
		for(int i=0; i < numNaves; i++)
			dShipList[i].moverAbajo();
	}
	private void derecha() {
		for(int i=0; i < numNaves; i++)
			dShipList[i].moverDer();
	}
	private void izquierda() {
		for(int i=0; i < numNaves; i++)
			dShipList[i].moverIzq();
	}
	//metodos de disparo
	public boolean puedeDisparar(int pos) {
		return dShipList[pos].puedeDisparar();
	}
	public void dispara(int pos) {
		dShipList[pos].dispara();
	}
	//otros metodos
	public boolean pared() {
		boolean pared=false;
		for (int i=0; i < numNaves && !pared; i++)
			if (dShipList[i].getCol() == 0 || dShipList[i].getCol() == 8)
				pared= true;
		return pared;
	}
	public boolean alcanzaFilaUcm() {
		boolean haLlegado = false;
		for (int i = 0; i < numNaves && !haLlegado; i++)
			if (dShipList[i].getFil() == 7) haLlegado = true;
		return haLlegado;
	}
	public void bajarVidaNave(int pos) {
		dShipList[pos].reduceLife();
		if (!dShipList[pos].estaViva())
			borrarNave(pos);
	}
	public boolean algunaViva() {
		boolean vivo = false;
		for (int i = 0; i < numNaves && !vivo; i++) {
			vivo = dShipList[i].getLife() > 0;
		}
		return vivo;
	}
	//devuelve el string correspondiente a una nave si la hay en la posicion indicada
	public String toString(int fil, int col) {
		boolean encontrado = false;
		int pos = 0;
		while (pos < numNaves && !encontrado) {
			if (dShipList[pos].isInPos(fil, col)) {
				encontrado = true;
			}
			pos++;
		}
		if (encontrado) return dShipList[--pos].toString();
		else return "";
	}
}