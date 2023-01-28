package swaglab_DDF_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility_Class 
{
	//this method is used to get test data from excel sheet 
	// need to pass two inputs: 1. rowIndex, 2.cellIndex
	//@Author name: Saurav
	public static String getData(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
	{
		 FileInputStream file= new FileInputStream("F:\\Excel\\Book1.xlsx");
		 Sheet sh = WorkbookFactory.create(file).getSheet("Sheet5");
		 String data = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		 return  data;
	}
	
	
	//this method will capture screenshot of WebPage
	// need two input : 1. WebDriver object, TCID
	//Author name: Saurav
	public static void captureScreenShoot(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dec= new File("F:\\ScreenShotsel\\TCID"+TCID+".jpg");
		FileHandler.copy(src, dec);
	}
	
	
	public static String getPropertyFileData(String key) throws IOException
	{
		FileInputStream file= new FileInputStream("D:\\eclipse\\PropertyFile\\SwagLab.properties");
		Properties p= new Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;
	}
	

	

}
