package com.travelmedicare.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.travelmedicare.qa.bases.TestBase;

public class TestUtils extends TestBase{

	public static String testdata_sheet_path = "C:\\Users\\Bimal\\eclipse-workspace\\TravelMedicare\\src\\main\\java\\com\\travelmedicare"+
	"\\qa\\testdata\\wb11.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(testdata_sheet_path);
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}try {
			book = WorkbookFactory.create(file)	;
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		System.out.println(sheet);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			
			}
		}
		return data;
		
		
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		// TODO Auto-generated method stub
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
