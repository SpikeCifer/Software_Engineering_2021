package input;

import java.util.ArrayList;

public class DecodeDecorator extends BaseReadDecorator {
	private IDecodeStrategy decodeStrategy;
	
	public DecodeDecorator(IInputSystem baseReader) {
		super(baseReader);
	}

	public void setDecodeStrategy(IDecodeStrategy decodeStrategy) {
		this.decodeStrategy = decodeStrategy;
	}
	
	@Override
	public ArrayList<String> read() {
		return decodeStrategy.decode(reader.read());
	}		
}
