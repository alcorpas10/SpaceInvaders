package tp.p1.Command;

import tp.p1.game.Game;

public class NoneCommand extends Command {

	public NoneCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}
	public NoneCommand() {
		super("none", "\n", "[None]", "Skips one cycle.");
	}
	
	@Override
	public boolean execute(Game game) {
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(this.matchCommandName(commandWords[0])) {
			return this;
		}
		else {
			return null;
		}
	}

}
