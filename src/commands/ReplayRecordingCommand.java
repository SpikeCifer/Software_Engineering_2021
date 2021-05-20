package commands;

public class ReplayRecordingCommand implements ICommand {
	RecordManager manager = new RecordManager();

	public ReplayRecordingCommand() {
		
	}
	
	@Override
	public void execute() {
		manager.replay();
	}

}
