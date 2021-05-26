package commands;

import model.Document;

public class SaveDocumentCommand implements ICommand {
	private String filename;
	private String encryption;
	
	public SaveDocumentCommand(String filename, String encryption) {
		this.filename = filename;
		this.encryption = encryption;
	}
	
	@Override
	public void execute() {
		Document doc = Document.getInstance();
		doc.save(filename, encryption);
	}
}
