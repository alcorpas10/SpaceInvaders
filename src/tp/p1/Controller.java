package tp.p1;

import java.util.Scanner;

import tp.p1.Command.Command;
import tp.p1.game.Game;
import tp.p1.util.CommandGenerator;

public class Controller {
	private Game game;
	private Scanner in;
	private static String PROMPT = "Command > ";
	private static String unknownCommandMsg = "No se pudo realizar la accion\n";
	
	//constructor
	public Controller(Game game) {
		this.game = game;
		in = new Scanner(System.in);
	}

	//metodo principal del juego, hasta que no acabe se seguira jugando
	public void run() {
		System.out.println(game);
		draw();
		userCommand();
		//una vez acaba el juego printeo el tablero en su ultimo estado game over y, en caso de haber finalizado naturalmente
		//(sin uso del EXIT), la razon junto a las estadisticas
		
		//System.out.println(new GamePrinter(game, 8, 9));
		System.out.println(
				"      ________                                          __________ \r\n" + 
				"     /  _____/_____    _____   ____     _______  __ ____\\______   \\\r\n" + 
				"    /   \\  ___\\__  \\  /     \\_/ __ \\   /  _ \\  \\/ // __ \\|       _/\r\n" + 
				"    \\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  (  <_> )   /\\  ___/|    |   \\\r\n" + 
				"     \\______  (____  /__|_|  /\\___  >  \\____/ \\_/  \\___  >____|_  /\r\n" + 
				"            \\/     \\/      \\/     \\/                   \\/       \\/ ");
		
		System.out.println(game.getWinnerMessage());
		System.out.println(game);
	}
	
	//metodos privados que se encargan de distintos segmentos de la partida
	private void draw() {
		System.out.println(new GamePrinter(game, 8, 9));
	}
	private void userCommand() {
		while (!game.isFinished()){
			System.out.println(PROMPT);
			String[] words = in.nextLine().toLowerCase().trim().split ("\\s+");
			try {
				Command command = CommandGenerator.parseCommand(words);
				if (command != null) {
					if (command.execute(game)) {
						game.update();
						System.out.println(game);
						draw();
					}
				}
				else System.out.format(unknownCommandMsg);
			}
			catch(Exception e) {
				System.out.println("Incorrect argument format");//Command.incorrectArgsMsg);
			}
		}
	}
}
