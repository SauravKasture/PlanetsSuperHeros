package BrokenLink;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Class3
{
	@Test
	public void Brokenlink() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> Links = driver.findElements(By.xpath("//a"));
		
		System.out.println(Links.size());
		
		for(WebElement link: Links)
		{
			String url = link.getAttribute("href");
			URL li= new URL(url);
			
			HttpsURLConnection con=(HttpsURLConnection) li.openConnection();
			
		
			con.connect();
			
			int rscode = con.getResponseCode();
			if(rscode>400)
			{
				Reporter.log(url+"- Broken link page not found",true);
				Assert.assertEquals(rscode, rscode>400);
			}
			else if(rscode>=300 & rscode<=399)
			{
				Reporter.log(url+" -Recdriected  ",true);
			}
			else if(rscode>=200 & rscode<=299)
			{
			
				Reporter.log(url+ " - Ok",true);
			}

			
		}
		
		driver.close();
	}

}
