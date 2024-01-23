package simondice;

import java.util.Scanner;

import java.util.Random;

public class Engine {

	public enum tColores {
		ROJO, VERDE, AZUL, DORADO
	};

	private int secuenciaActual = 3;
	
	
	final int MAX_COLORES_SEQ = 12;
	
	/**
	 * Array donde se almacenan los colores
	 */
	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
	

	
	
	
	
	/**
	 * metodo donde se ejecuta el juego 
	 */
	public void start() {

		Scanner sc = new Scanner(System.in);

		System.out.println("¡Bienvenido a Simon dice!");
		System.out.println("¿Cuál es tu nombre?");
		
		String name = sc.next();
		Jugador p1 = new Jugador(name);
		p1.setNombre(name);

		
		
		System.out.println("Hola " + p1.getNombre() + 
				", presiona ENTER para empezar a jugar");
		new Scanner(System.in).nextLine();//Linea para detectar ENTER
		
		
		System.out.println("¿Qué deseas hacer " + p1.getNombre() + "?" + "\n");
		
		menu();
		
		int nselect = sc.nextInt();
		
		if(nselect == 0 || nselect == 1 || nselect == 2) {
			
		
			do {
				switch(nselect) {
				
				case 0:
					System.out.println("¡Hasta luego " + p1.getNombre() + "!");
					break;
				case 1:
					System.out.println("Iniciando el juego:" + "\n");
					play();
					break;
				case 2:
					System.out.println("Función aún no está implementado :)");
					break;
				}
			}while(nselect != 0 && nselect != 1 && nselect != 2);	
			
		}else {
			System.out.println("Número inválido");
		}
		
		
		
	}
	
	
	
	
	
	public void play() {
		
		Boolean fallo = false;
		
		Scanner sc = new Scanner(System.in);
		
		int i = 1;
		
		generarSecuencia(4);
		
		do {
			
			System.out.println("Esta es la secuencia " + i );
			i++;
			mostrarSecuencia(secuenciaActual);	
			
			
			
			while(fallo == false ) {
				System.out.println("\n" + "Introduce el caracter del color");
				char cIntroducido = sc.next().charAt(0);
				
				comprobarColor( i, charToColor(cIntroducido));
				
				
			}
			
			
			secuenciaActual ++;
			System.out.println("\n");
			
		}while(fallo == false && secuenciaActual < MAX_COLORES_SEQ);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * metodo para generar el menu
	 */
	public void menu () {
		System.out.println("0 - Salir || 1 - Jugar || 2 - Aún no implementado");
	}
	
	
	
	/**
	 * Metodo que recibe un char como "v" y devuelve el color del enum "Verde"
	 * @param _color representa el caracter introducido por el usuario
	 * @return
	 */
	public tColores charToColor(char _color) {	
		
		char _minuscula = Character.toLowerCase (_color);
		
		tColores tipo = null;
		
		switch (_minuscula) {
		
		case 'r':
			tipo = tColores.ROJO;
			break;
			
		case 'a':
			tipo = tColores.AZUL;
			break;
		case 'v':
			tipo = tColores.VERDE;
			break;
		case 'd':
			tipo = tColores.DORADO;
			break;
		default:
			System.out.println("Introduce un caracter válido");
		}
		
		return tipo;	
	}
	
	
	
	/**
	 * Metodo que recibe un int y devuelve un color. El int recibido representa la posición del
	 * color en el enum
	 * @param _numero representa el número entero
	 */
	tColores intToColor(int _numero) {
		
		tColores num = null;
		
		switch(_numero) {
		
		case 1:
			num = tColores.ROJO;
			break;
		case 2: 
			num = tColores.VERDE;
			break;
		case 3:
			num = tColores.AZUL;
			break;
		case 4: 
			num = tColores.DORADO;
			break;
		}
		
		return num;
	}
	
	
	
	/**
	 * Metodo que genera una secuencia de colores aleatoria y lo mete en el array
	 * @param _numColores numero de colores que tiene el enum
	 */
	public void generarSecuencia (int _numColores) {
		for(int i = 0; i < this.secuenciaColores.length; i++) {
			this.secuenciaColores[i] = intToColor((int) (Math.random()*_numColores+1));
		}
	}
	
	
	/**
	 * Metodo que muestra la secuencia actual por pantalla
	 * @param _numero numero de la secuencia actual
	 */
	public void mostrarSecuencia (int _numero) {
		for(int i = 0; i < _numero; i++) {
			System.out.print(mostrarColor(secuenciaColores[i]) + " ");
		}
	}
	
	
	
	/**
	 * metodo que comprueba si el color introducido por el usuario es correcto o no
	 * @param _index indice que ocupa el color dentro del array secuenciaColores
	 * @param _color color introducido por el usuario
	 * @return
	 */
	public boolean comprobarColor (int _index, tColores _color) {
		
		Boolean check = false;
		
		if (_color != secuenciaColores[_index] ) {
			check = true;
		}
				
		return check;
	}
	
	
	
	
	/**
	 * metodo que cambia el color de tColores a un string S
	 * @param _color color que hay dentro del array tColores
	 * @return
	 */
	public String mostrarColor (tColores _color) {
		
		String colorString = null;
		
		switch (_color) {
		
			case ROJO: 
				colorString = "Rojo";
				break;
			case AZUL:
				colorString = "Azul";
				break;
			case VERDE:
				colorString = "Verde";
				break;
			case DORADO:
				colorString = "Dorado";
				break;
		}
		
		return colorString;
	}
}
