package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	private By signin = By.xpath("//span[text()='Login']");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By nav = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By header = By.xpath(
			"//p[contains(text(),'Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..')]");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage login = new LoginPage(driver);
		return login;
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavigation() {
		return driver.findElement(nav);
	}

	public WebElement getHeader() {
		return driver.findElement(header);
	}

}
