package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.StartRecordingCommand;
import commands.RecordManager;

class EnableRecordingTest {

	@Test
	void test() {
		new StartRecordingCommand().execute();
		assertTrue(RecordManager.getInstance().getRecordingStatus());
	}

}
