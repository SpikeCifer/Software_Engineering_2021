package model;

import java.util.List;

/**
 * @author Avgoustinos Zigos
 * 
 * This class was used for the Transform Unit Tests
 */
public class FakeTTSFacade extends TTSFacade {
	
	private List <String> playedcontents;
	
	@Override
	public void playContents(List<String> contents) {
		playedcontents = contents;
		super.playContents(contents);
	}
	
	public List <String> getPlayedContents() {	return playedcontents; }
}
