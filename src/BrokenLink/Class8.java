package BrokenLink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class8
{
	public static void main(String[] args)
	{
		// Initialize the webdriver
		WebDriver driver = new ChromeDriver();

		List<String> brokenLinks = new ArrayList<String>();

		// Navigate to the website
		driver.get("https://www.amazon.in/");

		// Get all the links on the page
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Iterate through each link
		for (WebElement link : links) {
		    // Get the href attribute of the link
		    String url = link.getAttribute("href");

		    // Send a request to the link
		    try {
		        HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
		        connection.setRequestMethod("HEAD");
		        connection.connect();

		        // Get the response code
		        int responseCode = connection.getResponseCode();

		        // If the response code is 404, add the link to the list of broken links
		        if (responseCode == 404) {
		            brokenLinks.add(url);
		        }
		    } catch (Exception e) {
		        // Print the exception if there is any
		        e.printStackTrace();
		    }
		}

		// Print the list of broken links
		System.out.println("Broken Links: " + brokenLinks);
		
	}

}
