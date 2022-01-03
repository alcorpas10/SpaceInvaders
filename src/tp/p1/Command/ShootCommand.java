package tp.p1.Command;

import tp.p1.game.Game;

public class ShootCommand extends Command {

	public ShootCommand() {
		super("shoot", "s", "Shoot", "UCM-Ship launches a missile.");
	}
	
	@Override
	public boolean execute(Game game) {
		return game..disparar();
	}

	@Override
	public Command parse(String[] commandWords) {
		if(this.matchCommandName(commandWords[0])) {
			return new ShootCommand();
		}
		else {
			return null;
		}
	}

}
