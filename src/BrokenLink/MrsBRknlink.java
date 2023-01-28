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
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class MrsBRknlink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		//System.setProperty("webdriver.chrome.driver", "E:\\Soft\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		//implicit wait
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    SoftAssert sa=new SoftAssert();
	    List<WebElement> links = driver.findElements(By.xpath("//div/table[@class='gf-t']//li/a"));
	    for(WebElement link:links)
	    {
		    String url = link.getAttribute("href");
		    HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
		    conn.setRequestMethod("HEAD");
		    conn.connect();
		    int resCode=conn.getResponseCode();
		    System.out.println(resCode);
		    sa.assertTrue(resCode<400, "The text with this "+link.getText()+" is broken with code "+resCode);
	    }
	    sa.assertAll();
	    
	  
	    
	}

}
