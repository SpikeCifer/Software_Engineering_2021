package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import commands.OpenDocumentCommand;
import input.AtBashDecodeStrategy;
import input.ExcelReadStrategy;
import input.Rot13DecodeStrategy;
import input.WordReadStrategy;
import model.Document;

/** 
 * 
 * @author Stylianos Zappidis 2971
 * The created tests work in the following order:
 * 1. Load the contents of the file by using the OpenDocument Command
 * 2. Load with specified methods (along with decoding ones if needed)
 * 3. Compare the contents of the document to the contents of the 
 * specifically loaded file. 
 *
 */
class OpenDocumentTest {
	private static final String PLAIN_WORD_TEST_FILE = "res/word/SSample.docx";
	private static final String ROT13_WORD_TEST_FILE = "res/word/Rot13.docx";
	private static final String ATBASH_WORD_TEST_FILE = "res/word/AtBash.docx";
	
	private static final String PLAIN_EXCEL_TEST_FILE = "res/excel/Sample.xlsx";
	private static final String ROT13_EXCEL_TEST_FILE = "res/excel/Rot13.xlsx";
	private static final String ATBASH_EXCEL_TEST_FILE = "res/excel/AtBash.xlsx";
	
	@Test
	void testWordFile() {
		new OpenDocumentCommand(PLAIN_WORD_TEST_FILE, "None").execute();
		ArrayList<String> expectedContents = new WordReadStrategy().read(PLAIN_WORD_TEST_FILE);
		
		Document doc = Document.getInstance();
		assertEquals(expectedContents, doc.getContents());
	}
	
	@Test
	void testWordRot13EncryptedFile() {
		new OpenDocumentCommand(ROT13_WORD_TEST_FILE, "Rot13").execute();
		ArrayList<String> expectedContents = new WordReadStrategy().read(ROT13_WORD_TEST_FILE);
		expectedContents = new Rot13DecodeStrategy().decode(expectedContents);
		 
		Document doc = Document.getInstance();
		assertEquals(expectedContents, doc.getContents());
	}
	
	@Test
	void testWordAtBashEncryptedFile() {
		new OpenDocumentCommand(ATBASH_WORD_TEST_FILE, "AtBash").execute();
		
		ArrayList<String> expectedContents = new WordReadStrategy().read(ATBASH_WORD_TEST_FILE);
		expectedContents = new AtBashDecodeStrategy().decode(expectedContents);
		Document doc = Document.getInstance();
		assertEquals(expectedContents, doc.getContents());
	}
	
	@Test
	void testExcelFile() {
		ArrayList<String> expectedContents = new ExcelReadStrategy().read(PLAIN_EXCEL_TEST_FILE);
		
		new OpenDocumentCommand(PLAIN_EXCEL_TEST_FILE, "None").execute();
		Document doc = Document.getInstance();
		assertEquals(expectedContents, doc.getContents());
	}
	
	@Test
	void testExcelRot13EncryptedFile() {
		ArrayList<String> expectedContents = new ExcelReadStrategy().read(ROT13_EXCEL_TEST_FILE);
		expectedContents = new Rot13DecodeStrategy().decode(expectedContents);
		 
		new OpenDocumentCommand(ROT13_EXCEL_TEST_FILE, "Rot13").execute();
		Document doc = Document.getInstance();
		assertEquals(expectedContents, doc.getContents());
	}
	
	@Test
	void testExcelAtBashEncryptedFile() {
		ArrayList<String> expectedContents = new ExcelReadStrategy().read(ATBASH_EXCEL_TEST_FILE);
		expectedContents = new AtBashDecodeStrategy().decode(expectedContents);
		
		new OpenDocumentCommand(ATBASH_EXCEL_TEST_FILE, "AtBash").execute();
		Document doc = Document.getInstance();
		assertEquals(expectedContents, doc.getContents()); 
	}
}
