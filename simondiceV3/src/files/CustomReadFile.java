package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import main.Jugador;

public class CustomReadFile extends FileReader implements ICustomReadFile{
	/**
	 * Atributos
	 */
	public ArrayList<Jugador> alplayers = new ArrayList<Jugador>();
	public Scanner sc;
	/**
	 * Constructora
	 * @param _path ruta del fichero
	 * @throws FileNotFoundException
	 */
	public CustomReadFile (String _path) throws FileNotFoundException{
		super(_path);
		this.sc = new Scanner(this);
	}
	/**
	 * Metodo para cerrar un objeto instanciado
	 */
	public void CloseReadFile() throws IOException {
		this.close();
	}
	/**
	 * Metodo para leer los jugadores en el archivo
	 */
	public ArrayList<Jugador> leerjugador() {
		while(this.sc.hasNextLine()) {
			 int points = this.sc.nextInt();
			 String name = this.sc.next();
			 Jugador player = new Jugador(name);
			 player.setPuntuacion(points);
			 this.alplayers.add(player);
			 this.sc.nextLine();
		}
		return this.alplayers;
	}	
}
	
