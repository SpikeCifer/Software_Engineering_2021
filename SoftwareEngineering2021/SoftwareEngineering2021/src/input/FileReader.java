package input;

import java.util.ArrayList;

public class FileReader implements IInputSystem {
	private IReadStrategy readStrategy;
	private String filename;
	
	public FileReader(String filename) {
		this.filename = filename;
	}
	
	public void setReadStrategy(IReadStrategy readStrategy) {
		this.readStrategy = readStrategy;
	}
	
	public ArrayList<String> read() {
		return readStrategy.read(filename);
	}
}
