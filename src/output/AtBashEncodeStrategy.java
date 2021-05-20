package output;

import java.util.ArrayList;

public class AtBashEncodeStrategy implements IEncodeStrategy {

	@Override
	public ArrayList<String> encode(ArrayList<String> docContents) {
		for (String plaintext: docContents)
			docContents.set(docContents.indexOf(plaintext), encodeLine(plaintext));
		return docContents;
	}
	
	public String encodeLine(String plaintext) {
        String ciphertext = "";
        plaintext = removeUnwantedChars(plaintext.toLowerCase());
        for(char c : plaintext.toCharArray()) {
            if(Character.isLetter(c))
                ciphertext += (char) ('a' + ('z' - c));
            else
                ciphertext += c;
        }
        return getSubStrings(ciphertext).trim();
    }
	
	private String getSubStrings(String input) {
        String out = "";
        for(int i = 0; i < input.length(); i += 5) {
            if(i + 5 <= input.length())
                out += (input.substring(i, i + 5) + " ");
            else
                out += (input.substring(i) + " ");
        }
        return out;
    }

    private String removeUnwantedChars(String input) {
        String out = "";
        for(char c : input.toCharArray())
            if(Character.isLetterOrDigit(c))
                out += c;
        return out;
    }
}
