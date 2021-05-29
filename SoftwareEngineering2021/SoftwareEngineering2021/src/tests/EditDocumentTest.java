package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import commands.EditDocumentCmd;
import model.Document;

/**
 * 
 * @author Stylianos Zappidis
 * The current functionality is just about 
 * adding new lines the document's contents.
 * 
 * After the execution of the command we check if
 * the contents of the document have been updated.
 *
 */
class EditDocumentTest {

	@Test
	void testAddingNewLines() {
		ArrayList<String> newContents = Document.getInstance().getContents();
		String newLine = "This is a new line";
		newContents.add(newLine);
		
		new EditDocumentCmd(newContents).execute();
		
		assertTrue(Document.getInstance().getContents().contains(newLine));
	}
}
