package commands;

import java.util.ArrayList;

public class RecordManager {
	ArrayList<ICommand> commandsList;
	boolean isActive = false;
	
	RecordManager() {
		
	}
	
	public void activate() {
		
	}
	
	public void replay() {
		
	}
	
	public void deactivate() {
		
	}
	
	public void addCommand(ICommand cmd) {
		commandsList.add(cmd);
	}
}
