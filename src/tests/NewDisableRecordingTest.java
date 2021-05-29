package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.RecordManager;
import commands.StartRecordingCommand;
import commands.StopRecordingCmd;

class NewDisableRecordingTest {

	@Test
	void test() {
		new StartRecordingCommand().execute();
		new StopRecordingCmd().execute();
		assertFalse(RecordManager.getInstance().getRecordingStatus());
	}

}
