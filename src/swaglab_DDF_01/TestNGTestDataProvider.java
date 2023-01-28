package swaglab_DDF_01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGTestDataProvider 
{
	
	
	
	@DataProvider(name="data")
	public Object[][] log()
	{
		Object [] []data= {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"}};
		return data;
		
	}
	
	
	int a;// declare globally 
	

	WebDriver m;
	swagLabLoginPage login; // datatype objectname
	swagLabHomePage home;
	SwagLabOpneMenuPage menu;
	
	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, IOException
	{

		 m= new ChromeDriver();
		 m.manage().window().maximize();
		 m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 m.get("https://www.saucedemo.com/");
		 
		 login= new swagLabLoginPage(m);
		 home= new swagLabHomePage(m);
		 menu= new SwagLabOpneMenuPage(m);
		 a=15;
		 
	}
	
	@Test(dataProvider = "data")
	public void verifylogo(String un,String pas) throws InterruptedException
	{
		login.inpswagLabLoginPageUsername(un);
		login.inpswagLabLoginPagepassword(pas);
		login.clickswagLabLoginPageLoginbutton();
		Thread.sleep(2000);
		boolean actResult = home.getSwagLabHomePageLogo();
		Assert.assertTrue(actResult,"failed: get false test case is failed ");
		home.clickswagLabHomePageOpenmenu();
		menu.clickswagLabMenuPageLogoutbutn();
		Thread.sleep(2000);
		
	}
	
	
	
	@AfterClass
	public void closeBrowser()
	{
		m.close();
	}
	
}
