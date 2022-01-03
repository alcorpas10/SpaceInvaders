package tp.p1.Command;

import tp.p1.game.Game;

public class MoveCommand extends Command {
	private String[] accion;
	public MoveCommand(String[] comandos) {
		super("move", "m", "Move <left|right><1|2>", "Moves UCM-Ship to the indicated direction.");
		accion = comandos;
	}
	public MoveCommand() {
		super("move", "m", "Move <left|right><1|2>", "Moves UCM-Ship to the indicated direction.");
		accion = null;
	}
	
	@Override
	public boolean execute(Game game) {
		return game.move(0);
	}

	@Override
	public Command parse(String[] commandWords) {
		if(this.matchCommandName(commandWords[0])) {
			return new MoveCommand(commandWords);
		}
		else {
			return null;
		}
	}

}
