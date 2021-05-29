package output;

import java.util.ArrayList;

public class EncodeDecorator extends WriteDecorator {
	private IEncodeStrategy encodeStrategy;
	
	public EncodeDecorator(IOutputSystem baseWriter) {
		super(baseWriter);
	}
	
	public void setEncodeStrategy(IEncodeStrategy encodeStrategy) {
		this.encodeStrategy = encodeStrategy;
	}
	
	public void write(ArrayList<String> docContents) {
		
		writer.write(encodeStrategy.encode(docContents)); // First we encode the contents, then we write it
	}
}
