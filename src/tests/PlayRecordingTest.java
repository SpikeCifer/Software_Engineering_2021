package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import commands.RecordManager;
import commands.StartRecordingCommand;
import commands.TransformSpecifiedTextCommand;
import model.Document;
import model.FakeTTSFacade;

public class PlayRecordingTest {

	void test() {
		RecordManager manager = RecordManager.getInstance();
		new StartRecordingCommand().execute();
		
		FakeTTSFacade fake = new FakeTTSFacade();
		Document doc = Document.getInstance();
		doc.setTransformer(fake);
		new TransformSpecifiedTextCommand(1, 3);
		
		manager.replay();
		ArrayList<String> contents = doc.getContents();
		assertEquals(contents.subList(1, 3), fake.getPlayedContents());
	}
}
