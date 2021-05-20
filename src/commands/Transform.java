package commands;

import model.Document;

public class Transform implements ICommand {

	Document doc;
	public Transform(Document doc) {
		
		this.doc = doc;
		
	}
	@Override
	public void execute() {
		
		//this.doc.transform();
		Document doc = Document.getInstance();
		doc.transform();
		
	}

}
