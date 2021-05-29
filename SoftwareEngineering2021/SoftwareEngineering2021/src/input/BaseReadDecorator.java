package input;
/* This class was created for future use if we
 * wish to add functionality to the input system
 * (e.g. translating to another language)
 */

import java.util.ArrayList;

public class BaseReadDecorator implements IInputSystem {
	protected IInputSystem reader;
	
	public BaseReadDecorator(IInputSystem baseReader) {
		this.reader = baseReader;
	}
	
	public ArrayList<String> read() {return null;}
}
