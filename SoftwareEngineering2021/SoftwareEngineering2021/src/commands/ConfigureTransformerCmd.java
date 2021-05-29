package commands;

import model.Document;
import model.TTSFacade;

public class ConfigureTransformerCmd implements ICommand {
	private float pitch;
	private float rate;
	private float volume;
	
	public ConfigureTransformerCmd(float pitch, float volume, float rate) {
		this.pitch = pitch;
		this.rate = rate;
		this.volume = volume;
	}
	
	@Override
	public void execute() {
		Document doc = Document.getInstance();
		TTSFacade transformer = doc.getTransformer();
		transformer.configure(volume, pitch, rate);
		doc.setTransformer(transformer);
	}

}
