package tp.p1.game.GameObjects;
import tp.p1.game.Game;
import tp.p1.game.Level;
import tp.p1.game.GameObjects.Lists.GameObjectBoard;
public class BoardInitializer {
	private Level level;
	private GameObjectBoard board;
	private Game game;
	public GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this. game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		initializeOvni ();
		initializeRegularAliens ();
		initializeDestroyerAliens ();
		return board;
	}
	private void initializeOvni () {
		
		// TODO implement
	}
	private void initializeRegularAliens () {
		// TODO implement
	}
	private void initializeDestroyerAliens () {
		// TODO implement
	}
}