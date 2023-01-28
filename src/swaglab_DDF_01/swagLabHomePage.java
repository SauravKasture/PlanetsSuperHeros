package swaglab_DDF_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class swagLabHomePage
{
	@FindBy(xpath ="//div[@class='app_logo']") private WebElement logo;
	@FindBy(xpath="//button[text()='Open Menu']")private WebElement menu;
	@FindBy(xpath="(//button[text()='Add to cart'])[1]")private WebElement add2cart;
	@FindBy(xpath="(//button[text()='Remove'])[1]") private WebElement remove;
	
	public swagLabHomePage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	
	public boolean getSwagLabHomePageLogo()
	{
		boolean result = logo.isDisplayed();
		return result;
	}
	
//	public void verifyswagLabHomePageLogo() 
//	{
//		boolean sd = logo.isDisplayed();
//		if(sd==true)
//		{
//			System.out.println("logo is present");
//		}
//		else
//		{
//			System.out.println("logo is not present");
//		}
//		
//	}
	
	
	public void clickswagLabHomePageOpenmenu()
	{
		menu.click();
		
	}
	
	public void clickswagLabHomePageAddtocart()
	{
		add2cart.click();
	}
	
	public void verifySwagLabHomePageRemove(String exptTxt)
	{
		String actTxt=remove.getText();
		if(exptTxt.equals(actTxt))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
			
		}
	}
}
