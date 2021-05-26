package commands;

public class StopRecordingCommand implements ICommand {
	RecordManager manager = new RecordManager();

	public StopRecordingCommand() {
		
	}
	
	@Override
	public void execute() {
		manager.deactivate();
	}

}
