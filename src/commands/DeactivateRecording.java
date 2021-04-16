package commands;

public class DeactivateRecording implements ICommand {
	RecordManager manager = new RecordManager();

	public DeactivateRecording() {
		
	}
	
	@Override
	public void execute() {
		manager.deactivate();
	}

}
