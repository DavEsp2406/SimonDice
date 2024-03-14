package files;

import java.io.IOException;
import java.util.ArrayList;
import main.Jugador;

public interface ICustomReadFile {
	ArrayList<Jugador> arrayplayers = new ArrayList<Jugador>(); 
	public void CloseReadFile() throws IOException;	
}
