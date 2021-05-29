package input;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelReadStrategy implements IReadStrategy {

	@Override
	public ArrayList<String> read(String filename) {
		ArrayList<String> fileContents = new ArrayList<String>();
		try (XSSFWorkbook myWorkBook = createWorkBook(filename)) {
			XSSFSheet mySheet = myWorkBook.getSheetAt(0); // Get iterator to all the rows in current sheet 
			Iterator<Row> rowIterator = mySheet.iterator(); // Traversing over each row of XLSX file 
			while (rowIterator.hasNext()) { 
				Row row = rowIterator.next(); // For each row, iterate through each columns 
				Iterator<Cell> cellIterator = row.cellIterator(); 
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next(); 
					switch (cell.getCellType()) { 
						case STRING:
							fileContents.add(cell.getStringCellValue() + "\t"); 
							break; 
						case NUMERIC: 
							fileContents.add(cell.getNumericCellValue() + "\t"); 
							break; 
						case BOOLEAN: 
							fileContents.add(cell.getBooleanCellValue() + "\t"); 
							break; 
						default : 
					} 
				} 
				fileContents.add("\n"); 
			}
		} catch (IOException e) {
			System.out.println("Could not load Excel File");
			e.printStackTrace();
		}
		return fileContents;
	}
	
	private  XSSFWorkbook createWorkBook(String filename) throws IOException {
		File myFile = new File(filename); 
		FileInputStream fis = new FileInputStream(myFile); // Finds the workbook instance for XLSX file 
		return new XSSFWorkbook (fis); // Return first sheet from the XLSX workbook 
	}
}
   
  
