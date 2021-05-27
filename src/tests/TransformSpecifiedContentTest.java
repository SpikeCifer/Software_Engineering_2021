package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.TransformSpecifiedTextCommand;

import java.util.ArrayList;
import model.Document;
import model.FakeTTSFacade;

class TransformSpecifiedContentTest {
	
	@Test
	void test() {
		FakeTTSFacade fake = new FakeTTSFacade();
		Document doc = Document.getInstance();
		doc.setTransformer(fake);
		
		TransformSpecifiedTextCommand cmd = new TransformSpecifiedTextCommand(1, 3);
		cmd.execute();
		
		ArrayList<String> contents = doc.getContents();
		assertEquals(contents.subList(1, 3), fake.getPlayedContents());
	}
}
