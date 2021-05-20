package model;

import java.util.ArrayList;

public class FakeTTSFacade extends TTSFacade {
	
	private ArrayList <String> playedcontents;
	
	@Override
	public void play(ArrayList <String> text) {
		
		playedcontents = text;
		super.play(text);
		
		
	}
	public ArrayList <String> getPlayedcontents() 
	{	
		return playedcontents;
	}
}
