package model;

import java.util.ArrayList;

public class Document {
	private static Document instance;
	
	ArrayList<String> contents;
	TTSFacade transformer;
	
	public Document() {
		
	}
	
	public static Document getInstance() {
		if (Document.instance == null)
			return new Document();
		return Document.instance;
	}
	
	public void open() {
		
	}
	
	public void edit() {
		
	}
	
	public void save() {
		
	}
	
	public void transfrom() {
		transformer.transform(contents);
	}
	
	public void transformLines(int from, int upto) {
		// Create sub ArrayList of contents based on the two indexes
		// Call transformer
	}
}
