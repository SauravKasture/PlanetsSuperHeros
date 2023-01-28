package BrokenLink;

import java.net.HttpURLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class6 
{
	public static void main(String[] args) 
	{
		WebDriver m = new ChromeDriver();
		m.get("https://www.youtube.com/");
		
		
		List<WebElement> links = m.findElements(By.xpath("//a"));
		
		System.out.println("no of links :" +links.size());
		
		for(WebElement k:links)
		{
			String URL = k.getAttribute("href");
			
			URL(URL);
		}
		
	}
	
	
	
	public static void URL(String URL)
	{
		try
		{
	java.net.URL k= new java.net.URL(URL);
				HttpURLConnection http = (HttpURLConnection)k.openConnection();
				//http.setConnectTimeout(5000);
				http.connect();
				
				if(http.getResponseCode()>=400)
				{
					System.out.println(URL + "-->" + http.getResponseMessage()+ " --> "+ http.getResponseCode()+ " is broken");
				}
				else
				{
					System.out.println(URL + "-->" + http.getResponseMessage()+ " --> "+ http.getResponseCode()+ " is not broken");
				}
		}
		
		catch (Exception e)
		{
			
		}
	}

}
