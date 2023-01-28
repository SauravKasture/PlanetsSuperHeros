package swaglab_DDF_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class swagLabLoginPage
{
	@FindBy(xpath="//input[@id='user-name']") private WebElement UN;
	@FindBy(xpath="//input[@id='password']") private WebElement Pass;
	@FindBy(xpath="//input[@id='login-button']") private WebElement login;
	public Object clickswagLabLoginPageLoginbutton;
	
	public swagLabLoginPage(WebDriver o)
	{
	PageFactory.initElements(o, this);
	}
	
	public void inpswagLabLoginPageUsername(String s) 
	{
		UN.sendKeys(s);
		
	}
	
	public void inpswagLabLoginPagepassword(String pas)
	{
		Pass.sendKeys(pas);
	}
	
	public void clickswagLabLoginPageLoginbutton()
	{
		login.click();
	}
	
	

}
