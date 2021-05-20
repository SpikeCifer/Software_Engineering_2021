package commands;

import java.util.ArrayList;

import model.Document;

public class EditDocumentCommand implements ICommand {

	private ArrayList<String> additionalContent;
	
	public EditDocumentCommand(ArrayList<String> newContent) {
		additionalContent = newContent;
	}
	
	@Override
	public void execute() {
		Document doc = Document.getInstance();
		doc.edit(additionalContent);
	}
	
}
