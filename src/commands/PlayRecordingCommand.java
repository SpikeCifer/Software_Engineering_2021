package commands;

public class PlayRecordingCommand implements ICommand {
	
	@Override
	public void execute() {
		RecordManager manager = RecordManager.getInstance();
		manager.replay();
	}

}
