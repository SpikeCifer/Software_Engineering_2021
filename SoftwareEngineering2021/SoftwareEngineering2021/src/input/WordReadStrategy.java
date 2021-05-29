package input;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class WordReadStrategy implements IReadStrategy {

	@Override
	public ArrayList<String> read(String filename) {
		ArrayList<String> contents = new ArrayList<String>();
		try {
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            XWPFDocument document = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document.getParagraphs();
            
            for (XWPFParagraph para : paragraphs)
            	contents.add(para.getText()+"\n");
            
            fis.close();
            document.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return contents;
    }
}
