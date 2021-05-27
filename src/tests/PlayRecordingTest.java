package tests;

import commands.RecordManager;
import commands.StartRecordingCommand;
import commands.TransformSpecifiedTextCommand;
import model.FakeTTSFacade;

public class PlayRecordingTest {

	void test() {
		RecordManager manager = RecordManager.getInstance();
		StartRecordingCommand recordCmd = new StartRecordingCommand(manager);
		recordCmd.execute();
		
		FakeTTSFacade fake = new FakeTTSFacade();
		TransformSpecifiedTextCommand transformCmd = new TransformSpecifiedTextCommand(1, 2);
		transformCmd.execute();
		
	}
}
