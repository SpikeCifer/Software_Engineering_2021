package input;

public class DecodeDecorator extends BaseDecorator {
	IDecodeStrategy decodeStrategy;
	
	public DecodeDecorator(IInputSystem baseReader) {
		super(baseReader);
		// TODO Auto-generated constructor stub
	}

	public void setDecodeStrategy(IDecodeStrategy decodeStrategy) {
		this.decodeStrategy = decodeStrategy;
	}
	
	@Override
	public void read() {
		decodeStrategy.decode();
	}
		
}
