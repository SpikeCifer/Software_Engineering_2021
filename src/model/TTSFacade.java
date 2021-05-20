package model;

import java.util.ArrayList;
import model.FakeTTSFacade;

public class TTSFacade {
	protected int pitch;
	protected int volume;
	protected int rate;
	
	public void transform(ArrayList<String> contents) {
		
	}
	
	public void configure() {
		
	}
	
	public void play(ArrayList <String> text) {
		System.out.println("print");
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void setPitch(int pitch) {
		this.pitch = pitch;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public int getPitch() {
		return pitch;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public int getRate() {
		return rate;
	}
}
