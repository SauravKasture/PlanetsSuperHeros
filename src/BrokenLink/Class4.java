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

public class Class4
{
	public static void main(String[] args)  throws IOException, InterruptedException
	{
		WebDriver m= new ChromeDriver();
		m.get("https://www.postman.com/");
		
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		List<WebElement> links = m.findElements(By.xpath("//a"));
		System.out.println(links.size());
		
		
		for(WebElement link:links)
		{
			String url = link.getAttribute("href");
			
			URL URL= new URL(url);
			
			HttpURLConnection con= (HttpURLConnection) URL.openConnection();
			
			con.connect();
			Thread.sleep(200);
			
			int Rscode = con.getResponseCode();
			
			if(Rscode>400)
			{
				System.out.println(url + " - is broken ");
			}
			else
			{
				System.out.println(url + " - URL is not borken");
			}
			
			
		}
		m.close();
		
	}

}
