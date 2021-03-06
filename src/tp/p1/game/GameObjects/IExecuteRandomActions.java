package tp.p1.game.GameObjects;

import tp.p1.game.Game;
public interface IExecuteRandomActions {
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
	static boolean canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() > game.getLevel().getShootFrequency();
	}
}