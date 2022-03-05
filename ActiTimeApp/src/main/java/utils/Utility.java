package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static String getDataFromExcel(String sheet, int row, int col) throws EncryptedDocumentException, IOException {
		String path= "E:\\Software Testing data\\Java\\UserDetails.xlsx";
		FileInputStream file= new FileInputStream(path);
		String data= WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(col).getStringCellValue();
		System.out.println(data);
		
		return data;
		
	}
	public static void getScreenShot(WebDriver driver, int testID) throws IOException {
		//To Fetch system date
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy,HH_mm_ss");  
		Date date = new Date();  
		System.out.println(formatter.format(date)); 
		
		//Take the screenshot1				    
	    File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desc= new File("E:\\Software Testing data\\Java\\Screenshots\\"+"Test="+testID+" "+formatter.format(date)+".jpg");
		FileHandler.copy(src, desc);
	}

}
