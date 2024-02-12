package simondicev2;

import java.util.Scanner;

import java.util.Random;

public class Engine {

	public enum tColores {
		ROJO, VERDE, AZUL, DORADO, BLANCO, MARRON, NARANJA
	}
	
	public enum tModo {
		SALIR, FACIL, DIFICIL
	}
	
	final int MAX_COLORES_SEQ = 15;
	/**
	 * Array donde se almacenan los colores
	 */
	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
	
	private int secuenciaActual = 3;
	
	final int MAX_COLORES_GENERADOS = 7;
	
	private int nJugadas = 0;
	
	private int ayudas = 3;
	
	Jugador p1 = new Jugador(null);
	
	/**
	 * metodo donde se ejecuta el inicio y menu del juego
	 */
	public void start() {

		Scanner sc = new Scanner(System.in);

		if(nJugadas == 0) {
			
		System.out.println("¡Bienvenido a Simon dice!");
		System.out.println("¿Cuál es tu nombre?");
		
		String name = sc.next();
		
		p1.setNombre(name);

		nJugadas ++;
		
		System.out.println("Hola " + p1.getNombre() + 
				", presiona ENTER para empezar a jugar");
		new Scanner(System.in).nextLine();//Linea para detectar ENTER
		
		
		System.out.println("¿Qué deseas hacer " + p1.getNombre() + "?" + "\n");
		
		}
		
		menu();
		
		int nselect = sc.nextInt();
		
		if(nselect >= 0 || nselect < 3) {
			do {
				switch(nselect) {
				
				case 0:
					System.out.println("¡Hasta luego!");
					break;
				case 1:
					System.out.println("Iniciando el modo fácil" + "\n");
					play(tModo.FACIL);
					break;
				case 2:
					System.out.println("Iniciando el modo difícil " + "\n");
					play(tModo.DIFICIL);
					break;
				}
			}while(nselect != 0 && nselect != 1 && nselect != 2);	
			
		}else {
			System.out.println("Número inválido");
		}
	}
	
	/**
	 * Metodo que ejecuta el juego 
	 */
	public void play(tModo _modo) {
		Boolean fallo = false;
		
		Scanner sc = new Scanner(System.in);
		
		p1.setPuntuacion(0);
		
		ayudas = 3;
		
		int i = 1;//Variable que indica en que secuencia estás
		
		if(_modo == tModo.FACIL) {
			generarSecuencia(MAX_COLORES_GENERADOS - 3);
		}else if(_modo == tModo.DIFICIL){
			generarSecuencia(MAX_COLORES_GENERADOS);
		}
		
		secuenciaActual = 3;//Variable que indica la cantidad de colores que aparecerán en la secuencia
		
		do {
			System.out.println("Esta es la secuencia " + i + ". Pulsa ENTER cuando estes listo." + "\n");
			mostrarSecuencia(secuenciaActual);	
			new Scanner(System.in).nextLine();
			i++;
			
			for (int j = 0; j <= 50; j++ )
				System.out.println();
			
			int nColores = 1;//Variable que indica el número del color a introducir
			
			int posColorArray = 0;//Posición que ocupa el color a introducir en el array
			
			while(fallo == false && nColores <= secuenciaActual )  {
				
				System.out.println("\n" + "Introduce el caracter del color nº" + nColores + " (Pulsa 'X' para la ayuda)");
				nColores++;
				
				char cIntroducido = sc.next().charAt(0);
				
				if(String.valueOf(cIntroducido).matches("^[a-zA-Z]$")) {
					
					if (cIntroducido == 'x' || cIntroducido == 'X') {
						usarAyuda(posColorArray);
						if(_modo == tModo.FACIL) {
							p1.restarPuntuacion(8);
						}else if(_modo == tModo.DIFICIL){
							p1.restarPuntuacion(16);
						}
						cIntroducido = sc.next().charAt(0);
					}
					if (comprobarColor(posColorArray, charToColor(cIntroducido)) == false) {
						posColorArray++;
						System.out.println("¡Correcto!");
						
						if(_modo == tModo.FACIL) {
							p1.sumarPuntuacion(2);
						}else if(_modo == tModo.DIFICIL){
							p1.sumarPuntuacion(4);
						}
					}else {
						fallo = true;
						System.out.println("¡Fallaste!"  + "\n");
						if(p1.getPuntuacion() < 0) {
							p1.setPuntuacion(0);
						}
						System.out.println("Tus puntos son " + p1.getPuntuacion());
						start();
					}
				}else {
					System.out.println("Error, introduce un caracter válido." + "\n");
					if(p1.getPuntuacion() < 0) {
						p1.setPuntuacion(0);
					}
					System.out.println("Tus puntos son " + p1.getPuntuacion());
					start();
					fallo = true;
				}
				
			}
			
			if(_modo == tModo.FACIL) {
				p1.sumarPuntuacion(5);
			}else if(_modo == tModo.DIFICIL){
				p1.sumarPuntuacion(10);
			}
			
			secuenciaActual ++;
			System.out.println("\n");
			
			if(nColores > MAX_COLORES_SEQ) {
				System.out.println("¡Ganaste!" + "\n" + "\n" + "Volviendo al inicio" + "\n" +"\n" );
				if(_modo == tModo.FACIL) {
					p1.sumarPuntuacion(40);
				}else if(_modo == tModo.DIFICIL){
					p1.sumarPuntuacion(80);
				}
				if(p1.getPuntuacion() < 0) {
					p1.setPuntuacion(0);
				}
				System.out.println("Tus puntos son " + p1.getPuntuacion());
				start();
			}
			
		}while(fallo == false && secuenciaActual <= MAX_COLORES_SEQ);
	}
	/**
	 * Metodo para mostrar las ayudas
	 * @param _index parametro que muestra el color i-esimo que se quiere mostrar
	 * @return
	 */
	boolean usarAyuda (int _index) {
		if(ayudas > 0) {
			System.out.println("El color que deseas saber es: " + mostrarColor(secuenciaColores[_index]));
			System.out.println("Te quedan " + (ayudas - 1) + " ayudas restantes");
			ayudas--;
			return true;
		}else {
			System.out.println("Ya no te quedan más ayudas disponibles");
			return false;
		}
	}
	/**
	 * metodo para generar el menu
	 */
	public void menu () {
		System.out.println("0 - Salir || 1 - Jugar en modo fácil || 2 - Jugar en modo dificil");
	}
	/**
	 * Metodo que recibe un char como "v" y devuelve el color del enum "Verde"
	 * @param _color representa el caracter introducido por el usuario
	 * @return retorna un color del enum
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
		case 'b':
			tipo = tColores.BLANCO;
			break;
		case 'm':
			tipo = tColores.MARRON;
			break;
		case 'n':
			tipo = tColores.NARANJA;
			break;
		}
		
		return tipo;	
	}
	/**
	 * Metodo que recibe un int y devuelve un color. El int recibido representa la posición del
	 * color en el enum
	 * @param _numero representa el número entero
	 * @return retorna un color del enum
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
		case 5:
			num = tColores.BLANCO;
			break;
		case 6:
			num = tColores.MARRON;
			break;
		case 7:
			num = tColores.NARANJA;
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
	 * @return retorna falso o verdadero dependiendo del si se cumple el if
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
	 * @return devuelve un string
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
			case BLANCO:
				colorString = "Blanco";
				break;
			case MARRON:
				colorString = "Marrón";
				break;
			case NARANJA:
				colorString = "Naranja";
				break;
		}
		return colorString;
	}
}
