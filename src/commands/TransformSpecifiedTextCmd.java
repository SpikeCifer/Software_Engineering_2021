package commands;

import model.Document;

public class TransformSpecifiedTextCmd implements ICommand {
	private int startLine;
	private int endLine;
	
	public TransformSpecifiedTextCmd(int startLine, int endLine) {
		this.startLine = startLine;
		this.endLine = endLine;
		
		RecordManager manager = RecordManager.getInstance();
		manager.addCommand(this);
	}
	
	@Override
	public void execute() {
		Document doc = Document.getInstance();
		doc.transformSpecificContents(startLine, endLine);
	}

}
