package tp.p1.game;

public enum Level {
	EASY(4, 2, 0.2, 3, 0.5, 1), HARD(8, 4, 0.3, 2, 0.2, 2), INSANE(12, 4, 0.5, 1, 0.1, 3);
	private int numReg, numDes, vel, numRowsReg;
	private double freqDis, freqOvni;
	
	//constructor privado de los niveles
	private Level(int numReg, int numDes, double freqDis, int vel, double freqOvni, int numRowsReg) {
		this.numReg = numReg;
		this.numDes = numDes;
		this.freqDis = freqDis;
		this.vel = vel;
		this.freqOvni = freqOvni;
		this.numRowsReg = numRowsReg;
	}
	
	//getters
	public int getNumReg() {
		return numReg;
	}
	public int getNumDes() {
		return numDes;
	}
	public double getShootFrequency() {
		return freqDis;
	}
	public int getVel() {
		return vel;
	}
	public double getOvniFrequency() {
		return freqOvni;
	}
	public int getNumRowsReg() {
		return numRowsReg;
	}
	public int getNumRegularAliensPerRow() {
		return numReg / numRowsReg;
	}
	public int getNumDestroyerAliensPerRow() {
		return getNumDes();
	}
	public static Level fromParam(String param) {
		for (Level level : Level. values() )
			if (level . name().equalsIgnoreCase(param)) return level;
		return EASY;
	}
	public Double getTurnExplodeFreq(){
		return 0.05;
	}
}
