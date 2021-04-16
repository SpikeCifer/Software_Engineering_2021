package commands;

public class OpenDocument implements ICommand {
	String filename;
	String encryption;
	
	public OpenDocument(String filename, String encryption) {
		this.filename = filename;
		this.encryption = encryption;
	}
	
	@Override
	public void execute() {
		
	}

}
