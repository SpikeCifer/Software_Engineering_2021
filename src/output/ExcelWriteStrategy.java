package output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * 
 * @author Stylianos Zappidis AM: 2971
 * The read and write code was found on the following link
 * https://www.java67.com/2014/09/how-to-read-write-xlsx-file-in-java-apache-poi-example.html
 *
 * TODO: Properly Implement the Write Mechanism
 **/
public class ExcelWriteStrategy implements IWriteStrategy {
	// 
	@Override
	public void write(String filename, ArrayList<String> contents) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("New Sheet");
        
        int rowCount = 0;
        int columnCount = -1;
        Row currentRow = sheet.createRow(0);
		
        for (String str : contents) {
			if (isNewRow(str)) {
				currentRow = sheet.createRow(++rowCount);
				columnCount = -1;
			} else {
				Cell cell = currentRow.createCell(++columnCount);
				try {
					cell.setCellValue(Double.parseDouble(str));
				} catch (NumberFormatException e) {
					 cell.setCellValue((String) str);
				}
			}
		}
        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
			System.out.println("Could not save to excel file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not save to excel file");
			e.printStackTrace();
		}
	}
	
	private boolean isNewRow(String cell) {	return cell == "\n"; }
}
