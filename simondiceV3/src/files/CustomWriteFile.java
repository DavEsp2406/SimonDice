package files;

import java.io.FileWriter;
import java.io.IOException;

public class CustomWriteFile extends FileWriter implements ICustomWriteFile {

	
	
	public CustomWriteFile (String _path) throws IOException{
		super(_path);//hereda de FileReader

	}

	@Override
	public void CloseWriteFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escribirJugador(String _jugador) {
		// TODO Auto-generated method stub
		
	}
}