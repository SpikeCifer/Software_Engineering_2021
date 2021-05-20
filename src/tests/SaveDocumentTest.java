package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.OpenDocumentCommand;
import commands.SaveDocumentCommand;
import input.AtBashDecodeStrategy;
import input.ExcelReadStrategy;
import input.Rot13DecodeStrategy;
import input.WordReadStrategy;

/**
 * 	
 * @author Stylianos Zappidis 2971
 * The created tests work in the following order:
 * 1. Load the file using the openDocument Command
 * 2. Write to the new file using the SaveDocument Command
 * 3. Compare the original file to the generated file. (Decode file if needed)
 * 
 **/
class SaveDocumentTest {
	private static final String SMALL_WORD_TEST_FILE = "res/word/SSample.docx";
	// private static final String LARGE_WORD_TEST_FILE = "res/word/LSample.docx"; // If you want to test a bigger file
	private static final String OUTPUT_WORD_FILE = "res/GeneratedWordFile.docx";
	
	private static final String EXCEL_TEST_FILE = "res/excel/Sample.xlsx";
	private static final String OUTPUT_EXCEL_FILE = "res/GeneratedExcelFile.xlsx";
	
	private static WordReadStrategy wordInput =  new WordReadStrategy();
	private static ExcelReadStrategy excelInput = new ExcelReadStrategy();
	private static Rot13DecodeStrategy rotDecoder = new Rot13DecodeStrategy();
	private static AtBashDecodeStrategy atBashDecoder = new AtBashDecodeStrategy();
	
	@Test
	void testWriteToWord() {
		new OpenDocumentCommand(SMALL_WORD_TEST_FILE, "None").execute();
		new SaveDocumentCommand(OUTPUT_WORD_FILE, "None").execute();
		assertEquals(wordInput.read(SMALL_WORD_TEST_FILE), wordInput.read(OUTPUT_WORD_FILE));
	}
	
	@Test
	void testWriteRot13EncryptedToWord() {
		new OpenDocumentCommand(SMALL_WORD_TEST_FILE, "None").execute();
		new SaveDocumentCommand(OUTPUT_WORD_FILE, "Rot13").execute();
		assertEquals(wordInput.read(SMALL_WORD_TEST_FILE), 
				rotDecoder.decode(wordInput.read(OUTPUT_WORD_FILE)));
	}
	
	@Test
	/* TODO: Fix The At Bash Algorithm not working properly.
	 * This is an implementation error, rather than an error in our
	 * system, as the Rot13 test passes.
	 */
	void testWriteAtBashEncryptedToWord() {
		fail();
		new OpenDocumentCommand(SMALL_WORD_TEST_FILE, "None").execute();
		new SaveDocumentCommand(OUTPUT_WORD_FILE, "AtBash").execute();
		assertEquals(wordInput.read(SMALL_WORD_TEST_FILE), 
				atBashDecoder.decode(wordInput.read(OUTPUT_WORD_FILE)));
	}
	
	@Test
	void testWriteToExcel() {
		new OpenDocumentCommand(EXCEL_TEST_FILE, "None").execute();
		new SaveDocumentCommand(OUTPUT_EXCEL_FILE, "None").execute();
		fail("There is an undefined bug that throws an XMLException");
		assertEquals(wordInput.read(EXCEL_TEST_FILE), 
				excelInput.read(OUTPUT_EXCEL_FILE));
	}
	
	@Test
	void testWriteRot13EncryptedToExcel() {
		new OpenDocumentCommand(EXCEL_TEST_FILE, "None").execute();
		new SaveDocumentCommand(EXCEL_TEST_FILE, "Rot13").execute();
		fail("The same problem as defined in testWriteToExcel");
		assertEquals(excelInput.read(SMALL_WORD_TEST_FILE), 
				rotDecoder.decode(excelInput.read(OUTPUT_WORD_FILE)));
	}
	
	@Test
	void testWriteAtBashEncryptedToExcel() {
		new OpenDocumentCommand(EXCEL_TEST_FILE, "None").execute();
		new SaveDocumentCommand(EXCEL_TEST_FILE, "AtBash").execute();
		fail("The same problem as defined in testWriteToExcel");
	}
}
