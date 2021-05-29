package commands;

public class StartRecordingCommand implements ICommand {
	
	@Override
	public void execute() {
		RecordManager.getInstance().activate();
	}
}
