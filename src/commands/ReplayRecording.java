package commands;

public class ReplayRecording implements ICommand {
	RecordManager manager = new RecordManager();

	public ReplayRecording() {
		
	}
	
	@Override
	public void execute() {
		manager.replay();
	}

}
