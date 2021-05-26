package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.OpenDocumentCommand;
import commands.SaveDocumentCommand;
import input.AtBashDecodeStrategy;
import input.ExcelReadStrategy;
import input.Rot13DecodeStrategy;
import input.WordReadStrategy;
import model.Document;

/**
 * 	
 * @author Stylianos Zappidis 2971
 * The created tests work in the following order:
 * 1. Load the file using the openDocument Command
 * 2. Write to the new file using the SaveDocument Command
 * 3. Compare the output to the contents stored in memory.
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
		assertEquals(Document.getInstance().getContents(), 
				wordInput.read(OUTPUT_WORD_FILE));
	}
	
	@Test
	void testWriteRot13EncryptedToWord() {
		new OpenDocumentCommand(SMALL_WORD_TEST_FILE, "None").execute();
		new SaveDocumentCommand(OUTPUT_WORD_FILE, "Rot13").execute();
		assertEquals(Document.getInstance().getContents(), 
				wordInput.read(OUTPUT_WORD_FILE));
	}
	
	@Test
	void testWriteAtBashEncryptedToWord() {
		new OpenDocumentCommand(SMALL_WORD_TEST_FILE, "None").execute();
		new SaveDocumentCommand(OUTPUT_WORD_FILE, "AtBash").execute();
		assertEquals(Document.getInstance().getContents(), 
				atBashDecoder.decode(wordInput.read(OUTPUT_WORD_FILE)));
	}
	
	@Test
	void testWriteToExcel() {
		new OpenDocumentCommand(EXCEL_TEST_FILE, "None").execute();
		new SaveDocumentCommand(OUTPUT_EXCEL_FILE, "None").execute();		
		assertEquals(Document.getInstance().getContents(), 
				excelInput.read(OUTPUT_EXCEL_FILE));
	}
	
	@Test
	void testWriteRot13EncryptedToExcel() {
		new OpenDocumentCommand(EXCEL_TEST_FILE, "None").execute();
		new SaveDocumentCommand(EXCEL_TEST_FILE, "Rot13").execute();		
		assertEquals(Document.getInstance().getContents(), 
				rotDecoder.decode(excelInput.read(OUTPUT_WORD_FILE)));
	}
	
	@Test
	void testWriteAtBashEncryptedToExcel() {
		new OpenDocumentCommand(EXCEL_TEST_FILE, "None").execute();
		new SaveDocumentCommand(EXCEL_TEST_FILE, "AtBash").execute();
		assertEquals(Document.getInstance().getContents(), 
				atBashDecoder.decode(excelInput.read(OUTPUT_WORD_FILE)));
	}
}
