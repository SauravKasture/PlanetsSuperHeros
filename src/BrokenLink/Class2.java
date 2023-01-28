package BrokenLink;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class2 
{
	public static void main(String[] args) throws IOException, InterruptedException 
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
				System.out.println(url+ " - is broken");
			}
			else if(rscode>=300 & rscode<=399)
			{
				System.out.println(url+ " - redirected ");
			}
			else if(rscode>=200 & rscode<=299)
			{
				System.out.println(url+ " - Ok");
			}
//			else
//			{
//				System.out.println(url+ " - not Broken");
//			}
			
		}
		
		driver.close();
		
		
		
	}

}
