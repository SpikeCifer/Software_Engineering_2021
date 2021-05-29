package model;

import java.util.ArrayList;

import input.IInputSystem;
import input.InputSystemFactory;
import output.IOutputSystem;
import output.OutputSystemFactory;

/** 
 * Singleton Pattern was used, so that the contents of the document
 * are not lost and can be used by all the classes that need them.
 **/
public class Document {
	private static Document instance;
	private ArrayList<String> contents = new ArrayList<String> ();
	private TTSFacade transformer;
	
	private Document() {
		contents = new ArrayList<String>();
		transformer = new TTSFacade();
	}
	
	public static Document getInstance() { 
		if (instance == null) 
			instance = new Document();
		return instance;	
	}
	
	// IO System Commands
	public void open(String filename, String encryption) {
		IInputSystem reader = new InputSystemFactory().createInputSystem(filename, encryption);
		contents = reader.read();
	}
	
	
	public void edit(ArrayList<String> newContents) { contents = newContents; }
	
	
	public void save(String filename, String encryption) {
		IOutputSystem writer = new OutputSystemFactory().createOutputSystem(filename, encryption);
		writer.write(contents);
	}
	
	
	public ArrayList<String> getContents() { return contents; }
	
	
	// Transform Commands
	public TTSFacade getTransformer() { return transformer;	}
	
	public void setTransformer(TTSFacade transformer) { this.transformer = transformer; }
	
	public void transformContents() { transformer.playContents(contents); }
	
	public void transformSpecificContents(int from, int upto) {
		// TODO: Change this back to its appointed test
		for (int i = 0; i < 10; i++) contents.add("This is line"+ i);
		transformer.playContents(contents.subList(from, upto));
	}

}
