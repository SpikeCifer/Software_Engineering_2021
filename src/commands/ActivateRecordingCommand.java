package commands;

public class ActivateRecordingCommand implements ICommand {
	RecordManager manager = new RecordManager();

	public ActivateRecordingCommand() {}
	
	@Override
	public void execute() {
		manager.activate();
	}
}
