package model;

import java.util.List;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 * 
 * @author Stylianos Zappidis
 * Notice: The Transform Procedure takes too much time
 * instead we opted to just print the incoming content.
 *
 */
public class TTSFacade {
	private Voice voice;
	protected float pitch;
	protected float volume;
	protected float rate;
	
	public TTSFacade() {
		System.setProperty("freetts.voices",
				"com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        voice = VoiceManager.getInstance().getVoice("kevin16");
        
        if (voice == null) 
        	System.out.println("Unexpected Error while loading voices");
        voice.allocate();
	}
	
	public void configure(float volume, float pitch, float rate) {
		this.volume = volume;
		this.pitch = pitch;
		this.rate = rate;
		update();
	}
	
	private void update() {
		voice.setVolume(volume);
		voice.setPitch(pitch);
		voice.setRate(rate);
	}
	
	public void playContents(List<String> contents) {
		for (String text : contents) play(text);
	}
	
	public float getPitch() {	return pitch; }
	
	public float getVolume() { return volume;	}
	
	public float getRate() { return rate; }
	
	private void play(String text) {
//		this.voice.speak(text);
		System.out.println(text);
	}
}