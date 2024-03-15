package files;

import java.io.IOException;
/**
 * Interfaz que contiene el metodo de escribir jugador y el metodo close
 */
public interface ICustomWriteFile {
	public void closeWriteFile() throws IOException;
	public void writePlayer(String _cadena) throws IOException;
}


