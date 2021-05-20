package model;

import java.util.ArrayList;

public class Document {
	private static Document instance;
	
	ArrayList<String> contents = new ArrayList<String>() ;
	TTSFacade transformer;
	
	public Document() {
		this.transformer = new TTSFacade();
	}
	
	public static Document getInstance() {
		if (Document.instance == null) {
			instance = new Document();
			return instance;
		}
		return Document.instance;
	}
	
	public void open() {
		
	}
	
	public void edit() {
		
	}
	
	public void save() {
		
	}
	
	public void transform() {
		
		contents.add("hello world");
		transformer.transform(contents);
		
	}
	public void setTransformer(TTSFacade transformer)
	{
		this.transformer = transformer;
	}
	
	public void transformLines(int from, int upto) {
		// Create sub ArrayList of contents based on the two indexes
		// Call transformer
	}
	
	public TTSFacade getTransformer() {
		return this.transformer;
	}
}
