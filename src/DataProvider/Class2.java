package DataProvider;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Class2 
{
	
	@Test(dataProvider = "m2")
	public void m1(String un, String pass)
	{
		WebDriver m= new ChromeDriver();
		m.get("https://www.saucedemo.com/");
		
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		m.findElement(By.xpath("//input[@id='user-name']")).sendKeys(un);
		m.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
		m.findElement(By.xpath("//input[@id='login-button']")).click();
		m.close();
		
	}
	
	
	@DataProvider //if we dont give name to data provider then only we can use method name as name to data provider.
	public Object[][] m2() throws IOException
	{
	Object [] []a = {{Utility.me("user1"),Utility.me("password")},
			{Utility.me("user2"),Utility.me("password")},
			{Utility.me("user3"),Utility.me("password")}};
	
		return a;
	}
	
	@DataProvider (name="data")
	public Object[][] datap()
	{
		Object [][] inp= {
				{"standard_user","secret_sauce"},
				{"problem_user","secret_sauce"},
				{"performance_glitch_user","secret_sauce"}};
		
		return inp;
	}

}
