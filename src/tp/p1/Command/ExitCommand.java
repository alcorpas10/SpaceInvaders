package tp.p1.Command;

import tp.p1.game.Game;

public class ExitCommand extends Command {

	public ExitCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}
	public ExitCommand() {
		super("exit", "e", "Exit", "Terminates the program.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		game.exit();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(this.matchCommandName(commandWords[0])) {
			return new ExitCommand();
		}
		else {
			return null;
		}
	}

}
