package output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordWriteStrategy implements IWriteStrategy {

	@Override
	public void write(String fileName, ArrayList<String> contents) {
		try (XWPFDocument doc = new XWPFDocument()){
			try (FileOutputStream out = new FileOutputStream(fileName)) {
				for (String line : contents) { 
					XWPFParagraph paragraph = doc.createParagraph();
					XWPFRun run = paragraph.createRun();
					run.setText(line);
				}
                doc.write(out);
            }
			
		} catch (IOException e) {
			System.out.println("Could not create XWPFDocument instance");
			e.printStackTrace();
		}
	}

}
