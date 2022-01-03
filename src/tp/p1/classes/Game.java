package tp.p1.classes;

import java.util.Random;

public class Game {
	private Random rndm;
	private Level level;
	private int numCiclos, ciclosEnDir, numPuntos, numOvnisDest;
	private boolean haLlegado, irDerecha, shockWave, isFinished;
	private RegularShipList rShipList;
	private DestroyerShipList dShipList;
	private BombList bList;
	private UCMShip ucmShip;
	private Ovni ovni;
	
	//constructores
	public Game(Level level, int i) {
		rndm = new Random(i);
		this.level = level;
		numCiclos = 0;
		ciclosEnDir = 1;
		numPuntos = 0;
		numOvnisDest = 0;
		haLlegado = false;
		irDerecha = true;
		shockWave = false;
		isFinished = false;
		rShipList = new RegularShipList(getNumReg());
		dShipList = new DestroyerShipList(getNumDes());
		bList = new BombList(getNumDes());
		ucmShip = new UCMShip();
		ovni = null;
		iniciaListas();
	}
	public Game(Level level) {
		rndm = new Random();
		this.level = level;
		numCiclos = 0;
		ciclosEnDir = 1;
		numPuntos = 0;
		numOvnisDest = 0;
		haLlegado = false;
		irDerecha = true;
		shockWave = false;
		isFinished = false;
		rShipList = new RegularShipList(getNumReg());
		dShipList = new DestroyerShipList(getNumDes());
		bList = new BombList(getNumDes());
		ucmShip = new UCMShip();
		ovni = null;
		iniciaListas();
	}	
	
