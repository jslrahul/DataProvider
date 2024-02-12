package dataprovider.DataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel{

static String [][] obj;
static Row row;
static Cell cell;

	public static void main(String[] args) throws Exception {
		

			
			File file = new File ("D:\\MobileAutomation\\DataProvider\\src\\test\\resources\\LoginUser.xlsx");
			FileInputStream fis = new FileInputStream(file);
			Workbook  wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("Login");
			
			int lastRowNum = sheet.getLastRowNum();
			System.out.println("total rows "+lastRowNum);
			Row row = sheet.getRow(0);
			int lastCellNum = row.getLastCellNum();
			System.out.println("total cell "+lastCellNum);
						
			obj = new String [lastRowNum][lastCellNum];
			
			System.out.println("size added to the two dimentional array");
			
			for(int i=1; i<=lastRowNum; i++) {
				row = sheet.getRow(i);
			
			 for(int j=0; j<lastCellNum; j++) {
				 cell = row.getCell(j);
				String value =  cell.getStringCellValue();
				 System.out.println(value);
			 }
			}
			

	}

}
