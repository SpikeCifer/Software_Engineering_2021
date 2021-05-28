package model;

import java.io.File;
import java.util.List;
import java.util.Locale;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;



public class TTSFacade {
	
	protected int pitch;
	protected int volume;
	protected int rate;
	
	private Voice voice;
	public TTSFacade() {
		System.setProperty("freetts.voices",
                "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        this.voice = VoiceManager.getInstance().getVoice("kevin16");
        if (this.voice == null) System.out.println("Giati?");
        this.voice.allocate();
	}
	public void configure() {}
	
	public void playContents(List<String> contents) {
		System.out.println("print");
	}
	
	public void setVolume(int volume) { this.voice.setVolume((float) volume); }
	
	public void setPitch(int pitch) { this.voice.setPitch((float) pitch); }
	
	public void setRate(int rate) {	this.voice.setRate((float) rate); }
	
	public int getPitch() {	return pitch; }
	
	public int getVolume() { return volume;	}
	
	public int getRate() { return rate; }
	
	public void play(String text) {
		this.voice.speak(text);
	}
}
