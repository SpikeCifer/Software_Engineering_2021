package commands;

public class DeactivateRecordingCommand implements ICommand {
	RecordManager manager = new RecordManager();

	public DeactivateRecordingCommand() {
		
	}
	
	@Override
	public void execute() {
		manager.deactivate();
	}

}
