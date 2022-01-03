package tp.p1.util;

import tp.p1.Command.Command;
import tp.p1.Command.ExitCommand;
import tp.p1.Command.HelpCommand;
import tp.p1.Command.ListCommand;
import tp.p1.Command.MoveCommand;
import tp.p1.Command.NoneCommand;
import tp.p1.Command.ResetCommand;
import tp.p1.Command.ShockwaveCommand;
import tp.p1.Command.ShootCommand;

public class CommandGenerator {
	private static Command[] availableCommands = {
		new ListCommand(),
		new HelpCommand(),
		new ResetCommand(),
		new ShootCommand(),
		new ExitCommand(),
		new NoneCommand(),
		new MoveCommand(),
		new ShockwaveCommand()
	};
	
	public static Command parseCommand(String[ ] commandWords) {
		Command command = null;
		for (int i = 0; i < availableCommands.length && command == null; i++) {
			command = availableCommands[i].parse(commandWords);
		}
		return command;
	}
	public static String commandHelp() {
		String ayuda = null;
		for (int i = 0; i < availableCommands.length; i++) {
			ayuda = availableCommands[i].helpText();
		}
		return ayuda;
	}
}
