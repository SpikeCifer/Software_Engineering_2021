package commands;

public class ActivateRecording implements ICommand {
	RecordManager manager = new RecordManager();

	public ActivateRecording() {
		
	}
	
	@Override
	public void execute() {
		manager.activate();

	}
}
