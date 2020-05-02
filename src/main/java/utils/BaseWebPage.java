package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseWebPage {

	public Properties prop; 
	public static WebDriver driver;
	public static String pathName1 = System.getProperty("user.dir") + PropertyKeys.globalProperties;
	public static String BasePath = System.getProperty("user.dir");
	private static final Logger log = LogManager.getLogger(BaseWebPage.class);
	
	


	public WebDriver initialWebDriver() throws IOException {
		
		prop= new Properties();
		FileInputStream fis = new FileInputStream(pathName1);
		prop.load(fis);
		
		//if (prop.getProperty("browser").equals("chrome"))
		if (System.getProperty("browser").equals("chrome"))
		{

			System.setProperty("webdriver.chrome.driver",
					BasePath +"//resources//drivers//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("headless");
			driver = new ChromeDriver(options);
			log.debug("Chrome Driver initiated");

		} else if (prop.getProperty("browser").equals("ie")) {

			System.setProperty("webdriver.ie.driver", "D:\\Selenium\\BrowserDrivers\\ChromeDriver\\chromedriver.exe");

			driver = new InternetExplorerDriver();
			log.debug("IE Driver initiated");

		} else {

			log.debug("NO Browser initiated");
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
		//driver.navigate().to(prop.getProperty("url"));
		

	}
	
	
public void getScreenshot(String result) throws IOException {
		
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("D:\\Selenium\\screenshot\\"+result+"Screenshot.png"));
	//FileUtils.copyFile(src, new File("C:\\Users\\Gagana T\\TestScreenShot"+result+"screenshot.png"));	
	}

}
