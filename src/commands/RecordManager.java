package commands;

import java.util.ArrayList;

public class RecordManager {
	private static RecordManager instance;
	private ArrayList<ICommand> commandsList;
	private boolean isActive = false;
	
	private RecordManager() { commandsList = new ArrayList<ICommand>(); }
	
	public static RecordManager getInstance() {
		if (instance == null) 
			instance = new RecordManager();
		return instance;
	}
	
	public void activate() { isActive = true; }
	
	public void replay() {
		for (ICommand cmd : commandsList)
			cmd.execute();
	}
	
	public void deactivate() {
		isActive = false;
		// If we wish to clear the list: commandsList.clear();
	}
	
	public void addCommand(ICommand cmd) {
		if(isActive) 
			commandsList.add(cmd);
	}	
	
	public boolean getRecordingStatus() {
		return isActive;
	}
	
	// RecordManager manager =  RecordManager.getInstance()
	// manager.addCommand(TransformSpecifiedTextCommand or TransformContentsCommand)
}
