package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	By signin = By.xpath("//span[text()='Login']");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By nav = By.xpath("//ul[@class='nav navbar-nav navbar-right']");

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

}
