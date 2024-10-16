package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver) throws IOException
	{
		super(driver);
	}
	
	@FindBy(xpath="(//span[@class='d-none d-md-inline'])[3]")
	WebElement myAccountButton;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement registerButton;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginButton;
	
	public void clickMyAccount()
	{
		myAccountButton.click();
	}
	
	public void clickRegister()
	{
		registerButton.click();
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
}
