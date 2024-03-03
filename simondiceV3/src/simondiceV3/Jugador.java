package simondiceV3;

public class Jugador {

	public String nombre;
	public int puntuacion;
	/**
	 * Constructora que instancia el nombre y la puntuación
	 * @param nombre
	 */
	public Jugador (String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
	}
	/**
	 * Metodo para devolver el nombre del jugador
	 * @return
	 */
	public String getNombre() {
		return this.nombre;
	}
	/**
	 * Metodo para asignar el nombre al jugador
	 * @param _nombre
	 */
	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}
	/**
	 * Método para devolver la puntuación
	 * @return
	 */
	public int getPuntuacion() {
		return this.puntuacion;
	}
	/**
	 * Método para asignar la puntuación del jugador
	 * @param _puntuacion
	 */
	public void setPuntuacion(int _puntuacion) {
		this.puntuacion = _puntuacion;
	}

	
}

