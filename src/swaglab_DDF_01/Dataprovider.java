package swaglab_DDF_01;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider extends BaseClass
{
	int TCID;
	swagLabLoginPage login;
	swagLabHomePage home;
	SwagLabOpneMenuPage menu;
	
	@Test(dataProvider ="data" )
	
	public void logiSwagLab(String UN,String PS) throws IOException
	{
		TCID=105;
		initializeBrowser();
		login.inpswagLabLoginPageUsername(UN);
		login.inpswagLabLoginPagepassword(PS);
		login.clickswagLabLoginPageLoginbutton();
		
		
		boolean logo = home.getSwagLabHomePageLogo();
		Assert.assertTrue(logo,"Fail");
		
		home.clickswagLabHomePageOpenmenu();
		
		menu.clickswagLabMenuPageLogoutbutn();
	}
	
	@DataProvider(name="data")
	public Object[] []log() throws IOException
	{
		Object [] []data= {{Utility_Class.getPropertyFileData("username"),Utility_Class.getPropertyFileData("password")},{Utility_Class.getPropertyFileData("username"),Utility_Class.getPropertyFileData("password")}};
		return data;
		
	
	}
	
	

}
