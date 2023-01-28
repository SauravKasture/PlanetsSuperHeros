package swaglab_DDF_01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabOpneMenuPage 
{
	@FindBy (xpath = "//a[text()='Logout']") private WebElement logout;
	
	public  SwagLabOpneMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickswagLabMenuPageLogoutbutn()
	{
		logout.click();
	}

}
