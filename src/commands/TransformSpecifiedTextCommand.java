package commands;

import model.Document;

public class TransformSpecifiedTextCommand implements ICommand {
	private int startLine;
	private int endLine;
	
	public TransformSpecifiedTextCommand(int startLine, int endLine) {
		this.startLine = startLine;
		this.endLine = endLine;
	}
	@Override
	public void execute() {
		Document doc = Document.getInstance();
		doc.transformSpecificContents(startLine, endLine);
	}

}
