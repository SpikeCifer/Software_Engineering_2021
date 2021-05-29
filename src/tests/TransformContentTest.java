package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.OpenDocumentCmd;
import commands.TransformContentsCmd;
import model.Document;
import model.FakeTTSFacade;

class TransformContentTest {

	@Test
	void test() {
		new OpenDocumentCmd("res/word/SSample.docx", "None").execute();
		
		FakeTTSFacade fake = new FakeTTSFacade();
		Document doc = Document.getInstance();
		doc.setTransformer(fake);
		
		TransformContentsCmd test = new TransformContentsCmd();
		test.execute();
		assertEquals(doc.getContents(), fake.getPlayedContents());
	}
}
