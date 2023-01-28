package DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Class1
{
	@Test(dataProvider ="data" )
	public void login(String s,String s1)
	{
		WebDriver m= new ChromeDriver();
		m.get("https://www.saucedemo.com/");
		
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		m.findElement(By.xpath("//input[@id='user-name']")).sendKeys(s);
		m.findElement(By.xpath("//input[@id='password']")).sendKeys(s1);
		m.findElement(By.xpath("//input[@id='login-button']")).click();
		m.close();
		
	}

	
	@DataProvider(name="data")
	public Object[] []log()
	{
		Object [] []data= {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"}};
		return data;
		
	}
}
