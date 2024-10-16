package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='form-check form-switch form-switch-lg form-check-reverse form-check-inline']/input")    
	WebElement policyButton;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement continueButton;
	
	@FindBy(xpath="//div[@id='content'] /h1")
	WebElement confirmMessege;
	
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);	
	}
	
	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickPolicyButton()
	{
		policyButton.click();
	}
	
	public void clickContinueButton()
	{
		continueButton.click();
	}
	
	public String getConfirmationmessege()
	{
		try {
			return (confirmMessege.getText());
		} catch (Exception e) {
	
			return (e.getMessage());
		}
	}
	
}
