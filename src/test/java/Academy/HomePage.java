package Academy;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
//import resources.base;

public class HomePage extends base
{
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
	

	
  @Test(dataProvider="getData")
  public void basePageNavigation(String email,String password) throws IOException {
	 
	  LandingPage land=new LandingPage(driver);
	  LoginPage login=land.getLogin();
	  login.email().sendKeys(email);
	  login.password().sendKeys(password);
	  login.click().click();
	  log.info("Data Recivied");
  }
  @DataProvider
  public Object[][] getData()
  {
	  Object[][] data=new Object[1][2];
	  data[0][0]="abc@gmail.com";
	  data[0][1]="123456";
	
	  return data;
	  
  }
  @AfterTest
  public void browserClose()
  {
  	driver.close();
  }
 
}
