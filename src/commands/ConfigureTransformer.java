package commands;

import model.Document;
import model.TTSFacade;

public class ConfigureTransformer implements ICommand {
	private int pitch;
	private int rate;
	private int volume;
	
	public ConfigureTransformer(int pitch, int volume, int rate) {
		this.pitch = pitch;
		this.rate = rate;
		this.volume = volume;
	}
	
	@Override
	public void execute() {
		
		Document doc = Document.getInstance();
		TTSFacade transform = doc.getTransformer();
		transform.setPitch(pitch);
		transform.setRate(rate);
		transform.setVolume(volume);
		doc.setTransformer(transform);
	}

}
