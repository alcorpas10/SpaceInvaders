package tp.p1.classes;

import java.util.Scanner;

public class Controller {
	private Game game;
	private Scanner in;
	
	//constructor
	public Controller(Game game) {
		this.game = game;
		in = new Scanner(System.in);
	}

	//metodo principal del juego, hasta que no acabe se seguira jugando
	public void run() {
		GamePrinter gP = null;
		String command;
		do {
			//1) Dibujamos tanto las estadisticas de juego como el tablero 
			draw(gP);
			
			//2) Se ejecuta la accion que desee hacer el jugador humano (devuelve un string para saber si debe finalizarse el juego "EXIT")
			command = userCommand(gP);
			
			//3) La clase Game realiza las tareas relacionadas con la maquina y la aleatoreidad 
			game.computerAction();
			
			//4) Game actualiza todas las posiciones y objetos en juego
			game.update();
			
			System.out.println("*********************************************************************************");
		}
		while(!game.getIsFinished() && !command.equals("E")); //el juego acaba si Game informa de que ha finalizado o si la persona desea finalizarlo
		
		//una vez acaba el juego printeo el tablero en su ultimo estado game over y, en caso de haber finalizado naturalmente
		//(sin uso del EXIT), la razon junto a las estadisticas
		gP = new GamePrinter(game, 8, 9);
		System.out.println(gP.toString());
		System.out.println(
				"      ________                                          __________ \r\n" + 
				"     /  _____/_____    _____   ____     _______  __ ____\\______   \\\r\n" + 
				"    /   \\  ___\\__  \\  /     \\_/ __ \\   /  _ \\  \\/ // __ \\|       _/\r\n" + 
				"    \\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  (  <_> )   /\\  ___/|    |   \\\r\n" + 
				"     \\______  (____  /__|_|  /\\___  >  \\____/ \\_/  \\___  >____|_  /\r\n" + 
				"            \\/     \\/      \\/     \\/                   \\/       \\/ ");
		if (!command.equals("E")) {
			if (game.getLife() > 0)
				System.out.println("Enhorabuena ganaste!!! Has acabado con todo lo que se ha puesto en medio.\n");
			else
				System.out.println("Vaya... Parece que esta vez esas navecitas han podido contigo.\n");
		}
		System.out.println("Estadisticas:\n"
				+ "Numero de ciclos: " + game.getCycles() + "\nPuntos: " + game.getPoints() + "\nAliens restantes: " + game.getAliens());
	}
	
	//metodos privados que se encargan de distintos segmentos de la partida
	private String board(int life, int cycles, int points, int aliens, boolean shockWave) {
		String shockWaveDisp = "NO";
		if (shockWave) shockWaveDisp = "SI";
		return "Vida: " + life + "\nNumero de ciclos: " + cycles + "\nPuntos: " + points + "\nAliens restantes: " + aliens + "\nshockWave: " + shockWaveDisp;
	}
	private void draw(GamePrinter gP) {
		System.out.println(board(game.getLife(), game.getCycles(), game.getPoints(), game.getAliens(), game.getShockWave()));
		gP = new GamePrinter(game, 8, 9);
		System.out.println(gP.toString());
	}
	private String userCommand(GamePrinter gP) {
		String command;
		do {
			System.out.println("Que deseas hacer?: ");
			command = in.nextLine().toUpperCase();
			String direccion, cantidad;
			switch(command) {
				case("SHOOT"):
				case("S"): game.disparar(); break;
				case("SOCKWAVE"):
				case("W"): game.usarShockwave(); break;
				case("RESET"):
				case("R"): reiniciarJuego(gP); break;
				case("MOVE"):
				case("M"): System.out.println("Hacia que lado (<RIGHT><LEFT>)?: ");
						direccion = in.nextLine().toUpperCase();
						System.out.println("Cuantas casillas (<1><2>)?: ");
						cantidad = in.nextLine().toUpperCase();
						if (direccion.equals("LEFT") && cantidad.equals("2")) game.moverNave("M -2");
						else if (direccion.equals("LEFT") && cantidad.equals("1")) game.moverNave("M -1");
						else if (direccion.equals("RIGHT") && cantidad.equals("1")) game.moverNave("M 1");
						else if (direccion.equals("RIGHT") && cantidad.equals("2")) game.moverNave("M 2");
						else {
							System.out.println("Introduce bien los paramtros\n");
							command = "Repetir"; 
						} break;
				case("LIST"):
				case("L"): System.out.println("[R]egular ship: Points: 5 - Harm: 0 - Shield: 2\n" + 
						"[D]estroyer ship: Points: 10 - Harm: 1 - Shield: 1\n" +
						"[O]vni: Points: 25 - Harm: 0 - Shield: 1\n" +
						"^__^: Harm: 1 - Shield: 3\n"); 
						command = "Repetir"; break;
				case("HELP"):
				case("H"): System.out.println("move <left|right><1|2>: Moves UCM-Ship to the indicated direction.\r\n" + 
						"shoot: UCM-Ship launches a missile.\r\n" + 
						"shockWave: UCM-Ship releases a shock wave.\r\n" + 
						"list: Prints the list of available ships.\r\n" + 
						"reset: Starts a new game.\r\n" + 
						"help: Prints this help message.\r\n" + 
						"exit: Terminates the program.\r\n" + 
						"[none]: Skips one cycle.\n"); 
						command = "Repetir"; break;
				case("EXIT"):
				case("E"): command = "E"; break;
				case("NONE"):
				case("N"):
				case(""): break;
				default: System.out.println("No valido");
						command = "No valido";
			}
		} while(command.equals("Repetir") || command.equals("No valido"));
		return command;
	}
	private void reiniciarJuego(GamePrinter gP) {
		Level level = game.getLevel();
		game = new Game(level);
		System.out.println("*********************************************************************************");
		draw(gP);
		userCommand(gP);
	}
}
