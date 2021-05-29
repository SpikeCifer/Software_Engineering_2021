package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import commands.RecordManager;
import commands.StartRecordingCommand;
import commands.TransformSpecifiedTextCmd;
import model.Document;
import model.FakeTTSFacade;

class PlayRecordingTest {

	@Test
	void test() {
		RecordManager manager = RecordManager.getInstance();
		new StartRecordingCommand().execute();
		
		FakeTTSFacade fake = new FakeTTSFacade();
		Document doc = Document.getInstance();
		doc.setTransformer(fake);
		new TransformSpecifiedTextCmd(1, 3);
		
		manager.replay();
		ArrayList<String> contents = doc.getContents();
		assertEquals(contents.subList(1, 3), fake.getPlayedContents());
	}

}
