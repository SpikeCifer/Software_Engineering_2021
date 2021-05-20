package commands;

import java.util.ArrayList;

public class RecordManager {
	ArrayList<ICommand> commandsList;
	boolean isActive = false;
	
	RecordManager() { commandsList = new ArrayList<ICommand>(); }
	
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
		if(isActive) commandsList.add(cmd);
	}	
}
