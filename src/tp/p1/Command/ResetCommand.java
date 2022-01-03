package tp.p1.Command;

import tp.p1.game.Game;

public class ResetCommand extends Command {
	public ResetCommand() {
		super("reset", "r", "Reset", "Starts a new game.");
	}


	@Override
	public boolean execute(Game game) {
		return game.reset();
	}

	@Override
	public Command parse(String[] commandWords) {
		if(this.matchCommandName(commandWords[0])) {
			return new ResetCommand();
		}
		else {
			return null;
		}
	}

}
