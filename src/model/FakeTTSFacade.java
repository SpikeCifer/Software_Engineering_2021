package model;

import java.util.List;

public class FakeTTSFacade extends TTSFacade {
	
	private List <String> playedcontents;
	
	@Override
	public void playContents(List<String> contents) {
		playedcontents = contents;
		super.playContents(contents);
	}
	
	public List <String> getPlayedContents() {	return playedcontents; }
}
