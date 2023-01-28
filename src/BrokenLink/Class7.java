package BrokenLink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class7 
{
	public static void main(String[] args)
	{
		WebDriver m = new ChromeDriver();
		m.get("https://www.youtube.in/");
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> links = m.findElements(By.xpath("//a"));
		System.out.println("Number of link prsent on Web Page:"+ links);
		for(WebElement link:links)
		{
			String URL = link.getAttribute("href");
			url(URL);
		}
	}
	
	
	public static void url(String URL)
	{
		try 
		{
			URL url= new URL(URL);
		HttpURLConnection 	con= (HttpURLConnection)url.openConnection();
		
		con.connect();
		
		if(con.getResponseCode()>=400)
		{
			System.out.println(URL + " --  " + con.getResponseCode()+ "-- " +con.getResponseMessage()+ " link is broken");
		}
		else
		{
			System.out.println(URL + " --  " + con.getResponseCode()+ "-- " +con.getResponseMessage()+ " working link");
		}
		}
		catch (Exception e)
		{
			
		}
	}

}
