package output;

import java.util.ArrayList;

public class FileWriter implements IOutputSystem {
	private IWriteStrategy writeStrategy;
	private String filename; // The file where we save the contents
	
	public FileWriter(String filename) {
		this.filename = filename;
	}
	
	public void setWriteStrategy(IWriteStrategy writeStrategy) {
		this.writeStrategy = writeStrategy;
	}
	
	public void write(ArrayList<String> contents) {
		writeStrategy.write(filename, contents);
	}
}
