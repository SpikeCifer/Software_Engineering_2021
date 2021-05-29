package input;

import java.util.ArrayList;

public class AtBashDecodeStrategy implements IDecodeStrategy {

    public ArrayList<String> decode(ArrayList<String> fileContents) {
    	for (String line: fileContents)
            fileContents.set(fileContents.indexOf(line), decodeString(line));
        return fileContents;
    }
    
    private String decodeString(String plaintext) {
    	String ciphertext = "";
    	for (char ch : plaintext.toCharArray()) {
    		if (ch >= 'A' && ch <= 'Z' )
        		ch = (char) ('Z' + ('A' - ch));
        	else if (ch >= 'a' && ch <= 'z')
        		ch = (char) ('z' + ('a' - ch));
    		ciphertext += ch;
    	}
    	return ciphertext;
    }
}
