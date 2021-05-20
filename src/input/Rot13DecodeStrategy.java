package input;

import java.util.ArrayList;

public class Rot13DecodeStrategy implements IDecodeStrategy {
	
	@Override
	public ArrayList<String> decode(ArrayList<String> fileContents) {
		for (String line : fileContents)
			fileContents.set(fileContents.indexOf(line), decodeLine(line));
		return fileContents;
	}
	
	private String decodeLine(String line) {
		String newLine = "";
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c >= 'a' && c <= 'm') c += 13;
			else if (c >= 'A' && c <= 'M') c += 13;
			else if (c >= 'n' && c <= 'z') c -= 13;
			else if (c >= 'N' && c <= 'Z') c -= 13;
			newLine += c;
		}
		return newLine;
	}
}
