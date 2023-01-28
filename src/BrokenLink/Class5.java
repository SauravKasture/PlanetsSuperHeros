package BrokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.dataloader.Try;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class5 
{
	public static void main(String[] args) throws MalformedURLException,IOException
	{
		WebDriver m= new ChromeDriver();
		m.get("https://www.techjockey.com/");
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> allli = m.findElements(By.tagName("a"));
		
		System.out.println(allli.size());
		
		try {
		for(WebElement link:allli)
		{
			String url = link.getAttribute("href");
			
			URL l= new URL(url);
			
			HttpURLConnection conn= (HttpURLConnection) l.openConnection();
			conn.connect();
			 
			int rsc = conn.getResponseCode();
			
			if(rsc>=400)
			{
				System.out.println(url+ " - broken");
			}
			else
			{
				System.out.println(url+ " working fine");
			}
			
		}}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
	}

}
