package main;

import java.io.IOException;
import java.util.ArrayList;
import files.CustomReadFile;
import files.CustomWriteFile;
import main.Engine.tColores;

public class Record {

	final int MAX_JUGADORES = 10;//constante que indica el maximo del array	
	
	private Jugador[] jugadoresPartida;
	
	public int contador;//variable para saber el numero de jugadores en el array
	/**
	 * Constructora que inicializa el tamaño del array y contador a 0
	 */
	public Record () {
		this.jugadoresPartida = new Jugador[this.MAX_JUGADORES];
		this.contador = 0;
	}
	/**
	 * Metodo que sirve para añadir un jugador al array
	 * @param _player Nombre del jugador introducido
	 */
	public void addPlayer(Jugador _player) {
		if (this.contador < this.MAX_JUGADORES) {
			this.jugadoresPartida[this.contador] = _player;
			this.contador ++;
		}else {
			this.jugadoresPartida[this.contador - 1] = _player;
		}
	}
	/**
	 * Metodo que ordena el array de manera descendente     this.a[this.cont] = jugador
	 */
	public void ordenarRanking() {
		for(int i = 0; i < this.contador; i++) {
			for(int j = 0; j < (this.contador - i - 1); j++) {
				if (this.jugadoresPartida[j].getPuntuacion() < this.jugadoresPartida[j+1].getPuntuacion()) {
					Jugador save = jugadoresPartida[j];
					this.jugadoresPartida[j] = this.jugadoresPartida[j+1];
					this.jugadoresPartida[j+1] = save;
				}
			}
		}
	}
	/**
	 * Metodo que enseña los n mejores jugadores
	 */
	public void showRanking() {
		int n = 0;
		while ( n < this.contador) {
			System.out.print(this.jugadoresPartida[n].getNombre());
			System.out.println(" -> " + this.jugadoresPartida[n].getPuntuacion());
			n++;
		}
	}
	/**
	 * Metodo que enseña los n mejores jugadores que esten en la posición 1º 
	 * y tengan la misma puntuación
	 */
	public void showBestPlayer() {
		int n = 0;
		
		while (this.jugadoresPartida[0].getPuntuacion() == this.jugadoresPartida[n].getPuntuacion()) {
			
				System.out.print(this.jugadoresPartida[n].getNombre());
				System.out.println(" -> " + this.jugadoresPartida[n].getPuntuacion());
				n++;
		}
	}
	/**
	 * metodo que carga en array los jugadores del fichero
	 * @throws IOException
	 */
	public void cargarRanking() throws IOException {
		CustomReadFile read = new CustomReadFile("./src/data/top.txt");
		ArrayList <Jugador> loadplayer = read.leerjugador();
		
		for(int i = 0; i < loadplayer.size(); i++) {
			Jugador player = loadplayer.get(i);
			this.addPlayer(player);
		}
		read.CloseReadFile();
	}
	/**
	 * Metodo para escribir en el archivo los jugadores del array
	 * @throws IOException
	 */
	public void escribirJugador() throws IOException {
		CustomWriteFile write = new CustomWriteFile("./src/data/top.txt");
		String chain = "";
		
		for(int i = 0; i < this.contador; i++) {
			chain += this.jugadoresPartida[i].getPuntuacion() + " " + this.jugadoresPartida[i].getNombre() + "\n";
		}
		write.writePlayer(chain);
		write.closeWriteFile();
	}
	
}

