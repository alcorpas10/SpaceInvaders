package tp.p1.classes;

public class Main {
	
	public static void main(String[] args) {
		Game game;
		Controller controller;
		//si no hay la cantidad de parametros requerida no se ejecuta el programa
		if (args.length < 3 && args.length > 0) {
			//no importa si los parametros recibidos estan en mayuscula o minuscula
			if (args.length == 1) 
				game = new Game(Level.valueOf(args[0].toUpperCase()));
			else 
				game = new Game(Level.valueOf(args[0].toUpperCase()), Integer.parseInt(args[1]));
			controller = new Controller(game);
			controller.run();
		}
	}
}
