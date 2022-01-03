package tp.p1.classes;

public enum Level {
	EASY(4, 2, 0.1, 3, 0.5), HARD(8, 2, 0.3, 2, 0.2), INSANE(8, 4, 0.5, 1, 0.1);
	private int numReg, numDes, vel;
	private double freqDis, freqOvni;
	
	//constructor privado de los niveles
	private Level(int numReg, int numDes, double freqDis, int vel, double freqOvni) {
		this.numReg = numReg;
		this.numDes = numDes;
		this.freqDis = freqDis;
		this.vel = vel;
		this.freqOvni = freqOvni;
	}
	
	//getters
	public int getNumReg() {
		return numReg;
	}
	public int getNumDes() {
		return numDes;
	}
	public double getFreqDis() {
		return freqDis;
	}
	public int getVel() {
		return vel;
	}
	public double getFreqOvni() {
		return freqOvni;
	}
}
