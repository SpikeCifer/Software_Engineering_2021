package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Document;
import model.FakeTTSFacade;
import model.TTSFacade;

class ConfigTransformerTest {

	@Test
	void test() {
		int pitch = 5;
		int volume = 10;
		int rate = 15;
		
		
		ConfigureTransformer test = new ConfigureTransformer(pitch, volume, rate);
		test.execute();
		Document doc = Document.getInstance();
		TTSFacade transformer =  doc.getTransformer();
		assertEquals(pitch, transformer.getPitch());
	}
}
