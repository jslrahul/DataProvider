package dataprovider.DataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Login {
	Object [][] obj;
	Row row;
	Cell cell;
	int rowArray=0, cellArray;
	
	@Test(dataProvider = "loginData")
	public void login(String userName, String password) {
		
		System.out.println("User name is: "+ userName);
		System.out.println("Password is: "+ password);
	}
	
	@DataProvider(name="loginData")
	public Object [][] getUserCredentials() throws Exception{


		File file = new File ("D:\\MobileAutomation\\DataProvider\\src\\test\\resources\\LoginUser.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook  wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Login");

		int lastRowNum = sheet.getLastRowNum();
		Row row = sheet.getRow(0);
		int lastCellNum = row.getLastCellNum();				
		obj = new String [lastRowNum][lastCellNum];

		System.out.println("size added to the two dimentional array");

		for(int i=0; i<lastRowNum; i++, rowArray++ ) {
			row = sheet.getRow(i+1);
			cellArray=0;
			for(int j=0; j<lastCellNum; j++) {
				cell = row.getCell(j);
				obj [i][j] =  cell.getStringCellValue();
				System.out.println(obj[rowArray][cellArray]);
				cellArray++;
			}
		}
		return obj;
	}

}
