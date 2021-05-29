package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.RecordManager;
import commands.StartRecordingCommand;

class TestActivateManager {

	@Test
	void test() {
		new StartRecordingCommand().execute();
		assertTrue(RecordManager.getInstance().getRecordingStatus());
	}

}
