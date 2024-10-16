package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage_SingleData;
import Utilities.DataProviders;
import Utilities.JavaScriptUtil;

public class Login_DDT extends BaseClass{

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String username,String password,String res) throws IOException, InterruptedException
	{
        logger.info("*** Starting Login_DDT testcase ***");
		
        
        Thread.sleep(8000);
		//Homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		Thread.sleep(3000);
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.typeEmail(username);
		Thread.sleep(3000);
		lp.typePassword(password);
		Thread.sleep(3000);
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage_SingleData macc= new MyAccountPage_SingleData(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		
		
		/*data is valid - login success - test pass- logout
		 *                login failed- test fail
		 */
		
		/*data is invalid - login success - test fail- logout
		 *                login failed- test pass
		 */
		
		
		if(res.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true) {
				JavaScriptUtil.jsUtil();
				macc.logoutButtonClick();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(res.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true) {
				JavaScriptUtil.jsUtil();
				macc.logoutButtonClick();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		
		Assert.assertEquals(targetPage, true);
		Thread.sleep(3000);
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,400)");
		
		JavaScriptUtil.jsUtil();
		macc.logoutButtonClick();
		
		Thread.sleep(5000);
		
		String actual=driver.findElement(By.xpath("//h1[text()='Account Logout']")).getText();
		String expected="Account Logout";
		System.out.println("verified");
		logger.info("*** Finished Login_DDT testcase ***");
	}
}
