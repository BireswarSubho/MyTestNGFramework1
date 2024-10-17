package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws InterruptedException, IOException {
		logger=LogManager.getLogger(this.getClass());
		
		FileInputStream fis=new FileInputStream(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(fis);
		
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--incognito");
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver(cp); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		default : System.out.println("Invalid browser"); return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
		Thread.sleep(6000);
		driver.navigate().refresh();
//		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li/following-sibling::li")).click();
//		driver.findElement(By.xpath("//div[@class='demonstration-box']/a/span")).click();
//		
////		driver.switchTo().newWindow((WindowType.TAB));
//		Set<String> handles=driver.getWindowHandles();
//		Iterator<String> it=handles.iterator();
//		String p=it.next();
//		String c=it.next();
//		driver.switchTo().window(c);
////		Thread.sleep(15000);                http://localhost/opencart/upload/install/index.php
	}
	
	@AfterClass(groups= {"Sanity","Master","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomStr() {
		String rnd=RandomStringUtils.randomAlphabetic(5);
		return rnd;
	}
	
	public String randomNum() {
		String rndNum=RandomStringUtils.randomNumeric(10);
				return rndNum;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}


}
