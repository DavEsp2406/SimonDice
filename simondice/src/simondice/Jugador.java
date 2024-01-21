package simondice;

public class Jugador {

	public String nombre;
	public int puntuacion;
	
	public Jugador (String nombre) {
		this.nombre = nombre;
	}
	
	public Jugador (int puntuacion) {
		this.puntuacion = 0;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}
	
	public int getPuntuacion() {
		return this.puntuacion;
	}
	
	public void setPuntuacion(int _puntuacion) {
		this.puntuacion = _puntuacion;
	}
	
}
