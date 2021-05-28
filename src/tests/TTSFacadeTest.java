package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TTSFacade;

class TTSFacadeTest {

	@Test
	void test() {
		TTSFacade test = new TTSFacade();
		test.setPitch(100);
		test.setRate(100);
		test.setVolume(200);
		test.play("hello");
	}

}
