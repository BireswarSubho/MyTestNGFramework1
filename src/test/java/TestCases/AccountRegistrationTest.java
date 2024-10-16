package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import Utilities.JavaScriptUtil;

public class AccountRegistrationTest extends BaseClass {

	@Test
	public void verify_Account_registration() throws InterruptedException, IOException
	{
		logger.info("***********Starting this test case******************");
		HomePage hm= new HomePage(driver);
		hm.clickMyAccount();
		logger.info("click on my account link");
		hm.clickRegister();
		logger.info("click on register link");
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		arp.setFirstName(randomStr().toUpperCase());
		arp.setLastName(randomStr().toUpperCase());
		arp.setEmail(randomStr()+"@gmail.com");
		arp.setPassword("ftuyyy");
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,400)");
		
		JavaScriptUtil.jsUtil();
		
		
		Thread.sleep(5000);
		arp.clickPolicyButton();
		arp.clickContinueButton();
		Thread.sleep(8000);
		String actual=arp.getConfirmationmessege();
		String expected="Your Account Has Been Created!";
		Assert.assertEquals(actual, expected);
		
	}
	
	
	
}
