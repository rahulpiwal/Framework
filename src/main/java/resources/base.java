package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class base {
	public WebDriver driver=null;
	public Properties prop;
	public WebDriver initilizeDriver() throws IOException
	{
		
	     prop  = new Properties();
		FileInputStream fis=new FileInputStream("C:\\eclipse-work\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.out.println(browserName +"gfhdghh");
		System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver.exe");
		System.out.println("rahul1");
			 ChromeOptions handlingSSL = new ChromeOptions();
			 System.out.println("rahulpiwal2");
			 handlingSSL.setAcceptInsecureCerts(true);
			 System.out.println("rahulpiwa3");
			 driver=new ChromeDriver(handlingSSL);
		System.out.println("rahulpiwal");
		}
		
	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	}
	public String getSceenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
