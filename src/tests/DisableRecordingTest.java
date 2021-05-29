package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import commands.RecordManager;
import commands.StartRecordingCommand;
import commands.StopRecordingCmd;

public class DisableRecordingTest {

	@Test
	public void test() {
		new StartRecordingCommand().execute();
		new StopRecordingCmd().execute();
		assertFalse(RecordManager.getInstance().getRecordingStatus());
	}

}
