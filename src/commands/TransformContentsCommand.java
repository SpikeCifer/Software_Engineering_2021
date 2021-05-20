package commands;

import model.Document;

public class TransformContentsCommand implements ICommand {
	
	@Override
	public void execute() {
		Document doc = Document.getInstance();
		doc.transformContents();	
	}
}
