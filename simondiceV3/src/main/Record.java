package main;

import main.Engine.tColores;

public class Record {

	final int MAX_JUGADORES = 10;//constante que indica el maximo del array	
	
	private Jugador[] jugadoresPartida;
	
	public int contador;//variable para saber el numero de jugadores en el array
	/**
	 * Constructora que inicializa el tamaño del array y contador a 0
	 */
	public Record () {
		this.jugadoresPartida = new Jugador[MAX_JUGADORES];
		this.contador = 0;
	}
	/**
	 * Metodo que sirve para añadir un jugador al array
	 * @param _player Nombre del jugador introducido
	 */
	public void aniadirJugador(Jugador _player) {
		if (contador < MAX_JUGADORES) {
			this.jugadoresPartida[this.contador] = _player;
			this.contador ++;
		}
	}
	/**
	 * Metodo que ordena el array de manera descendente
	 */
	public void ordenarRanking() {
		for(int i = 0; i < this.contador; i++) {
			for(int j = 0; j < (this.contador - i - 1); j++) {
				if (jugadoresPartida[j].getPuntuacion() < jugadoresPartida[j+1].getPuntuacion()) {
					Jugador save = jugadoresPartida[j];
					this.jugadoresPartida[j] = jugadoresPartida[j+1];
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
		while ( n < contador) {
			System.out.print(jugadoresPartida[n].getNombre());
			System.out.println(" -> " + jugadoresPartida[n].getPuntuacion());
			n++;
		}
	}
	/**
	 * Metodo que enseña los n mejores jugadores que esten en la posición 1º 
	 * y tengan la misma puntuación
	 */
	public void showBestPlayer() {
		int n = 0;
		
		while (jugadoresPartida[0].getPuntuacion() == jugadoresPartida[n].getPuntuacion()) {
			
				System.out.print(jugadoresPartida[n].getNombre());
				System.out.println(" -> " + jugadoresPartida[n].getPuntuacion());
				n++;
		}
	}
}

