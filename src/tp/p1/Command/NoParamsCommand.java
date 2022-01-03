package tp.p1.Command;

import tp.p1.game.Game;

public abstract class NoParamsCommand extends Command {

	public NoParamsCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	@Override
	public Command parse(String[] commandWords) {
		if(this.matchCommandName(commandWords[0])) {
			return new this();
		}
		else {
			return null;
		}
	}

}
