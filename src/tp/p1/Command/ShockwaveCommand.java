package tp.p1.Command;

import tp.p1.game.Game;

public class ShockwaveCommand extends Command {
	public ShockwaveCommand() {
		super("shockwave", "s", "Shockwave", "UCM-Ship releases a shock wave.");
	}

	@Override
	public boolean execute(Game game) {
		return game.usarShockwave();
	}

	@Override
	public Command parse(String[] commandWords) {
		if(this.matchCommandName(commandWords[0])) {
			return new ShockwaveCommand();
		}
		else {
			return null;
		}	}

}
