package tp.p1.Command;

import tp.p1.game.Game;

public class ListCommand extends Command {
	public ListCommand() {
		super("list", "l", "List", "Prints the list of available ships.");
	}
	
	@Override
	public boolean execute(Game game) {
		System.out.println();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(this.matchCommandName(commandWords[0])) {
			return new ListCommand();
		}
		else {
			return null;
		}
	}

}
