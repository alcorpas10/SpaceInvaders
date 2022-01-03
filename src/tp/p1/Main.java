package tp.p1;

import java.util.Random;

import tp.p1.game.Game;
import tp.p1.game.Level;

public class Main {
	
	public static void main(String[] args) {
		Game game;
		Controller controller;
		//si no hay la cantidad de parametros requerida no se ejecuta el programa
		if (args.length < 3 && args.length > 0) {
			//no importa si los parametros recibidos estan en mayuscula o minuscula
			if (args.length == 1) 
				game = new Game(Level.valueOf(args[0].toUpperCase()), new Random());
			else 
				game = new Game(Level.valueOf(args[0].toUpperCase()), new Random(Integer.parseInt(args[1])));
			controller = new Controller(game);
			controller.run();
		}
	}
}
