package input;

import java.util.ArrayList;

public class AtBashDecodeStrategy implements IDecodeStrategy {
    public ArrayList<String> decode(ArrayList<String> fileContents) {
    	for (String line: fileContents) {
            String ciphertext = removeUnwantedChars(line.toLowerCase());
            fileContents.set(fileContents.indexOf(line), applyCipher(ciphertext));
    	}
        return fileContents;
    }

    private String removeUnwantedChars(String input) {
        String out = "";
        for(char c : input.toCharArray())
            if(Character.isLetterOrDigit(c))
                out += c;
        return out;
    }
    
    private String applyCipher(String text) {
    	String plaintext = "";
    	for(char c : text.toCharArray()) {
            if(Character.isLetter(c))
                plaintext += (char) ('z' + ('a' - c));
            else
                plaintext += c;
        }
    	return plaintext;
    }
}
