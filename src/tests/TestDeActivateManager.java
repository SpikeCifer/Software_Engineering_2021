package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.RecordManager;

class TestDeActivateManager {

	@Test
	void test() {
		RecordManager manager = new RecordManager();
		new ActivateRecordingCommand (manager).execute();
		new DeactivateRecordingCommand (manager).execute();
		assertFalse(manager.getRecordingStatus());
	}

}
