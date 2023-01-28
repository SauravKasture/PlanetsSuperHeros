package BrokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Class1 
{
	
	public static void main(String[] args)  throws IOException, InterruptedException
	{
		WebDriver m= new ChromeDriver();
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		m.get("https://demo.guru99.com/test/newtours/");
		List<WebElement> links = m.findElements(By.xpath("//a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++)
		{
		
			WebElement elemente = links.get(i);
			//by using herf attribute we can get URL of required link
			String url = elemente.getAttribute("href");
			URL l= new URL(url);
			//create connect using url object link
			HttpURLConnection con= (HttpURLConnection) l.openConnection();
			Thread.sleep(2000);
			//Establish connection 
					con.connect();
			int responsecode = con.getResponseCode();// if this return response above than
			//400 Then that means link is broken link.
			if(responsecode>400 )
			{
				System.out.println(url + " - URL is broken  ");
			}
			
			//else
			//{
//				System.out.println(url+ " - URL is not Broken ");
			//}
		}
	}

}
