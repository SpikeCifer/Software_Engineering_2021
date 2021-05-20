package output;

import java.util.ArrayList;

public interface IWriteStrategy {
	public void write(String filename, ArrayList<String> contents);
}
