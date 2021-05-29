package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.TransformSpecifiedTextCmd;

import java.util.ArrayList;
import model.Document;
import model.FakeTTSFacade;

class TransformSpecifiedContentTest {
	
	@Test
	void test() {
		FakeTTSFacade fake = new FakeTTSFacade();
		Document doc = Document.getInstance();
		doc.setTransformer(fake);
		
		// Add some contents to the document
		ArrayList<String> contents = doc.getContents();
		for (int i = 0; i < 10; i++)
			contents.add("New line number " + i);
		doc.edit(contents);
		
		// Execute Transformation for specific lines
		TransformSpecifiedTextCmd cmd = new TransformSpecifiedTextCmd(1, 3);
		cmd.execute();
		
		contents = doc.getContents();
		assertEquals(contents.subList(1, 3), fake.getPlayedContents());
	}
}
