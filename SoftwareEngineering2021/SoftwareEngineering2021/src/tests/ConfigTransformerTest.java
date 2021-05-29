package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.ConfigureTransformerCmd;
import model.Document;
import model.TTSFacade;

class ConfigTransformerTest {
	private final float PITCH = 15;
	private final float VOLUME = 10;
	private final float RATE = 15;

	@Test
	public void test() {
		new ConfigureTransformerCmd(PITCH, VOLUME, RATE).execute();
		
		TTSFacade transformer =  Document.getInstance().getTransformer();
		assertEquals(PITCH, transformer.getPitch());
		assertEquals(VOLUME, transformer.getVolume());
		assertEquals(RATE, transformer.getRate());
	}
}
