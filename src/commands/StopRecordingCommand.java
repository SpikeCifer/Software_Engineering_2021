package commands;

public class StopRecordingCommand implements ICommand {

	@Override
	public void execute() {
		RecordManager.getInstance().deactivate();
	}
}
