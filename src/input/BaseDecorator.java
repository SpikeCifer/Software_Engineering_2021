package input;

public class BaseDecorator implements IInputSystem {
	protected IInputSystem reader;
	
	public BaseDecorator(IInputSystem baseReader) {
		this.reader = baseReader;
	}
	
	public void read() {
		// TODO Auto-generated method stub
		
	}

}
