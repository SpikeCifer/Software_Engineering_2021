package commands;

import model.Document;

public class TransformContentsCommand implements ICommand {
	public TransformContentsCommand() {
		RecordManager manager = RecordManager.getInstance();
		manager.addCommand(this);
	}
	
	@Override
	public void execute() {
		Document doc = Document.getInstance();
		doc.transformContents();	
	}
}
