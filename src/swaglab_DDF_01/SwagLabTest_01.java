package swaglab_DDF_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabTest_01 
{
	 public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	 {
		FileInputStream file= new FileInputStream("F:\\Excel\\Book1.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet5");
		 System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		 WebDriver m= new ChromeDriver();
		 m.manage().window().maximize();
		 m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 m.get("https://www.saucedemo.com/");
		 
		 swagLabLoginPage login= new swagLabLoginPage(m);
		 String user = sh.getRow(0).getCell(0).getStringCellValue();
		 login.inpswagLabLoginPageUsername(user);
		 login.inpswagLabLoginPagepassword(sh.getRow(0).getCell(1).getStringCellValue());
		 login.clickswagLabLoginPageLoginbutton();
		 Thread.sleep(2000);
		
		 swagLabHomePage home= new swagLabHomePage(m);
		 home.clickswagLabHomePageAddtocart();
		 home.verifySwagLabHomePageRemove(sh.getRow(2).getCell(0).getStringCellValue());
		 Thread.sleep(2000);
		 home.clickswagLabHomePageOpenmenu();
		 Thread.sleep(2000);
		
		 SwagLabOpneMenuPage menu= new SwagLabOpneMenuPage(m);
		 menu.clickswagLabMenuPageLogoutbutn();
		 
		 Thread.sleep(2000);
		 
		 m.close();
		
		 
		 
		 
		
	 }
	 

}
