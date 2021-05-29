package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import commands.ConfigureTransformerCmd;
import model.Document;
import model.TTSFacade;

public class ConfigTransformerTest {
	private final int PITCH = 15;
	private final int VOLUME = 10;
	private final int RATE = 15;

	@Test
	public void test() {
		new ConfigureTransformerCmd(PITCH, VOLUME, RATE).execute();
		
		TTSFacade transformer =  Document.getInstance().getTransformer();
		assertEquals(PITCH, transformer.getPitch());
		assertEquals(VOLUME, transformer.getVolume());
		assertEquals(RATE, transformer.getRate());
	}

}
