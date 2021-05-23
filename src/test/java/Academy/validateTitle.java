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

public class validateTitle extends base {
	public WebDriver driver;
	LandingPage land;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initilizeDriver();
		log.info("Driver is initilize");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepae");
	}

	@Test()
	public void basePageNavigation() throws IOException {
		land = new LandingPage(driver);
		String title = land.getTitle().getText();
		Assert.assertEquals(title, "FEAfgdfgdfgTURED COURSES");
		log.info("Succefully passed assert condition");
		System.out.println(title);

	}

	@Test()
	public void validateHeader() {
		String header = land.getHeader().getText();
		Assert.assertEquals(header,
				"Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("Succefully passed assert condition");
		System.out.println(header);
	}

	@AfterTest
	public void browserClose() {
		driver.close();
	}

}
