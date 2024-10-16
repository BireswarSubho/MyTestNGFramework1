package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) throws IOException
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='text-end'] //button")
	WebElement loginButton;
	
	public void typeEmail(String eml)
	{
		email.sendKeys(eml);
	}
	
	public void typePassword(String pwwd)
	{
		password.sendKeys(pwwd);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}

}
