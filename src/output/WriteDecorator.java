package output;

import java.util.ArrayList;

/**
 * 
 * @author Stylianos Zappidis 2971
 *
 * This is the base decorator AKA the super class
 */
public class WriteDecorator implements IOutputSystem {
	protected IOutputSystem writer;
	
	public WriteDecorator(IOutputSystem baseWriter) {
		this.writer = baseWriter;
	}
	
	public ArrayList<String> read() {return null;}
	
	@Override
	public void write(ArrayList<String> contents) {}
}
