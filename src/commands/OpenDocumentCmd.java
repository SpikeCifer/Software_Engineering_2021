package commands;

import model.Document;

public class OpenDocumentCmd implements ICommand {
	String filename;
	String encryption;
	
	public OpenDocumentCmd(String filename, String encryption) {
		this.filename = filename;
		this.encryption = encryption;
	}
	
	@Override
	public void execute() {
		Document doc = Document.getInstance();
		doc.open(filename, encryption);
	}
}
