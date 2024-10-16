package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage_SingleData extends BasePage {
	
	public MyAccountPage_SingleData(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="(//a[@class='list-group-item'])[13]")
	WebElement logOut;
	
	public boolean isMyAccountPageExists()
	{
		try {
			return(msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	
	public void logoutButtonClick()
	{
		logOut.click();
	}

}
