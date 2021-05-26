package commands;

public class StartRecordingCommand implements ICommand {
	RecordManager manager;
	
	public StartRecordingCommand(RecordManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void execute() {
		manager.activate();
	}
}
