package files;

import java.io.IOException;
import java.util.ArrayList;
import main.Jugador;
/**
 * Interfaz que contiene un arraylist y el metodo close
 */
public interface ICustomReadFile {
	public void CloseReadFile() throws IOException;
	public ArrayList<Jugador> leerjugador(); 
}
