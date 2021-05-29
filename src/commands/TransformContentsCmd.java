package commands;

import model.Document;

public class TransformContentsCmd implements ICommand {
	public TransformContentsCmd() {
		RecordManager manager = RecordManager.getInstance();
		manager.addCommand(this);
	}
	
	@Override
	public void execute() {
		Document doc = Document.getInstance();
		doc.transformContents();	
	}
}
