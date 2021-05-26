package commands;

public class PlayRecordingCommand implements ICommand {
	RecordManager manager = new RecordManager();

	public PlayRecordingCommand() {
		
	}
	
	@Override
	public void execute() {
		manager.replay();
	}

}
