package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import commands.TransformContentsCommand;
import model.Document;
import model.FakeTTSFacade;

class TransformContentTest {

	@Test
	void test() {
		FakeTTSFacade fake = new FakeTTSFacade();
		Document doc = Document.getInstance();
		doc.setTransformer(fake);
		
		TransformContentsCommand test = new TransformContentsCommand();
		test.execute();
		assertEquals(doc.getContents(), fake.getPlayedContents());
	}
}
