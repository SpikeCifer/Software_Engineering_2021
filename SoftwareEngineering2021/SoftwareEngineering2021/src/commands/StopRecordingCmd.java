package commands;

public class StopRecordingCmd implements ICommand {

	@Override
	public void execute() {
		RecordManager.getInstance().deactivate();
	}
}
