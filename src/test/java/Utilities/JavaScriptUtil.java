package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import PageObjects.BasePage;
import TestCases.BaseClass;

public class JavaScriptUtil extends BaseClass{
	
	
	public static void jsUtil() {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
	}

}
