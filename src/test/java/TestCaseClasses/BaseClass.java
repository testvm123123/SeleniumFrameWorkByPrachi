package TestCaseClasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public static Logger logger;
    ReadConfig rc;
    String url;
    String browser;

    @BeforeMethod
    public void setup() {
        rc = new ReadConfig();
        url = rc.getBaseUrl();
        browser = rc.getBrowser();

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
            	  WebDriverManager.firefoxdriver().setup();
            	    FirefoxOptions options = new FirefoxOptions();
            	    options.setBinary("C:\\Path\\To\\firefox.exe");  // Set your actual path here
            	    driver = new FirefoxDriver(options);
            	    break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        logger = LogManager.getLogger("SeleniumProj");
        logger.info("Browser launched successfully");
        driver.get(url);
		logger.info("Opened URL");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            //driver.quit();
            logger.info("Browser closed successfully");
        }
        
      
        }
    public void capturesScreenshots(WebDriver driver, String testname) throws IOException {
    	TakesScreenshot ts=((TakesScreenshot)driver);
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File(System.getProperty("user.dir")+"//screenshots//"+testname+".png");
    	
    	FileUtils.copyFile(src, dest);
    }
}
