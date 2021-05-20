package commands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Document;
import model.FakeTTSFacade;

class transformTest {

	@Test
	void test() {
		FakeTTSFacade fake = new FakeTTSFacade();
		Document doc = Document.getInstance();
		doc.setTransformer(fake);
		Transform test = new Transform(doc);
		test.execute();
		ArrayList <String> list = fake.getPlayedcontents();
		for(String str:list)
		{
			System.out.println(str);
		}
	}
}
