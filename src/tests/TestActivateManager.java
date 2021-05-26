package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.StartRecordingCommand;
import commands.RecordManager;

class TestActivateManager {

	@Test
	void test() {
		RecordManager manager = new RecordManager();
		new StartRecordingCommand(manager).execute();
		assertTrue(manager.getRecordingStatus());
	}

}