	//getters publicos llamados por Controller para dibujar correctamente las estadisticas
	public int getAliens() {
		return rShipList.getLength() + dShipList.getLength();
	}
	public int getLife() {
		return ucmShip.getLife();
	}
	public Level getLevel() {
		return level;
	}
	public int getCycles() {
		return numCiclos;
	}
	public int getPoints() {
		return numPuntos;
	}
	public boolean getShockWave() {
		return shockWave;
	}
	public boolean getIsFinished() {
		return isFinished;
	}
	//metodos publicos llamados por Controller para funcionar adecuadamente
	public void computerAction() {
		if (!existeOvni() && rndm.nextFloat() <= level.getFreqOvni()) {
			ovni = new Ovni(); 
		}
		for (int i = 0; i < dShipList.getLength(); i++) {
			if (rndm.nextDouble() <= level.getFreqDis() && dShipList.puedeDisparar(i)) {
				bList.anadir(dShipList.dispara(i)); //devuelve un proyectil creado por su padre mediante el constructor
			}
		}
		//interpreto que tanto el ovni como los proyectiles deben desaparecer durante un ciclo y al siguiente crearse, 
		//si se quisiera destruir y crear en el mismo haria falta un cambio en el orden de update y computerAction
	}	
	public void update() {
		//1) se mueven los misiles
		bList.moverMisiles();
		ucmShip.setEstadoMisil(bList.existeMisil());
		
		//2) movemos naves y ovni
		if (haLlegado) {
			if (bList.existeMisil()) comprobarChoques(); //para que el misil no atraviese la nave
			rShipList.abajo();
			dShipList.abajo();
			irDerecha = !irDerecha;
			haLlegado = false;
		}
		else {
			if (ciclosEnDir == level.getVel()) {
				rShipList.mover(irDerecha);
				dShipList.mover(irDerecha);
				haLlegado = (rShipList.pared() || dShipList.pared());
				ciclosEnDir = 1;
			}
			else ciclosEnDir++;
		}
		if (existeOvni()) {
			if (ovni.getCol() > 0) ovni.mover();
			else ovni = null;
		}
		
		//3) una vez se ha movido todo comprobamos choques
		comprobarChoques();		
		
		//4) ciclo finalizado
		numCiclos++;
		actualizarPuntos();
		isFinished = finished();
	}
	public void disparar() {
		if (!bList.existeMisil()) {
			ucmShip.dispara();
			bList.anadir(new Misil(ucmShip.getFil(), ucmShip.getCol()));
		}
	}
	public void usarShockwave() {
		if (shockWave) {
			shockWave = false;
			for (int i = rShipList.getLength() - 1; i >= 0; i--)
				rShipList.bajarVidaNave(i);
			for (int i = dShipList.getLength() - 1; i >= 0; i--)
				dShipList.bajarVidaNave(i);
			if (existeOvni()) {
				ovni = null; //interpreto que la destruccion de un ovni mediante un shockwave no deberia proporcionar otro
				numOvnisDest++;
			}
		}
	}
	public void moverNave(String movimiento) {
		String[] mov = movimiento.split(" "); //divide el string por el espacio y los trozos los guarda en un array de strings
		int numMovs = Integer.parseInt(mov[1]); //la posicion del array en la que se encontrara el numero la convertimos a int
		if (ucmShip.getCol() + numMovs < 9 && ucmShip.getCol() + numMovs > -1) 
			ucmShip.mover(numMovs);
	}
	//metodos privados auxiliares para el funcionamiento de los constructores y update
	private int getNumReg() {
		return level.getNumReg();
	}
	private int getNumDes() {
		return level.getNumDes();
	}
	private void iniciaListas() {
		int nReg = getNumReg();
		int nDes = getNumDes();
		if (getNumReg() == 4)
			for (int n = 0; n < nReg; n++) {
				rShipList.anadir(new RegularShip(1, 3 + n));
			}
		else
			for (int n = 0; n < nReg / 2; n++) {
				rShipList.anadir(new RegularShip(1, 3 + n));
				rShipList.anadir(new RegularShip(2, 3 + n));
			}
		if (level.equals(Level.INSANE))
			for (int n = 0; n < nDes; n++) {
				dShipList.anadir(new DestroyerShip(3, 3 + n));
			}
		else if (level.equals(Level.HARD))
			for (int n = 0; n < nDes; n++)
				dShipList.anadir(new DestroyerShip(3, 4 + n));
		else
			for (int n = 0; n < nDes; n++)
				dShipList.anadir(new DestroyerShip(2, 4 + n));
	}
	private boolean existeOvni() {
		return ovni != null;
	}
	private boolean finished() {
		if (!ucmShip.estaVivo()) return true;
		else if (!rShipList.algunaViva() && !dShipList.algunaViva()) return true;
		else if (rShipList.alcanzaFilaUcm() || dShipList.alcanzaFilaUcm()) {
			ucmShip.setLife(0);
			return true;
		}
		else return false;
	}
	private void actualizarPuntos() {
		numPuntos = (level.getNumReg() - rShipList.getLength()) * 5 + (level.getNumDes() - dShipList.getLength()) * 10 + numOvnisDest * 25;
	}
	private void comprobarChoques() {
		if (bList.existeMisil()) comprobarChoquesMisil();
		if (bList.getNumProyectiles() > 0) comprobarChoquesProyectiles();
	}
	private void comprobarChoquesMisil() {
		int pos = bList.comprobarChoqueBombas();;
		if (pos != -1) {
			bList.borrar();
			bList.borrar(pos);
		}
		for (int i = dShipList.getLength() - 1; i >= 0 && bList.existeMisil(); i--) {
			if (bList.comprobarChoqueNave(dShipList.getFilNave(i), dShipList.getColNave(i))){
				bList.borrar();
				dShipList.bajarVidaNave(i);
			}
		}
		for (int i = rShipList.getLength() - 1; i >= 0 && bList.existeMisil(); i--) {
			if (bList.comprobarChoqueNave(rShipList.getFilNave(i), rShipList.getColNave(i))){
				bList.borrar();
				rShipList.bajarVidaNave(i);
			}
		}
		if (bList.existeMisil() && existeOvni())
			if (bList.ovniAlcanzado(ovni.getFil(), ovni.getCol())) {
				numOvnisDest++;
				ovni = null;
				shockWave = true;
			}
	}
	private void comprobarChoquesProyectiles() {
		int pos = bList.comprobarChoqueUcm(ucmShip.getFil(), ucmShip.getCol());
		if (pos != -1){
			bList.borrar(pos);
			ucmShip.reduceLife();
		}
	}
	//metodo encargado de rellenar la board de gamePrinter
	public String creaTabla(int i, int j) {
		String objCasilla = "";
		if (existeOvni() && ovni.getCol() == j && i == ovni.getFil()) {
			objCasilla = ovni.toString();
		}
		else if (i == ucmShip.getFil() && ucmShip.getCol() == j) {
			objCasilla = ucmShip.toString();
		}
		else {
			objCasilla = rShipList.toString(i, j);
			if (objCasilla=="") objCasilla = dShipList.toString(i, j);
			if (objCasilla=="") objCasilla = bList.toString(i, j);
		}
		return objCasilla;
	}
}