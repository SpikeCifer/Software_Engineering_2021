package model;

import java.util.ArrayList;

public class FakeTTSFacade extends TTSFacade {
	
	private ArrayList <String> playedcontents;
	
	@Override
	public void playContents(ArrayList <String> text) {
		playedcontents = text;
		super.playContents(text);
	}
	
	public ArrayList <String> getPlayedContents() {	return playedcontents; }
}
