package tp.p1.game.GameObjects;

public interface IPlayerController {
	// PLAYER ACTIONS
	public boolean move (int numCells);
	public boolean shootLaser();
	public boolean shockWave();
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}