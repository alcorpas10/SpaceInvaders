package tp.p1.game;

import java.util.Random;

import tp.p1.game.GameObjects.Ships.AlienShip;
import tp.p1.game.GameObjects.Ships.Ship;
import tp.p1.game.GameObjects.BoardInitializer;
import tp.p1.game.GameObjects.GameObject;
import tp.p1.game.GameObjects.IPlayerController;
import tp.p1.game.GameObjects.UCMShip;
import tp.p1.game.GameObjects.Lists.GameObjectBoard;

public class Game implements IPlayerController{
	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;
	private int currentCycle;
	private Random rand;
	private Level level;
	GameObjectBoard board;
	private UCMShip player;
	private boolean doExit;
	private BoardInitializer initializer ;
	
	public Game (Level level, Random random){
		this.rand = random;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
	}
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		player = new UCMShip(this, DIM_X / 2, DIM_Y - 1, 3);
		board.add(player);
	}
	public Random getRandom() {
		return rand;
	}
	public Level getLevel() {
		return level;
	}
	public void reset() {
		initGame();
	}
	public void addObject(GameObject object) {
		board.add(object);
	}
	public String positionToString(int x, int y) {
		return board.toString(x, y);
	}
	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}
	public boolean aliensWin() {
		return !player.isAlive () || AlienShip.haveLanded();
	}
	private boolean playerWin () {
		return AlienShip.allDead();
	}
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}
	public boolean isOnBoard(int x, int y) {
		return x >= 0 && y >= 0 && x < DIM_X && y < DIM_Y;
	}
	public void exit() {
		doExit = true;
	}
	public String infoToString() {
		return "Cycles: " + currentCycle + "\n" + player.stateToString() + "Remaining aliens: " + AlienShip.getRemainingAliens() + "\n";
	}
	public String getWinnerMessage () {
		if (this.playerWin()) return "Enhorabuena ganaste!!! Has acabado con todo lo que se ha puesto en medio.\\n";
		else if (this.aliensWin()) return "Vaya... Parece que esta vez esas navecitas han podido contigo.\\n";
		else return "Player exits the game";
	}
	// TODO implementar los métodos del interfaz IPlayerController
	@Override
	public boolean move(int numCells) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean shootLaser() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean shockWave() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void receivePoints(int points) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enableShockWave() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enableMissile() {
		// TODO Auto-generated method stub
		
	}
}