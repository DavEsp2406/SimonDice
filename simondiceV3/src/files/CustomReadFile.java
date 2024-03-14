package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CustomReadFile extends FileReader implements ICustomReadFile{

	Scanner sc;
	
	public CustomReadFile (String _path) throws FileNotFoundException{
		super(_path);//hereda de FileReader
		this.sc = new Scanner(this);

	}

	@Override
	public void CloseReadFile() throws IOException {
		// TODO Auto-generated method stub
		
	}	
}
	
