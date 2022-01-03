package tp.p1.Command;

import tp.p1.game.Game;
import tp.p1.util.CommandGenerator;

public class HelpCommand extends Command {
	public HelpCommand() {
		super("help", "h", "Help", "Prints this help message.");
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(CommandGenerator.commandHelp());
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(this.matchCommandName(commandWords[0])) {
			return new HelpCommand();
		}
		else {
			return null;
		}
	}

}
