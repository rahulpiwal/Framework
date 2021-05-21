package Academy;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
//import pageObjects.LoginPage;
import resources.base;



public class validateNavigation extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver=initilizeDriver();
		 log.info("Driver is initilize");
		  driver.get(prop.getProperty("url"));
		  log.info("Navigated to homepae");
	}
	

	
  @Test()
  public void basePageNavigation() throws IOException {
	  
	  LandingPage land=new LandingPage(driver);
	  System.out.println(land.getNavigation().isDisplayed());
Assert.assertTrue(land.getNavigation().isDisplayed());
log.info("Succefully passed assert condition");
	 

}
  @AfterTest
  public void browserClose()
  {
  	driver.close();
  }

}

