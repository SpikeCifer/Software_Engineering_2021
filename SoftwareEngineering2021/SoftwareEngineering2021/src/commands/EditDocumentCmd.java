package commands;

import java.util.ArrayList;

import model.Document;

public class EditDocumentCmd implements ICommand {

	private ArrayList<String> additionalContent;
	
	public EditDocumentCmd(ArrayList<String> newContent) {
		additionalContent = newContent;
	}
	
	@Override
	public void execute() {
		Document doc = Document.getInstance();
		doc.edit(additionalContent);
	}
	
}
