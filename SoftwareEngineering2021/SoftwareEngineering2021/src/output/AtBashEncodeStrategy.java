package output;

import java.util.ArrayList;

public class AtBashEncodeStrategy implements IEncodeStrategy {

	@Override
	public ArrayList<String> encode(ArrayList<String> docContents) {
		ArrayList<String> cipheredContents = new ArrayList<String>();
		for (String plaintext: docContents)
			cipheredContents.add(encodeLine(plaintext));
		return cipheredContents;
	}
    
    private String encodeLine(String plaintext) {
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
