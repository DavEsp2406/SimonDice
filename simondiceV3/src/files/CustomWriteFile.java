package files;

import java.io.FileWriter;
import java.io.IOException;

public class CustomWriteFile extends FileWriter implements ICustomWriteFile {
	/**
	 * Constructora
	 * @param _path ruta del fichero
	 * @throws IOException
	 */
	public CustomWriteFile (String _path) throws IOException{
		super(_path);//hereda de FileReader
	}	
	/**
	 * Metodo para cerrar el objeto instanciado
	 */
	public void closeWriteFile() throws IOException {
		this.close();	
	}
	/**
	 * Metodo para escribir en fichero
	 */
	public void writePlayer (String _cadena) throws IOException {
		this.write(_cadena);
	}
}