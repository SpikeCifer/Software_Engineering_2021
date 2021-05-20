package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.ConfigureTransformerCommand;
import model.Document;
import model.TTSFacade;

class ConfigTransformerTest {

	@Test
	void test() {
		int pitch = 5;
		int volume = 10;
		int rate = 15;
		
		ConfigureTransformerCommand test = new ConfigureTransformerCommand(pitch, volume, rate);
		test.execute();
		
		TTSFacade transformer =  Document.getInstance().getTransformer();
		assertEquals(pitch, transformer.getPitch());
		assertEquals(volume, transformer.getVolume());
		assertEquals(rate, transformer.getRate());
	}
}
