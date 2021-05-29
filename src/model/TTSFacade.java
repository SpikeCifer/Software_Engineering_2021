package model;

import java.util.List;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class TTSFacade {
	// TODO: This is taking far too long
	private Voice voice;
	protected int pitch;
	protected int volume;
	protected int rate;
	
	public TTSFacade() {
		System.setProperty("freetts.voices",
				"com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        voice = VoiceManager.getInstance().getVoice("kevin16");
        
        if (voice == null) 
        	System.out.println("Unexpected Error while loading voices");
        voice.allocate();
	}
	public void configure() {}
	
	public void playContents(List<String> contents) {
		for (String text : contents)
			play(text);
	}
	
	public void setVolume(int volume) { this.voice.setVolume((float) volume); }
	
	public void setPitch(int pitch) { this.voice.setPitch((float) pitch); }
	
	public void setRate(int rate) {	this.voice.setRate((float) rate); }
	
	public int getPitch() {	return pitch; }
	
	public int getVolume() { return volume;	}
	
	public int getRate() { return rate; }
	
	private void play(String text) {
//		this.voice.speak(text);
		System.out.println(text);
	}
}