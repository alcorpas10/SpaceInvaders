package tp.p1.classes;

public class RegularShipList {
	private RegularShip[] rShipList;
	private int numNaves;
	
	//constructor
	public RegularShipList(int numNaves) {
		this.numNaves = 0;
		rShipList = new RegularShip[numNaves];
	}
	
	//getters
	public int getColNave(int pos) {
		return rShipList[pos].getCol();
	}
	public int getFilNave(int pos) {
		return rShipList[pos].getFil();
	}
	public int getLife(int pos) {
		return rShipList[pos].getLife();
	}
	public int getLength() {
		return numNaves;
	}
	//metodos para insercion y borrado de naves de la lista
	public void anadir(RegularShip rShip){
		rShipList[numNaves] = rShip;
		numNaves++;
	}
	private void borrarNave(int pos) {
		rShipList[pos] = null;
		for (int i = pos; i < numNaves - 1; i++) {
			rShipList[i] = rShipList[i + 1];
		}
		numNaves--;
		rShipList[numNaves] = null;
	}	
	//metodos para el movimiento de las naves de la lista
	public void mover(boolean irDerecha) {
		if (irDerecha) this.derecha();
		else this.izquierda();
	}
	public void abajo() {
		for(int i=0; i < numNaves; i++)
			rShipList[i].moverAbajo();
	}
	private void derecha() {
		for(int i=0; i < numNaves; i++)
			rShipList[i].moverDer();
	}
	private void izquierda() {
		for(int i=0; i < numNaves; i++)
			rShipList[i].moverIzq();
	}
	//otros metodos
	public boolean pared(){
		boolean pared = false;
		for (int i=0; i < numNaves && !pared; i++)
			if (rShipList[i].getCol() == 0 || rShipList[i].getCol() == 8)
				pared= true;
		return pared;
	}
	public boolean alcanzaFilaUcm() {
		boolean haLlegado = false;
		for (int i = 0; i < numNaves && !haLlegado; i++)
			if (rShipList[i].getFil() == 7) haLlegado = true;
		return haLlegado;
	}
	public void bajarVidaNave(int pos) {
		rShipList[pos].reduceLife();
		if (!rShipList[pos].estaViva()) {
			borrarNave(pos);
		}
	}
	public boolean algunaViva() {
		boolean vivo = false;
		for (int i = 0; i < numNaves && !vivo; i++) {
			vivo = rShipList[i].getLife() > 0;
		}
		return vivo;
	}
	//devuelve el string correspondiente a una nave si la hay en la posicion indicada
	public String toString(int fil, int col) {
		boolean encontrado = false;
		int pos = 0;
		while (pos < numNaves && !encontrado) {
			if (rShipList[pos].isInPos(fil, col)) {
				encontrado = true;
			}
			pos++;
		}
		if (encontrado) return rShipList[--pos].toString();
		else return "";
	}
}
