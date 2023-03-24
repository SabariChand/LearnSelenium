package learn_Excel_data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriven {

public static void main(String[] args) throws IOException 
{
	
	//steps
	//Identify TestCaases column by scanning the entire 1st row
	//once column is identidfied then scan entire testcases column to identify purchase test case row
	//after you grab purchase test cases row =pull all the data of the row and fee inot tests
	
	FileInputStream fip = new FileInputStream("C://Users//Sabari Nathan//Documents//Eclipses_Storage//Selenium//LearnSeleniumBasics//Excel_files//DataFile.xlsx");
	
	//xssf class need fileinout stream argument
	//Create object for XSSFWorkbook class

	XSSFWorkbook workbook = new XSSFWorkbook(fip);
	
	//Get Access to sheet, check the number of sheets
	
	int numberOfSheets = workbook.getNumberOfSheets();
	
	for (int i = 0; i < numberOfSheets;i++) 
	{
		if(workbook.getSheetName(i).equalsIgnoreCase("Testdata"))
		{
			XSSFSheet sheet = workbook.getSheetAt(i);
			
			//Identify TestCaases column by scanning the entire 1st row
			//Get access to all rows of sheet

			Iterator<Row> rows = sheet.iterator();
			//Access to specific row form all rows
			
			Row firstrow = rows.next();
			Iterator<Cell> ce = firstrow.cellIterator();
			
			int k=0;
			int column  = 0;
			
			while (ce.hasNext()) {
				
				Cell value = ce.next();
				
				if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
				{
					//deiredcolumn
					column =k;

				}
				k++;
				System.out.print(column);
			}
			
			/*while (ce.hasNext()) {
				Row r = rows.next();
				
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase"))
				{
				
				Iterator<Cell> cv = r.cellIterator();
				
				while (cv.hasNext()) {
					System.out.println(cv.next().getRichStringCellValue());
					
				}
				
				}
			
		}*/
		
	}

}
}
}



