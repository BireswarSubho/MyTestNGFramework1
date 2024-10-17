package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage_SingleData;
import Utilities.JavaScriptUtil;

public class LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_Login() throws IOException, InterruptedException {
		logger.info("*** Starting Login test ***");
		
		//Homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		Thread.sleep(3000);
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.typeEmail(p.getProperty("email"));
		Thread.sleep(3000);
		lp.typePassword(p.getProperty("password"));
		Thread.sleep(3000);
		lp.clickLogin();
		Thread.sleep(5000);		//MyAccountPage
		MyAccountPage_SingleData macc= new MyAccountPage_SingleData(driver);
		boolean targetPage=macc.isMyAccountPageExists();
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
		logger.info("*** Finishing Login test ***");
	}

}
