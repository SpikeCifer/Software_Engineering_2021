package commands;

public class PlayRecordingCmd implements ICommand {
	
	@Override
	public void execute() {
		RecordManager manager = RecordManager.getInstance();
		manager.replay();
	}

}
