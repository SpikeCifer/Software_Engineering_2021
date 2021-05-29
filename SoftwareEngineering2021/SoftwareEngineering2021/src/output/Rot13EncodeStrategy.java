package output;

import java.util.ArrayList;

public class Rot13EncodeStrategy implements IEncodeStrategy {
	
	/* Rot13 is a special encryption algorithm, as decoding
	 * and encoding are done using the exact same algorithm
	 */

	@Override
	public ArrayList<String> encode(ArrayList<String> fileContents) {
		for (String line : fileContents)
			fileContents.set(fileContents.indexOf(line), encodeLine(line));
		return fileContents;
	}
	
	private String encodeLine(String line) {
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
